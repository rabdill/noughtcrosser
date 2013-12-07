package noughtcrosser

class SquareController {

	def index() {		
		def gridArray= new Character[9]							//Initializes the array of states being sent to the view	
		def gameNum = params.long('gameNum')					//	Retrieves the game number
		def curSquare											//	The variable for the square currently being looked at inside the loop
		def squareNumber = 0									//	The variable for the gridArray[] element that will receive the curSquare's state
		def movesMade = 0										//	Tracks how many moves have been made to figure out whose turn it is
		for (def r = 0; r < 3; r++) {							//	Goes through each row
			for (def c = 0; c < 3; c++) {						//	Goes through each column in a row before it moves down
				curSquare = Square.findWhere(ro: r, colum: c, game:Game.findWhere(id: gameNum))	//	Grabs an array of the current square's information
				if(!curSquare) gridArray[squareNumber] = " "	//If the square isn't in the database, print it blank
				else {
					movesMade++
					gridArray[squareNumber] = curSquare.state }		//	Grabs the state (X,O, or null) of the current square
				squareNumber++									//	Moves on to the next gridArray[] element
				}
		}
		
		
		def win = 0												//	keeps track of if the game has been won
		def winner = 0											//	state (X or O) of the winner
		def testId		
		def fullSquares = 0										//	the ID of the square being tested
		
		//	Check for a TIE (just checks if all squares are filled in)
		for (def u = 0; u < 9; u++) {												
			if(gridArray[u] != " ") fullSquares++
		}
		if(fullSquares == 9) win = 2							// a 2 means a tie in the view
		
		//Check for three in a row across:
		for (def t = 0; t < 3; t++) {							//	iterates through the first square of each row
			testId = 0 + (3 * t)								//	by adding three each go-around
			if(gridArray[testId] != " "
				&& gridArray[testId] == gridArray[testId + 1]	//	look at the one next to the tested square
				&& gridArray[testId] == gridArray[testId + 2]) {//	aaand the one next to that one
					win = 1										//	flips the "winner" flag
					winner = gridArray[testId]					//	sets the winning letter
					}
		}
		
		//Check for three in a row up and down:
		for (def t = 0; t < 3; t++) {
			testId = t
			if(gridArray[testId] != " "
				&& gridArray[testId] == gridArray[testId + 3]
				&& gridArray[testId] == gridArray[testId + 6]) {
					win = 1
					winner = gridArray[testId]
					}
		}
		
		//Check for three in a row diagonally:
			testId = 0											// starts in the top-left corner
			if(gridArray[testId] != " "
				&& gridArray[testId] == gridArray[testId + 4]
				&& gridArray[testId] == gridArray[testId + 8]) {
					win = 1
					winner = gridArray[testId]
					}

			testId = 2											//	starts in the top right
			if(gridArray[testId] != " "
				&& gridArray[testId] == gridArray[testId + 2]
				&& gridArray[testId] == gridArray[testId + 4]) {
					win = 1
					winner = gridArray[testId]
					}
				def curMove
				if(movesMade % 2 == 0) curMove = new String("X")	//	X and O alternate every turn
				else curMove = new String("O")
				
		def curGame = Game.findWhere(id:gameNum)
		def winId
		if(win == 1)	{
			if(winner == "X") winId = curGame.x.id
			else winId = curGame.o.id
		}
				
		return [gridArray : gridArray, win:win, winner:winner, curMove:curMove, gameNum:gameNum, winId:winId, curGame:curGame]
		}
		
	
	
	def makeMove() {
		def state = new String(params.state)					//	X or O
		def squareSelect = new Integer(params.squareSelect)		//	the square being modified (0 through 8, reading left to right)
		def gameNum = params.long('gameNum')					//the game ID
		
		def colum = new Integer((squareSelect) % 3)			//	figuring out what column the square is in (0 through 2)
		def ro = new Integer(0)
		
		if(squareSelect < 3) ro = 0								//	what row (0 through 2 as well)
		else if(squareSelect < 6) ro = 1
		else ro = 2
		def newSquare = new Square(state:state, ro:ro, colum:colum, game:Game.findWhere(id: gameNum)).save(failOnError: true)
		
		return [gameNum:gameNum]
		
		
	}
	
	
	def clearGrid() {
		def gameNum = params.long('gameNum')
		def squares = Square.findAll("from Square as s where s.game=?", [Game.findWhere(id: gameNum)])
		Square.executeUpdate("delete Square s where s.game = :clearGame", [clearGame:Game.findWhere(id: gameNum)])
		return [gameNum:gameNum]
	}

	
	
	
	
}
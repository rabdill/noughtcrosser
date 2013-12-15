package com.noughtcrosser.web

import com.noughtcrosser.Game
import com.noughtcrosser.Square
import com.noughtcrosser.User

class SquareController {

    def gamesService

	def index( Long id ) {
		def gridArray= new Character[9]							//Initializes the array of states being sent to the view	
		def curSquare											//	The variable for the square currently being looked at inside the loop
		def squareNumber = 0									//	The variable for the gridArray[] element that will receive the curSquare's state
		def movesMade = 0										//	Tracks how many moves have been made to figure out whose turn it is

        def game = Game.get( id )
        def symbols = [
            x: game.x,
            o: game.o
        ]



		for (def r = 0; r < 3; r++) {							//	Goes through each row
			for (def c = 0; c < 3; c++) {						//	Goes through each column in a row before it moves down
				curSquare = Square.findWhere(row: r, column: c, game:Game.findWhere(id: id))	//	Grabs an array of the current square's information
				if(!curSquare) gridArray[squareNumber] = " "	//If the square isn't in the database, print it blank
				else {
					movesMade++
					gridArray[ squareNumber ] = ( squareNumber % 2 == 0 ? 'X' : 'O' )
                        //curSquare.state   //	Grabs the state (X,O, or null) of the current square
                }
				squareNumber++									//	Moves on to the next gridArray[] element
				}
		}
		
		
		def win = 0												//	keeps track of if the game has been won
		def winner = 0											//	state (X or O) of the winner
		def testId		
		def fullSquares = 0										//	the ID of the square being tested
		def winId
		def loseId
		def curGame = Game.get( id )
		
		//	Check for a TIE (just checks if all squares are filled in)
		for (def u = 0; u < 9; u++) {												
			if(gridArray[u] != " ") fullSquares++
		}
		if(fullSquares == 9) {win = 2							// a 2 means a tie in the view
							winId = curGame.x.id
							loseId = curGame.o.id
							}
		
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

		if(win == 1)	{
			if(winner == "X") {winId = curGame.x.id
								loseId = curGame.o.id}
			else {winId = curGame.o.id
					loseId = curGame.x.id}
		}
				
		return [gridArray : gridArray, win:win, winner:winner, curMove:curMove, gameId:id, winId:winId, loseId:loseId, curGame:curGame]
		}
		
	
	
	def makeMove( Long gameId ) {
		def squareSelect = params.squareSelect as Integer // the square being modified (0 through 8, reading left to right)

        def game = Game.get( gameId )

        log.error( "GAME: ${game}")

        def currentPlayer = gamesService.determineNextPlayer( game ) as User

		def column = new Integer((squareSelect) % 3)			//	figuring out what column the square is in (0 through 2)

		def row
		if ( squareSelect < 3 )
            row = 0								//	what row (0 through 2 as well)
		else if ( squareSelect < 6 )
            row = 1
		else
            row = 2

		new Square(
                player: currentPlayer,
                row:    row,
                column: column,
                game:   game ).save( failOnError: true )
		
		redirect( controller: 'square', action: 'index', id: game.id )
	}
	
	
	def clearGrid( Long gameId ) {
        gamesService.clearBoard( gameId )
		redirect( controller: 'square', action: 'index', id: gameId )
	}

	
	
	
	
}
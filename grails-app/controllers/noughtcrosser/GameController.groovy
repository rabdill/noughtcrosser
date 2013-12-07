package noughtcrosser

class GameController {
	
	def index()	{
		def allUsers = User.list()
		return [allUsers:allUsers]	//	Populates the list of current players for the "Create game" screen
		}
	
	def createGame() {
		def x
		def o
		//	Creates an entry in the Game table with the current players:
		if(params.goesFirst == 1)	{
			x = session.user
			o = User.findWhere(login:params.challenged)
		}
		
		else {
				o = session.user
				x = User.findWhere(login:params.challenged)
			}
		def curGame = new Game(x:x, o:o).save(failOnError:true)
		
		return [gameNum:curGame.id]
	}
	
}
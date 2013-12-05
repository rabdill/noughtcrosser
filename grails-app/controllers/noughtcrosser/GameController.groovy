package noughtcrosser

class GameController {
	
	def index()	{
		def allUsers = User.list()
		return [allUsers:allUsers]	//	Populates the list of current players for the "Create game" screen
		}
	
	def createGame() {
		//	Creates an entry in the Game table with the current players:
		def curGame = new Game(challenger:User.findWhere(userName: params.challenger), opponent:User.findWhere(userName: params.opponent)).save(failOnError:true)
		
		return [gameNum:curGame.id]
	}
	
}
package noughtcrosser

class HomeController {

    def index() { 
		def userList = User.list()
		return [userList:userList]	//	Populates list of players for the main page
	}
}

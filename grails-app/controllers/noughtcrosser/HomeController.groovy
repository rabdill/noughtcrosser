package noughtcrosser

class HomeController {

    def index() { 
		def userList = User.list()
		def user = session.user;
		return [userList:userList, user:user]	//	Populates list of players for the main page
	}
}

package noughtcrosser

class UserController {
	def index()	//	displays all the users
		{
			def allUsers = User.list()
			return [allUsers:allUsers]
		}
	
	def profile() {
		def curUser = User.findWhere(userName: params.uname)
		return [curUser:curUser]
		}

	
}

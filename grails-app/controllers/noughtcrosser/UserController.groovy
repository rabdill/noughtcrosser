package noughtcrosser

class UserController {
	def index()	//	displays all the users
		{
			def allUsers = User.list()
			return [allUsers:allUsers]
		}
	
	def profile() {
		def curUser = User.findWhere(login: params.login)
		return [curUser:curUser]
		}
	
	def createForm() {
		
	}
	
	def create()	{
		def created = new User(first: params.first, last: params.last, login:params.login, password:params.password, wins: "0", losses: "0", ties: "0").save(failOnError:true)
	}
	
	def login = {
	}
	
	def authenticate = {
		def user = User.findByLoginAndPassword(params.login, params.password)
		def success = 0
		if(user){
		  session.user = user
		  success = 1
		  }
		return [success:success]
		
	  }
	
	
}

package com.noughtcrosser.web

import com.noughtcrosser.User

class UserController {

    def springSecurityService

	def index()	//	displays all the users
		{
			def allUsers = User.list()
			return [allUsers:allUsers]
		}
	
	def profile() {
		def curUser = User.findWhere(username: params.login)
		return [curUser:curUser]
		}
	
	def createForm() {
		
	}
	
	def create()	{
		def created = new User( params['user'] as Map ).save(failOnError:true)
	}
	
	def login = {
	}
	
	def authenticate = {
		def user = User.findWhere(login:params.login, password:params.password)
		def success = 0
		if(user != null){
		  session.user = user
		  success = 1
		  }
		return [user:params.login, pass:params.password, success:success]
		
	  }
	
	
}

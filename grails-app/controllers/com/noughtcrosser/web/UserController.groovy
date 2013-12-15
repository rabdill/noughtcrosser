package com.noughtcrosser.web

import com.noughtcrosser.User

class UserController {

    def springSecurityService

	def index()	//	displays all the users
		{
			def allUsers = User.list()
			return [allUsers:allUsers]
		}
	
	def profile( Long id ) {
		def currUser = User.get( id as Long )

        if ( currUser != null ) {
		    return [ curUser:currUser ]
        } else {
            redirect( controller: "home", action: "index" )
        }
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

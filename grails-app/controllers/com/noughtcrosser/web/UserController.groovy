package com.noughtcrosser.web

import com.noughtcrosser.User

class UserController {

    def springSecurityService

	def index() {
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
	
	def 'new'() {
		
	}
	
	def create()	{
		def created = new User( params['user'] as Map ).save(failOnError:true)

        flash.info = "New user has been created"

        redirect( controller: "home", action: "index" )
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

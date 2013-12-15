package com.noughtcrosser.web

import com.noughtcrosser.User

class HomeController {

    def gamesService
    def springSecurityService

    def index() {
        def model = [:]

        model.userList    = User.list()
        model.gameList    = gamesService.gamesForUser( springSecurityService.currentUser as User )
        model.currentUser = session.user

		return model
	}
}

package com.noughtcrosser.web

import com.noughtcrosser.User

class HomeController {

    def index() {
        def model = [:]

        model.userList    = User.list()
        model.currentUser = session.user

		return model
	}
}

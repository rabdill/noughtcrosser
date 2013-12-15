package com.noughtcrosser

class GamesService {

    def springSecurityService

    def gamesForUser( User user ) {
        Game.findAll("from Game g where g.o = :user or g.x = :user", [ user: user ] )
    }
}

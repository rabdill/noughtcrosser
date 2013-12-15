package com.noughtcrosser.web

import com.noughtcrosser.Game
import com.noughtcrosser.Square
import com.noughtcrosser.User
import grails.converters.JSON

class SquareController {

    def gamesService

	def index( Long id ) {
        def model = [:]

        model.game       = Game.get( id )
        model.nextPlayer = gamesService.determineNextPlayer( model.game as Game )
        model.state      = gamesService.determineGameState( model.game as Game )

        return model
    }

    def play() {
        def column = params.column as Integer
        def row    = params.row as Integer
        def game   = Game.get( params.game as Long )

        def response = [:]

        try {
            gamesService.executePlay( game, column, row )

            def nextPlayer = gamesService.determineNextPlayer( game )
            response.nextPlayer = nextPlayer.fullName
            response.nextSymbol = (game.x == nextPlayer) ? 'X' : 'O'
            response.symbol     = (game.x == nextPlayer) ? 'O' : 'X'
            response.gameState  = gamesService.determineGameState( game )
        } catch ( e ) {
            response.error = e.getMessage()
        }

        render response as JSON

    }

	def clearGrid( Long gameId ) {
        gamesService.clearBoard( gameId )
		redirect( controller: 'square', action: 'index', id: gameId )
	}

	
	
	
	
}
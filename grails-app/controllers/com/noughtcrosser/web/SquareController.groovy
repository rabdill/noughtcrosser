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
		
	
	
	def makeMove( Long gameId ) {
		def squareSelect = params.squareSelect as Integer // the square being modified (0 through 8, reading left to right)

        def game = Game.get( gameId )

        log.error( "GAME: ${game}")

        def currentPlayer = gamesService.determineNextPlayer( game ) as User

		def column = new Integer((squareSelect) % 3)			//	figuring out what column the square is in (0 through 2)

		def row
		if ( squareSelect < 3 )
            row = 0								//	what row (0 through 2 as well)
		else if ( squareSelect < 6 )
            row = 1
		else
            row = 2

		new Square(
                player: currentPlayer,
                row:    row,
                column: column,
                game:   game ).save( failOnError: true )
		
		redirect( controller: 'square', action: 'index', id: game.id )
	}
	
	
	def clearGrid( Long gameId ) {
        gamesService.clearBoard( gameId )
		redirect( controller: 'square', action: 'index', id: gameId )
	}

	
	
	
	
}
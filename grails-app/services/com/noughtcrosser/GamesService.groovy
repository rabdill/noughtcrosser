package com.noughtcrosser

class GamesService {

    def springSecurityService

    def gamesForUser( User user ) {
        Game.findAll("from Game g where g.o = :user or g.x = :user", [ user: user ] )
    }

    /**
     * Here is how we will determine the next player: we figure out how many moves have been made,
     * if the number of moves is zero or even, the first player is up, otherwise the second player
     * is up.
     *
     * @param game
     */
    def determineNextPlayer( Game game ) {
        def nextPlayer

        if ( game.squares.size() % 2 == 0 ) {
            nextPlayer = game.x
        } else {
            nextPlayer = game.o
        }

        return nextPlayer
    }

    def clearBoard( Long gameId ) {
        Square.executeUpdate( "DELETE Square s WHERE s.game.id = :gameId", [gameId:gameId] )
    }

    def executePlay( Game game, Integer column, Integer row ) {
        def nextPlayer = determineNextPlayer( game )

        def existing = game.squares.find { it.column == column && it.row == row }

        if ( existing ) {
            throw new RuntimeException("This square is already taken, please choose a different square")
        }

        def newSquare = new Square( row: row, column: column, game: game, player: nextPlayer as User )
        game.squares << newSquare

        newSquare.save( flush: true, failOnError: true )

        return newSquare
    }

}

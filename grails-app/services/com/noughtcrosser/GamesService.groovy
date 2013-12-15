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

    /**
     * Executes a play for the next player in queue. This method will throw an exception if
     * the move is not valid (i.e. the space is already occupied).
     *
     * @param game
     * @param column
     * @param row
     * @return
     */
    def executePlay( Game game, Integer column, Integer row ) {

        if ( determineGameState( game ).state != 'Open' ) {
            throw new RuntimeException("The game has ended, you cannot make another play")
        }

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

    /**
     * Determines the state of the game. There are three possible states for any given game:
     * - Open: Game is still being played;
     * - Draw: The game ended in a draw;
     * - Win: The game has been won by one of the two players; the winning played is returned in the hash.
     *
     * @param game
     */
    def determineGameState( Game game ) {
        def board = game.board
        def winner = null
        def gameState = null

        //- Check all horizontal and vertical rows
        for ( int index = 0 ; index < 3 && winner == null ; index++ ) {
            if ( board[index][0] != null && board[index][0] == board[index][1] && board[index][1] == board[index][2] ) {
                winner = board[index][0]
            } else if ( board[0][index] != null && board[0][index] == board[1][index] && board[1][index] == board[2][index] ) {
                winner = board[0][index]
            }
        }

        //- If no winner has been determined, check the two diagonals
        if ( winner == null ) {
            if ( board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2] ) {
                winner = board[0][0]
            } else if ( board[0][2] != null && board[0][2] == board[1][2] && board[1][2] == board[2][0] ) {
                winner = board[0][2]
            }
        }

        if ( winner != null ) {
            gameState = 'Win'
        } else if ( game.squares.size() == 9 ) { //- Check if there are any possible plays left
            gameState = 'Draw'
        } else {
            gameState = 'Open'
        }

        log.error gameState
        log.error winner

        return [ state: gameState, winner: winner?.fullName ]
    }

}

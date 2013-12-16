package com.noughtcrosser

class Game {

    Date dateCreated

	static belongsTo = [owner: User]
	static hasOne = [x: User, o: User, winner: User]
	static hasMany = [squares: Square]
    
	static constraints = {
	    winner nullable:true
	}

    /**
     * Generates a multi dimensional array representing the game
     *
     * @return
     */
    def getBoard() {
        //- Organize the squares in a manner that can be easily accessed
        def board = [ [null,null,null], [null,null,null], [null,null,null] ]
        this.squares.each { Square square ->
            board[ square.row ][ square.column ] = square.player
        }
        return board
    }
}

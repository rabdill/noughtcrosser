package com.noughtcrosser

class Square {
	Integer row
	Integer column
    User player

	static belongsTo =	[game: Game]

    static mapping = {
        column column: '`column`'
    }

	static constraints = {
        row    blank: false
        column blank: false
        player nullable: true
    }
}

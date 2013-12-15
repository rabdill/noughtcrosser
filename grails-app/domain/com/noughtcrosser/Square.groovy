package com.noughtcrosser

class Square {
	Integer ro
	Integer colum
	Character state
	
	static belongsTo =	[game: Game]

	static constraints = {
    ro blank: false
	colum blank: false
	state nullable: true
		}
}

package com.noughtcrosser

class Game {
	static belongsTo = [owner: User]
	static hasOne = [x: User, o: User, winner: User]
	static hasMany = [squares: Square]
    
	static constraints = {
	winner nullable:true
	}
}

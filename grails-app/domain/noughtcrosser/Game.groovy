package noughtcrosser

class Game {
	static belongsTo = [x: User]
	static hasOne = [x: User, o: User, winner: User]
	static hasMany = [squares: Square]
    
	static constraints = {
	winner nullable:true
	}
}

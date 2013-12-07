package noughtcrosser

class Game {
	Integer winner
	
	static belongsTo = [x: User]
	static hasOne = [x: User, o: User]
	static hasMany = [squares: Square]
    
	static constraints = {
		winner nullable: true
	}
}

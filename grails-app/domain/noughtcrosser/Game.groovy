package noughtcrosser

class Game {
	Integer winner
	
	static belongsTo = [challenger: User]
	static hasOne = [challenger: User, opponent: User]
	static hasMany = [squares: Square]
    
	static constraints = {
		winner nullable: true
	}
}

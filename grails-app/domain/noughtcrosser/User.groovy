package noughtcrosser

class User {
	String login
	String password
	String first
	String last
	Integer wins
	Integer losses
	Integer ties
	
	String toString() {
		return first + " " + last
		}
 
	static mappedBy = [challengeGames:"x", opponentGames:"o"]
	static hasMany = [challengeGames: Game, opponentGames: Game]
	
    static constraints = {
		first blank: false
		last blank: false
		login blank: false, unique: true
		password blank: false, password: true
		wins nullable: true
		losses nullable: true
		ties nullable: true
    }
}

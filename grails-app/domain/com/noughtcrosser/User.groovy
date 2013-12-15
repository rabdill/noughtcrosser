package com.noughtcrosser

class User {

    transient springSecurityService

    String username
    String password

    String firstName
    String lastName

	Integer wins   = 0
	Integer losses = 0
	Integer ties   = 0

    /* Spring Security Fields */
    boolean enabled         = true
    boolean accountExpired  = false
    boolean accountLocked   = false
    boolean passwordExpired = false
	
	static mappedBy = [challengeGames:"x", opponentGames:"o", wonGames:"winner"]
	static hasMany = [challengeGames: Game, opponentGames: Game, wonGames: Game]
	
    static constraints = {
        username blank: false, unique: true
        password blank: false

		firstName blank: false
		lastName blank: false
		wins nullable: true
		losses nullable: true
		ties nullable: true
    }

    static mapping = {
        password column: '`password`'
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }

    String getFullName() {
        return firstName + " " + lastName
    }


}

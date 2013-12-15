package com.noughtcrosser.web

import com.noughtcrosser.Game
import com.noughtcrosser.User

class GameController {

    def springSecurityService
	
	def index()	{
		return [
            allUsers: User.list()
        ]
    }
	
	def createGame() {
        def game = new Game( owner: springSecurityService.currentUser as User )
        if ( params.goFirst == "1" ) {
            game.x = springSecurityService.currentUser as User
            game.o = User.findByUsername( params.challenged as String )
        } else {
            game.o = springSecurityService.currentUser as User
            game.x = User.findByUsername( params.challenged as String )
        }

        if ( game.save( flush: true ) ) {
            redirect(controller: 'square', action: 'index', id: game.id )
        } else {
            redirect(controller: 'home', action: 'index')
        }
	}
	
	
	def record()	{
		if(params.int('win') == 1){			//	recording the winner of the game
		def curGame = Game.findById(params.gameNum)
		def winUserId = User.findWhere(id:params.long('winId'))
		curGame.winner = winUserId
		curGame.save()
		
		//	add the win
		def winUser = User.findById(params.long('winId'))
		winUser.wins = winUser.wins + 1
		winUser.save()
		
		def loseUser = User.findWhere(id:params.long('loseId'))
		loseUser.losses = loseUser.losses + 1
		loseUser.save(flush:true)
		}
		
		else {				//	recording a tie
			def winUser = User.findById(params.long('winId'))
			winUser.ties = winUser.ties + 1
			winUser.save()
			
			def loseUser = User.findWhere(id:params.long('loseId'))
			loseUser.ties = loseUser.ties + 1
			loseUser.save(flush:true)
		}
	}
	
}
package com.noughtcrosser.web

import com.noughtcrosser.Game
import com.noughtcrosser.Square

class GameBoardTagLib {

    static namespace = "game"

    def drawBoard = { attrs, body ->
        Game game = attrs.game

        //- Organize the squares in a manner that can be easily accessed
        def board = [ [null,null,null], [null,null,null], [null,null,null] ]
        game.squares.each { Square square ->
            board[ square.row ][ square.column ] = square.player
        }

        //log.error board

        out << "<table id='gameBoard'>\n"
        out << "<tr>\n"

        for ( int index = 0 ; index < 9 ; index ++ ) {
            //- deal with the line breaks
            if ( index > 0 && index % 3 == 0 ) {
                out << "</tr>\n<tr>\n"
            }

            out << "<td>"

            def row    = ( index / 3 ) as Integer
            def column = index % 3
            def player = board[row][column]

            //log.error " ${row}, ${column} - ${player}"

            if ( player == null ) {
                out << "&nbsp;"
            } else {
                out << ( game.x == player ? 'X' : 'O' )
            }

            out << "</td>\n"
        }

        out << "</tr>"
        out << "</table>"
    }


}

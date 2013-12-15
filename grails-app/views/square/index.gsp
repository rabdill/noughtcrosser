<!DOCTYPE html>
<html>
    <head>
        <title>Noughtcrosser: Tic Tac Toe</title>
        <meta name="layout" content="main" />

        <g:javascript>
            var board = $("table#gameBoard");
            board.click(function( event ) {
                var element = $(event.target),
                        col     = element.prevAll().size() ,
                        row     = element.parent("tr").prevAll().size();

                $.ajax({
                    url: '${g.createLink(controller: 'square', action: 'play')}',
                    method: 'post',
                    data: {
                        column: col,
                        row: row,
                        game: ${game.id}
                    },
                    success: function( data, textStatus, jqXHR ) {
                        if ( data.error == null ) {
                            var index_tr = row + 1,
                                index_td = col + 1;
                            board.find("tr:nth-child(" + (index_tr) + ") > td:nth-child(" + (index_td) + ")").text( data.symbol );
                            $("span#gameNextPlayer").text( data.nextPlayer );
                            $("span#gameWinner").text( data.gameState.winner == null ? "" : data.gameState.winner );

                            console.log( data.gameState )
                        }
                    }
                });
            });
        </g:javascript>
    </head>

    <body>

        <section id="widgets">
            Next Move: <span id="gameNextPlayer">${nextPlayer}</span><br />
            Game Number: ${game.id}<br />
            Winner: <span id="gameWinner">${winner}</span><br />

            <br /><br />
            <g:link controller="game" action="new">New Game</g:link><br />
            <g:link controller="square" action="clearGrid" params="${[gameId: game.id]}">Clear Board</g:link>
        </section>

        <section id="main">
            <game:drawBoard game="${game}" />
        </section>

	</body>
</html>
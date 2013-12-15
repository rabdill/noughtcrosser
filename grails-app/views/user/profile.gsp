<!DOCTYPE html>
<html>
    <head>
        <title>Noughtcrosser: Tic Tac Toe</title>
        <meta name="layout" content="main" />
    </head>

    <body>

        <div class="container">
            <h2>${curUser.firstName } ${curUser.lastName }</h2>
            <div class="record">
                Wins: ${curUser.wins ?: 0}<br>
                Losses: ${curUser.losses ?: 0}<br>
                Ties: ${curUser.ties ?: 0}<br>
    		</div>
		</div>
	</body>
</html>
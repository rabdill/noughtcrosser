<!DOCTYPE html>
<html>
    <head>
        <title>Noughtcrosser: Tic Tac Toe</title>
        <meta name="layout" content="main" />
    </head>

    <body>
        <div class="container">
            <g:if test="${success == 1}">
                <h2>Login successful!</h2>
                <a href="<g:createLink controller="game" />">Play now!</a>
            </g:if>
            <g:else>
                <h2>Login rejected, sorry.</h2>
                <a href="<g:createLink controller="home" />">Go back home</a>
            </g:else>
        </div>
    </body>
</html>
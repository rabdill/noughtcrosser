<!DOCTYPE html>
<html>
    <head>
        <title>Noughtcrosser: Tic Tac Toe</title>
        <meta name="layout" content="main" />
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-5 col-xs-offset-1" style="margin-top:10px;" >
                    <a class="btn-primary btn-lg" href="<g:createLink controller="Game" />">PLAY</a><br>
                </div>
            </div>


            <section>
                <h1>Game List</h1>
                <ul id="gameList">
                    <g:each in="${gameList}">
                        <li><g:link controller="square" action="index" id="${it.id}">${it.x.fullName} vs. ${it.o.fullName}</g:link></li>
                    </g:each>
                </ul>

                <h1>Players</h1>
                <ul id="userList">
                    <g:each in="${userList}">
                        <li><g:link controller="user" action="profile" id="${it.id}">${it.fullName}</g:link></li>
                    </g:each>
                </ul>
            </section>
        </div>
    </body>
</html>

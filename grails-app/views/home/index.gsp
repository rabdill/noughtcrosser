<!DOCTYPE html>
<html>
    <head>
        <title>Noughtcrosser: Tic Tac Toe</title>
        <meta name="layout" content="main" />
    </head>

    <body>
        <section id="widgets">
            <sec:ifLoggedIn>
                <h1>Game List</h1>
                <ul id="gameList">
                    <g:each in="${gameList}">
                        <li><g:link controller="square" action="index" id="${it.id}">${it.x.fullName} vs. ${it.o.fullName}</g:link></li>
                    </g:each>
                </ul>
            </sec:ifLoggedIn>

            <h1>
                Current Players
                <g:link controller="game" action="createGame">new game</g:link>
            </h1>
            <ul id="userList">
                <g:each in="${userList}">
                    <li><g:link controller="user" action="profile" id="${it.id}">${it.fullName}</g:link></li>
                </g:each>
            </ul>
        </section>

        <section id="stream">

        </section>
    </body>
</html>

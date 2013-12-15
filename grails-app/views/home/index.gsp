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


                <div class="userbox col-lg-3 col-md-3 col-sm-3 col-xs-5">
                    <h3>Players</h3>
                    <p style="margin-top: -10px;"><i><a href="<g:createLink controller="user" action="createForm" />">Create an account</a></i></p>
                    <ul>
                        <g:each in="${userList}">
                            <li><a href="<g:createLink controller="user" action="profile"/>?login=${it.username}">${it.firstName} ${it.lastName}</a></li>
                        </g:each>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>

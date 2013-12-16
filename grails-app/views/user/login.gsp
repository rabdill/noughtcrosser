<!DOCTYPE html>
<html>
    <head>
        <title>Noughtcrosser: Tic Tac Toe</title>
        <meta name="layout" content="main" />
    </head>

    <body>

        <div class="container">
            <g:form name="userForm" url="[action:'authenticate',controller:'user']">
                <p><label for="login">Login:</label><g:textField name="login" /></p>
                <p><label for="password">Password:</label><g:passwordField name="password" /></p>
                <g:submitButton name="Log in" value="Log in" />
            </g:form>
        </div>

    </body>
</html>
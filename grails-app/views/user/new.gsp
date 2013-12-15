<!DOCTYPE html>
<html>
<head>
    <title>Noughtcrosser: Tic Tac Toe</title>
    <meta name="layout" content="main" />
</head>

    <body>
        <div class="container">
            <g:form name="userForm" url="[action:'create',controller:'user']">
                <p><label for="user.firstName">First name:</label><g:textField     name="user.firstName" /></p>
                <p><label for="user.lastName">Last name:</label>  <g:textField     name="user.lastName" /></p>
                <p><label for="user.username">User name:</label>  <g:textField     name="user.username" /></p>
                <p><label for="user.password">Password:</label>   <g:passwordField name="user.password" /></p>
                <g:submitButton name="create" value="Create" />
            </g:form>
        </div>

    </body>
</html>
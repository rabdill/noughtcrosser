<!DOCTYPE html>
<html>
    <head>
        <title>Noughtcrosser: Tic Tac Toe</title>
        <meta name="layout" content="main" />
    </head>

    <body>

        <div class="container">
            <h2>Create a new game</h2>
            <g:form name="newGame" url="[action:'createGame',controller:'Game']">
                Whom are you challenging?<br>
                <select name="challenged" id="challenged">
                    <g:each in="${allUsers}">
                        <g:if test="${sec.username() != it.username}">
                            <option value="${it.username}">${it.firstName} ${it.lastName}</option>
                        </g:if>
                    </g:each>
                </select>

               <br /><br />

               Are you going first?<br>
                <g:radio name="goesFirst" value="1" checked="true" />Yes
                <g:radio name="goesFirst" value="0"  />No

               <g:submitButton name="create" value="Create" />
            </g:form>
        </div>
	</body>
</html>
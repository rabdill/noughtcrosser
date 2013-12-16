<!DOCTYPE html>
<html>
    <head>
        <title>Noughtcrosser: Tic Tac Toe</title>
        <meta name="layout" content="main" />
    </head>

    <body>
        <div class="container">
            <h2>Recording move...</h2>
            <g:form id="transactional" url="[action:'index',controller:'Square']">
                <g:hiddenField name="gameNum" value="${gameNum}" />
            </g:form>
        </div>
	</body>
</html>
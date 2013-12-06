<g:render template="/templates/headerInfo" />
	<title>Noughtcrosser – Online tic tac toe</title>
	</head>
	<body>
<div class="container">
	<g:render template="/templates/titleBar" />
	
	<g:form name="userForm" url="[action:'authenticate',controller:'user']">
		<p><label for="login">User name:</label><g:textField name="login" /></p>
		<p><label for="password">Password:</label><g:passwordField name="password" /></p>
		<g:submitButton name="Log in" value="Log in" />
	</g:form>
</div>

</body>
</html>
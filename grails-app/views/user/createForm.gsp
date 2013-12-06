<g:render template="/templates/headerInfo" />
	<title>Noughtcrosser – Online tic tac toe</title>
	</head>
	<body>
<div class="container">
	<g:render template="/templates/titleBar" />
	
	<g:form name="userForm" url="[action:'create',controller:'user']">
		<p><label for="first">First name:</label><g:textField name="first" /></p>
		<p><label for="last">Last name:</label><g:textField name="last" /></p>
		<p><label for="userName">User name:</label><g:textField name="userName" /></p>
		<p><label for="password">Password:</label><g:passwordField name="password" /></p>
		<g:submitButton name="create" value="Create" />
	</g:form>
</div>

</body>
</html>
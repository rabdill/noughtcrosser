<g:render template="/templates/headerInfo" />
	<title>Noughtcrosser – Online tic tac toe</title>
	</head>
	<body>
<div class="container">
	<g:render template="/templates/titleBar" />
	
	<g:if test="${success == 1}">
		<h2>Login successful!</h2>
		<a href="<g:createLink controller="game" />">Play now!</a>
	</g:if>
	<g:else>
		<h2>Login rejected, sorry.</h2>
		<a href="<g:createLink controller="home" />">Go back home</a>
	</g:else>
<g:render template="/templates/headerInfo" />
		<title>Noughtcrosser: Tic Tac Toe</title>

	</head>
	
	<body>
<div class="container">
	<g:render template="/templates/titleBar" />
	<g:render template="/templates/redirector" />
	<h2>Creating game...</h2>
	
	<g:form id="transactional" url="[action:'index',controller:'Square']">
			<g:hiddenField name="gameNum" value="${gameNum }" />		
			</g:form>
</div>
	</body>
</html>
<g:render template="/templates/headerInfo" />
		<title>Noughtcrosser V0.1</title>
	</head>
	<body>
<div class="container">
<g:render template="/templates/titleBar" />
<g:render template="/templates/redirector" />
<h2>Creating user...</h2>
	<g:form id="transactional" url="[action:'index',controller:'home']">
			<g:hiddenField name="gameNum" value="1" />		
		</g:form>
	</div>
	</body>
</html>
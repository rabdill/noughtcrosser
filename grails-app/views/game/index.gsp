<g:render template="/templates/headerInfo" />
		<title>Noughtcrosser: Tic Tac Toe</title>
	</head>
	
	<body>
	<div class="container">
<g:render template="/templates/titleBar" />

		<h2>Create a new game</h2>
		<g:form name="newGame" url="[action:'createGame',controller:'Game']">
			Challenger (plays X, goes first):<br>
			<select name="challenger" id="challenger">
			<g:each in="${allUsers}">
			    <option value="${it.userName}">${it.first} ${it.last }</option>
			</g:each>			
			</select>

           <br><br>
           Opponent (plays O, goes second):<br>
			<select name="opponent" id="opponent">
			<g:each in="${allUsers}">
			    <option value="${it.userName}">${it.first} ${it.last }</option>
			</g:each>			
			</select>
			
           <g:submitButton name="create" value="Create" />
		</g:form>
	</div>
	</body>
</html>
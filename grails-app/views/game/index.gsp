<g:render template="/templates/headerInfo" />
		<title>Noughtcrosser: Tic Tac Toe</title>
	</head>
	
	<body>
	<div class="container">
<g:render template="/templates/titleBar" />

		<h2>Create a new game</h2>
		<g:form name="newGame" url="[action:'createGame',controller:'Game']">
			Whom are you challenging?<br>
			<select name="challenged" id="challenged">
			<g:each in="${allUsers}">
			    <g:if test = "${it.login != session.user.login }">
			    	<option value="${it.login}">${it.first} ${it.last }</option>
			    </g:if>
			</g:each>			
			</select>

           <br><br>
           Are you going first?<br>
			<g:radio name="goesFirst" value="1" checked="true" />Yes
			<g:radio name="goesFirst" value="0"  />No
			
           <g:submitButton name="create" value="Create" />
		</g:form>
	</div>
	</body>
</html>
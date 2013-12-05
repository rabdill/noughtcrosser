<g:render template="/templates/headerInfo" />
	<title>Noughtcrosser – Online tic tac toe</title>
	</head>
	
	<body>
		<div class="container">
		<g:render template="/templates/titleBar" />
		<table class="table table-striped">
  			<thead>
  			<tr>
  				<td>First name</td>
  				<td>Last name</td>
  				<td>Wins</td>
  				<td>Losses</td>
  				<td>Ties</td>
  			</tr>
  			</thead>
  			<tbody>
  				<g:each in="${allUsers}">
  					<tr>
				    <td><a href="<g:createLink action="profile"/>?uname=${it.userName}">${it.first }</a></td>
				    <td><a href="<g:createLink action="profile"/>?uname=${it.userName}">${it.last }</a></td>
				    <td>${it.wins }</td>
				    <td>${it.losses }</td>
				    <td>${it.ties }</td>
				    </tr>
				</g:each>
			</tbody>
		</table>
		</div>
	</body>
</html>
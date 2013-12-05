<g:render template="/templates/headerInfo" />
	<title>Noughtcrosser – Online tic tac toe</title>
	<style>
		.record	{font-size: 19px;}
	</style>
	</head>
	
	<body>
		<div class="container">
		<g:render template="/templates/titleBar" />
		<h2>${curUser.first } ${curUser.last }</h2>
		<div class="record">
		Wins: ${curUser.wins }<br>
		Losses: ${curUser.losses }<br>
		Ties: ${curUser.ties }<br>
		</div>
		</div>
	</body>
</html>
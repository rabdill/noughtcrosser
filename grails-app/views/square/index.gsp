<g:render template="/templates/headerInfo" />
		<style>
			.grid {font-size: 40px; text-align:center;}
			 table.grid {table-layout:fixed; width: 210px;}/*Setting the table width is important!*/
	         table.grid td {overflow:hidden; width: 70px;}/*Hide text outside the cell.*/
     
			.large	{font-size: 30px; margin-top: 0px;}
			
			.centered	{margin-left: auto;
						margin-right: auto;}
			h4	{
				margin-bottom: -58px;
				}
		</style>
	
		<title>Noughtcrosser – Online tic tac toe</title>
	</head>
	<body>
<div class="container">
	<g:render template="/templates/titleBar" />
Game number ${gameNum }
		<em class="large">
			<g:if test="${win == 1 }">			<%-- either print the winner or the next person to move --%>
	 			<br>Winner: ${winner } and ${winId }
	 			<g:form id="gameOver" url="[action:'record',controller:'Game']">	
					<g:hiddenField name="gameNum" value="${gameNum }" />
					<g:hiddenField name="winId" value="${winId }" />
					<g:hiddenField name="loseId" value="${loseId }" />
					<input type="submit" value="Record results" >
				</g:form>
	 			
	 			
	 			<h4><a href="<g:createLink controller="game" action="index" />">Start new game</a></h4><br>
			</g:if>
			<g:elseif test="${win == 2 }">
				<br>Tie game!
	 			<h4><a href="<g:createLink controller="game" />">Start new game</a></h4><br>
			</g:elseif>
	 		<g:else>
	 			<br>Your move, ${curMove } (<g:if test="${curMove == "X" }">${curGame.x }</g:if>
	 										<g:else>${curGame.o}</g:else>)
	 																<br>		
	 		</g:else>
		</em>
		
		<table border=1 class="grid" align="center">
			<tr>
		<g:each status="i" in="${gridArray}" var="item">	<%-- Print all 9 elements --%>
 			 	<g:if test="${i % 3 == 0 && i != 0}"></tr><tr></g:if>	<%-- if it's the third element in the row, start a new row --%>
 			<td>
 				<g:if test="${gridArray[i] == " "}">							<%-- If the square is blank, put in a "choose this box" button --%>	
 					<g:form controller="Square" action="makeMove">
							<g:hiddenField name="state" value="${curMove}" />
							<g:hiddenField name="squareSelect" value="${i }" />
							<g:hiddenField name="gameNum" value="${gameNum }" />
							<input type="submit" value=" " style="width: 65px">
					</g:form>
 				</g:if>
 				<g:else>
 					${item.toString()}
 				</g:else>		
 			</td>
 		 </g:each>
 		 	</tr>
 		 </table>
 		<g:form name="madeMove" url="[action:'clearGrid',controller:'Square']">
			<g:hiddenField name="gameNum" value="${gameNum }" />			
           <center><g:submitButton name="create" value="Clear board" /></center>
		</g:form>
 	</div>
	</body>
</html>
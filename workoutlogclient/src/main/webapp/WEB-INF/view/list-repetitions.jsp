<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Repetitions</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Workout Log Repetitions</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Repetitions -->
		
			<input type="button" value="Add Repetitions"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Exercise</th>
					<th>Weight</th>
					<th>Repetitions</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our repetitions -->
				<c:forEach var="tempRepetition" items="${repetitions}">
				
					<!-- construct an "update" link with repetition id -->
					<c:url var="updateLink" value="/repetition/showFormForUpdate">
						<c:param name="repetitionId" value="${tempRepetition.id}" />
					</c:url>					

					<!-- construct an "delete" link with repetition id -->
					<c:url var="deleteLink" value="/repetition/delete">
						<c:param name="repetitionId" value="${tempRepetition.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempRepetition.exerciseId} </td>
						<td> ${tempRepetition.weight} </td>
						<td> ${tempRepetition.repetitions} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this repetition?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>










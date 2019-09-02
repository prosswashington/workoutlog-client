<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Exercises</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Exercises</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add User -->
		
			<input type="button" value="Add Exercise"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Exercise Name</th>
					<th>Muscle</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our exercises -->
				<c:forEach var="tempExercise" items="${exercises}">
				
					<!-- construct an "update" link with user id -->
					<c:url var="updateLink" value="/exercise/showFormForUpdate">
						<c:param name="exerciseId" value="${tempExercise.id}" />
					</c:url>					

					<!-- construct an "delete" link with exercise id -->
					<c:url var="deleteLink" value="/exercise/delete">
						<c:param name="exerciseId" value="${tempExercise.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempExercise.name} </td>
						<td> ${tempExercise.muscle} </td>
						<td> ${tempExercise.description} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this exercise?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>










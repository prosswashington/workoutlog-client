<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Workouts</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Workout Log</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add User -->
		
			<input type="button" value="Add Workout"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Workout Name</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempWorkout" items="${workouts}">
				
					<!-- construct an "update" link with workout id -->
					<c:url var="updateLink" value="/workout/showFormForUpdate">
						<c:param name="workoutId" value="${tempWorkout.id}" />
					</c:url>					

					<!-- construct an "delete" link with workout id -->
					<c:url var="deleteLink" value="/workout/delete">
						<c:param name="workoutId" value="${tempWorkout.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempWorkout.workoutName} </td>
						<td> ${tempWorkout.description} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this workout?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>










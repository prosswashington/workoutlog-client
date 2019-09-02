<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Workout</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-user-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Workout Log Workout</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Workout</h3>
	
		<form:form action="saveWorkout" modelAttribute="workout" method="POST">

			<!-- need to associate this data with workout id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Workout name:</label></td>
						<td><form:input path="workoutName" /></td>
					</tr>
				
					<tr>
						<td><label>User ID:</label></td>
						<td><form:input path="userId" /></td>
					</tr>

					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="description" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/workout/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>











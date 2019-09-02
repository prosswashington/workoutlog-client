<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Exercise</title>

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
			<h2>Workout Log Exercise</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Exercise</h3>
	
		<form:form action="saveExercise" modelAttribute="exercise" method="POST">

			<!-- need to associate this data with exercise id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Workout ID:</label></td>
						<td><form:input path="workoutId" /></td>
					</tr>
				
					<tr>
						<td><label>Exercise name:</label></td>
						<td><form:input path="name" /></td>
					</tr>

					<tr>
						<td><label>Muscle:</label></td>
						<td><form:input path="muscle" /></td>
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
			<a href="${pageContext.request.contextPath}/exercise/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>











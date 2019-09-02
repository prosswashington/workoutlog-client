<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Repetition</title>

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
			<h2>Workout Log Repetition</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Repetition</h3>
	
		<form:form action="saveRepetition" modelAttribute="repetition" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Exercise Id:</label></td>
						<td><form:input path="exerciseId" /></td>
					</tr>
				
					<tr>
						<td><label>Weight:</label></td>
						<td><form:input path="weight" /></td>
					</tr>

					<tr>
						<td><label>Repetitions:</label></td>
						<td><form:input path="repetitions" /></td>
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
			<a href="${pageContext.request.contextPath}/repetition/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>











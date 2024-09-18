<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="StudentDataBaseDto.Teacher"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">

<!-- Custom CSS -->
<style>
body {
	margin-top: 100px;
	margin-bottom: 100px;
	background-image:
	url('https://i.pinimg.com/736x/50/67/2d/50672dd7c0a76e379ac6ddd8023c96be.jpg');
	background-size: cover;
	background-color: rgba(255, 255, 255, 1.0);
}

.card-title {
	font-weight: bold;
	font-size: 24px;
	text-align: center;
	color: black;
}

.card {
	border: none;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.5);
	transition: 0.3s;
	position: relative;
	left: 350px;
	top: 100px;
}

.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.card-title {
	font-weight: bold;
}

.card-text {
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<%
			List<Teacher> l = (List) session.getAttribute("list6");
			%>
			<%
			for (Teacher s : l) {
			%>
			<div class="col-md-4">
				<div class="card mb-4"
					style="background: transparent; border: none;">
					<div class="card-body">
						<a href="javascript:history.back()">Back</a>
						<h1 class="card-title mb-4" style="text-transform: uppercase;"><%=s.getName()%></h1>
						<h5 class="card-text" style="font-size: 18px;">
							<strong>ID:</strong>
							<%=s.getId()%></h5>
						<h5 class="card-text" style="font-size: 18px;">
							<strong>Subject:</strong>
							<%=s.getSubject()%></h5>
						<h5 class="card-text" style="font-size: 18px;">
							<strong>ClassTeacher:</strong>
							<%=s.getClassTeacher()%></h5>
						<h5 class="card-text" style="font-size: 18px;">
							<strong>Phone Number:</strong>
							<%=s.getPhone()%></h5>
						<h5 class="card-text" style="font-size: 18px;">
							<strong>Email:</strong>
							<%=s.getEmail()%></h5>
						<h5 class="card-text" style="font-size: 18px;">
							<strong>Salary:</strong>
							<%=s.getSalary()%></h5>
						
					</div>
				</div>


			</div>
			<%
			}
			%>
		</div>
	</div>



	<!-- Bootstrap JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.3/umd/popper.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.min.js"></script>

</body>
</html>
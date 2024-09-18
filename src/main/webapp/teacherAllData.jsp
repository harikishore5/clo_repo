<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="StudentDataBaseDto.Teacher" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">

<!-- Custom CSS -->
<style>
	body {
	margin-top: 100px;
	margin-bottom: 100px;
	background-image: url('https://img.freepik.com/premium-photo/travel-concept-blue-background-with-copy-space-airplane-toy-blue-color-background_661495-33583.jpg');
	background-size: cover;
	background-color: rgba(255,255,255,0.8); 
   }
    table {
        width: 100%;
        margin-bottom: 1rem;
        color: #212529;
        border-collapse: collapse;
    }
    
    th {
        text-align: inherit;
        padding: .75rem;
        vertical-align: bottom;
        border-bottom: 2px solid #dee2e6;
        font-weight: bold;
    }
    
    td {
        text-align: inherit;
        padding: .75rem;
        vertical-align: middle;
        border-top: 1px solid #dee2e6;
    }
    
    .table-primary {
        background-color: #c6e0f5;
    }
    
    .table-secondary {
        background-color: #d6d8db;
    }
    
    .table-success {
        background-color: #c3e6cb;
    }
    
    .table-danger {
        background-color: #f5c6cb;
    }
    
    .table-warning {
        background-color: #ffeeba;
    }
    
    .table-info {
        background-color: #d1ecf1;
    }
    
    .table-light {
        background-color: #f8f9fa;
    }
    
    .table-dark {
        background-color: #c6c8ca;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>Teachers List</h1>
                <table class="table">
                <a href="javascript:history.back()">Back</a>
                    <thead class="table-primary">
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Subject</th>
                            <th>Class Teacher</th>
                            <th>Phone Number</th>
                            <th>Email</th>
                            <th>Salary</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% List<Teacher> list = (List)session.getAttribute("list2"); %>
                        <% for(Teacher s: list){ %>
                        <tr class="table-light">
                            <td><%= s.getId() %></td>
                            <td><%= s.getName() %></td>
                            <td><%= s.getSubject() %></td>
                            <td><%= s.getClassTeacher() %></td>
                            <td><%= s.getPhone() %></td>
                            <td><%= s.getEmail() %></td>
                            <td><%= s.getSalary() %></td>
                            
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.3/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.min.js"></script>
    
</body>
</html>
<%-- 
    Document   : Header4
    Created on : 7 Mar, 2020, 1:53:36 PM
    Author     : Kritika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>


<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/resources/css/NavigationHeader.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .active {
  background-color: dodgerblue;
  color: white;
}
        </style>
    </head>
    <body>
        <center>
       <div class="pill-nav" style="margin-top: 220px">
            <a class="active" onclick="" id="tester" href="${pageContext.request.contextPath}/Testers">Tester Dashboard</a>
            <a href="${pageContext.request.contextPath}/Tester/CreateBug"  id="createBugs">Create Bugs</a>
            <a href="${pageContext.request.contextPath}/ProjectStatus" id="statPro">Project Status</a>
            <a href="${pageContext.request.contextPath}/Tester/AboutProjectTester" id="abtPro">About Project</a>
        </div>
            
        
    </body>
</html>

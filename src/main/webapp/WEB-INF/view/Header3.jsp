<%-- 
    Document   : Header3
    Created on : 29 Feb, 2020, 11:43:56 PM
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
    <% int id=(Integer)session.getAttribute("emp_id");
    %>
        <center>
        <div class="pill-nav" style="margin-top: 220px">
      ${id}  
            <a class="active" onclick="" id="addPro" href="${pageContext.request.contextPath}/Project/addProject">${id} Add Project</a>
            <a href="${pageContext.request.contextPath}/Project/AboutProject/${emp_id}"  id="aboutPro">About Project</a>
            <a href="${pageContext.request.contextPath}/ProjectStatus" id="statPro">Project Status</a>
            <a href="${pageContext.request.contextPath}/Project/addDeveloper" id="adddev">Add Developer</a>
        </div>
        </center>
</body>
</html>

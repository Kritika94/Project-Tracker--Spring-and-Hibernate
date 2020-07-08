<%-- 
    Document   : Header2
    Created on : 15 Feb, 2020, 2:00:33 PM
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
            <a class="active" onclick="" id="dashboard" href="${pageContext.request.contextPath}/dashboard"> Dashboard</a>
            <a href="${pageContext.request.contextPath}/createStory"  id="story">Create Story</a>
            <a href="${pageContext.request.contextPath}/Developer/AboutProject" id="aboutPro">About Project</a>
            <a href="${pageContext.request.contextPath}/ProjectStatus" id="ProjectStatus">Project Status</a>
        </div>
            
        
    </body>
</html>

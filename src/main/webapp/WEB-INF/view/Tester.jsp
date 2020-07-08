<%-- 
    Document   : Tester.jsp
    Created on : 7 Mar, 2020, 12:47:43 PM
    Author     : Kritika
--%>

<%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header4.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Dashboard</title>
    </head>
    <body>
 <div style="text-align: center; color:white;float:left;padding-left:6%; margin-top:1%; "><img src="${pageContext.request.contextPath}/resources/images/projectTracker.gif"></div>
        <div style="text-align: center; color:white;margin-right:-70%; margin-top:1%;  background-color: #5b86e5;border:2px solid #36d1dc;height:200px; width:30%">
             Welcome ${user}
            <h3>Assigned to you</h3>
            <ul>            
              <c:forEach var="lists" items="${Assignee}" >
           <li><a href="<c:url value="Tester/viewBug/${lists}"/>">${lists}</a></li>
             
             </c:forEach>
              <c:forEach var="listsAssignee" items="${AssignedTicket}" >
           <li><a href="<c:url value="/create/viewstory?cumin_number=${listsAssignee}"/>">${listsAssignee}</a></li>
             
             </c:forEach>
           </ul>
            
        </div>
        <div style="text-align: center; color:white;margin-right:-70%; margin-top:1%;  background-color: #5b86e5;border:2px solid #36d1dc;height:200px; width:30%">
            <h3>Reported By you </h3>
            <ul>
             <c:forEach var="bug_id" items="${list}" >
           <li><a href="<c:url value="Tester/viewBug/${bug_id}"/>">${bug_id}</a></li>
             
             </c:forEach>
           </ul>


        </div>
    </body>
</html>
<%-- 
    Document   : CuminDashboard
    Created on : 15 Feb, 2020, 1:58:13 PM
    Author     : Kritika
--%>

<%@page import="java.sql.*"%>
  <%@ taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header2.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Dashboard</title>
    </head>
    <body>
   <security:authorize access="hasRole('MANAGER')">

<p>
<%response.sendRedirect("/CuminTicket/Managers");
%>
</p>
</security:authorize>
<security:authorize access="hasRole('TESTER')">
<p>
<%response.sendRedirect("/CuminTicket/Testers");
%>
</p>
</security:authorize>
      
        <div style="text-align: center; color:white;float:left;padding-left:6%; margin-top:1%; "><img src="${pageContext.request.contextPath}/resources/images/projectTracker.gif"></div>
        
        <div style="text-align: center; color:white;margin-right:-70%; margin-top:1%;  background-color: #5b86e5;border:2px solid #36d1dc;height:200px; width:30%">
             Welcome ${user}
          
            <h3>Assigned to you</h3>
            <ul>            
              <c:forEach var="lists" items="${Assigned}" >
           <li><a href="<c:url value="/create/viewstory?cumin_number=${lists}"/>">${lists}</a></li>
             </c:forEach>
             <c:forEach var="listsBugs" items="${AssignedBugs}" >
             <li> <a href="<c:url value="/Tester/viewBug/${listsBugs}"/>">${listsBugs}</a></li>
             </c:forEach>
           </ul>
            
        </div>
        <div style="text-align: center; color:white;margin-right:-70%; margin-top:1%;  background-color: #5b86e5;border:2px solid #36d1dc;height:200px; width:30%">
            <h3>Reported By you</h3>
            <ul>
             <c:forEach var="lists" items="${list}" >
           <li><a href="<c:url value="/create/viewstory?cumin_number=${lists}"/>">${lists}</a></li>
             </c:forEach>
           </ul>
        </div>
    </body>
</html>

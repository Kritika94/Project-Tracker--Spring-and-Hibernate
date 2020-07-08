<%-- 
    Document   : Header
    Created on : 15 Feb, 2020, 1:53:42 PM
    Author     : Kritika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/resources/css/LoginCss.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cumin Ticket</title>
    </head>
    <body>  
     <div class="header__bg"><img src='${pageContext.request.contextPath}/resources/images/logo.png' style="margin-top:12px;transform:skewY(6deg)" width="20%" height="55%"><h2 style="color:white;transform:skewY(6deg);margin-left:20%; font-size: 40px"> Project Tracker</h2>
       <form:form action="${pageContext.request.contextPath}/logout" method="post">
             <input type="submit" id="logout" value="Logout"  style="background:linear-gradient(#66ccff,#eefefe);
               color:Black;width:140px;font-family:initial;border: none; font-weight:bold;transform:skewY(4deg); float:right;margin-top:-99px; font-size:100%">
              </form:form>
    </div>
       
        
    </body>
</html>

<%-- 
    Document   : CuminLogin
    Created on : 15 Feb, 2020, 12:12:48 PM
    Author     : Kritika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="Header.jsp"  %>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/resources/css/LoginCss.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cumin Ticket</title>
        <script>
         document.getElementById("logout").hidden=true;
         
         

        </script>


    </head>
    <style>
        input{
            -moz-border-radius: 15px;
            border-radius: 15px;
            border:solid 1px grey;
            padding:5px;
            background-color:white;
            color:Black;
            width: 200px;font-family:initial; font-weight:bolder; font-size:100%;
        }
        ::placeholder {
            color: #5b86e5;
            opacity: 1;  
            font-family: sans-serif;
        } 
        i{
            color:#5b86e5;

        }
    </style>

    <body>

    <center>
        <div class="divLogin">
            <h2 style="font-family:sans-serif;color:#5b86e5;font-size:40px  "><img src="${pageContext.request.contextPath}/resources/images/Staff.png" width=20% height="20%">Login</h2>
            <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
                <i class="fa fa-user" style="font-size:130%"></i> <input  name="username" placeholder="User Name"  required="true">
                <br>
                <i class="fa fa-lock" style="font-size:130%"></i>&nbsp;<input style="margin-top:4px"  name="password" class="img" placeholder="Password" type="password" required/>
                <br> <button style="background:linear-gradient(#66ccff,#eefefe);
                             color:Black;margin-left:15px; margin-top:2px; 
                             width: 205px;font-family:initial; font-weight:bolder; font-size:100%">Submit</button>
            </form:form>
      
        </div>

    </body>
</html>

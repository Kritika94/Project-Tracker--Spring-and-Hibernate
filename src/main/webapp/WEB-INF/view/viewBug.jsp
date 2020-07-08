<%-- 
    Document   : viewBug
    Created on : 7 Mar, 2020, 4:18:58 PM
    Author     : Kritika
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>
<%@page import="com.cumin.entity.Bugs"%>
<security:authorize access="hasRole('TESTER')&& hasRole('DEVELOPER')">
<p>
<jsp:include page="Header4.jsp"></jsp:include>
</security:authorize>
<security:authorize access="hasRole('DEVELOPER') && !hasRole('TESTER')">
<jsp:include page="Header2.jsp"/>
</security:authorize>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%  Bugs bugs = (Bugs)request.getAttribute("bugs");%>
        <script>

            function unloadEvt() {

                document.location.href = '${pageContext.request.contextPath}/Tester/statusChange?bug_id=${bugs.bug_id}&bug_status=${bugs.bug_status}';

            }

            function DevUnderstanding() {


                var Dev = document.getElementById("edit").innerHTML;
                document.location.href = '${pageContext.request.contextPath}/Tester/SetAssignee?bug_id=${bugs.bug_id}&Assignee=' + Dev;


            }

            function editable() {
                document.getElementById("edit").setAttribute("contenteditable", true);
                document.getElementById("devedit").hidden = false;
            }
            </script>
    </head>
   





    <body><br>
        <div class="container-fluid">
            <h2>${bugs.bugs_header}</h2> 
            <div class="row">

                <div class="col-sm-4" style="background-color:lavender;"><span style="padding :0px 14px 14px 14px;color:white;font-weight: bold;background-color:#5b86e5">Bug Type:${bugs.bug_type}</span>

                </div>
                <input type="hidden" name="cumin"  value="<%=bugs.getBug_id()%>"  >
                <div class="col-sm-4" style="background-color:lavenderblush;"><button class="btn btn-success" onclick='unloadEvt()' style="width:105px">${bugs.bug_status}</button></div>
                <div class="col-sm-4" style="background-color:lavender;">
                    <span style="padding :0px 14px 14px 14px;color:white;font-weight: bold;background-color:#5b86e5">Cumin-Ticket:${bugs.cumin_ticket.cumin_number}</span>

                </div>
            </div>
            <p></p>
            <div class="row"> 
                <div class="col-sm-4" style="background-color:white;"></div>
                <div class="col-sm-4" > <span style="padding :0px 14px 14px 14px;color:white;font-weight: bold;background-color:#5b86e5">Assignee:<span id='edit'><%=bugs.getAssignee()%></span><button onclick="editable()"  class="btn" style="font-size:20px; background-color: transparent"><i class="fa fa-pencil"></i></button><button id="devedit" onclick="DevUnderstanding()" title="save" class="btn" style="font-size:20px; background-color: transparent" hidden><i class="fa fa-floppy-o"></i></button></span>


                </div>
                <div class="col-sm-4" style="background-color:lavender;">
                    <span style="padding :0px 14px 14px 14px;color:white;font-weight: bold;background-color:#5b86e5">Reporter :${bugs.bug_reporter} </span>

                </div>
            </div>
            <p></p>
            <div class="row">
                <div class="container" height="50px">

                    <div class="jumbotron" style="height:40px">
                        <h3 style="margin-top:-54px">Description:</h3>
                        <p>${bugs.description}</p>                         
                    </div>

                </div>
            </div>



    </body>
</html>

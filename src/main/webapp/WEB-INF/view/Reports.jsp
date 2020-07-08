<%-- 
    Document   : Reports
    Created on : 8 Mar, 2020, 5:08:13 PM
    Author     : Kritika
--%>

<%@page import="com.cumin.entity.cumin_ticket"%>
<%@page import="com.cumin.entity.Bugs"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <% int size;
    String value = (String)request.getAttribute("value");
    
    %>
        <%@include file="ProjectStatusManage.jsp" %>
          <div class="div2"> 
         <%if (value.equals("BugReport")) {
        	List<Bugs> BugReport=(List<Bugs>)request.getAttribute("BugReport");
         %>
         
         
            <table class="table col-lg-12">
                <thead>
                    <tr>
                        <th scope="col">Bug Reporter</th>
                        <th scope="col">Bug Type</th>
                        <th scope="col">Bug Status</th>
                        <th scope="col">Bug Id</th>
                        <th scope="col">Assignee</th>
                        <th scope="col">Bug Header</th>
                        <th scope="col">Cumin Ticket</th>
                    </tr>
                </thead> 
                <tbody>
                 
                    <c:forEach var = "BugReport" items = "${BugReport}">
                    
                        <tr>
                            <td> <c:out value = "${BugReport.bug_reporter}"/></td>
                            <td> <c:out value = "${BugReport.bug_type}"/></td>
                            <td> <c:out value = "${BugReport.bug_status}"/></td>
                            <td> <c:out value = "${BugReport.bug_id}"/></td>
                           
                            <td> <c:out value = "<%=BugReport.iterator().next().getAssignee()%>"/></td>
                            
                            <td> <c:out value = "${BugReport.bugs_header}"/></td>
                            <td> <c:out value = "${BugReport.cumin_ticket.cumin_number}"/></td>

                        </tr>
                    </c:forEach>
                    
                </tbody>
            </table>
           <% }%>
               <%if (value.equals("CuminStatus")) {
               List<cumin_ticket> cumins=(List<cumin_ticket>)request.getAttribute("cumins");
               
               %>
            <table class="table col-lg-12">
                <thead>
                    <tr>
                        <td scope="col">Cumin Number</td>
                        <td scope="col">Reporter Name</td>
                        <td scope="col"> Status</td>
                        <td scope="col"> Assignee</td>
                    </tr>
                </thead> 
                <tbody>
                   
                    <c:forEach var = "cumins" items = "${cumins}">
                   
                        <tr>
                            <td> <c:out value = "${cumins.cumin_number}"/></td>
                            <td> <c:out value = "${cumins.reporter_name}"/></td>
                            <td> <c:out value = "${cumins.status}"/></td>
                            <td> <c:out value = "<%=cumins.iterator().next().getAssignee()%>"/></td>

                        </tr>
                    </c:forEach>
                    
                </tbody>
            </table>
          <%} %>
         
          <%if (value.equals("ProjectReport")) {
          
           %>
            <center>
           
                <div class="col-sm-4" style="background-color:lavender;">Project Status :
                
             
                    <div class="container">
                        <div class="progress" style="width:100%">
                            <div class="progress-bar" role="progressbar" id="progress"  aria-valuenow="70" aria-valuemin="0" aria-valuemax="100">
                       
                            </div>

                        </div>
                    </div>
                    <p id="progressStat"></p>
                </div>
            </center>
           
        </div>
        <%} %>
        
        <script>

        function foo() {
          
            var foo = ${(counter/size)*100};
            document.getElementById("progress").style.width = foo + '%';
            
            document.getElementById("progressStat").innerHTML = "The status of your project is " + foo + "%. Kindly increase the number of closed tickets over total number of tickets, to improvise the Project status";
        }
        foo();

        </script>

    </body>
</html>

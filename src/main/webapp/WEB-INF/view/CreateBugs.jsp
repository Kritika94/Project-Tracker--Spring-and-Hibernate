<%-- 
    Document   : CreateBugs
    Created on : 7 Mar, 2020, 2:04:13 PM
    Author     : Kritika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header4.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

        <script>
            
            function myFunction() {
   var element = document.getElementById("createBugs");
   element.classList.add("active");
   document.getElementById("tester").classList.remove("active");
   document.getElementById("statPro").classList.remove("active");
   document.getElementById("abtPro").classList.remove("active");
}
myFunction();
            
        </script>
        <%String name=(String)session.getAttribute("user");%>
    </head>
     <body>
        <div  style=" text-align: center;margin-top:2%" class="container-fluid">
        <form:form action="${pageContext.request.contextPath}/Tester/SaveBug" method="post" class="form-horizontal">
  <div class="form-group">
    <label  class="col-md-2">Bug Name</label>
    <input type="text" class="col-sm-4" name="bugs_header" required placeholder="Bug Name">
  </div>
  <div class="form-group">
    <label  class="col-md-2">Bug Type</label>
    <input type="Text" class="col-sm-4"  name="bug_type" required  placeholder="Bug Type">
  </div>
  <div class="form-group">
    <label  class="col-md-2">Assignee</label>
    <input type="Text" class="col-sm-4"  name="Assignee" required  placeholder="Enter Assignee">
  </div>
  <div class="form-group">
    <label  class="col-md-2">Cumin Ticket</label>
    <input type="Text" class="col-sm-4"  name="cumin_ticket" required  placeholder="Enter Cumin Ticket Number">
  </div>
   <div class="form-group">
    <label style="vertical-align: top"  class="col-md-2"> Bug Description</label>
    <textarea type="text" minlength="50" maxlength="120" class="col-sm-4"  required name="description" rows="4" cols="2"  placeholder="description"></textarea>
     <input type="hidden" value="<%=name%>" name="bug_reporter"/>
  </div> 
  <input type='submit' style="background:linear-gradient(#66ccff,#eefefe);
                                             color:Black;margin-left:0px; margin-top:2px; 
                                             width: 205px;font-family:initial; font-weight:bold; font-size:100%" value="Create Bug"/>
                
  </form:form>
        </div>
      
    </body>
</html>
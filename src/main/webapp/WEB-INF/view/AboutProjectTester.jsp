<%-- 
    Document   : AboutProject
    Created on : 27 Feb, 2020, 11:27:30 AM
    Author     : Kritika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>
<<jsp:include page="Header4.jsp"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <script>
            
        function myFunction() {
        	   var element = document.getElementById("createBugs");
        	   element.classList.remove("active");
        	   document.getElementById("tester").classList.remove("active");
        	   document.getElementById("statPro").classList.remove("active");
        	   document.getElementById("abtPro").classList.add("active");
        	}
        	myFunction();
            
        </script>
          
        
    </head>
    <body>
         <div class="container-fluid" >
              <div style="margin-right:30%; width:50%; color:white; margin-top:1%; "><img src="${pageContext.request.contextPath}/resources/images/projectTracker.gif"></div>
            <%Object project=request.getAttribute("Project");
            
            if(project==null){
            	
            %>
            
              <div style="text-align:left;width:30%;color:#5b86e5;padding-bottom: 2px; margin-left:65%;margin-top:-28%;">
                <div class="col-sm-12" style="background-color:lavender;">
                  Add Project Here 
                </div>
            </div>    
            </div>   
            <% }%>
            
            <div style="text-align:left;width:30%;color:#5b86e5;padding-bottom: 2px; margin-left:65%;margin-top:-28%;">
             <h4>Project Title:</h4>
             <div class="col-sm-12" style="background-color:lavender;">
             ${Project.project_title}
             </div>
             <h4>Description:</h4>
             <div class="col-sm-12" style="background-color:lavenderblush;">
             <p>
             ${Project.description}
             </p>
             </div>
             <h4>Project ID:</h4>
             <div class="col-sm-12" style="background-color:lavender;">
             <p>
             ${Project.project_id}
             </p>
             </div>
             <h4>Duration:</h4>
             <div class="col-sm-12" style="background-color:lavender;">
             Years: ${Project.years}  Months : ${Project.months}
             </div>
             <h4>Technology:</h4>
             <div class="col-sm-12" style="background-color:lavender;">
             ${Project.technology}
             </div>
             </div>
            </div>
    </body>
    
</html>

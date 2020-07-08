<%-- 
    Document   : ProjectHome
    Created on : 29 Feb, 2020, 11:36:33 PM
    Author     : Kritika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="Header3.jsp" %>
<!DOCTYPE html>
<html>
  <head>

        <link href="${pageContext.request.contextPath}/resources/css/NavigationHeader.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
      
            
 </script>
  </head>
  <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
 
 
  
  
      <body onload="loader()">
      <div style="text-align: center; color:white; margin-top:1%; "><img src="${pageContext.request.contextPath}/resources/images/projectTracker.gif"></div>
 
         <% out.println(id);
         if(id==0)
        	 
         {%>
        
				<div class="modal" id="myModal">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">Enter Manager Details</h4>
								<button type="button" class="close" onclick="close()" id="mybtn"  data-dismiss="modal">&times;</button>
							</div>

							<!-- Modal body -->
							<div class="modal-body">
								<form:form class="form-horizontal"
									action="${pageContext.request.contextPath}/Project/Manager"
									method="post">
									<div class="form-group">
										<label class="col-sm-2 control-label" for="title">EmployeeId</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="inputEmail3"
												name="emp_id" placeholder="Employee Id" required />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="description">Name</label>
										<div class="col-sm-10">
										<input type="text"  class="form-control" name="name"
												id="description" placeholder=" Enter Name" required/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="email">E-mail</label>
										<div class="col-sm-10">
										<input type="text"  class="form-control" name="email"
												id="email" placeholder=" Email" required/>
										</div>
									</div>
										<div class="form-group">
										<label class="col-sm-2 control-label" for="experience">Experience</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="experience"
												id="experience" placeholder=" Experience" required/>
										</div>
									</div>
										
										   <input type="hidden" class="col-sm-4" name="uname"  value="${user}">
							
							</div>

							<!-- Modal footer -->
							<div class="modal-footer">
								<button class="btn btn-primary" onclick="close()">OK</button>
								<button class="btn" style="background-color: #cccccc"
									data-dismiss="modal">cancel</button>
								</form:form>
							</div>

						</div>
					</div>
				</div>
     <% }%>
    </body>
     <script type="text/javascript">
var modal=  document.getElementById("myModal");
var btn=document.getElementById("mybtn");
  function loader(){
  modal.style.display="block";

  }
  
 btn.onclick=function (){
	 modal.style.display="none";
 }
  </script>
</html>

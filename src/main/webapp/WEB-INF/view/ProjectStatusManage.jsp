<%-- 
    Document   : ProjectStatusManage
    Created on : 29 Feb, 2020, 11:58:01 PM
    Author     : Kritika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
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
<link href="${pageContext.request.contextPath}/resources/css/newcss.css" rel="stylesheet" type="text/css">
        <script>
           
            
        </script>
         <style>
             
            div.gallery{
                    
                        height:150px;
                        width:100%;
                        z-index:1; 
                        position:relative;
            }
            



 #menu, #menu ul {
	list-style:none;
	padding:0;
	margin-left:10px;  
        font-weight:bold;
        text-align:center;
        
}
#menu li{
       
	position:relative;
	line-height: 2.5em;
	width: 20em;

}
ul#menu li ul {
	position:absolute;
	margin-top:-25%;
	margin-left:100%;
	display:none;
       
}




            #menu  a {
	display:block;
	border-right:1px solid #fff;
	background-color:cornflowerblue;
	color:darkblue;
	text-decoration:none;
        background:linear-gradient(#66ccff,#eefefe);
	font-weight:bold;
}
#menu a:hover {
	
	color:orange;
}

#menu li:hover ul, #menu li.over ul {
	display:block;
           z-index:100000;
               visibility:visible;
}




             
        </style>
    </head>
    <body>
        
        <div style="position: absolute"><ul id="menu" >
         <li>
             <a href="${pageContext.request.contextPath}/Reports?value=BugReport">Bug Report</a>             
         </li>
          <li>
             <a href="${pageContext.request.contextPath}/Reports?value=CuminStatus">Cumin Status</a>             
         </li>
          <li>
             <a href="${pageContext.request.contextPath}/Reports?value=ProjectReport">Project Report</a>             
         </li>     
</div> 
            <div class="div1"> 
                <img src="${pageContext.request.contextPath}/resources/images/projectTracker.gif" height="300px" width="100%">
            </div>
        
        
    </body>
</html>
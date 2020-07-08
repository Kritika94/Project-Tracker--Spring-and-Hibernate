<%-- 
    Document   : AddDeveloper
    Created on : 29 Feb, 2020, 11:40:32 PM
    Author     : Kritika
--%>

<html>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@include file="Header3.jsp"  %>
    <script>
        function myFunction() {
            var element = document.getElementById("adddev");
            element.classList.add("active");
            document.getElementById("addPro").classList.remove("active");
            document.getElementById("statPro").classList.remove("active");
            document.getElementById("aboutPro").classList.remove("active");
        }
        myFunction();

    </script>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>

        <div class="container">
            <form:form action="${pageContext.request.contextPath}/Developer/saveDev" method="post" class="form-vertical">
                <div class="form-group">
                    <label ><b>Developer </b></label><br>
                    <input type="text" class="form-control" name="name" required placeholder="Developer">

                </div>
                <div class="form-group">
                    <label><b>Employee ID </b></label><br>
                    <input type="Text" class="form-control"  name="emp_id" required  placeholder="Employee Id">
                </div>

                <div class="form-group">
                    <label><b>Employee Password </b></label><br>
                    <input type="password" class="form-control" name="p_password" required  placeholder="Employee Password">
                </div>

                <div class="form-group">

                    <label ><b>Experience </b></label><br>
                    <input type="number" class="form-control " name="experience" required  placeholder="Years">
                </div>   
                <div class="form-group">
                    <label><b>Skills </b></label><br>
                    <input type="text" class="form-control" name="skills" required  placeholder="Skills">
                    <input type="hidden" class="form-control" name="id" value="${emp_id}" >
                </div>
                     <div class="form-group">
                      <label><b>Employee Type </b></label><br>
                       <Select class="form-control" name="DevType" required >
                        <option>Developer</option>
                        <option>Tester</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>
</body>
</html>
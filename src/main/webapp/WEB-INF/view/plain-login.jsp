<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Custom Login Form</h3>

<c:if test="${param.error!=null}">
<i style="color:red" >Sorry u entered invalid username and password</i>
</c:if>
 <!--   <!--form:form>automatically added csrf token-->
<form:form  method ="post" action="${pageContext.request.contextPath}/authenticateTheUser">

<c:if test="${param.logout!=null}">
<i style="color:Blue" >U have been logged out</i>
</c:if>
<p>
User Name: <input type="text" name="username"/>
</p>
<p>
Password:  <input type="password" name="password"/>
</p>
<p>
<input type="submit" value="submit"/>
</p>

</form:form>
</body>
</html>
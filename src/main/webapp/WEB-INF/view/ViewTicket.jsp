<%-- 
    Document   : ViewTicket
    Created on : 17 Feb, 2020, 9:28:49 PM
    Author     : Kritika
--%>
<%@page import="com.cumin.entity.Subtask"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.cumin.entity.cumin_ticket"%>
<%@ taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<security:authorize access="hasRole('TESTER')&& hasRole('DEVELOPER')">
<p>
<jsp:include page="Header4.jsp"></jsp:include>
</security:authorize>
<security:authorize access="hasRole('DEVELOPER') && !hasRole('TESTER')">
<jsp:include page="Header2.jsp"/>
</security:authorize>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>


<script>

           function unloadEvt() {

                document.location.href = '${pageContext.request.contextPath}/create/statusChange?cumin_number=${cumin.cumin_number}&status=${cumin.status}';

            }
            function WorkLogEdit() {


                var Log = document.getElementById("Log").innerHTML;
                document.location.href = '${pageContext.request.contextPath}/create/saveWorkLog?cumin_number=${cumin.cumin_number}&log_work='+Log;


            }
            function DevUnderstanding() {


                var Dev = document.getElementById("dev").innerHTML;
                document.location.href = '${pageContext.request.contextPath}/create/save?cumin_number=${cumin.cumin_number}&DevUnderstanding='+Dev;

            }

           function editable() {
                document.getElementById("dev").setAttribute("contenteditable", true);
                document.getElementById("devedit").hidden = false;
            }
           
            function editable3() {
                document.getElementById("Log").setAttribute("contenteditable", true);
                document.getElementById("workLog").hidden = false;
            }


            function editables() {
                document.getElementById("editAssignee").setAttribute("contenteditable", true);
                document.getElementById("devedit2").hidden = false;
            }

            function Assigned() {
                var Dev = document.getElementById("editAssignee").innerHTML;
                document.location.href = '${pageContext.request.contextPath}/create/saveAssignee?cumin_number=${cumin.cumin_number}&assignee='+Dev;

            }

            
        </script>
</head>


<body>
	<br>
	<div class="container-fluid">
		<h2>${cumin.title}</h2>
		<div class="row">

			<div class="col-sm-4" style="background-color: lavender;">
				<button class=" btn btn-primary" data-toggle="modal"
					data-target="#myModal">Create Subtask:</button>
				<div class="modal" id="myModal">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">Create Subtask</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>

							<!-- Modal body -->
							<div class="modal-body">
								<form:form class="form-horizontal"
									action="${pageContext.request.contextPath}/create/Subtask"
									method="post">
									<div class="form-group">
										<input type="hidden" name="cumin" value="${cumin.cumin_number}">
										<label class="col-sm-2 control-label" for="title">Title</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="inputEmail3"
												name="title" placeholder="Title" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="description">Description</label>
										<div class="col-sm-10">
											<textarea row="4" class="form-control" name="Description"
												id="description" placeholder=" Enter Description"></textarea>
										</div>
									</div>
							</div>

							<!-- Modal footer -->
							<div class="modal-footer">
								<button class="btn btn-primary">OK</button>
								<button class="btn" style="background-color: #cccccc"
									data-dismiss="modal">cancel</button>
								</form:form>
							</div>

						</div>
					</div>
				</div>
			</div>
			<input type="hidden" name="cumin" value="${cumin.cumin_number}">
			<div class="col-sm-4" style="background-color: lavenderblush;">
				<button class="btn btn-success" onclick='unloadEvt()'
					style="width: 105px">${cumin.status}</button>
			</div>
			<div class="col-sm-4" style="background-color: lavender;">Estimated
				Time:${cumin.getEstimated_hrs()} hrs</div>
		</div>
		<p></p>
		<div class="row">
			<div class="col-sm-4" style="background-color: lavenderblush;">

				<span
					style="padding: 0px 14px 14px 14px; color: white; font-weight: bold; background-color: #5b86e5">Assignee
					: <span id='editAssignee'>${cumin.assignee}</span>
					<button onclick="editables()" class="btn"
						style="font-size: 20px; background-color: transparent">
						<i class="fa fa-pencil"></i>
					</button>
					<button id="devedit2" onclick="Assigned()" title="save" class="btn"
						style="font-size: 20px; background-color: transparent" hidden>
						<i class="fa fa-floppy-o"></i>
					</button>
				</span>



			</div>
			<div class="col-sm-4">
				<button class=" btn btn-primary" data-toggle="modal"
					data-target="#myModalNew">Log Work:</button>
				<!-- The Modal -->
				<div class="modal" id="myModalNew">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">Log Work</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>

							<!-- Modal body -->
							<div class="modal-body">
								<form:form class="form-horizontal" action="${pageContext.request.contextPath}/create/LogWork"
									method="post">

									<div class="form-group">

										<div class="col-sm-10">
										<input type="hidden" name="cumin_number" value="${cumin.cumin_number}">
											<textarea row="4" class="form-control" id="description"
												name="log_work" placeholder=" Enter Description"></textarea>
										</div>
										<div class="form-group">
											<br>
											<div class="col-sm-10">
												<input type="number" class="form-control"
													name="remaining_hrs" id="inputEmail3"
													placeholder="Remaining Time" />
											</div>
										</div>
									</div>
							</div>

							<!-- Modal footer -->
							<div class="modal-footer">
								<button class="btn btn-primary">OK</button>
								<button class="btn" style="background-color: #cccccc"
									data-dismiss="modal">cancel</button>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%
				cumin_ticket cumin = (cumin_ticket) request.getAttribute("cumin");
				int ehrs = cumin.getEstimated_hrs();
				int rhrs = cumin.getRemaining_hrs();
				double TimePercentage = ((double) (rhrs) / (double) (ehrs)) * 100;
			%>
			<div class="col-sm-4" style="background-color: lavender;">
				Remaining Time :
				<div class="container">
					<div class="progress" style="width: 20%; background-color:green" >
						<div class="progress-bar" role="progressbar" aria-valuenow="70"
							aria-valuemin="0" aria-valuemax="100"
							style="width:<%=TimePercentage%>%" ></div></div>
					</div>
				</div>
			</div>
		</div>
		<p></p>
		<div class="row">
			<div class="container" height="50px">

				<div class="jumbotron" style="height: 40px">
					<h3 style="margin-top: -54px">
						Developer Understanding:
						
						<button onclick="editable()" class="btn"
							style="font-size: 20px; background-color: transparent">
							<i class="fa fa-pencil"></i>
						</button>
						
						<button id="devedit" onclick="DevUnderstanding()" title="save"
							class="btn"
							style="font-size: 20px; background-color: transparent" hidden>
							<i class="fa fa-floppy-o"></i>
						</button>
						
					</h3>
					<p id="dev">
						<%=cumin.getDevUnderstanding()%>


					</p>


				</div>

			</div>
		</div>

		<div class="row">
			<div class="container" height="50px">

				<div class="jumbotron" style="height: auto;
    min-height: 206px;">
					<h3 style="margin-top: -54px">
						Subtask:
					</h3>

					<p id="sub">
					<ul style="position: absolute">
						<c:forEach var="lists" items="${description}">
							<li style="margin-left:414px">${lists}</li>

						</c:forEach>
					</ul>
					</p>
				</div>
				<div class="jumbotron" style="height: 40px">
					<h3 style="margin-top: -54px">
						Work Log:
						<button class="btn" onclick="editable3()"
							style="font-size: 20px; background-color: transparent">
							<i class="fa fa-pencil"></i>
						</button>
						<button id="workLog" title="save" onclick="WorkLogEdit();"
							class="btn"
							style="font-size: 20px; background-color: transparent" hidden>
							<i class="fa fa-floppy-o"></i>
						</button>
					</h3>

					<%
						if (cumin.getLog_work() != null) {
					%>
					<p id="Log"><%=cumin.getLog_work()%></p>

						<%
						}
					%>
					
				</div>

			</div>
		</div>
</body>
</html>

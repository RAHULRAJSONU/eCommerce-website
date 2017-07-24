<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="bootstrap" value="/assets/bootstrap/" />
<spring:url var="theme" value="/assets/themes/" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>eCart- ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>
<!-- Bootstrap Core CSS -->
<link href="${bootstrap}/css/bootstrap.min.css" rel="stylesheet">
<link href="${bootstrap}/css/font-awesome.css" rel="stylesheet"
	type="text/css">
<!-- themes -->
<link href="${bootstrap}/themes/dark/dark.css" rel="stylesheet" />


<!-- Custom CSS -->
<link href="${bootstrap}/css/shop-homepage.css" rel="stylesheet">
<link href="${bootstrap}/css/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Home</a>
				</div>
			</div>
		</nav>
		<!-- Page Content -->
		<div class="content">
			<div class="container">
				<%-- this will be displayed if the credentials are wrong --%>
				<c:if test="${not empty message}">
					<div class="row">

						<div class="col-md-offset-3 col-md-6">

							<div class="alert alert-danger">${message}</div>

						</div>
					</div>

				</c:if>
				<%-- this will be displayed only when user has logged out --%>
				<c:if test="${not empty logout}">
					<div class="row">

						<div class="col-md-offset-3 col-md-6">

							<div class="alert alert-success">${logout}</div>

						</div>
					</div>

				</c:if>


				<div class="row">

					<div class="col-md-offset-3 col-md-6">

						<div class="panel panel-primary">

							<div class="panel-heading">
								<h4>Login</h4>
							</div>

							<div class="panel-body">
								<form action="${contextRoot}/login" method="POST"
									class="form-horizontal" id="loginForm">
									<div class="form-group">
										<label for="username" class="col-md-4 control-label">Email:
										</label>
										<div class="col-md-8">
											<input type="text" name="username" id="username"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-md-4 control-label">Password:
										</label>
										<div class="col-md-8">
											<input type="password" name="password" id="password"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-offset-4 col-md-8">
											<input type="submit" value="Login" class="btn btn-primary" />
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</div>
									</div>
								</form>

							</div>
							<div class="panel-footer">
								<div class="text-right">
									New User - <a href="${contextRoot}/register">Register Here</a>
								</div>
							</div>
						</div>

					</div>

				</div>

			</div>

		</div>
		<!-- </div> -->
		<!-- /.container -->
		<!-- footer-->
		<%@include file="./shared/footer.jsp"%>
		<!-- /.container -->
	</div>
	<!-- jQuery -->
	<script src="${bootstrap}/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${bootstrap}/js/bootstrap.min.js"></script>
	<script src="${bootstrap}/js/app.js" type="text/javascript"></script>
	<!-- active pluggin -->
	<script src="${bootstrap}/js/activemenu.js" type="text/javascript"></script>
	<!-- themes js -->
	<script src="${bootstrap}/themes/dark/darkjs.js" type="text/javascript"></script>
	<!-- jQuery validation-->
	<script src="${bootstrap}/js/jquery.validate.js"></script>

	</div>
</body>

</html>

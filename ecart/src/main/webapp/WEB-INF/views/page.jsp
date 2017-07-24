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
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>eCart- ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>
<!-- Bootstrap Core CSS -->
<link href="${bootstrap}/css/bootstrap.min.css" rel="stylesheet">
<link href="${bootstrap}/css/dataTables.bootstrap.css" rel="stylesheet" />
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
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<c:if test="${userClickCategoryProduct==true}">
				<%@include file="products.jsp"%>
			</c:if>

			<c:if test="${userClickViewProduct==true}">
				<%@include file="product_details.jsp"%>
			</c:if>
			<!-- Manage Products -->
			<c:if test="${userClickManageProducts==true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>

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
	<script src="${bootstrap}/js/jquery.dataTables.js"
		type="text/javascript"></script>
	<script src="${bootstrap}/js/dataTables.bootstrap.js"
		type="text/javascript"></script>
	<script src="${bootstrap}/js/app.js" type="text/javascript"></script>
	<!-- active pluggin -->
	<script src="${bootstrap}/js/activemenu.js" type="text/javascript"></script>
	<!-- bootbox pluggin -->
	<script src="${bootstrap}/js/bootbox.min.js" type="text/javascript"></script>
	<!-- themes js -->
	<script src="${bootstrap}/themes/dark/darkjs.js" type="text/javascript"></script>
	<!-- jQuery validation-->
	<script src="${bootstrap}/js/jquery.validate.js"></script>
	
	</div>
</body>

</html>

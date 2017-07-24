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
		<%@include file="flows-navbar.jsp" %>
		<!-- Page Content -->
		<div class="content">
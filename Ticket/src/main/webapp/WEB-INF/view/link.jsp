<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../static/css/style.css" />
<title>Link do biletu</title>

</head>
<body class="tlo">
	<div role="navigation">
		<nav class="navbar navbar-inverse bg-inverse navbar-toggleable-md">
			<a class="navbar-brand" href="/home">Home</a>
			<ul class="nav navbar-nav">
				<li><a href="/szukaj">Szukaj</a></li>
				<li><a href="/movies">Filmy</a></li>
				<li><a href="/pobierzBilet">Pobierz bilet</a></li>
			</ul>
		</nav>
	</div>

	<div class="container">
		<div class="text-center">
			<h2 class="h">Zarezerwowałeś/aś bilet!</h2>
			<p>Zachowaj link do pobrania biletu!</p>
			<input name="link" size=30 value="${adr}" readonly />
			<br/>
			<br/>
			<a href="/home"><button type="button" class="btn btn-primary">Powrót</button></a>
		</div>
	</div>

	<div id="footer">
		<p id="date"></p>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../static/js/script.js"></script>
</body>
</html>
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
<link href="static/css/style.css" rel="stylesheet">
<title>Home</title>
</head>
<body>
	<div role="navigation">
		<nav class="navbar navbar-inverse bg-inverse navbar-toggleable-md">
			<a class="navbar-brand" href="/home">Home</a>
			<ul class="nav navbar-nav">
				<li><a href="#">Szukaj</a></li>
				<li><a href="/movies">Filmy</a></li>
				<li><c:choose>
						<c:when test="${not empty power}">
							<a href="#">Edycja</a>
						</c:when>
					</c:choose></li>
			</ul>
		</nav>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_TICKETS'}">
			<div class="container" id="homediv">
				<div class="container">
					<h3>Lista biletów</h3>
					<div class="table-responsive">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Imie</th>
									<th>Nazwisko</th>
									<th>Film</th>
									<th>Rodzaj</th>
									<th>Cena</th>
									<th>Miejsce</th>
									<th>Opcje</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="bilet" items="${bilety}">
									<tr>
										<td>${bilet.imie}</td>
										<td>${bilet.nazwisko}</td>
										<td>${bilet.film.tytul}</td>
										<td>${bilet.rodzaj.nazwa}</td>
										<td>${bilet.rodzaj.cena} zł</td>
										<td>${bilet.miejsce}</td>
										<td><a href="/del-ticket?id=${bilet.id}"><span
												class="glyphicon glyphicon-trash"></span></a> &nbsp; <a
											href="#"><span
												class="glyphicon glyphicon-pencil"></span></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<a href="./home">Strona główna</a>
					</div>
				</div>
			</div>
		</c:when>
	</c:choose>


	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>
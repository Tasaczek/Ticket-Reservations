<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<title>Home</title>
</head>
<body>
	<div role="navigation">
		<nav class="navbar navbar-inverse bg-inverse navbar-toggleable-md">
			<a class="navbar-brand" href="/home">Home</a>
			<ul class="nav navbar-nav">
				<li><a href="#">Szukaj</a></li>
				<li><a href="/movies">Filmy</a></li>
			</ul>
		</nav>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_TIMES'}">
			<div class="container" id="homediv">
				<div class="text-center">
					<h3>Lista terminów</h3>
					<div class="table-responsive">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Godzina</th>
									<th>Dzień</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="termin" items="${terminy}">
									<tr>
										<td>${termin.godzina}</td>
										<td>${termin.dzien}</td>
										<td><a href="#"><span
												class="glyphicon glyphicon-trash"></span></a> &nbsp;&nbsp;
 										<a href="#"><span
												class="glyphicon glyphicon-pencil"></span></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<a href="#">Dodaj termin</a><br /> 
						<a href="./home">Strona główna</a>
					</div>
				</div>
			</div>
		</c:when>
	</c:choose>


	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>
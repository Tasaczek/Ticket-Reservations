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
<title>Reżyserzy</title>

</head>
<body>
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
	
	<c:choose>
		<c:when test="${mode=='MODE_DIRECTORS'}">
			<div class="container"v">
				<div class="text-center">
					<h2 class="h">Szukaj według reżyserów</h2>
					<div class="table-responsive">
						<table class="table table-striped table-bordered tb">
							<thead>
								<tr>
									<th class="text-center">Reżyser</th>
									<th class="text-center">Wybierz</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="rezyser" items="${rezyserzy}">
									<tr>
										<td>${rezyser.imie}&nbsp;${rezyser.nazwisko}</td>
										<td><a href="/wybierz?id=${rezyser.id}&t=r"><span class="glyphicon glyphicon-hand-left"></span></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<a href="/home"><button type="button" class="btn btn-primary">Powrót</button></a>
					</div>
				</div>
			</div>
		</c:when>
	</c:choose>

	<div id="footer">
		<p id="date"></p>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../static/js/script.js"></script>
</body>
</html>
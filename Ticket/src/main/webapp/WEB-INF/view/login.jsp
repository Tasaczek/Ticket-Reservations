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
			<a class="navbar-brand" href="/main">Home</a>
			<ul class="nav navbar-nav">
				<li><a href="#">Looking for</a></li>
				<li><a href="#">Films</a></li>
				<li>
					<c:choose>
						<c:when test="${not empty loggedInUser}">
										Hello ${loggedInUser}!
						</c:when>
					</c:choose>
				</li>
				<li>
					<c:choose>
						<c:when test="${not empty loggedInUser}">
										<a href="/logout">Logout</a>
						</c:when>
					</c:choose>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</nav>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_LOGIN'}">
			<div class="container text-center">
				<form class="form-horizontal" method="POST"
					action="/login-uzytkownik">
					<c:if test="${not empty error}">
						<div class="alert alert-danger">
							<c:out value="${error}"></c:out>
						</div>
					</c:if>
					<div class="form-group row">
						<label class="col-form-label col-md-2">Login</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${users.username}" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-form-label col-md-2">Hasło</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="password"
								value="${users.password}" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>

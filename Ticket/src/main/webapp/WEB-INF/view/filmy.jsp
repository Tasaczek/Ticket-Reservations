<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Home</title>
<style>
.ekran {
	font-size: 25px;
	background-color: #2222AA;
	color: white;
	width: 90%;
	margin-bottom: 25px;
}

.fotel_rz {
	text-align: center;
	width: 510px;
	background: #e0e0e0;
	clear: both;
}

.fotel {
	width: 20px;
	font-size: 10px;
	font-family: "Tahoma";
	display: inline-block;
	border-style: solid;
	border-width: 1px;
	border-color: black;
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-khtml-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	cursor: pointer;
	cursor: hand;
	margin-top: 2px;
	margin-left: 2px;
	padding: 1px;
	background: lightgray;
	color: black;
}

.fotel_nr {
	width: 18px;
	font-weight: bold;
	font-size: 12px;
	font-family: "Tahoma";
	display: inline-block;
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-khtml-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	cursor: default;
	color: #FC2D1B;
	margin-right: 4px;
	margin-top: 2px;
	margin-left: 4px;
	padding: 1px;
}

@media ( min-width : 979px) {
	.fotel_rz {
		width: 700px;
	}
	.fotel, .fotel_nr {
		width: 22px;
		font-size: 12px;
	}
}

.fotel {
	color: rgba(38, 38, 00, 1);
	border-color: rgba(38, 38, 0, 1);
	background-color: rgba(103, 153, 85, 1);
}

.ekran {
	text-align: center;
	background: black;
	clear: both;
	color: silver;
	padding: 2px;
	margin-top: 0px;
	margin-bottom: 0px;
}
.w {
	border-color: rgba(38, 38, 0, 1);
	background-color: rgba(120, 170, 60, 1);
}
</style>

<script>
	var set = false,reserved=false;
	var oldValue;
	var m;


	$(document).ready(function() {
		for (var i = 1; i < 101; i++) {
			
			if(i == 3 || i == 7 || i== 11){
				$(".fotel#"+i+"").css("background-color", "red");
				$(".fotel#"+i+"").css("pointer-events", "none");
			}
			
			 $(".fotel#"+i+"").click(function() {
				if (set==false && reserved==false) {
					$(this).css("background-color", "yellow");
					var m = $(this).attr("id");
					oldValue=m;
					$("#miejsce").attr('value', parseInt(m));
					set = true;			
				} 
				else if (set==true && reserved==false) {
					var m = $(this).attr("id");
					if(m==oldValue){
						$(this).removeAttr('style');
						$("#miejsce").removeAttr('value');					
						set = false;	
					}
				}
			}); 	
		}
	});
</script>
</head>
<body>
	${rezerwacje}
	<div role="navigation">
		<nav class="navbar navbar-inverse bg-inverse navbar-toggleable-md">
			<a class="navbar-brand" href="/home">Home</a>
			<ul class="nav navbar-nav">
				<li><a href="#">Looking for</a></li>
				<li><a href="/movies">Films</a></li>
				<li><c:choose>
						<c:when test="${not empty power}">
							<a href="#">Edycja</a>
						</c:when>
					</c:choose></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><c:choose>
						<c:when test="${empty loggedInUser}">
							<a href="#"><span class="glyphicon glyphicon-user"></span>Sign
								Up</a>
						</c:when>
					</c:choose></li>
				<li><c:choose>
						<c:when test="${not empty loggedInUser}">
							<a href="#"><span class="glyphicon glyphicon-user"></span>Hello
								${loggedInUser}!</a>

						</c:when>
					</c:choose></li>
				<li><c:choose>
						<c:when test="${empty loggedInUser}">
							<a href="/login"><span class="glyphicon glyphicon-log-in"></span>Login</a>
						</c:when>
					</c:choose></li>
				<li><c:choose>
						<c:when test="${not empty loggedInUser}">
							<a href="/logout">Logout</a>
						</c:when>
					</c:choose></li>
			</ul>
		</nav>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_MOVIES'}">
			<div class="container" id="homediv">
				<div class="container text-center">
					<h3>Lista filmów</h3>
					<div class="table-responsive">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Tytuł</th>
									<th>Opis</th>
									<th>Wersja</th>
									<th>Gatunek</th>
									<th>Rezyser</th>
									<th>Termin</th>
									<th>Rezerwuj bilet</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="film" items="${filmy}">
									<tr>
										<td>${film.tytul}</td>
										<td>${film.opis}</td>
										<td>${film.wersja.nazwa}</td>
										<td>${film.gatunek.nazwa}</td>
										<td>${film.rezyser.imie} ${film.rezyser.nazwisko}</td>
										<td>${film.termin.dzien} ${film.termin.godzina}</td>
										<td><a href="/reservations?id=${film.id}"> <span
												class="glyphicon glyphicon-ok"></span></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<a href="./home">Strona główna</a>
					</div>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_RESERVATIONS'}">
			<h1>Rezerwuj bilet</h1>
			<form method="post" action="/reservations">
				<p>
					Imię: <input type="text" name="imie" maxlength="25" required />
				</p>
				<p>
					Nazwisko: <input type="text" name="nazwisko" maxlength="50"
						required />
				</p>
				<p>
					Film: ${film.tytul} [${film.gatunek.nazwa}]<input type="hidden"
						name="film" value="${film.id}" />
				</p>
				<p>
					Rodzaj: <select name="rodzaj" required>
						<c:forEach var="lista" items="${rodzaje}">
							<option value="${lista.id}">${lista.nazwa}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					Miejsce: <input type="text" name="miejsce" id="miejsce"
						maxlength="2" min="1" max="50" required>
				</p>
				<div class="row">
					<div class="span9">
						<div class="fotel_plan">
							<div class="fotel_rz" style="height: 10px"></div>
							<div class="ekran fotel_rz">Ekran</div>
							<div class="fotel_rz" style="height: 10px"></div>
							<div class="fotel_rz">
								<span class="fotel w" data-id="" id="1">1</span> <span
									class="fotel w" data-id="" id="2">2</span> <span
									class="fotel w" data-id="" id="3">3</span> <span
									class="fotel w" data-id="" id="4">4</span> <span
									class="fotel w" data-id="" id="5">5</span> <span
									class="fotel w" data-id="" id="6">6</span> <span
									class="fotel w" data-id="" id="7">7</span> <span
									class="fotel w" data-id="" id="8">8</span> <span
									class="fotel w" data-id="" id="9">9</span> <span
									class="fotel w" data-id="" id="10">10</span> <span
									class="fotel w" data-id="" id="11">11</span> <span
									class="fotel w" data-id="" id="12">12</span> <span
									class="fotel w" data-id="" id="13">13</span> <span
									class="fotel w" data-id="" id="14">14</span> <span
									class="fotel w" data-id="" id="15">15</span> <span
									class="fotel w" data-id="" id="16">16</span> <span
									class="fotel w" data-id="" id="17">17</span> <span
									class="fotel w" data-id="" id="18">18</span> <span
									class="fotel w" data-id="" id="19">19</span> <span
									class="fotel w" data-id="" id="20">20</span>
							</div>
							<div class="fotel_rz">
								<span class="fotel w" data-id="" id="21">21</span> <span
									class="fotel w" data-id="" id="22">22</span> <span
									class="fotel w" data-id="" id="23">23</span> <span
									class="fotel w" data-id="" id="24">24</span> <span
									class="fotel w" data-id="" id="25">25</span> <span
									class="fotel w" data-id="" id="26">26</span> <span
									class="fotel w" data-id="" id="27">27</span> <span
									class="fotel w" data-id="" id="28">28</span> <span
									class="fotel w" data-id="" id="29">29</span> <span
									class="fotel w" data-id="" id="30">30</span> <span
									class="fotel w" data-id="" id="31">31</span> <span
									class="fotel w" data-id="" id="32">32</span> <span
									class="fotel w" data-id="" id="33">33</span> <span
									class="fotel w" data-id="" id="34">34</span> <span
									class="fotel w" data-id="" id="35">35</span> <span
									class="fotel w" data-id="" id="36">36</span> <span
									class="fotel w" data-id="" id="37">37</span> <span
									class="fotel w" data-id="" id="38">38</span> <span
									class="fotel w" data-id="" id="39">39</span> <span
									class="fotel w" data-id="" id="40">40</span>
							</div>
							<div class="fotel_rz">
								<span class="fotel w" data-id="" id="41">41</span> <span
									class="fotel w" data-id="" id="42">42</span> <span
									class="fotel w" data-id="" id="43">43</span> <span
									class="fotel w" data-id="" id="44">44</span> <span
									class="fotel w" data-id="" id="45">45</span> <span
									class="fotel w" data-id="" id="46">46</span> <span
									class="fotel w" data-id="" id="47">47</span> <span
									class="fotel w" data-id="" id="48">48</span> <span
									class="fotel w" data-id="" id="49">49</span> <span
									class="fotel w" data-id="" id="50">50</span> <span
									class="fotel w" data-id="" id="51">51</span> <span
									class="fotel w" data-id="" id="52">52</span> <span
									class="fotel w" data-id="" id="53">53</span> <span
									class="fotel w" data-id="" id="54">54</span> <span
									class="fotel w" data-id="" id="55">55</span> <span
									class="fotel w" data-id="" id="56">56</span> <span
									class="fotel w" data-id="" id="57">57</span> <span
									class="fotel w" data-id="" id="58">58</span> <span
									class="fotel w" data-id="" id="59">59</span> <span
									class="fotel w" data-id="" id="60">60</span>
							</div>
							<div class="fotel_rz">
								<span class="fotel w" data-id="" id="61">61</span> <span
									class="fotel w" data-id="" id="62">62</span> <span
									class="fotel w" data-id="" id="63">63</span> <span
									class="fotel w" data-id="" id="64">64</span> <span
									class="fotel w" data-id="" id="65">65</span> <span
									class="fotel w" data-id="" id="66">66</span> <span
									class="fotel w" data-id="" id="67">67</span> <span
									class="fotel w" data-id="" id="68">68</span> <span
									class="fotel w" data-id="" id="69">69</span> <span
									class="fotel w" data-id="" id="70">70</span> <span
									class="fotel w" data-id="" id="71">71</span> <span
									class="fotel w" data-id="" id="72">72</span> <span
									class="fotel w" data-id="" id="73">73</span> <span
									class="fotel w" data-id="" id="74">74</span> <span
									class="fotel w" data-id="" id="75">75</span> <span
									class="fotel w" data-id="" id="76">76</span> <span
									class="fotel w" data-id="" id="77">77</span> <span
									class="fotel w" data-id="" id="78">78</span> <span
									class="fotel w" data-id="" id="79">79</span> <span
									class="fotel w" data-id="" id="80">80</span>
							</div>
							<div class="fotel_rz">
								<span class="fotel w" data-id="" id="81">81</span> <span
									class="fotel w" data-id="" id="82">82</span> <span
									class="fotel w" data-id="" id="83">83</span> <span
									class="fotel w" data-id="" id="84">84</span> <span
									class="fotel w" data-id="" id="85">85</span> <span
									class="fotel w" data-id="" id="86">86</span> <span
									class="fotel w" data-id="" id="87">87</span> <span
									class="fotel w" data-id="" id="88">88</span> <span
									class="fotel w" data-id="" id="89">89</span> <span
									class="fotel w" data-id="" id="90">90</span> <span
									class="fotel w" data-id="" id="91">91</span> <span
									class="fotel w" data-id="" id="92">92</span> <span
									class="fotel w" data-id="" id="93">93</span> <span
									class="fotel w" data-id="" id="94">94</span> <span
									class="fotel w" data-id="" id="95">95</span> <span
									class="fotel w" data-id="" id="96">96</span> <span
									class="fotel w" data-id="" id="97">97</span> <span
									class="fotel w" data-id="" id="98">98</span> <span
									class="fotel w" data-id="" id="99">99</span> <span
									class="fotel w" data-id="" id="100">100</span>
							</div>
						</div>
					</div>
				</div>
				
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Film</th>
								<th>Zajęte miejsca</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="r" items="${rezerwacje}">
								<tr>
									<td>${r.film.tytul}</td>
									<td>${r.miejsce}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
					
				<br /> <input type="submit" value="Rezerwuj" />
			</form>
		</c:when>
	</c:choose>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>
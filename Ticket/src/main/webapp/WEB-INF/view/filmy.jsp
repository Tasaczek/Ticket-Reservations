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
										<td>${film.rezyser.imie}&nbsp${film.rezyser.nazwisko}</td>
										<td>${film.termin.dzien}&nbsp${film.termin.godzina}</td>
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
			<div class="container" id="homediv">
				<h1>Rezerwuj bilet</h1>
				<form name="form1" method="post" action="/reservations" onsubmit="return validateForm()">
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
						<%--Miejsce: --%>
						<input type="hidden" name="miejsce" id="miejsce" required>
					</p>
					<div class="row">
						<div class="span9">
							<div class="fotel_plan">
								<div class="fotel_rz" style="height: 10px"></div>
								<div class="ekran fotel_rz">Wybierz miejsce [Ekran]</div>
								<div class="fotel_rz" style="height: 10px"></div>
								<div class="fotel_rz">
									<span class="fotel w" id="1">1</span> 
									<span class="fotel w" id="2">2</span> 
									<span class="fotel w" id="3">3</span>
								    <span class="fotel w" id="4">4</span> 
									<span class="fotel w" id="5">5</span> 
									<span class="fotel w" id="6">6</span> 
									<span class="fotel w" id="7">7</span> 
									<span class="fotel w" id="8">8</span>
									<span class="fotel w" id="9">9</span> 
									<span class="fotel w" id="10">10</span>
									<span class="fotel w" id="11">11</span>
									<span class="fotel w" id="12">12</span>
									<span class="fotel w" id="13">13</span>
									<span class="fotel w" id="14">14</span> 
									<span class="fotel w" id="15">15</span>
									<span class="fotel w" id="16">16</span> 
									<span class="fotel w" id="17">17</span>
									<span class="fotel w" id="18">18</span>
									<span class="fotel w" id="19">19</span>
									<span class="fotel w" id="20">20</span>
								</div>
								<div class="fotel_rz">
									<span class="fotel w" id="21">21</span> 
									<span class="fotel w" id="22">22</span> 
									<span class="fotel w" id="23">23</span>
								    <span class="fotel w" id="24">24</span> 
									<span class="fotel w" id="25">25</span> 
									<span class="fotel w" id="26">26</span> 
									<span class="fotel w" id="27">27</span> 
									<span class="fotel w" id="28">28</span>
									<span class="fotel w" id="29">29</span> 
									<span class="fotel w" id="30">30</span>
									<span class="fotel w" id="31">31</span>
									<span class="fotel w" id="32">32</span>
									<span class="fotel w" id="33">33</span>
									<span class="fotel w" id="34">34</span> 
									<span class="fotel w" id="35">35</span>
									<span class="fotel w" id="36">36</span> 
									<span class="fotel w" id="37">37</span>
									<span class="fotel w" id="38">38</span>
									<span class="fotel w" id="39">39</span>
									<span class="fotel w" id="40">40</span>
								</div>
								<div class="fotel_rz">
									<span class="fotel w" id="41">41</span> 
									<span class="fotel w" id="42">42</span> 
									<span class="fotel w" id="43">43</span>
								    <span class="fotel w" id="44">44</span> 
									<span class="fotel w" id="45">45</span> 
									<span class="fotel w" id="46">46</span> 
									<span class="fotel w" id="47">47</span> 
									<span class="fotel w" id="48">48</span>
									<span class="fotel w" id="49">49</span> 
									<span class="fotel w" id="50">50</span>
									<span class="fotel w" id="51">51</span>
									<span class="fotel w" id="52">52</span>
									<span class="fotel w" id="53">53</span>
									<span class="fotel w" id="54">54</span> 
									<span class="fotel w" id="55">55</span>
									<span class="fotel w" id="56">56</span> 
									<span class="fotel w" id="57">57</span>
									<span class="fotel w" id="58">58</span>
									<span class="fotel w" id="59">59</span>
									<span class="fotel w" id="60">60</span>
								</div>
								<div class="fotel_rz">
									<span class="fotel w" id="61">61</span> 
									<span class="fotel w" id="62">62</span> 
									<span class="fotel w" id="63">63</span>
								    <span class="fotel w" id="64">64</span> 
									<span class="fotel w" id="65">65</span> 
									<span class="fotel w" id="66">66</span> 
									<span class="fotel w" id="67">67</span> 
									<span class="fotel w" id="68">68</span>
									<span class="fotel w" id="69">69</span> 
									<span class="fotel w" id="70">70</span>
									<span class="fotel w" id="71">71</span>
									<span class="fotel w" id="72">72</span>
									<span class="fotel w" id="73">73</span>
									<span class="fotel w" id="74">74</span> 
									<span class="fotel w" id="75">75</span>
									<span class="fotel w" id="76">76</span> 
									<span class="fotel w" id="77">77</span>
									<span class="fotel w" id="78">78</span>
									<span class="fotel w" id="79">79</span>
									<span class="fotel w" id="80">80</span>
								</div>
								<div class="fotel_rz">
									<span class="fotel w" id="81">81</span> 
									<span class="fotel w" id="82">82</span> 
									<span class="fotel w" id="83">83</span>
								    <span class="fotel w" id="84">84</span> 
									<span class="fotel w" id="85">85</span> 
									<span class="fotel w" id="86">86</span> 
									<span class="fotel w" id="87">87</span> 
									<span class="fotel w" id="88">88</span>
									<span class="fotel w" id="89">89</span> 
									<span class="fotel w" id="90">90</span>
									<span class="fotel w" id="91">91</span>
									<span class="fotel w" id="92">92</span>
									<span class="fotel w" id="93">93</span>
									<span class="fotel w" id="94">94</span> 
									<span class="fotel w" id="95">95</span>
									<span class="fotel w" id="96">96</span> 
									<span class="fotel w" id="97">97</span>
									<span class="fotel w" id="98">98</span>
									<span class="fotel w" id="99">99</span>
									<span class="fotel w" id="100">100</span>
								</div>
							</div>
						</div>
					</div>
					<br />
					<p>
						<font color="red"><b>Czerwony</b></font> - miejsce zarezerwowane
					</p>
					<p>
						<font color="green"><b>Zielony</b></font> - miejsce dostępne
					</p>
					<p>
						<font color="yellow"><b>Żółty</b></font> - miejsce wybrane przez użytkownika
					</p>
					<br />
					<button type="submit" class="btn btn-success">Rezerwuj</button>
					<a href="/movies"><button type="button" class="btn btn-warning">Powrót</button></a>
				</form>
			</div>
		</c:when>
	</c:choose>

	<input id="comp" type="hidden" value="${rezerwacje}" />
	<%-- dla pobrania wartosci z javy przez js'a --%>

	<script src="static/js/bootstrap.min.js"></script>
</body>
<script>
	var set = false; // klik/!klik
	var oldValue;
	var m;
	var reserved = document.getElementById("comp").value; //to odzielenia liczb z tablicy z javy do js
	var e1 = reserved.replace("[", "");
	var e2 = e1.replace("]", "");
	var e3 = e2.split(",");

	$(document).ready(function() { //blokada zarezerwowanych miejsc wczesniej
		for (var i = 1; i < 101; i++) {
			for (let x = 0; x <= e3.length; x++) {
				if (i == e3[x]) {
					$(".fotel#" + i + "").css("background-color", "red");
					$(".fotel#" + i + "").css("pointer-events", "none");
				}
			}

			$(".fotel#" + i + "").click(function() { //wybor miejsca z dostepnych obecnie
				if (set == false) {
					$(this).css("background-color", "yellow");
					var m = $(this).attr("id");
					oldValue = m;
					$("#miejsce").attr('value', parseInt(m));
					set = true;
				} else if (set == true) {
					var m = $(this).attr("id");
					if (m == oldValue) {
						$(this).removeAttr('style');
						$("#miejsce").removeAttr('value');
						set = false;
					}
				}
			});
		}
	});
	
	function validateForm(){
		var x = document.forms["form1"]["miejsce"].value;
		if(x==""){
			alert("Wybierz miejsce!");
			return false;
		}
	}
</script>
</html>
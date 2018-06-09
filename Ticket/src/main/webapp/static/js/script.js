// część danych dla stworzenia danych w stopce
const monthNames = ["Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec",
			  "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"
			];
	
	n = new Date();
	y = n.getFullYear();
	d = n.getDate();
	if(d<10) d = "0" + d;

	document.getElementById("date").innerHTML ="Aktualna data: " + d + " " + monthNames[n.getMonth()] + " " + y;

// rezerwacja miejsca

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
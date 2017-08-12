function verifica_date () {
	var parola = $("#parola_1").val();
	var check_parola = $("#parola_2").val();

	if( parola.length < 4 ){
		$("#error_message").show();
		$(".signup_message").empty().append("* Parola dvs. este prea mica, incercati ceva mai complex!");

		$("#parola_1").val("");
		$("#parola_2").val("");

		$("#parola_1").focus();

		return false;
	}

	if( parola != check_parola){
		$("#error_message").show();
		$(".signup_message").empty().append("* Parolele nu corespund, mai incercati inca odata cu atentie!");
		$("#parola_1").val("");
		$("#parola_2").val("");

		$("#parola_1").focus();

		return false;

	}else{

		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				document.getElementById("mesaj_salut").innerHTML = xhttp.responseText;
			}
		};
		xhttp.open("POST","add-user/?"+"username="+$("#username").val()+"&telefon="+$("#telefon").val()+"&email="+$("#email_sign").val()+"&parola="+$("#parola_1").val(), true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send();
		
		$("#formRegister").hide();
		
		//document.getElementById('testForm').submit();
		return true;
	}
};


function login_user()
{
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			document.getElementById("mesaj_salut").innerHTML = xhttp.responseText;
			
			setTimeout(function(){ window.location.href = "http://localhost:8080/ProiectInchirieriFilme/"; }, 5000);
		}
	};
	xhttp.open("POST","login-user/?"+"username="+$("#username").val()+"&parola="+$("#parola").val(), true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send();
	
	$("#formRegister").hide();
	
	//document.getElementById('testForm').submit();
	return true;
};


function logout_user()
{
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			//document.getElementById("mesaj_salut").innerHTML = xhttp.responseText;
			
			window.location.href = "http://localhost:8080/ProiectInchirieriFilme/";
		}
	};
	xhttp.open("POST","logout-user", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send();
	
	
};


function adauga_produs(id_film)
{
	
	if(session_loged)
	{
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				
				location.reload();
			}
		};
		xhttp.open("GET","adauga-produs/?id_film="+id_film, true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send();
	}
	else
		{
			if(confirm("Trebuie sa va autentificati pentru a putea adauga in cos.\n Multumim pentru intelegere."))
			{
				window.location.href = "http://localhost:8080/ProiectInchirieriFilme/login.jsp";
			}
		}
	

}





var session_loged;

window.onload = function() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			
			 if(xhttp.responseText == 0)
			 {
				session_loged= false;
			 }
			 else
			 {
				 session_loged = true;
				 $('#cart').empty();
				 document.getElementById("cart").innerHTML = xhttp.responseText;
			 }
		}
	};
	xhttp.open("GET","login-user/", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send();
			
};

function getCat(tip)
{
	document.getElementById("category").value = tip;
	document.getElementById("categorieFilm").submit();
}



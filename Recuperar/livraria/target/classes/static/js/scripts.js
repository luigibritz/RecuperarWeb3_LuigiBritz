function login() {
	var usuario = document.getElementById("usuario").value;
	var senha = document.getElementById("senha").value;
	if(usuario != "admin"||senha != "admin"){
		window.location.href = "localhost://login.html";
	}
	else{
		window.location.href = "localhost://index.html";
	}
}
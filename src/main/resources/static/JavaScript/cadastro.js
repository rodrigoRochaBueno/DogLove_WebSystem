window.onload = function(){
		var lista = document.getElementById('cadastro');
		lista.style.display = "none";
		document.getElementById('cadastrar').onclick = function(){
		var lista = document.getElementById('lista');
		var cadastro = document.getElementById('cadastro');
		cadastro.style.display = "block";
		lista.style.display = "none";
	}
		document.getElementById('listar').onclick = function(){
		var lista = document.getElementById('lista');
		var cadastro = document.getElementById('cadastro');
		cadastro.style.display = "none";
		lista.style.display = "block";
	}
		
}

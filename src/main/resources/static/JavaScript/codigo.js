
window.onload = function(){
document.getElementById("btn").onclick = function(){
	var x = document.getElementById('nome');
	var y = document.getElementById('senha');
	
	if(x.value =="" || y.value==""){
		alert("ok");
		return(false)
	}else if(x.value != "admin" || y.value!="admin"){
		alert("pqp");
		var lb= document.createElement("label");
		var add = document.getElementById("pqp");
		lb.innerText="ok";
		add.appendChild(lb);
		return(false)
	}else{
		window.open("home.html");
	}		
  }
}
alert("funcionando");

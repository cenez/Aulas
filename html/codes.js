window.onload = function() {
	var randomico = document.getElementById("randomico");
	randomico.addEventListener("click", rand);

	var toUpperCase = document.getElementById("toUpperCase");
	toUpperCase.addEventListener("change", upperCase);

	if (navigator.cookieEnabled==true) {
		document.getElementById("cookie").innerHTML = "Cookies Estão Habilitados!!!!!!";
	} else {
		document.getElementById("cookie").innerHTML = "Cookies Estão Desabilitados!!!!!!";
	}
	
	function rand() {
		alert(Math.random());
		randomico.removeEventListener("click", rand);
	}
	function upperCase() {
		toUpperCase.value = toUpperCase.value.toUpperCase();
	}
};
function onSubmit(){
    alert(txtTexto.value);
}
function mOver(obj) {
	obj.innerHTML=":-) Blz!!"
}
function mOut(obj) {
	obj.innerHTML="Passar o mouse!"
}
function mDown(obj) {
	obj.style.backgroundColor="#1ec5e5";
	obj.innerHTML="Solte o clique"
} 
function mUp(obj) {
	obj.style.backgroundColor="#D94A38";
	obj.innerHTML="Clique aqui novamente"
}
function onFocus(){
	document.getElementById("txtInput").style.backgroundColor = "yellow";
}
function onBlur(){
	document.getElementById("txtInput").style.backgroundColor = "";
}
function onKeyDown(obj){
	document.getElementById("lblKeyDown").innerHTML = ": "+obj.value;
}
function onKeyPress(obj){
	document.getElementById("lblKeyPress").innerHTML = ": "+obj.value;
}
function onKeyUp(obj){
	document.getElementById("lblKeyUp").innerHTML = ": "+obj.value;
}


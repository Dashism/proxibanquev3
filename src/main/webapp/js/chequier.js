var title = $("#title")[0];
function validateChequier(event) {
	console.log("Evenement de soumission du form : ", event);
	if ((title.value == false) || (content.value == false)) {
		event.preventDefault();
		alert("Chequier en commande !");
	}
}
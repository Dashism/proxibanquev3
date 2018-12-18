function chequebook(event) {
	var selectedButton = event.target || event.currentTarget;
	selectedButton.style.display = "none";
	var accountId = selectedButton.id.split("-")[1];
	var account = {
			"id" : accountId
	};
	var send = JSON.stringify(account);
	$.ajax({
		url: "http://localhost:8080/proxibanquev3/webservices/json",
		type: "POST",
		contentType: 'application/json',
		data: send,
		dataType: 'json'
	}).done(function(status) {
//		var result = document.getElementById("result-"+accountId);
		if (status.valid) {
			$("#result-"+accountId).append($("<h6 style='color:purple'>"+status.message+"</h6>"));
		} else {
			$("#result-"+accountId).append($("<h6 style='color:orange'>"+status.message+"</h6>"));
		}
	});
}
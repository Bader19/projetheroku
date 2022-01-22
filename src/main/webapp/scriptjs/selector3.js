$(document).ready(function() {




	$.ajax({
		url: "ClientsController",
		data: { op: "load" },
		type: 'post',

		success: function(data, textStatus, jqXHR) {
			console.log(JSON.stringify(data))
			remplir1(data);

		},
		error: function(jqXHR, textStatus, errorthrown) {
			alert(textStatus);


		}

	});
 

	function remplir1(data) {
		var ligne = "";
		for (var i = 0; i < data.length; i++) {
			ligne += "<option>" + data[i].id + "</option>";
		}
		$("#Idclient").html(ligne);
	}
});
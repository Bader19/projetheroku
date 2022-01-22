$(document).ready(function() {




	$.ajax({
		url: "SalleController",
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
		var ligne = "<option selected='true' disabled='disabled'>Choisir une salle</option>";
		for (var i = 0; i < data.length; i++) {
		 
			ligne += "<option name ='id3' id='indx3'>" + data[i].id + "</option>";
		}
		$("#Idsalle").html(ligne);
	}
});
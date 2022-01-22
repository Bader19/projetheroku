$(document).ready(function() {

	$.ajax({
		url: "ClientsController",
		data: { op: "load" },
		type: 'post',

		success: function(data, textStatus, jqXHR) {
			console.log(JSON.stringify(data))
			remplir(data);
		},
		error: function(jqXHR, textStatus, errorthrown) {
			alert(textStatus);

		}

	});
	$("#add").click(function() {
		var nom = $("#Nom").val();
		var prenom = $("#Prenom").val();
		 

		console.log(nom + " " + prenom + " " );
		$.ajax({
			url: "ClientsController",
			data: { Nom:nom , Prenom:prenom },
			type: 'post',

			success: function(data, textStatus, jqXHR) {
				console.log(JSON.stringify(data))
				remplir(data);
			},
			error: function(jqXHR, textStatus, errorthrown) {
				alert(textStatus);
				 

			}

		});

	});

	$("#content").on("click", ".delete", function() {
		//alert($(this).attr('val'));
		var id = $(this).closest('tr').find('td').eq(0).text();
		$.ajax({
			url: "ClientsController",
			data: { op: "delete", id: id },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				remplir(data);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});
	});
	$("#content").on("click", ".update", function() {
		//alert($(this).attr('val'));
		var nom = $("#Nom").val();
		var prenom = $("#Prenom").val();
		 
		var id = $(this).closest('tr').find('td').eq(0).text();
		$.ajax({
			url: "ClientsController",
			data: { op: "update", id: id, Nom:nom , Prenom: prenom },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				remplir(data);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});
	});
	function remplir(data) {
		var ligne = "";
		for (var i = 0; i < data.length; i++) {
			ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].nom + "</td><td>" + data[i].prenom + "</td><td><button type='button'  class='btn btn-danger delete' val='" + data[i].id + "'>Supprimer</button></td><td><button type='button'   class='btn btn-warning update'>Update</button></td></tr>";
		}
		$("#content").html(ligne);
	}
});
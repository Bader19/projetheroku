$(document).ready(function() {




	$.ajax({
		url: "CrenomController",
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
		var HeureDebut = $("#HeureDebut").val();
		var HeureFin = $("#HeureFin").val();


		console.log(HeureFin + " " + HeureDebut + " ");
		$.ajax({
			url: "CrenomController",
			data: { HeureDebut: HeureDebut, HeureFin: HeureFin },
			type: 'post',

			success: function(data, textStatus, jqXHR) {
				console.log(JSON.stringify(data));
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
			url: "CrenomController",
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
		var HeureDebut = $("#HeureDebut").val();
		var HeureFin = $("#HeureFin").val();

		var id = $(this).closest('tr').find('td').eq(0).text();
		$.ajax({
			url: "CrenomController",
			data: { op: "update", id: id, HeureDebut: HeureDebut, HeureFin: HeureFin },
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
			ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].heureDebut + "</td><td>" + data[i].heureFin + "</td><td><button type='button'  class='btn btn-danger delete' val='" + data[i].id + "'>Supprimer</button></td><td><button type='button'   class='btn btn-warning update'>Update</button></td></tr>";
		}
		$("#content").html(ligne);
	}
 
});
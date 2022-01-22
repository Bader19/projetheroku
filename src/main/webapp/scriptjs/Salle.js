$(document).ready(function() {
 



	$.ajax({
		url: "SalleController",
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
		var Code = $("#Code").val();
		var Capacite = $("#Capacite").val();
		var Type = $("#Type").val();

		console.log(Code + " " + Capacite + " " + Type);
		$.ajax({
			url: "SalleController",
			data: { Code1: Code, Capacite1: Capacite, Type1: Type },
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
			url: "SalleController",
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
		var Code = $("#Code").val();
		var Capacite = $("#Capacite").val();
		var Type = $("#Type").val();
		var id = $(this).closest('tr').find('td').eq(0).text();
		$.ajax({
			url: "SalleController",
			data: { op: "update", id: id, Code1: Code, Capacite1: Capacite, Type1: Type },
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
			ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].code + "</td><td>" + data[i].capacite + "</td><td>" + data[i].type + "</td><td><button type='button'  class='btn btn-danger delete' val='" + data[i].id + "'>Supprimer</button></td><td><button type='button'   class='btn btn-warning update'>Update</button></td></tr>";
		}
		$("#content").html(ligne);
	}
	 
});
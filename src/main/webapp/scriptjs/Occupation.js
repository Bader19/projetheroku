
$(document).ready(function() {



	$.ajax({
		url: "OccupationController",
		data: { op: "load" },
		type: 'post',

		success: function(data, textStatus, jqXHR) {
			console.log(JSON.stringify(data));

			remplir(data);
		},
		error: function(jqXHR, textStatus, errorthrown) {
			alert(textStatus);


		}

	});
	$('input[type=date]').change(function() {
		var idsalle = $("#Idsalle option:selected").text();
		var date = $("#Date").val();
		alert(idsalle + "-" + date);
		$.ajax({
			url: "OccupationController",
			data: { op: "disponibilite", Date1: date, Idsalle1: idsalle},
			type: 'post',

			success: function(data, textStatus, jqXHR) {
				console.log(JSON.stringify(data))
 

				disponib(data);
			},
			error: function(jqXHR, textStatus, errorthrown) {
				alert(textStatus);


			}

		});
	});

	$('#Idsalle').change(function() {
		var idsalle = $("#Idsalle option:selected").text();
	 
		var date = $("#Date").val();
		alert(idsalle + "-"   + date);
		$.ajax({
			url: "OccupationController",
			data: { op: "disponibilite", Date1: date, Idsalle1: idsalle },
			type: 'post',

			success: function(data, textStatus, jqXHR) {
				console.log(JSON.stringify(data))
				 
				 disponib(data);

			},
			error: function(jqXHR, textStatus, errorthrown) {
				alert(textStatus);


			}

		});
	});

	$('#Idclient').change(function() {
		var idsalle = $("#Idsalle option:selected").text();
	 
		var date = $("#Date").val();
		alert(idsalle + "-" + date);
		$.ajax({
			url: "OccupationController",
			data: { op: "disponibilite", Date1: date,  Idsalle1: idsalle},
			type: 'post',

			success: function(data, textStatus, jqXHR) {
				console.log(JSON.stringify(data))
				 
				disponib(data);
			},
			error: function(jqXHR, textStatus, errorthrown) {
				alert(textStatus);


			}

		});

	});


	$("#add").click(function() {
		var idsalle = $("#Idsalle option:selected").text();
		var idcrenom = $("#Idcrenom option:selected").text();
		var Idclient = $("#Idclient option:selected").text();
		var date = $("#Date").val();
		alert(idsalle + "-" + idcrenom + "-" + Idclient + "-" + date);
		$.ajax({

			url: "OccupationController",
			data: { op: "addition", Date1: date, Idcrenom1: idcrenom, Idsalle1: idsalle, Idclient1: Idclient },
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

	$("#contentOccupation").on("click", ".delete1", function() {
		//alert($(this).attr('val'));
		var id = $(this).closest('tr').find('td').eq(0).text();
		$.ajax({
			url: "OccupationController",
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
	$("#contentOccupation").on("click", ".update1", function() {
		//alert($(this).attr('val'));
		var idsalle = $("#Idsalle option:selected").text();;
		var idcrenom = $("#Idcrenom option:selected").text();
		var date = $("#Date").val();
		var Idclient = $("#Idclient option:selected").text();
		var id = $(this).closest('tr').find('td').eq(0).text();
		alert(idsalle + "|" + idcrenom + "|" + date + "|" + id);
		$.ajax({
			url: "OccupationController",
			data: { op: "update", id: id, Date1: date, Idsalle1: idsalle, Idcrenom1: idcrenom, Idclient1: Idclient },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				remplir(data);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});
	});

	const convertTime12to24 = (time12h) => {
		const [time, modifier] = time12h.split(' ');

		let [hours, minutes] = time.split(':');

		if (hours === '12') {
			hours = '00';
		}

		if (modifier === 'PM') {
			hours = parseInt(hours, 10) + 12;
		}

		return `${hours}:${minutes}`;
	}

	$("#Idsalle").change(function() {

		var idsalle = $("#Idsalle option:selected").text();;
		var idcrenom = $("#Idcrenom option:selected").text();

		var date = $("#Date").val();
		let evenements = [];
		$.ajax({
			url: "OccupationController",
			data: { op: "load" },
			type: 'post',

			success: function(data, textStatus, jqXHR) {

				for (var i = 0; i < data.length; i++) {

					if (data[i].salle.id == idsalle) {


						var date = new Date(data[i].date);
						var d = date.getDate();
						var m = date.getMonth() + 1;
						var y = date.getFullYear();
						if (m < 10) {
							m = '0' + m;
						}
						if (d < 10) {
							d = '0' + d;
						}
						evenements.push({
							title: data[i].salle.code,
							start: y + "-" + m + "-" + d + "T" + convertTime12to24(data[i].crenom.heureDebut) + ":00",
							end: y + "-" + m + "-" + d + "T" + convertTime12to24(data[i].crenom.heureFin) + ":00",
							backgroundColor: "#839c49"

						});
					}
				}
				//				i++;
				//			}
				$("calendrier").empty();
				document.getElementById('calendrier').innerHTML = "";

				var elementCalendrier = document.getElementById('calendrier');
				calendar = new FullCalendar.Calendar(elementCalendrier, {
					plugins: ['dayGrid', 'timeGrid', 'list'],
					defaultView: 'timeGridWeek',
					locale: 'fr',
					header: {
						left: 'prev,next today',
						center: 'title',
						right: 'dayGridMonth,timeGridWeek,list'
					},
					buttonText: {
						today: 'Aujourd\'hui',
						month: 'Mois',
						week: 'Semaine',
						list: 'Liste'
					},
					events: evenements,
					nowIndicator: true,
				});

				calendar.render();



			},
			error: function(jqXHR, textStatus, errorthrown) {
				alert(textStatus);
			}




		});
	});
	function remplir(data) {
		var ligne = "";
		for (var i = 0; i < data.length; i++) {
			ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].date + "</td><td>" + data[i].salle.id + "</td><td>" + data[i].crenom.id + "<td>" + data[i].clientid.id + "</td></td><td><button type='button'  class='btn btn-danger delete1' val='" + data[i].id + "'>Supprimer</button></td><td><button type='button'   class='btn btn-warning update1'>Update</button></td></tr>";

		}
		$("#contentOccupation").html(ligne);
	}

	function disponib(data) {
		var ligne = "";
		for (var i = 0; i < data.length; i++) {
			ligne += "<option >" + data[i].id + "</option>";
		}
		$("#Idcrenom").html(ligne);
	}



});
$(document).ready(function() {


	$("#Idsalle").change(function() {

		let idsalle = $("#Idsalle option:selected").text();
		alert(idsalle);
		$.ajax({
			url: "OccupationController",
			data: { op: "chart", idsalle1: idsalle },
			type: 'post',
			success: function(response) {
				$('#myChart').replaceWith($('<canvas id="myChart" height="320px"></canvas>'));
				const ctx = document.getElementById("myChart").getContext("2d");

				const labels = TOTO(response);
				const data = {
					labels,
					datasets: [{
						data: goof(response),
						label: "reservation salles",
						backgroundColor: [
							'rgba(255, 99, 132, 0.2)',
							'rgba(54, 162, 235, 0.2)',
							'rgba(255, 206, 86, 0.2)',
							'rgba(75, 192, 192, 0.2)',
							'rgba(153, 102, 255, 0.2)',
							'rgba(255, 159, 64, 0.2)'
						],
						borderColor: [
							'rgba(255, 99, 132, 1)',
							'rgba(54, 162, 235, 1)',
							'rgba(255, 206, 86, 1)',
							'rgba(75, 192, 192, 1)',
							'rgba(153, 102, 255, 1)',
							'rgba(255, 159, 64, 1)'
						],
						borderWidth: 1
					}]

				}
				const config = {
					type: 'bar',
					data: data,
					options: {
						radius: 5,
						responsive: true,
						x: {
							ticks: {
								callback: function(value) {
									return "$" + value
								},
							},
						},
					},
				};

				const myChart = new Chart(ctx, config);

				window.myChart = new Chart(ctx).PieUnique(data);


			},


			error: function(jqXHR, textStatus, errorthrown) {
				alert(textStatus);


			}
		});

	});
	function goof(response) {
		var panda = [];
		for (const [key, value] of Object.entries(response)) {
			panda.push(value);
		}
		return panda;
	}
	function TOTO(response) {
		var panda = [];
		for (const [key, value] of Object.entries(response)) {
			if (key == "1")
				panda.push(" " + "Janvier");
			if (key == "2")
				panda.push(" " + "Février");
			if (key == "3")
				panda.push(" " + "Mars");
			if (key == "4")
				panda.push(" " + "Avril");
			if (key == "5")
				panda.push(" " + "Mai");
			if (key == "6")
				panda.push(" " + "Juin");
			if (key == "7")
				panda.push(" " + "Juillet");
			if (key == "8")
				panda.push(" " + "Aout");
			if (key == "9")
				panda.push(" " + "Septembre");
			if (key == "10")
				panda.push(" " + "Octobre");
			if (key == "11")
				panda.push(" " + "Novembre");
			if (key == "12")
				panda.push(" " + "Decembre");
		}
		return panda;
	}
});

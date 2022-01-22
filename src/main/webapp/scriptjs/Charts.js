	$(document).ready(function(){
	$.ajax({
		 
		success: function() {		 
				 
					const ctx = document.getElementById("myChart").getContext("2d");

					const labels = ['janvier'
						, 'février'
						, 'Mars'
						, 'Avril'
						, 'Mai'
						, 'Juin'
						, 'Juillet'
						, 'Aout'
						, 'Septembre'
						, 'Octobre'
						, 'Novembre'
						, 'Decembre'];
					const data = {
						labels,
						datasets: [{
							data: [11
								, 2
								, 5
								, 6
								, 3
								, 4
								, 7
								, 8
								, 5
								,12
								, 16
								, 7],
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
						 data:data,
						options: {
							radius: 5,
							responsive: true,
						}
					}

					const myChart = new Chart(ctx, config);
				
			 
			 
		

		},


		error: function(jqXHR, textStatus, errorthrown) {
			alert(textStatus);


		}

	});
	});
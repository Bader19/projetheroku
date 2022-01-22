<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Focus - Bootstrap Admin Dashboard</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="./images/favicon.png">
<link rel="stylesheet"
	href="./vendor/owl-carousel/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="./vendor/owl-carousel/css/owl.theme.default.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="./vendor/jqvmap/css/jqvmap.min.css" rel="stylesheet">
<link href="./css/style.css" rel="stylesheet">
<link rel="stylesheet" href="./assets/css/style.css">
<script type="text/javascript" src="scriptjs/Occupation.js"></script>
<script type="text/javascript" src="scriptjs/selector1.js"></script>
<script type="text/javascript" src="scriptjs/selector2.js"></script>
<script type="text/javascript" src="scriptjs/selector3.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link rel="stylesheet" href="fullcalendar/core/main.css">
<link rel="stylesheet" href="fullcalendar/timegrid/main.css">
<link rel="stylesheet" href="fullcalendar/daygrid/main.css">
<link rel="stylesheet" href="fullcalendar/list/main.css">

</head>

<body>

	<!--*******************
        Preloader start
    ********************-->
	<div id="preloader">
		<div class="sk-three-bounce">
			<div class="sk-child sk-bounce1"></div>
			<div class="sk-child sk-bounce2"></div>
			<div class="sk-child sk-bounce3"></div>
		</div>
	</div>
	<!--*******************
        Preloader end
    ********************-->


	<!--**********************************
        Main wrapper start
    ***********************************-->
	<div id="main-wrapper">

		<!--**********************************
            Nav header start
        ***********************************-->
		<%@include file="Header.jsp"%>
		<!--**********************************
            Header end ti-comment-alt
        ***********************************-->

		<!--**********************************
            Sidebar start
        ***********************************-->
		<%@include file="Sidebar.jsp"%>
		<!--**********************************
            Sidebar end
        ***********************************-->

		<!--**********************************
            Content body start
        ***********************************-->
		<div class="content-body">
			<!-- row -->
			<div class="container-fluid">
				<div class="row">




					<!-- /# column -->
				</div>

				<div class="row12">
					<form>
						<div class="form-icon">
							<span><i class="icon icon-user"></i></span>
						</div>
						<div class="form-group">
						<labdel for="Date1"> Date </labdel>
							<input type="date" class="form-control item" name="Date1"
								id="Date" placeholder="Date">
						</div>
						<div class="form-group" class="form-control item">
						<labdel for="Idsalle1"> Salle </labdel>
							<select id="Idsalle" class="form-control item" name="Idsalle1">

							</select>
						</div>
						<div class="form-group" class="form-control item">
						<labdel for="Idclient1"> Client </labdel>
							<select id="Idclient" class="form-control item" name="Idclient1">

							</select>
						</div>
						<div class="form-group" class="form-control item">
						<labdel for="Idcrenom1"> Crenom </labdel>
							<select id="Idcrenom" class="form-control item" name="Idcrenom1">

							</select>
						</div>

						
						<div id="ill">
							<button type="submit" class="btn btn-primary" id="add">Ajouter</button>
						</div>
					</form>
				</div>






				<div id="Bader">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Liste des Occupations</h4>
						</div>
						<div class="card-body justify-content-center align-items-center">
							<div class="table-responsive">
								<table class="table mb-0">
									<thead>
										<tr>

											<th>ID</th>
											<th>Date</th>
											<th>IdSalle</th>
											<th>IdCrenom</th>
											<th>IdClient</th>
											<th>Supprimer</th>
											<th>Modifier</th>
										</tr>
									</thead>
									<tbody id="contentOccupation">

									</tbody>
								</table>
							</div>

						</div>
					</div>

				</div>
				<div class="calendrier">
					<div id="calendrier"></div>
				</div>
			</div>



		</div>




	</div>
	<!--**********************************
            Content body end
        ***********************************-->


	<!--**********************************
            Footer start
        ***********************************-->
	<%@include file="Footer.jsp"%>>
	<!--**********************************
            Footer end
        ***********************************-->

	<!--**********************************
           Support ticket button start
        ***********************************-->

	<!--**********************************
           Support ticket button end
        ***********************************-->



	<!--**********************************
        Main wrapper end
    ***********************************-->

	<!--**********************************
        Scripts
    ***********************************-->
	<!-- Required vendors -->



	<script src="fullcalendar/core/main.js"></script>
	<script src="fullcalendar/daygrid/main.js"></script>
	<script src="fullcalendar/timegrid/main.js"></script>
	<script src="fullcalendar/list/main.js"></script>
	<script src="./vendor/global/global.min.js"></script>
	<script src="./js/quixnav-init.js"></script>
	<script src="./js/custom.min.js"></script>


	<!-- Vectormap -->
	<script src="./vendor/raphael/raphael.min.js"></script>



	<script src="./vendor/circle-progress/circle-progress.min.js"></script>
	<script src="./vendor/chart.js/Chart.bundle.min.js"></script>

	<script src="./vendor/gaugeJS/dist/gauge.min.js"></script>

	<!--  flot-chart js -->
	<script src="./vendor/flot/jquery.flot.js"></script>
	<script src="./vendor/flot/jquery.flot.resize.js"></script>

	<!-- Owl Carousel -->
	<script src="./vendor/owl-carousel/js/owl.carousel.min.js"></script>

	<!-- Counter Up -->
	<script src="./vendor/jqvmap/js/jquery.vmap.min.js"></script>
	<script src="./vendor/jqvmap/js/jquery.vmap.usa.js"></script>
	<script src="./vendor/jquery.counterup/jquery.counterup.min.js"></script>



	<script type="text/javascript" src="scriptjs/jquery-3.3.1.min.js"></script>


</body>

</html>
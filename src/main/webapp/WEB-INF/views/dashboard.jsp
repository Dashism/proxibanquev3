<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Proxibanque SI</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/agency.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">Proxibanque
				SI</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#team">Tableau de bord</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Header -->
	<header class="masthead">
		<div class="container">
			<div class="intro-text">
				<div class="intro-lead-in">Bienvenue sur le système
					d'information</div>
				<div class="intro-heading text-uppercase">PROXIBANQUE</div>
			</div>
		</div>
	</header>

	<section class="bg-light" id="team">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">Tableau de bord</h2>
					<h3 class="section-subheading text-muted">Sélectionner une
						action</h3>
				</div>
			</div>
			<h2>Identifiant : ${client.firstname} ${client.lastname}</h2>
			<div class="transfer-button">
				<a href="transfer.html">
					<button class="button">Faire un virement</button>
				</a> <a href="index.html">
					<button class="button" type="button">Retour</button>
				</a>
			</div>
			<div class="row">
				<c:if test="${currentAccounts.size() != 0}">
					<c:forEach var="currentAccount" items="${currentAccounts}">
						<div class="col-sm-4">
							<div class="currentAccounts">
								<h4>Compte courant</h4>
								<img src="./img/compte_courant.jpg" style="width: 50%;">
								<h6>Numéro de compte : ${currentAccount.number}</h6>
								<h6>Solde du compte</h6>
								<p>${currentAccount.balance}&#8364</p>
								<div class="cashWithdrawal-button">
									<a href="cashWithdrawal.html?id=${currentAccount.id}">
										<button class="button">Retrait liquide</button>
									</a>
								</div>
								<div class="newCard-button">
									<a href="newCard.html?id=${currentAccount.id}">
										<button class="button">Retrait CB</button>
									</a>
								</div>
								<form method="post" action="">
									<div class="retraitchequier-button">
										<div>${errorEmpty}${errorTooHigh}</div>
										<a href="retraitchequier.html?id=${currentAccount.id}">
											<button class="button">Retrait Chéquier</button>
										</a>
									</div>
								</form>
								<script src="js/form.js"></script>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${currentAccounts.size() == 0}">
					<div class="col-sm-4">
						<p>Aucun compte courant pour ce client.</p>
					</div>
				</c:if>
				<c:if test="${savingsAccounts.size() != 0}">
					<c:forEach var="savingsAccount" items="${savingsAccounts}">
						<div class="col-sm-4">
							<div class="currentAccounts">
								<h4>Compte épargne</h4>
								<img src="./img/epargne.jpg" style="width: 50%;">
								<h6>Numéro de compte : ${savingsAccount.number}</h6>
								<h6>Solde du compte</h6>
								<p>${savingsAccount.balance}&#8364</p>
								<div class="retraitchequier-button">
									<div>${errorEmpty}${errorTooHigh}</div>
									<a href="retraitchequier.html?id=${currentAccount.id}">
										<button class="button">Retrait Chéquier</button>
									</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${savingsAccounts.size() == 0}">
					<div class="col-sm-4">
						<p>Aucun compte épargne pour ce client.</p>
					</div>
				</c:if>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<span class="copyright">Copyright &copy; Proxibanque 2018</span>
				</div>
				<div class="col-md-4">
					<ul class="list-inline social-buttons">
						<li class="list-inline-item"><a href="#"> <i
								class="fab fa-twitter"></i>
						</a></li>
						<li class="list-inline-item"><a href="#"> <i
								class="fab fa-facebook-f"></i>
						</a></li>
						<li class="list-inline-item"><a href="#"> <i
								class="fab fa-linkedin-in"></i>
						</a></li>
					</ul>
				</div>
				<div class="col-md-4">
					<ul class="list-inline quicklinks">
						<li class="list-inline-item"><a href="#">Privacy Policy</a></li>
						<li class="list-inline-item"><a href="#">Terms of Use</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>



	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Contact form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>
	<script src="js/contact_me.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/agency.min.js"></script>
	<script src="js/chequier.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Proxibanque SI</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/agency.min.css" rel="stylesheet">

  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">Proxibanque SI</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav text-uppercase ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#team">Liste des comptes</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Header -->
    <header class="masthead">
      <div class="container">
        <div class="intro-text">
          <div class="intro-lead-in">Bienvenue sur le syst�me d'information</div>
          <div class="intro-heading text-uppercase">PROXIBANQUE</div>
        </div>
      </div>
    </header>

   
    <section class="bg-light" id="team">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">Listes des comptes</h2>
            <h3 class="section-subheading text-muted">Vous pouvez rajouter un compte ou faire un virement</h3>
          </div>
        </div>
    <div class="row" >
		<c:if test="${accounts.size()!=0}">
		<c:forEach var="account" items="${accounts}">
			<div class="col-sm-4">
			<div class="account" >
			<c:if test="${account.savings == 'false'}">
			<h4>Compte courant</h4>
			<img src="./img/compte_courant.jpg" style="width: 50%;">
			<h6>Num�ro de compte : ${account.number}</h6>
          
              <h6>Solde du compte</h6>
              <p>${account.balance} &#8364</p>
              </c:if>
              
              <c:if test="${account.savings == 'true'}">
              <h4>Compte epargne</h4>
              <img src="./img/epargne.jpg" style="width: 50%;">
			<h6>Num�ro de compte : ${account.number}</h6>
          
              <h6>Solde du compte</h6>
              <p>${account.balance} &#8364</p>
              </c:if>
			</div>
			</div>
		</c:forEach>
		</c:if>
		<c:if  test="${accounts.size()==0}">
		<div class="col-sm-4">
		<p>Aucun compte pour ce client.</p>
		</div>
		</c:if>
		<div class="col-sm-4">
		<a href="createaccount.html?id=${client.id}"><h6>Cr�er un nouveau compte</h6></a><br>
		<a href="transfer.html?id=${client.id}"><h6>Faire un virement</h6></a>
		</div>
	</div>
	<br>
	<a href="index.html">Revenir au menu pr�c�dent</a>
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
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-twitter"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-facebook-f"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-linkedin-in"></i>
                </a>
              </li>
            </ul>
          </div>
          <div class="col-md-4">
            <ul class="list-inline quicklinks">
              <li class="list-inline-item">
                <a href="#">Privacy Policy</a>
              </li>
              <li class="list-inline-item">
                <a href="#">Terms of Use</a>
              </li>
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

  </body>

</html>

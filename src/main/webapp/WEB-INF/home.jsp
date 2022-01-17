<%@include file="../header.jsp"%>
<%
String option = (String) request.getAttribute("option");
%>
<div class="container-scroller">
	<!-- partial:partials/_navbar.html -->
	<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
		<div class="navbar-brand-wrapper d-flex justify-content-center">
			<div
				class="navbar-brand-inner-wrapper d-flex justify-content-between align-items-center w-100">
				<a class="navbar-brand brand-logo" href="index.html"><img
					src="assets/admin-template/images/LOGO_E-COMMERCE.png" alt="logo" /></a>
				<a class="navbar-brand brand-logo-mini" href="index.html"><img
					src="assets/admin-template/images/LOGO_E-COMMERCE.png" alt="logo" /></a>
				<button class="navbar-toggler navbar-toggler align-self-center"
					type="button" data-toggle="minimize">
					<span class="mdi mdi-sort-variant"></span>
				</button>
			</div>
		</div>
		<div
			class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
			<ul class="navbar-nav mr-lg-4 w-100">
				<li class="nav-item nav-search d-none d-lg-block w-100">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" id="search"> <i
								class="mdi mdi-magnify"></i>
							</span>
						</div>
						<input type="text" class="form-control" placeholder="Search now"
							aria-label="search" aria-describedby="search">
					</div>
				</li>
			</ul>
			<ul class="navbar-nav navbar-nav-right">
				<li class="nav-item dropdown mr-1"><a
					class="nav-link count-indicator dropdown-toggle d-flex justify-content-center align-items-center"
					id="messageDropdown" href="#" data-toggle="dropdown"> <i
						class="mdi mdi-message-text mx-0"></i> <span class="count"></span>
				</a>
					<div class="dropdown-menu dropdown-menu-right navbar-dropdown"
						aria-labelledby="messageDropdown">
						<p class="mb-0 font-weight-normal float-left dropdown-header">Messages</p>
						<a class="dropdown-item">
							<div class="item-thumbnail">
								<img src="assets/admin-template/images/faces/face4.jpg"
									alt="image" class="profile-pic">
							</div>
							<div class="item-content flex-grow">
								<h6 class="ellipsis font-weight-normal">David Grey</h6>
								<p class="font-weight-light small-text text-muted mb-0">The
									meeting is cancelled</p>
							</div>
						</a> <a class="dropdown-item">
							<div class="item-thumbnail">
								<img src="assets/admin-template/images/faces/face2.jpg"
									alt="image" class="profile-pic">
							</div>
							<div class="item-content flex-grow">
								<h6 class="ellipsis font-weight-normal">Tim Cook</h6>
								<p class="font-weight-light small-text text-muted mb-0">New
									product launch</p>
							</div>
						</a> <a class="dropdown-item">
							<div class="item-thumbnail">
								<img src="assets/admin-template/images/faces/face3.jpg"
									alt="image" class="profile-pic">
							</div>
							<div class="item-content flex-grow">
								<h6 class="ellipsis font-weight-normal">Johnson</h6>
								<p class="font-weight-light small-text text-muted mb-0">
									Upcoming board meeting</p>
							</div>
						</a>
					</div></li>
				<li class="nav-item dropdown mr-4"><a
					class="nav-link count-indicator dropdown-toggle d-flex align-items-center justify-content-center notification-dropdown"
					id="notificationDropdown" href="#" data-toggle="dropdown"> <i
						class="mdi mdi-bell mx-0"></i> <span class="count"></span>
				</a>
					<div class="dropdown-menu dropdown-menu-right navbar-dropdown"
						aria-labelledby="notificationDropdown">
						<p class="mb-0 font-weight-normal float-left dropdown-header">Notifications</p>
						<a class="dropdown-item">
							<div class="item-thumbnail">
								<div class="item-icon bg-success">
									<i class="mdi mdi-information mx-0"></i>
								</div>
							</div>
							<div class="item-content">
								<h6 class="font-weight-normal">Application Error</h6>
								<p class="font-weight-light small-text mb-0 text-muted">
									Just now</p>
							</div>
						</a> <a class="dropdown-item">
							<div class="item-thumbnail">
								<div class="item-icon bg-warning">
									<i class="mdi mdi-settings mx-0"></i>
								</div>
							</div>
							<div class="item-content">
								<h6 class="font-weight-normal">Settings</h6>
								<p class="font-weight-light small-text mb-0 text-muted">
									Private message</p>
							</div>
						</a> <a class="dropdown-item">
							<div class="item-thumbnail">
								<div class="item-icon bg-info">
									<i class="mdi mdi-account-box mx-0"></i>
								</div>
							</div>
							<div class="item-content">
								<h6 class="font-weight-normal">New user registration</h6>
								<p class="font-weight-light small-text mb-0 text-muted">2
									days ago</p>
							</div>
						</a>
					</div></li>
				<li class="nav-item nav-profile dropdown"><a
					class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
					id="profileDropdown"> <img
						src="assets/admin-template/images/faces/face5.jpg" alt="profile" />
						<span class="nav-profile-name">Louis Barnett</span>
				</a>
					<div class="dropdown-menu dropdown-menu-right navbar-dropdown"
						aria-labelledby="profileDropdown">
						<a class="dropdown-item"> <i
							class="mdi mdi-settings text-primary"></i> Settings
						</a> <a class="dropdown-item"> <i
							class="mdi mdi-logout text-primary"></i> Logout
						</a>
					</div></li>
			</ul>
			<button
				class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
				type="button" data-toggle="offcanvas">
				<span class="mdi mdi-menu"></span>
			</button>
		</div>
	</nav>
	<!-- partial -->
	<div class="container-fluid page-body-wrapper">
		<!-- partial:partials/_sidebar.html -->
		<nav class="sidebar sidebar-offcanvas" id="sidebar">
			<ul class="nav">
				<li class="nav-item"><a class="nav-link"
					href="/gestion-ecommerce/AccueilServlet?option=accueil"> <i
						class="mdi mdi-home menu-icon"></i> <span class="menu-title">Accueil</span>
				</a><a></a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#user" aria-expanded="false" aria-controls="user"> <i
						class="mdi mdi-account menu-icon"></i> <span class="menu-title">Gestion
							des users</span> <i class="menu-arrow"></i>
				</a>
					<div class="collapse" id="user">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="/gestion-ecommerce/AccueilServlet?option=gestionUsers">
									User </a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#produit" aria-expanded="false" aria-controls="produit">
						<i class="mdi mdi-shopping menu-icon"></i> <span
						class="menu-title">Gestion des produits</span> <i
						class="menu-arrow"></i>
				</a>
					<div class="collapse" id="produit">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="/gestion-ecommerce/AccueilServlet?option=gestionProduits">
									Catégorie </a></li>
							<li class="nav-item"><a class="nav-link"
								href="/gestion-ecommerce/AccueilServlet?option=gestionsProduits">Produit </a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#client" aria-expanded="false" aria-controls="client"> <i
						class="mdi mdi-account-card-details menu-icon"></i> <span
						class="menu-title">Gestion des clients</span> <i
						class="menu-arrow"></i>
				</a>
					<div class="collapse" id="client">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="/gestion-ecommerce/AccueilServlet?option=gestionClients">
									Client </a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#livraison" aria-expanded="false" aria-controls="livraison">
						<i class="mdi mdi-truck menu-icon"></i> <span class="menu-title">Gestion
							de la livraison</span> <i class="menu-arrow"></i>
				</a>
					<div class="collapse" id="livraison">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="/gestion-ecommerce/AccueilServlet?option=gestionLivraisons">Livraison</a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#fournisseur" aria-expanded="false"
					aria-controls="fournisseur"> <i
						class="mdi mdi-account-circle menu-icon"></i> <span
						class="menu-title">Gestion des fournisseurs</span> <i
						class="menu-arrow"></i>
				</a>
					<div class="collapse" id="fournisseur">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="/gestion-ecommerce/AccueilServlet?option=gestionFournisseurs">Fournisseurs</a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#commande" aria-expanded="false" aria-controls="commande">
						<i class="mdi mdi-dropbox menu-icon"></i> <span class="menu-title">Gestion
							des commandes</span> <i class="menu-arrow"></i>
				</a>
					<div class="collapse" id="commande">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="/gestion-ecommerce/AccueilServlet?option=gestionCommandes">Commandes</a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#facturation" aria-expanded="false"
					aria-controls="facturation"> <i
						class="mdi mdi-receipt menu-icon"></i> <span class="menu-title">Gestion
							de la facturation</span> <i class="menu-arrow"></i>
				</a>
					<div class="collapse" id="facturation">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="/gestion-ecommerce/AccueilServlet?option=gestionFacturations">Facturation</a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#stocks" aria-expanded="false" aria-controls="stocks"> <i
						class="mdi mdi-trending-up menu-icon"></i> <span
						class="menu-title">Gestion des stocks</span> <i class="menu-arrow"></i>
				</a>
					<div class="collapse" id="stocks">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="/gestion-ecommerce/AccueilServlet?option=gestionStocks">Stocks</a></li>
						</ul>
					</div></li>
			</ul>
		</nav>
		<!-- partial -->
		<div class="main-panel">
			<div class="content-wrapper">
				<!-- main body -->
				<%
				if (option != null && option.equals("gestionProduits")) {
				%>
				<%@include file="views/gestionProduits/produit.jsp"%>
				<%
				}
				%>
				<%
				if (option != null && option.equals("gestionUsers")) {
				%>
				<%@include file="views/gestionUsers/user.jsp"%>
				<%
				}
				%>
				<%
				if (option != null && option.equals("gestionStocks")) {
				%>
				<%@include file="views/gestionStocks/stock.jsp"%>
				<%
				}
				%>
				<%
				if (option != null && option.equals("gestionFacturations")) {
				%>
				<%@include file="views/gestionFacturations/facturation.jsp"%>
				<%
				}
				%>
				<%
				if (option != null && option.equals("gestionCommandes")) {
				%>
				<%@include file="views/gestionCommandes/commande.jsp"%>
				<%
				}
				%>
				<%
				if (option != null && option.equals("gestionFournisseurs")) {
				%>
				<%@include file="views/gestionFournisseurs/fournisseur.jsp"%>
				<%
				}
				%>
				<%
				if (option != null && option.equals("gestionClients")) {
				%>
				<%@include file="views/gestionClients/client.jsp"%>
				<%
				}
				%>
				<%
				if (option != null && option.equals("gestionLivraisons")) {
				%>
				<%@include file="views/gestionClients/client.jsp"%>
				<%
				}
				%>
			</div>
			<!-- content-wrapper ends -->
		</div>
	</div>
	<!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<%@include file="../footer.jsp"%>
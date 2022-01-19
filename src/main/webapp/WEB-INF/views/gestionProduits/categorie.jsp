<%@page import="java.util.List"%>
<%@page import="sn.isi.ecommerce.entities.Categorie"%>
<%
List<Categorie> categories = (List) request.getAttribute("categories");
String isModification = (request.getParameter("isModification") != null) ? request.getParameter("isModification")
		: "false";
Categorie categorie = (request.getParameter("categorie") != null) ? (Categorie)request.getAttribute("categorie")
		: null;
%>
<div class="row">
	<div class="col-md-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Formulaire catégorie</h4>
				<form action="CategorieServlet" method="POST" class="forms-sample">
					<div class="row">
						<div class="col-md-6">
							<p class="card-description">Ajout</p>
							<div class="form-group">
								<label for="exampleInputUsername1">Libellé</label> <input
									type="text" class="form-control" id="libelleCategorie"
									name="libelle-categorie" placeholder="libellé">
							</div>
							<button type="submit" class="btn btn-primary mr-2">Ajouter</button>
							<button class="btn btn-light">Annuler</button>
						</div>
						<div class="col-md-6">
							<p class="card-description">Modification</p>
							<p><%=(categorie != null)? categorie.getLibelle(): ""%></p>
							<div class="form-group">
								<label for="exampleInputUsername1">Ancien libellé</label> <input
									type="text" class="form-control" id="ancienLibelleCategorie"
									name="ancien-libelle-categorie" placeholder="ancien libellé" value="<%=(categorie != null)? categorie.getLibelle(): ""%>" readonly>
							</div>
							<div class="form-group">
								<label for="exampleInputUsername1">Nouveau libellé</label> <input
									type="text" class="form-control" id="nouveauLibelleCategorie"
									name="nouveau-libelle-categorie" placeholder="Nouveau libellé">
							</div>
							<button type="submit" class="btn btn-primary mr-2">Modifier</button>
							<button class="btn btn-light">Annuler</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Liste des catégories</h4>
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Libellé</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>

							<%
							if (categories != null) {
							%>
							<%
							for (int i = 0; i < categories.size(); i++) {
							%>
							<%
							Categorie c = (Categorie) categories.get(i);
							%>
							<tr>
								<td><%=c.getId()%></td>
								<td><%=c.getLibelle()%></td>
								<td><a
									href="CategorieServlet?action=edit&id=<%=c.getId()%>"
									title="Modifier catégorie" class="btn btn-info btn-sm ">
										Modifier </a> <a
									href="CategorieServlet?action=delete&id=<%=c.getId()%>"
									title="Supprimer catégorie" class="btn btn-danger btn-sm ">
										Supprimer </a></td>
							</tr>
							<%
							}
							%>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
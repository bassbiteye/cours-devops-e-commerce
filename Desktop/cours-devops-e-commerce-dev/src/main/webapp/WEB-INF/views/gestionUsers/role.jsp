<%@page import="java.util.List"%>
<%@page import="sn.isi.ecommerce.entities.Roles"%>
<%
List<Roles> roles = (List) request.getAttribute("roles");
String isModification = (request.getParameter("isModification") != null) ? request.getParameter("isModification")
		: "false";
Roles role = (request.getParameter("role") != null) ? (Roles)request.getAttribute("role")
		: null;
%>
<div class="row">
	<div class="col-md-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Formulaire role</h4>
				<form action="RoleServlet" method="POST" class="forms-sample">
					<div class="row">
						<div class="col-md-6">
							<p class="card-description">Ajout</p>
							<div class="form-group">
								<label for="exampleInputUsername1">Nom</label> <input
									type="text" class="form-control" id="libelleRole"
									name="libelle-role" placeholder="libellé">
							</div>
							<button type="submit" class="btn btn-primary mr-2">Ajouter</button>
							<button class="btn btn-light">Annuler</button>
						</div>
						<div class="col-md-6">
							<p class="card-description">Modification</p>
							<p><%=(role != null)? role.getNom(): ""%></p>
							<div class="form-group">
								<label for="exampleInputUsername1">Ancien nom</label> <input
									type="text" class="form-control" id="ancienLibelleRole"
									name="ancien-libelle-role" placeholder="ancien libellé" value="<%=(role != null)? role.getNom(): ""%>" readonly>
							</div>
							<div class="form-group">
								<label for="exampleInputUsername1">Nouveau libellé</label> <input
									type="text" class="form-control" id="nouveauLibelleRole"
									name="nouveau-libelle-role" placeholder="Nouveau libellé">
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
				<h4 class="card-title">Liste des roles</h4>
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Nom</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>

							<%
							if (roles != null) {
							%>
							<%
							for (int i = 0; i < roles.size(); i++) {
							%>
							<%
							Roles r = (Roles) roles.get(i);
							%>
							<tr>
								<td><%=r.getId()%></td>
								<td><%=r.getNom()%></td>
								<td><a
									href="RoleServlet?action=edit&id=<%=r.getId()%>"
									title="Modifier role" class="btn btn-info btn-sm ">
										Modifier </a> <a
									href="RoleServlet?action=delete&id=<%=r.getId()%>"
									title="Supprimer role" class="btn btn-danger btn-sm ">
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
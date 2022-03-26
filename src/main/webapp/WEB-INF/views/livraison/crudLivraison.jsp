<%@include file="../../../header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="sn.isi.ecommerce.entities.Livraison"%>
<%
List<Livraison> livraisons = (List) request.getAttribute("Livraisons");
String isModification = (request.getParameter("isModification") != null) ? request.getParameter("isModification"): "false";
int idLivraison = (request.getParameter("idLivraison") != null) ? Integer.parseInt(request.getParameter("idLivraison")): -1;
%>
<div class="container">
	<h2>Gestion des Livraisons</h2>
	<div class="row">
		<!-- FORM  -->
		<div class="col-md-6">
			<form action="LivraisonServlet" method="POST" class="form-horizontal"
				id="form-edit-commande">
				<fieldset>

					<!-- Form Name -->
					<legend>Livraison</legend>

					<!-- Text input-->
					<div class="form-group">
						</div>

						<%
						if(isModification.equals("true"))
						{
							Livraison livraison = null;
							for(Livraison l : livraisons) {
								   if(l.getId() == idLivraison) {
									   livraison = l;
								   }
								}
						%>

						<%
						}
						%>
					</div>
					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="btn-save"></label>
						<div class="col-md-4">
							<button id="btn-save" name="btn-save" class="btn btn-success">Enregistrer</button>
						</div>
					</div>
				</fieldset>
			</form>


		</div>

		<!-- LIST -->
		<div class=col-md-6>

			<form id="form-list-commande">
				<legend>Liste des Livraisons</legend>

				<table class="table table-bordered table-condensed table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Actions</th>
						</tr>

					</thead>

				</table>
			</form>
		</div>
	</div>
</div>

<%@include file="../../../footer.jsp"%>
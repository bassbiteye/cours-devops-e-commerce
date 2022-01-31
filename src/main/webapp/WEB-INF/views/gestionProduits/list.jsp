
<%@page import="java.util.List"%>

<%@ page import="sn.isi.ecommerce.entities.Produit" %>
<%@ page import="sn.isi.ecommerce.entities.Categorie" %>
<%
    List<Categorie> categories = (List)request.getAttribute("categories");
    List<Produit> produits = (List) request.getAttribute("produits");
    String isModification = (request.getParameter("isModification") != null) ? request.getParameter("isModification"): "false";
    int idProduit = (request.getParameter("idProduit") != null) ? Integer.parseInt(request.getParameter("idProduit")): -1;
%>



<section class="content">
    <div class="container-fluid">

        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">


                    <!-- /.card-header -->
                    <div class="card-body table-responsive p-0 " >

                        <div >
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form method="post" action="ServletProduit">
                                        <div class="modal-body">
                                            <div class="input-group mb-3">
                                                <span class="input-group-text">Libelle Produit *</span>
                                                <input type="text" class="form-control" name="libelle" />
                                            </div>
                                            <div class="input-group mb-3">
                                                <span class="input-group-text">Description Produit *</span>
                                                <input type="text" class="form-control" name="description"/>
                                            </div>
                                            <%--<div class="input-group mb-3">
                                                <span class="input-group-text">Url Image Produit *</span>
                                                <input type="texe" class="form-control" name="image"/>
                                            </div>--%>
                                            <div class="input-group mb-3">
                                            <span class="input-group-text">Prix Produit *</span>
                                            <input type="number" class="form-control" name="pu"/>
                                        </div>
                                            <div class="input-group mb-3">
                                                <span class="input-group-text">Quantite en stock  *</span>
                                                <input type="number" class="form-control" name="qttst"/>
                                            </div>

                                            <div class="input-group mb-3">
                                                <label class="input-group-text"
                                                       for="inputGroupSelect01">Cateories</label>
                                                <select class="form-select" name="idCategorie">
                                                    <option selected>Selectionner une categorie...</option>
                                                    <% for (int i = 0; i < categories.size(); i++) { %>
                                                    <% Categorie c =  (Categorie) categories.get(i); %>
                                                    <option value="<%= c.getId() %>"><%= c.getLibelle() %></option>
                                                    <% } %>
                                                </select>
                                            </div>
                                            <div class="input-group mb-3">
                                                <span class="input-group-text">Date Peremtion *</span>
                                                <input type="date" class="form-control" name="date"/>
                                            </div>
                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="btn-save"></label>
                                                    <div class="col-md-4">
                                                        <button id="btn-save" name="btn-save" class="btn btn-success">Enregistrer</button>
                                                    </div>
                                                </div>
                                            </div>





                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /.card-body -->
                </div>
                <!-- /.card -->
            </div>
        </div>
        <form id="form-list-client">
            <table class="table table-bordered table-condensed table-hover" bgcolor="#7fff00">
                <thead>
                <tr bgcolor="#f8f8ff">
                    <th>Libelle</th>

                    <th>QuantiteStock</th>
                    <th>DateDePeremption</th>
                    <th>Description</th>
                    <th>Action</th>
                </tr>

                </thead>
                <tbody id="form-list-client-body">

                <%
                    for (int i = 0; i < produits.size(); i++) {
                %>
                <%
                    Produit c = (Produit) produits.get(i);
                %>
                <tr>
                    <td><%=c.getLibelle()%></td>
                    <td><%=c.getPrixUnitaire()%></td>
                    <td><%=c.getQuantite()%></td>

                    <td><%=c.getDateDePeremption()%></td>
                    <td><%=c.getDescription()%></td>

                    <td><a href="ProduitServlet?action=edit&id=<%=c.getId()%>" title="Modifier produit"
                           class="btn btn-info btn-sm "> Modifier </a> <a href="ServletProduit?action=delete&id=<%=c.getId()%>"
                                                                          title="Supprimer produit" class="btn btn-danger btn-sm ">
                        Supprimer </a></td>

                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </form>

        <!-- /.row -->
    </div><!-- /.container-fluid -->
    </div>
</section>


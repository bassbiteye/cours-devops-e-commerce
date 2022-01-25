<%@page import="java.util.List"%>
<%@page import="sn.isi.ecommerce.entities.Categorie"%>
<%@ page import="sn.isi.ecommerce.entities.Fournisseur" %>
<%
    List<Fournisseur> fournisseurs = (List) request.getAttribute("fournisseurs");
    String isModification = (request.getParameter("isModification") != null) ? request.getParameter("isModification")
            : "false";
    Fournisseur fournisseur = (request.getParameter("fournisseur") != null) ? (Fournisseur)request.getAttribute("fournisseur")
            : null;
%>

<div class="row">
    <div class="col-md-12 stretch-card">
        <div class="card">
            <div class="card-body">
                <p class="card-title">Fournisseur: 8</p>
                <div class="table-responsive">
                    <table id="recent-purchases-listing" class="table">
                        <thead>
                        <tr>
                            <th>Prenom</th>
                            <th>Nom</th>
                            <th>Telephone</th>
                            <th>Ville</th>
                            <th>adresse</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (int i = 0; i < fournisseurs.size(); i++) {
                        %>
                        <%
                            Fournisseur f = fournisseurs.get(i);
                        %>
                        <tr>
                            <td><%=f.getPrenom()%></td>
                            <td><%=f.getNom()%></td>
                            <td><%=f.getTelephone()%></td>
                            <td><%=f.getVille()%></td>
                            <td><%=f.getAdresse()%></td>
                        </tr>
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
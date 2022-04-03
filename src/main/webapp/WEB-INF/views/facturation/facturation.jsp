<%@include file="../../../header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="sn.isi.ecommerce.entities.Facturation"%>
<%
    List<Facturation> facturations = (List) request.getAttribute("factures");
    String isModification = (request.getParameter("isModification") != null) ? request.getParameter("isModification"): "false";
%>
<div class="container">
    <h2>Gestion des Facture</h2>
    <div class="row">
        <!-- FORM  -->

        <!-- LIST -->
        <div class=col-md-6>

            <form id="form-list-client">
                <legend>Liste des Factures</legend>

                <table class="table table-bordered table-condensed table-hover">
                    <thead>
                    <tr>
                        <th>Numero</th>
                        <th>date</th>
                        <th>Actions</th>
                    </tr>

                    </thead>
                    <tbody id="form-list-client-body">
                    <%
                        for (int i = 0; i < facturations.size(); i++) {
                    %>
                    <%
                        Facturation facture = (Facturation) facturations.get(i);
                    %>

                    <tr>
                        <td><%=facture.getId()%></td>
                        <td><%=facture.getDateFact()%></td>
                        <td>
                            <a href="FacturationServlet?action=edit&id=<%=facture.getId()%>" title="Modifier Facturation"  class="btn btn-info btn-sm "> Modifier </a>
                            <a href="FacturationServlet?action=delete&id=<%=facture.getId()%>" title="Supprimer Facturation" class="btn btn-danger btn-sm "> Supprimer </a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>

<%@include file="../../../footer.jsp"%>
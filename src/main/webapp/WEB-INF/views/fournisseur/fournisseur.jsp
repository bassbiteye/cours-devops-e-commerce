<%--
  Created by IntelliJ IDEA.
  User: Bazzman
  Date: 18/01/2022
  Time: 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../../../header.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List"%>
<%@page import="sn.isi.ecommerce.entities.Fournisseur"%>
<%
    List<Fournisseur> fournisseurs = (List) request.getAttribute("fournisseurs");
%>
<html>
<head>
    <title>Fournisseur</title>
</head>
<body>
<div class="row">
    <div class="col-md-12 stretch-card">
        <div class="card">
            <div class="card-body">
                <p class="card-title">Recent Purchases</p>
                <div class="table-responsive">
                    <table id="recent-purchases-listing" class="table">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Status report</th>
                            <th>Office</th>
                            <th>Price</th>
                            <th>Date</th>
                            <th>Gross amount</th>
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
</body>
</html>
<%@include file="../../../footer.jsp"%>
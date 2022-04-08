<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 08/04/2022
  Time: 01:28
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../../../header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="sn.isi.ecommerce.entities.Roles"%>
<%@ page import="sn.isi.ecommerce.entities.Users" %>
<%
  List<Users> users = (List) request.getAttribute("users");
  String isModification = (request.getParameter("isModification") != null) ? request.getParameter("isModification"): "false";
  int idUser = (request.getParameter("idUser") != null) ? Integer.parseInt(request.getParameter("idUser")): -1;
%>
<div class="container">
  <h2>Gestion des users</h2>
  <div class="row">
    <!-- FORM  -->
    <div class="col-md-6">
      <form action="UserServlet" method="POST" class="form-horizontal"
            id="form-edit-client">
        <fieldset>

          <!-- Form Name -->
          <legend>User</legend>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-md-4 control-label" for="nom">Username</label>
            <div class="col-md-4">
              <input id="user-name-label" name="username" type="text"
                     placeholder="username" class="form-control input-md">
            </div>
            <label class="col-md-4 control-label" for="password">Password</label>
            <div class="col-md-4">
              <input id="password-label" name="password" type="password"
                     class="form-control input-md">
            </div>

            <%
              if(isModification.equals("true"))
              {
                Users user = null;
                for(Users u : users) {
                  if(u.getId() == idUser) {
                    user = u;
                  }
                }
            %>
            <div class="col-md-4">
              <input id="email" name="ancien-email" type="text"
                     placeholder="ancien email" class="form-control input-md" value="<%=user.getEmail()%>" disabled>
            </div>
            <%
              }
            %>
          </div>
          <!-- Button -->
          <div class="form-group">
            <label class="col-md-4 control-label" for="btn-save"></label>
            <div class="col-md-4">
              <button id="btn-save" name="btn-save" class="btn btn-success">Ajouter</button>
            </div>
          </div>
        </fieldset>
      </form>


    </div>

    <!-- LIST -->
    <div class=col-md-6>

      <form id="form-list-client">
        <legend>Liste des utilisateurs</legend>

        <table class="table table-bordered table-condensed table-hover">
          <thead>
          <tr>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Email</th>
            <th>Etat</th>
            <th>Actions</th>
          </tr>

          </thead>
          <tbody id="form-list-client-body">

          <%
            for (int i = 0; i < users.size(); i++) {
          %>
          <%
            Users u = (Users) users.get(i);
          %>
          <tr>
            <td><%=u.getNom()%></td>
            <td><%=u.getPrenom()%></td>
            <td><%=u.getEmail()%></td>
            <td><%=u.getEtat()%></td>
            <td><a href="UserServlet?action=edit&id=<%=u.getId()%>" title="Modifier user" class="btn btn-info btn-sm "> Edit </a>
              <a href="UserServlet?action=delete&id=<%=u.getId()%>" title="Supprimer user" class="btn btn-danger btn-sm ">Delete </a>
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


<%@page import="java.util.List"%>
<%@ page import="sn.isi.ecommerce.entities.Produit" %>
<%@ page import="sn.isi.ecommerce.dao.IProduit" %>
<%@ page import="sn.isi.ecommerce.dao.ProduitImpl" %>
<%
    IProduit prduitdao = new ProduitImpl();
    List<Produit> produits= prduitdao.getAll();



%>
<%--<c:forEach items="${produits}" var="produitss">
    Produit pr = (Produit) produits.get();
    <div class="col-md-4 ">
        <div class="card card-blog ">
            <div class="card-img ">
                <a href="blog-single.html "><img src="<%=produits.()%>" alt=" " class="img-fluid "></a>
            </div>
            <div class="card-body ">

                <p class="card-description ">
                <h6 class="category ">Description</h6>
                <%=produits.getDescription()%>
                </p>
                <div class="col-md-12 ">
                    <a href="<%=produits.getId()%>" class="btn btn-primary float-right">
                        <i class="fas fa-shopping-cart mr-1"></i> faire un commande
                    </a>
                </div>

            </div>
            <div class="card-footer ">
                <h6 class="category ">Prix Unitaire</h6>
                <p> <%=produits.getPrixUnitaire()%> Fcfa</p>

                <div class="progress">
                    <div class="progress-bar" role="progressbar" style="width: 100%;" aria-valuenow="45%" aria-valuemin="0" aria-valuemax="100">
                        <a href="<%=produits.getId()%>" class="btn btn-success float-right">
                            <i class="fas fa-shopping-cart mr-1"></i> Detail produit
                        </a>
                    </div>
                </div>
                <div class="progress">
                    <div class="progress-bar" role="progressbar" style="width: 100%;" aria-valuenow="45%" aria-valuemin="0" aria-valuemax="100">
                        <span class="pull-right"><%=p.getDateDePeremption()%></span>
                    </div>
                </div>

            </div>

        </div>

    </div>
</c:forEach>--%>




<div class="container">
    <div class="row">

        <%
            if (produits != null) {
        %>
        <%

            for (int i = 0; i < produits.size(); i++) {
        %>
        <%
            Produit p = (Produit) produits.get(i);

        %>

        <div class="col-md-3 ">
            <div class="card card-blog ">
                <%--<div class="card-img ">
                    <img src="<%=p.getPhoto()%>" alt=" " class="img-fluid ">
                </div>--%>
                <div class="card-body ">
                    <h6 class="category ">Nom produit</h6>
                    <p class="card-description ">
                        <%=p.getLibelle()%>
                    </p>
                    <div class="col-md-12 ">

                        <h6 class="category ">Prix Unitaire</h6>
                        <p> <%=p.getPrixUnitaire()%> Fcfa</p>
                        <h6 class="category ">Date Peremption</h6>
                        <span class="pull-right"><%=p.getDateDePeremption()%></span>
                        <%--<a href="<%=p.getId()%>" class="btn btn-success ">
                            <i class="fas fa-shopping-cart mr-4"></i> Detail produit
                        </a>
                        <a href="<%=p.getId()%>" class="btn btn-primary ">
                            <i class="fas fa-shopping-cart mr-4"></i> faire un commande
                        </a>--%>


                    </div>


                </div>

            </div>


        </div>




        <%
            }
        %>
        <%
            }
        %>



    </div>
</div>

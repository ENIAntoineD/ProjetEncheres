<%@page import="fr.eni.ProjetEncheres.dal.jdbc.UtilisateurDAOJdbcImpl"%>
<%@page import="fr.eni.ProjetEncheres.bo.Utilisateur"%>
<%@page import="fr.eni.ProjetEncheres.dal.jdbc.UtilisateurDAO"%>
<%@page import="fr.eni.ProjetEncheres.bo.ArticleVendu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">



    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/Accueil.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/General.css">

    <title>Document</title>
</head>
<body>


<header>
    <h1>Accueil</h1>
       
       

    <h2>ENI-Encheres</h2>  
    
     
    

<div class="entete">
    <% boolean isConnected = (boolean)session.getAttribute("connecte");%> 
    
    <% if(isConnected){ 
    	
    	%>
    	 <a href="ServletProfil?index=<%= (String) session.getAttribute("pseudosession")  %>">Mon profil</a>
    	 <a href="ServletRechercher">Rechercher quelqu'un</a>

    	<%@ include file="../html/deconnexion.html" %>
    	<%
    	
    }
    else   {    %> 
    <a href="ServletConnectionUtilisateur" > se connecter</a>
    
    

     <a href="ServletInscription" >S'inscrire</a>
    <%
    
    }  %>
    </div>
  </header> 
  
 
  
  <h2 class="liste">Liste des enchères</h2>
  <main>
  <div class="rechercher">
  	<input name="btRechercher" class="bouton" style="padding : 20px 60px;"type="submit" value="Rechercher"
title="Effectuer une recherche">
</div>
<div class="filtre">
  <p>Filtres</p>
       


<input type="search" id="site-search" name="q">






<form name="categories" action="#"
enctype="multipart/form-data" method="post" class="categorie">
  <fieldset>
    
		<label for="categories" >Catégories :</label>
		<select name="categories" id="categories">
			<option>Informatique</option>
			<option>Ameublement</option>
			<option>Vêtement</option>
			<option>Sport</option>
			<option>Loisirs</option>
		</select>
    </fieldset>
</form>

<section>
<div>
	<input type="radio" name="Encheres" id="Achats"> Achats <br>
	<input type="checkbox" id="Achats"> enchères ouvertes<br>
	<input type="checkbox" id="Achats"> mes enchères en cours<br>
	<input type="checkbox" id="Achats"> mes enchères remportées<br>
</div>
<div>
	<input type="radio" name="Encheres" id="Ventes">Ventes<br>
	<input type="checkbox" id="Achats"> mes ventes en cours<br>
	<input type="checkbox" id="Achats"> ventes non débutées<br>
	<input type="checkbox" id="Achats"> ventes terminées<br>
</div>
</section>
</div>

</main>
<section class ="cases">
	<% 
	List<ArticleVendu> articles = (List<ArticleVendu>) session.getAttribute("afficher");
	Utilisateur user = new Utilisateur();
	UtilisateurDAOJdbcImpl userDAO = new UtilisateurDAOJdbcImpl();
	
	


if(articles != null){
		for(ArticleVendu article : articles){
		%>

		<div class="encheres">
				<img src=""><%--image à ajouter --%>
				<p><%=article.getNomArticle() %></p>
				<p><%=article.getMiseAPrix() %></p>
				<p>Fin de l'enchère : <%=article.getDateFinEncheres() %></p>
				<% user = userDAO.getid(article.getNoUtilisateur());%>
				<p>Vendeur : <a href="ServletUtilisateur?index=<%=article.getNoUtilisateur()%>"><%=user.getPseudo()%></a>
				
		</div>
		
		<%	
		}
	}
		%>
</section>

</body>
</html>
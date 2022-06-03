<%@page import="fr.eni.ProjetEncheres.bo.Utilisateur"%>
<%@page import="fr.eni.ProjetEncheres.dal.jdbc.UtilisateurDAOJdbcImpl"%>
<%@page import="fr.eni.ProjetEncheres.bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/General.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/DetailVente.css">
<title>Detail de la vente</title>
</head>
<body>
<header>
		<div class="entete">
	 <%@ include file="../html/retourAccueil.html" %>
	 </div>
	<h1>Detail Vente</h1>
	<h2>ENI-Encheres</h2> 

	</header>

	<%ArticleVendu article = (ArticleVendu) request.getAttribute("detailarticle"); 
	Utilisateur user = null;
	UtilisateurDAOJdbcImpl userDAO = new UtilisateurDAOJdbcImpl();
	
	%>
	
				<p>  <%=article.getNomArticle() %></p>
				<p> Description : <%=article.getDescription() %></p>
				<p> Meilleur offre: <%=article.getPrixVente() %></p>
				<p> Mise à prix :<%=article.getMiseAPrix() %></p>
				<p>Fin de l'enchère : <%=article.getDateFinEncheres() %></p>
				<% user = userDAO.getid(article.getNoUtilisateur());%>
				<p>Vendeur : <a href="ServletUtilisateur?index=<%=article.getNoUtilisateur()%>"><%=user.getPseudo()%></a></p>
				 Ma proposition : <input type="number" > 
				 <button>Enchérir</button>
</body>
</html>
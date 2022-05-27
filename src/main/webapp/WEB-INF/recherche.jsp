<%@page import="java.util.List"%>
<%@page import="fr.eni.ProjetEncheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recherche</title>
</head>
<body>
<form action="ServletRechercher" method="post">
<p>Rechercher quelqu'un :</p>
<label>Nom : </label><input type="search" name="nom">
<label>Prénom : </label><input type="search" name="prenom">
<label>Pseudo : </label><input type="search" name="pseudo">
<button type="submit">Rechercher</button>
</form>


<% if(request.getAttribute("rechercher") != null)
	{
	
	for(Utilisateur user : (List<Utilisateur>)request.getAttribute("rechercher"))
	{
		
		%>
		<p><%= user.afficherUtilisateur()%></p>
		
		<%
	}%>
	
	
	
	
	<%
	}%>

</body>
</html>
<%@page import="java.util.List"%>
<%@page import="fr.eni.ProjetEncheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/General.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/recherche.css">
<title>Recherche</title>
</head>
<body>
<header>
<h1>Rechercher quelqu'un</h1>
<h2>Eni Enchères</h2>
<div class="entete">
<%@ include file="../html/retourAccueil.html" %>
</div>
</header>
<form action="ServletRechercher" method="post">


<label>Recherche </label><input type="search" name="recherche" placeholder="nom,prénom ou pseudo">
<button type="submit">Rechercher</button>
</form>


<% if(request.getAttribute("rechercher") != null)
	{%>
	
			<table>
		<tr>
		<th>Pseudo</th>
		<th>Nom</th>
		<th>Prenom</th>
		<th>Email</th>
		<th>Voir profil</th>
		</tr>
		
		<% 
	
	for(Utilisateur user : (List<Utilisateur>)request.getAttribute("rechercher"))
	{
		
		%>
		<tr>
		<td><%= user.getPseudo()%></td>
		<td><%= user.getNom()%></td>
		<td><%= user.getPrenom()%></td>
		<td><%= user.getEmail()%></td>
		<% request.setAttribute("personne", user); %>
		<td><a href="ServletUtilisateur?index=<%= user.getNoUtilisateur() %>">Profil</a></td>
		</tr>
		
		<%
	}%>
	</table>
	
	
	
	<%
	}%>

</body>
</html>
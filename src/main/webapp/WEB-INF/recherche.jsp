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
		</tr>
		
		<% 
	
	for(Utilisateur user : (List<Utilisateur>)request.getAttribute("rechercher"))
	{
		
		%>

		<tr><%= user.getPseudo()%></tr>
		<tr><%= user.getNom()%></tr>
		<tr><%= user.getPrenom()%></tr>
		<tr><%= user.getEmail()%></tr>
		</table>
		<%
	}%>
	
	
	
	
	<%
	}%>

</body>
</html>
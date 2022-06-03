<%@page import="fr.eni.ProjetEncheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/General.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/Profil.css">
<title>Profil</title>

</head>
<body>
<header>
<%Utilisateur user = (Utilisateur) request.getAttribute("personne"); %>


<%
		if (request.getAttribute("personne") != null) {
			
			
			%>
			<h1>Page de <%= user.getPseudo() %></h1>
			<h2>Eni Enchères</h2>
			<div class="entete">
				<%@ include file="../html/retourAccueil.html" %>
			</div>
</header>
			<div>
				<p>Nom : <%=user.getNom() %></p>
				<p>Prénom : <%=user.getPrenom() %></p>
				<p>Email : <%=user.getEmail() %></p>
				<p>Pseudo : <%=user.getPseudo() %></p>
			<%
			
		}
	%>
		</div>
</body>
</html>
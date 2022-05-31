 <%@page import="fr.eni.ProjetEncheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>

</head>
<body>

<%Utilisateur user = (Utilisateur) request.getAttribute("profil"); %>


<%
		if (request.getAttribute("profil") != null) {
			
			
			%>
			<h1>Page de <%= user.getPseudo() %></h1>
				<p>Nom : <%=user.getNom() %></p>
				<p>Prénom : <%=user.getPrenom() %></p>
				<p>Email : <%=user.getEmail() %></p>
				<p>Pseudo : <%=user.getPseudo() %></p>
				<p>telephone : <%=user.getTelephone() %></p>
				<p>rue : <%=user.getRue() %></p>
				<p>Code Postal : <%=user.getCodePostal() %></p>
				<p>Ville : <%=user.getVille() %></p>
				<p>Crédit : <%=user.getCredit() %></p>
			<%
			
		}
	%>
	
	<a href="ModifierProfil?index=<%=(String) session.getAttribute("pseudosession") %>"><button>Modifier</button></a>
</body>
</html>

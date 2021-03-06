<%@page import="fr.eni.ProjetEncheres.dal.jdbc.UtilisateurDAOJdbcImpl"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.ProjetEncheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/General.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/modifierProfil.css">
</head>
<body>
<header>

	<div class="entete">
	<%@ include file="../html/retourAccueil.html" %>
	</div>
	<h1>Modifier mon profil</h1>
	<h2>Eni Encheres</h2>
	
</header>
<form action="ModifierProfil" method="post">
<main>
<% Utilisateur user = (Utilisateur)request.getAttribute("monprofil"); %>
<section class="premier">
    <div>
        <label for="pseudo">Pseudo:</label>
        <input type="text" id="pseudo" name="pseudo" value="<%= user.getPseudo() %>">
    </div>
   
    <div>
        <label for="mail">e-mail:</label>
        <input type="email" id="mail" name="email" value="<%= user.getEmail() %>">
    </div>
    <div>
        <label for="name">Nom:</label>
        <input type="text" id="name" name="Nom" value="<%= user.getNom() %>">
    </div>
    <div>
        <label for="prenom">Prénom:</label>
        <input type="text" id="prenom" name="Prenom" value="<%= user.getPrenom() %>">
    </div>
    <div>
        <label for="adresse">Rue:</label>
        <input type="text" id="adresse" name="Adresse" value="<%= user.getRue() %>">
    </div>
    
    <div>
        <label for="password">Nouveau mot de passe:</label>
        <input type="password" id="password" name="Confirm"></input>
    </div>
    </section>
    <section class="deuxieme">
    <div>
        <label for="cp">Code Postal:</label>
        <input type="number" id="cp" name="Cp" value="<%= user.getCodePostal() %>">
    </div>

     <div>
      <label for="ville">Ville:</label>
        <input type="text" id="ville" name="Ville" value="<%= user.getVille() %>">
        
    </div>
     <div>
    	<label for="telephone">Téléphone:</label>
        <input type="tel" id="telephone" name="Telephone" pattern="^(?:(?:\+|00)33[\s.-]{0,3}(?:\(0\)[\s.-]{0,3})?|0)[1-9](?:(?:[\s.-]?\d{2}){4}|\d{2}(?:[\s.-]?\d{3}){2})$" value="<%= user.getTelephone() %>">
    </div>
    <div>
      <label for="password">Mot De Passe actuel:</label>
        <input type="password" id="password" name="motdepasse" required="required"></input>
        <%
        
        if(request.getParameter("btSupprimer") != null || request.getParameter("btEnregistrer") != null) {
        UtilisateurDAOJdbcImpl userdao = new UtilisateurDAOJdbcImpl();
        int index = userdao.selectbypseudo(user);
        if(userdao.VerificationMDP(index, user) != true){
        	 %>
        <p style="color: red"> Le mot de passe est incorrect</p>
        <%
        }
        };%>
       
    </div>
        <div>
        <label for="password">Confirmation :</label>
        <input type="password" id="password" name="Confirm1"></input>
    </div>
    </section>
    
   </main> 
    
<input name="btEnregistrer" type="submit" value="Enregistrer"
title="Enregistrer les informations">
<input name="btSupprimer" type="submit" value="Supprimer mon compte"
title="Supprimer mon compte" >


    
</form>
</body>
</html>
<%@page import="java.util.List"%>
<%@page import="fr.eni.ProjetEncheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier</title>
</head>
<body>
<form action="/ServletInscription" method="post">

<% Utilisateur user = (Utilisateur)request.getAttribute("monprofil"); %>
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
        <label for="cp">Code Postal:</label>
        <input type="number" id="cp" name="Cp" value="<%= user.getCodePostal() %>">
    </div>
    <div>
        <label for="ville">Ville:</label>
        <input type="text" id="ville" name="Ville" value="<%= user.getVille() %>">
    </div>

     <div>
        <label for="telephone">Téléphone:</label>
        <input type="tel" id="telephone" name="Telephone" pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5}|(\(?\d{2,6}\)?))(-|)?)
        (\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$" value="<%= user.getTelephone() %>">
       
    </div>
     <div>
        <label for="password">Mot De Passe actuel:</label>
        <input type="password" id="password" name="motdepasse"></input>
    </div>
        <div>
        <label for="password">Nouveau mot de passe:</label>
        <input type="password" id="password" name="Confirm"></input>
    </div>
        <div>
        <label for="password">Confirmation du nouveau mot de passe:</label>
        <input type="password" id="password" name="Confirm"></input>
    </div>
    
    
    
<input name="btEnregistrer" type="submit" value="Enregistrer"
title="Enregistrer les informations">
<input name="btSupprimer" type="submit" value="Supprimer mon compte"
title="Supprimer mon compte">
   
    
</form>
</body>
</html>
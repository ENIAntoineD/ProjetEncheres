<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="<%= request.getContextPath() %>/css/General.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/Inscription.css">

 
<title>Inscription</title>
</head>
<body>

<header>
		<div class="entete">
	 <%@ include file="../html/retourAccueil.html" %>
	 </div>
	<h1>Inscription</h1>
	<h2>ENI-Encheres</h2> 

	</header>
	<form action="ServletInscription" method="post">
	<main>
	<section class="premier">
    <div>
        <label for="pseudo">Pseudo:</label>
        <input type="text" id="pseudo" name="pseudo">
    </div>
    <div>
        <label for="password">Mot De Passe:</label>
        <input type="password" id="password" name="motdepasse"></input>
    </div>
    <div>
        <label for="mail">e-mail:</label>
        <input type="email" id="mail" name="email">
    </div>
    <div>
        <label for="name">Nom:</label>
        <input type="text" id="name" name="Nom">
    </div>
    <div>
        <label for="prenom">Prénom:</label>
        <input type="text" id="prenom" name="Prenom">
    </div>
    </section>
    <section class="deuxieme">
    <div>
        <label for="adresse">Rue:</label>
        <input type="text" id="adresse" name="Adresse">
    </div>
    <div>
        <label for="cp">Code Postal:</label>
        <input type="number" id="cp" name="Cp">
    </div>
    <div>
        <label for="ville">Ville:</label>
        <input type="text" id="ville" name="Ville">
    </div>
    <div>
        <label for="password">Confirmation:</label>
        <input type="password" id="password" name="Confirm"></input>
    </div>
     <div>
        <label for="telephone">Téléphone:</label>
        <input type="tel" id="telephone" name="Telephone" pattern="^(?:(?:\+|00)33[\s.-]{0,3}(?:\(0\)[\s.-]{0,3})?|0)[1-9](?:(?:[\s.-]?\d{2}){4}|\d{2}(?:[\s.-]?\d{3}){2})$">
       
    </div>
    </section>
    </main>
    
<input name="btCréer" type="submit" value="Créer"
title="Créer votre inscription">
<input name="btAnnuler" type="reset" value="Annuler"
title="Annulez votre saisie">
  
    
</form>
</body>
</html>


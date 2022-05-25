<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
	<h1>Mon Profil</h1>
	<form action="/ServletInscription" method="post">
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
        <input type="tel" id="telephone" name="Telephone">
        pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5}|(\(?\d{2,6}\)?))(-|)?)
        (\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$"</input>
    </div>
    
    
   
    
</form>
</body>
</html>


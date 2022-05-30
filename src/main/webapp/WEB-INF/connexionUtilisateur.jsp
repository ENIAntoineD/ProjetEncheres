<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
<h1>Se connecter:</h1>

<div>


<form method="post"  action="ServletConnectionUtilisateur" name="SeConnecter">
<label>Identifiant :</label><input type="text" name="pseudo" title="Le pseudo doit contenir uniquement des caractères alphanumériques" placeholder ="exemple: DarkMimol256"  pattern="^[a-zA-Z0-9@.]{2,10}$"required="required" autofocus="autofocus">
<br>
<label>Mot de passe :</label><input type="password" placeholder="Exemple : JesuistonPère25" name="motdepasse" required="required">
<br>
<button type="submit">Connexion</button>
<input type="checkbox">Se souvenir de moi<br>
<a href="">Mot de passe oublié</a>

</form>

<form action="ServletInscription" name="Creer">

<a href="ServletInscription"><button>Créer un compte</button></a>

</form>

<%@ include file="retourAccueil.html" %>
</div>



</body>
</html>
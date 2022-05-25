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
<a href="">Pas de compte? s'inscrire</a>
<form method="post"  action="ServletConnectionUtilisateur">
<label>Pseudo :</label><input type="text" placeholder ="exemple: DarkMimol256"   pattern="^[a-zA-Z0-9@.]{2,10}$" name="pseudo" required="required" autofocus="autofocus" title="Le pseudo doit contenir uniquement des caractères alphanumériques" >
<br>
<label>Mot de passe :</label><input type="password" name="motdepasse" required="required" placeholder="Exemple : JesuistonPère25">
<br>
<p style="color: red"> Le nom d'utilisateur ou le mot de passe est incorrect    </p>
<button type="submit">Valider</button>

<a href="">Mot de passe oublié</a>
</form>


</div>
<%@include file="retourAccueil.html" %>

</body>
</html>
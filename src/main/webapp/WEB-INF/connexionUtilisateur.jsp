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
<form method="post"  action="ServletConnectionUtilisateur">
<label>Pseudo :</label><input type="text" name="pseudo">
<br>
<label>Mot de passe :</label><input type="password" name="motdepasse">
<br>
<button type="submit">Valider</button>
</form>


</div>

</body>
</html>
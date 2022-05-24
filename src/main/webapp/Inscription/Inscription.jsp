<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
	<h1>S'inscrire.</h1>
	<form action="/ServletInscription" method="post">
    <div>
        <label for="pseudo">Pseudo :</label>
        <input type="text" id="pseudo" name="pseudo">
    </div>
    <div>
        <label for="password">Mot De Passe</label>
        <input type="password" id="password" name="motdepasse"></input>
    </div>
    <div>
        <label for="mail">e-mail:</label>
        <input type="email" id="mail" name="email">
    </div>
    
</form>
</body>
</html>


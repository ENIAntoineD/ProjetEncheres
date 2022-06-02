<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/General.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/connexionUtilisateur.css">
<title>Connexion</title>
</head>
<body>
<header>
<div class="entete">
<%@ include file="../html/retourAccueil.html" %>
</div >
<h1>Se connecter:</h1>
<h2>Eni Enchères</h2>
</header>
<div>


<form method="post"  action="ServletConnectionUtilisateur" name="SeConnecter">
<label>Identifiant :</label><input type="text" name="pseudo" title="Le pseudo doit contenir uniquement des caractères alphanumériques" placeholder ="exemple: DarkMimol256"  pattern="^[a-zA-Z0-9@.]{2,10}$"required="required" autofocus="autofocus">
<br>
<label>Mot de passe :</label><input type="password" placeholder="**********" name="motdepasse" required="required">
<br>
<button type="submit">Connexion</button>
<div>
<input type="checkbox" name="souvenir" class="souvenir">Se souvenir de moi
</div>
<a href="">Mot de passe oublié</a>

</form>

<form action="ServletInscription" name="Creer">

<a href="ServletInscription"><button>Créer un compte</button></a>

</form>


</div>



</body>
</html>
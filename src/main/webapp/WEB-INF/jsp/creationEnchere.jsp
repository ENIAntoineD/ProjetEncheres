<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/General.css">
<title>Creation</title>
</head>
<body>
<header>
		<div class="entete">
	 <%@ include file="../html/retourAccueil.html" %>
	 </div>
	<h1>Création d'une enchère</h1>
	<h2>ENI-Encheres</h2> 

	</header>
	
	<form action="ServletInscription" method="post">
	<main>
	
    <div>
        <label for="nom">Article:</label>
        <input type="text" id="nom" name="nom">
    </div>
    <div>
        <label for="description">Description :</label>
        <input type="text" id="description" name="description"></input>
    </div>
    <div>
    <fieldset>
        <label for="categorie">categories :</label>
     <select name="categories" id="categories">
			<option>Informatique</option>
			<option>Ameublement</option>
			<option>Vêtement</option>
			<option>Sport</option>
			<option>Loisirs</option>
		</select>
		</fieldset>
    </div>
    <div>
        <label for="p">photo de l'article :</label>
        <input type="button" id="p" name="p"> uploader
    </div>
    <div>
        <label for="map">Mise a prix :</label>
        <input type="number" id="map" name="map">
    </div>
    
    
    <div>
        <label for="deb">Début d'enchères:</label>
        <input type="date" id="deb" name="deb">
    </div>
    <div>
       <label for="fin">Fin d'enchères:</label>
        <input type="date" id="fin" name="fin">
    </div>
 
   
    </main>
    
<input name="btCréer" type="submit" value="Créer"
title="Créer votre inscription">
<input name="btAnnuler" type="reset" value="Annuler"
title="Annulez votre saisie">
  
    
</form>

</body>
</html>
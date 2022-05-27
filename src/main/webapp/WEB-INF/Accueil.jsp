<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>



    <h1>Accueil</h1>
    <h2>Test</h2>
    
    <p> <% if((boolean)session.getAttribute("connecte") == true){ 
    	
    	%>
    	<%@ include file="deconnexion.html" %>
    	
    	<%
    	
    }
    else   {    %> 
    <a href="ServletConnectionUtilisateur">se connecter</a>
    
    <%
    
    }  %>
    
       </p>
       
       <form method="get" action="ServletAccueil">
       <button type ="submit" name="test"> Test</button>
       </form>
       
       

    <h1>ENI-Encheres</h1>
    <h2>Liste des enchères</h2>
    
    <p>Filtres</p>
    
    
    <input name="btInscription" type="submit" value="S'inscrire"
title="Créer votre inscription">
	<input name="btConnection" type="submit" value="Se connecter"
title="Vous connecter">

<label for="site-search">Rechercher</label>
<input type="search" id="site-search" name="q">

	<input name="btRechercher" type="submit" value="Rechercher"
title="Effectuer une recherche">



<form name="categories" action="#"
enctype="multipart/form-data" method="post">
  <fieldset>
    <legend>Catégories</legend>
		<label for="categories">Catégories :</label>
		<select> name="categories" id="categories"
			<option>Informatique</option>
			<option>Ameublement</option>
			<option>Vêtement</option>
			<option>Sport</option>
			<option>Loisirs</option>
		</select>
    </fieldset>
</form>




</body>
</html>
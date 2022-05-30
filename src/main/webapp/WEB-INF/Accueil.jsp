<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Document</title>
</head>
<body>



    <h1>Accueil</h1>
    <h2>Test</h2>
    

       
       <form method="get" action="ServletAccueil">
       <button type ="submit" name="test"> Test</button>
       </form>
       
       
<header>
    <h1>ENI-Encheres</h1>
      
    <div>
    
    <input name="btInscription" type="submit" value="S'inscrire"
title="Créer votre inscription">
    
   
    <% if((boolean)session.getAttribute("connecte") == true){ 
    	
    	%>
    	<%@ include file="deconnexion.html" %>
    	<%
    	
    }
    else   {    %> 
    <form action="ServletConnectionUtilisateur" method="get">
    <input type="submit" value="se connecter" > 
    </form>
    <%
    
    }  %>
  </header> 
  
  <h2>Liste des enchères</h2>
  <p>Filtres</p>
       

<label for="site-search">Rechercher</label>
<input type="search" id="site-search" name="q">

	<input name="btRechercher" type="submit" value="Rechercher"
title="Effectuer une recherche">
</div>


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


<img src="PCGamer.jpg"><%--image à ajouter --%>
<p><a href="#">PC Gamer pour travailler</a></p>
<p>Prix : 210 points<br>
Fin de l'enchère : 10/08/2018
</p>
<p>Vendeur : jojo44</p>

<img src="RocketStove.jpg"><%--image à ajouter --%>
<p><a href="#">Rocket Stove pour riz et pâtes</a></p>
<p>Prix : 185 points<br>
Fin de l'enchère : 09/10/2018
</p>
<p>Vendeur : NineJea</p>



</body>
</html>
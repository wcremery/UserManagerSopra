<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
 <html>
 	<head>
 		<title>Inscription</title>
 		<link type="text/css" rel="stylesheet" href="styles.css" />
 	</head>
 	<body>
 		<form method="post" action="register">
	 		 <fieldset>
	 		 	<legend>Inscription</legend>
	 		 	<p>Formulaire d'inscription, les champs (*) sont requis :</p>
	 		 	<label for="email">Adresse email <span class="requis">*</span></label>
	 		 	<input type="text" id="email" name="email" value="${form['email']}" size="20" maxlength="60" />
	 		 	<span class="erreur">${errors['email']}</span>
	 		 	<br />
	 		 	<label for="motdepasse">Mot de passe <span class="requis">*</span></label>
	 		 	<input type="password" id="pwd1" name="pwd1" value="${form['pwd1']}" size="20" maxlength="20" />
	 		 	<span class="erreur">${errors['pwd1']}</span>
	 		 	<br />
	 		 	<label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
	 		 	<input type="password" id="pwd2" name="pwd2" value="${form['pwd2']}" size="20" maxlength="20" />
	 		 	<span class="erreur">${errors['pwd2']}</span>
	 		 	<br />
	 		 	<label for="nom">Nom d'utilisateur</label>
	 		 	<input type="text" id="name" name="name" value="${form['name']}" size="20" maxlength="20" />
	 		 	<span class="erreur">${errors['name']}</span>
	 		 	<br />
	 		 	<input type="submit" value="Enregistrement" class="sansLabel" />
	 		 	<br />
	 		 	<p class="info">${actionMessage}</p>
	 		 </fieldset>
 		</form>
 		<br />
 		<c:if test="${ !errorStatus }">
 			<c:import url="WEB-INF/user/card.jsp" />
 		</c:if>
 	</body>
</html> 
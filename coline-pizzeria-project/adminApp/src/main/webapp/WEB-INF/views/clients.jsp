<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="fr.pizzeria.model.Client" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>List of customers</title>
</head>
<script type="text/javascript">
$(document)
		.ready(
				function() {
					$("#ajout_client").hide();
					$("#ajouter a").click(function() {
						$("#ajout_client").show();
					});
					$("#hide_ajout").click(function() {
						$("#ajout_client").hide();
					});
					$
							.ajax({
								url : 'http://localhost:8080/adminApp/api/rest/clients',
								type : 'GET',
								dataType : 'JSON',
								success : function(data) {
									console.log(data);
									$
											.each(
													data,
													function(index, value) {
														console.log(index);
														$("#tablecontent")
																.append(
																		"<tr><td>"
																				+ value['nom']
																				+ "</td><td>"
																				+ value['prenom']
																				+ "</td><td>"
																				+ value['telephone']
																				+ "</td><td>"
																				+ value['rue']
																				+ "</td><td>"
																				+ value['ville']
																				+ "</td></tr>");
													});
								}
							});
				});
				
				
</script>

<body>
	<h1>Clients</h1>
	<table>
    	<thead><th>id</th><th>nom</th><th>prenom</th><th>téléphone</th><th>adresse</th><th>ville</th></thead>
	

        	<tbody id="tablecontent"> 
        
        	</tbody>
	
	
	 </table>
	 
	 <div id="ajouter">
					<a href="#" class="btn btn-success">Ajouter un nouveau client</a>
				</div>
				
	 <form name="ajout_client"  method="post">
		<h3>Créer un client</h3>
		Nom <input type="text" name="nom"> Prénom <input type="text" name="prenom"><br>
		Adresse <input type="text" name="num" placeholder="n°" style="width:12px"> <input type="text" name="adresse" placeholder="nom de rue" style="width:256px"><br>
		Ville <input type="text" name="ville">  Téléphone <input type="text" name="tel"><br><br>
		<input type="submit" value="Ajouter client" id="add"> 
		<button><a id="hide_ajouter" href="#" class="btn btn-primary">retour </a></button>
		
	</form>
</body>
</html>
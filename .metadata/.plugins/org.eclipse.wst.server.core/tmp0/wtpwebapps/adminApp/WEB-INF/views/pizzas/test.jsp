<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.List" %>
<%@ page import="fr.pizzeria.model.Pizza" %>   


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mes pizzas</title>
</head>
<body>
<!--  table>
<tr><td>0</td><td>FLE</td><td>Fl�tan</td><td>8,90</td></tr>
<tr><td>2</td><td>BRE</td><td>Bretonne</td><td>12,90</td></tr>
</table>-->

    <table>
    <thead><th>id</th><th>code</th><th>libelle</th><th>prix</th></thead>
<%
List<Pizza> pizzas = (List<Pizza>)request.getAttribute("Pizzas");


for(Pizza p: pizzas) {

%>

        <tr> 
                <td> <%= p.getId()%></td>
                <td> <%= p.getCode()%></td>
                <td> <%= p.getNom() %></td>
                <td> <%= p.getPrix()%></td>
                <td> <%= p.getCat()%></td>
                
        
        </tr>
        
   
<%}%>

	 </table>

</body>
</html>
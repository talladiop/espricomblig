<%@page import="entites.Region"%>
<%@page import="entites.Enqueteur"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

 <%@page import="java.util.*"%>
<jsp:useBean id="service" class="FactoryService.FactoryService"></jsp:useBean>

<%
//intentiation du entreprise
Enqueteur cptcl=new Enqueteur();
//recuperation session
cptcl=(Enqueteur)session.getAttribute("session1administrator");

//verification validite session
 if(cptcl !=null)
     {
%>



<!DOCTYPE html>
<!--

Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Title      : Excess
Version    : 1.0
Released   : 20090210
Description: A two-column, fixed-width and lightweight template ideal for 1024x768 resolutions. Suitable for blogs and small websites.

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="shortcut icon" href="images/iconbar.ico" />

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>SPCD</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />


<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

</head>
<body>
<!-- start header -->
<div id="header">
	<div id="logo">
		<h1><a href="#">Etude<sup></sup></a></h1>
	  <h2>suivi de prix des combustibles domestiques </h2>
	  <div id="menu">
	    <ul>
	      <li class="active"><a href="produitGAZcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Produit Gaz</a></li>
	      <li></li>
	      <li><a href="produitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Produit CL</a></li>
	      <li><a href="cuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Equipement cuisson</a></li>
	      <li><a href="enqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Enqueteur</a></li>
          <li><a href="superviseurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Superviseur</a></li>
	      <li>
	        <form name="form1" method="post" action="LogOutAdmin">
	          <input type="submit" name="button3" id="button3" value="Déconnexion">
            </form>
	      </li>
        </ul>
      </div>
	</div>
</div>
<p>
  <!-- end header -->
  
  <!-- start page -->
  </p>
<p>&nbsp;</p>
<table width="1167" border="0" align="center" cellpadding="0" cellspacing="0" class="arrow">
  <tr bgcolor="#66CC66">
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="4" align="center" bgcolor="#66CC66" class="bleu">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td align="center"><span class="bleu">Validation</span></td>
    <td colspan="4" align="center" class="bleu">VISUALISATION</td>
    <td align="center" bgcolor="#66CC66">&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td align="center" bgcolor="#66CC66">&nbsp;</td>
  </tr>
  <tr bgcolor="#66CC66">
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">Variation  prix gaz suivant les mois</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
  </tr>
  <tr>
    <td width="10" bgcolor="#66CC66">&nbsp;</td>
    <td width="228"><p><a href="affacheTousEnquetecdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Enquête Gaz</a></p>
    <p><a href="affacheTousEnquete-PL-cdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Enquête Produits Ligneux</a> </p>
    <p><a href="affacheTousEnquete-Cuisson-cdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Enquête Equipement Cuisson</a> </p>
    <p><a href="affacheTousEnquete-Inventairegaz-cdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Stock Inventaire Gaz</a></p></td>
    <td width="4" bgcolor="#66CC66">&nbsp;</td>
    <td width="255"><form name="form3" method="post" action="graphe/regionaaaaaaaatroisdddddepartementssssssssssssssssssss.jsp">
      <p>Par Mois
        <select name="mois" id="mois">
          <option value="1">Janvier</option>
          <option value="2">Fevrier</option>
          <option value="3">Mars</option>
          <option value="4">Avril</option>
          <option value="5">Mai</option>
          <option value="6">Juin</option>
          <option value="7">Juillet</option>
          <option value="8">Aout</option>
          <option value="9">Septembre</option>
          <option value="10">Octobre</option>
          <option value="11">Novembre</option>
          <option value="12">Decembre</option>
        </select>
      </p>
      <p>Région
        <select  required="true" name="region" id="region">
          <%
			 Region rg = new Region();
                      
   			List<Region> gpList = service.regionServiceDao.findAll();
                       for(Region drp :gpList){
	                   %>
          <option value="<%=drp.getIDregion() %>"><%=drp.getNomregion() %></option>
          <%
				     }
			
		              %>
        </select>
        <input type="submit" name="button" id="button" value="Visualiser">
      </p>
    </form></td>
    <td width="4" bgcolor="#66CC66">&nbsp;</td>
    <td width="238"><form name="form2" method="post" action="graphe/ecart-prixdetail-prixgros-region-prix-gaz-enquetegazcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">
      <p>Toutes Région</p>
      <p>Mois
        <select name="mois" id="mois">
          <option value="1">Janvier</option>
          <option value="2">Fevrier</option>
          <option value="3">Mars</option>
          <option value="4">Avril</option>
          <option value="5">Mai</option>
          <option value="6">Juin</option>
          <option value="7">Juillet</option>
          <option value="8">Aout</option>
          <option value="9">Septembre</option>
          <option value="10">Octobre</option>
          <option value="11">Novembre</option>
          <option value="12">Decembre</option>
        </select>
        <input type="submit" name="button2" id="button2" value="Visualiser">
      </p>
    </form></td>
    <td width="10" bgcolor="#66CC66">&nbsp;</td>
    <td width="409">&nbsp;</td>
    <td width="15" bgcolor="#66CC66">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">Ecarte prix Gaz Suivant Deux dates</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td><a href="graphe/evolutionnnnnnnnnnnnnnnnnnnnnnnndessssssssssssssssssstoccccccccccccck.jsp">Evolution des stocks de gaz</a></td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td><form name="form2" method="post" action="graphe/deux-date-ecart-prixdetail-prixgros-region-prix-gaz-enquetegazcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">
      <p>Toutes Région</p>
      <p>
        <% 
	if(request.getParameter("admoneth23987hiceadmin")!=null ){
	String code=request.getParameter("admoneth23987hiceadmin");
	  	 if(code.equalsIgnoreCase("076430343")){
			
			  out.print("<font color='red'> Echec Vérifier bien les date à entrer !</font><br>");
			 
		 }else{
		 
		 out.print("<font color='green'> Affichage r&eacute;ussi ! </font><br>");
		 }
	}
	%>
        <select name="mois1" id="mois1">
          <option value="1">Janvier</option>
          <option value="2">Fevrier</option>
          <option value="3">Mars</option>
          <option value="4">Avril</option>
          <option value="5">Mai</option>
          <option value="6">Juin</option>
          <option value="7">Juillet</option>
          <option value="8">Aout</option>
          <option value="9">Septembre</option>
          <option value="10">Octobre</option>
          <option value="11">Novembre</option>
          <option value="12">Decembre</option>
        </select>
      </p>
      <p>
        <select name="mois2" id="mois2">
          <option value="1">Janvier</option>
          <option value="2">Fevrier</option>
          <option value="3">Mars</option>
          <option value="4">Avril</option>
          <option value="5">Mai</option>
          <option value="6">Juin</option>
          <option value="7">Juillet</option>
          <option value="8">Aout</option>
          <option value="9">Septembre</option>
          <option value="10">Octobre</option>
          <option value="11">Novembre</option>
          <option value="12">Decembre</option>
        </select>
        <input type="submit" name="button4" id="button4" value="Visualiser">
      </p>
    </form></td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td><a href="graphe/evolution-stock-gaz-annee-ddjschjcdjhhdhcgehcgehjcghgdc-cdcdhcdhgchgcscgscs-dccvsghcvd.jsp">Evolution stock CL par région</a></td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>Espace Administrateur</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>
  <!-- end page -->
  <!-- start footer -->
</p>
<div id="footer">
  <div id="footer-menu"></div>
	<p id="legal">(c) Copyright 2012 </p>
</div>
<!-- end footer -->
</body>
</html>
 <% }else{
response.sendRedirect("administrateur.jsp?edygeuguyegygfefd=655&dfdefgff=65shxhjcvhvdc&dfdfedjfbjfbgrjkgfrjhgbrjgbrgjhh=76543bjbjkvbjf");
 }
%>

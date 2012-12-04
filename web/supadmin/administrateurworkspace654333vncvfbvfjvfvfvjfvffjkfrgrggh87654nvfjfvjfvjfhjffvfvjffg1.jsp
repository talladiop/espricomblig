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
    <td colspan="4" align="center" class="bleu">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
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
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
  </tr>
  <tr>
    <td width="10" bgcolor="#66CC66">&nbsp;</td>
    <td width="228"><a href="affacheTousEnquetecdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Enquête Gaz</a></td>
    <td width="4" bgcolor="#66CC66">&nbsp;</td>
    <td width="255"><p>Par Mois
      <select name="select" id="select">
      </select>
    </p>
      <p>Région

        <select name="select3" id="select3">
        </select>      
        <input type="submit" name="button" id="button" value="Visualiser">
    </p></td>
    <td width="4" bgcolor="#66CC66">&nbsp;</td>
    <td width="232"><p>Toutes Région</p>
      <p>Mois
  <select name="select2" id="select2">
  </select>
        <input type="submit" name="button2" id="button2" value="Visualiser">
    </p></td>
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
    <td bgcolor="#66CC66">&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td>&nbsp;</td>
    <td bgcolor="#66CC66">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#66CC66">&nbsp;</td>
    <td><a href="affacheTousEnquete-PL-cdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Enquête Produits Ligneux</a></td>
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
    <td><a href="affacheTousEnquete-Cuisson-cdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Enquête Equipement Cuisson</a></td>
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
    <td><a href="affacheTousEnquete-Inventairegaz-cdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Stock Inventaire Gaz</a></td>
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
response.sendRedirect("index.jsp?edygeuguyegygfefd=655&dfdefgff=65shxhjcvhvdc&dfdfedjfbjfbgrjkgfrjhgbrjgbrgjhh=76543bjbjkvbjf");
 }
%>

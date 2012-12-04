<%@page import="entites.Departement"%>
<%@page import="entites.Enqueteur"%>
<%@page import="entites.Cuisson"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

 <%@page import="java.util.*"%>
<jsp:useBean id="service" class="FactoryService.FactoryService"></jsp:useBean>


<%

 
//intentiation du enqueteur
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
  
  <!-- start page --> <form id="form1" name="form1" 
class="form-inline well" method="post" action="ModifCuisson">
  <table width="420" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0">Modification Equipement Cuisson</td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><% 
	if(request.getParameter("mod39876ytre54320jhg543")!=null ){
	String code=request.getParameter("mod39876ytre54320jhg543");
	  	 if(code.equalsIgnoreCase("04469578")){
			
			  out.print("<font color='red'> Echec Modification!</font><br>");
			  out.print("<font color='red'> Vérifier bien les champs à remplir</font><br>");
		 }else{
		 
		 out.print("<font color='green'> Modification r&eacute;ussi ! </font><br>");
		 }
	}
	%></td>
    </tr>
    <%
        Cuisson ef = new Cuisson();
	  
	  ef = service.cuissonServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("dest65432id5432")));


%>
    <tr>
      <td align="right" bgcolor="#D0D0D0"><label for="nomprod">Nom produit </label>
        <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input name="nomprod" type="text" id="nomprod" value="<%=ef.getNomCuisson()  %>" size="20" required="true" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><input type="submit" name="button" id="button" value="Modifier" />
        <input name="cmd" type="hidden" id="cmd" value="Mod" />
        <input name="idequishhhhshs" type="hidden" id="idequishhhhshs" value="<%=ef.getIdCuisson() %>" /></td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#D0D0D0">Les champs en <span class="red">*</span> ne doivent pas être vide</td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
  </table>
</form></p>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr bgcolor="#AAAAFF">
    <td colspan="5" align="center" bgcolor="#E4E4E4">Liste de vos équipements </td>
  </tr>
  <tr bgcolor="#AAAAFF">
    <td bgcolor="#D0D0D0"><div align="center"><strong><span class="feature-title">Nom produit</span></strong></div></td>
    <td width="232" bgcolor="#D0D0D0"><div align="center"><strong><span class="feature-title">Modifier</span></strong></div></td>
    <td bgcolor="#D0D0D0">&nbsp;</td>
  </tr>
  <%
            //ProduitCl eq = new ProduitCl();
            
               
         List<Cuisson> eqList = service.cuissonServiceDao.findAll();
               for(Cuisson dest :eqList)
                    {
                   
%>
  <tr>
    <td align="left" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getNomCuisson() %></span></td>
    <td align="center" bgcolor="#F1F1F1"><strong><a href="modifcuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefemodifproduitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?dest65432id5432=<%=dest.getIdCuisson() %>">modifier</a></strong></td>
  </tr>
  <%
   }
     
%>
</table>
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

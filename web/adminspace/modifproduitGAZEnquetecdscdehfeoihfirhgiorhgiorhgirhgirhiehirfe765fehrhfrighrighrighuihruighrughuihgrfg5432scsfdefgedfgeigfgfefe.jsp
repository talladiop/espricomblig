<%@page import="entites.ProduitGaz"%>
<%@page import="entites.Enqueteur"%>
<%@page import="entites.Localite"%>
<%@page import="entites.Region"%>
<%@page import="entites.EnqueteGaz"%>
<%@page import="entites.Departement"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

 <%@page import="java.util.*"%>
<jsp:useBean id="service" class="FactoryService.FactoryService"></jsp:useBean>

<%! 
Departement dpart = null;

%>

<%

//intentiation du entreprise
Enqueteur cptcl=new Enqueteur();
//recuperation session
cptcl=(Enqueteur)session.getAttribute("session1enqueteur");

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
<title><%="SPCD" %><%="|"%><%=cptcl.getLogin() %></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />


<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<style type="text/css">
<!--
.bleu {color: #46A3FF;
}
.bleu {	color: #00F;
}
.bleu1 {color: #46A3FF;
}
-->
</style>
</head>
<body>
<!-- start header -->
<div id="header">
	<div id="logo">
		<h1><a href="#">Etude<sup></sup></a></h1>
	  <h2>suivi de prix des combustibles domestiques | Espace  <%=cptcl.getPrenomenqueteur() %><%=" "%><%=cptcl.getNomenqueteur() %></h2>
	  <div id="menu">
	    <ul>
	      <li class="active"><a href="enquetegazcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Suivi_Gaz</a></li>
	      <li></li>
	      <li><a href="produitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Suivi_CL</a></li>
	      <li><a href="inventairegazcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Inventaire_Stock_gaz</a></li>
	      <li><a href="cuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Suivi_Eq-cuisson</a></li>
	      <li><a href="enqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Enqueteur</a></li>
        </ul>
      </div>
	</div>
</div>
<p>
  <!-- end header -->
  
  <!-- start page --></p>
<form id="form1" 
class="form-inline well" name="form1" method="post" action="ModifEnqueteGaz">
  <p>&nbsp;</p>
  <table width="410" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0">Modification | SUIVI DES PRIX DE GAZ Région <span class="bleu"><%=cptcl.getDepartement().getRegion().getNomregion() %></span></td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><% 
	if(request.getParameter("admoneth23984outputofficeceadmin")!=null ){
	String code=request.getParameter("admoneth23984outputofficeceadmin");
	  	 if(code.equalsIgnoreCase("04469578")){
			
			  out.print("<font color='red'> Echec Modification !</font><br>");
			  out.print("<font color='red'> Vérifier bien les champs à remplir</font><br>");
		 }else{
		 
		 out.print("<font color='green'> Enregistrement r&eacute;ussi ! </font><br>");
		 }
	}
	%></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0">Gaz <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><select  required="true" name="gaz" id="gaz">
        <%
			 //recherche objet inventaire
                         EnqueteGaz ef = service.enquetegazServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("dest65432id5432")));
                         
                      
   			List<ProduitGaz> gpList = service.produitgazServiceDao.findAll();
                       for(ProduitGaz drp :gpList){
	                   %>
        <option value="<%=drp.getIdProduitgaz() %>" <% if(drp.getNomProduitgaz().equals(ef.getProduitgaz().getNomProduitgaz()))out.print("Selected") ;%>><%=drp.getNomProduitgaz() %></option>
        <%
				     }
			
		              %>
      </select></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0"><label for="pcg">Prix Gros </label>
        <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input name="pcg" type="text" id="pcg" value="<%=ef.getPrixCuGros() %>" size="20" required="true" /></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0">Prix Détail <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input name="pcd" type="text" id="pcd" value="<%=ef.getPrixCuDetail() %>" size="20" required="true" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><input type="submit" name="button" id="button" value="Modifier" />
      <input name="idenqueu" type="hidden" id="idenqueu" value="<%=cptcl.getIdenqueteur()  %>" />
      <input name="dest65432id5432" type="hidden" id="dest65432id5432" value="<%=ef.getIdEnqueteGaz() %>">
      <input name="region" type="hidden" id="region" value="<%=ef.getRegion() %>">
      <input name="mois" type="hidden" id="mois" value="<%=ef.getMois() %>">
      <input name="annee" type="hidden" id="annee" value="<%=ef.getAnnee() %>"></td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#D0D0D0">Les champs en <span class="red">*</span> ne doivent pas être vide</td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
  </table>
</form>
<p>&nbsp;</p>
<table width="1002" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr bgcolor="#AAAAFF">
    <td colspan="5" align="center" bgcolor="#E9E9E9">Liste de vos produit GAZ </td>
  </tr>
  <tr bgcolor="#AAAAFF">
    <td width="149" bgcolor="#D0D0D0"><div align="center"><strong><span class="feature-title">Nom produit</span></strong></div></td>
    <td width="173" align="center" bgcolor="#D0D0D0">Prix Gros</td>
    <td width="168" align="center" bgcolor="#D0D0D0">Prix Détail </td>
    <td width="151" bgcolor="#D0D0D0">Date d'enregistrement</td>
    <td width="81" bgcolor="#D0D0D0">&nbsp;</td>
  </tr>
  <%
            //recherche departement enqueteur
            Departement ddp = new Departement();
            ddp = service.departeServiceDao.findByPrimaryKey(cptcl.getDepartement().getIDdepartement());
  
  
            //Intentiation objet enquetegaz
             EnqueteGaz engaz = new EnqueteGaz();
             //specification du departement
             engaz.setDepartement(ddp);
             engaz.setValider("0");
            
               
         List<EnqueteGaz> eqList = service.enquetegazServiceDao.findByValue(engaz);
               for(EnqueteGaz dest :eqList)
                    {
                   
%>
  <tr>
    <td align="left" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getProduitgaz().getNomProduitgaz() %></span></td>
    <td align="center"><strong><span class="bleu1"><%=dest.getPrixCuGros() %></span></strong></td>
    <td align="center"><strong><span class="bleu1"><%=dest.getPrixCuDetail() %></span></strong></td>
    <td align="center"><strong><span class="bleu1"><%=dest.getDateEnquete() %></span></strong></td>
    <td align="center"><strong><a href="modifproduitGAZEnquetecdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?dest65432id5432=<%=dest.getIdEnqueteGaz() %>">modifier</a></strong></td>
  </tr>
  <%
   }
     
%>
</table>
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

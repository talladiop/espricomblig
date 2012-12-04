<%@page import="entites.EnqueteEquipement"%>
<%@page import="DAO.EnqueteEquipementImpl"%>
<%@page import="entites.Cuisson"%>
<%@page import="entites.Enqueteur"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

 <%@page import="java.util.*"%>
<jsp:useBean id="service" class="FactoryService.FactoryService"></jsp:useBean>

<%
//intentiation du entreprise
Enqueteur cptcl=new Enqueteur();
//recuperation session
cptcl=(Enqueteur)session.getAttribute("session1administratorregion");

//verification validite session
 if(cptcl !=null)
     {
		 
		 
		  //validation enquete
    if(request.getParameter("valider")!=null)
      {
        //validation enquete niveau regional
	service.enqueteequipementSrv.Valider(Integer.parseInt(request.getParameter("valider")));
     }
   
   
   //validation toutes enquete niveau regional
    if(request.getParameter("toutvalide")!=null)
      {
        //intentiation objet enquetecl
        EnqueteEquipement eqg = new EnqueteEquipement();
        //recherche enquete non valider
        eqg.setValider("0");
        eqg.setValiderfinale("0");
        
         List<EnqueteEquipement> eqListtous = service.enqueteequipementSrv.findByValue(eqg);
               for(EnqueteEquipement desttous :eqListtous)
                    {
                    if(desttous.getDepart().getRegion().getIDregion() == cptcl.getDepartement().getRegion().getIDregion())
                  {
        //activation du compte
	service.enqueteequipementSrv.Valider(desttous.getIdenquete());
        
           }
            }
     }
		 
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
<title><%="SPCD" %><%="|"%><%=cptcl.getDepartement().getRegion().getNomregion() %></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />


<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<style type="text/css">
<!--
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
	  <h2>suivi de prix des combustibles domestiques | Espace <%=cptcl.getPrenomenqueteur() %><%=" "%><%=cptcl.getNomenqueteur() %></h2>
	  <div id="menu">
	    <ul>
	      <li class="active"><a href="enquete-gaz-region-workspace654333vncvfbvfjvfvfvjfvffjkfrgrggh87654nvfjfvjfvjfhjffvfvjffg1.jsp">Visualiser enquete Gaz</a></li>
	      <li><a href="enquete-inventaire-region-workspace654333vncvfbvfjvfvfvjfvffjkfrgrggh87654nvfjfvjfvjfhjffvfvjffg1.jsp">Visualiser inventaire stock Gaz</a></li>
	      <li><a href="enquete-cl-region-workspace654333vncvfbvfjvfvfvjfvffjkfrgrggh87654nvfjfvjfvjfhjffvfvjffg1.jsp">Visualiser enquete CL</a>
          <li><a href="enquete-cuisson-region-workspace654333vncvfbvfjvfvfvjfvffjkfrgrggh87654nvfjfvjfvjfhjffvfvjffg1.jsp">Visualiser enquete Cuisson</a></li>
	      <li>
	        <form name="form1" method="post" action="LogOutAdminRegion">
	          <input type="submit" name="button" id="button" value="Déconnexion">
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
<p><img src="images/four.JPG" width="65" height="70"></p>
<p><a href="enquete-cuisson-region-workspace654333vncvfbvfjvfvfvjfvffjkfrgrggh87654nvfjfvjfvjfhjffvfvjffg1.jsp?ffdf=65&toutvalide=654re&stgx=65"><img src="images/val.JPG" width="19" height="22">Cliquer pour valider toutes les enquêtes</a></p>
<table width="1120" border="0" align="center" cellpadding="0" cellspacing="0" class="tail12">
  <tr bgcolor="#AAAAFF">
    <td colspan="13" align="center" bgcolor="#CCCCCC"><strong>Liste de toutes les enquêtes d'équipement cuisson de la Région de <%=cptcl.getDepartement().getRegion().getNomregion()  %></strong></td>
  </tr>
  <tr bgcolor="#AAAAFF">
    <td width="194" bgcolor="#ADADAD"><div align="center"><strong>Produit</strong></div></td>
    <td width="3" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="150" bgcolor="#ADADAD"><strong> Prix Achat</strong></td>
    <td width="3" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="129" bgcolor="#ADADAD"><strong>Prix de Vente</strong></td>
    <td width="3" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="149" bgcolor="#ADADAD"><strong>Quantité disponible</strong></td>
    <td width="3" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="158" bgcolor="#ADADAD"><div align="center"><strong><span class="feature-title">Date d'enregistrement</span></strong></div></td>
    <td width="3" align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="148" align="center" bgcolor="#ADADAD"><strong><span class="feature-title">Département</span></strong></td>
    <td width="3" align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="92" align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="82" align="center" bgcolor="#FFFFFF">&nbsp;</td>
  </tr>
  <%
            //instentiation de l'objet enquetegaz
           EnqueteEquipement enqgcl = new EnqueteEquipement();
           //especification de la recherche
           enqgcl.setValider("0");
           enqgcl.setValiderfinale("0");
           
               
         List<EnqueteEquipement> eqList = service.enqueteequipementSrv.findByValue(enqgcl);
               for(EnqueteEquipement dest :eqList)
                    {
                   if(dest.getDepart().getRegion().getIDregion() == cptcl.getDepartement().getRegion().getIDregion())
                  {
                      
%>
  <tr>
    <td align="left" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getEquipement().getNomCuisson() %></span></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getPrixAchat() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getPrixVente() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getQte() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getDateEnquete() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><span class="bleu1"><%=dest.getDepart().getNomdepartement() %></span></td>
    <td align="center" bgcolor="#F1F1F1">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><strong><span class="feature-title"><a href="enquete-cuisson-region-workspace654333vncvfbvfjvfvfvjfvffjkfrgrggh87654nvfjfvjfvjfhjffvfvjffg1.jsp?valider=<%=dest.getIdenquete() %>&ffdf=65&tofhhffhf=<%=dest.getIdenquete() %>stgx=65">valider</a></span></strong></td>
  </tr>
  <%
   }
   
     }
%>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
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
response.sendRedirect("locale.jsp?edygeuguyegygfefd=655&dfdefgff=65shxhjcvhvdc&dfdfedjfbjfbgrjkgfrjhgbrjgbrgjhh=76543bjbjkvbjf");
 }
%>

<%@page import="entites.EnqueteGaz"%>
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
	service.enquetegazServiceDao.ValiderEnquete(Integer.parseInt(request.getParameter("valider")));
     }
   
   
   //validation toutes enquete niveau regional
    if(request.getParameter("toutvalide")!=null)
      {
        //intentiation objet enquetegaz
        EnqueteGaz eqgaz = new EnqueteGaz();
        //recherche enquete non valider
        eqgaz.setValider("0");
        eqgaz.setValiderfinale("0");
        
         List<EnqueteGaz> eqListtous = service.enquetegazServiceDao.findByValue(eqgaz);
               for(EnqueteGaz desttous :eqListtous)
                    {
                    if(desttous.getDepartement().getRegion().getIDregion() == cptcl.getDepartement().getRegion().getIDregion())
                  {
        //activation du compte
	service.enquetegazServiceDao.ValiderEnquete(desttous.getIdEnqueteGaz());
        
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
<p><img src="images/bouteillegaz.JPG" width="79" height="72"></p>
<p><a href="enquete-gaz-region-workspace654333vncvfbvfjvfvfvjfvffjkfrgrggh87654nvfjfvjfvjfhjffvfvjffg1.jsp?ffdf=65&toutvalide=654re&stgx=65"><img src="images/campinegaz.JPG" width="20" height="20">Cliquer pour valider toutes les enquêtes</a></p>
<table width="1120" border="0" align="center" cellpadding="0" cellspacing="0" class="tail12">
  <tr bgcolor="#AAAAFF">
    <td colspan="14" align="center" bgcolor="#CCCCCC"><strong>Liste de toutes les enquêtes de Gaz  de la Région de <%=cptcl.getDepartement().getRegion().getNomregion()  %></strong></td>
  </tr>
  <tr bgcolor="#AAAAFF">
    <td width="112" bgcolor="#ADADAD"><div align="center"><strong>Produit</strong></div></td>
    <td width="4" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="109" bgcolor="#ADADAD"><strong>Prix Gros</strong></td>
    <td width="4" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="132" bgcolor="#ADADAD"><strong>Prix Détail </strong></td>
    <td width="3" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="3" align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="113" align="center" bgcolor="#ADADAD"><strong><span class="feature-title">Date d'enregistrée</span></strong></td>
    <td width="3" align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="117" align="center" bgcolor="#ADADAD"><strong><span class="feature-title">Département</span></strong></td>
    <td width="3" align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="114" align="center" bgcolor="#ADADAD"><strong>Région</strong></td>
    <td width="53" align="center" bgcolor="#FFFFFF">modifier</td>
    <td width="51" align="center" bgcolor="#FFFFFF">&nbsp;</td>
  </tr>
  <%
            //instentiation de l'objet enquetegaz
           EnqueteGaz enqgaz = new EnqueteGaz();
           //especification de la recherche
           enqgaz.setValider("0");
           enqgaz.setValiderfinale("0");
           
               
         List<EnqueteGaz> eqList = service.enquetegazServiceDao.findByValue(enqgaz);
               for(EnqueteGaz dest :eqList)
                    {
                   if(dest.getDepartement().getRegion().getIDregion() == cptcl.getDepartement().getRegion().getIDregion())
                  {
                      
%>
  <tr>
    <td align="left" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getProduitgaz().getNomProduitgaz() %></span></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getPrixCuGros() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getPrixCuDetail() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getDateEnquete() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getDepartement().getNomdepartement() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><span class="bleu1"><%=dest.getDepartement().getRegion().getNomregion() %></span></td>
    <td align="center" bgcolor="#F1F1F1"><img src="images/modif.JPG" width="24" height="21"></td>
    <td align="center" bgcolor="#F1F1F1"><strong><span class="feature-title"><a href="enquete-gaz-region-workspace654333vncvfbvfjvfvfvjfvffjkfrgrggh87654nvfjfvjfvjfhjffvfvjffg1.jsp?valider=<%=dest.getIdEnqueteGaz() %>&ffdf=65&tofhhffhf=<%=dest.getIdEnqueteGaz() %>stgx=65">valider</a></span></strong></td>
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

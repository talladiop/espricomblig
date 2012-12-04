<%@page import="entites.EnqueteGaz"%>
<%@page import="entites.Enqueteur"%>
<%@page import="entites.ProduitGaz"%>
<%@page import="entites.Region"%>
<%@page import="entites.Departement"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

 <%@page import="java.util.*"%>
<jsp:useBean id="service" class="FactoryService.FactoryService"></jsp:useBean>

<%! 
Departement dpart = null;

%>

<%

//intentiation du enqueteur
Enqueteur cptcl=new Enqueteur();
//recuperation session
cptcl=(Enqueteur)session.getAttribute("session1administrator");

//verification validite session
 if(cptcl !=null)
     {
		 
		 //determination Date enregistrement
    java.util.Calendar currDate = new java.util.GregorianCalendar();
   // add 1 to month because Calendar's months start at 0, not 1
   int month = currDate.get(currDate.MONTH)+1;
   int day = currDate.get(currDate.DAY_OF_MONTH);
   int year = currDate.get(currDate.YEAR);
   int minute = currDate.get(currDate.MINUTE);
   int seconde = currDate.get(currDate.SECOND);
   int heure = currDate.get(currDate.HOUR);
   
   
   
   //validation enquete
    if(request.getParameter("valider")!=null)
      {
        //activation du compte
	service.enquetegazServiceDao.ValiderEnqueteFinale(Integer.parseInt(request.getParameter("valider")));
     }
   
   
   //validation toutes enquete
    if(request.getParameter("toutvalide")!=null)
      {
        //intentiation objet enquetegaz
        EnqueteGaz eqgaz = new EnqueteGaz();
        //recherche enquete non valider
        eqgaz.setValider("1");
        eqgaz.setValiderfinale("0");
        
         List<EnqueteGaz> eqListtous = service.enquetegazServiceDao.findByValue(eqgaz);
               for(EnqueteGaz desttous :eqListtous)
                    {
        //activation du compte
	service.enquetegazServiceDao.ValiderEnqueteFinale(desttous.getIdEnqueteGaz());
        
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
<title>SPCD</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.bleu {color: #46A3FF;
}
-->
</style>


<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">


</head>
<body>
<!-- start header -->
<div id="header">
	<div id="logo">
		<h1><a href="#">Etude<sup></sup></a></h1>
		<h2>suivi de prix des combustibles domestiques</h2>
		<div id="menu">
		  <ul>
		    <li class="active"><a href="produitGAZcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Produit Gaz</a></li>
		    <li></li>
		    <li><a href="produitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Produit CL</a></li>
		    <li><a href="cuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Equipement cuisson</a></li>
		    <li><a href="enqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Enqueteur</a></li>
	      </ul>
	  </div>
		<h2>&nbsp; </h2>
	</div>
</div>
<p>
  <!-- end header -->
  
  <!-- start page -->
</p>
<p><img src="images/flamegaz.JPG" width="89" height="92">
</p>
<p>
  <!-- end page -->
  <!-- start footer -->
</p>
<table width="600" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="right"><a href="affacheTousEnquetecdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?toutvalide=543sdhhhcdschdc"><img src="images/valider.JPG" width="31" height="28">Cliquez ici pour Valider toutes les enquêtes gaz</a></td>
  </tr>
</table>
<a href="affacheTousEnquetecdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?toutvalide=543sdhhhcdschdc"></a>
<table width="1120" border="0" align="center" cellpadding="0" cellspacing="0" class="tail12">
  <tr bgcolor="#AAAAFF">
    <td colspan="17" align="center" bgcolor="#CCCCCC"><strong>Liste de toutes les enquêtes de Gaz  de tout Département du Sénégal</strong></td>
  </tr>
  <tr bgcolor="#AAAAFF">
    <td width="112" bgcolor="#ADADAD"><div align="center"><strong>Produit</strong></div></td>
    <td width="4" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="109" bgcolor="#ADADAD"><strong>Prix Gros/Centre urbain</strong></td>
    <td width="4" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="140" bgcolor="#ADADAD"><strong>Prix Détail /Centre urbain</strong></td>
    <td width="3" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="120" bgcolor="#ADADAD"><strong>Prix Gros/Périférique</strong></td>
    <td width="3" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="154" bgcolor="#ADADAD"><div align="center"><strong><span class="feature-title">Prix Détail/Périférique</span></strong></div></td>
    <td width="3" align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="127" align="center" bgcolor="#ADADAD"><strong><span class="feature-title">Date d'enregistrée</span></strong></td>
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
           enqgaz.setValider("1");
           enqgaz.setValiderfinale("0");
               
         List<EnqueteGaz> eqList = service.enquetegazServiceDao.findByValue(enqgaz);
               for(EnqueteGaz dest :eqList)
                    {
                   
                      
%>
  <tr>
    <td align="left" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getProduitgaz().getNomProduitgaz() %></span></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getPrixCuGros() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getPrixCuDetail() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getPrixPeriGros() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getPrixPeriDetail() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getDateEnquete() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><%=dest.getDepartement().getNomdepartement() %></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><span class="bleu"><%=dest.getDepartement().getRegion().getNomregion() %></span></td>
    <td align="center" bgcolor="#F1F1F1"><img src="images/modif.JPG" width="24" height="21"></td>
    <td align="center" bgcolor="#F1F1F1"><strong><span class="feature-title"><a href="affacheTousEnquetecdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?valider=<%=dest.getIdEnqueteGaz() %>">valider</a></span></strong></td>
  </tr>
  <%
   
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

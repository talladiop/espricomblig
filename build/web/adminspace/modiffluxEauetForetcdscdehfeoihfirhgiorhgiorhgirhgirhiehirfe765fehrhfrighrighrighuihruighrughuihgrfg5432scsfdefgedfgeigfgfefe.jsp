<%@page import="entites.ProduitCl"%>
<%@page import="entites.EnqueteEauxforet"%>
<%@page import="entites.Eauxforet"%>
<%@page import="entites.Enqueteur"%>
<%@page import="entites.Region"%>
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
		 
		 //determination Date (annee)
    java.util.Calendar currDate = new java.util.GregorianCalendar();
   // add 1 to month because Calendar's months start at 0, not 1
   int month = currDate.get(currDate.MONTH)+1;
   int day = currDate.get(currDate.DAY_OF_MONTH);
   int year = currDate.get(currDate.YEAR);
   int minute = currDate.get(currDate.MINUTE);
   int seconde = currDate.get(currDate.SECOND);
   int heure = currDate.get(currDate.HOUR);
		 
		 
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
class="form-inline well" name="form1" method="post" action="ModifEnqueteEauxetForet">
  <p>&nbsp;</p>
  <table width="400" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0">SUIVI DES FLUX Eaux et Foret du Departement de <span class="bleu"><%=cptcl.getDepartement().getNomdepartement() %></span></td>
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
    
        <%
    
//recherche objet inventaire
 EnqueteEauxforet ef = service.enqueteEauxForetServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("dest65432id5432")));

%>
    
    <tr>
      <td align="right" bgcolor="#D0D0D0">Produit *</td>
      <td bgcolor="#D0D0D0"><select  required="true" name="produit" id="produit">
        <%
             //recherche objet
         //recherche objet inventaire
        EnqueteEauxforet enqef = service.enqueteEauxForetServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("dest65432id5432")));
        
        
			
   			List<ProduitCl> gpList = service.produitclServiceDao.findAll();
                       for(ProduitCl drp :gpList){
	                   %>
        <option value="<%=drp.getIdProduitcl() %>" <% if(drp.getNomProduitcl().equals(enqef.getProduitcl().getNomProduitcl())) out.print("Selected") ;%>><%=enqef.getProduitcl().getNomProduitcl() %></option>
        <%
				     }
			
		              %>
      </select></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0">Quantité entrée<span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input name="qte" type="text" id="qte" value="<%=ef.getQtEntrer() %>" size="20" required="true" /></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0">Date d'entrée<span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input  required="true" name="datev1" type="text" id="dateDebut" onFocus="view_microcal(true,dateDebut,microcal,-1,0);" onBlur="view_microcal(false,dateDebut,microcal,-1,0);" onKeyUp="this.style.color=testTypeDate(this.value)?'black':'red'" value="<%=ef.getDateEntrer() %>" maxlength="10"/></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0">Quantité sortie<span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input name="qts" type="text" id="qts" value="<%=ef.getQtSortie() %>" size="20" required="true" /></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0">Date sortie<span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input  required="true" name="datev2" type="text" id="dateDebut2" onFocus="view_microcal(true,dateDebut,microcal,-1,0);" onBlur="view_microcal(false,dateDebut,microcal,-1,0);" onKeyUp="this.style.color=testTypeDate(this.value)?'black':'red'" value="<%=ef.getDateSortie() %>" maxlength="10"/></td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><input type="submit" name="button" id="button" value="Enregistrer" />
        <input name="idenqueu" type="hidden" id="idenqueu" value="<%=cptcl.getIdenqueteur()  %>" />
        <input name="dateentrer" type="hidden" id="dateentrer" value="<%=ef.getDateEnr() %>" />
        <input name="idenqueteur" type="hidden" id="idenqueteur" value="<%=ef.getEnqueteur().getIdenqueteur() %>">
        <input name="idenquete" type="hidden" id="idenquete" value="<%=ef.getIdEnqueteEf() %>">
        <input name="poste" type="hidden" id="poste" value="<%=ef.getEauxforet().getIdEauxforet() %>"></td>
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
<table width="870" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr bgcolor="#AAAAFF">
    <td colspan="6" align="center" bgcolor="#E9E9E9">Liste de vos flux Eaux et Forêt</td>
  </tr>
  <tr bgcolor="#AAAAFF">
    <td width="137" bgcolor="#D0D0D0"><div align="center"><strong><span class="feature-title">Nom produit</span></strong></div></td>
    <td width="178" align="center" bgcolor="#D0D0D0">Quantité entrée</td>
    <td width="135" align="center" bgcolor="#D0D0D0">Date d'entrée</td>
    <td width="124" align="center" bgcolor="#D0D0D0">Quantité sortie</td>
    <td width="146" align="center" bgcolor="#D0D0D0">Date sortie</td>
    <td width="91" bgcolor="#D0D0D0">&nbsp;</td>
  </tr>
  <%
            //recherche departement enqueteur
            Departement ddp = new Departement();
            ddp = service.departeServiceDao.findByPrimaryKey(cptcl.getDepartement().getIDdepartement());
  
  
            //Intentiation objet enquetegaz
             EnqueteEauxforet eneaux = new EnqueteEauxforet();
             //specification du departement
             eneaux.setEnqueteur(cptcl);
             eneaux.setValider("0");
             
            
               
         List<EnqueteEauxforet> eqList = service.enqueteEauxForetServiceDao.findByValue(eneaux);
               for(EnqueteEauxforet dest :eqList)
                    {
                   
%>
  <tr>
    <td align="left" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getProduitcl().getNomProduitcl() %></span></td>
    <td align="center"><strong><span class="bleu1"><%=dest.getQtEntrer() %></span></strong></td>
    <td align="center"><strong><span class="bleu1"><%=dest.getDateEntrer() %></span></strong></td>
    <td align="center"><strong><span class="bleu1"><%=dest.getQtSortie() %></span></strong></td>
    <td align="center"><strong><span class="bleu1"><%=dest.getDateSortie() %></span></strong></td>
    <td align="center"><strong><a href="modiffluxEauetForetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?dest65432id5432=<%=dest.getIdEnqueteEf() %>">modifier</a></strong></td>
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

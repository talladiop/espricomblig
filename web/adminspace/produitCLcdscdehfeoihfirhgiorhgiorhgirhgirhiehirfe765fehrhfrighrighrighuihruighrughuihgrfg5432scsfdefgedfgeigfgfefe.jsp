<%@page import="entites.ProduitCl"%>
<%@page import="entites.Enqueteur"%>
<%@page import="entites.EnqueteCl"%>
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
-->
</style>

</head>
<body>
<!-- start header -->
<div id="header">
	<div id="logo">
		<h1><a href="#">Etude<sup></sup></a></h1>
	  <h2>suivi de prix des combustibles domestiques <%=cptcl.getPrenomenqueteur() %><%=" "%><%=cptcl.getNomenqueteur() %></h2>
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
<form id="form1" name="form1" method="post" class="form-inline well" action="InsertionEnqueteCL">
  <p><img src="images/charbon.JPG" width="113" height="85"></p>
  <table width="790" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr class="bgliste">
      <td colspan="5" align="center" bgcolor="#D0D0D0">Insertion données portant sur l'enquéte de produit Combustible Ligneux | Département : <%=cptcl.getDepartement().getNomdepartement() %></td>
    </tr>
    <tr>
      <td colspan="5" align="center" bgcolor="#D0D0D0"><% 
	if(request.getParameter("admoneth23984outputofficeceadmin")!=null ){
	String code=request.getParameter("admoneth23984outputofficeceadmin");
	  	 if(code.equalsIgnoreCase("04469578")){
			
			  out.print("<font color='red'> Echec enregistrement!</font><br>");
			  out.print("<font color='red'> Vérifier bien les champs à remplir</font><br>");
		 }else{
		 
		 out.print("<font color='green'> Enregistrement r&eacute;ussi ! </font><br>");
		 }
	}
	%></td>
    </tr>
    <tr>
      <td width="181" align="right" bgcolor="#D0D0D0"><label for="nom">Type de produit </label>
        <span class="red">*</span></td>
      <td width="239" bgcolor="#D0D0D0"><select  required="true" name="produitcl" id="produitcl">
        <%
			 ProduitCl dpart=new ProduitCl();
                      
   			List<ProduitCl> gpList = service.produitclServiceDao.findAll();
                       for(ProduitCl drp :gpList){
	                   %>
        <option value="<%=drp.getIdProduitcl() %>" selected="selected"><%=drp.getNomProduitcl() %></option>
        <%
				     }
			
		              %>
      </select></td>
      <td width="4" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="96" align="right" bgcolor="#D0D0D0">Prix en gros *</td>
      <td width="270" bgcolor="#D0D0D0"><input required="true" name="pg" type="text" id="pg" size="14" maxlength="9" placeholder="Ex: 1350" />
        CFA</td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0">Type de condictionnemen<span class="red"> *</span></td>
      <td bgcolor="#D0D0D0"><input required="true" name="typecondition" type="text" id="typecondition" size="20" placeholder="Ex: sac, pôt" /></td>
      <td bgcolor="#FFFFFF">&nbsp;</td>
      <td align="right" bgcolor="#D0D0D0">Prix en détail *</td>
      <td bgcolor="#D0D0D0"><input required="true" name="pd" type="text" id="pd" size="14" maxlength="9" placeholder="Ex: 1550" />
        CFA</td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0">Equivalent en Kg min <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input required="true" name="equikgmin" type="text" id="equikgmin" size="14" maxlength="9" placeholder="Ex: 47" />
      kg</td>
      <td bgcolor="#FFFFFF">&nbsp;</td>
      <td align="right" bgcolor="#D0D0D0">Marché</td>
      <td bgcolor="#D0D0D0"><input required="true" name="marche" type="text" id="marche" size="14" placeholder="Ex: marché ou zone enquéte" /></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0">Equivalent en Kg max <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input required="true" name="equikgmax" type="text" id="equikgmax" size="14" maxlength="9" placeholder="Ex: 50" /></td>
      <td bgcolor="#FFFFFF">&nbsp;</td>
      <td align="right" bgcolor="#D0D0D0">&nbsp;</td>
      <td bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="5" align="center" bgcolor="#D0D0D0"><input name="idenqueteur" type="hidden" id="idenqueteur" value="<%=cptcl.getIdenqueteur() %>"></td>
    </tr>
    <tr>
      <td colspan="5" align="center" bgcolor="#D0D0D0"><input type="submit" name="button" id="button" value="Enregistrer" />
        <input type="reset" name="button2" id="button2" value="Effacer" /></td>
    </tr>
    <tr>
      <td colspan="5" bgcolor="#D0D0D0">Les champs en <span class="red">*</span> ne doivent pas être vide</td>
    </tr>
    <tr>
      <td colspan="5" bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
  </table>
</form>
<table width="1170" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr bgcolor="#AAAAFF">
    <td colspan="8" align="center" bgcolor="#EAEAEA">Liste de vos enquétes</td>
  </tr>
  <tr bgcolor="#D0D0D0">
    <td width="111"><div align="center"><strong><span class="feature-title">Nom produit</span></strong></div></td>
    <td width="187"><div align="center"><strong><span class="feature-title">Type conditionnement</span></strong></div></td>
    <td width="158"><div align="center"><strong><span class="feature-title">Equivalant en Kg min</span></strong></div></td>
    <td width="156"><strong><span class="feature-title">Equivalant en Kg max</span></strong></td>
    <td width="89"><div align="center"><strong>Prix en Gros</strong></div></td>
    <td width="96"><strong>Prix en détail</strong></td>
    <td width="284"><strong>Marché où l'enquete est faite</strong></td>
    <td width="89"><span class="feature-title"><strong>modifier</strong></span></td>
  </tr>
  <%
            EnqueteCl eq = new EnqueteCl();
            eq.setEnqueteur(cptcl);
            eq.setValider("0");
               
         List<EnqueteCl> eqList = service.enqueteclServiceDao.findByValue(eq);
               for(EnqueteCl dest :eqList)
                    {
                   
                    
%>
  <tr>
    <td align="left" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getProduitcl().getNomProduitcl() %></span></td>
    <td align="center" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getTypeCond() %></span></td>
    <td align="center" bgcolor="#F1F1F1"><strong><span class="feature-title"><%=dest.getEquivalantKgmin() %></span></strong></td>
    <td align="center" bgcolor="#F1F1F1"><strong><span class="feature-title"><%=dest.getEquivalantKgmax() %></span></strong></td>
    <td align="center" bgcolor="#F1F1F1"><strong><span class="bleu"><%=dest.getPrixGros() %></span></strong></td>
    <td align="left" bgcolor="#F1F1F1"><strong><span class="bleu"><%=dest.getPrixDetail() %></span></strong></td>
    <td align="center" bgcolor="#F1F1F1">&nbsp;</td>
    <td align="center"><strong><span class="feature-title"><a href="modifenqueteCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?dest65432id5432=<%=dest.getIdenqueteCl() %>">modifier</a></span></strong></td>
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

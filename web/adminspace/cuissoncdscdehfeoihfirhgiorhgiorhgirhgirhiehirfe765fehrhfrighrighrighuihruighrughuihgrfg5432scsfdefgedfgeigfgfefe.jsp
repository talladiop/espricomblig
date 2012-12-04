<%@page import="entites.Cuisson "%>
<%@page import="entites.EnqueteEquipement "%>

<%@page import="entites.Enqueteur"%>
<%@page import="entites.Region"%>
<%@page import="entites.Departement"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

 <%@page import="java.util.*"%>
<jsp:useBean id="service" class="FactoryService.FactoryService"></jsp:useBean>

<%! 
Departement dpart = null;

 //determination Date (annee)
    java.util.Calendar currDate = new java.util.GregorianCalendar();
   // add 1 to month because Calendar's months start at 0, not 1
   int month = currDate.get(currDate.MONTH)+1;
   int day = currDate.get(currDate.DAY_OF_MONTH);
   int year = currDate.get(currDate.YEAR);
   int minute = currDate.get(currDate.MINUTE);
   int seconde = currDate.get(currDate.SECOND);
   int heure = currDate.get(currDate.HOUR);
   
   
   //ideauforet
   Cuisson eqcu = null;
		 
		 

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
  <!-- end header --></p>
<form id="form1" 
class="form-inline well" name="form1" method="post" action="InsertionEnqueteCuisson">
<table width="430" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0">SUIVI DES EQUIPEMENTS DE CUISSON DEPARTEMENT <span class="bleu"><%=cptcl.getDepartement().getNomdepartement() %></span></td>
    </tr>
    <tr>
        
        <!--%
        //recherche de l eauetforet du departement
        List<Cuisson> cList = service.cuissonServiceDao.findAll();
          for(Cuisson cu : cList)
           { 
     if(cu.getDepartement().getIDdepartement().equals(cptcl.getDepartement().getIDdepartement()))
         {
            ideau = cu;
                           
             }
                           
         }
                       



%-->
        
        
      <td colspan="2" align="center" bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><% 
	if(request.getParameter("admoneth23984outputofficeceadmin")!=null ){
	String code=request.getParameter("admoneth23984outputofficeceadmin");
	  	 if(code.equalsIgnoreCase("04469578")){
			
			  out.print("<font color='red'> Echec enregistrement !</font><br>");
			  out.print("<font color='red'> Vérifier bien les champs à remplir</font><br>");
		 }else{
		 
		 out.print("<font color='green'> Enregistrement r&eacute;ussi ! </font><br>");
		 }
	}
	%></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0">Equipement Utilise <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><select  required="true" name="eqp" id="eqp">
        <%         
                         //intentiation objet
			// Cuisson cs=new Cuisson();
                         
                      
   			List<Cuisson> cList = service.cuissonServiceDao.findAll();
                       for(Cuisson drp :cList)
                       {
                          // if(drp.getDepartement().getRegion().getIDregion() == cptcl.getDepartement().getRegion().getIDregion())
                          // {
	                   %>
        <option value="<%=drp.getIdCuisson() %>" selected="selected"><%=drp.getNomCuisson() %></option>
        <%
		//}
                     }
		              %>
      </select></td>
    </tr>
  <tr>
      <td align="right" bgcolor="#D0D0D0">Prix d' achat <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input name="pda" type="text" id="pda" size="20" required="true" /></td>
    </tr>
    
    <tr>
      <td align="right" bgcolor="#D0D0D0">Prix de Vente <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input name="pdv" type="text" id="pdv" size="20" required="true" /></td>
    </tr>
    
    <tr>
      <td align="right" bgcolor="#D0D0D0">Quantite Disponible <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input name="qte" type="text" id="qte" size="20" required="true" /></td>
    </tr>
    
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
    
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><input type="submit" name="button" id="button" value="Enregistrer" />
        <input name="idenqueu" type="hidden" id="idenqueu" value="<%=cptcl.getIdenqueteur()  %>" />
        <input name="iddepartement" type="hidden" id="iddepartement" value="<%=cptcl.getDepartement().getIDdepartement() %>" /></td>
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
    <td colspan="6" align="center" bgcolor="#E9E9E9">Liste de vos Equipements</td>
  </tr>
  <tr bgcolor="#AAAAFF">
    <td width="137" bgcolor="#D0D0D0"><div align="center"><strong><span class="feature-title">Designation</span></strong></div></td>
    <td width="178" align="center" bgcolor="#D0D0D0"> Date de l'enregistrement</td>
    <td width="135" align="center" bgcolor="#D0D0D0">Prix d'achat</td>
    <td width="124" align="center" bgcolor="#D0D0D0">Prix de Vente</td>
    <td width="146" align="center" bgcolor="#D0D0D0">Quantite Disponible</td>
    <td width="91" bgcolor="#D0D0D0">&nbsp;</td>
  </tr>
  <%
            //recherche departement enqueteur
            Departement ddp = new Departement();
            ddp = service.departeServiceDao.findByPrimaryKey(cptcl.getDepartement().getIDdepartement());
  
 
            //Intentiation objet enquetecuisson
             EnqueteEquipement eneqp = new EnqueteEquipement();
             //specification du departement
             eneqp.setEnqueteur(cptcl);
             eneqp.setValider("0");
             eneqp.setDepart(ddp);
             
            
               
         List<EnqueteEquipement> eqList = service.enqueteequipementSrv.findByValue(eneqp);
               for(EnqueteEquipement dest :eqList)
                    {
                   
%>
  <tr>
    <td align="left" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getEquipement().getNomCuisson() %></span></td>
    <td align="center"><strong><span class="bleu1"><%=dest.getDateEnquete() %></span></strong></td>
    <td align="center"><strong><span class="bleu1"><%=dest.getPrixAchat() %></span></strong></td>
    <td align="center"><strong><span class="bleu1"><%=dest.getPrixVente() %></span></strong></td>
    <td align="center"><strong><span class="bleu1"><%=dest.getQte() %></span></strong></td>
    <td align="center"><strong><a href="modif-cuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?dest65432id5432=<%=dest.getIdenquete() %>">modifier</a></strong></td>
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

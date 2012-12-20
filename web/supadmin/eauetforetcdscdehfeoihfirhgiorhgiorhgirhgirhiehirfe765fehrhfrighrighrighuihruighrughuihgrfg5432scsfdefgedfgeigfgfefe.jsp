<%@page import="entites.Enqueteur"%>
<%@page import="entites.Eauxforet"%>
<%@page import="entites.Localite"%>
<%@page import="entites.Region"%>
<%@page import="entites.Departement"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

 <%@page import="java.util.*"%>
<jsp:useBean id="service" class="FactoryService.FactoryService"></jsp:useBean>

<%! 
Departement dpart = null;

%>

<%

 //activation compte
    if(request.getParameter("activer")!=null)
      {
        //activation du compte
	service.enqueteurServiceDao.activer(Integer.parseInt(request.getParameter("activer")));
     }
    
    //fermeture compte
    if(request.getParameter("suspend")!=null)
      {
        service.enqueteurServiceDao.desactiver(Integer.parseInt(request.getParameter("suspend")));
       }





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
<p><form id="form1" name="form1" 
class="form-inline well" method="post" action="InsertionEauxetforet">
  <table width="400" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0">Création Poste Eaux et Foêts</td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><% 
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
      <td bgcolor="#D0D0D0"><label for="nom2">Nom poste </label>
        <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input required="true" name="nom" type="text" id="nom2" size="20" /></td>
    </tr>
    <tr>
      <td bgcolor="#D0D0D0"><label for="tel">Téléphone poste</label>
        <span class="red">*</span></td>
      <td bgcolor="#D0D0D0">(221)
        <input required="true" name="tel" type="text" id="tel" size="14" maxlength="9" /></td>
    </tr>
    <tr>
      <td bgcolor="#D0D0D0">Le département du poste</td>
      <td bgcolor="#D0D0D0"><select  required="true" name="departement" id="departement">
        <%
			 dpart = new Departement();
                      
   			List<Departement> gpList = service.departeServiceDao.findAll();
                       for(Departement drp :gpList){
	                   %>
        <option value="<%=drp.getIDdepartement() %>"><%=drp.getNomdepartement() %></option>
        <%
				     }
			
		              %>
      </select></td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><input type="submit" name="button" id="button" value="Enregistrer" />
        <input type="reset" name="button2" id="button2" value="Effacer" /></td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#D0D0D0">Les champs en <span class="red">*</span> ne doivent pas être vide</td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
  </table>
</form></p>
<p>&nbsp;</p>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr bgcolor="#AAAAFF">
    <td colspan="4" align="center" bgcolor="#CCCCCC">Liste des postes de Eaux et Forêts</td>
  </tr>
  <tr bgcolor="#AAAAFF">
    <td bgcolor="#ADADAD"><div align="center"><strong><span class="feature-title">Nom du poste</span></strong></div></td>
    <td bgcolor="#ADADAD"><div align="center"><strong><span class="feature-title">Téléphone</span></strong></div></td>
    <td bgcolor="#ADADAD"><div align="center"><strong><span class="feature-title">Département du poste</span></strong></div></td>
    <td bgcolor="#ADADAD"><span class="feature-title"><strong>modifier</strong></span></td>
  </tr>
  <%
            
               
         List<Eauxforet> eqList = service.eauetforetServiceDao.findAll();
               for(Eauxforet dest :eqList)
                    {
                   
                      
%>
  <tr>
    <td align="left" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getNomPoste() %></span></td>
    <td align="center" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getTel() %></span></td>
    <td align="center" bgcolor="#F1F1F1"><strong><span class="bleu"><%=dest.getDepartement().getNomdepartement() %></span></strong></td>
    <td align="center" bgcolor="#F1F1F1"><strong><span class="feature-title"><a href="modifiereauetforetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?dest65432id5432=<%=dest.getIdEauxforet() %>">modifier</a></span></strong></td>
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

<%@page import="entites.Enqueteur"%>
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
	  <h2>suivi de prix des combustibles domestiques </h2>
	  <div id="menu">
	    <ul>
	      <li class="active"><a href="produitGAZcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Produit Gaz</a></li>
	      <li></li>
	      <li><a href="produitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Produit CL</a></li>
	      <li><a href="cuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Equipement cuisson</a></li>
	      <li><a href="enqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp">Agent</a></li>
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
  
  <!-- start page --></p>
<form id="form1" name="form1" method="post" class="form-inline well" action="InsertionEnqueteur">
  <table width="460" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2" align="center" bgcolor="#C6FFD9">Création Agent de saisie</td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><% 
	if(request.getParameter("admoneth23984outputofficeceadmin")!=null ){
	String code=request.getParameter("admoneth23984outputofficeceadmin");
	  	 if(code.equalsIgnoreCase("04469578")){
			
			  out.print("<font color='red'> Echec enregistrement!</font><br>");
			  out.print("<font color='red'> Vérifier bien les champs à remplir ou parametres d'un enquêteur éxistant</font><br>");
		 }else{
		 
		 out.print("<font color='green'> Enregistrement r&eacute;ussi ! </font><br>");
		 }
	}
	%></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0"><label for="nom">Nom agent </label>
        <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input required="true" name="nom" type="text" id="nom" size="20" /></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0"><label for="prenom">Prénom agent </label>
        <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input required="true" name="prenom" type="text" id="prenom" size="20" /></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0"><label for="tel">Téléphone </label>
        <span class="red">*</span></td>
      <td bgcolor="#D0D0D0">(221)
      <input required="true" name="tel" type="text" id="tel" size="14" maxlength="9" /></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0">E-mail</td>
      <td bgcolor="#D0D0D0"><input name="email" type="text" id="email" size="20" /></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0">Département</td>
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
      <td colspan="2" align="center" bgcolor="#C6FFD9">Information sur le compte</td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0"><label for="login">Login </label>
        <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input required="true" name="login" type="text" id="login" size="20" maxlength="30" /></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0"><label for="pwd">Mot de passe </label>
        <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input required="true" name="pwd" type="password" id="pwd" size="20" maxlength="30" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><input type="submit" name="button" id="button" value="Enregistrer" />
        <input type="reset" name="button2" id="button2" value="Effacer" /></td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#D0D0D0">Les champs en <span class="red">*</span> ne doivent pas être vide</td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#C6FFD9">&nbsp;</td>
    </tr>
  </table>
</form>
<table width="858" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr bgcolor="#AAAAFF">
    <td colspan="14" align="center" bgcolor="#EAEAEA">Liste de vos agents</td>
  </tr>
  <tr bgcolor="#D0D0D0">
    <td width="138"><div align="center"><strong><span class="feature-title">Prenom Nom</span></strong></div></td>
    <td width="4" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="78"><div align="center"><strong><span class="feature-title">Téléphone</span></strong></div></td>
    <td width="4" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="69"><div align="center"><strong><span class="feature-title">E-mail</span></strong></div></td>
    <td width="4" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="200"><div align="center"><strong><span class="feature-title">Département</span></strong></div></td>
    <td width="4" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="80"><strong><span class="feature-title">Région</span></strong></td>
    <td width="4" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="114"><span class="feature-title"><strong>modifier</strong></span></td>
    <td colspan="3" align="center">suspendre/activer</td>
  </tr>
  <%
            Enqueteur eq = new Enqueteur();
            eq.setProfile(41);
               
         List<Enqueteur> eqList = service.enqueteurServiceDao.findByValue(eq);
               for(Enqueteur dest :eqList)
                    {
                   
                    
%>
  <tr>
    <td align="left" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getPrenomenqueteur() %><%="  "%><%=dest.getNomenqueteur() %></span></td>
    <td align="left" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="left" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getTel() %></span></td>
    <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="center" bgcolor="#F1F1F1"><strong><span class="feature-title"><%=dest.getEmail() %></span></strong></td>
    <td align="left" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="left" bgcolor="#F1F1F1"><strong><span class="bleu"><%=dest.getDepartement().getNomdepartement() %></span></strong></td>
    <td align="left">&nbsp;</td>
    <td align="left" bgcolor="#FFFFFF"><strong><span class="bleu"><%=dest.getDepartement().getRegion().getNomregion() %></span></strong></td>
    <td align="center">&nbsp;</td>
    <td align="center"><strong><span class="feature-title"><a href="modifenqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?dest65432id5432=<%=dest.getIdenqueteur() %>&frd=64&dgg=21">modifier</a></span></strong></td>
    <td width="4" align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="77" align="center" bgcolor="#FFFFFF"><strong><span class="feature-title">
     <% if (dest.getEtatcompte().equalsIgnoreCase("0")) {%>
      <a href="enqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?3456kjuylisteby453juyt876=<%=dest.getIdenqueteur() %>&activer=<%=dest.getIdenqueteur() %>"><img src="images/activer.png" alt="" width="19" height="19" border="0" /></a>
      <%}%>
    </span></strong></td>
    <td width="78" align="center" bgcolor="#FFFFFF"><strong><span class="feature-title">
      <% if (dest.getEtatcompte().equalsIgnoreCase("1")) {%>
      <a href="enqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?3456kjuylisteby453juyt876=<%=dest.getIdenqueteur() %>&suspend=<%=dest.getIdenqueteur() %>"><img src="images/interdit.jpg" alt="" width="17" height="17" border="0" /></a>
      <%}%>
    </span></strong></td>
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

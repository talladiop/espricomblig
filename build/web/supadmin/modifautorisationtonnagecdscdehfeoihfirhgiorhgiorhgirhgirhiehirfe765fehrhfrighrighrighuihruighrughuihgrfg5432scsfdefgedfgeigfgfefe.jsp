<%@page import="entites.Departement"%>
<%@page import="entites.AutorisationTonnagecl"%>
<%@page import="entites.Enqueteur"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

 <%@page import="java.util.*"%>
<jsp:useBean id="service" class="FactoryService.FactoryService"></jsp:useBean>

<%
//intentiation du entreprise
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

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>


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
<p><form id="form2" 
class="form-inline well" name="form1" method="post" action="ModifAutorisationTonnage">
  <table width="510" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><strong>Modification Autorisation Tonnage Eaux et Foêts</strong></td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><% 
	if(request.getParameter("mod39876ytre54320jhg543")!=null ){
	String code=request.getParameter("mod39876ytre54320jhg543");
	  	 if(code.equalsIgnoreCase("087654gfr4329")){
			
			  out.print("<font color='red'> Echec Modification!</font><br>");
			  out.print("<font color='red'> Vérifier bien les champs à remplir</font><br>");
		 }else{
		 
		 out.print("<font color='green'> Modification r&eacute;ussi ! </font><br>");
		 }
	}
	%></td>
    </tr>
    <tr>
      <%
        AutorisationTonnagecl ef = new AutorisationTonnagecl();
	  
	  ef = service.autorisationtonnageServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("dest65432id5432")));


%>
      <td width="243" align="right" bgcolor="#D0D0D0">Quantité autorisée pour l'année<span class="red"> <%=year %>*</span></td>
      <td width="267" bgcolor="#D0D0D0"><input name="qt" type="text" id="qt" value="<%=ef.getQt() %>" size="20" required="true" />
      tonnes</td>
    </tr>
    <tr>
      <td align="right" bgcolor="#D0D0D0">Département cible</td>
      <td bgcolor="#D0D0D0"><select  required="true" name="departement" id="departement">
        <%
			 //Departement dpart=new Departement();
                      
   			List<Departement> gpList = service.departeServiceDao.findAll();
                       for(Departement drp :gpList){
	                   %>
        <option value="<%=drp.getIDdepartement() %>" <% if(drp.getNomdepartement().equals(ef.getDepartement().getNomdepartement()))out.print("Selected") ;%>><%=drp.getNomdepartement() %></option>
        <%
				     }
			
		              %>
      </select></td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><input name="anneaut" type="hidden" id="anneaut" value="<%=ef.getAnneeAut() %>" />
        <input name="idautorisat" type="hidden" id="idautorisat" value="<%=ef.getIdAuttonnage() %>" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><input type="submit" name="button2" id="button2" value="Modifier" />
        <input name="cmd" type="hidden" id="cmd" value="Mod" /></td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#D0D0D0">Les champs en <span class="red">*</span> ne doivent pas être vide</td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#D0D0D0"> </td>
    </tr>
  </table>
</form></p>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr bgcolor="#AAAAFF">
    <td colspan="4" align="center" bgcolor="#CCCCCC"><strong>Liste des Autorisations de Eaux et Forêts</strong></td>
  </tr>
  <tr bgcolor="#AAAAFF">
    <td bgcolor="#ADADAD"><div align="center"><strong>Quantité</strong></div></td>
    <td bgcolor="#ADADAD"><div align="center"><strong><span class="feature-title">Département</span></strong></div></td>
    <td align="center" bgcolor="#ADADAD"><strong>Année</strong></td>
    <td align="center" bgcolor="#ADADAD"><span class="feature-title"><strong>modifier</strong></span></td>
  </tr>
  <%
            
               
         List<AutorisationTonnagecl> eqList = service.autorisationtonnageServiceDao.findAll();
               for(AutorisationTonnagecl dest :eqList)
                    {
                   
                      
%>
  <tr>
    <td align="left" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getQt() %></span></td>
    <td align="center" bgcolor="#F1F1F1"><strong><span class="bleu"><%=dest.getDepartement().getNomdepartement() %></span></strong></td>
    <td align="center" bgcolor="#F1F1F1"><strong><span class="bleu"><%=dest.getAnneeAut() %></span></strong></td>
    <td align="center" bgcolor="#F1F1F1"><strong><span class="feature-title"><a href="modifautorisationtonnagecdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?dest65432id5432=<%=dest.getIdAuttonnage() %>">modifier</a></span></strong></td>
  </tr>
  <%
   
     }
%>
</table>
<p></p>
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

<%@page import="entites.Enqueteur"%>
<%@page import="entites.Eauxforet"%><%@page import="entites.Region"%>
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
.bleu {	color: #03F;
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
  
<!-- start page --><form id="form1" class="form-inline well" name="form1" method="post" action="ModifEauForet">
  <table width="400" border="0" align="center" cellpadding="0" cellspacing="0">
    <%
        Eauxforet ef = new Eauxforet();
	  
	  ef = service.eauetforetServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("dest65432id5432")));


%>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0">Modification Poste Eaux et Foêts de <span class="bleu"><%=ef.getNomPoste() %></span></td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><% 
	if(request.getParameter("mod39876ytre54320jhg543")!=null ){
	String code=request.getParameter("mod39876ytre54320jhg543");
	  	 if(code.equalsIgnoreCase("04469578")){
			
			  out.print("<font color='red'> Echec Modification!</font><br>");
			  out.print("<font color='red'> Vérifier bien les champs à remplir</font><br>");
		 }else{
		 
		 out.print("<font color='green'> Modification r&eacute;ussi ! </font><br>");
		 }
	}
	%></td>
    </tr>
    <tr>
      <td bgcolor="#D0D0D0"><label for="nom">Nom poste </label>
        <span class="red">*</span></td>
      <td bgcolor="#D0D0D0"><input name="nom" type="text" id="nom" value="<%=ef.getNomPoste() %>" size="20" required="true" /></td>
    </tr>
    <tr>
      <td bgcolor="#D0D0D0"><label for="tel">Téléphone poste</label>
        <span class="red">*</span></td>
      <td bgcolor="#D0D0D0">(221)
        <input name="tel" type="text" id="tel" value="<%=ef.getTel() %>" size="14" maxlength="9" required="true" /></td>
    </tr>
    <tr>
      <td bgcolor="#D0D0D0">Le département du poste</td>
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
      <td colspan="2" align="center" bgcolor="#D0D0D0">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#D0D0D0"><input type="submit" name="button" id="button" value="Modifier" />
        <input name="cmd" type="hidden" id="cmd" value="Mod" />
        <input name="idgg8765greua" type="hidden" id="idgg8765greua" value="<%=ef.getIdEauxforet() %>" /></td>
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
    <td colspan="4" align="center" bgcolor="#E8E8E8">Liste des postes de Eaux et Forêts</td>
  </tr>
  <tr bgcolor="#D0D0D0">
    <td><div align="center"><strong><span class="feature-title">Nom du poste</span></strong></div></td>
    <td><div align="center"><strong><span class="feature-title">Téléphone</span></strong></div></td>
    <td><div align="center"><strong><span class="feature-title">Département du poste</span></strong></div></td>
    <td><span class="feature-title"><strong>modifier</strong></span></td>
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
    <td align="center" bgcolor="#F1F1F1"><strong><span class="feature-title"><a href="modifiereauetforetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?dest65432id5432=<%=ef.getIdEauxforet() %>">modifier</a></span></strong></td>
  </tr>
  <%
   
     }
%>
</table>
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

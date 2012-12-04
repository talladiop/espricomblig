<%@page import="entites.Enqueteur"%>
<%@page import="entites.Localite"%>
<%@page import="entites.Region"%>
<%@page import="entites.Departement"%>
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
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Expert Vision</title>
<link href="style.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="jquery-1.2.6.js"></script>
<script type="text/javascript" src="jquery.formvalidation.js"></script>



<style type="text/css">
<!--
.centrer {	text-align: center;
}
-->
</style>
</head>

<body>
<div id="mainPan">
  <div id="topPan">
  	<a href="index.html"><img src="images/logo.png" alt="Expart Vision" width="230" height="44" border="0" class="logo" /></a> 
<h1>&nbsp;</h1>
<ul>
<li><a href="localiteq654hwxhvhvhvxshvhv65432908766cdxbhdbvchjdvchjdvchjdvchdvchdvghdvchdcdcvdxghvdghxdx43987654scxshjchjvhjvhjvhjvc.jsp">Localit&eacute;</a></li>
			<li class="about"><a href="#">Enqu&eacute;teurs</a></li>
			<li><a href="#">Chat</a></li>
			<li><a href="#">Blog</a></li>
			<li><a href="#">Forum</a></li>
			<li><a href="#">Clients</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
  </div>
  <div id="toprightPann">
  	
  	  <p>
  	    <% 
	if(request.getParameter("admondjkfkgggh23987hyofficeadmin")!=null ){
	String code=request.getParameter("admondjkfkgggh23987hyofficeadmin");
	  	 if(code.equalsIgnoreCase("0446978")){
			
			  out.print("<font color='red'> Echec connexion compte inconnu!</font><br>");
		 }else{
		  session.removeAttribute("sessionecole");
	
		 session.invalidate();
		 out.print("<font color='red'> Session expir&eacute;e ! </font><br>");
		 }
	}
	%>
  	  </p>
      <form id="form1" name="form1" method="post" action="InsertionLocalite">
  	  <table width="300" border="0" align="center" cellpadding="0" cellspacing="0">
  	    <tr>
  	      <td colspan="2" align="center" bgcolor="#FFC66F">Cr&eacute;ation de Localit&eacute;</td>
        </tr>
  	    <tr>
  	      <td bgcolor="#FFC66F">Non localit&eacute;</td>
  	      <td bgcolor="#FFC66F"><input  required="true" name="nomlocal" type="text" id="nomlocal" size="20" /></td>
        </tr>
  	    <tr>
  	      <td bgcolor="#FFC66F">D&eacute;partement localit&eacute;</td>
  	      <td bgcolor="#FFC66F"><select  required="true" name="departement" id="departement">
  	        <%
			 Departement dpart=new Departement();
                      
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
  	      <td colspan="2" align="center" bgcolor="#FFC66F"><input type="submit" name="button" id="button" value="Connexion" />
          <input name="cmd" type="hidden" id="cmd" value="En" /></td>
        </tr>
      </table>
    </form>
  	<p>&nbsp;</p>
	<p class="more">&nbsp;</p>
        
  </div>
  
  <div id="bodyTopPan">
    <table width="800" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td colspan="4" align="left" bgcolor="#F1F1F1" class="centrer">Liste des Localit&eacute;s</td>
      </tr>
      <tr bgcolor="#FFFFFF">
        <td align="left">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr bgcolor="#FFCC99">
        <td align="left">Nom localit&eacute;</td>
        <td align="center">D&eacute;partement localit&eacute;</td>
        <td align="center">R&eacute;gion de la localit&eacute;</td>
        <td align="center">&nbsp;</td>
      </tr>
      <%
            Region rg = null;
                //affichage liste par groupe
               // Departement dp = service.departeServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("3456kjuylisteby453juyt876")));
                //Destinataire ds = new Destinataire();
                //ds.setGroupe(gro);

                // List<Destinataire> destList = service.destinataireService.findByValue(ds);
                 // for(Destinataire dest :destList){
                      //if(dest.getGroupe().getEntreprise().getIdEntrep() == cptcl.getIdEntrep())
                         // {
        List<Localite> lcList = service.localiteServiceDao.findAll();
               for(Localite dest :lcList)
                    {
                      
                 %>
      <tr>
        <td align="left" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getNomLocalite() %></span></td>
        <td align="center" bgcolor="#F1F1F1"><span class="feature-title"><%=dest.getDepartement().getNomdepartement() %></span></td>
        <td align="center"><span class="feature-title"><%=dest.getDepartement().getRegion().getNomregion() %></span></td>
        <td align="center"><strong><span class="feature-title"><a href="modificationlocaliteq654hwxhvhvhvxshvhv65432908766cdxbhdbvchjdvchjdvchjdvchdvchdvghdvchdcdcvdxghvdghxdx43987654scxshjchjvhjvhjvhjvc.jsp?dsffyefyeff=<%=dest.getIdLocalite() %>">modifier</a></span></strong></td>
      </tr>
      <%
}   
%>
    </table>
  </div>
</div>

<div id="footermainPan">
	<div id="footerPan">
	  <ul class="templateworld">
	    <li>&copy; Copyright Information: REALCLIC</li>
	<li><a href="http://www.templateworld.com" target="_blank">2012</a></li>
  </ul>
  </div>
</div>
</body>
</html>

 <% }else{
response.sendRedirect("administrateur.jsp?edygeuguyegygfefd=655&dfdefgff=65shxhjcvhvdc&dfdfedjfbjfbgrjkgfrjhgbrjgbrgjhh=76543bjbjkvbjf");
 }
%>

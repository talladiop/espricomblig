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
  	<ul>
<li><a href="localiteq654hwxhvhvhvxshvhv65432908766cdxbhdbvchjdvchjdvchjdvchdvchdvghdvchdcdcvdxghvdghxdx43987654scxshjchjvhjvhjvhjvc.jsp">Localit&eacute;</a></li>
			<li class="about"><a href="#">Enqu&eacute;teurs</a></li>
			<li><a href="#">Chat</a></li>
			<li><a href="#">Blog</a></li>
			<li><a href="#">Forum</a></li>
			<li><a href="#">Clients</a></li>
			<li><a href="#">Contact</a>  </li>
  	</ul>
  </div>
  <div id="bodyTopPan">
    <form id="form1" name="form1" method="post" action="ModifLocalite">
      <table width="470" border="0" cellspacing="0" cellpadding="0">
      <%
	  Localite lc = new Localite();
	  
	  lc = service.localiteServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("dsffyefyeff")));
	  
	  %>
      
      
        <tr>
          <td colspan="2" align="center" bgcolor="#FFFFFF">Modification localit&eacute; <span class="bleu"><%=lc.getNomLocalite() %></span></td>
        </tr>
        <tr>
          <td colspan="2" align="center" bgcolor="#FFC66F">&nbsp;</td>
        </tr>
        <tr>
          <td colspan="2" align="center" bgcolor="#FFC66F"><% 
	if(request.getParameter("admondjkfkgggh23987hyiceadmin")!=null ){
	String code=request.getParameter("admondjkfkgggh23987hyiceadmin");
	  	 if(code.equalsIgnoreCase("04469768")){
			
			  out.print("<font color='red'> Echec modification !</font><br>");
		 }else{
		  	
		 		 out.print("<font color='green'> Modification r&eacute;essie ! </font><br>");
		 }
	}
	%></td>
        </tr>
        <tr>
          <td width="104" bgcolor="#FFC66F"><label for="nomlocal">Nom localit&eacute;</label></td>
          <td width="96" bgcolor="#FFC66F"><input  required="true" name="nomlocal" type="text" id="nomlocal" value="<%=lc.getNomLocalite() %>" size="20" /></td>
        </tr>
        <tr>
          <td bgcolor="#FFC66F">D&eacute;partement de la localit&eacute;</td>
          <td bgcolor="#FFC66F"><select  required="true" name="departement" id="departement">
            <%
			 //Departement dpart=new Departement();
                      
   			List<Departement> gpList = service.departeServiceDao.findAll();
                       for(Departement drp :gpList){
	                   %>
            <option value="<%=drp.getIDdepartement() %>" <% if(drp.getNomdepartement().equals(lc.getDepartement().getNomdepartement()))out.print("Selected") ;%>><%=drp.getNomdepartement() %></option>
            <%
				     }
			
		              %>
          </select></td>
        </tr>
        <tr>
          <td colspan="2" align="center" bgcolor="#FFC66F"><input type="submit" name="button" id="button" value="Modifier" />
          <input name="idlocaloruhg" type="hidden" id="idlocaloruhg" value="<%=lc.getIdLocalite() %>" />
          <input name="cmd" type="hidden" id="cmd" value="Mod" /></td>
        </tr>
        <tr>
          <td colspan="2" bgcolor="#FFC66F">&nbsp;</td>
        </tr>
      </table>
    </form>
  </div>
</div>

<div id="footermainPan">
	<div id="footerPan">
	  <ul class="templateworld">
	    <li>&copy; Copyright 2012</li>
	<li></li>
  </ul>
  </div>
</div>
</body>
</html>

 <% }else{
response.sendRedirect("administrateur.jsp?edygeuguyegygfefd=655&dfdefgff=65shxhjcvhvdc&dfdfedjfbjfbgrjkgfrjhgbrjgbrgjhh=76543bjbjkvbjf");
 }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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


</head>
<body>
<!-- start header -->
<div id="header">
	<div id="logo">
		<h1><a href="#">Etude<sup></sup></a></h1>
		<h2>suivi de prix des combustibles domestiques</h2>
	</div>
	
</div>
<!-- end header -->

<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
		  <h2 class="title"><b>Login Enqu&eacute;teur</b></h2>
		  <p>&nbsp;</p>
		  <p>&nbsp;</p>
	    <p class="date">&nbsp;</p>
			<div class="entry">
				<p>
				<p>                
			  <p>                
			  <p>                
			  <form id="form" name="form" method="post" action="LoginEnqueteur">
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
  	  <table  class="form-inline well" width="310" border="0" align="center" cellpadding="0" cellspacing="0">
  	    <tr>
  	      <td bgcolor="#D0D0D0">&nbsp;</td>
  	      <td bgcolor="#D0D0D0">&nbsp;</td>
	      </tr>
  	    <tr>
  	      <td width="100" bgcolor="#D0D0D0"><label for="login">Login</label></td>
  	      <td width="208" bgcolor="#D0D0D0"><input  required="true" name="login" type="text" id="login" size="20"  placeholder="votre login"/></td>
        </tr>
  	    <tr>
  	      <td bgcolor="#D0D0D0"><label for="pwd">Mot de passe</label></td>
  	      <td bgcolor="#D0D0D0"><input  required="true" name="pwd" type="password" id="pwd" size="20"  placeholder="votre mot de passe"/></td>
        </tr>
  	    <tr>
  	      <td colspan="2" align="center" bgcolor="#D0D0D0"><input class="btn btn-primary btn-large" type="submit" value="Connexion" name="connexion" id="connexion"/></td>
        </tr>
      </table>
    </form></p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
          </div>
			<div class="meta"></div>
		</div>
		<div class="post"></div>
	</div>
	<!-- end content -->
	<!-- start sidebar -->
	<!-- end sidebar -->
  <div style="clear: both;">&nbsp;</div>
</div>
<!-- end page -->
<!-- start footer -->
<div id="footer">
	<div id="footer-menu"></div>
	<p id="legal">(c) Copyright 2012 </p>
</div>
<!-- end footer -->
</body>
</html>

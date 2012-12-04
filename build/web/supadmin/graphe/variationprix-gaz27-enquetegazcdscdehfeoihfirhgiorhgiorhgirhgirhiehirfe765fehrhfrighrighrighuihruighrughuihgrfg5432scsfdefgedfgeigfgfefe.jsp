<%@page import="entites.ProduitGaz"%>
<%@page import="entites.Enqueteur"%>
<%@page import="entites.Localite"%>
<%@page import="entites.Region"%>
<%@page import="entites.EnqueteGaz"%>
<%@page import="entites.Departement"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

 <%@page import="java.util.*"%>
<jsp:useBean id="service" class="FactoryService.FactoryService"></jsp:useBean>

<%! 
Departement dpart = null;

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

<link rel="shortcut icon" href="images/iconbar.ico"/>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title> affiche statistic</title>




	<link href="css/basic.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="enhance.js"></script>
	<script type="text/javascript">
		// Run capabilities test
		enhance({
			loadScripts: [
				'js/excanvas.js',
				'jquery.min.js',
				'js/visualize.jQuery.js',
				'js/example.js'
			],
			loadStyles: [
				'css/visualize.css',
				'css/visualize-light.css'
			]
		});
    </script>



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
<p>
  <!-- end header -->
  
  <!-- start page --></p>
<p>&nbsp;</p>
<table>
	<caption>
	Variation des Prix   du Gaz 2,7 kg dans toutes les région 
	
    </caption>
	<thead>
  </tr>
  
  <tr bgcolor="#AAAAFF">
    <td width="149" bgcolor="#D0D0D0"></th>
  
    <th scope="col">Prix gros</th>
    <th scope="col">Prix detail</th>
   
    
 
    
  </tr>
  </thead>
  
  <%
            //recherche departement enqueteur
           // Departement ddp1 = new Departement();
            //ddp1 = service.departeServiceDao.findByPrimaryKey(cptcl.getDepartement().getIDdepartement());
  
  
            //Intentiation objet enquetegaz
            // EnqueteGaz engaz = new EnqueteGaz();
             //specification du departement
             //engaz.setDepartement(ddp1);
            // engaz.setValider("0");
            
               
         List<EnqueteGaz> eqLis = service.enquetegazServiceDao.findAll();
               for(EnqueteGaz dest :eqLis)
                    {
                   if(dest.getProduitgaz().getNomProduitgaz().equals("GAZ 2.7 kg"))
				   {
%>
<tbody>
  <tr>
  
 
  
  
  
    <th scope="row"><%=dest.getDepartement().getRegion().getNomregion() %></th>
    <td><%=dest.getPrixCuGros() %></td>
     <td><%=dest.getPrixCuDetail() %></td>
   
  
    
    
   </tr>
  <%
   }
                  }   
%>
</tbody>
</table>




<p>&nbsp;</p>
<p>&nbsp;</p>
<p>
  <!-- end page -->
  <!-- start footer -->
</p>
<!-- end footer -->
</body>
</html>
 

<%@page import="entites.Departement"%>
<%@page import="entites.InventairestGaz"%>
<%@page import="entites.Enqueteur"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

 <%@page import="java.util.*"%>
<jsp:useBean id="service" class="FactoryService.FactoryService"></jsp:useBean>
<%!
int n1 = 0;
int n2 = 0;
int n3 = 0;
int n4 = 0;


%>

<%

 
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
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title>Charting</title>
	<link href="css/basic.css" type="text/css" rel="stylesheet" />
	<!-- <script type="text/javascript" src="http://filamentgroup.github.com/EnhanceJS/enhance.js"></script> -->
    <script type="text/javascript" src="enhance.js"></script>
	<script type="text/javascript">
		// Run capabilities test
		enhance({
			loadScripts: [
				'js/excanvas.js',
			<!--	'https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js', -->
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
</head>
<body>

<table>
	<caption>Inventaire stocks Gaz du mois de <%=month %><%="/" %><%=year%> pour Département concernés</caption>
       <thead>
    
		<tr>
			<td></td>
			<th scope="col">TAMBA</th>
			<th scope="col">St-LOUIS</th>
			<th scope="col">MBACKE</th>
			<th scope="col">KAOLACK</th>
			<th scope="col">DIOURBEL</th>
			<th scope="col">MATAM</th>
                        <th scope="col">MBOUR</th>
                        <th scope="col">Dakar</th>
               
		</tr>
	</thead>
	<tbody>
		<tr>
			<th scope="row">Gaz 2,7 kg</th>
			<td>400</td>
			<td>0</td>
			<td>1600</td>
			<td>1050</td>
			<td>0</td>
			<td>5562</td>
                        <td>5562</td>
			<td>0</td>
           
		</tr>
		<tr>
			<th scope="row">Gaz 6 kg</th>
			<td>1800</td>
			<td>0</td>
			<td>2800</td>
			<td>3081</td>
			<td>0</td>
			<td>14740</td>
                        <td>14740</td>
			<td>0</td>
           
		</tr>
		<tr>
			<th scope="row">Gaz 9 kg</th>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
                        <td>0</td>
			<td>0</td>
          
		</tr>
		<tr>
			<th scope="row">Gaz 12,5 kg</th>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
                        <td>0</td>
			<td>0</td>
            
		</tr>
                <tr>
			<th scope="row">Gaz 38 kg</th>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
                        <td>0</td>
			<td>0</td>
            
		</tr>
	</tbody>
    
    
</table>
</body>
</html>
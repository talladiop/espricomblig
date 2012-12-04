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
	<caption class="petitcaract">
	Evolution prix en gros produit Cuisson du mois de <%=month %><%="/" %><%=year%> pour Département concernés</caption>
       <thead>
    
		<tr>
			<td width="238"></td>
			<th width="52" scope="col">TAMBA</th>
			<th width="105" scope="col">St-LOUIS</th>
			<th width="90" scope="col">MBACKE</th>
			<th width="105" scope="col">KAOLACK</th>
			<th width="111" scope="col">DIOURBEL</th>
			<th width="95" scope="col">MATAM</th>
                        <th width="93" scope="col">MBOUR</th>
                        <th width="84" scope="col">Dakar</th>
         </tr>
	</thead>
	<tbody>
		<tr>
			<th scope="row">FA (10  Kg)</th>
			<td>8000</td>
			<td>8000</td>
			<td>1050</td>
			<td>9000</td>
			<td>9000</td>
			<td>9000</td>
			<td>9000</td>
			<td>9000</td>
		</tr>
		<tr>
			<th scope="row">FA  format à charbon (3 à 7 Kg)</th>
			<td>4500</td>
			<td>4500</td>
			<td>3081</td>
			<td>7000</td>
			<td>7000</td>
			<td>7000</td>
			<td>7000</td>
			<td>7000</td>
		</tr>
		<tr>
			<th scope="row">FA  Format Thé </th>
			<td>2500</td>
			<td>2500</td>
			<td>5000</td>
			<td>2500</td>
			<td>2500</td>
			<td>2500</td>
			<td>2500</td>
			<td>2500</td>
		</tr>
		<tr>
			<th scope="row">FA  Format  4 kg</th>
			<td>0</td>
			<td>0</td>
			<td>2500</td>
			<td>5000</td>
			<td>5000</td>
			<td>5000</td>
			<td>5000</td>
			<td>5000</td>
        </tr>
                <tr>
                  <th scope="row">And</th>
                  <td>0</td>
                  <td>0</td>
                  <td>1500</td>
                  <td>2500</td>
                  <td>2500</td>
                  <td>1500</td>
                  <td>1500</td>
                  <td>1500</td>
                </tr>
                <tr>
			<th scope="row">Foyer  ordinaire (imitation F sakanal)</th>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>1500</td>
			<td>1500</td>
			<td>0</td>
                        <td>0</td>
			<td>0</td>
		</tr>
    </tbody>
    
    
</table>
</body>
</html>
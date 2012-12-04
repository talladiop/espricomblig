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
	<caption>Utilisation domestique des Combustibles</caption>
    
    
    
    
    
	<thead>
    
		<tr>
			<td></td>
			<th scope="col">Janv</th>
			<th scope="col">fevr</th>
			<th scope="col">Mars</th>
			<th scope="col">Avril</th>
			<th scope="col">Mai</th>
			<th scope="col">juin</th>
            <th scope="col">julliet</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th scope="row">Bois</th>
			<td>190</td>
			<td>160</td>
			<td>40</td>
			<td>120</td>
			<td>30</td>
			<td>70</td>
            <td>100</td>
		</tr>
		<tr>
			<th scope="row">Charbon</th>
			<td>3</td>
			<td>40</td>
			<td>30</td>
			<td>45</td>
			<td>35</td>
			<td>49</td>
            <td>70</td>
		</tr>
		<tr>
			<th scope="row">Bio...</th>
			<td>10</td>
			<td>180</td>
			<td>10</td>
			<td>85</td>
			<td>25</td>
			<td>79</td>
            <td>60</td>
		</tr>
		<tr>
			<th scope="row">Gaz</th>
			<td>40</td>
			<td>80</td>
			<td>90</td>
			<td>25</td>
			<td>15</td>
			<td>119</td>
            <td>100</td>
		</tr>
	</tbody>
    
    
    
</table>
</body>
</html>
<%@page import="org.apache.catalina.connector.Request"%>
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

//initialisation mois
int mois = 0;

//prix de diference
int n = 0;
int n1s;
int n2s = 0;
int n3 = 0;
int n4 = 0;
int n5 = 0; int mq1 = 0; int mn1 = 0; int mm1 = 0; int mc1 = 0; int md1 = 0; int mf1 = 0; int me1 = 0;
int n5s = 0; int mq1s = 0; int mn1s = 0; int mm1s = 0; int mc1s = 0; int md1s = 0; int mf1s = 0; int me1s = 0;
int mq1sa = 0; int mn1sa = 0; int mm1sa = 0; int mc1sa = 0; int md1sa = 0; int mf1sa = 0; int me1sa = 0;
int n6 = 0; int mi1 = 0; int mh1 = 0; int ms1 = 0; int mg1 = 0;
int mi1s = 0; int mh1s = 0; int ms1s = 0; int mg1s = 0; int mds1 = 0; int mb1s = 0; int ma1s = 0; int ma1sa = 0;
int mi1sa = 0; int mh1sa = 0; int ms1sa = 0; int mg1sa = 0; int mds1a = 0; int mb1ss = 0; int ma1ss = 0; int mb1sa = 0;
int ma1sa8 = 0; int mb1sa8 = 0; int  mc1sa8= 0;  int  me1sa8= 0; int md1sa8 = 0; int mf1sa8 = 0;  
int  mh1sa8= 0; int mi1sa8=0; int mg1sa8=0; int mm1sa8=0; int mn1sa8=0; int ms1sa8=0; 
int n7 = 0;
int n8 = 0;
int n9 = 0;
int n10 = 0;
int n11 = 0;
int n12 = 0;
int n13 = 0;
int n14 = 0;
int ma1 = 0;
int mb1 = 0;
//annee
int an = 2012;
//mois
//int mois = 11;



%>
<%


//intentiation du enqueteur
Enqueteur cptcl=new Enqueteur();
//recuperation session
cptcl=(Enqueteur)session.getAttribute("session1administrator");

//verification validite session
 if(cptcl !=null)
     {

int mois = Integer.parseInt(request.getParameter("mois"));
 
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title>Charting</title>
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
</head>
<body>
<p class="tailla12">Ecart entre Prix en d&eacute;tail et gros des diff&eacute;rents Gaz suivant toutes les r&eacute;gions du mois de <%if(mois == 1){out.println("Janvier");} if(mois == 2){out.println("Fevrier");}
if(mois == 3){out.println("Mars");} if(mois == 4){out.println("Avril");} 
if(mois == 5){out.println("Mai");} if(mois == 6){out.println("Juin");} 
if(mois == 7){out.println("Juillet");} if(mois == 8){out.println("Aout"); } 
if(mois == 9){out.println("Septembre");} if(mois == 10){out.println("Octobre");} 
if(mois == 11){out.println("Novembre");} if(mois == 12){out.println("Decembre");} %> 
| <a href="http://localhost:8080/espricomblig/supadmin/administrateurworkspace654333vncvfbvfjvfvfvjfvffjkfrgrggh87654nvfjfvjfvjfhjffvfvjffg1.jsp?admoneth23987hyofficeadmin=176430943">retour</a></p>
<table width="640" border="0" cellspacing="0" cellpadding="0">
<tbody>
  <tr>
    <td width="76">&nbsp;</td>
    <th width="35" scope="col">Dk</th>
    <th width="34" scope="col">Th</th>
    <th width="39" scope="col">Mt</th>
    <th width="39" scope="col">Kl</th>
    <th width="39" scope="col">DL</th>
    <th width="37" scope="col">SL</th>
    <th width="37" scope="col">FT</th>
    <th width="39" scope="col">KF</th>
    <th width="40" scope="col">Kg</th>
    <th width="40" scope="col">Kd</th>
    <th width="40" scope="col">Lg</th>
    <th width="44" scope="col">SD</th>
    <th width="43" scope="col">ZG</th>
    <th width="58" scope="col">TM</th>
  </tr>
  <%
//objet gaz
ProduitGaz prd = service.produitgazServiceDao.findByPrimaryKey(9);

%>
  <tr>
    <th scope="row">GAZ 2.7 kg</th>
    <td> <%
            
            EnqueteGaz ed1 = new EnqueteGaz();
            ed1.setAnnee(an);
            ed1.setRegion("Dakar");
            ed1.setMois(mois);
            ed1.setProduitgaz(prd);
            
            
               
         List<EnqueteGaz> eq1 = service.enquetegazServiceDao.findByValue(ed1);
               for(EnqueteGaz ee1 :eq1)
                    { n1s = ee1.getPrixCuDetail() - ee1.getPrixCuGros()+n1s; }
                   out.println(n1s); 
%></td>
    <td><%
            
            EnqueteGaz ed2 = new EnqueteGaz();
            ed2.setAnnee(an);
            ed2.setRegion("Thies");
            ed2.setMois(mois);
            ed2.setProduitgaz(prd);
           
            
               
         List<EnqueteGaz> eq2 = service.enquetegazServiceDao.findByValue(ed2);
               for(EnqueteGaz ee2 :eq2)
                    { n2s = ee2.getPrixCuDetail() - ee2.getPrixCuGros()+n2s; }
                   out.println(n2s); 
%></td>
    <td><%
            
            EnqueteGaz ed3 = new EnqueteGaz();
            ed3.setAnnee(an);
            ed3.setRegion("Matam");
            ed3.setMois(mois);
            ed3.setProduitgaz(prd);
            
               
         List<EnqueteGaz> eq3 = service.enquetegazServiceDao.findByValue(ed3);
               for(EnqueteGaz ee3 :eq3)
                    { n3 = ee3.getPrixCuDetail() - ee3.getPrixCuGros()+n3; }
                   out.println(n3); 
%></td>
    <td><%
            
            EnqueteGaz ed4 = new EnqueteGaz();
            ed4.setAnnee(an);
            ed4.setRegion("Kaolack");
            ed4.setMois(mois);
            ed4.setProduitgaz(prd);
            
               
         List<EnqueteGaz> eq4 = service.enquetegazServiceDao.findByValue(ed4);
               for(EnqueteGaz ee4 :eq4)
                    { n4 = ee4.getPrixCuDetail() - ee4.getPrixCuGros()+n4; }
                   out.println(n4); 
%></td>
    <td><%
            
            EnqueteGaz ed5 = new EnqueteGaz();
            ed5.setAnnee(an);
            ed5.setRegion("Diourbel");
            ed5.setMois(mois);
            ed5.setProduitgaz(prd);
            
               
         List<EnqueteGaz> eq5 = service.enquetegazServiceDao.findByValue(ed5);
               for(EnqueteGaz ee5 :eq5)
                    { n5 = ee5.getPrixCuDetail() - ee5.getPrixCuGros()+n5; }
                   out.println(n5); 
%></td>
    <td><%
            
            EnqueteGaz ed6 = new EnqueteGaz();
            ed6.setAnnee(an);
            ed6.setRegion("Saint-Louis");
            ed6.setMois(mois);
            ed6.setProduitgaz(prd);
            
               
         List<EnqueteGaz> eq6 = service.enquetegazServiceDao.findByValue(ed6);
               for(EnqueteGaz ee6 :eq6)
                    { n6 = ee6.getPrixCuDetail() - ee6.getPrixCuGros()+n6; }
                   out.println(n6); 
%></td>
    <td><%
            
            EnqueteGaz ed7 = new EnqueteGaz();
            ed7.setAnnee(an);
            ed7.setRegion("Fatick");
            ed7.setMois(mois);
            ed7.setProduitgaz(prd);
            
               
         List<EnqueteGaz> eq7 = service.enquetegazServiceDao.findByValue(ed7);
               for(EnqueteGaz ee7 :eq7)
                    { n7 = ee7.getPrixCuDetail() - ee7.getPrixCuGros()+n7; }
                   out.println(n7); 
%></td>
    <td><%
            
            EnqueteGaz ed8 = new EnqueteGaz();
            ed8.setAnnee(an);
            ed8.setRegion("Kaffrine");
            ed8.setMois(mois);
            ed8.setProduitgaz(prd);
            
               
         List<EnqueteGaz> eq8 = service.enquetegazServiceDao.findByValue(ed8);
               for(EnqueteGaz ee8 :eq8)
                    { n8 = ee8.getPrixCuDetail() - ee8.getPrixCuGros()+n8; }
                   out.println(n8); 
%></td>
    <td><%
            
            EnqueteGaz ed9 = new EnqueteGaz();
            ed9.setAnnee(an);
            ed9.setRegion("Kedougou");
            ed9.setMois(mois);
            ed9.setProduitgaz(prd);
            
               
         List<EnqueteGaz> eq9 = service.enquetegazServiceDao.findByValue(ed9);
               for(EnqueteGaz ee9 :eq9)
                    { n9 = ee9.getPrixCuDetail() - ee9.getPrixCuGros()+n9; }
                   out.println(n9); 
%></td>
    <td><%
            
            EnqueteGaz ed10 = new EnqueteGaz();
            ed10.setAnnee(an);
            ed10.setRegion("Kolda");
            ed10.setMois(mois);
            ed10.setProduitgaz(prd);
            
               
         List<EnqueteGaz> eq10 = service.enquetegazServiceDao.findByValue(ed10);
               for(EnqueteGaz ee10 :eq10)
                    { n10 = ee10.getPrixCuDetail() - ee10.getPrixCuGros()+n10; }
                   out.println(n10); 
%></td>
    <td><%
            
            EnqueteGaz ed11 = new EnqueteGaz();
            ed11.setAnnee(an);
            ed11.setRegion("Louga");
            ed11.setMois(mois);
            ed11.setProduitgaz(prd);
            
               
         List<EnqueteGaz> eq11 = service.enquetegazServiceDao.findByValue(ed11);
               for(EnqueteGaz ee11 :eq11)
                    { n11 = ee11.getPrixCuDetail() - ee11.getPrixCuGros()+n11; }
                   out.println(n11); 
%></td>
    <td><%
            
            EnqueteGaz ed12 = new EnqueteGaz();
            ed12.setAnnee(an);
            ed12.setRegion("Sedhiou");
            ed12.setMois(mois);
            ed12.setProduitgaz(prd);
            
               
         List<EnqueteGaz> eq12 = service.enquetegazServiceDao.findByValue(ed12);
               for(EnqueteGaz ee12 :eq12)
                    { n12 = ee12.getPrixCuDetail() - ee12.getPrixCuGros()+n12; }
                   out.println(n12); 
%></td>
    <td><%
            
            EnqueteGaz ed13 = new EnqueteGaz();
            ed13.setAnnee(an);
            ed13.setRegion("Ziguinchor");
            ed13.setMois(mois);
            ed13.setProduitgaz(prd);
            
               
         List<EnqueteGaz> eq13 = service.enquetegazServiceDao.findByValue(ed13);
               for(EnqueteGaz ee13 :eq13)
                    { n13 = ee13.getPrixCuDetail() - ee13.getPrixCuGros()+n13; }
                   out.println(n13); 
%></td>
    <td><%
            
            EnqueteGaz ed14 = new EnqueteGaz();
            ed14.setAnnee(an);
            ed14.setRegion("Tambacounda");
            ed14.setMois(mois);
            ed14.setProduitgaz(prd);
            
               
         List<EnqueteGaz> eq14 = service.enquetegazServiceDao.findByValue(ed14);
               for(EnqueteGaz ee14 :eq14)
                    { n14 = ee14.getPrixCuDetail() - ee14.getPrixCuGros()+n14; }
                   out.println(n14); 
%></td>
  </tr>
  <%
  ProduitGaz prd2 = service.produitgazServiceDao.findByPrimaryKey(10);

%>
  
  <tr>
    <th scope="row">GAZ 6kg</th>
    <td><%
            
            EnqueteGaz a = new EnqueteGaz();
            a.setAnnee(an);
            a.setRegion("Dakar");
            a.setMois(mois);
            a.setProduitgaz(prd2);
            
            
               
         List<EnqueteGaz> aa = service.enquetegazServiceDao.findByValue(a);
               for(EnqueteGaz a1 :aa)
                    { ma1 = a1.getPrixCuDetail() - a1.getPrixCuGros()+ma1; }
                   out.println(ma1); 
%></td>
    <td><%
            
            EnqueteGaz b = new EnqueteGaz();
            b.setAnnee(an);
            b.setRegion("Thies");
            b.setMois(mois);
            b.setProduitgaz(prd2);
           
            
               
         List<EnqueteGaz> ab = service.enquetegazServiceDao.findByValue(b);
               for(EnqueteGaz b1 :ab)
                    { mb1 = b1.getPrixCuDetail() - b1.getPrixCuGros()+mb1; }
                   out.println(mb1); 
%></td>
    <td><%
            
            EnqueteGaz c = new EnqueteGaz();
            c.setAnnee(an);
            c.setRegion("Matam");
            c.setMois(mois);
            c.setProduitgaz(prd2);
            
               
         List<EnqueteGaz> cb = service.enquetegazServiceDao.findByValue(c);
               for(EnqueteGaz c1 :cb)
                    { mc1 = c1.getPrixCuDetail() - c1.getPrixCuGros()+mc1; }
                   out.println(mc1); 
%></td>
    <td><%
            
            EnqueteGaz d = new EnqueteGaz();
            d.setAnnee(an);
            d.setRegion("Kaolack");
            d.setMois(mois);
            d.setProduitgaz(prd2);
            
               
        List<EnqueteGaz> db = service.enquetegazServiceDao.findByValue(d);
               for(EnqueteGaz d1 :db)
                    { md1 = d1.getPrixCuDetail() - d1.getPrixCuGros()+md1; }
                   out.println(md1); 
%></td>
    <td><%
            
            EnqueteGaz e = new EnqueteGaz();
            e.setAnnee(an);
            e.setRegion("Diourbel");
            e.setMois(mois);
            e.setProduitgaz(prd2);
            
               
         List<EnqueteGaz> eb = service.enquetegazServiceDao.findByValue(e);
               for(EnqueteGaz e1 :eb)
                    { me1 = e1.getPrixCuDetail() - e1.getPrixCuGros()+me1; }
                   out.println(me1); 
%></td>
    <td><%
            
            EnqueteGaz f = new EnqueteGaz();
            f.setAnnee(an);
            f.setRegion("Saint-Louis");
            f.setMois(mois);
            f.setProduitgaz(prd2);
            
               
         List<EnqueteGaz> fb = service.enquetegazServiceDao.findByValue(f);
               for(EnqueteGaz f1 :fb)
                    { mf1 = f1.getPrixCuDetail() - f1.getPrixCuGros()+mf1; }
                   out.println(mf1); 
%></td>
    <td><%
            
            EnqueteGaz h = new EnqueteGaz();
            h.setAnnee(an);
            h.setRegion("Fatick");
            h.setMois(mois);
            h.setProduitgaz(prd2);
            
               
         List<EnqueteGaz> hb = service.enquetegazServiceDao.findByValue(h);
               for(EnqueteGaz h1 :hb)
                    { mh1 = h1.getPrixCuDetail() - h1.getPrixCuGros()+mh1; }
                   out.println(mh1); 
%></td>
    <td><%
            
            EnqueteGaz l = new EnqueteGaz();
            l.setAnnee(an);
            l.setRegion("Kaffrine");
            l.setMois(mois);
            l.setProduitgaz(prd2);
            
               
         List<EnqueteGaz> ib = service.enquetegazServiceDao.findByValue(l);
               for(EnqueteGaz i1 :ib)
                    { mi1 = i1.getPrixCuDetail() - i1.getPrixCuGros()+mi1; }
                   out.println(mi1);  
%></td>
    <td><%
            
            EnqueteGaz ll = new EnqueteGaz();
            ll.setAnnee(an);
            ll.setRegion("Kaffrine");
            ll.setMois(mois);
            ll.setProduitgaz(prd2);
            
               
         List<EnqueteGaz> ibl = service.enquetegazServiceDao.findByValue(ll);
               for(EnqueteGaz i1 :ibl)
                    { mi1 = i1.getPrixCuDetail() - i1.getPrixCuGros()+mi1; }
                   out.println(mi1);  
%></td>
    <td><%
            
            EnqueteGaz g = new EnqueteGaz();
            g.setAnnee(an);
            g.setRegion("Kolda");
            g.setMois(mois);
            g.setProduitgaz(prd2);
            
               
         List<EnqueteGaz> gb = service.enquetegazServiceDao.findByValue(g);
               for(EnqueteGaz g1 :gb)
                    { mg1 = g1.getPrixCuDetail() - g1.getPrixCuGros()+mg1; }
                   out.println(mg1);  
%></td>
    <td><%
            
            EnqueteGaz m = new EnqueteGaz();
            m.setAnnee(an);
            m.setRegion("Louga");
            m.setMois(mois);
            m.setProduitgaz(prd2);
            
               
        List<EnqueteGaz> mb = service.enquetegazServiceDao.findByValue(m);
               for(EnqueteGaz m1 :mb)
                    { mm1 = m1.getPrixCuDetail() - m1.getPrixCuGros()+mm1; }
                   out.println(mm1); 
%></td>
    <td><%
            
            EnqueteGaz n = new EnqueteGaz();
            n.setAnnee(an);
            n.setRegion("Sedhiou");
            n.setMois(mois);
            n.setProduitgaz(prd2);
            
               
         List<EnqueteGaz> nb = service.enquetegazServiceDao.findByValue(n);
               for(EnqueteGaz n1 :nb)
                    { mn1 = n1.getPrixCuDetail() - n1.getPrixCuGros()+mn1; }
                   out.println(mn1); 
%></td>
    <td><%
            
            EnqueteGaz s = new EnqueteGaz();
            s.setAnnee(an);
            s.setRegion("Ziguinchor");
            s.setMois(mois);
            s.setProduitgaz(prd2);
            
               
         List<EnqueteGaz> sb = service.enquetegazServiceDao.findByValue(s);
               for(EnqueteGaz s1 :sb)
                    { ms1 = s1.getPrixCuDetail() - s1.getPrixCuGros()+ms1; }
                   out.println(ms1);  
%></td>
    <td><%
            
            EnqueteGaz sx = new EnqueteGaz();
            sx.setAnnee(an);
            sx.setRegion("Ziguinchor");
            sx.setMois(mois);
            sx.setProduitgaz(prd2);
            
               
         List<EnqueteGaz> sbx = service.enquetegazServiceDao.findByValue(sx);
               for(EnqueteGaz s1 :sbx)
                    { ms1 = s1.getPrixCuDetail() - s1.getPrixCuGros()+ms1; }
                   out.println(ms1);  
%></td>
  </tr>
  <tr>
  
   <%
//objet gaz
ProduitGaz pr9 = service.produitgazServiceDao.findByPrimaryKey(11);

%>
  
  
    <th scope="row">GAZ 9kg</th>
    <td><%
            
            EnqueteGaz as = new EnqueteGaz();
            as.setAnnee(an);
            as.setRegion("Dakar");
            as.setMois(mois);
            as.setProduitgaz(pr9);
            
            
               
         List<EnqueteGaz> aas = service.enquetegazServiceDao.findByValue(a);
               for(EnqueteGaz a1s :aas)
                    { ma1s = a1s.getPrixCuDetail() - a1s.getPrixCuGros()+ma1s; }
                   out.println(ma1s); 
%></td>
    <td><%
            
            EnqueteGaz bs = new EnqueteGaz();
            bs.setAnnee(an);
            bs.setRegion("Thies");
            bs.setMois(mois);
            bs.setProduitgaz(pr9);
           
            
               
         List<EnqueteGaz> abs = service.enquetegazServiceDao.findByValue(bs);
               for(EnqueteGaz b1s :abs)
                    { mb1s = b1s.getPrixCuDetail() - b1s.getPrixCuGros()+mb1s; }
                   out.println(mb1s); 
%></td>
    <td><%
            
            EnqueteGaz cs = new EnqueteGaz();
            cs.setAnnee(an);
            cs.setRegion("Matam");
            cs.setMois(mois);
            cs.setProduitgaz(pr9);
            
               
         List<EnqueteGaz> cbs = service.enquetegazServiceDao.findByValue(cs);
               for(EnqueteGaz c1s :cbs)
                    { mc1s = c1s.getPrixCuDetail() - c1s.getPrixCuGros()+mc1s; }
                   out.println(mc1s); 
%></td>
    <td><%
            
            EnqueteGaz dss = new EnqueteGaz();
            dss.setAnnee(an);
            dss.setRegion("Kaolack");
            dss.setMois(mois);
            dss.setProduitgaz(pr9);
            
               
        List<EnqueteGaz> dbs = service.enquetegazServiceDao.findByValue(dss);
               for(EnqueteGaz d1s :dbs)
                    { md1s = d1s.getPrixCuDetail() - d1s.getPrixCuGros()+md1s; }
                   out.println(mds1); 
%></td>
    <td><%
            
            EnqueteGaz es = new EnqueteGaz();
            es.setAnnee(an);
            es.setRegion("Diourbel");
            es.setMois(mois);
            es.setProduitgaz(pr9);
            
               
         List<EnqueteGaz> ebs = service.enquetegazServiceDao.findByValue(es);
               for(EnqueteGaz e1s :ebs)
                    { me1s = e1s.getPrixCuDetail() - e1s.getPrixCuGros()+me1s; }
                   out.println(me1s); 
%></td>
    <td><%
            
            EnqueteGaz fs = new EnqueteGaz();
            fs.setAnnee(an);
            fs.setRegion("Saint-Louis");
            fs.setMois(mois);
            fs.setProduitgaz(pr9);
            
               
         List<EnqueteGaz> fbs = service.enquetegazServiceDao.findByValue(fs);
               for(EnqueteGaz f1s :fbs)
                    { mf1s = f1s.getPrixCuDetail() - f1s.getPrixCuGros()+mf1s; }
                   out.println(mf1s); 
%></td>
    <td><%
            
            EnqueteGaz hs = new EnqueteGaz();
            hs.setAnnee(an);
            hs.setRegion("Fatick");
            hs.setMois(mois);
            hs.setProduitgaz(pr9);
            
               
         List<EnqueteGaz> hbs = service.enquetegazServiceDao.findByValue(hs);
               for(EnqueteGaz h1s :hbs)
                    { mh1s = h1s.getPrixCuDetail() - h1s.getPrixCuGros()+mh1s; }
                   out.println(mh1s); 
%></td>
    <td><%
            
            EnqueteGaz ls = new EnqueteGaz();
            ls.setAnnee(an);
            ls.setRegion("Kaffrine");
            ls.setMois(mois);
            ls.setProduitgaz(pr9);
            
               
         List<EnqueteGaz> ibs = service.enquetegazServiceDao.findByValue(ls);
               for(EnqueteGaz i1s :ibs)
                    { mi1s = i1s.getPrixCuDetail() - i1s.getPrixCuGros()+mi1s; }
                   out.println(mi1s);  
%></td>
    <td><%
            
            EnqueteGaz lsc = new EnqueteGaz();
            lsc.setAnnee(an);
            lsc.setRegion("Kaffrine");
            lsc.setMois(mois);
            lsc.setProduitgaz(pr9);
            
               
         List<EnqueteGaz> ibsc = service.enquetegazServiceDao.findByValue(lsc);
               for(EnqueteGaz i1s :ibsc)
                    { mi1s = i1s.getPrixCuDetail() - i1s.getPrixCuGros()+mi1s; }
                   out.println(mi1s);  
%></td>
    <td><%
            
            EnqueteGaz gs = new EnqueteGaz();
            gs.setAnnee(an);
            gs.setRegion("Kolda");
            gs.setMois(mois);
            gs.setProduitgaz(pr9);
            
               
         List<EnqueteGaz> gbs = service.enquetegazServiceDao.findByValue(gs);
               for(EnqueteGaz g1s :gbs)
                    { mg1s = g1s.getPrixCuDetail() - g1s.getPrixCuGros()+mg1s; }
                   out.println(mg1s);  
%></td>
    <td><%
            
            EnqueteGaz ms = new EnqueteGaz();
            ms.setAnnee(an);
            ms.setRegion("Louga");
            ms.setMois(mois);
            ms.setProduitgaz(pr9);
            
               
        List<EnqueteGaz> mbs = service.enquetegazServiceDao.findByValue(ms);
               for(EnqueteGaz m1s :mbs)
                    { mm1s = m1s.getPrixCuDetail() - m1s.getPrixCuGros()+mm1s; }
                   out.println(mm1s); 
%></td>
    <td><%
            
            EnqueteGaz ns = new EnqueteGaz();
            ns.setAnnee(an);
            ns.setRegion("Sedhiou");
            ns.setMois(mois);
            ns.setProduitgaz(pr9);
            
               
         List<EnqueteGaz> nbs = service.enquetegazServiceDao.findByValue(ns);
               for(EnqueteGaz n1s :nbs)
                    { mn1s = n1s.getPrixCuDetail() - n1s.getPrixCuGros()+mn1s; }
                   out.println(mn1s); 
%></td>
    <td><%
            
            EnqueteGaz ss = new EnqueteGaz();
            ss.setAnnee(an);
            ss.setRegion("Ziguinchor");
            ss.setMois(mois);
            ss.setProduitgaz(pr9);
            
               
         List<EnqueteGaz> sbs = service.enquetegazServiceDao.findByValue(ss);
               for(EnqueteGaz s1s :sbs)
                    { ms1s = s1s.getPrixCuDetail() - s1s.getPrixCuGros()+ms1s; }
                   out.println(ms1s);  
%></td>
    <td><%
            
            EnqueteGaz ssc = new EnqueteGaz();
            ssc.setAnnee(an);
            ssc.setRegion("Ziguinchor");
            ssc.setMois(mois);
            ssc.setProduitgaz(pr9);
            
               
         List<EnqueteGaz> sbsc = service.enquetegazServiceDao.findByValue(ssc);
               for(EnqueteGaz s1s :sbsc)
                    { ms1s = s1s.getPrixCuDetail() - s1s.getPrixCuGros()+ms1s; }
                   out.println(ms1s);  
%></td>
  </tr>
  <tr>
 <% 
  //objet gaz
ProduitGaz pr12 = service.produitgazServiceDao.findByPrimaryKey(12);

%>
  
  
    <th scope="row">GAZ 12kg</th>
    <td><%
            
            EnqueteGaz asa = new EnqueteGaz();
            asa.setAnnee(an);
            asa.setRegion("Dakar");
            asa.setMois(mois);
            asa.setProduitgaz(pr12);
            
            
               
         List<EnqueteGaz> aasa = service.enquetegazServiceDao.findByValue(asa);
               for(EnqueteGaz a1sa :aasa)
                    { ma1sa = a1sa.getPrixCuDetail() - a1sa.getPrixCuGros()+ma1sa; }
                   out.println(ma1sa); 
%></td>
    <td><%
            
            EnqueteGaz bsa = new EnqueteGaz();
            bsa.setAnnee(an);
            bsa.setRegion("Thies");
            bsa.setMois(mois);
            bsa.setProduitgaz(pr12);
           
            
               
         List<EnqueteGaz> absa = service.enquetegazServiceDao.findByValue(bsa);
               for(EnqueteGaz b1sa :absa)
                    { mb1sa = b1sa.getPrixCuDetail() - b1sa.getPrixCuGros()+mb1sa; }
                   out.println(mb1sa); 
%></td>
    <td><%
            
            EnqueteGaz csa = new EnqueteGaz();
            csa.setAnnee(an);
            csa.setRegion("Matam");
            csa.setMois(mois);
            csa.setProduitgaz(pr12);
            
               
         List<EnqueteGaz> cbsa = service.enquetegazServiceDao.findByValue(csa);
               for(EnqueteGaz c1sa :cbsa)
                    { mc1sa = c1sa.getPrixCuDetail() - c1sa.getPrixCuGros()+mc1sa; }
                   out.println(mc1sa); 
%></td>
    <td><%
            
            EnqueteGaz dssa = new EnqueteGaz();
            dssa.setAnnee(an);
            dssa.setRegion("Kaolack");
            dssa.setMois(mois);
            dssa.setProduitgaz(pr12);
            
               
        List<EnqueteGaz> dbsa = service.enquetegazServiceDao.findByValue(dssa);
               for(EnqueteGaz d1sa :dbsa)
                    { md1sa = d1sa.getPrixCuDetail() - d1sa.getPrixCuGros()+md1sa; }
                   out.println(mds1a); 
%></td>
    <td><%
            
            EnqueteGaz esa = new EnqueteGaz();
            esa.setAnnee(an);
            esa.setRegion("Diourbel");
            esa.setMois(mois);
            esa.setProduitgaz(pr12);
            
               
         List<EnqueteGaz> ebsa = service.enquetegazServiceDao.findByValue(esa);
               for(EnqueteGaz e1sa :ebsa)
                    { me1sa = e1sa.getPrixCuDetail() - e1sa.getPrixCuGros()+me1sa; }
                   out.println(me1sa); 
%></td>
    <td><%
            
            EnqueteGaz fsa = new EnqueteGaz();
            fsa.setAnnee(an);
            fsa.setRegion("Saint-Louis");
            fsa.setMois(mois);
            fsa.setProduitgaz(pr12);
            
               
         List<EnqueteGaz> fbsa = service.enquetegazServiceDao.findByValue(fsa);
               for(EnqueteGaz f1sa :fbsa)
                    { mf1sa = f1sa.getPrixCuDetail() - f1sa.getPrixCuGros()+mf1sa; }
                   out.println(mf1sa); 
%></td>
    <td><%
            
            EnqueteGaz hsa = new EnqueteGaz();
            hsa.setAnnee(an);
            hsa.setRegion("Fatick");
            hsa.setMois(mois);
            hsa.setProduitgaz(pr12);
            
               
         List<EnqueteGaz> hbsa = service.enquetegazServiceDao.findByValue(hsa);
               for(EnqueteGaz h1sa :hbsa)
                    { mh1sa = h1sa.getPrixCuDetail() - h1sa.getPrixCuGros()+mh1sa; }
                   out.println(mh1sa); 
%></td>
    <td><%
            
            EnqueteGaz lsa = new EnqueteGaz();
            lsa.setAnnee(an);
            lsa.setRegion("Kaffrine");
            lsa.setMois(mois);
            lsa.setProduitgaz(pr12);
            
               
         List<EnqueteGaz> ibsa = service.enquetegazServiceDao.findByValue(lsa);
               for(EnqueteGaz i1sa :ibsa)
                    { mi1sa = i1sa.getPrixCuDetail() - i1sa.getPrixCuGros()+mi1sa; }
                   out.println(mi1sa);  
%></td>
    <td><%
            
            EnqueteGaz lsca = new EnqueteGaz();
            lsca.setAnnee(an);
            lsca.setRegion("Kaffrine");
            lsca.setMois(mois);
            lsca.setProduitgaz(pr12);
            
               
         List<EnqueteGaz> ibsca = service.enquetegazServiceDao.findByValue(lsca);
               for(EnqueteGaz i1sa :ibsca)
                    { mi1sa = i1sa.getPrixCuDetail() - i1sa.getPrixCuGros()+mi1sa; }
                   out.println(mi1sa);  
%></td>
    <td><%
            
            EnqueteGaz gsa = new EnqueteGaz();
            gsa.setAnnee(an);
            gsa.setRegion("Kolda");
            gsa.setMois(mois);
            gsa.setProduitgaz(pr12);
            
               
         List<EnqueteGaz> gbsa = service.enquetegazServiceDao.findByValue(gsa);
               for(EnqueteGaz g1sa :gbsa)
                    { mg1sa = g1sa.getPrixCuDetail() - g1sa.getPrixCuGros()+mg1sa; }
                   out.println(mg1sa);  
%></td>
    <td><%
            
            EnqueteGaz msa = new EnqueteGaz();
            msa.setAnnee(an);
            msa.setRegion("Louga");
            msa.setMois(mois);
            msa.setProduitgaz(pr12);
            
               
        List<EnqueteGaz> mbsa = service.enquetegazServiceDao.findByValue(msa);
               for(EnqueteGaz m1sa :mbsa)
                    { mm1sa = m1sa.getPrixCuDetail() - m1sa.getPrixCuGros()+mm1sa; }
                   out.println(mm1sa); 
%></td>
    <td><%
            
            EnqueteGaz nsa = new EnqueteGaz();
            nsa.setAnnee(an);
            nsa.setRegion("Sedhiou");
            nsa.setMois(mois);
            nsa.setProduitgaz(pr12);
            
               
         List<EnqueteGaz> nbsa = service.enquetegazServiceDao.findByValue(nsa);
               for(EnqueteGaz n1sa :nbsa)
                    { mn1sa = n1sa.getPrixCuDetail() - n1sa.getPrixCuGros()+mn1sa; }
                   out.println(mn1sa); 
%></td>
    <td><%
            
            EnqueteGaz ssa = new EnqueteGaz();
            ssa.setAnnee(an);
            ssa.setRegion("Ziguinchor");
            ssa.setMois(mois);
            ssa.setProduitgaz(pr12);
            
               
         List<EnqueteGaz> sbsa = service.enquetegazServiceDao.findByValue(ss);
               for(EnqueteGaz s1sa :sbsa)
                    { ms1sa = s1sa.getPrixCuDetail() - s1sa.getPrixCuGros()+ms1sa; }
                   out.println(ms1sa);  
%></td>
    <td><%
            
            EnqueteGaz ssca = new EnqueteGaz();
            ssca.setAnnee(an);
            ssca.setRegion("Ziguinchor");
            ssca.setMois(mois);
            ssca.setProduitgaz(pr12);
            
               
         List<EnqueteGaz> sbsca = service.enquetegazServiceDao.findByValue(ssca);
               for(EnqueteGaz s1sa :sbsca)
                    { ms1sa = s1sa.getPrixCuDetail() - s1sa.getPrixCuGros()+ms1sa; }
                   out.println(ms1sa);  
%></td>
    </tr>
  <tr>
      
    <% 
  //objet gaz
ProduitGaz pr38 = service.produitgazServiceDao.findByPrimaryKey(13);

%>  
      
    <th scope="row">GAZ 38 kg</th>
    <td><%
            
            EnqueteGaz asa8 = new EnqueteGaz();
            asa8.setAnnee(an);
            asa8.setRegion("Dakar");
            asa8.setMois(mois);
            asa8.setProduitgaz(pr38);
            
            
               
         List<EnqueteGaz> aasa8 = service.enquetegazServiceDao.findByValue(asa8);
               for(EnqueteGaz a1sa8 :aasa8)
                    { ma1sa8 = a1sa8.getPrixCuDetail() - a1sa8.getPrixCuGros()+ma1sa8; }
                   out.println(ma1sa8); 
%></td>
    <td><%
            
            EnqueteGaz bsa8 = new EnqueteGaz();
            bsa8.setAnnee(an);
            bsa8.setRegion("Thies");
            bsa8.setMois(mois);
            bsa8.setProduitgaz(pr38);
           
            
               
         List<EnqueteGaz> absa8 = service.enquetegazServiceDao.findByValue(bsa8);
               for(EnqueteGaz b1sa88 :absa8)
                    { mb1sa8 = b1sa88.getPrixCuDetail() - b1sa88.getPrixCuGros()+mb1sa8; }
                   out.println(mb1sa8); 
%></td>
    <td><%
            
            EnqueteGaz csa8 = new EnqueteGaz();
            csa8.setAnnee(an);
            csa8.setRegion("Matam");
            csa8.setMois(mois);
            csa8.setProduitgaz(pr38);
            
               
         List<EnqueteGaz> cbsa8 = service.enquetegazServiceDao.findByValue(csa8);
               for(EnqueteGaz c1sa8 :cbsa8)
                    { mc1sa8 = c1sa8.getPrixCuDetail() - c1sa8.getPrixCuGros()+mc1sa8; }
                   out.println(mc1sa8); 
%></td>
    <td><%
            
            EnqueteGaz dssa8 = new EnqueteGaz();
            dssa8.setAnnee(an);
            dssa8.setRegion("Kaolack");
            dssa8.setMois(mois);
            dssa8.setProduitgaz(pr38);
            
               
        List<EnqueteGaz> dbsa8 = service.enquetegazServiceDao.findByValue(dssa8);
               for(EnqueteGaz d1sa8 :dbsa8)
                    { md1sa8 = d1sa8.getPrixCuDetail() - d1sa8.getPrixCuGros()+md1sa8; }
                   out.println(md1sa8); 
%></td>
    <td><%
            
            EnqueteGaz esa8 = new EnqueteGaz();
            esa8.setAnnee(an);
            esa8.setRegion("Diourbel");
            esa8.setMois(mois);
            esa8.setProduitgaz(pr38);
            
               
         List<EnqueteGaz> ebsa8 = service.enquetegazServiceDao.findByValue(esa8);
               for(EnqueteGaz e1sa8 :ebsa8)
                    { me1sa8 = e1sa8.getPrixCuDetail() - e1sa8.getPrixCuGros()+me1sa8; }
                   out.println(me1sa8); 
%></td>
    <td><%
            
            EnqueteGaz fsa8 = new EnqueteGaz();
            fsa8.setAnnee(an);
            fsa8.setRegion("Saint-Louis");
            fsa8.setMois(mois);
            fsa8.setProduitgaz(pr38);
            
               
         List<EnqueteGaz> fbsa8 = service.enquetegazServiceDao.findByValue(fsa8);
               for(EnqueteGaz f1sa8 :fbsa8)
                    { mf1sa8 = f1sa8.getPrixCuDetail() - f1sa8.getPrixCuGros()+mf1sa8; }
                   out.println(mf1sa8); 
%></td>
    <td><%
            
            EnqueteGaz hsa8 = new EnqueteGaz();
            hsa8.setAnnee(an);
            hsa8.setRegion("Fatick");
            hsa8.setMois(mois);
            hsa8.setProduitgaz(pr38);
            
               
         List<EnqueteGaz> hbsa8 = service.enquetegazServiceDao.findByValue(hsa);
               for(EnqueteGaz h1sa8 :hbsa8)
                    { mh1sa8 = h1sa8.getPrixCuDetail() - h1sa8.getPrixCuGros()+mh1sa8; }
                   out.println(mh1sa8); 
%></td>
    <td><%
            
            EnqueteGaz lsa8 = new EnqueteGaz();
            lsa8.setAnnee(an);
            lsa8.setRegion("Kaffrine");
            lsa8.setMois(mois);
            lsa8.setProduitgaz(pr38);
            
               
         List<EnqueteGaz> ibsa8 = service.enquetegazServiceDao.findByValue(lsa8);
               for(EnqueteGaz i1sa8 :ibsa8)
                    { mi1sa8 = i1sa8.getPrixCuDetail() - i1sa8.getPrixCuGros()+mi1sa8; }
                   out.println(mi1sa8);  
%></td>
    <td><%
            
            EnqueteGaz lsca8 = new EnqueteGaz();
            lsca8.setAnnee(an);
            lsca8.setRegion("Kaffrine");
            lsca8.setMois(mois);
            lsca8.setProduitgaz(pr38);
            
               
         List<EnqueteGaz> ibsca8 = service.enquetegazServiceDao.findByValue(lsca8);
               for(EnqueteGaz i1sa8 :ibsca8)
                    { mi1sa8 = i1sa8.getPrixCuDetail() - i1sa8.getPrixCuGros()+mi1sa8; }
                   out.println(mi1sa8);  
%></td>
    <td><%
            
            EnqueteGaz gsa8 = new EnqueteGaz();
            gsa8.setAnnee(an);
            gsa8.setRegion("Kolda");
            gsa8.setMois(mois);
            gsa8.setProduitgaz(pr38);
            
               
         List<EnqueteGaz> gbsa8 = service.enquetegazServiceDao.findByValue(gsa8);
               for(EnqueteGaz g1sa8 :gbsa8)
                    { mg1sa8 = g1sa8.getPrixCuDetail() - g1sa8.getPrixCuGros()+mg1sa8; }
                   out.println(mg1sa8);  
%></td>
    <td><%
            
            EnqueteGaz msa8 = new EnqueteGaz();
            msa8.setAnnee(an);
            msa8.setRegion("Louga");
            msa8.setMois(mois);
            msa8.setProduitgaz(pr38);
            
               
        List<EnqueteGaz> mbsa8 = service.enquetegazServiceDao.findByValue(msa8);
               for(EnqueteGaz m1sa8 :mbsa8)
                    { mm1sa8 = m1sa8.getPrixCuDetail() - m1sa8.getPrixCuGros()+mm1sa8; }
                   out.println(mm1sa8); 
%></td>
    <td><%
            
            EnqueteGaz nsa8 = new EnqueteGaz();
            nsa8.setAnnee(an);
            nsa8.setRegion("Sedhiou");
            nsa8.setMois(mois);
            nsa8.setProduitgaz(pr38);
            
               
         List<EnqueteGaz> nbsa8 = service.enquetegazServiceDao.findByValue(nsa8);
               for(EnqueteGaz n1sa8 :nbsa8)
                    { mn1sa8 = n1sa8.getPrixCuDetail() - n1sa8.getPrixCuGros()+mn1sa8; }
                   out.println(mn1sa8); 
%></td>
    <td><%
            
            EnqueteGaz ssa8 = new EnqueteGaz();
            ssa8.setAnnee(an);
            ssa8.setRegion("Ziguinchor");
            ssa8.setMois(mois);
            ssa8.setProduitgaz(pr38);
            
               
         List<EnqueteGaz> sbsa8 = service.enquetegazServiceDao.findByValue(ssa8);
               for(EnqueteGaz s1sa8 :sbsa8)
                    { ms1sa8 = s1sa8.getPrixCuDetail() - s1sa8.getPrixCuGros()+ms1sa8; }
                   out.println(ms1sa8);  
%></td>
    <td><%
            
            EnqueteGaz ssca8 = new EnqueteGaz();
            ssca8.setAnnee(an);
            ssca8.setRegion("Ziguinchor");
            ssca8.setMois(mois);
            ssca8.setProduitgaz(pr38);
            
               
         List<EnqueteGaz> sbsca8 = service.enquetegazServiceDao.findByValue(ssca8);
               for(EnqueteGaz s1sa8 :sbsca8)
                    { ms1sa8 = s1sa8.getPrixCuDetail() - s1sa8.getPrixCuGros()+ms1sa8; }
                   out.println(ms1sa8);  
%></td>
    </tr>
  </tbody>
  
</table>
<p><a href="http://localhost:8080/espricomblig/supadmin/administrateurworkspace654333vncvfbvfjvfvfvjfvffjkfrgrggh87654nvfjfvjfvjfhjffvfvjffg1.jsp?admoneth23987hyofficeadmin=176430943">Retour</a></p>
<p>&nbsp;</p>
</body>
</html>
 <% }else{
response.sendRedirect("http://localhost:8080/espricomblig/supadmin/administrateur.jsp?edygeuguyegygfefd=655&dfdefgff=65shxhjcvhvdc&dfdfedjfbjfbgrjkgfrjhgbrjgbrgjhh=76543bjbjkvbjf");
 }
%>
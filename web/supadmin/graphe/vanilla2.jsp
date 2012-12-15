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
int mois = 11;


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
<p class="tailla12">Ecart entre Prix en d&eacute;tail et gros des diff&eacute;rents Gaz suivant les r&eacute;gions</p>
<table width="600" border="0" cellspacing="0" cellpadding="0">
  <tbody>
    <tr> 
    <td width="80">&nbsp;</td>
    
     <%
  //recherche region
  Region rg = service.regionServiceDao.findByPrimaryKey(1);
  //recherche departement
   Departement dep = new Departement();
            dep.setRegion(rg);
           
            
            
               
         List<Departement> dr = service.departeServiceDao.findByValue(dep);
               for(Departement ee1: dr)
                    {
						 
  
  %>
    
    <th scope="col"><%=ee1.getNomdepartement() %></th>
  
    <%
}
       
%>
    
    </tr>
    <%
//objet gaz
ProduitGaz prd = service.produitgazServiceDao.findByPrimaryKey(9);

%>
    <tr>
      <th scope="row">GAZ 2.7 kg</th>
      <td><%
      //recherche departement
      Departement ad = new Departement();
            ad.setNomdepartement("Dakar");
            
            EnqueteGaz ed1 = new EnqueteGaz();
            ed1.setAnnee(an);
            ed1.setRegion("Dakar");
            ed1.setMois(mois);
            ed1.setProduitgaz(prd);
            ed1.setDepartement(ad);
            
            
               
         List<EnqueteGaz> eq1 = service.enquetegazServiceDao.findByValue(ed1);
               for(EnqueteGaz ee1 :eq1)
                    { n1s = ee1.getPrixCuDetail() - ee1.getPrixCuGros()+n1s; }
                   out.println(n1s); 
%></td>
      <td><%
      //recherche depart
     Departement bd = new Departement();
            bd.setNomdepartement("Guediawaye");
            
            EnqueteGaz ed2 = new EnqueteGaz();
            ed2.setAnnee(an);
            ed2.setRegion("Dakar");
            ed2.setMois(mois);
            ed2.setProduitgaz(prd);
            ed2.setDepartement(bd);
           
            
               
         List<EnqueteGaz> eq2 = service.enquetegazServiceDao.findByValue(ed2);
               for(EnqueteGaz ee2 :eq2)
                    { n2s = ee2.getPrixCuDetail() - ee2.getPrixCuGros()+n2s; }
                   out.println(n2s); 
%></td>
      <td><%
      //recherche depart
     Departement cd = new Departement();
            cd.setNomdepartement("Pikine");
            
            EnqueteGaz ed3 = new EnqueteGaz();
            ed3.setAnnee(an);
            ed3.setRegion("Dakar");
            ed3.setMois(mois);
            ed3.setProduitgaz(prd);
            ed3.setDepartement(cd);
            
               
         List<EnqueteGaz> eq3 = service.enquetegazServiceDao.findByValue(ed3);
               for(EnqueteGaz ee3 :eq3)
                    { n3 = ee3.getPrixCuDetail() - ee3.getPrixCuGros()+n3; }
                   out.println(n3); 
%></td>
      <td><%
            Departement dd = new Departement();
            dd.setNomdepartement("Rufisque");
            
            EnqueteGaz ed4 = new EnqueteGaz();
            ed4.setAnnee(an);
            ed4.setRegion("Dakar");
            ed4.setMois(mois);
            ed4.setProduitgaz(prd);
            ed4.setDepartement(dd);
            
               
         List<EnqueteGaz> eq4 = service.enquetegazServiceDao.findByValue(ed4);
               for(EnqueteGaz ee4 :eq4)
                    { n4 = ee4.getPrixCuDetail() - ee4.getPrixCuGros()+n4; }
                   out.println(n4); 
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
            b.setRegion("Dakar");
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
            c.setRegion("Dakar");
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
    </tr>
  </tbody>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
</body>
</html>
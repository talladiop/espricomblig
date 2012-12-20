/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;
import FactoryService.FactoryService;
import entites.EnqueteCl;
import entites.Enqueteur;
import entites.ProduitCl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Talla
 */
public class InsertionEnqueteCL extends FactoryService
{
   static final long serialVersionUID = 1L;


	public InsertionEnqueteCL()
        {
		super();
	}


        @Override
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
              doPost(request, response);
        }


        @Override
	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
              //recherche 
                    EnqueteCl ct = null;
                    //déclaration de l'objet person

            HttpSession session=request.getSession();
            
            //determination Date enregistrement
    java.util.Calendar currDate = new java.util.GregorianCalendar();
   // add 1 to month because Calendar's months start at 0, not 1
   int month = currDate.get(currDate.MONTH)+1;
   int day = currDate.get(currDate.DAY_OF_MONTH);
   int year = currDate.get(currDate.YEAR);
   int minute = currDate.get(currDate.MINUTE);
   int seconde = currDate.get(currDate.SECOND);
   int heure = currDate.get(currDate.HOUR);
   
   String dateenregistrer = day+"/"+month+"/"+year;
            
            

           try{
               
               
               //verification presence et remplacement caractere <<',é,è,ç,...>> dans la chaine de caractere message
                      String descript = request.getParameter("typecondition");
                       //remplacer "'" par "" dans description
                       String courier =  descript.replaceAll("'", " ");
                       //remplacement <<é >>
                       String co =  courier.replaceAll("Ã©", "é");
                       //remplacement <<è >>
                       String co1 =  co.replaceAll("Ã¨", "è");
                       //remplacement <<à >>
                       //String cour = enleveraccentServiceDao.supprimeAccentEA(co1);
                       String co2 =  co1.replaceAll("Ã", "à");
                       //remplacement <<ç >>
                       String co3 = co2.replaceAll("à§", "ç");
                        String co4 = co3.replaceAll("Ã´", "ô");
                        String co5 = co4.replaceAll("Â½", "½");
                        String typecondition = co5.replaceAll("Ãª", "ê");
                        
                        //remplacement <<é,è>> dans marche
                       String ee = request.getParameter("marche"); 
                       String eepl =  ee.replaceAll("Ã©", "é");
                       String eepll =  eepl.replaceAll("Ã©", "é");
                       String eeplll = eepll.replaceAll("A§", "ç");
                       String eepllll = eeplll.replaceAll("Ã", "à");
                       String eeplllll =  eepllll.replaceAll("'", " ");
                       String eepllllll = eeplllll.replaceAll("Ã´", "ô");
                       String marche = eepllllll.replaceAll("Ãª", "ê");
                       
                       

                 //férification des entrées de sisies
		if(!"".equals(request.getParameter("produitcl")) && request.getParameter("produitcl")!=null
                    && !"".equals(request.getParameter("typecondition")) && request.getParameter("typecondition")!=null
                    &&	!"".equals(request.getParameter("equikgmin")) && request.getParameter("equikgmin")!=null
                    && !"".equals(request.getParameter("equikgmax")) && request.getParameter("equikgmax")!=null
		    &&	!"".equals(request.getParameter("pg")) && request.getParameter("pg")!=null
		    && !"".equals(request.getParameter("pd")) && request.getParameter("pd")!=null
                    )

		 {
                    
                     //recherche produit
                     ProduitCl prcl = produitclServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("produitcl")));
                     
                     
                     
                     //rercherche departement
                    Enqueteur enq = enqueteurServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("idenqueteur")));
                    
                     
                      //enregistrement du enquetecl
			ct = new EnqueteCl(0,
                                        prcl,
					typecondition,
                                        Float.parseFloat(request.getParameter("equikgmin")),
                                        Float.parseFloat(request.getParameter("equikgmax")),
					Integer.parseInt(request.getParameter("pg")),
                                        Integer.parseInt(request.getParameter("pd")),
                                        dateenregistrer,
                                        marche,
                                       enq,
                                       enq.getDepartement(),
                                       enq.getDepartement().getRegion().getNomregion(),
                                         month,
                                         year,
                                        "0"
					 );
  
			
                           if(enqueteclServiceDao.creerEnqueteCL(ct))
                                     {
                                                                                  
                                       
				    response.sendRedirect("produitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=184469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                     else{
                               
                                       response.sendRedirect("produitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefejsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                



			}
                else
                {
                    
                  response.sendRedirect("produitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
               }

                }

           catch(Exception e)
           {
 
              response.sendRedirect("produitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
             ServletContext sc = getServletContext();
             //sc.log(e.getMessage());
            }
                  }

}

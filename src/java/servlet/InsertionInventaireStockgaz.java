/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;
import FactoryService.FactoryService;
import entites.Departement;
import entites.EnqueteGaz;
import entites.Enqueteur;
import entites.InventairestGaz;
import entites.ProduitGaz;
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
public class InsertionInventaireStockgaz extends FactoryService
{
   static final long serialVersionUID = 1L;


	public InsertionInventaireStockgaz()
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
              //intentiation enquetegaz
              InventairestGaz ct = new InventairestGaz();
              //intentiation objet enqueteur
              Enqueteur enq = new Enqueteur();
              //recherche de l'enqueteur
              enq = enqueteurServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("idenqueu")));
                 
            //objet session
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
               
               
                        

                 //férification des entrées de sisies
		if(!"".equals(request.getParameter("qt")) && request.getParameter("qt")!=null
                    
		    
                    )

		 {
                     
                     //rercherche departement
                     Departement dp = new Departement();
                     dp = departeServiceDao.findByPrimaryKey(enq.getDepartement().getIDdepartement());
                     
                     
                      //rercherche produit
                     ProduitGaz prod = new ProduitGaz();
                     prod = produitgazServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("gaz")));
                    
                    
                      //enregistrement du enqueteur
			ct = new InventairestGaz(0,prod,
                                        Integer.parseInt(request.getParameter("qt")),
                                        dateenregistrer,
                                        enq,
                                        dp,
                                        dp.getRegion().getNomregion(),
                                         month,
                                         year,
                                         "0");
					
			
                           if(inventaireServiceDao.creer(ct))
                                     {
                                                                                 
                                       
				    response.sendRedirect("inventairegazcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=184469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                     else{
                                       response.sendRedirect("inventairegazcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                



			}
                else
                {
                  response.sendRedirect("inventairegazcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
               }

                }

           catch(Exception e)
           {

              response.sendRedirect("inventairegazcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
             ServletContext sc = getServletContext();
             //sc.log(e.getMessage());
            }
                  }

}

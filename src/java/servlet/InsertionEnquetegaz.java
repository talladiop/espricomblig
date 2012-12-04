/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;
import FactoryService.FactoryService;
import entites.Departement;
import entites.EnqueteGaz;
import entites.Enqueteur;
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
public class InsertionEnquetegaz extends FactoryService
{
   static final long serialVersionUID = 1L;


	public InsertionEnquetegaz()
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
              EnqueteGaz ct = new EnqueteGaz();
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
		if(!"".equals(request.getParameter("pcg")) && request.getParameter("pcg")!=null
                    && !"".equals(request.getParameter("pcd")) && request.getParameter("pcd")!=null
                   // &&	!"".equals(request.getParameter("ppg")) && request.getParameter("ppg")!=null
		   // &&	!"".equals(request.getParameter("ppd")) && request.getParameter("ppd")!=null
		    
                    )

		 {
                     //recherche 
                     //rercherche departement
                     Departement dp = new Departement();
                     dp = departeServiceDao.findByPrimaryKey(enq.getDepartement().getIDdepartement());
                     
                     
                      //rercherche produit
                     ProduitGaz prod = new ProduitGaz();
                     prod = produitgazServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("gaz")));
                    
                     
                      //enregistrement du enqueteur : NB prix periferique gros et detail pour departement est a 0
			ct = new EnqueteGaz(0,prod,
                                        Integer.parseInt(request.getParameter("pcg")),
					Integer.parseInt(request.getParameter("pcd")),
                                        0,
					0,
                                        dateenregistrer,
                                        enq,
                                        dp );
					
			
                           if(enquetegazServiceDao.save(ct))
                                     {
                                                                                  
                                       
				    response.sendRedirect("enquetegazcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=184469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                     else{
                                       response.sendRedirect("enquetegazcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                



			}
                else
                {
                  response.sendRedirect("enquetegazcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
               }

                }

           catch(Exception e)
           {

              response.sendRedirect("enquetegazcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
             ServletContext sc = getServletContext();
             //sc.log(e.getMessage());
            }
                  }

}

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
public class ModifInventaireGaz extends FactoryService
{
   static final long serialVersionUID = 1L;


	public ModifInventaireGaz()
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
              
              InventairestGaz invente = new InventairestGaz();
              //recherche de l'enqueteur
              enq = enqueteurServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("idenqueu")));
                 
               //recherche de l'enqueteur
              invente = inventaireServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("idinvent")));
                 
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
            
            //id inventaire 
           // InventairestGaz gazinv = inventaireServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("dest65432id5432")));

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
			ct = new InventairestGaz();
                        
                        ct.setIdEnventairegaz(Integer.parseInt(request.getParameter("idinvent")));
                        ct.setProduitgaz(prod);
                        ct.setQt(Integer.parseInt(request.getParameter("qt")));
                        ct.setDateEnr(dateenregistrer);
                        ct.setEnqueteur(enq);
                        ct.setDepartement(dp);
                        ct.setValider("0");
                        ct.setValiderfinale("0");
                                        
					
			
                           if(inventaireServiceDao.modifier(ct))
                                     {
                                                                                  
                                       
				    response.sendRedirect("modifinventaireGAZcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=184469578&dest65432id5432="+invente.getIdEnventairegaz()+"&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                     else{
                                       response.sendRedirect("modifinventaireGAZcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&dest65432id5432="+invente.getIdEnventairegaz()+"&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                



			}
                else
                {
                  response.sendRedirect("modifinventaireGAZcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&dest65432id5432="+invente.getIdEnventairegaz()+"&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
               }

                }
 
           catch(Exception e)
           {

              response.sendRedirect("modifinventaireGAZcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&dest65432id5432="+invente.getIdEnventairegaz()+"&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
             ServletContext sc = getServletContext();
             //sc.log(e.getMessage());
            }
                  }

}

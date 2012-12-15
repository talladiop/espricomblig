/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import FactoryService.FactoryService;
import entites.Departement;
import entites.EnqueteEquipement;
import entites.Enqueteur;
import entites.Cuisson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author souleymane
 */
public class InsertionEnqueteCuisson extends FactoryService {
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


   static final long serialVersionUID = 1L;


	public InsertionEnqueteCuisson()
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
              EnqueteEquipement ct = new EnqueteEquipement();
              //intentiation objet enqueteur
              Enqueteur enq = new Enqueteur();
              //recherche de l'enqueteur
              enq = enqueteurServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("idenqueu")));
                 
            //objet session
            HttpSession session=request.getSession();
            Enqueteur user= (Enqueteur)session.getAttribute("session1administrator");
            
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
		if(!"".equals(request.getParameter("eqp")) && request.getParameter("eqp")!=null
                    && !"".equals(request.getParameter("pda")) && request.getParameter("pda")!=null
                    &&	!"".equals(request.getParameter("pdv")) && request.getParameter("pdv")!=null
		    &&	!"".equals(request.getParameter("qte")) && request.getParameter("qte")!=null
		    
                    )

		 {
                     //recherche 
                     //rercherche departement
                     Departement dp = new Departement();
                     dp= departeServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("iddepartement")));
                    // dp = departeServiceDao.findByPrimaryKey(enq.getDepartement().getIDdepartement());
                                          
                      //rercherche produit
                     Cuisson prod = new Cuisson();
                     prod= cuissonServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("eqp")));
                     
                      //enregistrement du enqueteur
			ct = new EnqueteEquipement(0, prod, dateenregistrer, dp,
                                        dp.getRegion().getNomregion(),
                                         month,
                                         year,
                                        enq, Integer.parseInt(request.getParameter("pda")),
                                        Integer.parseInt(request.getParameter("pdv")),
					Integer.parseInt(request.getParameter("qte")),
                                        
                                        "0");
					
			
                           if(enqueteequipementSrv.creerEnqueteEquipement(ct))
                                     {
                                                                                  
                                       
				    response.sendRedirect("cuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=184469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                     else{
                                       response.sendRedirect("cuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
			}
                else
                {
                  response.sendRedirect("cuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
               }

                }

           catch(Exception e)
           {

              response.sendRedirect("cuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
             ServletContext sc = getServletContext();
             //sc.log(e.getMessage());
            }
                  }

}

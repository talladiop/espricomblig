/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;
import FactoryService.FactoryService;
import entites.Cuisson;
import entites.Departement;
import entites.EnqueteEquipement;
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
public class ModifEnqueteCuisson extends FactoryService
{
   static final long serialVersionUID = 1L;


	public ModifEnqueteCuisson()
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
		if(!"".equals(request.getParameter("pa")) && request.getParameter("pa")!=null
                    && !"".equals(request.getParameter("pv")) && request.getParameter("pv")!=null
                   &&  !"".equals(request.getParameter("qt")) && request.getParameter("qt")!=null
		    
                    )

		 {
                       
                     //rercherche departement
                     Departement dp = new Departement();
                     dp = departeServiceDao.findByPrimaryKey(enq.getDepartement().getIDdepartement());
                     
                     
                      //rercherche produit
                     Cuisson prod = new Cuisson();
                     prod = cuissonServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("cuisson")));
                    
                   
                      //enregistrement du enqueteur
			ct = new EnqueteEquipement();
                        
                        ct.setIdenquete(Integer.parseInt(request.getParameter("idenquetecuisson")));
                        ct.setEquipement(prod);
                        ct.setDateEnquete(dateenregistrer);
                        ct.setDepart(dp);
                         ct.setRegion(request.getParameter("region"));
                        ct.setMois(Integer.parseInt(request.getParameter("mois")));
                        ct.setAnnee(Integer.parseInt(request.getParameter("annee")));
                        ct.setEnqueteur(enq);
                        ct.setPrixAchat(Integer.parseInt(request.getParameter("pa")));
                        ct.setPrixVente(Integer.parseInt(request.getParameter("pv")));
                        ct.setQte(Integer.parseInt(request.getParameter("qt")));
                        ct.setValider("0");
                        ct.setValiderfinale("0");
                                        
				 	
			
                           if(enqueteequipementSrv.modifier(ct))
                                     {
                                                                                   
                                       
				    response.sendRedirect("modif-cuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=184469578&dest65432id5432="+Integer.parseInt(request.getParameter("idenquetecuisson"))+"&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                     else{
                                       response.sendRedirect("modif-cuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&dest65432id5432="+Integer.parseInt(request.getParameter("idenquetecuisson"))+"&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                



			}
                else
                {
                  response.sendRedirect("modif-cuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&dest65432id5432="+Integer.parseInt(request.getParameter("idenquetecuisson"))+"&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
               }

                }
 
           catch(Exception e)
           {

              response.sendRedirect("modif-cuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&dest65432id5432="+Integer.parseInt(request.getParameter("idenquetecuisson"))+"&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
             ServletContext sc = getServletContext();
             //sc.log(e.getMessage());
            }
                  }

}

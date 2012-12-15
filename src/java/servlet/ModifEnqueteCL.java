/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;
import FactoryService.FactoryService;
import entites.Departement;
import entites.EnqueteCl;
import entites.EnqueteGaz;
import entites.Enqueteur;
import entites.ProduitCl;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Talla
 */
public class ModifEnqueteCL extends FactoryService
{
   static final long serialVersionUID = 1L;


	public ModifEnqueteCL()
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
              //intentiation enquetecl
              EnqueteCl ct = new EnqueteCl();
             
              //recherche de l'enqueteur
   Enqueteur enq = enqueteurServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("idenqueteur")));
                 
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
		if(!"".equals(request.getParameter("produitcl")) && request.getParameter("produitcl")!=null
                    && !"".equals(request.getParameter("typecondition")) && request.getParameter("typecondition")!=null
                    &&	!"".equals(request.getParameter("equikgmin")) && request.getParameter("equikgmin")!=null
                    && !"".equals(request.getParameter("equikgmax")) && request.getParameter("equikgmax")!=null
                    && !"".equals(request.getParameter("pg")) && request.getParameter("pg")!=null
                        && !"".equals(request.getParameter("pd")) && request.getParameter("pd")!=null
		    
                    )

		 {
                     
                      
                     //rercherche departement
                   Departement  dp = departeServiceDao.findByPrimaryKey(enq.getDepartement().getIDdepartement());
                     
                     
                      //rercherche produitgaz
                     ProduitCl pr = new ProduitCl();
                     pr = produitclServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("produitcl")));
                      
                    
                      //enregistrement du enquetegaz
			ct = new EnqueteCl();
                        
                        ct.setIdenqueteCl(Integer.parseInt(request.getParameter("idenquete")));
                         ct.setProduitcl(pr);
                        ct.setTypeCond(request.getParameter("typecondition"));
                        ct.setEquivalantKgmin(Integer.parseInt(request.getParameter("equikgmin")));
			ct.setEquivalantKgmax(Integer.parseInt(request.getParameter("equikgmax")));
                        ct.setPrixGros(Integer.parseInt(request.getParameter("pg")));
                        ct.setPrixDetail(Integer.parseInt(request.getParameter("pd")));
		        ct.setDateEnquete(dateenregistrer);
                        ct.setMarchee(request.getParameter("marche"));
                        ct.setEnqueteur(enq);
                        ct.setDepartement(dp);
                        ct.setRegion(request.getParameter("region"));
                        ct.setMois(Integer.parseInt(request.getParameter("mois")));
                        ct.setAnnee(Integer.parseInt(request.getParameter("annee")));
                        ct.setValider("0");
                        ct.setValiderfinale("0");
                                         
					
			
                           if(enqueteclServiceDao.modifier(ct))
                                     {
                                                                                  
                                       
				    response.sendRedirect("modifenqueteCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=184469578&npage=1&dest65432id5432="+Integer.parseInt(request.getParameter("idenquete"))+"&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                     else{
                                       response.sendRedirect("modifenqueteCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&dest65432id5432="+Integer.parseInt(request.getParameter("idenquete"))+"&dggbbf=56-43hcggcvv");
                                    }
                                



			}
                else
                {
                  response.sendRedirect("modifenqueteCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&dest65432id5432="+Integer.parseInt(request.getParameter("idenquete"))+"&65sl-23&dggbbf=56-43hcggcvv");
               }

                }

           catch(Exception e)
           {

              response.sendRedirect("modifenqueteCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&dest65432id5432="+Integer.parseInt(request.getParameter("idenquete"))+"&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
             ServletContext sc = getServletContext();
             //sc.log(e.getMessage());
            }
                  }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;
import DAO.EnqueteEauxForetImpl;
import FactoryService.FactoryService;
import entites.Departement;
import entites.Eauxforet;
import entites.EnqueteEauxforet;
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
public class IsertionEnquetefluxEauxEtForet extends FactoryService
{
   static final long serialVersionUID = 1L;


	public IsertionEnquetefluxEauxEtForet()
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
              //intentiation enqueteeauetforet
              EnqueteEauxforet ct = new EnqueteEauxforet();
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
		if(!"".equals(request.getParameter("produit")) && request.getParameter("produit")!=null
                    && !"".equals(request.getParameter("qte")) && request.getParameter("qte")!=null
                    &&	!"".equals(request.getParameter("datev1")) && request.getParameter("datev1")!=null
		    &&	!"".equals(request.getParameter("qts")) && request.getParameter("qts")!=null
                    && !"".equals(request.getParameter("datev2")) && request.getParameter("datev2")!=null
		    
                    )

		 {
                     //recherche 
                     //rercherche departement
                     Departement dp = new Departement();
                     dp = departeServiceDao.findByPrimaryKey(enq.getDepartement().getIDdepartement());
                     
                     
                      //rercherche eauetforet
                     Eauxforet eau = new Eauxforet();
                     eau = eauetforetServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("ideauforet")));
                   
                     
                     
                      //rercherche produit
                    ProduitCl pr = produitclServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("produit")));
                    
                     
                     
                      //enregistrement du enqueteur
			ct = new EnqueteEauxforet(0,
                                        pr,
                                        Integer.parseInt(request.getParameter("qte")),
					request.getParameter("datev1"),
                                        Integer.parseInt(request.getParameter("qts")),
					request.getParameter("datev2"),
                                        dateenregistrer,
                                        enq,
                                        eau );
					
			
                           if(enqueteEauxForetServiceDao.creerEnqueteAuxForet(ct))
                                     {
                                                                                  
                                       
				    response.sendRedirect("fluxEauEtForetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=184469578&npage=1&iddepart="+Integer.parseInt(request.getParameter("iddepartement"))+"&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                     else{
                                       response.sendRedirect("fluxEauEtForetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&iddepart="+Integer.parseInt(request.getParameter("iddepartement"))+"&dggbbf=56-43hcggcvv");
                                    }
                                



			}
                else
                {
                  response.sendRedirect("fluxEauEtForetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&iddepart="+Integer.parseInt(request.getParameter("iddepartement"))+"&65sl-23&dggbbf=56-43hcggcvv");
               }

                }

           catch(Exception e)
           {

              response.sendRedirect("fluxEauEtForetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&iddepart="+Integer.parseInt(request.getParameter("iddepartement"))+"&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
             ServletContext sc = getServletContext();
             //sc.log(e.getMessage());
            }
                  }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;
import FactoryService.FactoryService;
import entites.Departement;
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
public class InsertionProduitCL extends FactoryService
{
   static final long serialVersionUID = 1L;


	public InsertionProduitCL()
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
              //intentiation produitcl
                    ProduitCl ct = new ProduitCl();
                    
                     //recherche departement
              // Departement dp = new Departement();
            
            //dp = departeServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("departement")));

            
            

           try{
               
               //verification presence et remplacement caractere <<',é,è,ç,...>> dans la chaine de caractere message
                      String descript = request.getParameter("nomprod");
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
                        String nomproduit = co4.replaceAll("Ãª", "ê");
                        
                        
                       
                 //férification des entrées de sisies
		if(!"".equals(request.getParameter("nomprod")) && request.getParameter("nomprod")!=null
                    //&& !"".equals(request.getParameter("typecondition")) && request.getParameter("typecondition")!=null
                    //&&	!"".equals(request.getParameter("ekg")) && request.getParameter("ekg")!=null
		    //&&	!"".equals(request.getParameter("pu")) && request.getParameter("pu")!=null
		     )

		 {
                     
                      //enregistrement du enqueteur
			ct = new ProduitCl(0,nomproduit
					//type,
                                        //ekg,
					//Integer.parseInt(request.getParameter("pu")),
                                        //dp
                                        );

			
                    if(produitclServiceDao.save(ct))
                      {
                                                                                  
                                       
		 response.sendRedirect("produitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=184469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                     }
                       else{
                  response.sendRedirect("produitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
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

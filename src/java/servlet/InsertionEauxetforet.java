/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;
import FactoryService.FactoryService;
import entites.Departement;
import entites.Eauxforet;
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
public class InsertionEauxetforet extends FactoryService
{
   static final long serialVersionUID = 1L;


	public InsertionEauxetforet()
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
              //recherche entreprise et groupe
                    Eauxforet ct = new Eauxforet();
                    //déclaration de l'objet person

            HttpSession session=request.getSession();
            

           try{
               
               //verification presence et remplacement caractere <<',é,è,ç,...>> dans la chaine de caractere message
                      String descript = request.getParameter("nom");
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
                        String nom = co4.replaceAll("Ãª", "ê");
                       
                        

                 //férification des entrées de sisies
		if(!"".equals(request.getParameter("nom")) && request.getParameter("nom")!=null
                    && !"".equals(request.getParameter("tel")) && request.getParameter("tel")!=null
                   
                    )

		 {
                     //rercherche departement
                     Departement dp = new Departement();
                     dp = departeServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("departement")));
                    
                      //enregistrement du enqueteur
			ct = new Eauxforet(0,nom,
                                        request.getParameter("tel"),
                                        dp);

			
                                     if(eauetforetServiceDao.save(ct))
                                     {
                                                                                  
				    response.sendRedirect("eauetforetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=184469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                     else{
                                       response.sendRedirect("eauetforetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                 



			}
                else
                {
                  response.sendRedirect("eauetforetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
               }

                }

           catch(Exception e)
           {

              response.sendRedirect("eauetforetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
             ServletContext sc = getServletContext();
             //sc.log(e.getMessage());
            }
                  }

}

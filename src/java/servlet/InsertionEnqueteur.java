/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;
import FactoryService.FactoryService;
import entites.Departement;
import entites.Enqueteur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Talla
 */
public class InsertionEnqueteur extends FactoryService
{
   static final long serialVersionUID = 1L;


	public InsertionEnqueteur()
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
            
             String descriptd1 = request.getParameter("login");
                       //remplacer "'" par "" dans description
                       String courierd =  descriptd1.replaceAll("'", " ");
                       //remplacement <<é >>
                       String cod1 =  courierd.replaceAll("Ã©", "é");
                       //remplacement <<è >>
                       String co1d1 =  cod1.replaceAll("Ã¨", "è");
                       //remplacement <<ç >>
                       String co2d1 = co1d1.replaceAll("A§", "c");
                        String co3d1 =  co2d1.replaceAll("Ã", "à");
                       //remplacement <<ç >>
                       String co4d1 = co3d1.replaceAll("à§", "ç");
                        String co5d1 = co4d1.replaceAll("Ã´", "ô");
                        String co6d1 = co5d1.replaceAll("Ãª", "ê");
                        String co7d1 = co6d1.replaceAll("à¯", "ï");
                        String log = co7d1.replaceAll("Â", "°");
            
                        
                        String pdescriptd1 = request.getParameter("pwd");
                       //remplacer "'" par "" dans description
                       String pcourierd =  pdescriptd1.replaceAll("'", " ");
                       //remplacement <<é >>
                       String pcod1 =  pcourierd.replaceAll("Ã©", "é");
                       //remplacement <<è >>
                       String pco1d1 =  pcod1.replaceAll("Ã¨", "è");
                       //remplacement <<ç >>
                       String pco2d1 = pco1d1.replaceAll("A§", "c");
                        String pco3d1 =  pco2d1.replaceAll("Ã", "à");
                       //remplacement <<ç >>
                       String pco4d1 = pco3d1.replaceAll("à§", "ç");
                        String pco5d1 = pco4d1.replaceAll("Ã´", "ô");
                        String pco6d1 = pco5d1.replaceAll("Ãª", "ê");
                        String pco7d1 = pco6d1.replaceAll("à¯", "ï");
                        String pasword = pco7d1.replaceAll("Â", "°");
                        
                        
                //validite email
                 boolean emalter = valideremailService.validateEmailAddress(request.getParameter("email"));
           
                        
                        
              //recherche entreprise et groupe
                    Enqueteur ct = new Enqueteur();
                    //déclaration de l'objet person

            HttpSession session=request.getSession();
            
            //recherche meme mot de passe
            Enqueteur eq = new Enqueteur();
            eq.setPwd(pasword);
            
            //recherche dans la liste
             List<Enqueteur> eList1 = (List<Enqueteur>) enqueteurServiceDao.findByValue(eq);
              
              //recherche meme login
            Enqueteur eq1 = new Enqueteur();
             eq1.setLogin(log);
              //recherche dans la liste
             List<Enqueteur> eList12 = (List<Enqueteur>) enqueteurServiceDao.findByValue(eq1);
             
             //recherche meme email
            Enqueteur eq13 = new Enqueteur();
             eq13.setEmail(request.getParameter("email"));
              //recherche dans la liste
             List<Enqueteur> eList123 = (List<Enqueteur>) enqueteurServiceDao.findByValue(eq13);
             
             //recherche meme telephone
            Enqueteur eq134 = new Enqueteur();
             eq134.setTel(request.getParameter("tel"));
              //recherche dans la liste
             List<Enqueteur> eList1234 = (List<Enqueteur>) enqueteurServiceDao.findByValue(eq134);
             
            
            if(eList1.size() > 0 || eList12.size() > 0 || eList123.size() > 0 || eList1234.size() > 0)
            {
             response.sendRedirect("enqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                               
            }
            else
            {       
            
            

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
                        
                        //remplacement <<é,è>> dans nom
                       String ee = request.getParameter("login"); 
                       String eepl =  ee.replaceAll("Ã©", "é");
                       String eepll =  eepl.replaceAll("Ã©", "é");
                       String eeplll = eepll.replaceAll("A§", "ç");
                       String eepllll = eeplll.replaceAll("Ã", "à");
                       String eeplllll =  eepllll.replaceAll("'", " ");
                       String eepllllll = eeplllll.replaceAll("Ã´", "ô");
                       String login = eepllllll.replaceAll("Ãª", "ê");
                       
                        
                        String descriptd = request.getParameter("prenom");
                       //remplacer "'" par "" dans description
                       String courierd1 =  descriptd.replaceAll("'", " ");
                       //remplacement <<é >>
                       String cod =  courierd1.replaceAll("Ã©", "é");
                       //remplacement <<è >>
                       String co1d =  cod.replaceAll("Ã¨", "è");
                       //remplacement <<ç >>
                       String co2d = co1d.replaceAll("A§", "c");
                        String co3d =  co2d.replaceAll("Ã", "à");
                       //remplacement <<ç >>
                       String co4d = co3d.replaceAll("à§", "ç");
                        String co5d = co4d.replaceAll("Ã´", "ô");
                        String co6d = co5d.replaceAll("Ãª", "ê");
                        String co7d = co6d.replaceAll("à¯", "ï");
                        String prenom = co7d.replaceAll("Â", "°");
                        
                        //remplacement <<',é,è>>
                       String cat = request.getParameter("pwd"); 
                       String catt =  cat.replaceAll("'", " ");
                       String cattt =  catt.replaceAll("Ã©", "é");
                       String catttt =  cattt.replaceAll("Ã¨", "è");
                       String cattttt = catttt.replaceAll("A§", "ç");
                       String catttttt = cattttt.replaceAll("Ã´", "ô");
                       String pwd = catttttt.replaceAll("Ãª", "ê");
                       
                        

                 //férification des entrées de sisies
		if(!"".equals(request.getParameter("nom")) && request.getParameter("nom")!=null
                    && !"".equals(request.getParameter("prenom")) && request.getParameter("prenom")!=null
                    &&	!"".equals(request.getParameter("tel")) && request.getParameter("tel")!=null
		    &&	!"".equals(request.getParameter("login")) && request.getParameter("login")!=null
		    && !"".equals(request.getParameter("pwd")) && request.getParameter("pwd")!=null
                        && emalter == true
                    )

		 {
                     //rercherche departement
                     Departement dp = new Departement();
                     dp = departeServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("departement")));
                    
                     
                      //enregistrement du enqueteur
			ct = new Enqueteur(0,nom,
					prenom,
                                        request.getParameter("tel"),
					request.getParameter("email"),
                                        dp,
                                        login,
                                        pwd,
                                       41,
                                        "1"
					 );

			
                           if(enqueteurServiceDao.creerEnqueteur(ct))
                                     {
                                                                                  
                                       
				    response.sendRedirect("enqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=184469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                     else{
                                       response.sendRedirect("enqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
                                    }
                                



			}
                else
                {
                  response.sendRedirect("enqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
               }

                }

           catch(Exception e)
           {

              response.sendRedirect("enqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?admoneth23984outputofficeceadmin=04469578&npage=1&clt345id65deter34=65&65sl-23&dggbbf=56-43hcggcvv");
             ServletContext sc = getServletContext();
             //sc.log(e.getMessage());
            }
           
           
        }
                  }

}

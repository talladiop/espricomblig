package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FactoryService.FactoryService;
import entites.Cuisson;
import entites.Departement;
import entites.Enqueteur;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;


 public class ModifCuisson extends FactoryService
 {
   static final long serialVersionUID = 1L;


	public ModifCuisson() {
		super();
	}


	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {

                
                //intentiation session
                 HttpSession session=request.getSession();
                 //enqueteur
                 Enqueteur eq = new Enqueteur();
                 
                //intentiation produit
                 Cuisson pr = new Cuisson();

                 //recuperation session
                 eq=(Enqueteur)session.getAttribute("session1administrator");
                 
                 
                 Departement dp = null;
                 
       try {

    if(!"".equals(request.getParameter("nomprod")) && request.getParameter("nomprod")!=null
      //&& !"".equals(request.getParameter("pa")) && request.getParameter("pa")!=null
       //&& !"".equals(request.getParameter("pv")) && request.getParameter("pv")!=null
        
          )
       {
                 
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
                                             
                       
                        
                        pr.setIdCuisson(Integer.parseInt(request.getParameter("idequishhhhshs")));
                        pr.setNomCuisson(nomproduit);
                       // pr.setPrixAchat(Integer.parseInt(request.getParameter("pa")));
                        //pr.setPrixVente(Integer.parseInt(request.getParameter("pv")));
                        
                           
                    //id du departemment 
                 //dp = departeServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("departement")));
                 // pr.setDepartement(dp);
                       
                       
                        
                        
                       // Enregistrement
                       if("Mod".equalsIgnoreCase(request.getParameter("cmd")))
                                {
                                    if( cuissonServiceDao.update(pr))
                                     {
				     response.sendRedirect("modifcuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=9876543rez3211&dest65432id5432="+Integer.parseInt(request.getParameter("idequishhhhshs"))+"&dgggdgd=76&dhhd=63ds");
                                     
                                    }else{
                                         response.sendRedirect("modifcuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+Integer.parseInt(request.getParameter("idequishhhhshs"))+"&dxggd=54fds");
                                         }
                                 }
}
    else
    {
     response.sendRedirect("modifcuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+Integer.parseInt(request.getParameter("idequishhhhshs"))+"&dxggd=54fds");
    }
   
     }
catch(Exception e)  {

    response.sendRedirect("modifcuissoncdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?=087654gfr4329&dest65432id5432="+Integer.parseInt(request.getParameter("idequishhhhshs"))+"&dxggd=54fds");
     ServletContext sc = getServletContext();
     //sc.log(e.getMessage());
                        }



	}
}
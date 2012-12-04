package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FactoryService.FactoryService;
import entites.AutorisationTonnagecl;
import entites.Departement;
import entites.Enqueteur;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;


 public class ModifAutorisationTonnage extends FactoryService
 {
   static final long serialVersionUID = 1L;


	public ModifAutorisationTonnage() {
		super();
	}


	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {


                 AutorisationTonnagecl ea = null;
                 Departement dp = null;
                 HttpSession session=request.getSession();
                 Enqueteur entre=new Enqueteur();

                 //recherch entreprise
                 entre=(Enqueteur)session.getAttribute("session1administrator");
                 //int identre= entre.getIdEntrep();
                 
                 //id du departemment 
                 dp = departeServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("departement")));
try {

    if(!"".equals(request.getParameter("qt")) && request.getParameter("qt")!=null )
      
       {
                 
                        ea = new AutorisationTonnagecl();
                         
                        ea.setIdAuttonnage(Integer.parseInt(request.getParameter("idautorisat")));
                        ea.setQt(Integer.parseInt(request.getParameter("qt")));
                        ea.setAnneeAut(Integer.parseInt(request.getParameter("anneaut")));
                        ea.setDepartement(dp);
// Enregistrement
                       if("Mod".equalsIgnoreCase(request.getParameter("cmd")))
                                {
                                    //gp.setIdGroupe(Integer.parseInt(request.getParameter("idgg8765groppe")));
                                     if( autorisationtonnageServiceDao.modifier(ea))
                                     {
				     response.sendRedirect("modifautorisationtonnagecdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=9876543rez3211&dest65432id5432="+ea.getIdAuttonnage()+"&dgggdgd=76&dhhd=63ds");
                                     
                                    }else{
                                        response.sendRedirect("modifautorisationtonnagecdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+ea.getIdAuttonnage()+"&dggd=65");
                                    }
                                 }
}
    else
    {
    response.sendRedirect("modifautorisationtonnagecdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+ea.getIdAuttonnage()+"&cgggc=432g");
    }
   
     }
catch(Exception e)  {

    response.sendRedirect("modifautorisationtonnagecdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+ea.getIdAuttonnage()+"&dxggd=54fds");
     ServletContext sc = getServletContext();
     //sc.log(e.getMessage());
                        }



	}
}
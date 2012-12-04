package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FactoryService.FactoryService;
import entites.Departement;
import entites.Eauxforet;
import entites.Enqueteur;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;


 public class ModifEauForet extends FactoryService
 {
   static final long serialVersionUID = 1L;


	public ModifEauForet() {
		super();
	}


	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {


                 Eauxforet ea = null;
                 Departement dp = null;
                 HttpSession session=request.getSession();
                 Enqueteur entre=new Enqueteur();

                 //recherch entreprise
                 entre=(Enqueteur)session.getAttribute("session1administrator");
                 //int identre= entre.getIdEntrep();
                 
                 //id du departemment 
                 dp = departeServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("departement")));
try {

    if(!"".equals(request.getParameter("nom")) && request.getParameter("nom")!=null
       && !"".equals(request.getParameter("tel")) && request.getParameter("tel")!=null)
       {
                 
                      //verification caractere
                      String nname = request.getParameter("nom");
                       String nommpr1 =  nname.replaceAll("'", " ");
                       //remplacement <<é >>
                       String nommpr2 =  nommpr1.replaceAll("Ã©", "é");
                       //remplacement <<è >>
                       String nommpr3 =  nommpr2.replaceAll("Ã¨", "è");
                       //remplacement <<ç >>
                       String nommpr4 = nommpr3.replaceAll("A§", "c");
                        String nommpr5 =  nommpr4.replaceAll("Ã", "à");
                       //remplacement <<ç >>
                       String nommpr6 = nommpr5.replaceAll("à§", "ç");
                        String nommpr7 = nommpr6.replaceAll("Ã´", "ô");
                        String nommpr8 = nommpr7.replaceAll("à¢", "â");
                        String nom = nommpr8.replaceAll("Ãª", "ê");
           
           
          /* ea = new Eauxforet(Integer.parseInt(request.getParameter("idgg8765greua")),
                                        nom,
                                      request.getParameter("tel"),
					dp
					);
           * 
           */
                        ea = new Eauxforet();
                        ea.setIdEauxforet(Integer.parseInt(request.getParameter("idgg8765greua")));
                        ea.setNomPoste(nom);
                        ea.setTel(request.getParameter("tel"));
                        ea.setDepartement(dp);
// Enregistrement
                       if("Mod".equalsIgnoreCase(request.getParameter("cmd")))
                                {
                                    //gp.setIdGroupe(Integer.parseInt(request.getParameter("idgg8765groppe")));
                                     if( eauetforetServiceDao.update(ea))
                                     {
				     response.sendRedirect("modifiereauetforetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=9876543rez3211&dest65432id5432="+ea.getIdEauxforet()+"&dgggdgd=76&dhhd=63ds");
                                     
                                    }else{
                                        response.sendRedirect("modifiereauetforetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+ea.getIdEauxforet()+"&dggd=65");
                                    }
                                 }
}
    else
    {
    response.sendRedirect("modifiereauetforetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+ea.getIdEauxforet()+"&cgggc=432g");
    }
   
     }
catch(Exception e)  {

    response.sendRedirect("modifiereauetforetcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+ea.getIdEauxforet()+"&dxggd=54fds");
     ServletContext sc = getServletContext();
     //sc.log(e.getMessage());
                        }



	}
}
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FactoryService.FactoryService;
import entites.Departement;
import entites.Enqueteur;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;


 public class ModifEnqueteur extends FactoryService
 {
   static final long serialVersionUID = 1L;


	public ModifEnqueteur() {
		super();
	}


	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {

                
                 Departement dp = null;
                 HttpSession session=request.getSession();
                 Enqueteur entre=new Enqueteur();
                 Enqueteur eq = new Enqueteur();

                 //recherch entreprise
                 entre=(Enqueteur)session.getAttribute("session1administrator");
                 //int identre= entre.getIdEntrep();
                 
                 //id du departemment 
                 dp = departeServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("departement")));
                 
                 //id de l'enqueteur
                 eq = enqueteurServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("equetbbwggww")));
                 
try {

    if(!"".equals(request.getParameter("nom")) && request.getParameter("nom")!=null
      && !"".equals(request.getParameter("prenom")) && request.getParameter("prenom")!=null
       && !"".equals(request.getParameter("tel")) && request.getParameter("tel")!=null
        && !"".equals(request.getParameter("login")) && request.getParameter("login")!=null
         && !"".equals(request.getParameter("pwd")) && request.getParameter("pwd")!=null )
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
           
                         //verification caractere
                      String nnamep = request.getParameter("prenom");
                       String nommpr1p =  nnamep.replaceAll("'", " ");
                       //remplacement <<é >>
                       String nommpr2p =  nommpr1p.replaceAll("Ã©", "é");
                       //remplacement <<è >>
                       String nommpr3p =  nommpr2p.replaceAll("Ã¨", "è");
                       //remplacement <<ç >>
                       String nommpr4p = nommpr3p.replaceAll("A§", "c");
                        String nommpr5p =  nommpr4p.replaceAll("Ã", "à");
                       //remplacement <<ç >>
                       String nommpr6p = nommpr5p.replaceAll("à§", "ç");
                        String nommpr7p = nommpr6p.replaceAll("Ã´", "ô");
                        String nommpr8p = nommpr7p.replaceAll("à¢", "â");
                        String name = nommpr8p.replaceAll("Ãª", "ê");
           
                        
                         //verification caractere
                      String nnamel = request.getParameter("login");
                       String nommpr1l =  nnamel.replaceAll("'", " ");
                       //remplacement <<é >>
                       String nommpr2l =  nommpr1l.replaceAll("Ã©", "é");
                       //remplacement <<è >>
                       String nommpr3l =  nommpr2l.replaceAll("Ã¨", "è");
                       //remplacement <<ç >>
                       String nommpr4l = nommpr3l.replaceAll("A§", "c");
                        String nommpr5l =  nommpr4l.replaceAll("Ã", "à");
                       //remplacement <<ç >>
                       String nommpr6l = nommpr5l.replaceAll("à§", "ç");
                        String nommpr7l = nommpr6l.replaceAll("Ã´", "ô");
                        String nommpr8l = nommpr7l.replaceAll("à¢", "â");
                        String login = nommpr8l.replaceAll("Ãª", "ê");
                        
                        
                         //verification caractere
                      String nnamew = request.getParameter("pwd");
                       String nommpr1w =  nnamew.replaceAll("'", " ");
                       //remplacement <<é >>
                       String nommpr2w =  nommpr1w.replaceAll("Ã©", "é");
                       //remplacement <<è >>
                       String nommpr3w =  nommpr2w.replaceAll("Ã¨", "è");
                       //remplacement <<ç >>
                       String nommpr4w = nommpr3w.replaceAll("A§", "c");
                        String nommpr5w =  nommpr4w.replaceAll("Ã", "à");
                       //remplacement <<ç >>
                       String nommpr6w = nommpr5w.replaceAll("à§", "ç");
                        String nommpr7w = nommpr6w.replaceAll("Ã´", "ô");
                        String nommpr8w = nommpr7w.replaceAll("à¢", "â");
                        String pwd = nommpr8w.replaceAll("Ãª", "ê");
          /* ea = new Eauxforet(Integer.parseInt(request.getParameter("idgg8765greua")),
                                        nom,
                                      request.getParameter("tel"),
					dp
					);
           * 
           */
                        eq = new Enqueteur();
                        
                        eq.setIdenqueteur(Integer.parseInt(request.getParameter("equetbbwggww")));
                        eq.setNomenqueteur(nom);
                        eq.setPrenomenqueteur(name);
                        eq.setTel(request.getParameter("tel"));
                        eq.setEmail(request.getParameter("email"));
                        eq.setDepartement(dp);
                        eq.setLogin(login);
                        eq.setPwd(pwd);
                        eq.setProfile(Integer.parseInt(request.getParameter("profilddedede")));
                        eq.setEtatcompte(request.getParameter("stat"));
                        
// Enregistrement
                       if("Mod".equalsIgnoreCase(request.getParameter("cmd")))
                                {
                                    //gp.setIdGroupe(Integer.parseInt(request.getParameter("idgg8765groppe")));
                                     if( enqueteurServiceDao.modifier(eq))
                                     {
				     response.sendRedirect("modifenqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=9876543rez3211&dest65432id5432="+eq.getIdenqueteur()+"&dgggdgd=76&dhhd=63ds");
                                     
                                    }else{
                                        response.sendRedirect("modifenqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+eq.getIdenqueteur()+"&dggd=65");
                                    }
                                 }
}
    else
    {
    response.sendRedirect("modifenqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+eq.getIdenqueteur()+"&cgggc=432g");
    }
   
     }
catch(Exception e)  {

    response.sendRedirect("modifenqueteurcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+eq.getIdenqueteur()+"&dxggd=54fds");
     ServletContext sc = getServletContext();
     //sc.log(e.getMessage());
                        }



	}
}
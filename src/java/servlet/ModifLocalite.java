package servlet;

import FactoryService.FactoryService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entites.Departement;
import entites.Localite;
import entites.Enqueteur;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;



 public class ModifLocalite extends  FactoryService{
   static final long serialVersionUID = 1L;


	public ModifLocalite() {
		super();
	}


	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {


                 Localite lc = null;
                 HttpSession session=request.getSession();
                 Enqueteur us=new Enqueteur();
                 
                 //recherche departement
                 Departement  dp = new Departement();
                 
                 dp = departeServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("departement")));
                

                 //recherch entreprise
                 us=(Enqueteur)session.getAttribute("session1administrator");
                 
try {

    if(!"".equals(request.getParameter("nomlocal")) && request.getParameter("nomlocal")!=null )
       {
                 
                      //verification caractere
                      String nname = request.getParameter("nomlocal");
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
           
                        
                        //specification departemet a modifier
                        lc = new Localite();
                        lc.setIdLocalite(Integer.parseInt(request.getParameter("idlocaloruhg")));
                        lc.setNomLocalite(nom);
                        lc.setDepartement(dp);
           
                       // Enregistrement
                       if("Mod".equalsIgnoreCase(request.getParameter("cmd")))
                                {
                                   // lc.setIdGroupe(Integer.parseInt(request.getParameter("idgg8765groppe")));
                                     if( localiteServiceDao.modifier(lc))
                                     {
				     response.sendRedirect("modificationlocaliteq654hwxhvhvhvxshvhv65432908766cdxbhdbvchjdvchjdvchjdvchdvchdvghdvchdcdcvdxghvdghxdx43987654scxshjchjvhjvhjvhjvc.jsp?admondjkfkgggh23987hyiceadmin=14469768&fhhgf=76&dsffyefyeff="+lc.getIdLocalite()+"&dhhf=76");
                                    }else{
                                         
                                        response.sendRedirect("modificationlocaliteq654hwxhvhvhvxshvhv65432908766cdxbhdbvchjdvchjdvchjdvchdvchdvghdvchdcdcvdxghvdghxdx43987654scxshjchjvhjvhjvhjvc.jsp?admondjkfkgggh23987hyiceadmin=04469768&fhhgf=76&dsffyefyeff="+lc.getIdLocalite()+"&dhhf=76");
                                    }
                                 }
}
    else
    {
    response.sendRedirect("modificationlocaliteq654hwxhvhvhvxshvhv65432908766cdxbhdbvchjdvchjdvchjdvchdvchdvghdvchdcdcvdxghvdghxdx43987654scxshjchjvhjvhjvhjvc.jsp?admondjkfkgggh23987hyiceadmin=04469768&fhhgf=76&dsffyefyeff="+lc.getIdLocalite()+"&dhhf=73");
    }
   
     }
catch(Exception e)  {

    response.sendRedirect("modificationlocaliteq654hwxhvhvhvxshvhv65432908766cdxbhdbvchjdvchjdvchjdvchdvchdvghdvchdcdcvdxghvdghxdx43987654scxshjchjvhjvhjvhjvc.jsp?admondjkfkgggh23987hyiceadmin=04469768&fhhgf=76&dsffyefyeff="+lc.getIdLocalite()+"&dhhf=72");
     ServletContext sc = getServletContext();
     //sc.log(e.getMessage());
                        }



	}
}
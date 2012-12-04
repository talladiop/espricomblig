/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import FactoryService.FactoryService;
import entites.Enqueteur;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Talla
 */

public class LoginAdminRegion extends FactoryService
{

   static final long serialVersionUID = 1L;
    String password;
    String p;

   
	public LoginAdminRegion() {
		super();
	}

	
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
                  doPost(request,response);
	}


	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            ServletContext sc = getServletContext();

try {

    if ((!"".equals(request.getParameter("login")) && request.getParameter("login")!=null)
	&&(!"".equals(request.getParameter("pwd")) && request.getParameter("pwd")!=null))

                       {
                             String login=request.getParameter("login");

                              if(request.getParameter("pwd").equalsIgnoreCase("toto 'OR' 1 '=' 1"))
                             {
                             response.sendRedirect("locale.jsp?admondjkfkgggh23987hyofficeadmin=0446978&dhzghdvhvhdf=665433hgffggffgfg&schscdhvgghdc=654bgfddddcf");
                                     password = null;
                             p = password;
                             }
                             else
                             {
                              password=request.getParameter("pwd");

            
                   //intentiation objet users
                   Enqueteur e = new Enqueteur();
                   //recherche de l'objet
                   e.setLogin(request.getParameter("login"));
                   e.setPwd(password);                
                   e.setProfile(127);
                     //recherche dans la liste
                       List<Enqueteur> eList = (List<Enqueteur>) enqueteurServiceDao.findByValue(e);
                            if (eList.size()>0) 
                            {
                              e = eList.get(0);
                              if(e.getEtatcompte().equalsIgnoreCase("1")){
                               HttpSession  session = request.getSession(true);
                               session.setAttribute("session1administratorregion", e);

                               //sc.log("Succes tentative de login de "+e.getLogin()+"/"+e.getPwd());
                               response.sendRedirect("administrateur-region-workspace654333vncvfbvfjvfvfvjfvffjkfrgrggh87654nvfjfvjfvjfhjffvfvjffg1.jsp?admoneth23987hyofficeadmin=176430943");
                                }else{
                                    response.sendRedirect("locale.jsp?admondjkfkgggh23987hyofficeadmin=0446978&dhzghdvhvhdf=665433hgffggffgfg&schscdhvgghdc=654bgfddddcf");
                                }


                            }else{
                             response.sendRedirect("locale.jsp?admondjkfkgggh23987hyofficeadmin=0446978&dhzghdvhvhdf=665433hgffggffgfg&schscdhvgghdc=654bgfddddcf");
                               //sc.log("Echec tentative de login de"+login+"/"+password);
                            }



        }} else {
         response.sendRedirect("locale.jsp?admondjkfkgggh23987hyofficeadmin=0446978&dhzghdvhvhdf=665433hgffggffgfg&schscdhvgghdc=654bgfddddcf");
      }

} catch(Exception es)
{
     response.sendRedirect("locale.jsp?admondjkfkgggh23987hyofficeadmin=0446978&dhzghdvhvhdf=665433hgffggffgfg&schscdhvgghdc=654bgfddddcf");

    //sc.log(es.getMessage());

  }
 }
}

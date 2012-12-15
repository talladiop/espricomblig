 package  servlet;



import FactoryService.FactoryService;
import entites.Enqueteur;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;


 public class LogOutAdmin extends FactoryService
 {
   static final long serialVersionUID = 1L;


	public LogOutAdmin() {
		super();
	}


	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	          Enqueteur ent = null;
                  ServletContext sc = getServletContext();

try {


                               HttpSession  session = request.getSession();
                               session.invalidate();
                             
                               response.sendRedirect("administrateur.jsp");


} catch(Exception e)
{
     
     response.sendRedirect("administrateur.jsp");

    //sc.log(e.getMessage());

  }
 }
}
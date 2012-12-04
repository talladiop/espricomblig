/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;
import FactoryService.FactoryService;
import entites.Departement;
import entites.Localite;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Talla
 */
public class InsertionLocalite extends FactoryService
{
   static final long serialVersionUID = 1L;


	public InsertionLocalite()
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
                 //declaration departement et localite
                Localite lc = null;
                Departement dp = new Departement();
            
            dp = departeServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("departement")));


           try{

		if(!"".equals(request.getParameter("nomlocal")) && request.getParameter("nomlocal")!=null )
		 {
                   
                     //traitement caractere du nom du departement
                     String descript = request.getParameter("nomlocal");
                       //remplacer "'" par "" dans description
                       String courier =  descript.replaceAll("'", " ");
                       //remplacement <<é >>
                       String co =  courier.replaceAll("Ã©", "é");
                       //remplacement <<è >>
                       String co1 =  co.replaceAll("Ã¨", "è");
                       //remplacement <<ç >>
                       String co2 = co1.replaceAll("A§", "c");
                        String co3 =  co2.replaceAll("Ã", "à");
                       //remplacement <<ç >>
                       String co4 = co3.replaceAll("à§", "ç");
                        String co5 = co4.replaceAll("Ã´", "ô");
                        String nomdp = co5.replaceAll("Ãª", "ê");
                     
                     
                                  //enregistrement groupe
                                   lc = new Localite(0,nomdp, dp );

				if("En".equalsIgnoreCase(request.getParameter("cmd")))
                                {

                                     if(localiteServiceDao.creerLocalite(lc))
                                     {
				    response.sendRedirect("localiteq654hwxhvhvhvxshvhv65432908766cdxbhdbvchjdvchjdvchjdvchdvchdvghdvchdcdcvdxghvdghxdx43987654scxshjchjvhjvhjvhjvc.jsp?erty234b5688=1hy654jo987compte4032&npage=1&dggfgg=54&dgggf=65&departement="+dp.getIDdepartement()+"&dhggfff=76&gfhhfjfgbfgf=76&fggf=654dfrrd");
                                    }else{
                                        response.sendRedirect("localiteq654hwxhvhvhvxshvhv65432908766cdxbhdbvchjdvchjdvchjdvchdvchdvghdvchdcdcvdxghvdghxdx43987654scxshjchjvhjvhjvhjvc.jsp?erty234b5688=1765reza32&npage=1&dggfgg=54&dgggf=6325&departement="+dp.getIDdepartement()+"&dhggfff=76&gfhhfjfgbfgf=76&fggf=654dfrrd");
                                    }
                                 }

				                           

            }
                else
                {
                response.sendRedirect("localiteq654hwxhvhvhvxshvhv65432908766cdxbhdbvchjdvchjdvchjdvchdvchdvghdvchdcdcvdxghvdghxdx43987654scxshjchjvhjvhjvhjvc.jsp?erty234b5688=1765reza32&npage=1&dggfgg=54&dgggf=6985&departement="+dp.getIDdepartement()+"&dhggfff=76&gfhhfjfgbfgf=76&fggf=654dfrrd");
                }

           }
           catch(Exception e)
           {

              response.sendRedirect("localiteq654hwxhvhvhvxshvhv65432908766cdxbhdbvchjdvchjdvchjdvchdvchdvghdvchdcdcvdxghvdghxdx43987654scxshjchjvhjvhjvhjvc.jsp?erty234b5688=1765reza32&npage=1&dggfgg=54&dgggf=68&departement="+dp.getIDdepartement()+"&dhggfff=76&gfhhfjfgbfgf=76&fggf=654dfrrd");
             ServletContext sc = getServletContext();
             sc.log(e.getMessage());
            }
                  }

}

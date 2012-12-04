package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FactoryService.FactoryService;
import entites.Departement;
import entites.Enqueteur;
import entites.ProduitCl;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;


 public class ModifProduitCL extends FactoryService
 {
   static final long serialVersionUID = 1L;


	public ModifProduitCL() {
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
                 ProduitCl pr = new ProduitCl();

                 //recuperation session
                 eq=(Enqueteur)session.getAttribute("session1administrator");
                 
                 //intentiation departement
                  Departement dp = new Departement();
       try {

    if(!"".equals(request.getParameter("nomprod")) && request.getParameter("nomprod")!=null
      //&& !"".equals(request.getParameter("typecondition")) && request.getParameter("typecondition")!=null
       //&& !"".equals(request.getParameter("ekg")) && request.getParameter("ekg")!=null
       // && !"".equals(request.getParameter("pu")) && request.getParameter("pu")!=null
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
                        
                  /*      //remplacement <<é,è>> dans nom
                       String ee = request.getParameter("typecondition"); 
                       String eepl =  ee.replaceAll("Ã©", "é");
                       String eepll =  eepl.replaceAll("Ã©", "é");
                       String eeplll = eepll.replaceAll("A§", "ç");
                       String eepllll = eeplll.replaceAll("Ã", "à");
                       String eeplllll =  eepllll.replaceAll("'", " ");
                       String eepllllll = eeplllll.replaceAll("Ã´", "ô");
                       String type = eepllllll.replaceAll("Ãª", "ê");
                       
                        
                        String descriptd = request.getParameter("ekg");
                       //remplacer "'" par "" dans description
                       String courierd =  descriptd.replaceAll("'", " ");
                       //remplacement <<é >>
                       String cod =  courierd.replaceAll("Ã©", "é");
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
                        String ekg = co7d.replaceAll("Â", "°");
          /* ea = new Eauxforet(Integer.parseInt(request.getParameter("idgg8765greua")),
                                        nom,
                                      request.getParameter("tel"),
					dp
					);
           * 
           */
                        
                        
                        pr.setIdProduitcl(Integer.parseInt(request.getParameter("idprodsnxscxhcds")));
                        pr.setNomProduitcl(nomproduit);
                       // pr.setTypeCondition(type);
                        //pr.setUnitemesure(ekg);
                        //pr.setPrixunitaire(Integer.parseInt(request.getParameter("pu")));
                        
                         //id du departemment 
                       // dp = departeServiceDao.findByPrimaryKey(Integer.parseInt(request.getParameter("departement")));
                       // pr.setDepartement(dp);
                       
                        
                        
                       // Enregistrement
                       if("Mod".equalsIgnoreCase(request.getParameter("cmd")))
                                {
                                    //gp.setIdGroupe(Integer.parseInt(request.getParameter("idgg8765groppe")));
                                     if( produitclServiceDao.update(pr))
                                     {
				     response.sendRedirect("modifproduitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=9876543rez3211&dest65432id5432="+Integer.parseInt(request.getParameter("idprodsnxscxhcds"))+"&dgggdgd=76&dhhd=63ds");
                                     
                                    }else{
                                         response.sendRedirect("modifproduitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+Integer.parseInt(request.getParameter("idprodsnxscxhcds"))+"&dxggd=54fds");
                                         }
                                 }
}
    else
    {
     response.sendRedirect("modifproduitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+Integer.parseInt(request.getParameter("idprodsnxscxhcds"))+"&dxggd=54fds");
    }
   
     }
catch(Exception e)  {

    response.sendRedirect("modifproduitCLcdscdehfeoihfirhgiorhgiorhgirhgirhiehirfe765fehrhfrighrighrighuihruighrughuihgrfg5432scsfdefgedfgeigfgfefe.jsp?mod39876ytre54320jhg543=087654gfr4329&dest65432id5432="+Integer.parseInt(request.getParameter("idprodsnxscxhcds"))+"&dxggd=54fds");
     ServletContext sc = getServletContext();
     //sc.log(e.getMessage());
                        }



	}
}
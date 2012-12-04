/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;



import DAO.AutorisationTonnageDaoImpl;
import DAO.CuissonDaoImpl;
import DAO.DeparteDaoImpl;
import DAO.Eauetforet;
import DAO.EnqueteCLDaoImpl;
import DAO.EnqueteEauxForetImpl;
import DAO.EnqueteEquipementImpl;
import DAO.EnqueteGazDaoImpl;
import DAO.EnqueteurDaoImpl;
import DAO.InventaireGazDaoImpl;
import DAO.LocaliteDaoImpl;
import DAO.ProduitCLDaoImpl;
import DAO.ProduitGazDaoImpl;
import DAO.RegionDaoImpl;
import DAO.ValiderEmail;


/**
 *
 * @author Talla
 */
public class FactoryD 
{
          protected DeparteDaoImpl departeDao= DeparteDaoImpl.getInstance();   
          protected RegionDaoImpl regionDao= RegionDaoImpl.getInstance();
          protected LocaliteDaoImpl localiteDao= LocaliteDaoImpl.getInstance();
          protected EnqueteurDaoImpl enqueteurDao= EnqueteurDaoImpl.getInstance();
          protected Eauetforet eauetforetDao= Eauetforet.getInstance();
          protected ProduitCLDaoImpl produitclDao= ProduitCLDaoImpl.getInstance();
          protected ProduitGazDaoImpl produitgazDao= ProduitGazDaoImpl.getInstance();
          protected CuissonDaoImpl cuissonDao= CuissonDaoImpl.getInstance();
          protected EnqueteEauxForetImpl enqueteeauforetDao= EnqueteEauxForetImpl.getInstance();
           protected EnqueteGazDaoImpl enquetegazDao= EnqueteGazDaoImpl.getInstance();
            protected InventaireGazDaoImpl inventairegazDao= InventaireGazDaoImpl.getInstance();
             protected AutorisationTonnageDaoImpl autorisationtonnageDao= AutorisationTonnageDaoImpl.getInstance();
              protected EnqueteCLDaoImpl enqueteclDao= EnqueteCLDaoImpl.getInstance();
              protected ValiderEmail valideremailDao= ValiderEmail.getInstance();
               protected EnqueteEquipementImpl enqueteequipementDao= EnqueteEquipementImpl.getInstance();
    
}

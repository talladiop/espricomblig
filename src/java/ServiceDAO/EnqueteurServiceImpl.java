/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;


import Factory.FactoryD;
import InterfaceService.IEnqueteurService;
import entites.Enqueteur;
import java.util.List;

/**
 *
 * @author Cherif
 */
public class EnqueteurServiceImpl extends FactoryD implements IEnqueteurService{


    	private static EnqueteurServiceImpl instance;
        
    private EnqueteurServiceImpl()
    {
    }
    /**
		 * @return the instance
		 */
		public static EnqueteurServiceImpl getInstance() {
			if(instance==null){
				instance = new EnqueteurServiceImpl();
			}
			return instance;
		}


    public synchronized boolean creerEnqueteur(Enqueteur enqueteur) {
      Enqueteur eqARechercher = new Enqueteur();
			eqARechercher.setNomenqueteur(enqueteur.getNomenqueteur());
                        eqARechercher.setPrenomenqueteur(enqueteur.getPrenomenqueteur());
                        eqARechercher.setTel(enqueteur.getTel());
                        eqARechercher.setDepartement(enqueteur.getDepartement());

			List<Enqueteur> eqList = enqueteurDao.findByValue(eqARechercher);
			return (eqList!=null && !eqList.isEmpty())?false:enqueteurDao.save(enqueteur);
    }

    public synchronized void saveListEnqueteur(List<Enqueteur> enqueteur) 
    {
       for(Enqueteur eq : enqueteur)
       {
		creerEnqueteur(eq);
       }
    }

    public synchronized boolean modifier(Enqueteur enqueteur) {
         Enqueteur eqARechercher = new Enqueteur();
         
        eqARechercher.setIdenqueteur(enqueteur.getIdenqueteur());
        eqARechercher.setNomenqueteur(enqueteur.getNomenqueteur());
        eqARechercher.setPrenomenqueteur(enqueteur.getPrenomenqueteur());
        eqARechercher.setTel(enqueteur.getTel());
        eqARechercher.setEmail(enqueteur.getEmail());
        eqARechercher.setDepartement(enqueteur.getDepartement());

			List<Enqueteur> eqList = enqueteurDao.findByValue(eqARechercher);
			return (eqList!=null && !eqList.isEmpty())?false:enqueteurDao.update(enqueteur);
    }

    public synchronized boolean supprimer(Enqueteur enqueteur) {
        return enqueteurDao.delete(enqueteur);
    }

    public synchronized Enqueteur findByPrimaryKey(int pk)
    {
         return enqueteurDao.findByPrimaryKey(pk);
    }


    public synchronized List<Enqueteur> findAll() {
         return enqueteurDao.findAll();
    }

    public synchronized List<Enqueteur> findByValue(Enqueteur enqueteur) {
         return enqueteurDao.findByValue(enqueteur);
    }

    public synchronized boolean activer(int pk) 
    {
        return enqueteurDao.activer(pk);
    }

    public synchronized boolean desactiver(int pk) 
    {
        return enqueteurDao.activer(pk);
    }
      
     

}

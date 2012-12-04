/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;


import Factory.FactoryD;
import InterfaceService.IEnqueteEauxForetService;
import entites.EnqueteEauxforet;
import java.util.List;

/**
 *
 * @author Cherif
 */
public class EnqueteEauxForetServiceImpl extends FactoryD implements IEnqueteEauxForetService{


    	private static EnqueteEauxForetServiceImpl instance;
        
    private EnqueteEauxForetServiceImpl()
    {
    }
    /**
		 * @return the instance
		 */
		public static EnqueteEauxForetServiceImpl getInstance() {
			if(instance==null){
				instance = new EnqueteEauxForetServiceImpl();
			}
			return instance;
		}


    public synchronized boolean creerEnqueteAuxForet(EnqueteEauxforet eq) 
    {
      EnqueteEauxforet eqARechercher = new EnqueteEauxforet();
      
			eqARechercher.setQtEntrer(eq.getQtEntrer());
                        eqARechercher.setDateEntrer(eq.getDateEntrer());
                        eqARechercher.setQtSortie(eq.getQtSortie());
                        eqARechercher.setDateSortie(eq.getDateSortie());
                        eqARechercher.setEnqueteur(eq.getEnqueteur());

			List<EnqueteEauxforet> eqList = enqueteeauforetDao.findByValue(eqARechercher);
			return (eqList!=null && !eqList.isEmpty())?false:enqueteeauforetDao.save(eq);
    }

    public synchronized void saveListEnqueteur(List<EnqueteEauxforet> enqueteur) 
    {
       for(EnqueteEauxforet eq : enqueteur)
       {
		creerEnqueteAuxForet(eq);
       }
    }

    public synchronized boolean modifier(EnqueteEauxforet eq) {
         return enqueteeauforetDao.update(eq);
    }

    public synchronized boolean supprimer(EnqueteEauxforet eq) {
        return enqueteeauforetDao.delete(eq);
    }

    public synchronized EnqueteEauxforet findByPrimaryKey(int pk)
    {
         return enqueteeauforetDao.findByPrimaryKey(pk);
    }


    public synchronized List<EnqueteEauxforet> findAll() {
         return enqueteeauforetDao.findAll();
    }

    public synchronized List<EnqueteEauxforet> findByValue(EnqueteEauxforet eq) {
         return enqueteeauforetDao.findByValue(eq);
    }

    public boolean ValiderEnquete(int pk) {
        return enqueteeauforetDao.ValiderEnquete(pk);
    }

    
      
     

}

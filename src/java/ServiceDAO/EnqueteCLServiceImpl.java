/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;


import Factory.FactoryD;
import InterfaceService.IEnqueteCLService;
import entites.EnqueteCl;
import java.util.List;

/**
 *
 * @author Cherif
 */
public class EnqueteCLServiceImpl extends FactoryD implements IEnqueteCLService{


    	private static EnqueteCLServiceImpl instance;
        
    private EnqueteCLServiceImpl()
    {
    }
    /**
		 * @return the instance
		 */
		public static EnqueteCLServiceImpl getInstance() {
			if(instance==null){
				instance = new EnqueteCLServiceImpl();
			}
			return instance;
		}


    public synchronized boolean creerEnqueteCL(EnqueteCl enqueteur) {
                         EnqueteCl eqARechercher = new EnqueteCl();
                         
			eqARechercher.setProduitcl(enqueteur.getProduitcl());
                        eqARechercher.setTypeCond(enqueteur.getTypeCond());
                        eqARechercher.setEquivalantKgmin(enqueteur.getEquivalantKgmin());
                        eqARechercher.setEquivalantKgmax(enqueteur.getEquivalantKgmax());
                        eqARechercher.setPrixGros(enqueteur.getPrixGros());
                        eqARechercher.setPrixDetail(enqueteur.getPrixDetail());
                        eqARechercher.setDateEnquete(enqueteur.getDateEnquete());
                        eqARechercher.setMarchee(enqueteur.getMarchee());
                        eqARechercher.setEnqueteur(enqueteur.getEnqueteur());
                        eqARechercher.setDepartement(enqueteur.getDepartement());

			List<EnqueteCl> eqList = enqueteclDao.findByValue(eqARechercher);
			return (eqList!=null && !eqList.isEmpty())?false:enqueteclDao.save(enqueteur);
    }

    public synchronized void saveListEnqueteCL(List<EnqueteCl> enqueteur) 
    {
       for(EnqueteCl eq : enqueteur)
       {
		creerEnqueteCL(eq);
       }
    }

    public synchronized boolean modifier(EnqueteCl enqueteur) {
        return enqueteclDao.update(enqueteur);
    }

    public synchronized boolean supprimer(EnqueteCl enqueteur) {
        return enqueteclDao.delete(enqueteur);
    }

    public synchronized EnqueteCl findByPrimaryKey(int pk)
    {
         return enqueteclDao.findByPrimaryKey(pk);
    }


    public synchronized List<EnqueteCl> findAll() {
         return enqueteclDao.findAll();
    }

    public synchronized List<EnqueteCl> findByValue(EnqueteCl enqueteur) {
         return enqueteclDao.findByValue(enqueteur);
    }

    public synchronized boolean Valider(int pk) 
    {
        return enqueteclDao.Valider(pk);
    }

    public boolean ValiderFinale(int pk) 
    {
        return enqueteclDao.ValiderFinale(pk);
    }

   
    }

   
     



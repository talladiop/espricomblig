/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;


import Factory.FactoryD;
import InterfaceService.IInventaireGazService;
import entites.InventairestGaz;
import java.util.List;

/**
 *
 * @author Cherif
 */
public class InventaireServiceImpl extends FactoryD implements IInventaireGazService{


    	private static InventaireServiceImpl instance;
        
    private InventaireServiceImpl()
    {
    }
    /**
		 * @return the instance
		 */
		public static InventaireServiceImpl getInstance() {
			if(instance==null){
				instance = new InventaireServiceImpl();
			}
			return instance;
		}


    public synchronized boolean creer(InventairestGaz inv) 
    {
                          InventairestGaz in = new InventairestGaz();
			
                       in.setQt(inv.getQt());
                       in.setProduitgaz(inv.getProduitgaz());
                        in.setDateEnr(inv.getDateEnr());
                        in.setDepartement(inv.getDepartement());

			List<InventairestGaz> eqList = inventairegazDao.findByValue(in);
			return (eqList!=null && !eqList.isEmpty())?false:inventairegazDao.save(inv);
    }

    

    public synchronized boolean modifier(InventairestGaz inv) {
  
        return inventairegazDao.update(inv);
    }

    public synchronized boolean supprimer(InventairestGaz inv) {
        return inventairegazDao.delete(inv);
    }

    public synchronized InventairestGaz findByPrimaryKey(int pk)
    {
         return inventairegazDao.findByPrimaryKey(pk);
    }


    public synchronized List<InventairestGaz> findAll() {
         return inventairegazDao.findAll();
    }

    public synchronized List<InventairestGaz> findByValue(InventairestGaz inve) {
         return inventairegazDao.findByValue(inve);
    }

    public boolean Valider(int pk) {
        return inventairegazDao.Valider(pk);
    }

    public boolean ValiderFinale(int pk) {
        return inventairegazDao.ValiderFinale(pk);
    }

  
     

}

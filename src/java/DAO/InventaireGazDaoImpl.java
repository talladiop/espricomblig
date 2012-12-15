/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;



import InterfaceDao.IInventaireGaz;
import entites.Departement;
import entites.Enqueteur;
import entites.InventairestGaz;
import entites.ProduitGaz;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class InventaireGazDaoImpl extends AbstractDao implements IInventaireGaz
{
  private static InventaireGazDaoImpl instance;


	private InventaireGazDaoImpl(){}

	/**
	 * @return the instance
	 */

	public static InventaireGazDaoImpl getInstance() {
		if(instance==null){
			instance = new InventaireGazDaoImpl();
		}
			return instance;
		}


	public List<InventairestGaz> findAll() {
		return findByValue(new InventairestGaz());
	}

	private List<InventairestGaz> populate(ResultSet rs) 
        {
            //intentiation de departement, enqueteur, produitgaz
            DeparteDaoImpl dpDao=DeparteDaoImpl.getInstance();
            ProduitGazDaoImpl progazDao=ProduitGazDaoImpl.getInstance();
            EnqueteurDaoImpl enqDao=EnqueteurDaoImpl.getInstance();
            
		List<InventairestGaz> enqList = new ArrayList<InventairestGaz>();
		if (rs!=null) {
			try {
				while (rs.next()) {
					InventairestGaz eq = new InventairestGaz();
                                        
					eq.setIdEnventairegaz(Integer.parseInt(rs.getString("id_enventairegaz")));
                                        
					 ProduitGaz prodt = progazDao.findByPrimaryKey(Integer.parseInt(rs.getString("id_produit")));    
                                        eq.setProduitgaz(prodt);
                                       
					eq.setQt(Integer.parseInt(rs.getString("qt")));
                                        eq.setDateEnr(rs.getString("date_enr"));
                                        
                                        Enqueteur enqet = enqDao.findByPrimaryKey(Integer.parseInt(rs.getString("id_enqueteur")));    
                                        eq.setEnqueteur(enqet);
                                       
                                       
                                        Departement dpart = dpDao.findByPrimaryKey(Integer.parseInt(rs.getString("IDdepartement")));        
                                        eq.setDepartement(dpart);
                                        
                                         eq.setRegion(rs.getString("region"));
                                         
                                          eq.setMois(Integer.parseInt(rs.getString("mois")));
                                          
                                           eq.setAnnee(Integer.parseInt(rs.getString("annee")));
                                        
                                       eq.setValider(rs.getString("valider"));
                                       
                                       eq.setValiderfinale(rs.getString("validerfinale"));
                                         
                                        
					enqList.add(eq);
				}
				close(rs);
				close(conx);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return enqList;
	}


	public InventairestGaz findByPrimaryKey(int pk) {
		InventairestGaz eq = new InventairestGaz();
		eq.setIdEnventairegaz(pk);
		List<InventairestGaz> eqList = findByValue(eq);
		return (eqList!=null && !eqList.isEmpty()
				&& eqList.size()==1 )?eqList.get(0):null;
	}


	public List<InventairestGaz> findByValue(InventairestGaz iv) {
		sb = new StringBuffer("SELECT * FROM inventairest_gaz");
		try {

			if(iv.getIdEnventairegaz()!=0){
				sb.append(" AND id_enventairegaz =")
				.append(iv.getIdEnventairegaz())
                                .append("");
			}
			if(iv.getProduitgaz()!=null && !"".equals(iv.getProduitgaz()))
                        {
				sb.append(" AND id_produit =")
				.append(iv.getProduitgaz().getIdProduitgaz())
				.append("");
			}

                        if(iv.getQt() != 0){
				sb.append(" AND qt =")
				.append(iv.getQt())
				.append("");
			}
                        if(iv.getDateEnr()!=null && !"".equals(iv.getDateEnr())){
				sb.append(" AND date_enr ='")
				.append(iv.getDateEnr())
                                .append("'");
			}
                        if(iv.getEnqueteur()!=null && !"".equals(iv.getEnqueteur())){
				sb.append(" AND id_enqueteur =")
				.append(iv.getEnqueteur().getIdenqueteur())
                                 .append("");
			}
                        if(iv.getDepartement()!=null && !"".equals(iv.getDepartement())){
				sb.append(" AND IDdepartement =")
				.append(iv.getDepartement().getIDdepartement())
                                 .append("");
			}
                         if(iv.getRegion()!=null && !"".equals(iv.getRegion())){
				sb.append(" AND region ='")
				.append(iv.getRegion())
				.append("'");
			}
                           if(iv.getMois()!=0 && !"".equals(iv.getMois())){
				sb.append(" AND mois =")
				.append(iv.getMois())
				.append("");
			}
                            if(iv.getAnnee()!=0 && !"".equals(iv.getAnnee())){
				sb.append(" AND annee =")
				.append(iv.getAnnee())
				.append("");
			}
                        if(iv.getValider()!=null && !"".equals(iv.getValider())){
				sb.append(" AND valider ='")
				.append(iv.getValider())
                                 .append("'");
			}
                         if(iv.getValiderfinale()!=null && !"".equals(iv.getValiderfinale())){
				sb.append(" AND validerfinale ='")
				.append(iv.getValiderfinale())
                                 .append("'");
			}
                             
                        
                                      
			String requete = sb.toString().replaceFirst("AND", "WHERE");
			ResultSet rs = createStatement().executeQuery(requete);
			return populate(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conx);
		return null;
	}


	 @Override
    public synchronized boolean save(InventairestGaz ea)
    {
         sb = new StringBuffer();
		sb.append("INSERT INTO inventairest_gaz (id_produit, qt, date_enr, id_enqueteur, "
                        + "IDdepartement, region, mois, annee, valider)")

                        .append("VALUES(").append(ea.getProduitgaz().getIdProduitgaz()).append(", ")
                        .append("").append(ea.getQt()).append(", ")
                        .append("'").append(ea.getDateEnr()).append("', ")
                        .append("").append(ea.getEnqueteur().getIdenqueteur()).append(", ")
                        .append("").append(ea.getDepartement().getIDdepartement()).append(", ")
                        .append("'").append(ea.getRegion()).append("', ")
                        .append("").append(ea.getMois()).append(", ")
                        .append("").append(ea.getAnnee()).append(", ")
                        .append("'").append(ea.getValider()).append("') ");
                       

                     	try {
                    //System.out.println(sb);
			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
         
         
         
         
	 @Override
    public synchronized boolean update(InventairestGaz pr)
    {
        sb = new StringBuffer();
	sb.append("UPDATE inventairest_gaz ")
                        .append("SET id_enventairegaz").append("=").append(pr.getIdEnventairegaz())
			.append(", id_produit").append("=").append(pr.getProduitgaz().getIdProduitgaz())
			.append(", qt").append("=").append(pr.getQt())
			.append(", date_enr").append("='").append(pr.getDateEnr())
			.append("', id_enqueteur").append("=").append(pr.getEnqueteur().getIdenqueteur())
                        .append(", IDdepartement").append("=").append(pr.getDepartement().getIDdepartement())
                        .append(", region").append("='").append(pr.getRegion())
                
                        .append("', mois").append("=").append(pr.getMois())
                
                        .append(", annee").append("=").append(pr.getAnnee())
                        .append(", valider").append("='").append(pr.getValider())
                        .append("', validerfinale").append("='").append(pr.getValiderfinale())
                

			.append("'  WHERE id_enventairegaz").append("=").append(pr.getIdEnventairegaz()).append("");
		try {
			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e)
                {
			e.printStackTrace();
		}
		return false;
    }


         
         
	public boolean delete(InventairestGaz inv) {
		sb = new StringBuffer();
		sb.append("DELETE FROM inventairest_gaz")
			.append("WHERE id_enventairegaz =").append(inv.getIdEnventairegaz()).append("");
		try {
			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

        
         //activation et desactivation de l'enqueteur
        
   public synchronized boolean Valider(int pk) {
		sb = new StringBuffer();
		sb.append("UPDATE inventairest_gaz ")
			.append("SET valider").append("='1'")
			.append("  WHERE id_enventairegaz ").append("=").append(pk);
		try {

			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


   //activation et desactivation de l'enqueteur
        
   public synchronized boolean ValiderFinale(int pk) {
		sb = new StringBuffer();
		sb.append("UPDATE inventairest_gaz ")
			.append("SET validerfinale").append("='1'")
			.append("  WHERE id_enventairegaz ").append("=").append(pk);
		try {

			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

     
   
}

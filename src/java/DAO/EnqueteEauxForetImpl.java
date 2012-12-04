/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import InterfaceDao.IEnqueteEauForetDao;
import entites.Eauxforet;
import entites.EnqueteEauxforet;
import entites.Enqueteur;
import entites.ProduitCl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class EnqueteEauxForetImpl extends AbstractDao implements IEnqueteEauForetDao
{
  private static EnqueteEauxForetImpl instance;


	private EnqueteEauxForetImpl(){}

	/**
	 * @return the instance
	 */

	public static EnqueteEauxForetImpl getInstance() {
		if(instance==null){
			instance = new EnqueteEauxForetImpl();
		}
			return instance;
		}


	public List<EnqueteEauxforet> findAll() {
		return findByValue(new EnqueteEauxforet());
	}

	private List<EnqueteEauxforet> populate(ResultSet rs) 
        {
            //intentiation departement
            Eauetforet eauxfor = Eauetforet.getInstance();
            //intentiation enqueteur
            EnqueteurDaoImpl eqDao = EnqueteurDaoImpl.getInstance();
            
             //intentiation produitcl
            ProduitCLDaoImpl prodcl = ProduitCLDaoImpl.getInstance();
            
		List<EnqueteEauxforet> enqList = new ArrayList<EnqueteEauxforet>();
		if (rs!=null) {
			try {
				while (rs.next()) {
					EnqueteEauxforet eq = new EnqueteEauxforet();
                                        
					eq.setIdEnqueteEf(Integer.parseInt(rs.getString("id_enquete_ef")));
                                        
                                         ProduitCl prcl = prodcl.findByPrimaryKey(Integer.parseInt(rs.getString("id_produitcl")));    
                                        eq.setProduitcl(prcl);
                                        
                                       
					eq.setQtEntrer(Integer.parseInt(rs.getString("qt_entrer")));
					eq.setDateEntrer(rs.getString("date_entrer"));
                                        eq.setQtSortie(Integer.parseInt(rs.getString("qt_sortie")));
                                        eq.setDateSortie(rs.getString("date_sortie"));
                                        eq.setDateEnr(rs.getString("date_enr"));
                                        
                                        
					
                                        Enqueteur enquet = eqDao.findByPrimaryKey(Integer.parseInt(rs.getString("id_enqueteur"))); 
                                        
                                        eq.setEnqueteur(enquet);
                                                                                
                                        Eauxforet eauxfore = eauxfor.findByPrimaryKey(Integer.parseInt(rs.getString("id_eauxforet")));    
                                        eq.setEauxforet(eauxfore);
                                        
                                        eq.setValider(rs.getString("valider"));
                                       // eq.setActivation(rs.getString("activation"));
                                         
                                        
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


	public EnqueteEauxforet findByPrimaryKey(int pk) {
		EnqueteEauxforet eq = new EnqueteEauxforet();
		eq.setIdEnqueteEf(pk);
		List<EnqueteEauxforet> eqList = findByValue(eq);
		return (eqList!=null && !eqList.isEmpty()
				&& eqList.size()==1 )?eqList.get(0):null;
	}

        
        

	public List<EnqueteEauxforet> findByValue(EnqueteEauxforet eq) {
		sb = new StringBuffer("SELECT * FROM enquete_eauxforet");
		try {

			if(eq.getIdEnqueteEf()!=0){
				sb.append(" AND id_enquete_ef =")
				.append(eq.getIdEnqueteEf());
			}
                        
                        if(eq.getProduitcl() !=null && !"".equals(eq.getProduitcl()))
                        {
				sb.append(" AND id_produitcl =")
				.append(eq.getProduitcl().getIdProduitcl())
				.append("");
			}
                        
			if(eq.getQtEntrer()>0 && !"".equals(eq.getQtEntrer()))
                        {
				sb.append(" AND qt_entrer =")
				.append(eq.getQtEntrer())
				.append("");
			}

                        if(eq.getDateEntrer()!=null && !"".equals(eq.getDateEntrer())){
				sb.append(" AND date_entrer ='")
				.append(eq.getDateEntrer())
				.append("'");
			}
                        if(eq.getQtSortie()>0 && !"".equals(eq.getQtSortie())){
				sb.append(" AND qt_sortie =")
				.append(eq.getQtSortie())
                                .append("");
			}
                        if(eq.getDateSortie()!=null && !"".equals(eq.getDateSortie())){
				sb.append(" AND date_sortie ='")
				.append(eq.getDateSortie())
                                 .append("'");
			}
                        if(eq.getDateEnr()!=null && !"".equals(eq.getDateEnr())){
				sb.append(" AND date_enr ='")
				.append(eq.getDateEnr())
                                 .append("'");
			}
                             if(eq.getEnqueteur()!=null && !"".equals(eq.getEnqueteur())){
				sb.append(" AND id_enqueteur =")
				.append(eq.getEnqueteur().getIdenqueteur())
                                 .append("");
			}
                             if(eq.getEauxforet()!=null && !"".equals(eq.getEauxforet())){
				sb.append(" AND id_eauxforet =")
				.append(eq.getEauxforet().getIdEauxforet())
                                 .append("");
			}
                             
                             if(eq.getValider()!=null && !"".equals(eq.getValider())){
				sb.append(" AND valider ='")
				.append(eq.getValider())
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
    public synchronized boolean save(EnqueteEauxforet eq)
    {
        sb = new StringBuffer();
  sb.append("INSERT INTO enquete_eauxforet (id_produitcl, qt_entrer, date_entrer, qt_sortie, "
          + "date_sortie, date_enr, id_enqueteur, id_eauxforet)")

                        .append("VALUES(").append(eq.getProduitcl().getIdProduitcl()).append(", ")
                        .append("").append(eq.getQtEntrer()).append(", ")
			.append("'").append(eq.getDateEntrer()).append("', ")
                        .append("").append(eq.getQtSortie()).append(", ")
                        .append("'").append(eq.getDateSortie()).append("', ")
                        .append("'").append(eq.getDateEnr()).append("', ")
                        .append("").append(eq.getEnqueteur().getIdenqueteur()).append(", ")
                        .append("").append(eq.getEauxforet().getIdEauxforet()).append(") ");
                        
                

                        
		try {
                   // System.out.println(sb);
			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }

	 @Override
    public synchronized boolean update(EnqueteEauxforet eqt)
    {
        sb = new StringBuffer();
	sb.append("UPDATE enquete_eauxforet ")
                        .append("SET id_enquete_ef").append("=").append(eqt.getIdEnqueteEf())
                        .append(", id_produitcl").append("=").append(eqt.getProduitcl().getIdProduitcl())
			.append(", qt_entrer").append("=").append(eqt.getQtEntrer())
                        .append(", date_entrer").append("='").append(eqt.getDateEntrer())
			.append("', qt_sortie").append("=").append(eqt.getQtSortie())
                        .append(", date_sortie").append("='").append(eqt.getDateSortie())
                .append("', date_enr").append("='").append(eqt.getDateEnr())
                .append("', id_enqueteur").append("=").append(eqt.getEnqueteur().getIdenqueteur())
                .append(", id_eauxforet").append("=").append(eqt.getEauxforet().getIdEauxforet())
                 .append(", valider").append("='").append(eqt.getValider())
                        
                	.append("'  WHERE id_enquete_ef").append("=").append(eqt.getIdEnqueteEf()).append("");
        
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

	public boolean delete(EnqueteEauxforet eq) {
		sb = new StringBuffer();
		sb.append("DELETE FROM enquete_eauxforet ")
			.append("WHERE id_enquete_ef =").append(eq.getIdEnqueteEf()).append("");
		try {
			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

        
        //validation de l'enqueteur
        
  public synchronized boolean ValiderEnquete(int pk) {
		sb = new StringBuffer();
		sb.append("UPDATE enquete_eauxforet ")
			.append("SET valider").append("='1'")
			.append("  WHERE id_enquete_ef  ").append("=").append(pk);
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

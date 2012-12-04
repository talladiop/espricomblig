/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;



import InterfaceDao.IEnqueteGazDao;
import entites.Departement;
import entites.EnqueteGaz;
import entites.Enqueteur;
import entites.ProduitGaz;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Talla
 */
public class EnqueteGazDaoImpl extends AbstractDao implements IEnqueteGazDao
{
    //declaration de l'instence de la class
    private static EnqueteGazDaoImpl instance;

        //constructeur de la class
	private EnqueteGazDaoImpl(){}

	/**
	 * @return the instance
	 */

        //creation de l'instence
	public synchronized static EnqueteGazDaoImpl getInstance()
        {
		if(instance==null)
                {
			instance = new EnqueteGazDaoImpl();
		}
			return instance;
		}

        
        @Override
    public synchronized boolean update(EnqueteGaz pr)
    {
        sb = new StringBuffer();
	sb.append("UPDATE enquete_gaz ")
                        .append("SET id_enquete_gaz").append("=").append(pr.getIdEnqueteGaz())
			.append(", id_produitgaz").append("=").append(pr.getProduitgaz().getIdProduitgaz())
			.append(", prix_cu_gros").append("=").append(pr.getPrixCuGros())
			.append(", prix_cu_detail").append("=").append(pr.getPrixCuDetail())
			.append(", prix_peri_gros").append("=").append(pr.getPrixPeriGros())
                        .append(", prix_peri_detail").append("=").append(pr.getPrixPeriDetail())
                        .append(", date_enquete").append("='").append(pr.getDateEnquete())
                        .append("', id_enqueteur").append("=").append(pr.getEnqueteur().getIdenqueteur())
                
                
                .append(", IDdepartement").append("=").append(pr.getDepartement().getIDdepartement())
                        
                .append(", valider").append("='").append(pr.getValider())
                
                .append("', validerfinale").append("='").append(pr.getValiderfinale())

			.append("'  WHERE id_enquete_gaz").append("=").append(pr.getIdEnqueteGaz()).append("");
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


        @Override
    public synchronized boolean save(EnqueteGaz pr)
    {
        sb = new StringBuffer();
		sb.append("INSERT INTO enquete_gaz (id_produitgaz, prix_cu_gros, prix_cu_detail, prix_peri_gros, "
                        + "prix_peri_detail, date_enquete, id_enqueteur, IDdepartement)")

                        .append("VALUES(").append(pr.getProduitgaz().getIdProduitgaz()).append(", ")
			.append("").append(pr.getPrixCuGros()).append(", ")
			.append("").append(pr.getPrixCuDetail()).append(", ")
			.append("").append(pr.getPrixPeriGros()).append(", ")
                        .append("").append(pr.getPrixPeriDetail()).append(", ")
                        .append("'").append(pr.getDateEnquete()).append("', ")
                .append("").append(pr.getEnqueteur().getIdenqueteur()).append(", ")
                 .append("").append(pr.getDepartement().getIDdepartement()).append(") ");
			

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
    public synchronized boolean delete(EnqueteGaz pr) {
        sb = new StringBuffer();
        System.out.println(sb);
		sb.append("DELETE FROM enquete_gaz ")
			.append("WHERE id_enquete_gaz =").append(pr.getIdEnqueteGaz()).append("");
		try {
			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }

        @Override
    public synchronized EnqueteGaz findByPrimaryKey(int pk)
    {
        EnqueteGaz pr = new EnqueteGaz();
		pr.setIdEnqueteGaz(pk);
		List<EnqueteGaz> prList = findByValue(pr);
		return (prList!=null && !prList.isEmpty()
		&& prList.size()==1 )?prList.get(0):null;
    }

        @Override
    public synchronized List<EnqueteGaz> findAll()
    {
        return findByValue(new EnqueteGaz());
    }

        
    private synchronized List<EnqueteGaz> populate(ResultSet rs)
    {

        //intentiation enqueteur
        EnqueteurDaoImpl dpDao=EnqueteurDaoImpl.getInstance();
         //intentiation produitgaz
        ProduitGazDaoImpl pdgazDao=ProduitGazDaoImpl.getInstance();
        
        //intentiation departement
        DeparteDaoImpl departDao=DeparteDaoImpl.getInstance();
        
		List<EnqueteGaz> enqList = new ArrayList<EnqueteGaz>();
		if (rs!=null) {
			try {
				while (rs.next()) {

					EnqueteGaz pr = new EnqueteGaz();

					pr.setIdEnqueteGaz(Integer.parseInt(rs.getString("id_enquete_gaz")));

                                        ProduitGaz pg = pdgazDao.findByPrimaryKey(Integer.parseInt(rs.getString("id_produitgaz")));                                 
					
					pr.setProduitgaz(pg);
                                        
                                         pr.setPrixCuGros(Integer.parseInt(rs.getString("prix_cu_gros")));
					pr.setPrixCuDetail(Integer.parseInt(rs.getString("prix_cu_detail")));
					pr.setPrixPeriGros(Integer.parseInt(rs.getString("prix_peri_gros")));
                                        pr.setPrixPeriDetail(Integer.parseInt(rs.getString("prix_peri_detail")));
                                        pr.setDateEnquete(rs.getString("date_enquete"));
                                        
                                        Enqueteur enq = dpDao.findByPrimaryKey(Integer.parseInt(rs.getString("id_enqueteur")));                                 
					
					pr.setEnqueteur(enq);
                                        				
                                         Departement dpart = departDao.findByPrimaryKey(Integer.parseInt(rs.getString("IDdepartement"))); 
                                        
                                        pr.setDepartement(dpart);
                                        
                                        pr.setValider(rs.getString("valider"));
                                        
                                        pr.setValiderfinale(rs.getString("validerfinale"));

					enqList.add(pr);
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




    @Override
    public synchronized List<EnqueteGaz>findByValue(EnqueteGaz pr)
    {
        sb = new StringBuffer("SELECT * FROM enquete_gaz");
		try {

			if(pr.getIdEnqueteGaz()!=0){
				sb.append(" AND id_enquete_gaz =")
				.append(pr.getIdEnqueteGaz());
			}
                         if(pr.getProduitgaz()!=null && !"".equals(pr.getProduitgaz()) ){
				sb.append(" AND id_produitgaz =")
				.append(pr.getProduitgaz().getIdProduitgaz())
				.append("");
			}
			if(pr.getPrixCuGros()!=0 && !"".equals(pr.getPrixCuGros() >0)){
				sb.append(" AND prix_cu_gros =")
				.append(pr.getPrixCuGros())
				.append("");
			}
			if(pr.getPrixCuDetail()!=0 && !"".equals(pr.getPrixCuDetail() >0)){
				sb.append(" AND prix_cu_detail =")
				.append(pr.getPrixCuDetail())
				.append("");
			}
			if(pr.getPrixPeriGros()!=0 && !"".equals(pr.getPrixPeriGros() >0)){
				sb.append(" AND prix_peri_gros =")
				.append(pr.getPrixPeriGros())
				.append("");
			}
                        if(pr.getPrixPeriDetail()!=0 && !"".equals(pr.getPrixPeriDetail() >0)){
				sb.append(" AND prix_peri_detail =")
				.append(pr.getPrixPeriDetail())
				.append("");
			}
                        if(pr.getDateEnquete()!=null && !"".equals(pr.getDateEnquete())){
				sb.append(" AND date_enquete ='")
				.append(pr.getDateEnquete())
				.append("'");
			}
                         if(pr.getEnqueteur()!=null && !"".equals(pr.getEnqueteur())){
				sb.append(" AND id_enqueteur =")
				.append(pr.getEnqueteur().getIdenqueteur())
				.append("");
			}
			
                         if(pr.getDepartement()!=null && !"".equals(pr.getDepartement())){
				sb.append(" AND IDdepartement =")
				.append(pr.getDepartement().getIDdepartement())
				.append("");
			}
                         if(pr.getValider()!=null && !"".equals(pr.getValider())){
				sb.append(" AND valider ='")
				.append(pr.getValider())
				.append("'");
			}
                         
                          if(pr.getValiderfinale()!=null && !"".equals(pr.getValiderfinale())){
				sb.append(" AND validerfinale ='")
				.append(pr.getValiderfinale())
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


     //Validation de l'enquete niveau regional
        
   public synchronized boolean ValiderEnquete(int pk) {
		sb = new StringBuffer();
		sb.append("UPDATE enquete_gaz ")
			.append("SET valider").append("='1'")
			.append("  WHERE id_enquete_gaz ").append("=").append(pk);
		try {

			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
   
    //Validation de l'enquete niveau centrale
        
   public synchronized boolean ValiderEnqueteFinale(int pk) {
		sb = new StringBuffer();
		sb.append("UPDATE enquete_gaz ")
			.append("SET validerfinale").append("='1'")
			.append("  WHERE id_enquete_gaz ").append("=").append(pk);
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

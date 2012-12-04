/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;



;
import InterfaceDao.IDifferencePrixDao;
import entites.Departement;
import entites.Diferenceprix;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import InterfaceDao.IDifferencePrixDao;
import entites.Departement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;






public class DifferencePrix extends AbstractDao implements IDifferencePrixDao
{
    //declaration de l'instence de la class
    private static DifferencePrix instance;

        //constructeur de la class
	private DifferencePrix(){}

	/**
	 * @return the instance
	 */

        //creation de l'instence
	public synchronized static DifferencePrix getInstance()
        {
		if(instance==null)
                {
			instance = new DifferencePrix();
		}
			return instance;
		}

        
        
        
        @Override
    public synchronized boolean update(Diferenceprix pr)
    {
        sb = new StringBuffer();
	sb.append("UPDATE diferenceprix ")
                        .append("SET id_difference").append("=").append(pr.getIdDifference())
			.append(", id_produit").append("=").append(pr.getIdProduit())
			.append(", type_produit").append("='").append(pr.getTypeProduit())
			.append("', diference").append("=").append(pr.getDiference())
			.append(", mois").append("=").append(pr.getMois())
                        .append(", annee").append("=").append(pr.getAnnee())
                        .append(", IDdepartement").append("=").append(pr.getDepartement().getIDdepartement())
                        .append(", etat").append("=").append(pr.getEtat())
                
              

			.append("  WHERE id_difference").append("=").append(pr.getIdDifference()).append("");
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
    public synchronized boolean save(Diferenceprix pr)
    {
        sb = new StringBuffer();
		sb.append("INSERT INTO diferenceprix (id_produit, type_produit, diference, mois, "
                        + "annee, IDdepartement, etat)")

                        .append("VALUES(").append(pr.getIdProduit()).append(", ")
			.append("'").append(pr.getTypeProduit()).append("', ")
			.append("").append(pr.getDiference()).append(", ")
			.append("").append(pr.getMois()).append(", ")
                        .append("").append(pr.getAnnee()).append(", ")
                        .append("").append(pr.getDepartement().getIDdepartement()).append(", ")
                        .append("").append(pr.getEtat()).append(") ");
                 
			

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
    public synchronized boolean delete(Diferenceprix pr) {
        sb = new StringBuffer();
        System.out.println(sb);
		sb.append("DELETE FROM diferenceprix ")
			.append("WHERE id_difference =").append(pr.getIdDifference()).append("");
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
    public synchronized Diferenceprix findByPrimaryKey(int pk)
    {
        Diferenceprix pr = new Diferenceprix();
		pr.setIdDifference(pk);
		List<Diferenceprix> prList = findByValue(pr);
		return (prList!=null && !prList.isEmpty()
		&& prList.size()==1 )?prList.get(0):null;
    }

        @Override
    public synchronized List<Diferenceprix> findAll()
    {
        return findByValue(new Diferenceprix());
    }

        
    private synchronized List<Diferenceprix> populate(ResultSet rs)
    {

        
        
        //intentiation departement
        DeparteDaoImpl departDao=DeparteDaoImpl.getInstance();
        
		List<Diferenceprix> enqList = new ArrayList<Diferenceprix>();
		if (rs!=null) {
			try {
				while (rs.next()) {

					Diferenceprix pr = new Diferenceprix();

					pr.setIdDifference(Integer.parseInt(rs.getString("id_difference")));
                                 
					
					pr.setIdProduit(Integer.parseInt(rs.getString("id_produit")));
                                        
                                         pr.setTypeProduit(rs.getString("type_produit"));
                                         
                                         pr.setDiference(Integer.parseInt(rs.getString("diference")));
					pr.setMois(Integer.parseInt(rs.getString("mois")));
					pr.setAnnee(Integer.parseInt(rs.getString("annee")));
                                       			
                                         Departement dpart = departDao.findByPrimaryKey(Integer.parseInt(rs.getString("IDdepartement"))); 
                                        
                                        pr.setDepartement(dpart);
                                        
                                        pr.setEtat(Integer.parseInt(rs.getString("etat")));
                                        
                                       

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
    public synchronized List<Diferenceprix>findByValue(Diferenceprix pr)
    {
        sb = new StringBuffer("SELECT * FROM diferenceprix");
		try {

			if(pr.getIdDifference()!=0){
				sb.append(" AND id_difference =")
				.append(pr.getIdDifference());
			}
                         if(pr.getProduitgaz()!=null && !"".equals(pr.getProduitgaz()) ){
				sb.append(" AND id_produit =")
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


    //activer de l'etat
        
   public synchronized boolean ActiverEtat(int pk) {
		sb = new StringBuffer();
		sb.append("UPDATE diferenceprix ")
			.append("SET etat").append("='1'")
			.append("  WHERE id_difference ").append("=").append(pk);
		try {

			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

   
       
   public synchronized boolean DesactiverEtat(int pk) {
		sb = new StringBuffer();
		sb.append("UPDATE diferenceprix ")
			.append("SET etat").append("='0'")
			.append("  WHERE id_difference ").append("=").append(pk);
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

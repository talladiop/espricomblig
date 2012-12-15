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
                         if(pr.getIdProduit()>=0 && !"".equals(pr.getIdProduit()) ){
				sb.append(" AND id_produit =")
				.append(pr.getIdProduit())
				.append("");
			}
			if(pr.getTypeProduit() != null && !"".equals(pr.getTypeProduit())){
				sb.append(" AND type_produit ='")
				.append(pr.getTypeProduit())
				.append("'");
			}
			if(pr.getDiference()>=0 && !"".equals(pr.getDiference())){
				sb.append(" AND diference =")
				.append(pr.getDiference())
				.append("");
			}
			if(pr.getMois()>=0 && !"".equals(pr.getMois())){
				sb.append(" AND mois =")
				.append(pr.getMois())
				.append("");
			}
                        if(pr.getAnnee()>=0 && !"".equals(pr.getAnnee())){
				sb.append(" AND annee =")
				.append(pr.getAnnee())
				.append("");
			}
                        if(pr.getDepartement()!=null && !"".equals(pr.getDepartement())){
				sb.append(" AND IDdepartement =")
				.append(pr.getDepartement().getIDdepartement())
				.append("");
			}
                         if(pr.getEtat() >=0 && !"".equals(pr.getEtat())){
				sb.append(" AND etat =")
				.append(pr.getEtat())
				.append("");
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

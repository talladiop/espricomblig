/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import InterfaceDao.IProduitGazDao;
import entites.Departement;
import entites.ProduitGaz;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Talla
 */
public class ProduitGazDaoImpl extends AbstractDao implements IProduitGazDao
{
    //declaration de l'instence de la class
    private static ProduitGazDaoImpl instance;

        //constructeur de la class
	private ProduitGazDaoImpl(){}

	/**
	 * @return the instance
	 */

        //creation de l'instence
	public synchronized static ProduitGazDaoImpl getInstance()
        {
		if(instance==null)
                {
			instance = new ProduitGazDaoImpl();
		}
			return instance;
		}

        
        @Override
    public synchronized boolean update(ProduitGaz pr)
    {
        sb = new StringBuffer();
	sb.append("UPDATE produit_gaz ")
                        .append("SET id_produitgaz").append("=").append(pr.getIdProduitgaz())
			.append(", nom_produitgaz").append("='").append(pr.getNomProduitgaz())
			
                //.append("', IDdepartement").append("=").append(pr.getDepartement().getIDdepartement())
                        

			.append("'  WHERE id_produitgaz").append("=").append(pr.getIdProduitgaz()).append("");
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
    public synchronized boolean save(ProduitGaz pr)
    {
        sb = new StringBuffer();
		sb.append("INSERT INTO produit_gaz (nom_produitgaz)")

                        .append("VALUES('").append(pr.getNomProduitgaz()).append("') ");
			
                //.append("").append(pr.getDepartement().getIDdepartement()).append(") ");
			

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
    public synchronized boolean delete(ProduitGaz pr) {
        sb = new StringBuffer();
        System.out.println(sb);
		sb.append("DELETE FROM produit_gaz ")
			.append("WHERE id_produitgaz =").append(pr.getIdProduitgaz()).append("");
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
    public synchronized ProduitGaz findByPrimaryKey(int pk)
    {
        ProduitGaz pr = new ProduitGaz();
		pr.setIdProduitgaz(pk);
		List<ProduitGaz> prList = findByValue(pr);
		return (prList!=null && !prList.isEmpty()
		&& prList.size()==1 )?prList.get(0):null;
    }

        @Override
    public synchronized List<ProduitGaz> findAll()
    {
        return findByValue(new ProduitGaz());
    }

        
    private synchronized List<ProduitGaz> populate(ResultSet rs)
    {

        //intentiation departement
        DeparteDaoImpl dpDao=DeparteDaoImpl.getInstance();
        
		List<ProduitGaz> prList = new ArrayList<ProduitGaz>();
		if (rs!=null) {
			try {
				while (rs.next()) {

					ProduitGaz pr = new ProduitGaz();

					pr.setIdProduitgaz(Integer.parseInt(rs.getString("id_produitgaz")));


					pr.setNomProduitgaz(rs.getString("nom_produitgaz"));
                                        
                                       // Departement dpart = dpDao.findByPrimaryKey(Integer.parseInt(rs.getString("IDdepartement")));                                 
					
					//pr.setDepartement(dpart);
                                        				


					prList.add(pr);
				}
				close(rs);
				close(conx);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return prList;
    }




    @Override
    public synchronized List<ProduitGaz>findByValue(ProduitGaz pr)
    {
        sb = new StringBuffer("SELECT * FROM produit_gaz");
		try {

			if(pr.getIdProduitgaz()!=0){
				sb.append(" AND id_produitgaz =")
				.append(pr.getIdProduitgaz());
			}
                         if(pr.getNomProduitgaz()!=null && !"".equals(pr.getNomProduitgaz()) ){
				sb.append(" AND nom_produitgaz ='")
				.append(pr.getNomProduitgaz())
				.append("'");
			}
			   /*     if(pr.getDepartement()!=null && !"".equals(pr.getDepartement())){
				sb.append(" AND IDdepartement =")
				.append(pr.getDepartement().getIDdepartement())
				.append("");
			}
			*/

                       
			String requete = sb.toString().replaceFirst("AND", "WHERE");
			ResultSet rs = createStatement().executeQuery(requete);
			return populate(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conx);
		return null;
    }



}

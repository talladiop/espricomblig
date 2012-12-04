/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import InterfaceDao.IProduitCLDao;
import entites.Departement;
import entites.ProduitCl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Talla
 */
public class ProduitCLDaoImpl extends AbstractDao implements IProduitCLDao
{
    //declaration de l'instence de la class
    private static ProduitCLDaoImpl instance;

        //constructeur de la class
	private ProduitCLDaoImpl(){}

	/**
	 * @return the instance
	 */

        //creation de l'instence
	public synchronized static ProduitCLDaoImpl getInstance()
        {
		if(instance==null)
                {
			instance = new ProduitCLDaoImpl();
		}
			return instance;
		}

        
        @Override
    public synchronized boolean update(ProduitCl pr)
    {
        sb = new StringBuffer();
	sb.append("UPDATE produit_cl ")
                        .append("SET id_produitcl").append("=").append(pr.getIdProduitcl())
			.append(", nom_produitcl").append("='").append(pr.getNomProduitcl())
			//.append("', type_condition").append("='").append(pr.getTypeCondition())
			//.append("', Unite_mesure").append("='").append(pr.getUnitemesure())
			//.append("', Prix_unitaire").append("=").append(pr.getPrixunitaire())
                //.append("', IDdepartement").append("=").append(pr.getDepartement().getIDdepartement())
                        

			.append("'  WHERE id_produitcl").append("=").append(pr.getIdProduitcl()).append("");
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
    public synchronized boolean save(ProduitCl pr)
    {
        sb = new StringBuffer();
		sb.append("INSERT INTO produit_cl (nom_produitcl)")

                        .append("VALUES('").append(pr.getNomProduitcl()).append("') ");
			//.append("'").append(pr.getTypeCondition()).append("', ")
			//.append("'").append(pr.getUnitemesure()).append("', ")
			//.append("").append(pr.getPrixunitaire()).append(", ")
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
    public synchronized boolean delete(ProduitCl pr) {
        sb = new StringBuffer();
        System.out.println(sb);
		sb.append("DELETE FROM produit_cl ")
			.append("WHERE id_produitcl =").append(pr.getIdProduitcl()).append("");
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
    public synchronized ProduitCl findByPrimaryKey(int pk)
    {
        ProduitCl pr = new ProduitCl();
		pr.setIdProduitcl(pk);
		List<ProduitCl> prList = findByValue(pr);
		return (prList!=null && !prList.isEmpty()
		&& prList.size()==1 )?prList.get(0):null;
    }

        @Override
    public synchronized List<ProduitCl> findAll()
    {
        return findByValue(new ProduitCl());
    }

        
    private synchronized List<ProduitCl> populate(ResultSet rs)
    {
        
         //intentiation departement
        DeparteDaoImpl dpDao=DeparteDaoImpl.getInstance();

		List<ProduitCl> prList = new ArrayList<ProduitCl>();
		if (rs!=null) {
			try {
				while (rs.next()) {

					ProduitCl pr = new ProduitCl();

					pr.setIdProduitcl(Integer.parseInt(rs.getString("id_produitcl")));


					pr.setNomProduitcl(rs.getString("nom_produitcl"));
                                         //pr.setTypeCondition(rs.getString("type_condition"));
					//pr.setUnitemesure(rs.getString("Unite_mesure"));
					//pr.setPrixunitaire(Integer.parseInt(rs.getString("Prix_unitaire")));
					
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
    public synchronized List<ProduitCl>findByValue(ProduitCl pr)
    {
        sb = new StringBuffer("SELECT * FROM produit_cl");
		try {

			if(pr.getIdProduitcl()!=0){
				sb.append(" AND id_produitcl =")
				.append(pr.getIdProduitcl());
			}
                         if(pr.getNomProduitcl()!=null && !"".equals(pr.getNomProduitcl()) ){
				sb.append(" AND nom_produitcl ='")
				.append(pr.getNomProduitcl())
				.append("'");
			}
		/*	if(pr.getTypeCondition()!=null && !"".equals(pr.getTypeCondition())){
				sb.append(" AND type_condition ='")
				.append(pr.getTypeCondition())
				.append("'");
			}
			if(pr.getUnitemesure()!=null && !"".equals(pr.getUnitemesure())){
				sb.append(" AND Unite_mesure ='")
				.append(pr.getUnitemesure())
				.append("'");
			}
			if(pr.getUnitemesure()!=null && !"".equals(pr.getUnitemesure())){
				sb.append(" AND Prix_unitaire =")
				.append(pr.getUnitemesure())
				.append("");
			}
                 
                 
                        if(pr.getDepartement()!=null && !"".equals(pr.getDepartement())){
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

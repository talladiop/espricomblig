/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import InterfaceDao.ICuissonDao;
import entites.Cuisson;
import entites.Departement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Talla
 */
public class CuissonDaoImpl extends AbstractDao implements ICuissonDao
{
    //declaration de l'instence de la class
    private static CuissonDaoImpl instance;

        //constructeur de la class
	private CuissonDaoImpl(){}

	/**
	 * @return the instance
	 */

        //creation de l'instence
	public synchronized static CuissonDaoImpl getInstance()
        {
		if(instance==null)
                {
			instance = new CuissonDaoImpl();
		}
			return instance;
		}

        
        @Override
    public synchronized boolean update(Cuisson pr)
    {
        sb = new StringBuffer();
	sb.append("UPDATE cuisson ")
                        .append("SET id_cuisson").append("=").append(pr.getIdCuisson())
			.append(", nom_cuisson").append("='").append(pr.getNomCuisson())
			//.append("', prix_achat").append("=").append(pr.getPrixAchat())
			//.append(", prix_vente").append("=").append(pr.getPrixVente())
			//.append("', IDdepartement").append("=").append(pr.getDepartement().getIDdepartement())
                        

			.append("'  WHERE id_cuisson").append("=").append(pr.getIdCuisson()).append("");
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
    public synchronized boolean save(Cuisson cr)
    {
        sb = new StringBuffer();
		sb.append("INSERT INTO cuisson (nom_cuisson)")

                        .append("VALUES('").append(cr.getNomCuisson()).append("') ");
			//.append("").append(cr.getPrixAchat()).append(", ")
			//.append("").append(cr.getPrixVente()).append(", ")
			//.append("").append(cr.getDepartement().getIDdepartement()).append(") ");
			

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
    public synchronized boolean delete(Cuisson cr) {
        sb = new StringBuffer();
        System.out.println(sb);
		sb.append("DELETE FROM cuisson ")
			.append("WHERE id_cuisson =").append(cr.getIdCuisson()).append("");
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
    public synchronized Cuisson findByPrimaryKey(int pk)
    {
        Cuisson pr = new Cuisson();
		pr.setIdCuisson(pk);
		List<Cuisson> prList = findByValue(pr);
		return (prList!=null && !prList.isEmpty()
		&& prList.size()==1 )?prList.get(0):null;
    }

        @Override
    public synchronized List<Cuisson> findAll()
    {
        return findByValue(new Cuisson());
    }

        
    private synchronized List<Cuisson> populate(ResultSet rs)
    {
        
        //intentiation departement
        DeparteDaoImpl dpDao=DeparteDaoImpl.getInstance();
        

		List<Cuisson> prList = new ArrayList<Cuisson>();
		if (rs!=null) {
			try {
				while (rs.next()) {

					Cuisson pr = new Cuisson();

					pr.setIdCuisson(Integer.parseInt(rs.getString("id_cuisson")));


					pr.setNomCuisson(rs.getString("nom_cuisson"));
                                         //pr.setPrixAchat(Integer.parseInt(rs.getString("prix_achat")));
					//pr.setPrixVente(Integer.parseInt(rs.getString("prix_vente")));
                                        
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
    public synchronized List<Cuisson>findByValue(Cuisson pr)
    {
        sb = new StringBuffer("SELECT * FROM cuisson");
		try {

			if(pr.getIdCuisson()!=0){
				sb.append(" AND id_cuisson =")
				.append(pr.getIdCuisson());
			}
                         if(pr.getNomCuisson()!=null && !"".equals(pr.getNomCuisson()) ){
				sb.append(" AND nom_cuisson ='")
				.append(pr.getNomCuisson())
				.append("'");
			}
		/*	if(pr.getPrixAchat()!=0 && pr.getPrixAchat() >0){
				sb.append(" AND prix_achat =")
				.append(pr.getPrixAchat())
				.append("");
			}
			if(pr.getPrixVente()!=0 && pr.getPrixVente() >0){
				sb.append(" AND prix_vente =")
				.append(pr.getPrixVente())
				.append("");
			}
                 * 
                 
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

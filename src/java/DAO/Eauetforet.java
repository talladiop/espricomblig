/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import InterfaceDao.Departe;
import InterfaceDao.IEauetforetDao;
import InterfaceService.IDeparte;
import entites.Departement;
import entites.Eauxforet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talla
 */
public class Eauetforet extends AbstractDao implements IEauetforetDao
{

     private static Eauetforet instance;


	private Eauetforet(){}

	/**
	 * @return the instance
	 */

	public synchronized static Eauetforet getInstance() {
		if(instance==null){
			instance = new Eauetforet();
		}
			return instance;
		}


 @Override
    public synchronized boolean update(Eauxforet ea)
    {
         sb = new StringBuffer();
	sb.append("UPDATE eauxforet ")
                        .append("SET id_eauxforet").append("=").append(ea.getIdEauxforet())
			.append(", nom_poste").append("='").append(ea.getNomPoste())
                        .append("', tel").append("='").append(ea.getTel())
			.append("', IDdepartement").append("=").append(ea.getDepartement().getIDdepartement())
                        

			.append("  WHERE id_eauxforet").append("=").append(ea.getIdEauxforet()).append("");
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
    public synchronized boolean save(Eauxforet ea)
    {
         sb = new StringBuffer();
		sb.append("INSERT INTO eauxforet (nom_poste, tel, IDdepartement)")

                        .append("VALUES('").append(ea.getNomPoste()).append("', ")
                        .append("'").append(ea.getTel()).append("', ")
                        .append("").append(ea.getDepartement().getIDdepartement()).append(") ");
                       

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
    public synchronized boolean delete(Eauxforet ea)
    {
       sb = new StringBuffer();
		sb.append("DELETE FROM eauxforet ")
			.append("WHERE id_eauxforet =").append(ea.getIdEauxforet()).append("");
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
    public synchronized Eauxforet findByPrimaryKey(int pk)
    {
         Eauxforet ea = new Eauxforet();
		ea.setIdEauxforet(pk);
		List<Eauxforet> eaList = findByValue(ea);
		return (eaList!=null && !eaList.isEmpty()
		&& eaList.size()==1 )?eaList.get(0):null;
    }


@Override
    public synchronized List<Eauxforet> findAll()
    {
        return findByValue(new Eauxforet());
    }


@Override
    public synchronized List<Eauxforet> findByValue(Eauxforet ea)
    {
        sb = new StringBuffer("SELECT * FROM eauxforet");
		try {

			if(ea.getIdEauxforet()!= 0){
				sb.append(" AND id_eauxforet =")
				.append(ea.getIdEauxforet())
                                  .append("");
			}

			if(ea.getNomPoste()!=null && !"".equals(ea.getNomPoste())){
				sb.append(" AND nom_poste ='")
				.append(ea.getNomPoste())
				.append("'");
			}



                         if(ea.getTel()!=null && !"".equals(ea.getTel())){
				sb.append(" AND tel ='")
				.append(ea.getTel())
				.append("'");
			}

                       if(ea.getDepartement()!=null && !"".equals(ea.getDepartement()) ){
				sb.append(" AND IDdepartement =")
				.append(ea.getDepartement().getIDdepartement())
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


 private synchronized List<Eauxforet> populate(ResultSet rs)
    {

               Departe dpDao=DeparteDaoImpl.getInstance();

		List<Eauxforet> eaList = new ArrayList<Eauxforet>();
		if (rs!=null) {
			try {
				while (rs.next()) {

					Eauxforet mg = new Eauxforet();

					mg.setIdEauxforet(Integer.parseInt(rs.getString("id_eauxforet")));
                                     	mg.setNomPoste(rs.getString("nom_poste"));
                                        mg.setTel(rs.getString("tel"));
                                      
                                        Departement dep = dpDao.findByPrimaryKey(Integer.parseInt(rs.getString("IDdepartement")));
                                        mg.setDepartement(dep);
                                        
                                        

					eaList.add(mg);
				}
				close(rs);
				close(conx);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return eaList;
    }


 

}

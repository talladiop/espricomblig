/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import InterfaceDao.Departe;
import InterfaceDao.IAutorisationTonnageDao;
import entites.AutorisationTonnagecl;
import entites.Departement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talla
 */
public class AutorisationTonnageDaoImpl extends AbstractDao implements IAutorisationTonnageDao
{

     private static AutorisationTonnageDaoImpl instance;


	private AutorisationTonnageDaoImpl(){}

	/**
	 * @return the instance
	 */

	public synchronized static AutorisationTonnageDaoImpl getInstance() {
		if(instance==null){
			instance = new AutorisationTonnageDaoImpl();
		}
			return instance;
		}


 @Override
    public synchronized boolean update(AutorisationTonnagecl ea)
    {
         sb = new StringBuffer();
	sb.append("UPDATE autorisation_tonnagecl ")
                        .append("SET id_auttonnage").append("=").append(ea.getIdAuttonnage())
			.append(", qt").append("=").append(ea.getQt())
                        .append(", annee_aut").append("=").append(ea.getAnneeAut())
			.append(", IDdepartement").append("=").append(ea.getDepartement().getIDdepartement())
                        

			.append("  WHERE id_auttonnage").append("=").append(ea.getIdAuttonnage()).append("");
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
    public synchronized boolean save(AutorisationTonnagecl ea)
    {
         sb = new StringBuffer();
		sb.append("INSERT INTO autorisation_tonnagecl (qt, annee_aut, IDdepartement)")

                        .append("VALUES(").append(ea.getQt()).append(", ")
                        .append("").append(ea.getAnneeAut()).append(", ")
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
    public synchronized boolean delete(AutorisationTonnagecl ea)
    {
       sb = new StringBuffer();
		sb.append("DELETE FROM autorisation_tonnagecl ")
			.append("WHERE id_auttonnage =").append(ea.getIdAuttonnage()).append("");
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
    public synchronized AutorisationTonnagecl findByPrimaryKey(int pk)
    {
         AutorisationTonnagecl ea = new AutorisationTonnagecl();
		ea.setIdAuttonnage(pk);
		List<AutorisationTonnagecl> eaList = findByValue(ea);
		return (eaList!=null && !eaList.isEmpty()
		&& eaList.size()==1 )?eaList.get(0):null;
    }


@Override
    public synchronized List<AutorisationTonnagecl> findAll()
    {
        return findByValue(new AutorisationTonnagecl());
    }


@Override
    public synchronized List<AutorisationTonnagecl> findByValue(AutorisationTonnagecl ea)
    {
        sb = new StringBuffer("SELECT * FROM autorisation_tonnagecl");
		try {

			if(ea.getIdAuttonnage()!= 0){
				sb.append(" AND id_auttonnage =")
				.append(ea.getIdAuttonnage())
                                  .append("");
			}

			if(ea.getQt() >0 && !"".equals(ea.getQt())){
				sb.append(" AND qt =")
				.append(ea.getQt())
				.append("");
			}



                         if(ea.getAnneeAut() >0 && !"".equals(ea.getAnneeAut())){
				sb.append(" AND annee_aut =")
				.append(ea.getAnneeAut())
				.append("");
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


 private synchronized List<AutorisationTonnagecl> populate(ResultSet rs)
    {

               Departe dpDao=DeparteDaoImpl.getInstance();

		List<AutorisationTonnagecl> eaList = new ArrayList<AutorisationTonnagecl>();
		if (rs!=null) {
			try {
				while (rs.next()) {

					AutorisationTonnagecl mg = new AutorisationTonnagecl();

					mg.setIdAuttonnage(Integer.parseInt(rs.getString("id_auttonnage")));
                                     	mg.setQt(Integer.parseInt(rs.getString("qt")));
                                        mg.setAnneeAut(Integer.parseInt(rs.getString("annee_aut")));
                                      
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

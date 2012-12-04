/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import InterfaceDao.Departe;
import InterfaceDao.IRegionDao;
import entites.Departement;
import entites.Region;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talla
 */
public class DeparteDaoImpl extends AbstractDao implements Departe
{
    //declaration de l'instence de la class
    private static DeparteDaoImpl instance;

        //constructeur de la class
	private DeparteDaoImpl(){}

	/**
	 * @return the instance
	 */

        //creation de l'instence
	public synchronized static DeparteDaoImpl getInstance()
        {
		if(instance==null)
                {
			instance = new DeparteDaoImpl();
		}
			return instance;
		}

        @Override
    public synchronized boolean update(Departement dp)
    {
        sb = new StringBuffer();
	sb.append("UPDATE departement ")
                        .append("SET IDdepartement").append("=").append(dp.getIDdepartement())
			.append(", IDregion").append("=").append(dp.getRegion().getIDregion())
			.append(", Nomdepartement").append("='").append(dp.getNomdepartement())
			

			.append("'  WHERE IDdepartement").append("=").append(dp.getIDdepartement()).append("");
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
    public synchronized boolean save(Departement dp)
    {
        sb = new StringBuffer();
		sb.append("INSERT INTO departement (IDregion, Nomdepartement)")

                        .append("VALUES(").append(dp.getRegion().getIDregion()).append(", ")
			.append("'").append(dp.getNomdepartement()).append("') ");

                        
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
    public synchronized boolean delete(Departement dp) {
        sb = new StringBuffer();
        System.out.println(sb);
		sb.append("DELETE FROM departement ")
			.append("WHERE IDdepartement =").append(dp.getIDdepartement()).append("");
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
    public synchronized Departement findByPrimaryKey(int pk)
    {
        Departement dp = new Departement();
		dp.setIDdepartement(pk);
		List<Departement> lcList = findByValue(dp);
		return (lcList!=null && !lcList.isEmpty()
		&& lcList.size()==1 )?lcList.get(0):null;
    }

        @Override
    public synchronized List<Departement> findAll()
    {
        return findByValue(new Departement());
    }

    private synchronized List<Departement> populate(ResultSet rs)
    {
            
        IRegionDao rgDao=RegionDaoImpl.getInstance();
        
		List<Departement> dpList = new ArrayList<Departement>();
		if (rs!=null) {
			try {
				while (rs.next()) {

					Departement d = new Departement();

                                        d.setIDdepartement(Integer.parseInt(rs.getString("IDdepartement")));
                                        
                                        Region r = rgDao.findByPrimaryKey(Integer.parseInt(rs.getString("IDregion")));
					d.setRegion(r);
                                       
					d.setNomdepartement(rs.getString("Nomdepartement"));

					dpList.add(d);
				}
				close(rs);
				close(conx);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dpList;
    }


  
    @Override
    public synchronized List<Departement>findByValue(Departement dp)
    {
        sb = new StringBuffer("SELECT * FROM departement");
		try {

			if(dp.getIDdepartement()!=0){
				sb.append(" AND IDdepartement =")
				.append(dp.getIDdepartement());
			}
                         if(dp.getRegion()!=null && !"".equals(dp.getRegion()) ){
				sb.append(" AND IDregion =")
				.append(dp.getRegion().getIDregion())
				.append("");
			}
			if(dp.getNomdepartement()!=null && !"".equals(dp.getNomdepartement())){
				sb.append(" AND Nomdepartement ='")
				.append(dp.getNomdepartement())
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



}

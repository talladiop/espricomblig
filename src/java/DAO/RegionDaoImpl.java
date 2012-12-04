/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import InterfaceDao.IRegionDao;
import entites.Region;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class RegionDaoImpl extends AbstractDao implements IRegionDao
{
      private static RegionDaoImpl instance;

      ResultSet rs;


	private RegionDaoImpl(){}

	/**
	 * @return the instance
	 */

	public static RegionDaoImpl getInstance() {
		if(instance==null){
			instance = new RegionDaoImpl();
		}
			return instance;
		}


	public List<Region> findAll() {
		return findByValue(new Region());
	}

	  private List<Region> populate(ResultSet rs)
    {
		List<Region> regionList = new ArrayList<Region>();
		if (rs!=null)
        {
	  try {
		while (rs.next())
                {
		   Region region = new Region();

		    region.setIDregion(Integer.parseInt(rs.getString("IDregion")));
                    region.setNomregion(rs.getString("Nomregion"));



		    regionList.add(region);
				}
				close(rs);
				close(conx);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return regionList;
    }


	public Region findByPrimaryKey(int pk) {
		Region region = new Region();
		region.setIDregion(pk);
		List<Region> regionList = findByValue(region);
		return (regionList!=null && !regionList.isEmpty()
				&& regionList.size()==1 )?regionList.get(0):null;
	}


	 public List<Region> findByValue(Region region)
    {
         sb = new StringBuffer("SELECT * FROM region");
		try {

			if(region.getIDregion()!=0)
           {
				sb.append(" AND IDregion =")
				.append(region.getIDregion());
	  }
            if(region.getNomregion()!=null && !"".equals(region.getNomregion()) )
            {
				sb.append(" AND Nomregion ='")
				.append(region.getNomregion())
				.append("'");
			}

			String requete = sb.toString().replaceFirst("AND", "WHERE");
			 rs = createStatement().executeQuery(requete);
			return populate(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conx);
		return null;
    }



	public boolean save(Region region) {

		sb = new StringBuffer();
		sb.append("INSERT INTO Region (Nomregion)")
			.append("VALUES('").append(region.getNomregion()).append("') ");

		try {
			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean update(Region region) {
		sb = new StringBuffer();
		sb.append("UPDATE Region ")
		.append("SET Nomregion").append("='").append(region.getNomregion()).append("'")
	.append("WHERE IDregion").append("=").append(region.getIDregion()).append("");

		try {
			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean delete(Region region) {
		sb = new StringBuffer();
		sb.append("DELETE FROM Region ")
			.append("WHERE IDregion ='").append(region.getIDregion()).append("'");
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

;
import InterfaceDao.ILocaliteDao;
import entites.Departement;
import entites.Localite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talla
 */
public class LocaliteDaoImpl extends AbstractDao implements ILocaliteDao
{
    //declaration de l'instence de la class
    private static LocaliteDaoImpl instance;

        //constructeur de la class
	private LocaliteDaoImpl(){}

	/**
	 * @return the instance
	 */

        //creation de l'instence
	public synchronized static LocaliteDaoImpl getInstance()
        {
		if(instance==null)
                {
			instance = new LocaliteDaoImpl();
		}
			return instance;
		}

         @Override
    public synchronized boolean update(Localite lc)
    {
        sb = new StringBuffer();
	sb.append("UPDATE localite ")
                        .append("SET id_localite").append("=").append(lc.getIdLocalite())
			.append(", nom_localite").append("='").append(lc.getNomLocalite())
                        .append("', id_departement").append("=").append(lc.getDepartement().getIDdepartement())
			
                        
                	.append("  WHERE Id_enqueteur").append("=").append(lc.getIdLocalite()).append("");
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
    public synchronized boolean save(Localite localite)
    {
        sb = new StringBuffer();
		sb.append("INSERT INTO localite (nom_localite, id_departement)")

                        .append("VALUES('").append(localite.getNomLocalite()).append("', ")
			.append("'").append(localite.getDepartement().getIDdepartement()).append("') ");

                        
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
    public synchronized boolean delete(Localite localite) {
        sb = new StringBuffer();
        System.out.println(sb);
		sb.append("DELETE FROM localite ")
			.append("WHERE id_localite =").append(localite.getIdLocalite()).append("");
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
    public synchronized Localite findByPrimaryKey(int pk)
    {
        Localite localite = new Localite();
		localite.setIdLocalite(pk);
		List<Localite> lcList = findByValue(localite);
		return (lcList!=null && !lcList.isEmpty()
		&& lcList.size()==1 )?lcList.get(0):null;
    }

        @Override
    public synchronized List<Localite> findAll()
    {
        return findByValue(new Localite());
    }

    private synchronized List<Localite> populate(ResultSet rs)
    {
            
        DeparteDaoImpl dpDao=DeparteDaoImpl.getInstance();
        
		List<Localite> localiteList = new ArrayList<Localite>();
		if (rs!=null) {
			try {
				while (rs.next()) {

					Localite lc = new Localite();

                                        lc.setIdLocalite(Integer.parseInt(rs.getString("id_localite")));
					lc.setNomLocalite(rs.getString("nom_localite"));
                                        
					Departement dpart = dpDao.findByPrimaryKey(Integer.parseInt(rs.getString("id_departement")));                                 
					
					lc.setDepartement(dpart);

					localiteList.add(lc);
				}
				close(rs);
				close(conx);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return localiteList;
    }


  
    @Override
    public synchronized List<Localite>findByValue(Localite localite)
    {
        sb = new StringBuffer("SELECT * FROM localite");
		try {

			if(localite.getIdLocalite()!=0){
				sb.append(" AND id_localite =")
				.append(localite.getIdLocalite());
			}
                         if(localite.getNomLocalite()!=null && !"".equals(localite.getNomLocalite()) ){
				sb.append(" AND nom_localite ='")
				.append(localite.getNomLocalite())
				.append("'");
			}
			if(localite.getDepartement()!=null){
				sb.append(" AND id_departement ='")
				.append(localite.getDepartement().getIDdepartement())
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

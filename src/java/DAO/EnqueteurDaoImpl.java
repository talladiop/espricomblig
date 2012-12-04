/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import InterfaceDao.IEnqueteurDao;
import entites.Departement;
import entites.Enqueteur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class EnqueteurDaoImpl extends AbstractDao implements IEnqueteurDao
{
  private static EnqueteurDaoImpl instance;


	private EnqueteurDaoImpl(){}

	/**
	 * @return the instance
	 */

	public static EnqueteurDaoImpl getInstance() {
		if(instance==null){
			instance = new EnqueteurDaoImpl();
		}
			return instance;
		}


	public List<Enqueteur> findAll() {
		return findByValue(new Enqueteur());
	}

	private List<Enqueteur> populate(ResultSet rs) 
        {
            DeparteDaoImpl dpDao=DeparteDaoImpl.getInstance();
            
		List<Enqueteur> enqList = new ArrayList<Enqueteur>();
		if (rs!=null) {
			try {
				while (rs.next()) {
					Enqueteur eq = new Enqueteur();
					eq.setIdenqueteur(Integer.parseInt(rs.getString("Id_enqueteur")));
					eq.setNomenqueteur(rs.getString("Nom_enqueteur"));
					eq.setPrenomenqueteur(rs.getString("Prenom_enqueteur"));
                                        eq.setTel(rs.getString("tel"));
                                        eq.setEmail(rs.getString("email"));
                                        eq.setLogin(rs.getString("login"));
					eq.setPwd(rs.getString("pwd"));
                                        eq.setProfile(Integer.parseInt(rs.getString("profile")));
                                        eq.setEtatcompte(rs.getString("etat_compte"));
                                        
                                        Departement dpart = dpDao.findByPrimaryKey(Integer.parseInt(rs.getString("IDdepartement"))); 
                                        
                                        eq.setDepartement(dpart);
                                        
                                       // eq.setActivation(rs.getString("activation"));
                                         
                                        
					enqList.add(eq);
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


	public Enqueteur findByPrimaryKey(int pk) {
		Enqueteur eq = new Enqueteur();
		eq.setIdenqueteur(pk);
		List<Enqueteur> eqList = findByValue(eq);
		return (eqList!=null && !eqList.isEmpty()
				&& eqList.size()==1 )?eqList.get(0):null;
	}


	public List<Enqueteur> findByValue(Enqueteur enqueteur) {
		sb = new StringBuffer("SELECT * FROM enqueteur");
		try {

			if(enqueteur.getIdenqueteur()!=0){
				sb.append(" AND Id_enqueteur =")
				.append(enqueteur.getIdenqueteur());
			}
			if(enqueteur.getNomenqueteur()!=null && !"".equals(enqueteur.getNomenqueteur()))
                        {
				sb.append(" AND Nom_enqueteur ='")
				.append(enqueteur.getNomenqueteur())
				.append("'");
			}

                        if(enqueteur.getPrenomenqueteur()!=null && !"".equals(enqueteur.getPrenomenqueteur())){
				sb.append(" AND Prenom_enqueteur ='")
				.append(enqueteur.getPrenomenqueteur())
				.append("'");
			}
                        if(enqueteur.getTel()!=null && !"".equals(enqueteur.getTel())){
				sb.append(" AND tel ='")
				.append(enqueteur.getTel())
                                .append("'");
			}
                        if(enqueteur.getEmail()!=null && !"".equals(enqueteur.getEmail())){
				sb.append(" AND email ='")
				.append(enqueteur.getEmail())
                                 .append("'");
			}
                        if(enqueteur.getDepartement()!=null && !"".equals(enqueteur.getDepartement())){
				sb.append(" AND IDdepartement =")
				.append(enqueteur.getDepartement().getIDdepartement())
                                 .append("");
			}
                             if(enqueteur.getLogin()!=null && !"".equals(enqueteur.getLogin())){
				sb.append(" AND login ='")
				.append(enqueteur.getLogin())
                                 .append("'");
			}
                             if(enqueteur.getPwd()!=null && !"".equals(enqueteur.getPwd())){
				sb.append(" AND pwd ='")
				.append(enqueteur.getPwd())
                                 .append("'");
			}
                             if(enqueteur.getProfile()!=0 && !"".equals(enqueteur.getProfile())){
				sb.append(" AND profile =")
				.append(enqueteur.getProfile())
                                 .append("");
			}
                             if(enqueteur.getEtatcompte()!=null && !"".equals(enqueteur.getEtatcompte())){
				sb.append(" AND etat_compte ='")
				.append(enqueteur.getEtatcompte())
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


	 @Override
    public synchronized boolean save(Enqueteur eq)
    {
        sb = new StringBuffer();
		sb.append("INSERT INTO enqueteur (Nom_enqueteur, Prenom_enqueteur, tel, email, IDdepartement, login, pwd, profile, etat_compte)")

                        .append("VALUES('").append(eq.getNomenqueteur()).append("', ")
			.append("'").append(eq.getPrenomenqueteur()).append("', ")
                .append("'").append(eq.getTel()).append("', ")
                .append("'").append(eq.getEmail()).append("', ")
                        .append("").append(eq.getDepartement().getIDdepartement()).append(", ")
                        .append("'").append(eq.getLogin()).append("', ")
                        .append("'").append(eq.getPwd()).append("', ")
                        .append("").append(eq.getProfile()).append(", ")
                        .append("'").append(eq.getEtatcompte()).append("') ");
                

                        
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
    public synchronized boolean update(Enqueteur eqt)
    {
        sb = new StringBuffer();
	sb.append("UPDATE enqueteur ")
                        .append("SET Id_enqueteur").append("=").append(eqt.getIdenqueteur())
			.append(", Nom_enqueteur").append("='").append(eqt.getNomenqueteur())
                        .append("', Prenom_enqueteur").append("='").append(eqt.getPrenomenqueteur())
			.append("', tel").append("='").append(eqt.getTel())
                        .append("', email").append("='").append(eqt.getEmail())
                .append("', IDdepartement ").append("=").append(eqt.getDepartement().getIDdepartement())
                .append(", login").append("='").append(eqt.getLogin())
                .append("', pwd").append("='").append(eqt.getPwd())
                .append("', profile").append("=").append(eqt.getProfile())
                .append(", etat_compte").append("='").append(eqt.getEtatcompte())
                        
                	.append("'  WHERE Id_enqueteur").append("=").append(eqt.getIdenqueteur()).append("");
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

	public boolean delete(Enqueteur enqueteur) {
		sb = new StringBuffer();
		sb.append("DELETE FROM enqueteur ")
			.append("WHERE Id_enqueteur ='").append(enqueteur.getIdenqueteur()).append("'");
		try {
			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

        
        //activation et desactivation de l'enqueteur
        
   public synchronized boolean activer(int pk) {
		sb = new StringBuffer();
		sb.append("UPDATE enqueteur ")
			.append("SET etat_compte").append("='1'")
			.append("  WHERE Id_enqueteur ").append("=").append(pk);
		try {

			createStatement().executeUpdate(sb.toString());
			close(conx);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


    public synchronized boolean desactiver(int pk)
        {
		sb = new StringBuffer();
		sb.append("UPDATE enqueteur ")
			.append("SET etat_compte").append("='0'")
			.append("  WHERE Id_enqueteur ").append("=").append(pk);
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

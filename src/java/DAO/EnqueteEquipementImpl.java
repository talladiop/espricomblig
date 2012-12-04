/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import InterfaceDao.IEnqueteEquipement;
import InterfaceDao.IEnqueteurDao;
import entites.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author souleymane
 */
public class EnqueteEquipementImpl extends AbstractDao implements IEnqueteEquipement
{
  private static EnqueteEquipementImpl instance;


	private EnqueteEquipementImpl(){}

	/**
	 * @return the instance
	 */

	public static EnqueteEquipementImpl getInstance() {
		if(instance==null){
			instance = new EnqueteEquipementImpl();
		}
			return instance;
		}
 private List<EnqueteEquipement> populate(ResultSet rs) throws SQLException
        {
            //DeparteDaoImpl departDao=DeparteDaoImpl.getInstance();
            EnqueteurDaoImpl enqqDao= EnqueteurDaoImpl.getInstance();
            DeparteDaoImpl departDao= DeparteDaoImpl.getInstance();
            CuissonDaoImpl eqpDao= CuissonDaoImpl.getInstance();
		List<EnqueteEquipement> enqueteequipList = new ArrayList<EnqueteEquipement>();
		if (rs!=null) {
			try {      
				while (rs.next()) {
                                   EnqueteEquipement enqueteequipement = new EnqueteEquipement();
					
                                        enqueteequipement.setIdenquete(Integer.parseInt(rs.getString("Id_enquete")));
                                        
					Cuisson cus=eqpDao.findByPrimaryKey(Integer.parseInt(rs.getString("Id_Cuisson")));
                                        enqueteequipement.setEquipement(cus);
                                        
                                        enqueteequipement.setDateEnquete(rs.getString("date_enquete"));
                                        
                                         Departement dep =departDao.findByPrimaryKey(Integer.parseInt(rs.getString("IDepartement")));
                                        enqueteequipement.setDepart(dep);
                                        
                                        Enqueteur enq= enqqDao.findByPrimaryKey(Integer.parseInt(rs.getString("Id_enqueteur")));
					enqueteequipement.setEnqueteur(enq);
                                                                              
                                        
                                        enqueteequipement.setPrixAchat(Integer.parseInt(rs.getString("prix_achat")));
                                        enqueteequipement.setPrixVente(Integer.parseInt(rs.getString("prix_vente")));
                                        
                                        enqueteequipement.setQte(Integer.parseInt(rs.getString("qte")));
                                       
                                        enqueteequipement.setValider(rs.getString("valider"));
					enqueteequipement.setValiderfinale(rs.getString("validerfinale"));
                                                                                       
                                       enqueteequipList.add(enqueteequipement);
				}
				close(rs);
				close(conx);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return enqueteequipList;
        }
    @Override
    public boolean update(EnqueteEquipement enqueteEquipement) {
       // throw new UnsupportedOperationException("Not supported yet.");
    sb = new StringBuffer();
    sb.append("UPDATE enquete_equipement ") 
			.append("SET Id_enquete=").append(enqueteEquipement.getIdenquete())
			.append(", Id_Cuisson=").append(enqueteEquipement.getEquipement().getIdCuisson())
                        .append(", date_enquete='").append(enqueteEquipement.getDateEnquete())
                        .append("', IDepartement=").append(enqueteEquipement.getDepart().getIDdepartement())
                        .append(", Id_enqueteur=").append(enqueteEquipement.getEnqueteur().getIdenqueteur())
                        .append(", prix_achat=").append(enqueteEquipement.getPrixAchat())
                        .append(", prix_vente=").append(enqueteEquipement.getPrixVente())
                        .append(", qte=").append(enqueteEquipement.getQte())
                        .append(", valider='").append(enqueteEquipement.getValider())
                        .append("', validerfinale='").append(enqueteEquipement.getValiderfinale())
            
            
                       .append("' WHERE Id_enquete=").append(enqueteEquipement.getIdenquete()).append("");
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
    public synchronized boolean save(EnqueteEquipement enqueteequipement)
    {
        sb = new StringBuffer();
		sb.append("INSERT INTO enquete_equipement (Id_Cuisson, date_enquete, "
                           + "IDepartement, Id_enqueteur, prix_achat, prix_vente, "
                           + "qte, valider) VALUES(").append(enqueteequipement.getEquipement().getIdCuisson()).append(", ")
                        .append("'").append(enqueteequipement.getDateEnquete()).append("', ")
			.append("").append(enqueteequipement.getDepart().getIDdepartement()).append(", ")
                        .append("").append(enqueteequipement.getEnqueteur().getIdenqueteur()).append(", ")
                        .append("").append(enqueteequipement.getPrixAchat()).append(", ")
                        .append("").append(enqueteequipement.getPrixVente()).append(", ")
                        .append("").append(enqueteequipement.getQte()).append(", ")
                        .append("'").append(enqueteequipement.getValider()).append("') ");
                

                        
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
    public boolean delete(EnqueteEquipement enqueteequipement) {
    //    throw new UnsupportedOperationException("Not supported yet.");
    sb = new StringBuffer();
		sb.append("DELETE FROM enquete_equipement")
			.append("WHERE Id_enquete=").append(enqueteequipement.getIdenquete()).append("");
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
    public EnqueteEquipement findByPrimaryKey(int pk) {
    //    throw new UnsupportedOperationException("Not supported yet.");
    EnqueteEquipement enqueteequipement = new EnqueteEquipement();
		enqueteequipement.setIdenquete(pk);
		List<EnqueteEquipement> enqueteequipementList = findByValue(enqueteequipement);
		return (enqueteequipementList!=null && !enqueteequipementList.isEmpty()
				&& enqueteequipementList.size()==1 )?enqueteequipementList.get(0):null;
    }

    @Override
    public List<EnqueteEquipement> findAll() {
       // throw new UnsupportedOperationException("Not supported yet.");
    return findByValue(new EnqueteEquipement());
    }

    @Override
    public List<EnqueteEquipement> findByValue(EnqueteEquipement enqueteequipement) {
       
      sb = new StringBuffer("SELECT * FROM enquete_equipement");
		try{
 
			if(enqueteequipement.getIdenquete()!=0){
				sb.append(" AND Id_enquete =")
				.append(enqueteequipement.getIdenquete())
                                        .append("");
			}
                        if(enqueteequipement.getEquipement() != null){
				sb.append(" AND Id_Cuisson=")
				.append(enqueteequipement.getEquipement().getIdCuisson())
                                        .append("");
                              }
                         if(enqueteequipement.getDateEnquete()!=null && !"".equals(enqueteequipement.getDateEnquete())){
				sb.append(" AND date_enquete='")
				.append(enqueteequipement.getDateEnquete())
                                        .append("'");
				}
                        
                                if(enqueteequipement.getDepart() != null){
				sb.append(" AND IDepartement=")
				.append(enqueteequipement.getDepart().getIDdepartement())
                                        .append("");
                                       			}
                                if(enqueteequipement.getEnqueteur() != null){
				sb.append(" AND Id_enqueteur=")
				.append(enqueteequipement.getEnqueteur().getIdenqueteur())
                                        .append("");
                        }
                       
                       if(enqueteequipement.getPrixAchat()!=0){
				sb.append(" AND prix_achat=")
				.append(enqueteequipement.getPrixAchat())
                                        .append("");
							}
                       if(enqueteequipement.getPrixVente()!=0){
				sb.append(" AND prix_vente=")
				.append(enqueteequipement.getPrixAchat())
                                        .append("");
							}
                      
                        if(enqueteequipement.getQte()!=0){
				sb.append(" AND qte=")
				.append(enqueteequipement.getQte())
                                        .append("");
							}
                        if(enqueteequipement.getValider()!=null && !"".equals(enqueteequipement.getValider())){
				sb.append(" AND valider='")
				.append(enqueteequipement.getValider())
				.append("'");
			}
                        if(enqueteequipement.getValiderfinale()!=null && !"".equals(enqueteequipement.getValiderfinale())){
				sb.append(" AND validerfinale='")
				.append(enqueteequipement.getValiderfinale())
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
    
    
     //activation et desactivation de l'enqueteur
        
   public synchronized boolean Valider(int pk) {
		sb = new StringBuffer();
		sb.append("UPDATE enquete_equipement ")
			.append("SET valider").append("='1'")
			.append("  WHERE Id_enquete ").append("=").append(pk);
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
        
   public synchronized boolean ValiderFinale(int pk) {
		sb = new StringBuffer();
		sb.append("UPDATE enquete_equipement ")
			.append("SET validerfinale").append("='1'")
			.append("  WHERE Id_enquete ").append("=").append(pk);
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

    


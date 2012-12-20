/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import InterfaceDao.IEnqueteCLDao;
import entites.Departement;
import entites.EnqueteCl;
import entites.Enqueteur;
import entites.ProduitCl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class EnqueteCLDaoImpl extends AbstractDao implements IEnqueteCLDao
{
  private static EnqueteCLDaoImpl instance;


	private EnqueteCLDaoImpl(){}

	/**
	 * @return the instance
	 */

	public static EnqueteCLDaoImpl getInstance() {
		if(instance==null){
			instance = new EnqueteCLDaoImpl();
		}
			return instance;
		}


	public List<EnqueteCl> findAll() {
		return findByValue(new EnqueteCl());
	}

        
        
        
	private List<EnqueteCl> populate(ResultSet rs) 
        {
            //intentiation departement
            DeparteDaoImpl dpDao=DeparteDaoImpl.getInstance();
            
            //intentiation departement
            ProduitCLDaoImpl prodclDao=ProduitCLDaoImpl.getInstance();
            
            //intentiation enqueteur
            EnqueteurDaoImpl enqDao=EnqueteurDaoImpl.getInstance();
            
		List<EnqueteCl> enqList = new ArrayList<EnqueteCl>();
		if (rs!=null) {
			try {
				while (rs.next()) {
					EnqueteCl eq = new EnqueteCl();
                                        
					eq.setIdenqueteCl(Integer.parseInt(rs.getString("Id_enqueteCl")));
                                        
                                         ProduitCl pcl = prodclDao.findByPrimaryKey(Integer.parseInt(rs.getString("Id_produitcl"))); 
                                        eq.setProduitcl(pcl);
                                        
				        eq.setTypeCond(rs.getString("type_cond"));
                                        eq.setEquivalantKgmin(Float.parseFloat(rs.getString("equivalant_kg_min")));
                                        eq.setEquivalantKgmax(Float.parseFloat(rs.getString("equivalant_kg_max")));
                                        eq.setPrixGros(Integer.parseInt(rs.getString("prix_gros")));
                                        eq.setPrixDetail(Integer.parseInt(rs.getString("Prix_Detail")));
					eq.setDateEnquete(rs.getString("date_enquete"));
                                        eq.setMarchee(rs.getString("marchee"));
                                        
                                         Enqueteur enq = enqDao.findByPrimaryKey(Integer.parseInt(rs.getString("Id_enqueteur"))); 
                                        eq.setEnqueteur(enq);
                                        
                                        Departement dpart = dpDao.findByPrimaryKey(Integer.parseInt(rs.getString("IDdepartement"))); 
                                        eq.setDepartement(dpart);
                                        
                                         eq.setRegion(rs.getString("region"));
                                         
                                          eq.setMois(Integer.parseInt(rs.getString("mois")));
                                          
                                           eq.setAnnee(Integer.parseInt(rs.getString("annee")));
                                        
                                         
                                          eq.setValider(rs.getString("valider"));
                                          
                                          eq.setValiderfinale(rs.getString("validerfinale"));
                                        
                                       
                                                
                                        
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


	public EnqueteCl findByPrimaryKey(int pk) {
		EnqueteCl eq = new EnqueteCl();
		eq.setIdenqueteCl(pk);
		List<EnqueteCl> eqList = findByValue(eq);
		return (eqList!=null && !eqList.isEmpty()
				&& eqList.size()==1 )?eqList.get(0):null;
	}


        
       public List<EnqueteCl> findByValue(EnqueteCl eq) {
		sb = new StringBuffer("SELECT * FROM enquete_cl");
		try {

			if(eq.getIdenqueteCl()!=0){
				sb.append(" AND Id_enqueteCl =")
				.append(eq.getIdenqueteCl())
                                        .append("");
			}
                        
                        if(eq.getProduitcl() !=null && !"".equals(eq.getProduitcl()))
                        {
				sb.append(" AND Id_produitcl =")
				.append(eq.getProduitcl().getIdProduitcl())
				.append("");
			}
                        
			if(eq.getTypeCond() !=null && !"".equals(eq.getTypeCond()))
                        {
				sb.append(" AND type_cond ='")
				.append(eq.getTypeCond())
				.append("'");
			}

                        if(eq.getEquivalantKgmin()!=0 && !"".equals(eq.getEquivalantKgmin())){
				sb.append(" AND equivalant_kg_min =")
				.append(eq.getEquivalantKgmin())
				.append("");
			}
                        if(eq.getEquivalantKgmax() !=0 && !"".equals(eq.getEquivalantKgmax())){
				sb.append(" AND equivalant_kg_max =")
				.append(eq.getEquivalantKgmax())
                                .append("");
			}
                        if(eq.getPrixGros()!=0 && !"".equals(eq.getPrixGros())){
				sb.append(" AND prix_gros =")
				.append(eq.getPrixGros())
                                 .append("");
			}
                        if(eq.getPrixDetail()!=0 && !"".equals(eq.getPrixDetail())){
				sb.append(" AND Prix_Detail =")
				.append(eq.getPrixDetail())
                                 .append("");
			}
                             if(eq.getDateEnquete()!=null && !"".equals(eq.getDateEnquete())){
				sb.append(" AND date_enquete ='")
				.append(eq.getDateEnquete())
                                 .append("'");
			}
                             if(eq.getMarchee()!=null && !"".equals(eq.getMarchee())){
				sb.append(" AND marchee ='")
				.append(eq.getMarchee())
                                 .append("'");
			}
                             
                             if(eq.getEnqueteur()!=null && !"".equals(eq.getEnqueteur())){
				sb.append(" AND Id_enqueteur =")
				.append(eq.getEnqueteur().getIdenqueteur())
                                 .append("");
			}
                             
                             
                             if(eq.getDepartement()!=null && !"".equals(eq.getDepartement())){
				sb.append(" AND IDdepartement =")
				.append(eq.getDepartement().getIDdepartement())
                                 .append("");
			}
                                   if(eq.getRegion()!=null && !"".equals(eq.getRegion())){
				sb.append(" AND region ='")
				.append(eq.getRegion())
				.append("'");
			}
                           if(eq.getMois()!=0 && !"".equals(eq.getMois())){
				sb.append(" AND mois =")
				.append(eq.getMois())
				.append("");
			}
                            if(eq.getAnnee()!=0 && !"".equals(eq.getAnnee())){
				sb.append(" AND annee =")
				.append(eq.getAnnee())
				.append("");
			}
                             if(eq.getValider()!=null && !"".equals(eq.getValider())){
				sb.append(" AND valider ='")
				.append(eq.getValider())
                                 .append("'");
			}
                              if(eq.getValiderfinale()!=null && !"".equals(eq.getValiderfinale())){
				sb.append(" AND validerfinale ='")
				.append(eq.getValiderfinale())
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
    public synchronized boolean save(EnqueteCl eq)
    {
        sb = new StringBuffer();
		sb.append("INSERT INTO enquete_cl (Id_produitcl, type_cond, equivalant_kg_min, "
                        + "equivalant_kg_max, prix_gros, "
                        + "Prix_Detail, date_enquete, marchee, Id_enqueteur, IDdepartement, region, "
                        + "mois, annee,valider)")

                        .append("VALUES(").append(eq.getProduitcl().getIdProduitcl()).append(", ")
			.append("'").append(eq.getTypeCond()).append("', ")
                        .append("").append(eq.getEquivalantKgmin()).append(", ")
                        .append("").append(eq.getEquivalantKgmax()).append(", ")
                       .append("").append(eq.getPrixGros()).append(", ")
                        .append("").append(eq.getPrixDetail()).append(", ")
                        .append("'").append(eq.getDateEnquete()).append("', ")
                        .append("'").append(eq.getMarchee()).append("', ")
                        .append("").append(eq.getEnqueteur().getIdenqueteur()).append(", ")
                        .append("").append(eq.getDepartement().getIDdepartement()).append(", ")
                         .append("'").append(eq.getRegion()).append("', ")
                        .append("").append(eq.getMois()).append(", ")
                        .append("").append(eq.getAnnee()).append(", ")
                        .append("'").append(eq.getValider()).append("') ");
                

                        
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
    public synchronized boolean update(EnqueteCl eqt)
    {
        sb = new StringBuffer();
	sb.append("UPDATE enquete_cl ")
                        .append("SET Id_enqueteCl").append("=").append(eqt.getIdenqueteCl())
			.append(", Id_produitcl").append("=").append(eqt.getProduitcl().getIdProduitcl())
                        .append(", type_cond").append("='").append(eqt.getTypeCond())
			.append("', equivalant_kg_min").append("=").append(eqt.getEquivalantKgmin())
                        .append(", equivalant_kg_max").append("=").append(eqt.getEquivalantKgmax())
                        .append(", prix_gros").append("=").append(eqt.getPrixGros())
                .append(", Prix_Detail").append("=").append(eqt.getPrixDetail())
                .append(", date_enquete").append("='").append(eqt.getDateEnquete())
                .append("', marchee").append("='").append(eqt.getMarchee())
                .append("', Id_enqueteur").append("=").append(eqt.getEnqueteur().getIdenqueteur())
                .append(", IDdepartement").append("=").append(eqt.getDepartement().getIDdepartement())
                .append(", region").append("='").append(eqt.getRegion())
                
                .append("', mois").append("=").append(eqt.getMois())
                
                .append(", annee").append("=").append(eqt.getAnnee())
                .append(", valider").append("='").append(eqt.getValider())
                .append("', validerfinale").append("='").append(eqt.getValiderfinale())
                        
                	.append("'  WHERE Id_enqueteCl").append("=").append(eqt.getIdenqueteCl()).append("");
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

	public boolean delete(EnqueteCl enqueteur) {
		sb = new StringBuffer();
		sb.append("DELETE FROM enquete_cl ")
			.append("WHERE Id_enqueteCl ='").append(enqueteur.getIdenqueteCl()).append("'");
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
        
   public synchronized boolean Valider(int pk) {
		sb = new StringBuffer();
		sb.append("UPDATE enquete_cl ")
			.append("SET valider").append("='1'")
			.append("  WHERE Id_enqueteCl ").append("=").append(pk);
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
		sb.append("UPDATE enquete_cl ")
			.append("SET validerfinale").append("='1'")
			.append("  WHERE Id_enqueteCl ").append("=").append(pk);
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

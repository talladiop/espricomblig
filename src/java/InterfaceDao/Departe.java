/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDao;

import entites.Departement;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface Departe 
{
     public boolean update(Departement dp);
	public boolean save(Departement dp);
	public boolean delete(Departement dp);
	public Departement findByPrimaryKey(int pk);
	public List <Departement> findAll();
	public List <Departement> findByValue(Departement dp);
    
}

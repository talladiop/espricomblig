/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.EnqueteGaz;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IEnqueteGazService 
{
     public boolean update(EnqueteGaz pr);
	public boolean save(EnqueteGaz pr);
	public boolean delete(EnqueteGaz pr);
	public EnqueteGaz findByPrimaryKey(int pk);
	public List <EnqueteGaz> findAll();
	public List <EnqueteGaz> findByValue(EnqueteGaz pr);
        public  boolean ValiderEnquete(int pk);
        public  boolean ValiderEnqueteFinale(int pk);
    
}

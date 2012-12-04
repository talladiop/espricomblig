/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.Cuisson;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface ICuissonService 
{
     public boolean update(Cuisson pr);
	public boolean save(Cuisson pr);
	public boolean delete(Cuisson pr);
	public Cuisson findByPrimaryKey(int pk);
	public List <Cuisson> findAll();
	public List <Cuisson> findByValue(Cuisson pr);
    
}

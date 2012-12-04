/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDao;

import entites.Cuisson;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface ICuissonDao
{
    public boolean update(Cuisson cs);
	public boolean save(Cuisson cs);
	public boolean delete(Cuisson cs);
	public Cuisson findByPrimaryKey(int pk);
	public List <Cuisson> findAll();
	public List <Cuisson> findByValue(Cuisson cs);
    
}

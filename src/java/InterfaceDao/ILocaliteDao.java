/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDao;

import entites.Localite;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface ILocaliteDao 
{
    public boolean update(Localite localite);
	public boolean save(Localite localite);
	public boolean delete(Localite localite);
	public Localite findByPrimaryKey(int pk);
	public List <Localite> findAll();
	public List <Localite> findByValue(Localite localite);
    
}

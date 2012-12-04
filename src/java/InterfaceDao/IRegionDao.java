/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfaceDao;

import entites.Region;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface IRegionDao
{
  public boolean update(Region region);
	public boolean save(Region region);
	public boolean delete(Region region);
	public Region findByPrimaryKey(int pk);
	public List <Region> findAll();
	public List <Region> findByValue(Region region);
}

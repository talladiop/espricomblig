/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfaceService;


import entites.Region;
import java.util.List;

/**
 *
 * @author Cherif
 */
public interface IRegionService
{

    public boolean creerRegion(Region region);
	public void saveListRegion(List<Region> regionList);
	public boolean modifier(Region region);
	public boolean supprimer(Region region);
	public Region findByPrimaryKey(int pk);
	public List <Region> findAll();
	public List <Region> findByValue(Region region);

}

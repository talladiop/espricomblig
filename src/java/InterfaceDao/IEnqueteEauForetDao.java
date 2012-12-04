/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDao;

import entites.Eauxforet;
import entites.EnqueteEauxforet;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IEnqueteEauForetDao
{
    public boolean update(EnqueteEauxforet ef);
	public boolean save(EnqueteEauxforet ef);
	public boolean delete(EnqueteEauxforet ef);
	public EnqueteEauxforet findByPrimaryKey(int pk);
	public List <EnqueteEauxforet> findAll();
	public List <EnqueteEauxforet> findByValue(EnqueteEauxforet ef);
       public  boolean ValiderEnquete(int pk);
    
}

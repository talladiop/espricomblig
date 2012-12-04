/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDao;

import entites.Eauxforet;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IEauetforetDao 
{
    public boolean update(Eauxforet e);
	public boolean save(Eauxforet e);
	public boolean delete(Eauxforet e);
	public Eauxforet findByPrimaryKey(int pk);
	public List <Eauxforet> findAll();
	public List <Eauxforet> findByValue(Eauxforet e);
        
    
}

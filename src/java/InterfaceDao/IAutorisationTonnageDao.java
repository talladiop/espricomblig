/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDao;

import entites.AutorisationTonnagecl;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IAutorisationTonnageDao 
{
     public boolean update(AutorisationTonnagecl aut);
	public boolean save(AutorisationTonnagecl aut);
	public boolean delete(AutorisationTonnagecl aut);
	public AutorisationTonnagecl findByPrimaryKey(int pk);
	public List <AutorisationTonnagecl> findAll();
	public List <AutorisationTonnagecl> findByValue(AutorisationTonnagecl aut);
    
}

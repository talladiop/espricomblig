/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.Eauxforet;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IEauetforetService 
{
    public boolean update(Eauxforet ea);
	public boolean save(Eauxforet ea);
	public boolean delete(Eauxforet ea);
	public Eauxforet findByPrimaryKey(int pk);

        public List <Eauxforet> findAll();
	public List <Eauxforet> findByValue(Eauxforet ea);
       
    
}

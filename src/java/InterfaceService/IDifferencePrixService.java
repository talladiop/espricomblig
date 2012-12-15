/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.Diferenceprix;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IDifferencePrixService 
{
     public boolean update(Diferenceprix pr);
	public boolean save(Diferenceprix pr);
	public boolean delete(Diferenceprix pr);
	public Diferenceprix findByPrimaryKey(int pk);
	public List <Diferenceprix> findAll();
	public List <Diferenceprix> findByValue(Diferenceprix pr);
        public  boolean DesactiverEtat(int pk);
       
    
}

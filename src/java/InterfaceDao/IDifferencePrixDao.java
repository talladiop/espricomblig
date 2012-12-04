/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDao;


import entites.Diferenceprix;
import java.util.List;



public interface IDifferencePrixDao 
{
    public boolean update(Diferenceprix pr);
	public boolean save(Diferenceprix pr);
	public boolean delete(Diferenceprix pr);
	public Diferenceprix findByPrimaryKey(int pk);
	public List <Diferenceprix> findAll();
	public List <Diferenceprix> findByValue(Diferenceprix pr);
        public  boolean ActiverEtat(int pk);
        public  boolean DesactiverEtat(int pk);
    
}

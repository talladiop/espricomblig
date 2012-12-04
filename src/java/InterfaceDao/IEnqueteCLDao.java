/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDao;

import entites.EnqueteCl;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IEnqueteCLDao 
{
     public boolean update(EnqueteCl enquete);
	public boolean save(EnqueteCl enquete);
	public boolean delete(EnqueteCl enquete);
	public EnqueteCl findByPrimaryKey(int pk);
	public List <EnqueteCl> findAll();
	public List <EnqueteCl> findByValue(EnqueteCl enquete);
        public  boolean Valider(int pk);
        public  boolean ValiderFinale(int pk);
       
    
}

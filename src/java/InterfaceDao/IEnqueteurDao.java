/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDao;

import entites.Enqueteur;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IEnqueteurDao 
{
    public boolean update(Enqueteur enquete);
	public boolean save(Enqueteur enquete);
	public boolean delete(Enqueteur enquete);
	public Enqueteur findByPrimaryKey(int pk);
	public List <Enqueteur> findAll();
	public List <Enqueteur> findByValue(Enqueteur enquete);
        public  boolean activer(int pk);
        public  boolean desactiver(int pk);
    
}

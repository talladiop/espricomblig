/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.ProduitCl;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IProduitCLService
{
     public boolean update(ProduitCl pr);
	public boolean save(ProduitCl pr);
	public boolean delete(ProduitCl pr);
	public ProduitCl findByPrimaryKey(int pk);
	public List <ProduitCl> findAll();
	public List <ProduitCl> findByValue(ProduitCl pr);
    
}

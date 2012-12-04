/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.ProduitGaz;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IProduitGazService 
{
    public boolean update(ProduitGaz pr);
	public boolean save(ProduitGaz pr);
	public boolean delete(ProduitGaz pr);
	public ProduitGaz findByPrimaryKey(int pk);
	public List <ProduitGaz> findAll();
	public List <ProduitGaz> findByValue(ProduitGaz pr);
    
}

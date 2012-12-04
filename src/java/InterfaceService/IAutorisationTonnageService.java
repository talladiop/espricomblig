/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.AutorisationTonnagecl;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IAutorisationTonnageService 
{
     public boolean creerAutorisationTonnage(AutorisationTonnagecl aut);
	public void saveListAutorisationTonnage(List<AutorisationTonnagecl> eqList);
	public boolean modifier(AutorisationTonnagecl aut);
	public boolean supprimer(AutorisationTonnagecl aut);
	public AutorisationTonnagecl findByPrimaryKey(int pk);
	public List <AutorisationTonnagecl> findAll();
	public List <AutorisationTonnagecl> findByValue(AutorisationTonnagecl aut);
    
}

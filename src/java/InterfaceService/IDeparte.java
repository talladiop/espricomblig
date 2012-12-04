/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.Departement;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IDeparte 
{
    public boolean creerDepartement(Departement dp);
	public void saveListDepartement(List<Departement> dpList);
	public boolean modifier(Departement dp);
	public boolean supprimer(Departement dp);
	public Departement findByPrimaryKey(int pk);
	public List <Departement> findAll();
	public List <Departement> findByValue(Departement dp);
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.Localite;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface ILocaliteService 
{
    public boolean creerLocalite(Localite localite);
	public void saveListLocalite(List<Localite> regionList);
	public boolean modifier(Localite localite);
	public boolean supprimer(Localite localite);
	public Localite findByPrimaryKey(int pk);
	public List <Localite> findAll();
	public List <Localite> findByValue(Localite localite);
    
}

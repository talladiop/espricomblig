/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.EnqueteCl;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IEnqueteCLService 
{
     public boolean creerEnqueteCL(EnqueteCl enqueteur);
	public void saveListEnqueteCL(List<EnqueteCl> eqList);
	public boolean modifier(EnqueteCl enqueteur);
	public boolean supprimer(EnqueteCl enqueteur);
	public EnqueteCl findByPrimaryKey(int pk);
	public List <EnqueteCl> findAll();
	public List <EnqueteCl> findByValue(EnqueteCl enqueteur);
        public  boolean Valider(int pk);
        public  boolean ValiderFinale(int pk);
    
}

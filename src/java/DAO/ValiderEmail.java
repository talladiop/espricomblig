/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import InterfaceDao.ValiderEmailDao;
import org.apache.commons.validator.routines.EmailValidator;


/**
 *
 * @author Talla
 */
public class ValiderEmail extends AbstractDao implements ValiderEmailDao
{

    private static ValiderEmail instance;


	private ValiderEmail(){}

	/**
	 * @return the instance
	 */

	public synchronized static ValiderEmail getInstance()
        {
		if(instance==null){
			instance = new ValiderEmail();
		}
			return instance;
		}


    @Override
    public  synchronized boolean validateEmailAddress(String votreEmail)
    {
      EmailValidator emailValidator = EmailValidator.getInstance();
      return emailValidator.isValid(votreEmail);
    }

 /*   public static void main(String[] arg)
    {
   boolean r =  validateEmailAddress("tebbend@yahoo.fr");
   if(r == true)
   {
   System.out.println("E-mail valide");
   }
   else
   {
   System.out.println("E-mail non valide");
   }
    }
  * 
  */
}

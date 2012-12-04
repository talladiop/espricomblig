/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;

import Factory.FactoryD;
import InterfaceService.IValiderEmailService;




/**
 *
 * @author Talla
 */
public class ValiderEmailServiceImpl extends FactoryD implements IValiderEmailService
{

    private static ValiderEmailServiceImpl instance;
        /**
		 * @return the instance
		 */
		public synchronized static ValiderEmailServiceImpl getInstance() {
			if(instance==null){
				instance = new ValiderEmailServiceImpl();
			}
			return instance;
		}

		private ValiderEmailServiceImpl()
                {

		}



    @Override
    public synchronized boolean validateEmailAddress(String votreEmail)
    {
         return valideremailDao.validateEmailAddress(votreEmail);
    }


}

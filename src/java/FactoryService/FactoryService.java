/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FactoryService;


import InterfaceService.IAutorisationTonnageService;
import InterfaceService.ICuissonService;
import InterfaceService.IDeparte;
import InterfaceService.IDifferencePrixService;
import InterfaceService.IEauetforetService;
import InterfaceService.IEnqueteCLService;
import InterfaceService.IEnqueteEauxForetService;
import InterfaceService.IEnqueteEquipementService;
import InterfaceService.IEnqueteGazService;
import InterfaceService.IEnqueteurService;
import InterfaceService.IInventaireGazService;
import InterfaceService.ILocaliteService;
import InterfaceService.IProduitCLService;
import InterfaceService.IProduitGazService;
import InterfaceService.IRegionService;
import InterfaceService.IValiderEmailService;
import ServiceDAO.AutorisationTonnageServiceImpl;
import ServiceDAO.CuissonServiceImpl;
import ServiceDAO.DeparteServiceImpl;
import ServiceDAO.DifferencePrixServiceImpl;
import ServiceDAO.EauetforetServiceImpl;
import ServiceDAO.EnqueteCLServiceImpl;
import ServiceDAO.EnqueteEauxForetServiceImpl;
import ServiceDAO.EnqueteEquipementServiceImpl;
import ServiceDAO.EnqueteGazServiceImpl;
import ServiceDAO.EnqueteurServiceImpl;
import ServiceDAO.InventaireServiceImpl;
import ServiceDAO.LocaliteServiceImpl;
import ServiceDAO.ProduitCLServiceImpl;
import ServiceDAO.ProduitGazServiceImpl;
import ServiceDAO.RegionServiceImpl;
import ServiceDAO.ValiderEmailServiceImpl;
import javax.servlet.http.HttpServlet;





/**
 *
 * @author Talla
 */
public  class FactoryService extends HttpServlet
{


            public IDeparte departeServiceDao= DeparteServiceImpl.getInstance();
            public IRegionService regionServiceDao= RegionServiceImpl.getInstance();
            public ILocaliteService localiteServiceDao= LocaliteServiceImpl.getInstance();
            public IEnqueteurService enqueteurServiceDao= EnqueteurServiceImpl.getInstance();
            public IEauetforetService eauetforetServiceDao= EauetforetServiceImpl.getInstance();
            public IProduitCLService produitclServiceDao= ProduitCLServiceImpl.getInstance();
            public IProduitGazService produitgazServiceDao= ProduitGazServiceImpl.getInstance();
            public ICuissonService cuissonServiceDao= CuissonServiceImpl.getInstance();
            public IEnqueteEauxForetService enqueteEauxForetServiceDao= EnqueteEauxForetServiceImpl.getInstance();
             public IEnqueteGazService enquetegazServiceDao= EnqueteGazServiceImpl.getInstance();
              public IInventaireGazService inventaireServiceDao= InventaireServiceImpl.getInstance();
              public IAutorisationTonnageService autorisationtonnageServiceDao= AutorisationTonnageServiceImpl.getInstance();
              public IEnqueteCLService enqueteclServiceDao= EnqueteCLServiceImpl.getInstance();
               public IValiderEmailService valideremailService= ValiderEmailServiceImpl.getInstance();
              public IEnqueteEquipementService enqueteequipementSrv = EnqueteEquipementServiceImpl.getInstance();
               public IDifferencePrixService diferenceprixServiceDao = DifferencePrixServiceImpl.getInstance();
            
       
}


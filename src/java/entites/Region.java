/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entites;

import java.io.Serializable;


/**
 *
 * @author Administrateur
 */

public class Region implements Serializable {
    private static final long serialVersionUID = 1L;

    private int iDregion;
 
    private String nomregion;

    public Region() {
    }

    public Region(int iDregion) {
        this.iDregion = iDregion;
    }

    public Region(int iDregion, String nomregion) {
        this.iDregion = iDregion;
        this.nomregion = nomregion;
    }

    public int getIDregion() {
        return iDregion;
    }

    public void setIDregion(int iDregion) {
        this.iDregion = iDregion;
    }

    public String getNomregion() {
        return nomregion;
    }

    public void setNomregion(String nomregion) {
        this.nomregion = nomregion;
    }



 
}

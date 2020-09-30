/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Ookee
 */
public class ServerskiOdgovor implements Serializable{
    
    private Object odogovor;
    private String poruka;
 
    public ServerskiOdgovor() {
    }
 
    public ServerskiOdgovor(Object odogovor, String poruka) {
        this.odogovor = odogovor;
        this.poruka = poruka;
    }
 
    public String getPoruka() {
        return poruka;
    }
 
    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
 
    public Object getOdogovor() {
        return odogovor;
    }
 
    public void setOdogovor(Object odogovor) {
        this.odogovor = odogovor;
    }
    
}

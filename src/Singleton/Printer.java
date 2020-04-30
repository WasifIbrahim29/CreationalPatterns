/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

/**
 *
 * @author wasifibrahim
 * 
 *  
 */
public class Printer {
 
    private static Printer instance = null;

    protected Printer() {
    }

    private String os;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
        
        
    public static Printer getInstance() {
            if (instance == null) {
                    // To make it Thread Safe. We are using synchronized keyword.
                    synchronized (Printer.class) {
                            if (instance == null) {
                                    instance = new Printer();
                            }
                    }
            }
            return instance;
    }
}

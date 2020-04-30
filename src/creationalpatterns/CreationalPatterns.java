/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creationalpatterns;

import Builder.Email;
import Prototype.Shape;
import Prototype.ShapeCache;
import Singleton.Printer;

/**
 *
 * @author wasifibrahim
 */
public class CreationalPatterns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Creational Pattern Example
        // I have used this pattern because this pattern looked pretty unique to me and
        // it's implementation is pretty interesting as well. Also I haven't used this pattern
        // before, so I had to implement it.
        
        Email email = new Email.EmailBuilder()
            .addRecipient("wasif.ibrahim29@gmail.com")
            .setMainText("Please go away!")
            .setGreeting("Hi Corona!")
            .setClosing("Regards")
            .setTitle("End Lockdown")
            .build();
        
        
        System.out.println(email.toString());
        
        // Singleton Pattern
        // Used this pattern because it is the most simplest and easiest.
        // Also I didn't have idea about the thread-safe version of it
        // So I wanted to try that
        
        Printer printer1 =Printer.getInstance();
        
        printer1.setOs("Mac");
        
        Printer printer2 =Printer.getInstance();
        
        printer2.setOs("Windows");
        
        // Since it's same instance it would print "Windows"
        
        System.out.println(printer2.getOs());
        
        
        // Prototype Pattern
        // I used this pattern because this is also another pattern
        // which I have never used.
        // Also this is the best way to create an object when you have 
        // to consider good performance too.
        
      ShapeCache.loadCache();

      Shape clonedShape = (Shape) ShapeCache.getShape("1");
      System.out.println("Shape : " + clonedShape.getType());		

      Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
      System.out.println("Shape : " + clonedShape2.getType());		

      Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
      System.out.println("Shape : " + clonedShape3.getType());



            
    }
    
}

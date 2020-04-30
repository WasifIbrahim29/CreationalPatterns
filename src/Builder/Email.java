/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wasifibrahim
 * 
 * The scenario of a backend system that has to compose and send email is used here.
 * Creating an email might be a complex procedure.
 * You have to specify the title, set the recipients, add a greeting, and add a closing statement.
 * 
 */

// Create the class responsible for sending the email.

public class Email {
    
    private final String title;
    private final String recipients;
    private final String message;
    
    public Email(String title, String recipients, String message) {
        this.title = title;
        this.recipients = recipients;
        this.message = message;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getRecipients() {
        return recipients;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void send() {
    }

    @Override
    public String toString() {
        return "Email{" + "title=" + title + ", recipients=" + recipients + ", message=" + message + '}';
    }
    
    
    // Now create a builder class that will handle the message formatting, the recipient representation, 
    // and the creation of the Email class.
    
    public static class EmailBuilder {
        private Set<String> recipients = new HashSet();
        private String title;
        private String greeting;
        private String mainText;
        private String closing;
        
        public EmailBuilder addRecipient(String recipient) {
            this.recipients.add(recipient);
            return this;
        }
        
        public EmailBuilder removeRecipient(String recipient) {
            this.recipients.remove(recipient);
            return this;
        }
        
        public EmailBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
        
        public EmailBuilder setGreeting(String greeting) {
            this.greeting = greeting;
            return this;
        }
        
        public EmailBuilder setMainText(String mainText) {
            this.mainText = mainText;
            return this;
        }
        
        public EmailBuilder setClosing(String closing) {
            this.closing = closing;
            return this;
        }
        
        public Email build() {
            String message = greeting+"\n"+mainText+"\n"+closing;
            String recipientSection = commaSeparatedRecipients();
            return new Email(title,recipientSection,message);
        }
        
        private String commaSeparatedRecipients() {
            StringBuilder sb = new StringBuilder();
            for(String recipient:recipients) {
                sb.append(",").append(recipient);
            }
            return sb.toString().replaceFirst(",","");
        }
    }
    
    
}

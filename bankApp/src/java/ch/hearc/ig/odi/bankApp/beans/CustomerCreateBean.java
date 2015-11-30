package ch.hearc.ig.odi.bankApp.beans;

import ch.hearc.ig.odi.bankApp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Francois Gatherat <francois.gatherat@he-arc.ch>
 */
@Named(value="customerBean")
@RequestScoped
public class CustomerCreateBean implements Serializable {
    
    private int number;
    private String lastName;
    private String firstName;
        
    //private Customer cust;
    
    @Inject Services services;
    public CustomerCreateBean(){
    
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String add(){
        try {
           services.saveCustomer(number, firstName, lastName);
        
            return "success"; 
        }catch (Exception e ) {
            return "error";
        }
        
    }
    
}

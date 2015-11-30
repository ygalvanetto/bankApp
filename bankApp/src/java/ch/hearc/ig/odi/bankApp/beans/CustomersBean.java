/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.hearc.ig.odi.bankApp.beans;

import ch.hearc.ig.odi.bankApp.business.Customer;
import ch.hearc.ig.odi.bankApp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Yannick Galvanetto<yannick.galvanetto@he-arc.ch>
 */
@Named(value="customersbean")
@RequestScoped
public class CustomersBean implements Serializable {
    
    private DataModel<Customer> customersDM;
    
    @Inject Services services;
    public CustomersBean() {
    }
    
    public DataModel<Customer> getCustomersDM() {
        customersDM = new ListDataModel<>();
        customersDM.setWrappedData(services.getCustomersList());
        return customersDM;
    }
    
    public String detailCustomer (Customer cust){
        
        services.clientEdit(cust);
        
        return "detailsDuClient";
    }
    
    
    
    
}

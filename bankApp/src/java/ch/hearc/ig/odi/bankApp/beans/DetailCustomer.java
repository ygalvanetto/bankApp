/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.hearc.ig.odi.bankApp.beans;

import ch.hearc.ig.odi.bankApp.business.Account;
import ch.hearc.ig.odi.bankApp.business.Customer;
import ch.hearc.ig.odi.bankApp.services.Services;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Yannick Galvanetto<yannick.galvanetto@he-arc.ch>
 */
@Named(value="detailClient")
@SessionScoped
public class DetailCustomer implements Serializable {
    
    private int number;
    private String lastName;
    private String firstName;

    private Customer cust;
    
    private DataModel<Account> accountsDM;
    
    @Inject Services services;
    public DetailCustomer() {
        
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
    
    @PostConstruct
    public void detailCust () {
        Customer clientEdit = services.returnClientEdit();
        cust = new Customer(clientEdit.getNumber(), clientEdit.getFirstName(), clientEdit.getLastName());
        setNumber(cust.getNumber());
        setFirstName(cust.getFirstName());
        setLastName(cust.getLastName());
    }
    
    public DataModel<Account> getAccountDM() {
        accountsDM = new ListDataModel<>();
        accountsDM.setWrappedData(services.getAccountByCustomer());
        return accountsDM;
    }
    
    public String detailsCompte (Account compte){
        
        services.compteEdit(cust, compte);
        
        return "detailsDuCompte";
    }
}
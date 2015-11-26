/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.hearc.ig.odi.bankApp.beans;

import ch.hearc.ig.odi.bankApp.business.Customer;
import ch.hearc.ig.odi.bankApp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Yannick Galvanetto<yannick.galvanetto@he-arc.ch>
 */
@ManagedBean(name = "employesLISBean")
@SessionScoped
public class EmployesLISBean implements Serializable {
    
    private DataModel<Customer> lesEmployesDM;
    
    public EmployesLISBean() {
    }
    
    public DataModel<Customer> getLesEmployesDM() {
        Services srv = new Services();
        lesEmployesDM = new ListDataModel<Customer>();
        lesEmployesDM.setWrappedData(srv.getCustomersList());
        return lesEmployesDM;
    }
    
}

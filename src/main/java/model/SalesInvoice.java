/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Maro
 */
public class SalesInvoice {
    private int invoiceId;
    private Date invoiceDate;
    private String custName;
    private ArrayList<SalesInvoiceItems> items;

    

    public SalesInvoice(int invoiceId, Date invoiceDate, String CustName) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.custName = CustName;
    }

    SalesInvoice() {//To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<SalesInvoiceItems> getItems() {
        return items;
    }

    public void setItems(ArrayList<SalesInvoiceItems> items) {
        if (items == null){
         items = new ArrayList<>();
        }
        this.items = items;
    }
    
    public double getInvoiceTotal (){
        double invoiceTotal = 0.0;
        // getItems().stream().mapToDouble(item -> item.getTotal()).sum() 
        for (int i = 0; i < items.size(); i++){
            SalesInvoiceItems item = items.get(i);
            invoiceTotal += item.getTotal();
        }
        return invoiceTotal;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String CustName) {
        this.custName = CustName;
    }
    
    
}

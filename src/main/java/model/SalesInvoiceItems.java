/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Maro
 */
public class SalesInvoiceItems {
    
    int invoiceId;
    String itemName;
    double itemPrice;
    int quantity;
    SalesInvoice invoice;
    private ArrayList<SalesInvoice> parentInvoice;

    public void setParentInvoice(ArrayList<SalesInvoice> parentInvoice) {
        this.parentInvoice = parentInvoice;
    }

    public SalesInvoiceItems(String itemName, double itemPrice, int quantity, SalesInvoice invoice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.invoice = invoice;
    }

    public SalesInvoiceItems(int invoiceId, String itemName, double itemPrice, int quantity) {
        this.invoiceId = invoiceId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    SalesInvoiceItems() {
       //To change body of generated methods, choose Tools | Templates.
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }
    
    public double getTotal(){
        return itemPrice * quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SalesInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(SalesInvoice invoice) {
        this.invoice = invoice;
    }
    
    
    
}

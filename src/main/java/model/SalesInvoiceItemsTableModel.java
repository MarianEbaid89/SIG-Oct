/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maro
 */
public class SalesInvoiceItemsTableModel extends AbstractTableModel{
    
    private final ArrayList <SalesInvoiceItems> invoiceItemsList;
    private final String [] itemsColumns = 
    {"Invoice Id","Item Name" ,"Item Price", "Quantity", "Item Total"};

    public SalesInvoiceItemsTableModel(ArrayList<SalesInvoiceItems> invoiceItemsList) {
        this.invoiceItemsList = invoiceItemsList;
    }

    public ArrayList<SalesInvoiceItems> getInvoiceItemsList() {
        return invoiceItemsList;
    }

    @Override
    public int getRowCount() {
        return invoiceItemsList== null ? 0 : invoiceItemsList.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return itemsColumns.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (invoiceItemsList == null) {
            return "";
        }
        else {
        SalesInvoiceItems row = invoiceItemsList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return row.getInvoiceId();//getInvoice().getInvoiceId();
            case 1:
                return row.getItemName();
            case 2:
                return row.getItemPrice();
            case 3:
                return row.getQuantity();
            case 4:
                return row.getTotal();
            default:
                return "";
        }  //To change body of generated methods, choose Tools | Templates.
    
       }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return itemsColumns [columnIndex];
    }
    
    
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
            case 3:
                return Integer.class;
            case 4:
                return Double.class;
            default:
                return Object.class;
        }
    }    

}
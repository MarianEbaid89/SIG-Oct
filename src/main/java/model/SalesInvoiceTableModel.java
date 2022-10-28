/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maro
 */
public class SalesInvoiceTableModel extends AbstractTableModel {
    
    private final  ArrayList<SalesInvoice> invoiceList;
    private final String [] invoiceColumns = 
    {"Invoice Id","Customer Name" ,"Invoice Date", "Invoice Total"};
    private final  DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    

    public SalesInvoiceTableModel(ArrayList<SalesInvoice> invoiceList) {
        this.invoiceList = invoiceList;
    }


    public ArrayList<SalesInvoice> getInvoiceList() {
        return invoiceList;
    }    
    

    @Override
    public int getRowCount() {
        return invoiceList== null ? 0 : invoiceList.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return invoiceColumns.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SalesInvoice row = (SalesInvoice)this.invoiceList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return row.getInvoiceId();
            case 1:
                return row.getCustName();
            case 2:
                return this.dateFormat.format(row.getInvoiceDate());
            case 3:
                return row.getInvoiceTotal();
            default:
                return "";
        } //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return invoiceColumns[columnIndex];     
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Double.class;
            default:
                return Object.class;
        }
    }    

    
}


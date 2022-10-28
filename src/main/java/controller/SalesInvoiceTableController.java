/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.SalesInvoice;
import model.SalesInvoiceItems;
import model.SalesInvoiceItemsTableModel;
import view.FrmSalesInvoice;

/**
 *
 * @author HP
 */
public class SalesInvoiceTableController implements ListSelectionListener {
    
    private final FrmSalesInvoice frame;
    private final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public SalesInvoiceTableController(FrmSalesInvoice frame) {
        this.frame = frame;
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInvIndex = frame.getInvoicesTable().getSelectedRow();
        if (selectedInvIndex != -1) {
            SalesInvoice invoice = frame.getInvoicesList().get(selectedInvIndex);
            ArrayList<SalesInvoiceItems> items = invoice.getItems();
            SalesInvoiceItemsTableModel itemsTableModel = new SalesInvoiceItemsTableModel(items);
            frame.setItemsList(items);
            frame.getItemsTable().setModel(itemsTableModel);
            
            frame.getInvIdLabel().setText(Integer.toString(invoice.getInvoiceId()));
            frame.getInvDateTxtField().setText(dateFormat.format(invoice.getInvoiceDate()));
            frame.getNameTextField().setText(invoice.getCustName());
            frame.getInvTotalLabel().setText("" + invoice.getInvoiceTotal());
            
            
        }

    }
    
    
    
}

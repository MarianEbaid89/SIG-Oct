/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.FileOperations;
import model.SalesInvoice;
import model.SalesInvoiceTableModel;
import view.DiaCreateInvoice;
import view.DiaCreateItem;
import view.FrmSalesInvoice;

/**
 *
 * @author HP
 */
public class SalesInvoiceController implements ActionListener {
    
    private final FrmSalesInvoice frame;
    private DiaCreateInvoice invoiceDialog;
    private DiaCreateItem itemDialog;

    public SalesInvoiceController(FrmSalesInvoice frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "createInv":
                createInvoice();
                break;
            case "deleteInv":
                deleteInvoice();
                break;
            case "createItem":
                createItem();
                break;
            case "deleteItem":
                deleteItem();
                break;
            case "load":
                frame.setInvoicesList(null);
                FileOperations fileOperations = new FileOperations(frame);
                ArrayList<SalesInvoice> invoice = fileOperations.loadFile();
                frame.setTableCellAlignment(frame.getInvoicesTable());
                frame.getInvoiceModel().fireTableDataChanged();
                break;
            case "save":
                FileOperations operation = new FileOperations(frame);
                operation.writeFile();
                break;
        }
    }
    
    private void createInvoice() {
        invoiceDialog = new DiaCreateInvoice(frame);
        invoiceDialog.setVisible(true);
        invoiceDialog.resize(500,300);
    }
    private void createItem() {
        itemDialog = new DiaCreateItem(frame);
        itemDialog.setVisible(true);
        itemDialog.resize(500,300);
    }
    
    private void deleteInvoice() {
         int record = frame.getInvoicesTable().getSelectedRow();
        if(record != -1){
            frame.getInvoicesList().remove(record);
            frame.getInvoiceModel().fireTableDataChanged();
        }
    }
    private void deleteItem() {
         int record = frame.getItemsTable().getSelectedRow();
        if(record != -1){
            frame.getItemsList().remove(record);
            frame.getInvoiceModel().fireTableDataChanged();
        }
    }
}

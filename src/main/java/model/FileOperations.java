/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;
import javax.swing.table.TableModel;

import view.FrmSalesInvoice;

/**
 *
 * @author HP
 */
public class FileOperations {
    
    private final FrmSalesInvoice frame;
    private final  DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    
    public FileOperations(FrmSalesInvoice frame) {
        this.frame = frame;
    }
    
    public ArrayList<SalesInvoice>  readFile() {
        String invoicesPath = System.getProperty("user.dir")+"/src/main/resources/data/InvoiceHeader.csv";
        File invoicesFile = new File(invoicesPath);
        FileReader invoicesReader;
        CSVReader invoicesCsvReader ;
        ArrayList<SalesInvoice> invoices = null;

        String itemsPath = System.getProperty("user.dir")+"/src/main/resources/data/InvoiceLine.csv";
        File itemsFile = new File(itemsPath);
        FileReader itemsReader;
        CSVReader itemsCsvReader ;
        ArrayList<SalesInvoiceItems> items ;

	try {
            invoicesReader = new FileReader(invoicesFile);
            invoicesCsvReader = new CSVReader(invoicesReader);
            List<String[]> invoicesRecords = invoicesCsvReader.readAll();
            Iterator<String[]> iter = invoicesRecords.iterator();
            invoices = new ArrayList<>();
            while (iter.hasNext()) {
                String[] line = iter.next();
                String id = line[0];
                int invoiceId = Integer.parseInt(id);
                String date = line[1];
                Date invoiceDate = dateFormat.parse(date);
                String custName = line[2];
                SalesInvoice salesInvoice = new SalesInvoice(invoiceId,invoiceDate,custName);
                invoices.add(salesInvoice);
            }
            System.out.println(invoices.toString());
            frame.setInvoicesList(invoices);
            ////////////////////Items Read//////////////
            itemsReader = new FileReader(itemsFile);
            itemsCsvReader = new CSVReader(itemsReader);
            List<String[]> itesmRecords = itemsCsvReader.readAll();
            Iterator<String[]> it = itesmRecords.iterator();
            items = new ArrayList<>();
        SalesInvoice inv = null;
        while (it.hasNext()) {
                String[] line = it.next();
                String id = line[0];
                int invId = Integer.parseInt(id);
                String itemName =(line[1]);
                String price = line[2];
                double itemPrice =(Double.parseDouble(price));
                String quan = line[3];
                int quantity = Integer.parseInt(quan);
                inv = frame.getInvoiceById(invId);
                SalesInvoiceItems invoiceItem = new SalesInvoiceItems(invId,itemName,itemPrice,quantity,inv);
                items.add(invoiceItem);
                inv.setItems(items);
            }

            SalesInvoiceTableModel invoiceTableModel = new  SalesInvoiceTableModel (invoices);
            frame.setInvoiceModel(invoiceTableModel);
            frame.getInvoicesTable().setModel(invoiceTableModel);
            System.out.println(items);
            itemsCsvReader.close();
        }
        catch (ParseException ex) {
            System.out.println("ParseException");
        }
        catch (FileNotFoundException  e) {
            System.out.println("file not found");
        }
        catch (IOException e) {
                System.out.println("Wrong File");
                JOptionPane.showMessageDialog(this.frame, "Wrong File");
            }
        catch (CsvValidationException ex) {
            System.out.println("CsvValidationException");
        }
        catch (CsvException ex) {
            System.out.println("CsvException");
        }
        return invoices;
    }

    public ArrayList<SalesInvoiceItems>  readItemsFile(SalesInvoice inv) {


        String itemsPath = System.getProperty("user.dir")+"/src/main/resources/data/InvoiceLine.csv";
        File itemsFile = new File(itemsPath);
        FileReader itemsReader;
        CSVReader itemsCsvReader ;
        ArrayList<SalesInvoiceItems> items = null;

        try {
            ////////////////////Items Read//////////////
            itemsReader = new FileReader(itemsFile);
            itemsCsvReader = new CSVReader(itemsReader);
            List<String[]> itesmRecords = itemsCsvReader.readAll();
            Iterator<String[]> it = itesmRecords.iterator();
            items = new ArrayList<>();
            //SalesInvoice invo = null;
            while (it.hasNext()) {
                String[] line = it.next();
                String id = line[0];
                int invId = Integer.parseInt(id);
                String itemName =(line[1]);
                String price = line[2];
                double itemPrice =(Double.parseDouble(price));
                String quan = line[3];
                int quantity = Integer.parseInt(quan);
                //inv = frame.getInvoiceById(invId);
                for(int i = 0;i<items.size();i++) {
                    if (inv.getInvoiceId() == items.get(i).getInvoiceId()) {
                        SalesInvoiceItems invoiceItem = new SalesInvoiceItems(invId, itemName, itemPrice, quantity);
                        items.add(invoiceItem);
                    }
                }
                //inv.setItems(items);
            }

            //SalesInvoiceTableModel invoiceTableModel = new  SalesInvoiceTableModel (invoices);
            //frame.setInvoiceModel(invoiceTableModel);
            //frame.getInvoicesTable().setModel(invoiceTableModel);
            System.out.println(items);
            itemsCsvReader.close();
        }
        catch (FileNotFoundException  e) {
            System.out.println("file not found");
        }
        catch (IOException e) {
            System.out.println("Wrong File");
            JOptionPane.showMessageDialog(this.frame, "Wrong File");
        }
        catch (CsvValidationException ex) {
            System.out.println("CsvValidationException");
        }
        catch (CsvException ex) {
            System.out.println("CsvException");
        }
        return items;
    }

    public ArrayList<SalesInvoice>  loadFile() {
        frame.setInvoicesList(null);
        frame.setItemsList(null);
        JFileChooser fileChooser = new JFileChooser();
	int result;
        File invoicesFile;
        FileReader invoicesReader;
        CSVReader invoicesCsvReader = null;
	ArrayList<SalesInvoice> invoices = null;
        File itemsFile;
        FileReader itemsReader;
        CSVReader itemsCsvReader = null;
        ArrayList<SalesInvoiceItems> items ;
        JOptionPane.showMessageDialog(frame, "Please insert invoice header File then invoice line File"); 
        try{
            result = fileChooser.showOpenDialog(frame);
            if(result == JFileChooser.APPROVE_OPTION){
                invoicesFile = fileChooser.getSelectedFile();
                invoicesReader = new FileReader(invoicesFile);
                invoicesCsvReader = new CSVReader(invoicesReader);
                List<String[]> invoicesRecords = invoicesCsvReader.readAll();
                Iterator<String[]> iter = invoicesRecords.iterator();
                //List<String> invoicesRecords= Files.readAllLines(invoicesPath);
                invoices = new ArrayList<>();
                while (iter.hasNext()) {
                    String[] line = iter.next();
                    String id = line[0];
                    int invoiceId = Integer.parseInt(id);
                    String date = line[1];
                    Date invoiceDate = dateFormat.parse(date);
                    String custName = line[2];
                    SalesInvoice salesInvoice = new SalesInvoice(invoiceId,invoiceDate,custName);
                    invoices.add(salesInvoice);
                }
                
                frame.setInvoicesList(invoices);
				
                ///////Items/////////////
                result = fileChooser.showOpenDialog(frame);
                if(result == JFileChooser.APPROVE_OPTION){
                    itemsFile = fileChooser.getSelectedFile();
                    itemsReader = new FileReader(itemsFile);
                    itemsCsvReader = new CSVReader(itemsReader);
                    //Path itemsPath = Paths.get(itemsFile.getAbsolutePath());
                    //List<String> itemsRecords= Files.readAllLines(itemsPath);
                    List<String[]> itesmRecords = itemsCsvReader.readAll();
                    Iterator<String[]> it = itesmRecords.iterator();
                    items = new ArrayList<>();
                    while (it.hasNext()) {
                        String[] line = it.next();
                        String id = line[0];
                        int invId = Integer.parseInt(id);
                        String itemName =(line[1]);
                        String price = line[2];
                        double itemPrice =(Double.parseDouble(price));
                        String quan = line[3];
                        int quantity = Integer.parseInt(quan);
                        //SalesInvoice inv = frame.getInvoiceById(invId);
                        //SalesInvoiceItems invoiceItem = new SalesInvoiceItems(itemName,itemPrice,quantity,inv);
                        //inv.getItems().add(invoiceItem);
                        //items.add(invoiceItem);
                        //inv.setItems(items);
                    }
                }
                
                SalesInvoiceTableModel invoiceTableModel = new  SalesInvoiceTableModel (invoices);
                frame.setInvoiceModel(invoiceTableModel);
                frame.getInvoicesTable().setModel(invoiceTableModel);

            }
            itemsCsvReader.close();
            invoicesCsvReader.close();
        }
        catch (ParseException ex) {
            System.out.println("ParseException");
        }
        catch (FileNotFoundException  e) {
            System.out.println("file not found");
        }
        catch (IOException e) {
                System.out.println("Wrong File");
                JOptionPane.showMessageDialog(this.frame, "Wrong File");
            } 
        catch (CsvValidationException ex) {
            System.out.println("CsvValidationException");
        } 
        catch (CsvException ex) {
            System.out.println("CsvException");
        }
        return invoices;
    }
    

    
    public void  writeFile() {
        TableModel invoicesModel ;
        TableModel itemsModel ;
        JTable invoicesTable = frame.getInvoicesTable();
        JTable itemsTable = frame.getItemsTable();
        String invoicesPath = System.getProperty("user.dir")+"/src/main/resources/data/InvoiceHeader.csv";
        String itemsPath = System.getProperty("user.dir")+"/src/main/resources/data/InvoiceLine.csv";
        FileWriter invoicesWriter;
        FileWriter itemsWriter;
        try {
            invoicesModel = invoicesTable.getModel();
            invoicesWriter = new FileWriter(new File(invoicesPath));
            for (int i = 0; i < invoicesModel.getColumnCount(); i++) {
                invoicesWriter.write(invoicesModel.getColumnName(i) + ",");
            }
            invoicesWriter.write("\n");
            for (int i = 0; i < invoicesModel.getRowCount(); i++) {
                for (int j = 0; j < invoicesModel.getColumnCount(); j++) {
                    invoicesWriter.write(invoicesModel.getValueAt(i, j).toString() + ",");
                }
                invoicesWriter.write("\n");
            }
            invoicesWriter.close();

            itemsModel = itemsTable.getModel();
            itemsWriter = new FileWriter(new File(itemsPath));
            for (int i = 0; i < itemsModel.getColumnCount(); i++) {
                itemsWriter.write(itemsModel.getColumnName(i) + ",");
            }
            itemsWriter.write("\n");
            for (int i = 0; i < itemsModel.getRowCount(); i++) {
                for (int j = 0; j < itemsModel.getColumnCount(); j++) {
                    itemsWriter.write(itemsModel.getValueAt(i, j).toString() + ",");
                }
                itemsWriter.write("\n");
            }
            itemsWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* public SalesInvoiceItems getItemsById(int id){
        for(SalesInvoiceItems item : readItemsFile()){
            if(item.getInvoiceId()==id){
                return item;
            }
        }
        return null;
    }*/

    
}

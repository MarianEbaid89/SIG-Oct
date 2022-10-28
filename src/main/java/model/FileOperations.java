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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
        CSVReader invoicesCsvReader = null;
        ArrayList<SalesInvoice> invoices = null;
        
        String itemsPath = System.getProperty("user.dir")+"/src/main/resources/data/InvoiceLine.csv";
        File itemsFile = new File(itemsPath);
        FileReader itemsReader;
        CSVReader itemsCsvReader = null;
        ArrayList<SalesInvoiceItems> items = null;
        
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
            while (it.hasNext()) {
                String[] line = it.next();
                String id = line[0];
                int invId = Integer.parseInt(id);
                String itemName =(line[1]);
                String price = line[2];
                double itemPrice =(Double.parseDouble(price));
                String quan = line[3];
                int quantity = Integer.parseInt(quan);
                SalesInvoice inv = getInvoiceById(invId);
                SalesInvoiceItems invoiceItem = new SalesInvoiceItems(itemName,itemPrice,quantity,inv);
                items.add(invoiceItem);
                inv.setItems(items);
                
            }
            frame.setItemsList(items);
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
        ArrayList<SalesInvoiceItems> items = null;
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
                        SalesInvoice inv = getInvoiceById(invId);
                        SalesInvoiceItems invoiceItem = new SalesInvoiceItems(itemName,itemPrice,quantity,inv);
                        //inv.getItems().add(invoiceItem);
                        items.add(invoiceItem);
                        inv.setItems(items);
                    }
                }
                
                SalesInvoiceTableModel invoiceTableModel = new  SalesInvoiceTableModel (invoices);
                frame.setInvoiceModel(invoiceTableModel);
                frame.getInvoicesTable().setModel(invoiceTableModel);
                itemsCsvReader.close();
            }
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
    
    public SalesInvoice getInvoiceById(int id){
         for(SalesInvoice inv : frame.getInvoicesList()){
             if(inv.getInvoiceId()==id){
                 return inv;
             }
         }
         return null;
     }
    
    public void  writeFile(ArrayList<SalesInvoice> invoices) {
        String invoicesPath = System.getProperty("user.dir")+"/src/main/resources/data/InvoiceHeader.csv";
        File invoicesFile = new File(invoicesPath);
        FileWriter invoicesWriter;
        CSVWriter invoicesCsvWriter;
        String itemsPath = System.getProperty("user.dir")+"/src/main/resources/data/InvoiceLine.csv";
        File itemsFile = new File(itemsPath);
        FileWriter itemsWriter;
        CSVWriter itemsCsvWriter;
        ArrayList<SalesInvoiceItems> items ;
        ArrayList<SalesInvoiceItems> item = null ;
        ArrayList<SalesInvoice> invoice = null ;
	try {
            //invoices = frame.getInvoicesList();
            Iterator<SalesInvoice> iter = invoices.iterator();
            while (iter.hasNext()) {
                    SalesInvoice line = iter.next();
                    int invoiceId = line.getInvoiceId();
                    Date invoiceDate = line.getInvoiceDate();
                    String custName = line.getCustName();
                    SalesInvoice inv = new SalesInvoice(invoiceId,invoiceDate,custName);
                invoice.add(inv);
                }
            invoicesWriter = new FileWriter(invoicesFile);
            invoicesCsvWriter = new CSVWriter(invoicesWriter);
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(invoicesCsvWriter).build();
            beanToCsv.write(invoice);
            frame.setInvoicesList(null);
            frame.setInvoicesList(invoice);
            
            items = frame.getItemsList();
            Iterator<SalesInvoiceItems> it = items.iterator();
            while (it.hasNext()) {
                    SalesInvoiceItems line = it.next();
                    int invoiceId = line.getInvoiceId();
                    String itemName = line.getItemName();
                    double itemPrice = line.getItemPrice();
                    int quantity = line.getQuantity();
                    SalesInvoiceItems invoiceItem = new SalesInvoiceItems(invoiceId,itemName,itemPrice,quantity);
                    item.add(invoiceItem);
                }
            itemsWriter = new FileWriter(itemsFile);
            itemsCsvWriter = new CSVWriter(itemsWriter);
            StatefulBeanToCsv beansToCsv = new StatefulBeanToCsvBuilder(itemsCsvWriter).build();
            beansToCsv.write(item);
            frame.setItemsList(null);
            frame.setItemsList(item);
            itemsCsvWriter.close();
            invoicesWriter.close();
            System.out.println(invoices.toString());
        } 
        catch (FileNotFoundException  e) {
            System.out.println("file not found");
        }
        catch (IOException e) {
                System.out.println("Wrong File");
                JOptionPane.showMessageDialog(this.frame, "Wrong File");
            } 
        catch (CsvException ex) {
            System.out.println("CsvException");
        }
    }
    
    
}

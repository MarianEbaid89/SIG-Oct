/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.SalesInvoiceController;
import controller.SalesInvoiceTableController;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.FileOperations;
import model.SalesInvoice;
import model.SalesInvoiceItems;
import model.SalesInvoiceItemsTableModel;
import model.SalesInvoiceTableModel;

/**
 *
 * @author Maro
 */
public class FrmSalesInvoice extends javax.swing.JFrame {
    
    SalesInvoiceTableModel invoiceModel;
    SalesInvoiceItemsTableModel itemsModel;
    private ArrayList<SalesInvoice> invoicesList;
    private ArrayList<SalesInvoiceItems>  itemsList ;
    private SalesInvoiceTableController tableListener = new SalesInvoiceTableController(this);
    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
    private SalesInvoiceController control = new SalesInvoiceController(this);

    public SalesInvoiceItemsTableModel getItemsModel() {
        return itemsModel;
    }
   

    /**
     * Creates new form FrmSalesInvoice
     */
    public FrmSalesInvoice() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        invoicesTable.getSelectionModel().addListSelectionListener(tableListener);
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invIdLabel = new javax.swing.JLabel();
        invDateTxtField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        invTotalLabel = new javax.swing.JLabel();
        createInvBtn = new javax.swing.JButton();
        deleteInvBtn = new javax.swing.JButton();
        createItemBtn = new javax.swing.JButton();
        deleteItemBtn = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Invoice Id", "Customer Name", "Invoice Date", "Invoice Total"
            }
        ));
        invoicesTable.setSurrendersFocusOnKeystroke(true);
        invoicesTable.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(invoicesTable);

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Invoice Id", "Item Name", "Item Price", "Quantity", "Item Total"
            }
        ));
        jScrollPane2.setViewportView(itemsTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Invoice Id");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Invoice Date");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Customer Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Invoice Total");

        invIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        invIdLabel.setText("          ");

        invDateTxtField.setEditable(false);
        invDateTxtField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nameTextField.setEditable(false);
        nameTextField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        invTotalLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        invTotalLabel.setText("         ");

        createInvBtn.setText("Create New Invoice");
        createInvBtn.setToolTipText("");
        createInvBtn.setActionCommand("createInv");
        createInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvBtnActionPerformed(evt);
            }
        });

        deleteInvBtn.setText("Delete Invoice");
        deleteInvBtn.setActionCommand("deleteInv");
        deleteInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvBtnActionPerformed(evt);
            }
        });

        createItemBtn.setText("Create New Item");
        createItemBtn.setActionCommand("createItem");
        createItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createItemBtnActionPerformed(evt);
            }
        });

        deleteItemBtn.setText("Delete Item");
        deleteItemBtn.setActionCommand("deleteItem");
        deleteItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemBtnActionPerformed(evt);
            }
        });

        jMenu3.setText("File");

        loadMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, 0));
        loadMenuItem.setText("Load");
        loadMenuItem.setActionCommand("load");
        loadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(loadMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setText("Save");
        saveMenuItem.setActionCommand("save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(saveMenuItem);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(invIdLabel))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(invDateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(invTotalLabel)
                                .addComponent(nameTextField))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(createInvBtn)
                .addGap(98, 98, 98)
                .addComponent(deleteInvBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createItemBtn)
                .addGap(79, 79, 79)
                .addComponent(deleteItemBtn)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invIdLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(invDateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invTotalLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createInvBtn)
                    .addComponent(deleteInvBtn)
                    .addComponent(createItemBtn)
                    .addComponent(deleteItemBtn))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMenuItemActionPerformed
        // TODO add your handling code here:
        control.actionPerformed(evt);
    }//GEN-LAST:event_loadMenuItemActionPerformed

    private void createInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createInvBtnActionPerformed
        // TODO add your handling code here:
        control.actionPerformed(evt);
    }//GEN-LAST:event_createInvBtnActionPerformed

    private void createItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createItemBtnActionPerformed
        // TODO add your handling code here:
        control.actionPerformed(evt);  
    }//GEN-LAST:event_createItemBtnActionPerformed

    private void deleteInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvBtnActionPerformed
        // TODO add your handling code here:
        control.actionPerformed(evt);
    }//GEN-LAST:event_deleteInvBtnActionPerformed

    private void deleteItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemBtnActionPerformed
        // TODO add your handling code here:
        control.actionPerformed(evt);
    }//GEN-LAST:event_deleteItemBtnActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        // TODO add your handling code here:
        control.actionPerformed(evt);
    }//GEN-LAST:event_saveMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmSalesInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSalesInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSalesInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSalesInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmSalesInvoice mainFrame = new FrmSalesInvoice();
                mainFrame.setVisible(true);
                
                FileOperations fileOperations = new FileOperations(mainFrame);                
                ArrayList<SalesInvoice> invoice = fileOperations.readFile();
                mainFrame.setTableCellAlignment(mainFrame.getInvoicesTable());
                mainFrame.getInvoiceModel().fireTableDataChanged();
                
                ////////
                /*
                ArrayList<SalesInvoiceItems> item = opera.readItemsFile();
                mainFrame.setItemsList(item);
                SalesInvoiceItemsTableModel itemTable = new SalesInvoiceItemsTableModel(item);
                mainFrame.setItemsModel(itemTable);
                mainFrame.getItemsTable().setModel(itemTable);
                //mainFrame.getInvoiceModel().fireTableDataChanged();
                mainFrame.setTableCellAlignment(mainFrame.getItemsTable());*/
                
            }
        });
    }



    public SalesInvoiceTableModel getInvoiceModel() {
        return invoiceModel;
    }
   

    public void setInvoicesList(ArrayList<SalesInvoice> invoicesList) {
        this.invoicesList = invoicesList;
    }

    public ArrayList<SalesInvoice> getInvoicesList() {
        return invoicesList;
    }

    public void setItemsList(ArrayList<SalesInvoiceItems> itemsList) {
        this.itemsList = itemsList;
    }

    public JTable getInvoicesTable() {
        return invoicesTable;
    }

    public JTable getItemsTable() {
        return itemsTable;
    }

    public void setInvoiceModel(SalesInvoiceTableModel invoiceModel) {
        this.invoiceModel = invoiceModel;
    }

    public void setItemsModel(SalesInvoiceItemsTableModel itemsModel) {
        this.itemsModel = itemsModel;
    }

    public JTextField getInvDateTxtField() {
        return invDateTxtField;
    }

    public JLabel getInvIdLabel() {
        return invIdLabel;
    }

    public JLabel getInvTotalLabel() {
        return invTotalLabel;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public ArrayList<SalesInvoiceItems> getItemsList() {
        return itemsList;
    }

    public SalesInvoice getInvoiceById(int id){
        for(SalesInvoice inv : this.getInvoicesList()){
            if(inv.getInvoiceId()==id){
                return inv;
            }
        }
        return null;
    }
    
    public void setTableCellAlignment(JTable t) {
      renderer.setHorizontalAlignment(SwingConstants.CENTER );
      for (int i=0; i<t.getColumnCount();i++){
         t.setDefaultRenderer(t.getColumnClass(i),renderer);
      }
      t.updateUI();
      
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvBtn;
    private javax.swing.JButton createItemBtn;
    private javax.swing.JButton deleteInvBtn;
    private javax.swing.JButton deleteItemBtn;
    private javax.swing.JTextField invDateTxtField;
    private javax.swing.JLabel invIdLabel;
    private javax.swing.JLabel invTotalLabel;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JTable itemsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables


}

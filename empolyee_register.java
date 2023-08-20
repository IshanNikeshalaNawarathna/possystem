/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author user
 */
public class empolyee_register extends javax.swing.JFrame {
    
    private HashMap<String, String> emloyeeMap = new HashMap<>();
    private HashMap<String, String> genderMap = new HashMap<>();

    /**
     * Creates new form empolyee_register
     */
    public empolyee_register() {
        initComponents();
        loadGender();
        loadType();
        loadEmloyee();
    }
    
    private void claer() {
        email.setText("");
        firstName.setText("");
        lastName.setText("");
        mbile.setText("");
        password.setText("");
        typeCombox.setSelectedIndex(0);
        genderCombox.setSelectedIndex(0);
        nic.setText("");
        email.requestFocus();
    }
    
    private void loadType() {
        
        try {
            
            ResultSet resultSet = MySQL.execute("SELECT * FROM `employee_type`");
            
            Vector<String> value = new Vector<>();
            value.add("Select");
            
            while (resultSet.next()) {
                value.add(resultSet.getString("name"));
                emloyeeMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }
            
            typeCombox.setModel(new DefaultComboBoxModel<>(value));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void loadGender() {
        
        try {
            
            ResultSet resultSet = MySQL.execute("SELECT * FROM `gender`");
            
            Vector<String> value = new Vector<>();
            value.add("Select");
            
            while (resultSet.next()) {
                value.add(resultSet.getString("name"));
                genderMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }
            
            genderCombox.setModel(new DefaultComboBoxModel<>(value));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void loadEmloyee() {
        
        try {
            
            ResultSet resultSet = MySQL.execute("SELECT * FROM `employee` "
                    + "INNER JOIN `employee_type` ON `employee`.`employee_type_id`=`employee_type`.`id`"
                    + " INNER JOIN `gender` ON `employee`.`gender_id`=`gender`.`id`");
            
            DefaultTableModel model = (DefaultTableModel) empolyeeTable.getModel();
            model.setRowCount(0);
            
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("last_name"));
                vector.add(resultSet.getString("nic"));
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("gender.name"));
                vector.add(resultSet.getString("password"));
                vector.add(resultSet.getString("employee_type.name"));
                
                model.addRow(vector);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        mbile = new javax.swing.JTextField();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        nic = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        typeCombox = new javax.swing.JComboBox<>();
        genderCombox = new javax.swing.JComboBox<>();
        insertButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        empolyeeTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Eamil");

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("NIC");

        jLabel5.setText("Mobile");

        jLabel6.setText("Type");

        jLabel7.setText("Password");

        jLabel8.setText("Gender");

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        typeCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        genderCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        insertButton.setText("Create Account");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update Account");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reload.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insertButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(typeCombox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(password))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(genderCombox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(email)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(mbile, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbile, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        empolyeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "First Name", "Last Name", "NIC", "Mobile", "Gender", "Password", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        empolyeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empolyeeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(empolyeeTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:

        String em = email.getText();
        String fname = firstName.getText();
        String lname = lastName.getText();
        String n = nic.getText();
        String mobile_number = mbile.getText();
        String gen = String.valueOf(genderCombox.getSelectedItem());
        String pass = String.valueOf(password.getPassword());
        String ty = String.valueOf(typeCombox.getSelectedItem());
        
        try {
            
            if (em.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Type your Email ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (!em.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                JOptionPane.showMessageDialog(this, "Invalid Email Address", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Type your First Name ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (lname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Type your Last Name ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (n.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Type your NIC ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (mobile_number.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Type your Mobile ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (!mobile_number.matches("^07[01245678]{1}[0-9]{7}$")) {
                JOptionPane.showMessageDialog(this, "Invalid Mobile ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Type your Password", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (gen.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Type your Gender ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (ty.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Type your Type ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else {
                
                ResultSet resultSet = MySQL.execute("SELECT * FROM `employee` WHERE `email`='" + em + "' OR `nic`='" + n + "' OR `mobile`='" + mobile_number + "'");
                
                if (resultSet.next()) {
                    
                    if (resultSet.getString("email").equals(em)) {
                        JOptionPane.showMessageDialog(this, "Email already use. ", "warning", JOptionPane.INFORMATION_MESSAGE);
                    } else if (resultSet.getString("mobile").equals(mobile_number)) {
                        JOptionPane.showMessageDialog(this, "Mobile already use. ", "warning", JOptionPane.INFORMATION_MESSAGE);
                    } else if (resultSet.getString("nic").equals(n)) {
                        JOptionPane.showMessageDialog(this, "NIC already use. ", "warning", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                } else {
                    
                    Date date = new Date();
                    SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
                    
                    MySQL.execute("INSERT INTO `employee`(`email`,`first_name`,`last_name`,`nic`,`mobile`,`employee_type_id`,`date_registerd`,`password`,`gender_id`) VALUES ('" + em + "','" + fname + "','" + lname + "','" + n + "','" + mobile_number + "','" + emloyeeMap.get(ty) + "','" + SDF.format(date) + "','" + pass + "','" + genderMap.get(gen) + "')");
                    
                    loadEmloyee();
                    claer();
                    
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }//GEN-LAST:event_insertButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:

        String em = email.getText();
        String fname = firstName.getText();
        String lname = lastName.getText();
        String n = nic.getText();
        String mobile_number = mbile.getText();
        String gen = String.valueOf(genderCombox.getSelectedItem());
        String pass = String.valueOf(password.getPassword());
        String ty = String.valueOf(typeCombox.getSelectedItem());
        
        try {
            
            if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Type your First Name ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (lname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Type your Last Name ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (n.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Type your NIC ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (mobile_number.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Type your Mobile ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (!mobile_number.matches("^07[01245678]{1}[0-9]{7}$")) {
                JOptionPane.showMessageDialog(this, "Invalid Mobile ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Type your Password", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (gen.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Type your Gender ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (ty.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Type your Type ", "warning", JOptionPane.INFORMATION_MESSAGE);
            } else {
                
                ResultSet resultSet = MySQL.execute("SELECT * FROM `employee` WHERE `nic`='" + n + "' OR `mobile`='" + mobile_number + "'");
                
                boolean checkResult = false;
                
                if (resultSet.next()) {
                    
                    if (resultSet.getString("email").equals(email)) {
                        JOptionPane.showMessageDialog(this, "Mobile or NIC ", "warning", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        checkResult = true;
                    }
                    
                } else {
                    checkResult = true;
                }
                
                if (checkResult) {
                    MySQL.execute("UPDATE `employee` SET"
                            + " `first_name`='" + fname + "',`last_name`='" + lname + "',`nic`='" + n + "',`mobile`='" + mobile_number + "',`employee_type_id`='" + emloyeeMap.get(ty) + "',`password`='" + pass + "',`gender_id`='" + genderMap.get(gen) + "' WHERE `email`='" + em + "'");
                    
                    loadEmloyee();
                    claer();
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }//GEN-LAST:event_updateButtonActionPerformed

    private void empolyeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empolyeeTableMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {
            int row = empolyeeTable.getSelectedRow();
            String em = String.valueOf(empolyeeTable.getValueAt(row, 0));
            
            AddressView addressView = new AddressView(this, true, em);
            addressView.setVisible(true);
        }
        
        int row = empolyeeTable.getSelectedRow();
        
        String em = String.valueOf(empolyeeTable.getValueAt(row, 0));
        email.setText(em);
        email.setEditable(false);
        
        String fname = String.valueOf(empolyeeTable.getValueAt(row, 1));
        firstName.setText(fname);
        
        String lname = String.valueOf(empolyeeTable.getValueAt(row, 2));
        lastName.setText(lname);
        
        String n = String.valueOf(empolyeeTable.getValueAt(row, 3));
        nic.setText(n);
        
        String mobile_number = String.valueOf(empolyeeTable.getValueAt(row, 4));
        mbile.setText(mobile_number);
        
        String pass = String.valueOf(empolyeeTable.getValueAt(row, 6));
        password.setText(pass);
        
        String ty = String.valueOf(empolyeeTable.getValueAt(row, 7));
        typeCombox.setSelectedItem(ty);
        
        String gen = String.valueOf(empolyeeTable.getValueAt(row, 5));
        genderCombox.setSelectedItem(gen);
        

    }//GEN-LAST:event_empolyeeTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        claer();
        email.setEditable(true);
        empolyeeTable.clearSelection();
        

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacDarkLaf.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new empolyee_register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JTable empolyeeTable;
    private javax.swing.JTextField firstName;
    private javax.swing.JComboBox<String> genderCombox;
    private javax.swing.JButton insertButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastName;
    private javax.swing.JTextField mbile;
    private javax.swing.JTextField nic;
    private javax.swing.JPasswordField password;
    private javax.swing.JComboBox<String> typeCombox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
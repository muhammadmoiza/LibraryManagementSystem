/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS.UI;

import LMS.Borrower;
import LMS.*;
/**
 *
 * @author itsme
 */
public class ClerkInfoUI extends javax.swing.JFrame {

    GUIHandler handler;
    Person person;
    /**
     * Creates new form ClerkInfoUI
     */
    public ClerkInfoUI(GUIHandler handler, Person person) {
        this.handler = handler;
        this.person = person;
        initComponents();
        this.AL.setName("Error");
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
        jLabel1 = new javax.swing.JLabel();
        CIDTL = new javax.swing.JLabel();
        CIDTB = new javax.swing.JTextField();
        VIB = new javax.swing.JButton();
        AL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1500, 1000));
        setMinimumSize(new java.awt.Dimension(1500, 1000));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("CLERK INFO");

        CIDTL.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CIDTL.setText("CLERK ID:");

        CIDTB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CIDTB.setName("ClerkIDTextBox"); // NOI18N

        VIB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        VIB.setText("VIEW INFO");
        VIB.setName("ViewInfoButton"); // NOI18N
        VIB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIBActionPerformed(evt);
            }
        });

        AL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TA.setEditable(false);
        TA.setColumns(20);
        TA.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        TA.setRows(5);
        jScrollPane1.setViewportView(TA);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("< BACK");
        jButton2.setName("BackButton"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jButton2)
                        .addGap(420, 420, 420)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(563, 563, 563)
                        .addComponent(CIDTL)
                        .addGap(18, 18, 18)
                        .addComponent(CIDTB, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(VIB)
                        .addGap(672, 672, 672))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(AL)
                        .addGap(724, 724, 724))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 128, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CIDTL)
                    .addComponent(CIDTB, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(VIB)
                .addGap(31, 31, 31)
                .addComponent(AL)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VIBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIBActionPerformed
        AL.setText("");
        if(!CIDTB.getText().equals("")){
            if(CIDTB.getText().matches("[0-9]+")){
                if(CIDTB.getText().length() <= 10){
                    Clerk ck = handler.lib.findClerk(Integer.parseInt(CIDTB.getText()));
                    if(ck != null){
                        String string = ck.toString();
                        TA.setText(string);
                    }
                    else{
                        AL.setText("Invalid clerk id");
                    }
                }
                else{
                    AL.setText("Word limit of field(s) exceeded");
                }
            }
            else{
                AL.setText("ID can only be numbers");
            }
        }
        else{
            AL.setText("Field(s) cannot be empty");
        }
    }//GEN-LAST:event_VIBActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(person.getClass().getSimpleName().equals("Librarian")){
            this.hide();
            new LibrarianUI(handler, person).setVisible(true);
        }
        else if(person.getClass().getSimpleName().equals("Clerk")){
            this.hide();
            new ClerkUI(handler, person).setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(person.getClass().getSimpleName().equals("Librarian")){
            CIDTB.setVisible(true);
            CIDTL.setVisible(true);
            VIB.setVisible(true);
        }
        else if(person.getClass().getSimpleName().equals("Clerk")){
            CIDTB.setVisible(false);
            CIDTL.setVisible(false);
            VIB.setVisible(false);
            TA.setText(((Clerk) person).toString());
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(ClerkInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClerkInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClerkInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClerkInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ClerkInfoUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AL;
    private javax.swing.JTextField CIDTB;
    private javax.swing.JLabel CIDTL;
    private javax.swing.JTextArea TA;
    private javax.swing.JButton VIB;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

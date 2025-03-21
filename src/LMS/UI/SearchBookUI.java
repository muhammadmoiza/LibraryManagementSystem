/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS.UI;

import LMS.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author itsme
 */
public class SearchBookUI extends javax.swing.JFrame {

    GUIHandler handler;
    Person person;
    /**
     * Creates new form SearchBookUI
     */
    public SearchBookUI(GUIHandler handler, Person person) {
        this.handler = handler;
        this.person = person;
        initComponents();
        this.AL.setName("Error");
    }

    private SearchBookUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TL = new javax.swing.JLabel();
        BNTB = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA = new javax.swing.JTextArea();
        TRB = new javax.swing.JRadioButton();
        ARB = new javax.swing.JRadioButton();
        SRB = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        AL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1500, 1000));
        setMinimumSize(new java.awt.Dimension(1500, 1000));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("SEARCH BOOK");

        TL.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TL.setText("BOOK TITLE:");

        BNTB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BNTB.setName("SearchFilterTextBox"); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.setName("SearchButton"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TA.setEditable(false);
        TA.setColumns(20);
        TA.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        TA.setRows(5);
        TA.setName("SearchBox"); // NOI18N
        jScrollPane1.setViewportView(TA);

        TRB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TRB.setText(" BY TITLE");
        TRB.setName("TitleRadioButton"); // NOI18N
        TRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRBActionPerformed(evt);
            }
        });

        ARB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ARB.setText(" BY AUTHOR");
        ARB.setName("AuthorRadioButton"); // NOI18N
        ARB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ARBActionPerformed(evt);
            }
        });

        SRB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        SRB.setText(" BY SUBJECT");
        SRB.setName("SubjectRadioButton"); // NOI18N
        SRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SRBActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("< BACK");
        jButton2.setName("BackButton"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        AL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 111, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(TL)
                        .addGap(39, 39, 39)
                        .addComponent(BNTB, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(500, 500, 500))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jButton2)
                        .addGap(359, 359, 359)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(TRB)
                        .addGap(136, 136, 136)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ARB)
                                .addGap(106, 106, 106)
                                .addComponent(SRB))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(705, 705, 705)
                        .addComponent(AL)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TRB)
                    .addComponent(ARB)
                    .addComponent(SRB))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TL)
                    .addComponent(BNTB, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AL)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TA.setText("");
        if(!BNTB.getText().equals("")){
            String result = "";
            if(TRB.isSelected()){
                if(BNTB.getText().length() <= 50){
                    try {
                        result = handler.lib.searchForBooks(BNTB.getText(), 1);
                    } catch (IOException ex) {
                        Logger.getLogger(SearchBookUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    AL.setText("Word limit of field(s) exceeded");
                }
            }
            else if(ARB.isSelected()){
                if(BNTB.getText().length() <= 60){
                    try {
                        result = handler.lib.searchForBooks(BNTB.getText(), 3);
                    } catch (IOException ex) {
                        Logger.getLogger(SearchBookUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    AL.setText("Word limit of field(s) exceeded");
                }
            }
            else if(SRB.isSelected()){
                if(BNTB.getText().length() <= 40){
                    try {
                        result = handler.lib.searchForBooks(BNTB.getText(), 2);
                    } catch (IOException ex) {
                        Logger.getLogger(SearchBookUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    AL.setText("Word limit of field(s) exceeded");
                }
            }
            if(!result.equals("")){
                TA.setText(result);
            }
        }else{
            TA.setText("No field(s) can be empty");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        BG.add(TRB);
        BG.add(ARB);
        BG.add(SRB);
        
        TRB.setSelected(true);
        
        TL.setText("BOOK TITLE:");
    }//GEN-LAST:event_formWindowOpened

    private void TRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRBActionPerformed
        TL.setText("BOOK TITLE:");
        
        BNTB.setText("");
    }//GEN-LAST:event_TRBActionPerformed

    private void ARBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ARBActionPerformed
        TL.setText("BOOK AUTHOR:");
        
        BNTB.setText("");
    }//GEN-LAST:event_ARBActionPerformed

    private void SRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SRBActionPerformed
        TL.setText("BOOK SUBJECT:");
        
        BNTB.setText("");
    }//GEN-LAST:event_SRBActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                                 
        if(person.getClass().getSimpleName().equals("Librarian")){
            this.hide();
            new LibrarianUI(handler, person).setVisible(true);
        }
        else if(person.getClass().getSimpleName().equals("Clerk")){
            this.hide();
            new ClerkUI(handler, person).setVisible(true);
        }
        else{
            this.hide();
            new BorrowerUI(handler, person).setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SearchBookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchBookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchBookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchBookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchBookUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AL;
    private javax.swing.JRadioButton ARB;
    private javax.swing.ButtonGroup BG;
    private javax.swing.JTextField BNTB;
    private javax.swing.JRadioButton SRB;
    private javax.swing.JTextArea TA;
    private javax.swing.JLabel TL;
    private javax.swing.JRadioButton TRB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

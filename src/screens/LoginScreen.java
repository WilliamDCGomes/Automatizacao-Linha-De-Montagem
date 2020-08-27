package screens;

import commands.Hash;
import conexaobd.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alunos
 */
public class LoginScreen extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form LoginScreen
     */
    public LoginScreen() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDoLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JLabel();
        inoutLogin = new javax.swing.JTextField();
        txtPassword = new javax.swing.JLabel();
        inputPassword = new javax.swing.JPasswordField();
        buttonLogin = new javax.swing.JButton();
        buttonControlPanel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        txtDoLogin.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        txtDoLogin.setText("FAÇA LOGIN");

        txtLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtLogin.setText("LOGIN");

        inoutLogin.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtPassword.setText("SENHA");

        inputPassword.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N

        buttonLogin.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonLogin.setText("LOGAR");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        buttonControlPanel.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonControlPanel.setText("PAÍNEL DE CONTROLE");
        buttonControlPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonControlPanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLogin)
                            .addComponent(txtPassword))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inoutLogin)
                            .addComponent(inputPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonLogin)
                        .addGap(35, 35, 35)
                        .addComponent(buttonControlPanel)))
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDoLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(txtDoLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin)
                    .addComponent(inoutLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword)
                    .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLogin)
                    .addComponent(buttonControlPanel))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(577, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonControlPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonControlPanelActionPerformed
        ConfirmationScreen confirmationScreen = new ConfirmationScreen();
        confirmationScreen.setVisible(true);
    }//GEN-LAST:event_buttonControlPanelActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        Hash hash = new Hash();
        String login = hash.DoHash(inoutLogin.getText());
        String password = hash.DoHash(inputPassword.getText());
        System.out.println("Seu login: " + login + "\nSua senha: " + password);
        WorkerScreen workerScreen = new WorkerScreen();
        this.dispose();
        workerScreen.setVisible(true);
    }//GEN-LAST:event_buttonLoginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonControlPanel;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JTextField inoutLogin;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JLabel txtDoLogin;
    private javax.swing.JLabel txtLogin;
    private javax.swing.JLabel txtPassword;
    // End of variables declaration//GEN-END:variables
}

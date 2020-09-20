/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import commands.Hash;
import connectionbd.ConnectionModule;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author willi
 */
public class CadastreNewStation extends javax.swing.JFrame {
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pst2 = null;
    ResultSet rs2 = null;
    /**
     * Creates new form CadastreNewLine
     */
    public CadastreNewStation() {
        initComponents();
        ConnectionModule connect = new ConnectionModule();
        connection = connect.getConnectionMySQL();
        URL adress = getClass().getResource("/images/icone.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(adress);
        this.setIconImage(icon);
    }
    int x =0;
    private void add(){
        String sql = "insert into stations(id,login,passwors)values(?,?,MD5(MD5(MD5(?))))";
        try {
            Hash hash = new Hash();
            pst = connection.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(outputNumberOfStation.getText()));
            pst.setString(2,inputLogin.getText());
            pst.setString(3,hash.DoHash(inputPassword.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"ESTAÇÃO CADASTRADA COM SUCESSO");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private boolean hasStation(){
        String sqlnome = "select * from stations where id = ?";
        try {
            pst2 = connection.prepareStatement(sqlnome);
            pst2.setString(1,outputNumberOfStation.getText());
            rs2 = pst2.executeQuery();
            if (rs2.next()) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return false;
    }
    private void localeID(){
        String sqlnome = "select id from stations order by id desc limit 1";
        try {
            pst = connection.prepareStatement(sqlnome);
            rs = pst.executeQuery();
            if (rs.next()) {
                outputNumberOfStation.setText(Integer.toString(Integer.parseInt(rs.getString(1))+1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
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

        txtNewStation = new javax.swing.JLabel();
        txtNumberOfStation = new javax.swing.JLabel();
        txtLogin = new javax.swing.JLabel();
        txtPassword = new javax.swing.JLabel();
        outputNumberOfStation = new javax.swing.JTextField();
        inputLogin = new javax.swing.JTextField();
        txtConfirmPassword = new javax.swing.JLabel();
        inputPassword = new javax.swing.JPasswordField();
        inputConfirmPassword = new javax.swing.JPasswordField();
        buttonSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova Estação");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        txtNewStation.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtNewStation.setText("NOVA ESTAÇÃO");

        txtNumberOfStation.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtNumberOfStation.setText("NÚMERO DA ESTAÇÃO");

        txtLogin.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtLogin.setText("LOGIN");

        txtPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtPassword.setText("SENHA");

        outputNumberOfStation.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        outputNumberOfStation.setText("1");
        outputNumberOfStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputNumberOfStationActionPerformed(evt);
            }
        });
        outputNumberOfStation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputNumberOfStationKeyPressed(evt);
            }
        });

        inputLogin.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        inputLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputLoginKeyPressed(evt);
            }
        });

        txtConfirmPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtConfirmPassword.setText("CONFIRMAR SENHA");

        inputPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        inputPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputPasswordKeyPressed(evt);
            }
        });

        inputConfirmPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        inputConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputConfirmPasswordKeyPressed(evt);
            }
        });

        buttonSave.setText("SALVAR");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });
        buttonSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonSaveKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNewStation)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSave)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLogin)
                            .addComponent(txtNumberOfStation, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPassword)
                            .addComponent(txtConfirmPassword))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputPassword)
                            .addComponent(inputLogin)
                            .addComponent(inputConfirmPassword)
                            .addComponent(outputNumberOfStation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(txtNewStation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumberOfStation)
                    .addComponent(outputNumberOfStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin)
                    .addComponent(inputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword)
                    .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmPassword)
                    .addComponent(inputConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(buttonSave)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(401, 421));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(x==0){
            x++;
            inputLogin.requestFocus();
            localeID();
        }
        
    }//GEN-LAST:event_formWindowActivated

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        if(inputLogin.getText().equals("")||inputPassword.getText().equals("")||inputConfirmPassword.getText().equals("")){
            JOptionPane.showMessageDialog(null, "POR FAVOR, PREENCHA TODOS OS CAMPOS");
        }
        else if(inputPassword.getText().equals(inputConfirmPassword.getText())){
            if(hasStation()){
                JOptionPane.showMessageDialog(null, "ESSA ESTAÇÃO JÁ ESTÁ CADASTRADA NO BANCO DE DADOS");
            }
            else{
                add();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "AS SENHAS NÃO CONFEREM");
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void outputNumberOfStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputNumberOfStationActionPerformed
        
    }//GEN-LAST:event_outputNumberOfStationActionPerformed

    private void outputNumberOfStationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputNumberOfStationKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            inputLogin.requestFocus();
        }
    }//GEN-LAST:event_outputNumberOfStationKeyPressed

    private void inputLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputLoginKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            inputPassword.requestFocus();
        }
    }//GEN-LAST:event_inputLoginKeyPressed

    private void inputPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputPasswordKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            inputConfirmPassword.requestFocus();
        }
    }//GEN-LAST:event_inputPasswordKeyPressed

    private void inputConfirmPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputConfirmPasswordKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(inputLogin.getText().equals("")||inputPassword.getText().equals("")||inputConfirmPassword.getText().equals("")){
                JOptionPane.showMessageDialog(null, "POR FAVOR, PREENCHA TODOS OS CAMPOS");
            }
            else if(inputPassword.getText().equals(inputConfirmPassword.getText())){
                if(hasStation()){
                    JOptionPane.showMessageDialog(null, "ESSA ESTAÇÃO JÁ ESTÁ CADASTRADA NO BANCO DE DADOS");
                }
                else{
                    add();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "AS SENHAS NÃO CONFEREM");
            }
        }
    }//GEN-LAST:event_inputConfirmPasswordKeyPressed

    private void buttonSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonSaveKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(inputLogin.getText().equals("")||inputPassword.getText().equals("")||inputConfirmPassword.getText().equals("")){
                JOptionPane.showMessageDialog(null, "POR FAVOR, PREENCHA TODOS OS CAMPOS");
            }
            else if(inputPassword.getText().equals(inputConfirmPassword.getText())){
                if(hasStation()){
                    JOptionPane.showMessageDialog(null, "ESSA ESTAÇÃO JÁ ESTÁ CADASTRADA NO BANCO DE DADOS");
                }
                else{
                    add();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "AS SENHAS NÃO CONFEREM");
            }
        }
    }//GEN-LAST:event_buttonSaveKeyPressed

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
            java.util.logging.Logger.getLogger(CadastreNewStation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastreNewStation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastreNewStation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastreNewStation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastreNewStation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSave;
    private javax.swing.JPasswordField inputConfirmPassword;
    private javax.swing.JTextField inputLogin;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JTextField outputNumberOfStation;
    private javax.swing.JLabel txtConfirmPassword;
    private javax.swing.JLabel txtLogin;
    private javax.swing.JLabel txtNewStation;
    private javax.swing.JLabel txtNumberOfStation;
    private javax.swing.JLabel txtPassword;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import functions.ExportDataCSV;
import functions.GetDate;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class CommandScreen extends javax.swing.JFrame {

    /**
     * Creates new form CommandScreen
     */
    public CommandScreen() {
        initComponents();
        URL adress = getClass().getResource("/images/icone.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(adress);
        this.setIconImage(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCadastreNewStation = new javax.swing.JLabel();
        txtControlPanel = new javax.swing.JLabel();
        txtEditStation = new javax.swing.JLabel();
        txtChangePasswordControlPanel = new javax.swing.JLabel();
        txtDayPlan = new javax.swing.JLabel();
        txtDelay = new javax.swing.JLabel();
        txtExportTable = new javax.swing.JLabel();
        txtHourHistoric = new javax.swing.JLabel();
        buttonLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paínel de Controle");
        setResizable(false);

        txtCadastreNewStation.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txtCadastreNewStation.setText("CADASTRAR UMA NOVA ESTAÇÃO");
        txtCadastreNewStation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCadastreNewStationMouseClicked(evt);
            }
        });

        txtControlPanel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtControlPanel.setText("PAÍNEL DE CONTROLE");

        txtEditStation.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txtEditStation.setText("EDITAR ESTAÇÕES");
        txtEditStation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEditStationMouseClicked(evt);
            }
        });

        txtChangePasswordControlPanel.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txtChangePasswordControlPanel.setText("MUDAR SENHA DO PAÍNEL DE CONTROLE");
        txtChangePasswordControlPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtChangePasswordControlPanelMouseClicked(evt);
            }
        });

        txtDayPlan.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txtDayPlan.setText("PLANEJAMENTO DIÁRIO");
        txtDayPlan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDayPlanMouseClicked(evt);
            }
        });

        txtDelay.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txtDelay.setText("ATRASOS");
        txtDelay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDelayMouseClicked(evt);
            }
        });

        txtExportTable.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txtExportTable.setText("EXPORTAR TABELA COMPARATIVA");
        txtExportTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtExportTableMouseClicked(evt);
            }
        });

        txtHourHistoric.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txtHourHistoric.setText("HISTÓRICO DE HORÁRIOS");
        txtHourHistoric.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHourHistoricMouseClicked(evt);
            }
        });

        buttonLogout.setText("LOGOUT");
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogoutActionPerformed(evt);
            }
        });
        buttonLogout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonLogoutKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtControlPanel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonLogout)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDelay)
                            .addComponent(txtExportTable)
                            .addComponent(txtDayPlan)
                            .addComponent(txtHourHistoric, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChangePasswordControlPanel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtEditStation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCadastreNewStation)))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(txtControlPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDayPlan)
                    .addComponent(txtCadastreNewStation))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDelay)
                    .addComponent(txtEditStation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHourHistoric)
                    .addComponent(txtChangePasswordControlPanel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(txtExportTable)
                .addGap(27, 27, 27)
                .addComponent(buttonLogout)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(738, 347));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogoutActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "DESEJA FAZER LOGOUT?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
        if(confirma==JOptionPane.YES_OPTION){
            LoginScreen loginScreen = new LoginScreen();
            Frame[] frames = getFrames(); 
            for (int i = 0; i < frames.length; i++){ 
                frames[i].dispose(); 
            }
            loginScreen.setVisible(true);
        }
    }//GEN-LAST:event_buttonLogoutActionPerformed

    private void txtDayPlanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDayPlanMouseClicked
        NewAndCheckPlanning newAndCheckPlanning = new NewAndCheckPlanning();
        newAndCheckPlanning.setVisible(true);
    }//GEN-LAST:event_txtDayPlanMouseClicked

    private void txtDelayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDelayMouseClicked
        CheckDelayScreen checkDelayScreen = new CheckDelayScreen();
        checkDelayScreen.setVisible(true);
    }//GEN-LAST:event_txtDelayMouseClicked

    private void txtHourHistoricMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHourHistoricMouseClicked
        HourHistoricScreen hourHistoricScreen = new HourHistoricScreen();
        hourHistoricScreen.setVisible(true);
    }//GEN-LAST:event_txtHourHistoricMouseClicked

    private void txtCadastreNewStationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCadastreNewStationMouseClicked
        CadastreNewStation cadastreNewStation = new CadastreNewStation();
        cadastreNewStation.setVisible(true);
    }//GEN-LAST:event_txtCadastreNewStationMouseClicked

    private void txtEditStationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEditStationMouseClicked
        EditStation editStation = new EditStation();
        editStation.setVisible(true);
    }//GEN-LAST:event_txtEditStationMouseClicked

    private void txtChangePasswordControlPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtChangePasswordControlPanelMouseClicked
        ChangePasswordControlPanel changePasswordControlPanel = new ChangePasswordControlPanel();
        changePasswordControlPanel.setVisible(true);
    }//GEN-LAST:event_txtChangePasswordControlPanelMouseClicked

    private void buttonLogoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonLogoutKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            int confirma = JOptionPane.showConfirmDialog(null, "DESEJA FAZER LOGOUT?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
            if(confirma==JOptionPane.YES_OPTION){
                LoginScreen loginScreen = new LoginScreen();
                Frame[] frames = getFrames(); 
                for (int i = 0; i < frames.length; i++){ 
                    frames[i].dispose(); 
                }
                loginScreen.setVisible(true);
            }
        }
    }//GEN-LAST:event_buttonLogoutKeyPressed

    private void txtExportTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExportTableMouseClicked
        Export export = new Export();
        export.setVisible(true);
    }//GEN-LAST:event_txtExportTableMouseClicked

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
            java.util.logging.Logger.getLogger(CommandScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CommandScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CommandScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CommandScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CommandScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogout;
    private javax.swing.JLabel txtCadastreNewStation;
    private javax.swing.JLabel txtChangePasswordControlPanel;
    private javax.swing.JLabel txtControlPanel;
    private javax.swing.JLabel txtDayPlan;
    private javax.swing.JLabel txtDelay;
    private javax.swing.JLabel txtEditStation;
    private javax.swing.JLabel txtExportTable;
    private javax.swing.JLabel txtHourHistoric;
    // End of variables declaration//GEN-END:variables
}

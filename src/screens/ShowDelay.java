package screens;
import conexaobd.ModuloConexao;
import functions.TimeDifference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Alunos
 */
public class ShowDelay extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form ShowDelay
     */
    public ShowDelay() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    int x=0;
    public int idDelay;
    TimeDifference timeDifference = new TimeDifference();
    private void getDelay(){
        String sql = "select reasonDelay, shot, dats from delay where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1,idDelay);
            rs=pst.executeQuery();
            if(rs.next()){
                outputReasonDelay.setText(rs.getString(1));
                outputShot.setText(rs.getString(2));
                outputDayOfDelay.setText(rs.getString(3));
                outputDurationDelay.setText(timeDifference.getDifference(outputBeginDelay.getText(), outputEndDelay.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void getPreviusDelay(){
        String sql = "select * from delay where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1,--idDelay);
            rs=pst.executeQuery();
            if(rs.next()){
                outputStation.setText(rs.getString(6));
                outputTypeDelay.setText(rs.getString(5));
                outputShot.setText(rs.getString(2));
                outputBeginDelay.setText(rs.getString(7));
                outputEndDelay.setText(rs.getString(8));
                outputReasonDelay.setText(rs.getString(4));
                outputDurationDelay.setText(timeDifference.getDifference(outputBeginDelay.getText(), outputEndDelay.getText()));
            }
            else{
                idDelay++;
                JOptionPane.showMessageDialog(null, "NÃO HÁ MAIS ATRASOS PARA SER MOSTRADO");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void getNextDelay(){
        String sql = "select * from delay where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1,++idDelay);
            rs=pst.executeQuery();
            if(rs.next()){
                outputStation.setText(rs.getString(6));
                outputTypeDelay.setText(rs.getString(5));
                outputShot.setText(rs.getString(2));
                outputBeginDelay.setText(rs.getString(7));
                outputEndDelay.setText(rs.getString(8));
                outputReasonDelay.setText(rs.getString(4));
                outputDurationDelay.setText(timeDifference.getDifference(outputBeginDelay.getText(), outputEndDelay.getText()));
            }
            else{
                idDelay--;
                JOptionPane.showMessageDialog(null, "NÃO HÁ MAIS ATRASOS PARA SER MOSTRADO");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void remove(){
        int confirma = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA APAGAR ESSE ATRASO?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
        if(confirma==JOptionPane.YES_OPTION){
            String sql = "delete from delay where shot=? and dats=? and localeOfDelay=? and beginningDelay=? and endingDelay=?";
            try {
                pst=conexao.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(outputShot.getText()));
                pst.setString(2, outputDayOfDelay.getText());
                pst.setInt(3, Integer.parseInt(outputStation.getText()));
                pst.setString(4, outputBeginDelay.getText());
                pst.setString(5, outputEndDelay.getText());
                int apagado = pst.executeUpdate();
                if(apagado>0){
                    JOptionPane.showMessageDialog(null,"ATRASO APAGADA COM SUCESSO");
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "ATRASO NÃO LOCALIZADO NO BANCO DE DADOS");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
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

        txtDelay = new javax.swing.JLabel();
        txtStation = new javax.swing.JLabel();
        outputStation = new javax.swing.JTextField();
        txtTypeDelay = new javax.swing.JLabel();
        outputTypeDelay = new javax.swing.JTextField();
        txtDurationDelay = new javax.swing.JLabel();
        outputDurationDelay = new javax.swing.JFormattedTextField();
        txtReasonDelay = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputReasonDelay = new javax.swing.JTextArea();
        previousDelay = new javax.swing.JLabel();
        nextDelay = new javax.swing.JLabel();
        txtShot = new javax.swing.JLabel();
        outputShot = new javax.swing.JTextField();
        txtDurationDelay1 = new javax.swing.JLabel();
        outputBeginDelay = new javax.swing.JFormattedTextField();
        txtDurationDelay2 = new javax.swing.JLabel();
        outputEndDelay = new javax.swing.JFormattedTextField();
        txtDayOfDelay = new javax.swing.JLabel();
        outputDayOfDelay = new javax.swing.JFormattedTextField();
        buttonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atraso");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        txtDelay.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        txtDelay.setText("ATRASO");

        txtStation.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtStation.setText("Estação");

        outputStation.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        outputStation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputStationKeyPressed(evt);
            }
        });

        txtTypeDelay.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtTypeDelay.setText("Tipo do Atraso");

        outputTypeDelay.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        outputTypeDelay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputTypeDelayKeyPressed(evt);
            }
        });

        txtDurationDelay.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtDurationDelay.setText("Duração do Atraso");

        try {
            outputDurationDelay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        outputDurationDelay.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        outputDurationDelay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputDurationDelayKeyPressed(evt);
            }
        });

        txtReasonDelay.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtReasonDelay.setText("Motivo do Atraso");

        outputReasonDelay.setColumns(20);
        outputReasonDelay.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        outputReasonDelay.setRows(5);
        jScrollPane1.setViewportView(outputReasonDelay);

        previousDelay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LeftArrow.png"))); // NOI18N
        previousDelay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previousDelayMouseClicked(evt);
            }
        });

        nextDelay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RightArrow.png"))); // NOI18N
        nextDelay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextDelayMouseClicked(evt);
            }
        });

        txtShot.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtShot.setText("Rodagem");

        outputShot.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        outputShot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputShotKeyPressed(evt);
            }
        });

        txtDurationDelay1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtDurationDelay1.setText("Começo do Atraso");

        try {
            outputBeginDelay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        outputBeginDelay.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        outputBeginDelay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputBeginDelayKeyPressed(evt);
            }
        });

        txtDurationDelay2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtDurationDelay2.setText("Finalização do Serviço");

        try {
            outputEndDelay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        outputEndDelay.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        outputEndDelay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputEndDelayKeyPressed(evt);
            }
        });

        txtDayOfDelay.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtDayOfDelay.setText("Dia do Atraso");

        try {
            outputDayOfDelay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        outputDayOfDelay.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        outputDayOfDelay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputDayOfDelayKeyPressed(evt);
            }
        });

        buttonDelete.setText("APAGAR");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        buttonDelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonDeleteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(outputStation, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTypeDelay)
                            .addComponent(outputTypeDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtReasonDelay)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previousDelay)
                        .addGap(29, 29, 29)
                        .addComponent(nextDelay)
                        .addGap(27, 27, 27)
                        .addComponent(buttonDelete))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDurationDelay1)
                                .addComponent(outputBeginDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDurationDelay2)
                                        .addComponent(outputEndDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDurationDelay)
                                        .addComponent(outputDurationDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(outputShot, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtShot, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtDayOfDelay)
                                    .addGap(18, 18, 18)
                                    .addComponent(outputDayOfDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDelay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(txtDelay)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStation)
                            .addComponent(txtTypeDelay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outputStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputTypeDelay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtShot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputShot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDurationDelay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputDurationDelay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDurationDelay2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outputEndDelay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDurationDelay1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outputBeginDelay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReasonDelay)
                    .addComponent(txtDayOfDelay)
                    .addComponent(outputDayOfDelay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(previousDelay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nextDelay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(buttonDelete)))
                .addGap(12, 12, 12))
        );

        setSize(new java.awt.Dimension(710, 518));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(x==0){
            x++;
            getDelay();
        }
    }//GEN-LAST:event_formWindowActivated

    private void previousDelayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousDelayMouseClicked
        getPreviusDelay();
    }//GEN-LAST:event_previousDelayMouseClicked

    private void nextDelayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextDelayMouseClicked
        getNextDelay();
    }//GEN-LAST:event_nextDelayMouseClicked

    private void outputStationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputStationKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            outputTypeDelay.requestFocus();
        }
    }//GEN-LAST:event_outputStationKeyPressed

    private void outputTypeDelayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputTypeDelayKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            outputShot.requestFocus();
        }
    }//GEN-LAST:event_outputTypeDelayKeyPressed

    private void outputShotKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputShotKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            outputBeginDelay.requestFocus();
        }
    }//GEN-LAST:event_outputShotKeyPressed

    private void outputBeginDelayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputBeginDelayKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            outputEndDelay.requestFocus();
        }
    }//GEN-LAST:event_outputBeginDelayKeyPressed

    private void outputEndDelayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputEndDelayKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            outputDurationDelay.requestFocus();
        }
    }//GEN-LAST:event_outputEndDelayKeyPressed

    private void outputDurationDelayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputDurationDelayKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            outputDayOfDelay.requestFocus();
        }
    }//GEN-LAST:event_outputDurationDelayKeyPressed

    private void outputDayOfDelayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputDayOfDelayKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            outputReasonDelay.requestFocus();
        }
    }//GEN-LAST:event_outputDayOfDelayKeyPressed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        remove();
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonDeleteKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            remove();
        }
    }//GEN-LAST:event_buttonDeleteKeyPressed

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
            java.util.logging.Logger.getLogger(ShowDelay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowDelay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowDelay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowDelay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowDelay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nextDelay;
    public static javax.swing.JFormattedTextField outputBeginDelay;
    public static javax.swing.JFormattedTextField outputDayOfDelay;
    private javax.swing.JFormattedTextField outputDurationDelay;
    public static javax.swing.JFormattedTextField outputEndDelay;
    private javax.swing.JTextArea outputReasonDelay;
    public static javax.swing.JTextField outputShot;
    public static javax.swing.JTextField outputStation;
    public static javax.swing.JTextField outputTypeDelay;
    private javax.swing.JLabel previousDelay;
    private javax.swing.JLabel txtDayOfDelay;
    private javax.swing.JLabel txtDelay;
    private javax.swing.JLabel txtDurationDelay;
    private javax.swing.JLabel txtDurationDelay1;
    private javax.swing.JLabel txtDurationDelay2;
    private javax.swing.JLabel txtReasonDelay;
    private javax.swing.JLabel txtShot;
    private javax.swing.JLabel txtStation;
    private javax.swing.JLabel txtTypeDelay;
    // End of variables declaration//GEN-END:variables
}

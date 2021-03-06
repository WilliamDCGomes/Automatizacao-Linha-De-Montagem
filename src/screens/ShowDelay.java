package screens;
import connectionbd.ConnectionModule;
import functions.TimeDifference;
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
public class ShowDelay extends javax.swing.JFrame {
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int x=0;
    public int idDelay;
    TimeDifference timeDifference = new TimeDifference();
    
    public ShowDelay() {
        initComponents();
        ConnectionModule connect = new ConnectionModule();
        connection = connect.getConnectionMySQL();
        URL adress = getClass().getResource("/images/icon.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(adress);
        this.setIconImage(icon);
    }
    private void getDelay(){
        String sql = "select reasonDelay, shot, dats from delay where id = ?";
        try {
            pst = connection.prepareStatement(sql);
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
        String sql = "SELECT id, localeOfDelay, typeDelay, shot, beginningDelay, endingDelay, reasonDelay, dats FROM delay WHERE id = (SELECT MAX(id) FROM delay WHERE id < ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idDelay);
            rs=pst.executeQuery();
            if(rs.next()){
                idDelay= rs.getInt(1);
                outputStation.setText(rs.getString(2));
                outputTypeDelay.setText(rs.getString(3));
                outputShot.setText(rs.getString(4));
                outputBeginDelay.setText(rs.getString(5));
                outputEndDelay.setText(rs.getString(6));
                outputReasonDelay.setText(rs.getString(7));
                outputDayOfDelay.setText(rs.getString(8));
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
        String sql = "SELECT id, localeOfDelay, typeDelay, shot, beginningDelay, endingDelay, reasonDelay, dats FROM delay WHERE id = (SELECT MIN(id) FROM delay WHERE id > ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idDelay);
            rs=pst.executeQuery();
            if(rs.next()){
                idDelay= rs.getInt(1);
                outputStation.setText(rs.getString(2));
                outputTypeDelay.setText(rs.getString(3));
                outputShot.setText(rs.getString(4));
                outputBeginDelay.setText(rs.getString(5));
                outputEndDelay.setText(rs.getString(6));
                outputReasonDelay.setText(rs.getString(7));
                outputDayOfDelay.setText(rs.getString(8));
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
                pst=connection.prepareStatement(sql);
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
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        txtDelay.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        txtDelay.setText("ATRASO");
        getContentPane().add(txtDelay);
        txtDelay.setBounds(290, 30, 103, 33);

        txtStation.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtStation.setText("Estação");
        getContentPane().add(txtStation);
        txtStation.setBounds(46, 88, 69, 24);

        outputStation.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        outputStation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputStationKeyPressed(evt);
            }
        });
        getContentPane().add(outputStation);
        outputStation.setBounds(46, 118, 69, 24);

        txtTypeDelay.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtTypeDelay.setText("Tipo do Atraso");
        getContentPane().add(txtTypeDelay);
        txtTypeDelay.setBounds(251, 88, 127, 24);

        outputTypeDelay.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        outputTypeDelay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputTypeDelayKeyPressed(evt);
            }
        });
        getContentPane().add(outputTypeDelay);
        outputTypeDelay.setBounds(251, 118, 104, 24);

        txtDurationDelay.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtDurationDelay.setText("Duração do Atraso");
        getContentPane().add(txtDurationDelay);
        txtDurationDelay.setBounds(487, 154, 161, 24);

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
        getContentPane().add(outputDurationDelay);
        outputDurationDelay.setBounds(487, 184, 106, 24);

        txtReasonDelay.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtReasonDelay.setText("Motivo do Atraso");
        getContentPane().add(txtReasonDelay);
        txtReasonDelay.setBounds(46, 224, 148, 24);

        outputReasonDelay.setColumns(20);
        outputReasonDelay.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        outputReasonDelay.setRows(5);
        outputReasonDelay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputReasonDelayKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(outputReasonDelay);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(46, 257, 602, 156);

        previousDelay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LeftArrow.png"))); // NOI18N
        previousDelay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previousDelayMouseClicked(evt);
            }
        });
        getContentPane().add(previousDelay);
        previousDelay.setBounds(46, 419, 48, 48);

        nextDelay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RightArrow.png"))); // NOI18N
        nextDelay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextDelayMouseClicked(evt);
            }
        });
        getContentPane().add(nextDelay);
        nextDelay.setBounds(123, 419, 48, 48);

        txtShot.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtShot.setText("Rodagem");
        getContentPane().add(txtShot);
        txtShot.setBounds(487, 88, 84, 24);

        outputShot.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        outputShot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputShotKeyPressed(evt);
            }
        });
        getContentPane().add(outputShot);
        outputShot.setBounds(487, 118, 84, 24);

        txtDurationDelay1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtDurationDelay1.setText("Começo do Atraso");
        getContentPane().add(txtDurationDelay1);
        txtDurationDelay1.setBounds(46, 158, 162, 24);

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
        getContentPane().add(outputBeginDelay);
        outputBeginDelay.setBounds(46, 188, 106, 24);

        txtDurationDelay2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtDurationDelay2.setText("Finalização do Serviço");
        getContentPane().add(txtDurationDelay2);
        txtDurationDelay2.setBounds(252, 158, 196, 24);

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
        getContentPane().add(outputEndDelay);
        outputEndDelay.setBounds(252, 188, 106, 24);

        txtDayOfDelay.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtDayOfDelay.setText("Dia do Atraso");
        getContentPane().add(txtDayOfDelay);
        txtDayOfDelay.setBounds(252, 224, 117, 24);

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
        getContentPane().add(outputDayOfDelay);
        outputDayOfDelay.setBounds(387, 225, 106, 24);

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
        getContentPane().add(buttonDelete);
        buttonDelete.setBounds(198, 427, 90, 25);

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

    private void outputReasonDelayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputReasonDelayKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputReasonDelayKeyPressed

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

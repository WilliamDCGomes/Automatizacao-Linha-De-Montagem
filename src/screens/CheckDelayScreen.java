package screens;
import connectionbd.ConnectionModule;
import functions.GetDate;
import functions.GetYesterdayDate;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author willi
 */
public class CheckDelayScreen extends javax.swing.JFrame {
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form CheckDelayScreen
     */
    public CheckDelayScreen() {
        initComponents();
        ConnectionModule connect = new ConnectionModule();
        connection = connect.getConnectionMySQL();
        URL adress = getClass().getResource("/images/icon.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(adress);
        this.setIconImage(icon);
    }
    int x=0;
    GetDate getDate = new GetDate();
    GetYesterdayDate getYesterdayDate= new GetYesterdayDate();
    private void searchDelays(String begin, String end){
        String sql = "select id, localeOfDelay as 'Estação', typeDelay as 'Tipo do Atraso', beginningDelay as 'Começo do Atraso', endingDelay as 'Finalização do Serviço', dats as 'Data' from delay where dats between ? and ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,begin);
            pst.setString(2,end);
            inputFirstDateFilter.setText(getDate.informDate());
            inputSecondDateFilter.setText(getDate.informDate());
            rs=pst.executeQuery();
            tableDelay.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void searchDelaysFilter(){
        String sql = "select id, localeOfDelay as 'Estação', typeDelay as 'Tipo do Atraso', beginningDelay as 'Começo do Atraso', endingDelay as 'Finalização do Serviço', dats as 'Data' from delay where (dats between ? and ?) and typeDelay = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,inputFirstDateFilter.getText());
            pst.setString(2,inputSecondDateFilter.getText());
            if(inputDelayReason.getSelectedItem().equals("M1")){
                pst.setString(3,"M1");
            }
            else if(inputDelayReason.getSelectedItem().equals("M2")){
                pst.setString(3,"M2");
            }
            else if(inputDelayReason.getSelectedItem().equals("M3")){
                pst.setString(3,"M3");
            }
            else if(inputDelayReason.getSelectedItem().equals("M4")){
                pst.setString(3,"M4");
            }
            rs=pst.executeQuery();
            tableDelay.setModel(DbUtils.resultSetToTableModel(rs));
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

        txtDelay = new javax.swing.JLabel();
        allTableDelay = new javax.swing.JScrollPane();
        tableDelay = new javax.swing.JTable();
        inputFirstDateFilter = new javax.swing.JFormattedTextField();
        inputSecondDateFilter = new javax.swing.JFormattedTextField();
        buttonFilter = new javax.swing.JButton();
        inputDelayReason = new javax.swing.JComboBox<>();
        buttonShow = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atrasos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        txtDelay.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtDelay.setText("ATRASOS");
        getContentPane().add(txtDelay);
        txtDelay.setBounds(231, 20, 116, 32);

        tableDelay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Estação", "Tipo do Atraso", "Duração do Atraso", "Rodagem"
            }
        ));
        allTableDelay.setViewportView(tableDelay);

        getContentPane().add(allTableDelay);
        allTableDelay.setBounds(17, 70, 545, 255);

        try {
            inputFirstDateFilter.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        inputFirstDateFilter.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        inputFirstDateFilter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputFirstDateFilterFocusGained(evt);
            }
        });
        inputFirstDateFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputFirstDateFilterKeyPressed(evt);
            }
        });
        getContentPane().add(inputFirstDateFilter);
        inputFirstDateFilter.setBounds(17, 339, 104, 24);

        try {
            inputSecondDateFilter.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        inputSecondDateFilter.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        inputSecondDateFilter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputSecondDateFilterFocusGained(evt);
            }
        });
        inputSecondDateFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputSecondDateFilterKeyPressed(evt);
            }
        });
        getContentPane().add(inputSecondDateFilter);
        inputSecondDateFilter.setBounds(17, 378, 104, 24);

        buttonFilter.setText("FILTRAR");
        buttonFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterActionPerformed(evt);
            }
        });
        buttonFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonFilterKeyPressed(evt);
            }
        });
        getContentPane().add(buttonFilter);
        buttonFilter.setBounds(17, 420, 80, 25);

        inputDelayReason.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        inputDelayReason.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "M1", "M2", "M3", "M4" }));
        inputDelayReason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDelayReasonActionPerformed(evt);
            }
        });
        inputDelayReason.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputDelayReasonKeyPressed(evt);
            }
        });
        getContentPane().add(inputDelayReason);
        inputDelayReason.setBounds(180, 337, 110, 29);

        buttonShow.setText("MOSTRAR");
        buttonShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowActionPerformed(evt);
            }
        });
        buttonShow.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonShowKeyPressed(evt);
            }
        });
        getContentPane().add(buttonShow);
        buttonShow.setBounds(111, 420, 90, 25);

        buttonRefresh.setText("ATUALIZAR");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        buttonRefresh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonRefreshKeyPressed(evt);
            }
        });
        getContentPane().add(buttonRefresh);
        buttonRefresh.setBounds(220, 420, 110, 25);

        setSize(new java.awt.Dimension(595, 513));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(x==0){
            x++;
            searchDelays(getDate.informDate(), getDate.informDate());
        }
    }//GEN-LAST:event_formWindowActivated

    private void buttonFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterActionPerformed
        if(inputDelayReason.getSelectedItem().equals("TODOS")){
            searchDelays(inputFirstDateFilter.getText(), inputSecondDateFilter.getText());
        }
        else{
            searchDelaysFilter();
        }
    }//GEN-LAST:event_buttonFilterActionPerformed

    private void inputFirstDateFilterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputFirstDateFilterFocusGained
        inputFirstDateFilter.selectAll();
    }//GEN-LAST:event_inputFirstDateFilterFocusGained

    private void inputSecondDateFilterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputSecondDateFilterFocusGained
        inputSecondDateFilter.selectAll();
    }//GEN-LAST:event_inputSecondDateFilterFocusGained

    private void buttonShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowActionPerformed
        int setar=tableDelay.getSelectedRow();
        ShowDelay showDelay = new ShowDelay();
        showDelay.idDelay = Integer.parseInt(tableDelay.getModel().getValueAt(setar,0).toString());
        showDelay.outputStation.setText(tableDelay.getModel().getValueAt(setar,1).toString());
        showDelay.outputTypeDelay.setText(tableDelay.getModel().getValueAt(setar,2).toString());
        showDelay.outputBeginDelay.setText(tableDelay.getModel().getValueAt(setar,3).toString());
        showDelay.outputEndDelay.setText(tableDelay.getModel().getValueAt(setar,4).toString());
        showDelay.setVisible(true);
    }//GEN-LAST:event_buttonShowActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        searchDelays(getDate.informDate(), getDate.informDate());
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void inputFirstDateFilterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputFirstDateFilterKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            inputSecondDateFilter.requestFocus();
        }
    }//GEN-LAST:event_inputFirstDateFilterKeyPressed

    private void inputSecondDateFilterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputSecondDateFilterKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            inputDelayReason.requestFocus();
        }
    }//GEN-LAST:event_inputSecondDateFilterKeyPressed

    private void inputDelayReasonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputDelayReasonKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(inputDelayReason.getSelectedItem().equals("TODOS")){
                searchDelays(inputFirstDateFilter.getText(), inputSecondDateFilter.getText());
            }
            else{
                searchDelaysFilter();
            }
        }
    }//GEN-LAST:event_inputDelayReasonKeyPressed

    private void buttonFilterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonFilterKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(inputDelayReason.getSelectedItem().equals("TODOS")){
                searchDelays(inputFirstDateFilter.getText(), inputSecondDateFilter.getText());
            }
            else{
                searchDelaysFilter();
            }
        }
    }//GEN-LAST:event_buttonFilterKeyPressed

    private void buttonShowKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonShowKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            int setar=tableDelay.getSelectedRow();
            ShowDelay showDelay = new ShowDelay();
            showDelay.idDelay = Integer.parseInt(tableDelay.getModel().getValueAt(setar,0).toString());
            showDelay.outputStation.setText(tableDelay.getModel().getValueAt(setar,1).toString());
            showDelay.outputTypeDelay.setText(tableDelay.getModel().getValueAt(setar,2).toString());
            showDelay.outputBeginDelay.setText(tableDelay.getModel().getValueAt(setar,3).toString());
            showDelay.outputEndDelay.setText(tableDelay.getModel().getValueAt(setar,4).toString());
            showDelay.setVisible(true);
        }
    }//GEN-LAST:event_buttonShowKeyPressed

    private void buttonRefreshKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonRefreshKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            searchDelays(getDate.informDate(), getDate.informDate());
        }
    }//GEN-LAST:event_buttonRefreshKeyPressed

    private void inputDelayReasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDelayReasonActionPerformed
        if(inputDelayReason.getSelectedItem().equals("TODOS")){
            searchDelays(inputFirstDateFilter.getText(), inputSecondDateFilter.getText());
        }
        else{
            searchDelaysFilter();
        }
    }//GEN-LAST:event_inputDelayReasonActionPerformed

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
            java.util.logging.Logger.getLogger(CheckDelayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckDelayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckDelayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckDelayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckDelayScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane allTableDelay;
    private javax.swing.JButton buttonFilter;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonShow;
    private javax.swing.JComboBox<String> inputDelayReason;
    private javax.swing.JFormattedTextField inputFirstDateFilter;
    private javax.swing.JFormattedTextField inputSecondDateFilter;
    private javax.swing.JTable tableDelay;
    private javax.swing.JLabel txtDelay;
    // End of variables declaration//GEN-END:variables
}

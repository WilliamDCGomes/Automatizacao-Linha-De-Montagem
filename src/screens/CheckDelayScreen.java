package screens;
import conexaobd.ModuloConexao;
import functions.GetDate;
import functions.GetYesterdayDate;
import java.awt.Color;
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
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form CheckDelayScreen
     */
    public CheckDelayScreen() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    int x=0;
    GetDate getDate = new GetDate();
    GetYesterdayDate getYesterdayDate= new GetYesterdayDate();
    private void searchDelays(String begin, String end){
        String sql = "select localeOfDelay as 'Estação', typeDelay as 'Tipo do Atraso', beginningDelay as 'Começo do Atraso', endingDelay as 'Finalização do Serviço' from delay where dats between ? and ?";
        try {
            pst = conexao.prepareStatement(sql);
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
        String sql = "select localeOfDelay as 'Estação', typeDelay as 'Tipo do Atraso', beginningDelay as 'Começo do Atraso', endingDelay as 'Finalização do Serviço' from delay where (dats between ? and ?) and typeDelay = ?";
        try {
            pst = conexao.prepareStatement(sql);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atrasos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        txtDelay.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtDelay.setText("ATRASOS");

        tableDelay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Estação", "Tipo do Atraso", "Duração do Atraso"
            }
        ));
        allTableDelay.setViewportView(tableDelay);

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

        buttonFilter.setText("FILTRAR");
        buttonFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterActionPerformed(evt);
            }
        });

        inputDelayReason.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        inputDelayReason.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONAR", "M1", "M2", "M3", "M4" }));

        buttonShow.setText("MOSTRAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDelay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonFilter)
                        .addGap(18, 18, 18)
                        .addComponent(buttonShow)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputSecondDateFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(allTableDelay, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inputFirstDateFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(inputDelayReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtDelay)
                .addGap(18, 18, 18)
                .addComponent(allTableDelay, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputFirstDateFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDelayReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputSecondDateFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonFilter)
                    .addComponent(buttonShow))
                .addGap(29, 29, 29))
        );

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
        if(inputDelayReason.getSelectedItem().equals("SELECIONAR")){
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
    private javax.swing.JButton buttonShow;
    private javax.swing.JComboBox<String> inputDelayReason;
    private javax.swing.JFormattedTextField inputFirstDateFilter;
    private javax.swing.JFormattedTextField inputSecondDateFilter;
    private javax.swing.JTable tableDelay;
    private javax.swing.JLabel txtDelay;
    // End of variables declaration//GEN-END:variables
}

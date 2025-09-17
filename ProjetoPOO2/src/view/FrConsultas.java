package view;

import controller.LocalController;
import controller.PacienteController;
import controller.UsuarioController;
import java.util.List;
import model.Local;
import model.Paciente;
import model.Usuario;

public class FrConsultas extends javax.swing.JDialog {

    public FrConsultas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxMedico = new javax.swing.JComboBox<>();
        cbxPaciente = new javax.swing.JComboBox<>();
        cbxLocal = new javax.swing.JComboBox<>();
        btnMarcar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 255, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Marcar consultas");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 120));

        jPanel1.add(cbxMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 130, -1));

        jPanel1.add(cbxPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 140, -1));

        jPanel1.add(cbxLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 130, -1));

        btnMarcar.setText("Marcar");
        btnMarcar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMarcarMouseClicked(evt);
            }
        });
        jPanel1.add(btnMarcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        btnVoltar.setText("Voltar");
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        UsuarioController controller = new UsuarioController();
        PacienteController controllerPaciente = new PacienteController();
        LocalController controllerLocal = new LocalController();

        List<Usuario> lista = controller.consultar(0, "");
        List<Paciente> listaPaciente = controllerPaciente.consultarPaciente(0, "");
        List<Local> listaLocal = controllerLocal.consultarLocal(0, "");

        for (Usuario usu : lista) {

            cbxMedico.addItem(usu);

        }

        for (Paciente paciente : listaPaciente) {

            cbxPaciente.addItem(paciente);

        }

        for (Local local : listaLocal) {

            cbxLocal.addItem(local);

        }


    }//GEN-LAST:event_formWindowOpened

    private void btnMarcarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMarcarMouseClicked


    }//GEN-LAST:event_btnMarcarMouseClicked

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
            java.util.logging.Logger.getLogger(FrConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrConsultas dialog = new FrConsultas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMarcar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<Local> cbxLocal;
    private javax.swing.JComboBox<Usuario> cbxMedico;
    private javax.swing.JComboBox<Paciente> cbxPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import Controlador.Controlador;
import Controlador.IControlador;
import DataTransferObject.DTOSistema;
import Datos.LectorData;
import Validacion.Validacion;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author SilviaElena
 */
public class VistaGUI extends javax.swing.JFrame {

    IControlador controlador = Controlador.getInstance();

    /**
     * Creates new form VistaGUI
     */
    public VistaGUI() {
        initComponents();
        JFormattedTextField tf = ((JSpinner.DefaultEditor) plazo.getEditor()).getTextField();
        tf.setEditable(false);
        llenarCombo(sistemas, "SistemasAmortizacion");
        llenarCombo(monedas, "Monedas");
    }

    public void llenarCombo(JComboBox combo, String tipo) {
        LectorData lector = new LectorData();
        ArrayList<String> sistemasR = new ArrayList<>();
        sistemasR = lector.getRegistros(tipo);
        for (int i = 0; i < sistemasR.size(); i++) {
            combo.addItem(sistemasR.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAp1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtAp2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtMonto = new javax.swing.JTextField();
        plazo = new javax.swing.JSpinner();
        txtInteres = new javax.swing.JTextField();
        sistemas = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        monedas = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnRealizarOperacion = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel8.setText("Seleccione el Sistema de Amortización");

        btnCancelar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtNombre.setName("txt_nombre"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("Complete la siguiente información:");

        txtAp1.setName("txt_apellido1"); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 49, 33));
        jPanel2.setMaximumSize(new java.awt.Dimension(32766, 32766));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        txtAp2.setName("txt_apellido2"); // NOI18N

        jPanel3.setBackground(new java.awt.Color(0, 49, 33));
        jPanel3.setMaximumSize(new java.awt.Dimension(32766, 32766));
        jPanel3.setPreferredSize(new java.awt.Dimension(277, 3));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        txtMonto.setName("txt_monto"); // NOI18N

        plazo.setName("periodo"); // NOI18N
        plazo.setOpaque(false);
        plazo.setValue(1);

        txtInteres.setName("txt_interes"); // NOI18N

        sistemas.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel9.setText("Seleccione el tipo de moneda:");

        jPanel1.setBackground(new java.awt.Color(0, 49, 33));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("SISTEMA DE AMORTIZACIÓN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setText("Primer Apellido:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("Segundo Apellido:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel5.setText("Monto del péstamo:");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel6.setText("Periódo total en años:");

        monedas.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        monedas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monedasActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel7.setText("Interés Anual: ");

        btnRealizarOperacion.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnRealizarOperacion.setText("Realizar Operación");
        btnRealizarOperacion.setName("btnRealizarOperacion"); // NOI18N
        btnRealizarOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarOperacionActionPerformed(evt);
            }
        });

        jLabel10.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRealizarOperacion))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtNombre)
                                                    .addComponent(txtAp1)
                                                    .addComponent(txtAp2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sistemas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(monedas, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(plazo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(176, 176, 176))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel10)))))
                                .addGap(0, 2, Short.MAX_VALUE)))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(plazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(sistemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(monedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRealizarOperacion)
                    .addComponent(btnCancelar))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void monedasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monedasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monedasActionPerformed

    public String getTipoCambioCompra() {
        return controlador.getTipoCambioCompra();
    }

    public String getFechaHora() {
        return controlador.getFechaHora();
    }

    public DTOSistema crearSistema(String nombreCliente,
            String apellido1, String apellido2, String tipoCliente, double prestamo, int plazo,
            double interes, Double moneda, String tipoSistema) {

        DTOSistema dtoSistema = new DTOSistema();
        dtoSistema.setMontoPrestamo(prestamo);
        dtoSistema.setPlazo(plazo);
        dtoSistema.setInteres(interes);
        dtoSistema.setTipoSistema(tipoSistema);
        dtoSistema.setMoneda(moneda);
        dtoSistema.setNombreCliente(nombreCliente);
        dtoSistema.setPrimerApellidoCliente(apellido1);
        dtoSistema.setSegundoApellidoCliente(apellido2);
        dtoSistema.setTipoCliente(tipoCliente);
        return controlador.crearAmortizacion(dtoSistema);
    }

    public void realizarOperacion(String nombre, String ap1, String ap2, String monto,
            String plazo, String interes, Double moneda, String sistema) {

        String tipoCambio = getTipoCambioCompra();
        String fechaHora = getFechaHora();
        double montoP = Double.parseDouble(monto);
        int plazoP = Integer.parseInt(plazo);
        double interesP = Double.parseDouble(interes) / 100;
        DTOSistema dtoSistema = crearSistema(nombre, ap1, ap2, "Fisico", montoP, plazoP, interesP, moneda, sistema);
        controlador.registrarBitacora(dtoSistema);
        PasarDatos(dtoSistema, tipoCambio, fechaHora);
    }

    public void PasarDatos(DTOSistema sistema, String tipoCambio, String chucky) {
        this.setVisible(false);
        ResultadoAmortizacion resultado = new ResultadoAmortizacion();
        resultado.setVisible(true);
        resultado.cargarDatos(sistema, tipoCambio, chucky);
    }

    public Double verificarMoneda(String moneda) {
        LectorData lector = new LectorData();
        if ((lector.getRegistros("Monedas").get(0)).equals(moneda)) {
            return 1.0;
        }
        return Double.parseDouble(controlador.getTipoCambioCompra());
    }


    private void btnRealizarOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarOperacionActionPerformed
        String nombre = txtNombre.getText();
        String ap1 = txtAp1.getText();
        String ap2 = txtAp2.getText();
        String monto = txtMonto.getText();
        String interes = txtInteres.getText();
        String plaz = String.valueOf(plazo.getValue());
        String sistema = (String) sistemas.getSelectedItem();
        String moneda = (String) monedas.getSelectedItem();
        Double tipoCambio = verificarMoneda(moneda);

        if (validarCamposVacios(nombre, ap1, ap2, monto, interes)) {
            if (validarCamposValor(nombre, ap1, ap2, monto, interes)) {
                realizarOperacion(nombre, ap1, ap2, monto, plaz, interes, tipoCambio, sistema);
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese correctamente los datos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
        }

    }//GEN-LAST:event_btnRealizarOperacionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public Boolean validarCamposVacios(String nombre, String ap1, String ap2, String monto, String interes) {
        return !nombre.equals("") && !nombre.equals(" ") && !ap1.equals("") && !ap1.equals(" ")
                && !ap2.equals("") && !ap2.equals(" ") && !monto.equals("") && !interes.equals("");
    }

    public Boolean validarCamposValor(String nombre, String ap1, String ap2, String monto, String interes) {
        Validacion val = new Validacion();
        return val.validarNombre(nombre) && val.validarNombre(ap1) && val.validarNombre(ap2)
                && val.validarDouble(monto) && val.validarNumero(interes);
    }

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
            java.util.logging.Logger.getLogger(VistaGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRealizarOperacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> monedas;
    public javax.swing.JSpinner plazo;
    private javax.swing.JComboBox<String> sistemas;
    public javax.swing.JTextField txtAp1;
    public javax.swing.JTextField txtAp2;
    public javax.swing.JTextField txtInteres;
    public javax.swing.JTextField txtMonto;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

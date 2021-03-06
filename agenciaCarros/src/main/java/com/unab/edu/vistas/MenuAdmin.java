/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.vistas;

import com.unab.edu.conexion.Conexion;
import com.unab.edu.dao.UsuarioDao;
import com.unab.edu.entidades.Usuario;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Dennis
 */
public class MenuAdmin extends javax.swing.JFrame {

    
    /**
     * 
     */
    public MenuAdmin() {
        initComponents();
        this.setLocationRelativeTo(this);
        //
        Conexion con = new Conexion();
        con.retornarConexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoBotones = new javax.swing.ButtonGroup();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnProveedor = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnEmpleado = new javax.swing.JButton();
        btnMarca = new javax.swing.JButton();
        btnModelo = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnCompra = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        btnVehiculo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de Sesión");
        setBackground(new java.awt.Color(0, 102, 102));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setOpaque(false);
        jPanel2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanel2PropertyChange(evt);
            }
        });

        btnProveedor.setBackground(new java.awt.Color(102, 102, 102));
        btnProveedor.setText("Proveedor");
        btnProveedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        btnUsuario.setBackground(new java.awt.Color(102, 102, 102));
        btnUsuario.setText("Usuario");
        btnUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        btnEmpleado.setBackground(new java.awt.Color(102, 102, 102));
        btnEmpleado.setText("Empleado");
        btnEmpleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoActionPerformed(evt);
            }
        });

        btnMarca.setBackground(new java.awt.Color(102, 102, 102));
        btnMarca.setText("Marca");
        btnMarca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcaActionPerformed(evt);
            }
        });

        btnModelo.setBackground(new java.awt.Color(102, 102, 102));
        btnModelo.setText("Modelo");
        btnModelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModeloActionPerformed(evt);
            }
        });

        btnCliente.setBackground(new java.awt.Color(102, 102, 102));
        btnCliente.setText("Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnCompra.setBackground(new java.awt.Color(102, 102, 102));
        btnCompra.setText("Compras");
        btnCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        btnVenta.setBackground(new java.awt.Color(102, 102, 102));
        btnVenta.setText("Ventas");
        btnVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        btnVehiculo.setBackground(new java.awt.Color(102, 102, 102));
        btnVehiculo.setText("Vehiculos");
        btnVehiculo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(btnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProveedor)
                    .addComponent(btnMarca)
                    .addComponent(btnVehiculo))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuario)
                    .addComponent(btnModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmpleado)
                    .addComponent(btnCliente)
                    .addComponent(btnCompra))
                .addGap(66, 66, 66))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 440, 250));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/11.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanel2PropertyChange
        // TODO add your handling code here:
        jPanel2.setOpaque(false);
    }//GEN-LAST:event_jPanel2PropertyChange

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        crudProveedor proveedor = new crudProveedor();
        proveedor.setVisible(true);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        crudUsuario usuario = new crudUsuario();
        usuario.setVisible(true);
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoActionPerformed
        crudEmpleado empleado = new crudEmpleado();
        empleado.setVisible(true);
    }//GEN-LAST:event_btnEmpleadoActionPerformed

    private void btnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcaActionPerformed
        crudMarca marca = new crudMarca();
        marca.setVisible(true);
    }//GEN-LAST:event_btnMarcaActionPerformed

    private void btnModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModeloActionPerformed
        crudModel modelo = new crudModel();
        modelo.setVisible(true);
    }//GEN-LAST:event_btnModeloActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        crudCliente cliente = new crudCliente();
        cliente.setVisible(true);
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        crudCompras venta = new crudCompras();
        venta.setVisible(true);
    }//GEN-LAST:event_btnCompraActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehiculoActionPerformed
        // TODO add your handling code here:
        crudVehiculo carro= new crudVehiculo();
        carro.setVisible(true);
    }//GEN-LAST:event_btnVehiculoActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotones;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnEmpleado;
    private javax.swing.JButton btnMarca;
    private javax.swing.JButton btnModelo;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVehiculo;
    private javax.swing.JButton btnVenta;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
    
}

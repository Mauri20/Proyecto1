//Review--Ready
package com.unab.edu.vistas;
import com.unab.edu.dao.EmpleadoDao;
import com.unab.edu.dao.UsuarioDao;
import com.unab.edu.entidades.Empleado;
import com.unab.edu.entidades.Usuario;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class crudUsuario extends javax.swing.JFrame {

    /**
     * Creates new form crudUsuario
     */
    
    
    String valueMember[];
    String valueMember2[];
    int contador = 1;
    int contador2 =1; 
    
    
 
    
    //cod. for comboxs
    void displayMember() {
        DefaultComboBoxModel cbdeault = new DefaultComboBoxModel();
        EmpleadoDao claseEmpleado = new EmpleadoDao();
        ArrayList<Empleado> Empleados = claseEmpleado.MostrarEmpleados();
        valueMember = new String[Empleados.size()+1];
        String filas[] = new String[5];
        cbdeault.addElement("");

        for (var IterarDatosEmpleado : Empleados) {
            filas[0] = String.valueOf(IterarDatosEmpleado.getId());
            filas[1] = IterarDatosEmpleado.getNombre();
            valueMember[contador] = filas[0];
            cbdeault.addElement(filas[1]);
            contador++;

        }
        cbIdEmpleado.setModel(cbdeault);
    }
    
     void displayMember2() {
        DefaultComboBoxModel cbdeault2 = new DefaultComboBoxModel();
        UsuarioDao claseUsuarioDao = new UsuarioDao();
        ArrayList<Usuario> Usuarios = claseUsuarioDao.MostrarUsuario();
        valueMember2 = new String[Usuarios.size()+1];
        String filas[] = new String[5];
        cbdeault2.addElement("");

        for (var IterarDatosUsuario : Usuarios) {
            filas[0] = String.valueOf(IterarDatosUsuario.getId());
            filas[1] = IterarDatosUsuario.getTipo();
            valueMember2[contador2] = filas[0];
            cbdeault2.addElement(filas[1]);
            contador2++;

        }
        cbTipo.setModel(cbdeault2);
    }
    
    
    
    public crudUsuario() {
        initComponents();
        MostrarUsuario();
        displayMember();
        displayMember2();
    }

    
    //Para la consulta mostrar --Listo
     void MostrarUsuario() 
     {
        String TITULOS[] = {"ID", "EMPLEADO", "USUARIO", "PASS", "TIPO"};
        
        DefaultTableModel modelTabla = new DefaultTableModel(null, TITULOS);
        UsuarioDao claseusuario = new UsuarioDao();
        
        var listaEmpleados = claseusuario.MostrarUsuario();
        String filas[] = new String[5];
            
        for (var iterarDatos : listaEmpleados)
        {
            filas[0] = String.valueOf(iterarDatos.getIdUsuario());
            filas[1] = String.valueOf(iterarDatos.getId());
            filas[2] = iterarDatos.getUsuario();
            filas[3] = iterarDatos.getPass();
            filas[4] = String.valueOf(iterarDatos.getTipo());
           
            
            modelTabla.addRow(filas);
        }
        
        tbUsuarios.setModel(modelTabla);
    }
     
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTbDatos = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        btnAyudaTable = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        MesaDeTrabajo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        txtIdUsuario = new javax.swing.JTextField();
        cbIdEmpleado = new javax.swing.JComboBox<>();
        cbTipo = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblMenu = new javax.swing.JLabel();
        btnAyuda = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTbDatos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuarios);

        btnAyudaTable.setText("Ayuda");
        btnAyudaTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAyudaTable)
                .addContainerGap(547, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(477, Short.MAX_VALUE)
                .addComponent(btnAyudaTable)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(42, Short.MAX_VALUE)))
        );

        jTbDatos.addTab("LISTADO", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MesaDeTrabajo.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Datos de usuario");

        txtIdUsuario.setEditable(false);

        cbIdEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbIdEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdEmpleadoActionPerformed(evt);
            }
        });

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Empleado:");

        lblMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu.setText("Menu");
        lblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuMouseClicked(evt);
            }
        });

        btnAyuda.setText("Ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MesaDeTrabajoLayout = new javax.swing.GroupLayout(MesaDeTrabajo);
        MesaDeTrabajo.setLayout(MesaDeTrabajoLayout);
        MesaDeTrabajoLayout.setHorizontalGroup(
            MesaDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MesaDeTrabajoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(MesaDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MesaDeTrabajoLayout.createSequentialGroup()
                        .addComponent(lblMenu)
                        .addGap(124, 124, 124)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addComponent(btnAyuda))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MesaDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
                    .addGroup(MesaDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(MesaDeTrabajoLayout.createSequentialGroup()
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(115, 115, 115)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        MesaDeTrabajoLayout.setVerticalGroup(
            MesaDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MesaDeTrabajoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MesaDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MesaDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMenu))
                    .addComponent(btnAyuda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(MesaDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        jPanel3.add(MesaDeTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 500));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/6.jpg"))); // NOI18N
        jPanel3.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 500));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTbDatos.addTab("DATOS", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTbDatos)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTbDatos, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    //Evento mouseclicked --listo
    private void tbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosMouseClicked
              
         jTbDatos.setSelectedIndex(jTbDatos.indexOfComponent(jPanel1));

        int fila = tbUsuarios.getSelectedRow();

        
        String idusuario = String.valueOf(tbUsuarios.getValueAt(fila, 0));
        String idempleado = String.valueOf(tbUsuarios.getValueAt(fila, 1));
        String usuario = String.valueOf(tbUsuarios.getValueAt(fila, 2));
        String pass = String.valueOf(tbUsuarios.getValueAt(fila, 3));
        String tipo = String.valueOf(tbUsuarios.getValueAt(fila, 4));

        
        txtIdUsuario.setText(idusuario);
        txtUsuario.setText(usuario);
        txtContraseña.setText(pass);
                    
        
        int seleccionadordevista = 0;
        for(var iterar: valueMember){
            
            if (idempleado.equals(iterar)&&(tipo.equals(iterar) ) ) 
            {
                
                cbIdEmpleado.setSelectedIndex(seleccionadordevista);
                cbTipo.setSelectedIndex(seleccionadordevista);    
                
            }
            seleccionadordevista += 1;
        }               
    }//GEN-LAST:event_tbUsuariosMouseClicked

    
    
    // Evento boton borrar --listo
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        UsuarioDao usuadao = new UsuarioDao();
        Usuario usuario = new Usuario();

        usuario.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));

        usuadao.eliminarUsuario(usuario);
        MostrarUsuario();

    }//GEN-LAST:event_btnEliminarActionPerformed

    
   
    //Evento vaciar los datos de los txt and combox --listo
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        cbIdEmpleado.setSelectedItem("");
        txtIdUsuario.setText("");
        txtContraseña.setText("");
        txtUsuario.setText("");
        cbTipo.setSelectedItem("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    
    
    //Evento btn guardar --listo
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {

            UsuarioDao usuu = new UsuarioDao();
            Usuario usuarioo = new Usuario();

            usuarioo.setId(Integer.parseInt(valueMember[cbIdEmpleado.getSelectedIndex()]));
            usuarioo.setUsuario(txtUsuario.getText());
            usuarioo.setPass(txtContraseña.getText());
            usuarioo.setTipo((valueMember[cbTipo.getSelectedIndex()]));

            usuu.agregarUsuario(usuarioo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error verifica los datos");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    
    
    
    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoActionPerformed

    private void cbIdEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIdEmpleadoActionPerformed

    private void lblMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuMouseClicked
        MenuAdmin menu = new MenuAdmin();
        menu.setVisible(true);
        this.hide();
    }//GEN-LAST:event_lblMenuMouseClicked

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnAyudaTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAyudaTableActionPerformed

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
            java.util.logging.Logger.getLogger(crudUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crudUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crudUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crudUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crudUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JPanel MesaDeTrabajo;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnAyudaTable;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbIdEmpleado;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTbDatos;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

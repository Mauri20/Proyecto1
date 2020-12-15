/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.vistas;

import com.unab.edu.dao.ModeloDao;
import com.unab.edu.dao.ProveedorDao;
import com.unab.edu.dao.VehiculoDao;
import com.unab.edu.entidades.Fondo;
import com.unab.edu.entidades.Modelo;
import com.unab.edu.entidades.Proveedor;
import com.unab.edu.entidades.Tablas;
import com.unab.edu.entidades.Vehiculo;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio
 */
public class crudVehiculo extends javax.swing.JFrame {

    /**
     * Creates new form crudVehiculo
     */
    
    public int origen=crudCompras.origen;
    Fondo fondo = new Fondo();
    public crudVehiculo() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(this);
        btnBuscar.setBackground(new Color(0, 0, 0, 0));
        MotrarVehiculos();
        Tablas.removeBackground(tbVehiculos, jScrollPane1);
        Tablas.resizeColumnWidth(tbVehiculos, 35, 100);
        Tablas.removeBackground(tbVehiculos1, ScrollPaneSeleccion);
        Tablas.resizeColumnWidth(tbVehiculos1, 35, 100);

        txtMarca.enable(false);
        if(origen==2){
            Menu.remove(PanelListado);
            Activar();
        }else if(origen==0){
            Menu.remove(PanelSeleccion);
            Desactivar();
        }
//        Menu.remove(PanelListado);
    }
    String ValueMember[];
    int contador = 1;

    void DisplayProveedores(int idMarca) {
        DefaultComboBoxModel cbodefault = new DefaultComboBoxModel();
        ProveedorDao provDao = new ProveedorDao();
        ArrayList<Proveedor> listado = provDao.mostrarProveedoresMarca(idMarca);
        ValueMember = new String[listado.size() + 1];
        String filas[] = new String[2];
        for (var iterarDatos : listado) {

            filas[0] = String.valueOf(iterarDatos.getId());
            filas[1] = iterarDatos.getNombre();
            ValueMember[contador] = filas[0];
            cbodefault.addElement(filas[1]);
            contador++;
        }
        cboProveedor.setModel(cbodefault);
    }
    void MotrarVehiculos() {
        String TITULOS[] = {"IDVEHIVULO", "IDMODELO", "MODELO", "IDMARCA", "MARCA", "IDPROVEEDOR", "PROVEEDOR", "CHASIS", "PUERTAS", "COLOR", "EMISION", "MOTOR", "PRECIO","EXISTENCIA"};
        DefaultTableModel modeloTabla = new DefaultTableModel(null, TITULOS);

        VehiculoDao carroDao = new VehiculoDao();
        var listado = carroDao.mostrarVehiculos();

        String fila[] = new String[14];

        for (var iterar : listado) {
            fila[0] = String.valueOf(iterar.getId());
            fila[1] = String.valueOf(iterar.getModelo().getIdModelo());
            fila[2] = iterar.getModelo().getNombreModelo();
            fila[3] = String.valueOf(iterar.getModelo().getId());
            fila[4] = iterar.getModelo().getNombreMarca();
            fila[5] = String.valueOf(iterar.getProveedor().getId());
            fila[6] = iterar.getProveedor().getNombre();
            fila[7] = iterar.getChasis();
            fila[8] = String.valueOf(iterar.getPuertas());
            fila[9] = iterar.getColor();
            fila[10] = iterar.getEmision();
            fila[11] = iterar.getMotor();
            fila[12] = String.valueOf(iterar.getPrecioAdq());
            fila[13] = String.valueOf(iterar.getExistencia());
            modeloTabla.addRow(fila);
        }
        tbVehiculos.setModel(modeloTabla);
        tbVehiculos1.setModel(modeloTabla);
    }
    void Limpiar() {
        txtModelo.setText("");
        txtIdModelo.setText("0");
        txtMarca.setText("");
        txtIdMarca.setText("0");
        //Restablecer el cboProveedores
        cboProveedor.removeAllItems();
        ValueMember = null;
        contador = 1;
        txtChasis.setText("");
        txtColor.setText("");
        txtPuertas.setText("");
        txtEmision.setText("");
        txtMotor.setText("");
        txtPrecioAdq.setText("");
        txtIdVehiculo.setText("0");
    }
    void Desactivar() {
        btnBuscar.setVisible(false);
        txtModelo.enable(false);
        txtIdModelo.enable(false);
        txtMarca.enable(false);
        txtIdMarca.enable(false);
        //Restablecer el cboProveedores
        cboProveedor.removeAllItems();
        ValueMember = null;
        contador = 1;
        txtChasis.enable(false);
        txtColor.enable(false);
        txtPuertas.enable(false);
        txtEmision.enable(false);
        txtMotor.enable(false);
        txtPrecioAdq.enable(false);
        txtIdVehiculo.enable(false);
    }
    void Activar() {
        btnBuscar.setVisible(true);
        txtModelo.enable(true);
        txtIdModelo.enable(true);
        txtMarca.enable(true);
        txtIdMarca.enable(true);
        //Restablecer el cboProveedores
        cboProveedor.removeAllItems();
        ValueMember = null;
        contador = 1;
        txtChasis.enable(true);
        txtColor.enable(true);
        txtPuertas.enable(true);
        txtEmision.enable(true);
        txtMotor.enable(true);
        txtPrecioAdq.enable(true);
        txtIdVehiculo.enable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JTabbedPane();
        PanelDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cboProveedor = new javax.swing.JComboBox<>();
        txtIdMarca = new javax.swing.JLabel();
        txtIdModelo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtChasis = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPuertas = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmision = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMotor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPrecioAdq = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtIdVehiculo = new javax.swing.JLabel();
        PanelListado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVehiculos = new javax.swing.JTable();
        PanelSeleccion = new javax.swing.JPanel();
        ScrollPaneSeleccion = new javax.swing.JScrollPane();
        tbVehiculos1 = new javax.swing.JTable();

        setTitle("CrudVehículo");
        setResizable(false);

        Menu.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMouseClicked(evt);
            }
        });

        PanelDatos.setForeground(new java.awt.Color(255, 255, 255));
        PanelDatos.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("Modelo:");

        txtModelo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Marca:");

        txtMarca.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Buscar 2.png"))); // NOI18N
        btnBuscar.setToolTipText("Buscar Modelo");
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setIconTextGap(6);
        btnBuscar.setOpaque(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("Proveedor:");

        cboProveedor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cboProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtIdMarca.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtIdMarca.setForeground(new java.awt.Color(204, 204, 255));
        txtIdMarca.setText("0");

        txtIdModelo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtIdModelo.setForeground(new java.awt.Color(204, 204, 255));
        txtIdModelo.setText("0");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        jLabel6.setText("# de Chasis:");

        txtChasis.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 255));
        jLabel7.setText("# de Puertas:");

        txtPuertas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtColor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 255));
        jLabel8.setText("Color:");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 255));
        jLabel9.setText("Emisión:");

        txtEmision.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 255));
        jLabel10.setText("Motor:");

        txtMotor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 255));
        jLabel11.setText("Precio de Adquisición:");

        txtPrecioAdq.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");

        txtIdVehiculo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtIdVehiculo.setForeground(new java.awt.Color(204, 204, 255));
        txtIdVehiculo.setText("0");

        javax.swing.GroupLayout PanelDatosLayout = new javax.swing.GroupLayout(PanelDatos);
        PanelDatos.setLayout(PanelDatosLayout);
        PanelDatosLayout.setHorizontalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(btnGuardar)
                .addGap(180, 180, 180)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addGap(76, 76, 76))
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addComponent(txtIdVehiculo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6)
                                .addComponent(jLabel9)
                                .addComponent(txtChasis, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(txtEmision))
                            .addGroup(PanelDatosLayout.createSequentialGroup()
                                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PanelDatosLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtIdModelo))
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PanelDatosLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIdMarca))
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)
                            .addComponent(txtPuertas, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtPrecioAdq, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))))
        );
        PanelDatosLayout.setVerticalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelDatosLayout.createSequentialGroup()
                                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PanelDatosLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(12, 12, 12))
                                    .addGroup(PanelDatosLayout.createSequentialGroup()
                                        .addComponent(txtIdMarca)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelDatosLayout.createSequentialGroup()
                                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtIdModelo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(txtIdVehiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtChasis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(12, 12, 12)
                        .addComponent(txtPuertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(12, 12, 12)
                        .addComponent(txtMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(12, 12, 12)
                        .addComponent(txtPrecioAdq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(37, 37, 37))
        );

        Menu.addTab("DATOS", PanelDatos);

        PanelListado.setOpaque(false);

        tbVehiculos.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        tbVehiculos.setForeground(new java.awt.Color(255, 255, 255));
        tbVehiculos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbVehiculos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbVehiculos.setGridColor(new java.awt.Color(255, 255, 255));
        tbVehiculos.setOpaque(false);
        tbVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVehiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbVehiculos);

        javax.swing.GroupLayout PanelListadoLayout = new javax.swing.GroupLayout(PanelListado);
        PanelListado.setLayout(PanelListadoLayout);
        PanelListadoLayout.setHorizontalGroup(
            PanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelListadoLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        PanelListadoLayout.setVerticalGroup(
            PanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.addTab("EDICIÓN", PanelListado);

        PanelSeleccion.setOpaque(false);

        tbVehiculos1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        tbVehiculos1.setForeground(new java.awt.Color(255, 255, 255));
        tbVehiculos1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbVehiculos1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbVehiculos1.setGridColor(new java.awt.Color(255, 255, 255));
        tbVehiculos1.setOpaque(false);
        tbVehiculos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVehiculos1MouseClicked(evt);
            }
        });
        ScrollPaneSeleccion.setViewportView(tbVehiculos1);

        javax.swing.GroupLayout PanelSeleccionLayout = new javax.swing.GroupLayout(PanelSeleccion);
        PanelSeleccion.setLayout(PanelSeleccionLayout);
        PanelSeleccionLayout.setHorizontalGroup(
            PanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSeleccionLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(ScrollPaneSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        PanelSeleccionLayout.setVerticalGroup(
            PanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSeleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.addTab("SELECCIÓN DE VEHÍCULOS", PanelSeleccion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String nombreModelo = txtModelo.getText();
        Modelo modelo = new Modelo();
        ModeloDao modeloDao = new ModeloDao();
        modelo = modeloDao.BuscarModelo(nombreModelo);
        try {
            txtModelo.setText(modelo.getNombreModelo());
            txtIdModelo.setText(String.valueOf(modelo.getIdModelo()));
            txtMarca.setText(modelo.getNombreMarca());
            txtIdMarca.setText(String.valueOf(modelo.getId()));
//           DisplayProveedores(modelo.getId());
            cboProveedor.removeAllItems();
            contador = 1;
            ValueMember = null;
            DisplayProveedores(Integer.parseInt(txtIdMarca.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error :( Así no Es! " + e);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtMarca.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe ingresar un Modelo Válido para Continuar");
            JOptionPane.showMessageDialog(null, "Debe seleccionar un vehículo para Continuar");
        } else {
            if (txtChasis.getText().trim().isEmpty() || txtPuertas.getText().trim().isEmpty() || txtColor.getText().trim().isEmpty()
                    || txtEmision.getText().trim().isEmpty() || txtMotor.getText().trim().isEmpty() || txtPrecioAdq.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe completar todos los Campos!");
            } else {
                VehiculoDao carroDao = new VehiculoDao();
                Vehiculo carro = new Vehiculo();

                Modelo modelo = new Modelo();
                modelo.setId(Integer.parseInt(txtIdMarca.getText()));
                modelo.setIdModelo(Integer.parseInt(txtIdModelo.getText()));
                modelo.setNombreMarca(txtMarca.getText());
                modelo.setNombreModelo(txtModelo.getText());

                Proveedor prov = new Proveedor();
                prov.setId(Integer.parseInt(ValueMember[cboProveedor.getSelectedIndex() + 1]));
                prov.setNombre(String.valueOf(cboProveedor.getSelectedItem()));

                if (txtPuertas.getText().isEmpty()) {
                    txtPuertas.setText("0");
                }
                carro.setId(Integer.parseInt(txtIdVehiculo.getText()));
                carro.setPuertas(Integer.parseInt(txtPuertas.getText()));
                carro.setChasis(txtChasis.getText());
                carro.setColor(txtColor.getText());
                carro.setEmision(txtEmision.getText());
                carro.setMotor(txtMotor.getText());
                if (txtPrecioAdq.getText().isEmpty()) {
                    txtPrecioAdq.setText("0");
                }
                carro.setPrecioAdq(Double.parseDouble(txtPrecioAdq.getText()));
                carro.setModelo(modelo);
                carro.setProveedor(prov);
                if (carro.getId() > 0) {
                    carroDao.actualizarVehiculo(carro);
                    //limpiar
                    Limpiar();
                    MotrarVehiculos();
                } else {
                    carroDao.agregarVehiculo(carro);
                    Limpiar();
                    MotrarVehiculos();
                }
            }
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tbVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVehiculosMouseClicked
        // TODO add your handling code here:
        Menu.setSelectedIndex(Menu.indexOfComponent(PanelDatos));

        int fila = tbVehiculos.getSelectedRow();

        String idVehiculo = String.valueOf(tbVehiculos.getValueAt(fila, 0));
        String idModelo = String.valueOf(tbVehiculos.getValueAt(fila, 1));
        String modelo = String.valueOf(tbVehiculos.getValueAt(fila, 2));
        String idMarca = String.valueOf(tbVehiculos.getValueAt(fila, 3));
        String marca = String.valueOf(tbVehiculos.getValueAt(fila, 4));
        String idProv = String.valueOf(tbVehiculos.getValueAt(fila, 5));
        String prov = String.valueOf(tbVehiculos.getValueAt(fila, 6));
        String chasis = String.valueOf(tbVehiculos.getValueAt(fila, 7));
        String puertas = String.valueOf(tbVehiculos.getValueAt(fila, 8));
        String color = String.valueOf(tbVehiculos.getValueAt(fila, 9));
        String emision = String.valueOf(tbVehiculos.getValueAt(fila, 10));
        String motor = String.valueOf(tbVehiculos.getValueAt(fila, 11));
        String precio = String.valueOf(tbVehiculos.getValueAt(fila, 12));
        
        Activar();
        txtIdVehiculo.setText(idVehiculo);
        txtModelo.setText(modelo);
        btnBuscar.doClick();
        int seleccionadordeVista = -1;
        for (var it : ValueMember) {
            if (it == null) {
                it = "0";
            }
            if (it.trim().equals(idProv)) {
                cboProveedor.setSelectedIndex(seleccionadordeVista);
            }
            seleccionadordeVista += 1;
        }
        txtChasis.setText(chasis);
        txtPuertas.setText(puertas);
        txtColor.setText(color);
        txtEmision.setText(emision);
        txtMotor.setText(motor);
        txtPrecioAdq.setText(precio);
    }//GEN-LAST:event_tbVehiculosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (txtIdVehiculo.getText() == "0") {
            JOptionPane.showMessageDialog(null, "No hay vehículo seleccionado");
        } else {
            VehiculoDao carroDao = new VehiculoDao();
            Vehiculo carro = new Vehiculo();
            carro.setId(Integer.parseInt(txtIdVehiculo.getText()));
            carroDao.eliminarVehiculo(carro);
            MotrarVehiculos();
            Limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tbVehiculos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVehiculos1MouseClicked
        // TODO add your handling code here:
        int fila = tbVehiculos1.getSelectedRow();

        String idVehiculo = String.valueOf(tbVehiculos1.getValueAt(fila, 0));
        String idModelo = String.valueOf(tbVehiculos1.getValueAt(fila, 1));
        String modelo = String.valueOf(tbVehiculos1.getValueAt(fila, 2));
        String idMarca = String.valueOf(tbVehiculos1.getValueAt(fila, 3));
        String marca = String.valueOf(tbVehiculos1.getValueAt(fila, 4));
        String idProv = String.valueOf(tbVehiculos1.getValueAt(fila, 5));
        String prov = String.valueOf(tbVehiculos1.getValueAt(fila, 6));
        String chasis = String.valueOf(tbVehiculos1.getValueAt(fila, 7));
        String puertas = String.valueOf(tbVehiculos1.getValueAt(fila, 8));
        String color = String.valueOf(tbVehiculos1.getValueAt(fila, 9));
        String emision = String.valueOf(tbVehiculos1.getValueAt(fila, 10));
        String motor = String.valueOf(tbVehiculos1.getValueAt(fila, 11));
        String precio = String.valueOf(tbVehiculos1.getValueAt(fila, 12));
        //########
//        JOptionPane.showMessageDialog(null,idVehiculo+"-"+modelo+"-"+marca+"-"+precio);
        crudCompras.txtIdCarro.setText(idVehiculo);
        
        crudCompras.txtModelo.setText(modelo);
        crudCompras.txtMarca.setText(marca);
        crudCompras.txtProveedor.setText(prov);
        crudCompras.txtPuertas.setText(puertas);
        crudCompras.txtColor.setText(color);
        crudCompras.txtEmision.setText(emision);
        crudCompras.txtMotor.setText(motor);
        crudCompras.txtPrecio.setText(precio);
        
        this.dispose();
    }//GEN-LAST:event_tbVehiculos1MouseClicked

    private void MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_MenuMouseClicked

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
            java.util.logging.Logger.getLogger(crudVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crudVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crudVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crudVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crudVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Menu;
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel PanelListado;
    private javax.swing.JPanel PanelSeleccion;
    private javax.swing.JScrollPane ScrollPaneSeleccion;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVehiculos;
    private javax.swing.JTable tbVehiculos1;
    private javax.swing.JTextField txtChasis;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtEmision;
    private javax.swing.JLabel txtIdMarca;
    private javax.swing.JLabel txtIdModelo;
    private javax.swing.JLabel txtIdVehiculo;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMotor;
    private javax.swing.JTextField txtPrecioAdq;
    private javax.swing.JTextField txtPuertas;
    // End of variables declaration//GEN-END:variables
}

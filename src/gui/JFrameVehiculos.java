package gui;

import Gestion.GestorDeMemoria;
import Gestion.gestor_clientes;
import Gestion.gestor_vehiculos;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.TipoVehiculo;
import modelo.Vehiculo;

public class JFrameVehiculos extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(JFrameVehiculos.class.getName());

    private gestor_vehiculos administrador;
    private gestor_clientes adminClientes;
    private DefaultTableModel tableModel;

    public JFrameVehiculos() {
        initComponents();
        this.administrador = GestorDeMemoria.getAdminVehiculos();
        this.adminClientes = GestorDeMemoria.getAdminClientes();
        
        // Ajustar fondo base rosa pastel
        getContentPane().setBackground(new Color(255, 240, 245));
        
        cargarTiposVehiculo();
        cargarClientes();
        agregarColumnasATabla();
        cargarVehiculos();
    }

    // ── Lógica ───────────────────────────────────────────────
    private void cargarTiposVehiculo() {
        this.cmbTipo.removeAllItems();
        this.cmbTipo.addItem("AUTOMOVIL");
        this.cmbTipo.addItem("CAMIONETA");
        this.cmbTipo.addItem("MOTOCICLETA");
    }

    private void cargarClientes() {
        this.cmbCliente.removeAllItems();
        ArrayList<Cliente> clientes = this.adminClientes.getList();
        for (Cliente c : clientes) {
            this.cmbCliente.addItem(
                c.getCodigo() + " - " + c.getNombre() + " " + c.getApellido());
        }
    }

    private Cliente obtenerClienteSeleccionado() {
        int index = this.cmbCliente.getSelectedIndex();
        if (index >= 0) return this.adminClientes.getList().get(index);
        return null;
    }

    private TipoVehiculo obtenerTipoVehiculo() {
        return TipoVehiculo.valueOf(
            this.cmbTipo.getSelectedItem().toString());
    }

    private String mostrarCliente(Cliente c) {
        return c.getCodigo() + " - " + c.getNombre() + " " + c.getApellido();
    }

    private void agregarColumnasATabla() {
        this.tableModel = new DefaultTableModel();
        this.tableModel.addColumn("Id");
        this.tableModel.addColumn("Placa");
        this.tableModel.addColumn("Marca");
        this.tableModel.addColumn("Modelo");
        this.tableModel.addColumn("Año");
        this.tableModel.addColumn("Tipo");
        this.tableModel.addColumn("Cliente");
        this.tblVehiculos.setModel(tableModel);
    }

    private void limpiarCampos() {
        this.txtId.setText("");
        this.txtPlaca.setText("");
        this.txtMarca.setText("");
        this.txtModelo.setText("");
        this.txtAño.setText("");
        this.cmbTipo.setSelectedItem("AUTOMOVIL");
        if (this.cmbCliente.getItemCount() > 0)
            this.cmbCliente.setSelectedIndex(0);
    }

    private void cargarVehiculos() {
        this.tableModel.setRowCount(0);
        ArrayList<Vehiculo> vehiculos = this.administrador.getList();
        for (Vehiculo v : vehiculos) {
            if (v != null) {
                String[] fila = new String[7];
                fila[0] = Integer.toString(v.getCodigo());
                fila[1] = v.getPlaca();
                fila[2] = v.getMarca();
                fila[3] = v.getModelo();
                fila[4] = Integer.toString(v.getAño());
                fila[5] = v.getTipo().toString();
                fila[6] = v.getCliente().getNombre() + " " +
                          v.getCliente().getApellido();
                this.tableModel.addRow(fila);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de Vehiculos");
        setBackground(new java.awt.Color(255, 240, 245));

        jLabel1.setBackground(new java.awt.Color(136, 14, 79));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Vehiculos");
        jLabel1.setOpaque(true);
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(136, 14, 79));
        jLabel2.setText("ID:");

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(240, 240, 240));
        txtId.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtId.setForeground(new java.awt.Color(21, 21, 21));
        txtId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(136, 14, 79));
        jLabel3.setText("Placa:");

        txtPlaca.setBackground(new java.awt.Color(255, 248, 250));
        txtPlaca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPlaca.setForeground(new java.awt.Color(21, 21, 21));
        txtPlaca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(136, 14, 79));
        jLabel4.setText("Marca:");

        txtMarca.setBackground(new java.awt.Color(255, 248, 250));
        txtMarca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(21, 21, 21));
        txtMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(136, 14, 79));
        jLabel5.setText("Modelo:");

        txtModelo.setBackground(new java.awt.Color(255, 248, 250));
        txtModelo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(21, 21, 21));
        txtModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(136, 14, 79));
        jLabel6.setText("Año:");

        txtAño.setBackground(new java.awt.Color(255, 248, 250));
        txtAño.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAño.setForeground(new java.awt.Color(21, 21, 21));
        txtAño.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(136, 14, 79));
        jLabel7.setText("Tipo:");

        cmbTipo.setBackground(new java.awt.Color(255, 248, 250));
        cmbTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbTipo.setForeground(new java.awt.Color(136, 14, 79));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AUTOMOVIL", "CAMIONETA", "MOTOCICLETA" }));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(136, 14, 79));
        jLabel8.setText("Cliente:");

        cmbCliente.setBackground(new java.awt.Color(255, 248, 250));
        cmbCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbCliente.setForeground(new java.awt.Color(136, 14, 79));
        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));

        btnGuardar.setBackground(new java.awt.Color(136, 14, 79));
        btnGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(136, 14, 79));
        btnModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.setFocusPainted(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(84, 110, 122));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        tblVehiculos.setBackground(new java.awt.Color(255, 255, 255));
        tblVehiculos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Placa", "Marca", "Modelo", "Año", "Tipo", "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehiculos.setRowHeight(24);
        tblVehiculos.setSelectionBackground(new java.awt.Color(240, 180, 210));
        tblVehiculos.setShowGrid(false);
        jScrollPane1.setViewportView(tblVehiculos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int id = this.txtId.getText().trim().equals("") ? 0
                : Integer.parseInt(this.txtId.getText().trim());

        String placa  = this.txtPlaca.getText().trim();
        String marca  = this.txtMarca.getText().trim();
        String modelo = this.txtModelo.getText().trim();

        if (placa.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la placa.");
            return;
        }
        if (marca.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la marca.");
            return;
        }
        if (modelo.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el modelo.");
            return;
        }
        if (this.txtAño.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el año.");
            return;
        }

        int año;
        try {
            año = Integer.parseInt(this.txtAño.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El año debe ser un número entero.");
            return;
        }

        Cliente cliente = obtenerClienteSeleccionado();
        if (cliente == null) {
            JOptionPane.showMessageDialog(this,
                    "Debe registrar o seleccionar un cliente.");
            return;
        }

        TipoVehiculo tipo = obtenerTipoVehiculo();
        Vehiculo vehiculo = new Vehiculo(id, placa, marca, modelo,
                                         año, tipo, cliente);
        Vehiculo resultado;

        if (id == 0) {
            resultado = administrador.agregar(vehiculo);
        } else {
            resultado = administrador.modificar(vehiculo);
        }

        if (resultado != null) {
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error!");
        }
        cargarVehiculos();
        limpiarCampos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int index = this.tblVehiculos.getSelectedRow();
        if (index >= 0) {
            int codigo = Integer.parseInt(
                    this.tableModel.getValueAt(index, 0).toString());
            Vehiculo v = administrador.buscar(codigo);
            if (v != null) {
                this.txtId.setText(Integer.toString(v.getCodigo()));
                this.txtPlaca.setText(v.getPlaca());
                this.txtMarca.setText(v.getMarca());
                this.txtModelo.setText(v.getModelo());
                this.txtAño.setText(Integer.toString(v.getAño()));
                this.cmbTipo.setSelectedItem(v.getTipo().toString());
                this.cmbCliente.setSelectedItem(mostrarCliente(v.getCliente()));
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int index = this.tblVehiculos.getSelectedRow();
        if (index >= 0) {
            int codigo = Integer.parseInt(
                    this.tableModel.getValueAt(index, 0).toString());
            Vehiculo v = administrador.buscar(codigo);
            boolean flag = false;
            if (v != null) {
                flag = this.administrador.eliminar(v);
            }
            if (flag) {
                JOptionPane.showMessageDialog(this,
                        "Vehículo eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error!");
            }
            cargarVehiculos();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new JFrameVehiculos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVehiculos;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
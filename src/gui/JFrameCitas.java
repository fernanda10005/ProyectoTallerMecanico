package gui;

import Gestion.GestorDeMemoria;
import Gestion.gestor_citas;
import Gestion.gestor_clientes;
import Gestion.gestor_servicios;
import Gestion.gestor_vehiculos;
import Gestion.Fecha;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cita;
import modelo.Cliente;
import modelo.Servicio;
import modelo.Vehiculo;

public class JFrameCitas extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(JFrameCitas.class.getName());

    private gestor_citas administrador;
    private gestor_clientes adminClientes;
    private gestor_vehiculos adminVehiculos;
    private gestor_servicios adminServicios;
    private DefaultTableModel tableModel;
    private ArrayList<Vehiculo> vehiculosDelCliente;

    public JFrameCitas() {
        initComponents();
        this.administrador   = GestorDeMemoria.getAdminCitas();
        this.adminClientes   = GestorDeMemoria.getAdminClientes();
        this.adminVehiculos  = GestorDeMemoria.getAdminVehiculos();
        this.adminServicios  = GestorDeMemoria.getAdminServicios();
        this.vehiculosDelCliente = new ArrayList<>();
        
        // Ajustar fondo del Frame al cargar
        getContentPane().setBackground(new Color(255, 240, 245));
        
        agregarColumnasATabla();
        cargarServicios();
        cargarClientes();
        cargarVehiculos();
        cargarCitas();
    }

    // ── Lógica ───────────────────────────────────────────────
    private void agregarColumnasATabla() {
        this.tableModel = new DefaultTableModel();
        this.tableModel.addColumn("Id");
        this.tableModel.addColumn("Cliente");
        this.tableModel.addColumn("Vehículo");
        this.tableModel.addColumn("Servicio");
        this.tableModel.addColumn("Fecha");
        this.tblCitas.setModel(tableModel);
    }

    private void limpiarCampos() {
        this.txtFecha.setText("");
        if (this.cmbCliente.getItemCount() > 0)
            this.cmbCliente.setSelectedIndex(0);
        if (this.cmbTipoServicio.getItemCount() > 0)
            this.cmbTipoServicio.setSelectedIndex(0);
        cargarVehiculos();
    }

    private void cargarServicios() {
        this.cmbTipoServicio.removeAllItems();
        for (Servicio s : this.adminServicios.getList())
            this.cmbTipoServicio.addItem(
                s.getCodigo() + " - " + s.getNombre() + " - S/ " + s.getPrecio());
    }

    private void cargarClientes() {
        this.cmbCliente.removeAllItems();
        for (Cliente c : this.adminClientes.getList())
            this.cmbCliente.addItem(
                c.getCodigo() + " - " + c.getNombre() + " " + c.getApellido());
    }

    private Cliente obtenerClienteSeleccionado() {
        int index = this.cmbCliente.getSelectedIndex();
        if (index >= 0) return this.adminClientes.getList().get(index);
        return null;
    }

    private void cargarVehiculos() {
        this.cmbVehiculo.removeAllItems();
        this.vehiculosDelCliente.clear();
        Cliente cliente = obtenerClienteSeleccionado();
        if (cliente == null) return;
        for (Vehiculo v : this.adminVehiculos.getList()) {
            if (v.getCliente().getCodigo() == cliente.getCodigo()) {
                this.vehiculosDelCliente.add(v);
                this.cmbVehiculo.addItem(
                    v.getCodigo() + " - " + v.getPlaca() + " - " + v.getMarca());
            }
        }
    }

    private Vehiculo obtenerVehiculoSeleccionado() {
        int index = this.cmbVehiculo.getSelectedIndex();
        if (index >= 0) return this.vehiculosDelCliente.get(index);
        return null;
    }

    private Servicio obtenerServicioSeleccionado() {
        int index = this.cmbTipoServicio.getSelectedIndex();
        if (index >= 0) return this.adminServicios.getList().get(index);
        return null;
    }

    private void cargarCitas() {
        this.tableModel.setRowCount(0);
        for (Cita c : this.administrador.getList()) {
            if (c != null) {
                String[] fila = new String[5];
                fila[0] = Integer.toString(c.getCodigo());
                fila[1] = c.getCliente().getNombre() + " " +
                          c.getCliente().getApellido();
                fila[2] = c.getVehiculo().getPlaca() + " - " +
                          c.getVehiculo().getMarca();
                fila[3] = c.getServicio().getNombre();
                fila[4] = c.getFecha();
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
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbTipoServicio = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbVehiculo = new javax.swing.JComboBox<>();
        btnCrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCitas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Citas");
        setBackground(new java.awt.Color(255, 240, 245));

        jLabel1.setBackground(new java.awt.Color(136, 14, 79));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Citas");
        jLabel1.setOpaque(true);
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(136, 14, 79));
        jLabel2.setText("ID:");

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(240, 240, 240));
        txtId.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtId.setForeground(new java.awt.Color(33, 33, 33));
        txtId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(136, 14, 79));
        jLabel3.setText("Cliente:");

        cmbCliente.setBackground(new java.awt.Color(255, 248, 250));
        cmbCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbCliente.setForeground(new java.awt.Color(136, 14, 79));
        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(136, 14, 79));
        jLabel4.setText("Servicio:");

        cmbTipoServicio.setBackground(new java.awt.Color(255, 248, 250));
        cmbTipoServicio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbTipoServicio.setForeground(new java.awt.Color(136, 14, 79));
        cmbTipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(136, 14, 79));
        jLabel5.setText("Fecha (dd/MM/yyyy):");

        txtFecha.setBackground(new java.awt.Color(255, 248, 250));
        txtFecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(33, 33, 33));
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(136, 14, 79));
        jLabel6.setText("Vehiculo:");

        cmbVehiculo.setBackground(new java.awt.Color(255, 248, 250));
        cmbVehiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbVehiculo.setForeground(new java.awt.Color(136, 14, 79));
        cmbVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));

        btnCrear.setBackground(new java.awt.Color(136, 14, 79));
        btnCrear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setText("Crear Cita");
        btnCrear.setFocusPainted(false);
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        tblCitas.setBackground(new java.awt.Color(255, 255, 255));
        tblCitas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Cliente", "Vehículo", "Servicio", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCitas.setRowHeight(24);
        tblCitas.setSelectionBackground(new java.awt.Color(240, 180, 210));
        tblCitas.setShowGrid(false);
        jScrollPane1.setViewportView(tblCitas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrear)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnCrear)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        Cliente  cliente  = obtenerClienteSeleccionado();
        Vehiculo vehiculo = obtenerVehiculoSeleccionado();
        Servicio servicio = obtenerServicioSeleccionado();
        String   fecha    = this.txtFecha.getText().trim();

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente.");
            return;
        }
        if (vehiculo == null) {
            JOptionPane.showMessageDialog(this,
                "El cliente seleccionado no tiene vehículos.");
            return;
        }
        if (servicio == null) {
            JOptionPane.showMessageDialog(this,
                "No existen servicios registrados.");
            return;
        }
        if (fecha.equals("")) {
            JOptionPane.showMessageDialog(this,
                "Debe ingresar la fecha de la cita.");
            return;
        }
        if (!Fecha.validarFecha(fecha)) {
            JOptionPane.showMessageDialog(this,
                "La fecha debe tener el formato dd/MM/yyyy.");
            return;
        }

        Cita cita = new Cita(cliente, vehiculo, fecha, servicio);
        Cita resultado = this.administrador.agregar(cita);

        if (resultado != null) {
            JOptionPane.showMessageDialog(this, "Cita creada correctamente.");
            cargarCitas();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this,
                "No hay bahías disponibles para ese servicio en la fecha solicitada.");
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        if (this.adminVehiculos != null && this.vehiculosDelCliente != null)
            cargarVehiculos();
    }//GEN-LAST:event_cmbClienteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new JFrameCitas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbTipoServicio;
    private javax.swing.JComboBox<String> cmbVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCitas;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
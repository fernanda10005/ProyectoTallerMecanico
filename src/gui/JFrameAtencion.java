package gui;

import Gestion.GestorDeMemoria;
import Gestion.gestor_ordenes;
import Gestion.gestor_servicios;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.DetalleRepuesto;
import modelo.EstadoOrden;
import modelo.OrdenTrabajo;
import modelo.Servicio;

public class JFrameAtencion extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = 
        java.util.logging.Logger.getLogger(JFrameAtencion.class.getName());

    private gestor_ordenes adminOrdenes;
    private gestor_servicios adminServicios;
    private DefaultTableModel tableModelOrdenes;
    private ArrayList<OrdenTrabajo> listaOrdenesActivas;

    public JFrameAtencion() {
        initComponents();
        this.adminOrdenes = GestorDeMemoria.getAdminOrdenes();
        this.adminServicios = GestorDeMemoria.getAdminServicios();
        this.listaOrdenesActivas = new ArrayList<>();
        
        getContentPane().setBackground(new Color(255, 240, 245)); // Rosa pastel
        
        configurarTablas();
        cargarServiciosDisponibles();
        cargarOrdenesActivas();
        this.setLocationRelativeTo(null);
    }

    private void configurarTablas() {
        this.tableModelOrdenes = new DefaultTableModel();
        this.tableModelOrdenes.addColumn("ID Orden");
        this.tableModelOrdenes.addColumn("Cliente");
        this.tableModelOrdenes.addColumn("Vehículo");
        this.tableModelOrdenes.addColumn("Bahía");
        this.tblOrdenesActivas.setModel(tableModelOrdenes);
    }

    private void cargarServiciosDisponibles() {
        cmbServiciosAdicionales.removeAllItems();
        for (Servicio s : adminServicios.getList()) {
            cmbServiciosAdicionales.addItem(s.getCodigo() + " - " + s.getNombre() + " (S/. " + s.getPrecio() + ")");
        }
    }

    private void cargarOrdenesActivas() {
        this.tableModelOrdenes.setRowCount(0);
        this.listaOrdenesActivas.clear();
        for (OrdenTrabajo o : adminOrdenes.getList()) {
            if (o != null && o.getEstado() == EstadoOrden.ACTIVA) {
                this.listaOrdenesActivas.add(o);
                String[] fila = new String[4];
                fila[0] = Integer.toString(o.getCodigo());
                fila[1] = o.getCita().getCliente().getNombre() + " " + o.getCita().getCliente().getApellido();
                fila[2] = o.getCita().getVehiculo().getPlaca() + " (" + o.getCita().getVehiculo().getMarca() + ")";
                fila[3] = "Bahía #" + o.getBahia().getCodigo();
                this.tableModelOrdenes.addRow(fila);
            }
        }
    }

    private OrdenTrabajo obtenerOrdenSeleccionada() {
        int index = tblOrdenesActivas.getSelectedRow();
        if (index >= 0 && index < listaOrdenesActivas.size()) {
            return listaOrdenesActivas.get(index);
        }
        return null;
    }

    private Servicio obtenerServicioSeleccionado() {
        int index = cmbServiciosAdicionales.getSelectedIndex();
        if (index >= 0) {
            return adminServicios.getList().get(index);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdenesActivas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreRepuesto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCantidadRepuesto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioRepuesto = new javax.swing.JTextField();
        btnAgregarRepuesto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cmbServiciosAdicionales = new javax.swing.JComboBox<>();
        btnAgregarServicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atención Activa del Vehículo (Mecánico)");

        jLabel1.setBackground(new java.awt.Color(136, 14, 79));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Atención del Vehículo (Registro de Consumos)");
        jLabel1.setOpaque(true);
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(136, 14, 79));
        jLabel2.setText("Seleccione la Orden de Trabajo a atender:");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        tblOrdenesActivas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblOrdenesActivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID Orden", "Cliente", "Vehículo", "Bahía"
            }
        ));
        tblOrdenesActivas.setRowHeight(24);
        tblOrdenesActivas.setSelectionBackground(new java.awt.Color(240, 180, 210));
        jScrollPane1.setViewportView(tblOrdenesActivas);

        jPanel1.setBackground(new java.awt.Color(255, 248, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)), "Consumo de Repuestos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(136, 14, 79))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(136, 14, 79));
        jLabel3.setText("Descripción del Repuesto:");

        txtNombreRepuesto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(136, 14, 79));
        jLabel4.setText("Cantidad:");

        txtCantidadRepuesto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(136, 14, 79));
        jLabel5.setText("Precio Unitario (S/.):");

        txtPrecioRepuesto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        btnAgregarRepuesto.setBackground(new java.awt.Color(136, 14, 79));
        btnAgregarRepuesto.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnAgregarRepuesto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarRepuesto.setText("Agregar Repuesto");
        btnAgregarRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRepuestoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreRepuesto)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtCantidadRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtPrecioRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 54, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregarRepuesto)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidadRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnAgregarRepuesto)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 248, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)), "Servicios Adicionales Consumidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(136, 14, 79))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(136, 14, 79));
        jLabel6.setText("Seleccione el Servicio Extra:");

        cmbServiciosAdicionales.setBackground(new java.awt.Color(255, 255, 255));

        btnAgregarServicio.setBackground(new java.awt.Color(136, 14, 79));
        btnAgregarServicio.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnAgregarServicio.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarServicio.setText("Agregar Servicio Adicional");
        btnAgregarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbServiciosAdicionales, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 96, Short.MAX_VALUE)
                        .addComponent(btnAgregarServicio)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbServiciosAdicionales, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarServicio)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRepuestoActionPerformed
        OrdenTrabajo orden = obtenerOrdenSeleccionada();
        if (orden == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una orden de trabajo activa.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombre = txtNombreRepuesto.getText().trim();
        String cantStr = txtCantidadRepuesto.getText().trim();
        String precStr = txtPrecioRepuesto.getText().trim();

        if (nombre.isEmpty() || cantStr.isEmpty() || precStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos del repuesto.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantStr);
            double precio = Double.parseDouble(precStr);

            if (cantidad <= 0 || precio <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad y precio deben ser mayores a cero.", "Error de Datos", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DetalleRepuesto repuesto = new DetalleRepuesto(nombre, cantidad, precio);
            boolean exito = orden.agregarRepuesto(repuesto);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Repuesto \"" + nombre + "\" asignado correctamente a la Orden #" + orden.getCodigo());
                txtNombreRepuesto.setText("");
                txtCantidadRepuesto.setText("");
                txtPrecioRepuesto.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar. Verifique que la orden esté activa.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Verifique los valores de cantidad y precio.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarRepuestoActionPerformed

    private void btnAgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarServicioActionPerformed
        OrdenTrabajo orden = obtenerOrdenSeleccionada();
        if (orden == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una orden de trabajo activa.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Servicio servicio = obtenerServicioSeleccionado();
        if (servicio == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un servicio del catálogo.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean exito = orden.agregarServicio(servicio);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Servicio adicional \"" + servicio.getNombre() + "\" cargado a la Orden #" + orden.getCodigo());
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo añadir. Verifique que la orden esté activa.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarServicioActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new JFrameAtencion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarRepuesto;
    private javax.swing.JButton btnAgregarServicio;
    private javax.swing.JComboBox<String> cmbServiciosAdicionales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrdenesActivas;
    private javax.swing.JTextField txtCantidadRepuesto;
    private javax.swing.JTextField txtNombreRepuesto;
    private javax.swing.JTextField txtPrecioRepuesto;
    // End of variables declaration//GEN-END:variables
}
package gui;

import Gestion.GestorDeMemoria;
import Gestion.gestor_ordenes;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.EstadoBahia;
import modelo.EstadoOrden;
import modelo.OrdenTrabajo;

public class JFrameEntrega extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(JFrameEntrega.class.getName());

    private gestor_ordenes administradorOrdenes;
    private DefaultTableModel tableModel;
    private ArrayList<OrdenTrabajo> ordenesActivas;

    public JFrameEntrega() {
        initComponents();
        this.administradorOrdenes = GestorDeMemoria.getAdminOrdenes();
        this.ordenesActivas = new ArrayList<>();
        
        // Ajustar fondo del JFrame al iniciar
        getContentPane().setBackground(new Color(255, 240, 245));
        
        agregarColumnasATabla();
        cargarOrdenes();
    }

    // ── Lógica ───────────────────────────────────────────────
    private void agregarColumnasATabla() {
        this.tableModel = new DefaultTableModel();
        this.tableModel.addColumn("Id");
        this.tableModel.addColumn("Cliente");
        this.tableModel.addColumn("Vehículo");
        this.tableModel.addColumn("Bahía");
        this.tableModel.addColumn("Fecha recepción");
        this.tableModel.addColumn("Estado");
        this.tblOrdenes.setModel(tableModel);
    }

    private void cargarOrdenes() {
        this.tableModel.setRowCount(0);
        this.ordenesActivas.clear();
        for (OrdenTrabajo o : this.administradorOrdenes.getList()) {
            if (o != null && o.getEstado() == EstadoOrden.ACTIVA) {
                this.ordenesActivas.add(o);
                String[] fila = new String[6];
                fila[0] = Integer.toString(o.getCodigo());
                fila[1] = o.getCita().getCliente().getNombre() + " " +
                          o.getCita().getCliente().getApellido();
                fila[2] = o.getCita().getVehiculo().getPlaca();
                fila[3] = Integer.toString(o.getBahia().getCodigo());
                fila[4] = o.getFechaRecepcion();
                fila[5] = o.getEstado().toString();
                this.tableModel.addRow(fila);
            }
        }
    }

    private OrdenTrabajo obtenerOrdenSeleccionada() {
        int index = this.tblOrdenes.getSelectedRow();
        if (index >= 0 && index < this.ordenesActivas.size())
            return this.ordenesActivas.get(index);
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdenes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtFechaEntrega = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbEstadoBahia = new javax.swing.JComboBox<>();
        btnEntregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrega de Vehiculo");
        setBackground(new java.awt.Color(255, 240, 245));

        jLabel1.setBackground(new java.awt.Color(136, 14, 79));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Entrega de Vehiculo");
        jLabel1.setOpaque(true);
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(136, 14, 79));
        jLabel2.setText("Seleccione la orden a entregar:");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        tblOrdenes.setBackground(new java.awt.Color(255, 255, 255));
        tblOrdenes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Cliente", "Vehículo", "Bahía", "Fecha recepción", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrdenes.setRowHeight(24);
        tblOrdenes.setSelectionBackground(new java.awt.Color(240, 180, 210));
        tblOrdenes.setShowGrid(false);
        jScrollPane1.setViewportView(tblOrdenes);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(136, 14, 79));
        jLabel3.setText("Fecha de entrega (dd/MM/yyyy):");

        txtFechaEntrega.setBackground(new java.awt.Color(255, 248, 250));
        txtFechaEntrega.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFechaEntrega.setForeground(new java.awt.Color(21, 21, 21));
        txtFechaEntrega.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(136, 14, 79));
        jLabel4.setText("Estado final de la bahía:");

        cmbEstadoBahia.setBackground(new java.awt.Color(255, 248, 250));
        cmbEstadoBahia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbEstadoBahia.setForeground(new java.awt.Color(136, 14, 79));
        cmbEstadoBahia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LIBRE", "EN_MANTENIMIENTO" }));

        btnEntregar.setBackground(new java.awt.Color(136, 14, 79));
        btnEntregar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnEntregar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntregar.setText("Registrar Entrega");
        btnEntregar.setFocusPainted(false);
        btnEntregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEstadoBahia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnEntregar))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbEstadoBahia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnEntregar)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregarActionPerformed
        OrdenTrabajo orden = obtenerOrdenSeleccionada();

        if (orden == null) {
            JOptionPane.showMessageDialog(this,
                "Debe seleccionar una orden activa.");
            return;
        }

        String fecha = this.txtFechaEntrega.getText().trim();
        if (fecha.equals("")) {
            JOptionPane.showMessageDialog(this,
                "Debe ingresar la fecha de entrega.");
            return;
        }

        String estadoStr = this.cmbEstadoBahia.getSelectedItem().toString();
        EstadoBahia estadoFinal = estadoStr.equals("LIBRE")
            ? EstadoBahia.LIBRE
            : EstadoBahia.EN_MANTENIMIENTO;

        boolean resultado = this.administradorOrdenes.entregar(
            orden, fecha, estadoFinal);

       if (resultado) {
            // Requerimiento 8: Cálculo automático y desglose de facturación al momento de la Entrega
            double manoObraServicios = orden.calcularTotalServicios();
            double repuestosAdicionales = orden.calcularTotalRepuestos();
            double totalFacturado = orden.calcularTotal();

            String mensajeFactura = "¡Entrega registrada correctamente!\n\n"
                    + "── DESGLOSE DE FACTURACIÓN AUTOMÁTICA ──\n"
                    + "(+) Mano de obra (Servicios): S/. " + String.format("%.2f", manoObraServicios) + "\n"
                    + "(+) Consumo de Repuestos/Adicionales: S/. " + String.format("%.2f", repuestosAdicionales) + "\n"
                    + "───────────────────────────────\n"
                    + "TOTAL NETO A COBRAR: S/. " + String.format("%.2f", totalFacturado) + "\n\n"
                    + "La Bahía #" + orden.getBahia().getCodigo() + " pasó a estado: " + estadoFinal;

            JOptionPane.showMessageDialog(this, mensajeFactura, "Facturación de Orden #" + orden.getCodigo(), JOptionPane.INFORMATION_MESSAGE);
            
            cargarOrdenes();
            this.txtFechaEntrega.setText("");
        } else {
            
            
            
            JOptionPane.showMessageDialog(this,
                "No se pudo registrar la entrega.\n" +
                "Verifique que la orden esté activa y la fecha sea válida.");
        }
    }//GEN-LAST:event_btnEntregarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new JFrameEntrega().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntregar;
    private javax.swing.JComboBox<String> cmbEstadoBahia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrdenes;
    private javax.swing.JTextField txtFechaEntrega;
    // End of variables declaration//GEN-END:variables
}
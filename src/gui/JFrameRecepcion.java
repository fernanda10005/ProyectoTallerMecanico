package gui;

import Gestion.GestorDeMemoria;
import Gestion.gestor_bahias;
import Gestion.gestor_citas;
import Gestion.gestor_ordenes;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Bahia;
import modelo.Cita;
import modelo.EstadoBahia;
import modelo.OrdenTrabajo;

public class JFrameRecepcion extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(JFrameRecepcion.class.getName());

    private gestor_ordenes administradorOrdenes;
    private gestor_citas   administradorCitas;
    private gestor_bahias  administradorBahias;

    private DefaultTableModel tableModelCitas;
    private DefaultTableModel tableModelBahias;

    private ArrayList<Cita>  citasDisponibles;
    private ArrayList<Bahia> bahiasDisponibles;

    public JFrameRecepcion() {
        initComponents();
        this.administradorOrdenes = GestorDeMemoria.getAdminOrdenes();
        this.administradorCitas   = GestorDeMemoria.getAdminCitas();
        this.administradorBahias  = GestorDeMemoria.getAdminBahias();
        this.citasDisponibles     = new ArrayList<>();
        this.bahiasDisponibles    = new ArrayList<>();

        // Fondo rosa pastel para el contenedor nativo
        getContentPane().setBackground(new Color(255, 240, 245));

        agregarColumnasTablaCitas();
        agregarColumnasTablaBahias();
        cargarCitas();
        cargarBahias();
    }

    // ── Lógica ───────────────────────────────────────────────
    private void agregarColumnasTablaCitas() {
        this.tableModelCitas = new DefaultTableModel();
        this.tableModelCitas.addColumn("Id");
        this.tableModelCitas.addColumn("Cliente");
        this.tableModelCitas.addColumn("Vehículo");
        this.tableModelCitas.addColumn("Servicio");
        this.tableModelCitas.addColumn("Fecha");
        this.tblCitas.setModel(tableModelCitas);
    }

    private void agregarColumnasTablaBahias() {
        this.tableModelBahias = new DefaultTableModel();
        this.tableModelBahias.addColumn("Id");
        this.tableModelBahias.addColumn("Tipo");
        this.tableModelBahias.addColumn("Capacidad");
        this.tableModelBahias.addColumn("Estado");
        this.tblBahias.setModel(tableModelBahias);
    }

    private void cargarCitas() {
        this.tableModelCitas.setRowCount(0);
        this.citasDisponibles.clear();
        for (Cita c : this.administradorCitas.getList()) {
            if (c != null) {
                this.citasDisponibles.add(c);
                String[] fila = new String[5];
                fila[0] = Integer.toString(c.getCodigo());
                fila[1] = c.getCliente().getNombre() + " " +
                          c.getCliente().getApellido();
                fila[2] = c.getVehiculo().getPlaca();
                fila[3] = c.getServicio().getNombre();
                fila[4] = c.getFecha();
                this.tableModelCitas.addRow(fila);
            }
        }
    }

    private void cargarBahias() {
        this.tableModelBahias.setRowCount(0);
        this.bahiasDisponibles.clear();
        for (Bahia b : this.administradorBahias.getList()) {
            if (b != null && b.getEstado() == EstadoBahia.LIBRE) {
                this.bahiasDisponibles.add(b);
                String[] fila = new String[4];
                fila[0] = Integer.toString(b.getCodigo());
                fila[1] = b.getTipo().toString();
                fila[2] = Integer.toString(b.getCapacidad());
                fila[3] = b.getEstado().toString();
                this.tableModelBahias.addRow(fila);
            }
        }
    }

    private Cita obtenerCitaSeleccionada() {
        int index = this.tblCitas.getSelectedRow();
        if (index >= 0 && index < this.citasDisponibles.size())
            return this.citasDisponibles.get(index);
        return null;
    }

    private Bahia obtenerBahiaSeleccionada() {
        int index = this.tblBahias.getSelectedRow();
        if (index >= 0 && index < this.bahiasDisponibles.size())
            return this.bahiasDisponibles.get(index);
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCitas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBahias = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recepcion de Vehiculo");
        setBackground(new java.awt.Color(255, 240, 245));

        jLabel1.setBackground(new java.awt.Color(136, 14, 79));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Recepcion de Vehiculo");
        jLabel1.setOpaque(true);
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(136, 14, 79));
        jLabel2.setText("Seleccione una cita:");

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

        jLabel3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(136, 14, 79));
        jLabel3.setText("Seleccione una bahia disponible:");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        tblBahias.setBackground(new java.awt.Color(255, 255, 255));
        tblBahias.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblBahias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Id", "Tipo", "Capacidad", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBahias.setRowHeight(24);
        tblBahias.setSelectionBackground(new java.awt.Color(240, 180, 210));
        tblBahias.setShowGrid(false);
        jScrollPane2.setViewportView(tblBahias);

        btnRegistrar.setBackground(new java.awt.Color(136, 14, 79));
        btnRegistrar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar Recepcion");
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnRegistrar)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Cita cita   = obtenerCitaSeleccionada();
        Bahia bahia = obtenerBahiaSeleccionada();

        if (cita == null) {
            JOptionPane.showMessageDialog(this,
                "Debe seleccionar una cita.");
            return;
        }
        if (bahia == null) {
            JOptionPane.showMessageDialog(this,
                "Debe seleccionar una bahía disponible.");
            return;
        }

        OrdenTrabajo orden    = new OrdenTrabajo(0, cita, bahia, "");
        OrdenTrabajo resultado = this.administradorOrdenes.agregar(orden);

        if (resultado != null) {
            JOptionPane.showMessageDialog(this,
                "Recepción registrada correctamente.\n" +
                "Orden de trabajo #" + resultado.getCodigo() + " creada.\n" +
                "Bahía #" + bahia.getCodigo() + " asignada.");
            cargarCitas();
            cargarBahias();
        } else {
            JOptionPane.showMessageDialog(this,
                "No se pudo registrar la recepción.\n" +
                "Verifique que la bahía esté LIBRE.");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new JFrameRecepcion().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBahias;
    private javax.swing.JTable tblCitas;
    // End of variables declaration//GEN-END:variables
}
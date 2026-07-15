package gui;

import Gestion.GestorDeMemoria;
import Gestion.gestor_servicios;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Servicio;
import modelo.TipoServicio;

public class JFrameServicios extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(JFrameServicios.class.getName());

    private gestor_servicios administrador;
    private DefaultTableModel tableModel;

    public JFrameServicios() {
        initComponents();
        this.administrador = GestorDeMemoria.getAdminServicios();
        
        // Ajustar fondo del JFrame al iniciar
        getContentPane().setBackground(new Color(255, 240, 245));
        
        agregarColumnasATabla();
        cargarServicios();
    }

    // ── Lógica ───────────────────────────────────────────────
    private void agregarColumnasATabla() {
        this.tableModel = new DefaultTableModel();
        this.tableModel.addColumn("Id");
        this.tableModel.addColumn("Nombre");
        this.tableModel.addColumn("Precio");
        this.tableModel.addColumn("Tipo");
        this.tblServicios.setModel(tableModel);
    }

    private void limpiarCampos() {
        this.txtId.setText("");
        this.txtNombre.setText("");
        this.txtPrecio.setText("");
        this.cmbTipo.setSelectedItem("CAMBIO DE ACEITE");
    }

    private void cargarServicios() {
        this.tableModel.setRowCount(0);
        ArrayList<Servicio> servicios = this.administrador.getList();
        for (Servicio s : servicios) {
            if (s != null) {
                String[] fila = new String[4];
                fila[0] = Integer.toString(s.getCodigo());
                fila[1] = s.getNombre();
                fila[2] = Double.toString(s.getPrecio());
                fila[3] = mostrarTipoServicio(s.getTipo());
                this.tableModel.addRow(fila);
            }
        }
    }

    private TipoServicio obtenerTipoServicio() {
        String tipo = this.cmbTipo.getSelectedItem().toString();
        if (tipo.equals("CAMBIO DE ACEITE"))        return TipoServicio.CAMBIO_DE_ACEITE;
        if (tipo.equals("ALINEACION Y BALANCEO"))   return TipoServicio.ALINEACION_Y_BALANCEO;
        if (tipo.equals("DIAGNOSTICO ELECTRONICO")) return TipoServicio.DIAGNOSTICO_ELECTRONICO;
        return null;
    }

    private String mostrarTipoServicio(TipoServicio tipo) {
        if (tipo == TipoServicio.CAMBIO_DE_ACEITE)        return "CAMBIO DE ACEITE";
        if (tipo == TipoServicio.ALINEACION_Y_BALANCEO)   return "ALINEACION Y BALANCEO";
        if (tipo == TipoServicio.DIAGNOSTICO_ELECTRONICO) return "DIAGNOSTICO ELECTRONICO";
        return "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de Servicios");
        setBackground(new java.awt.Color(255, 240, 245));

        jLabel1.setBackground(new java.awt.Color(136, 14, 79));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Servicios");
        jLabel1.setOpaque(true);
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(136, 14, 79));
        jLabel6.setText("ID:");

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(240, 240, 240));
        txtId.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtId.setForeground(new java.awt.Color(21, 21, 21));
        txtId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(136, 14, 79));
        jLabel7.setText("Nombre:");

        txtNombre.setBackground(new java.awt.Color(255, 248, 250));
        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(21, 21, 21));
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(136, 14, 79));
        jLabel8.setText("Precio:");

        txtPrecio.setBackground(new java.awt.Color(255, 248, 250));
        txtPrecio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(21, 21, 21));
        txtPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(136, 14, 79));
        jLabel9.setText("Tipo:");

        cmbTipo.setBackground(new java.awt.Color(255, 248, 250));
        cmbTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbTipo.setForeground(new java.awt.Color(136, 14, 79));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CAMBIO DE ACEITE", "ALINEACION Y BALANCEO", "DIAGNOSTICO ELECTRONICO" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

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

        tblServicios.setBackground(new java.awt.Color(255, 255, 255));
        tblServicios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Precio", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblServicios.setRowHeight(24);
        tblServicios.setSelectionBackground(new java.awt.Color(240, 180, 210));
        tblServicios.setShowGrid(false);
        jScrollPane1.setViewportView(tblServicios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int id = this.txtId.getText().equals("") ? 0
                : Integer.parseInt(this.txtId.getText());

        String nombre = this.txtNombre.getText().trim();
        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Debe ingresar el nombre del servicio.");
            return;
        }

        if (this.txtPrecio.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el precio.");
            return;
        }

        double precio;
        try {
            precio = Double.parseDouble(
                    this.txtPrecio.getText().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El precio debe ser un número válido.");
            return;
        }

        if (precio <= 0) {
            JOptionPane.showMessageDialog(this,
                    "El precio debe ser mayor que 0.");
            return;
        }

        TipoServicio tipo = obtenerTipoServicio();
        Servicio servicio = new Servicio(id, nombre, tipo, precio);
        Servicio resultado;

        if (id == 0) {
            resultado = administrador.agregar(servicio);
        } else {
            resultado = administrador.modificar(servicio);
        }

        if (resultado != null) {
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error!");
        }
        cargarServicios();
        limpiarCampos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int index = this.tblServicios.getSelectedRow();
        if (index >= 0) {
            int codigo = Integer.parseInt(
                    this.tableModel.getValueAt(index, 0).toString());
            Servicio s = administrador.buscar(codigo);
            boolean flag = false;
            if (s != null) {
                flag = this.administrador.eliminar(s);
            }
            if (flag) {
                JOptionPane.showMessageDialog(this,
                        "Servicio eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error!");
            }
            cargarServicios();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int index = this.tblServicios.getSelectedRow();
        if (index >= 0) {
            int codigo = Integer.parseInt(
                    this.tableModel.getValueAt(index, 0).toString());
            Servicio s = administrador.buscar(codigo);
            if (s != null) {
                this.txtId.setText(Integer.toString(s.getCodigo()));
                this.txtNombre.setText(s.getNombre());
                this.txtPrecio.setText(Double.toString(s.getPrecio()));
                this.cmbTipo.setSelectedItem(mostrarTipoServicio(s.getTipo()));
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // sin acción adicional
    }//GEN-LAST:event_cmbTipoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new JFrameServicios().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblServicios;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
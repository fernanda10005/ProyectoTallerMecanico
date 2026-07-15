package gui;

import Gestion.GestorDeMemoria;
import Gestion.gestor_empleados;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Rol;

public class JFrameEmpleados extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(JFrameEmpleados.class.getName());

    private gestor_empleados administrador;
    private DefaultTableModel tableModel;

    public JFrameEmpleados() {
        initComponents();
        this.administrador = GestorDeMemoria.getAdminEmpleados();
        
        // Ajustar fondo del JFrame al iniciar
        getContentPane().setBackground(new Color(255, 240, 245));
        
        agregarColumnasATabla();
        cargarEmpleados();
    }

    // ── Lógica ───────────────────────────────────────────────
    private void agregarColumnasATabla() {
        this.tableModel = new DefaultTableModel();
        this.tableModel.addColumn("Id");
        this.tableModel.addColumn("Nombre");
        this.tableModel.addColumn("Apellido");
        this.tableModel.addColumn("Dni");
        this.tableModel.addColumn("Rol");
        this.tblEmpleados.setModel(tableModel);
    }

    private void limpiarCampos() {
        this.txtID.setText("");
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.txtDni.setText("");
        this.cmbRol.setSelectedItem("MECANICO");
    }

    private void cargarEmpleados() {
        this.tableModel.setRowCount(0);
        ArrayList<Empleado> empleados = this.administrador.getList();
        for (Empleado e : empleados) {
            if (e != null) {
                String[] fila = new String[5];
                fila[0] = Integer.toString(e.getCodigo());
                fila[1] = e.getNombre();
                fila[2] = e.getApellido();
                fila[3] = e.getDni().toString();
                fila[4] = e.getRol().toString();
                this.tableModel.addRow(fila);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de Empleados");
        setBackground(new java.awt.Color(255, 240, 245));

        jLabel1.setBackground(new java.awt.Color(136, 14, 79));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Empleados");
        jLabel1.setOpaque(true);
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(136, 14, 79));
        jLabel2.setText("Nombre:");

        txtNombre.setBackground(new java.awt.Color(255, 248, 250));
        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(33, 33, 33));
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(136, 14, 79));
        jLabel3.setText("Apellido:");

        txtApellido.setBackground(new java.awt.Color(255, 248, 250));
        txtApellido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(33, 33, 33));
        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(136, 14, 79));
        jLabel4.setText("Dni:");

        txtDni.setBackground(new java.awt.Color(255, 248, 250));
        txtDni.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDni.setForeground(new java.awt.Color(33, 33, 33));
        txtDni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(136, 14, 79));
        jLabel5.setText("Rol:");

        cmbRol.setBackground(new java.awt.Color(255, 248, 250));
        cmbRol.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbRol.setForeground(new java.awt.Color(136, 14, 79));
        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MECANICO", "ASESOR", "ADMINISTRADOR" }));

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

        btnCrear.setBackground(new java.awt.Color(136, 14, 79));
        btnCrear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setText("Guardar");
        btnCrear.setFocusPainted(false);
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
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

        tblEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        tblEmpleados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellido", "Dni", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.setRowHeight(24);
        tblEmpleados.setSelectionBackground(new java.awt.Color(240, 180, 210));
        tblEmpleados.setShowGrid(false);
        jScrollPane1.setViewportView(tblEmpleados);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(136, 14, 79));
        jLabel6.setText("ID:");

        txtID.setEditable(false);
        txtID.setBackground(new java.awt.Color(240, 240, 240));
        txtID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtID.setForeground(new java.awt.Color(33, 33, 33));
        txtID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCrear)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellido)
                            .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        int id = this.txtID.getText().equals("") ? 0
                : Integer.parseInt(this.txtID.getText());
        String nombre   = this.txtNombre.getText().trim();
        String apellido = this.txtApellido.getText().trim();
        String dni      = this.txtDni.getText().trim();

        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre.");
            return;
        }
        if (apellido.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el apellido.");
            return;
        }
        if (dni.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el DNI.");
            return;
        }

        Rol rol = Rol.valueOf(this.cmbRol.getSelectedItem().toString());
        Empleado empleado = new Empleado(id, dni, nombre, apellido, rol);
        Empleado resultado;

        if (id == 0) {
            resultado = administrador.agregar(empleado);
        } else {
            resultado = administrador.modificar(empleado);
        }

        if (resultado != null) {
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error!");
        }
        cargarEmpleados();
        limpiarCampos();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int index = this.tblEmpleados.getSelectedRow();
        if (index >= 0) {
            int codigo = Integer.parseInt(
                    this.tableModel.getValueAt(index, 0).toString());
            Empleado e = administrador.buscar(codigo);
            if (e != null) {
                this.txtID.setText(Integer.toString(e.getCodigo()));
                this.txtNombre.setText(e.getNombre());
                this.txtApellido.setText(e.getApellido());
                this.txtDni.setText(e.getDni());
                this.cmbRol.setSelectedItem(e.getRol().toString());
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int index = this.tblEmpleados.getSelectedRow();
        if (index >= 0) {
            int codigo = Integer.parseInt(
                    this.tableModel.getValueAt(index, 0).toString());
            Empleado e = administrador.buscar(codigo);
            boolean flag = false;
            if (e != null) {
                flag = this.administrador.eliminar(e);
            }
            if (flag) {
                JOptionPane.showMessageDialog(this,
                        "Empleado eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error!");
            }
            cargarEmpleados();
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
            new JFrameEmpleados().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
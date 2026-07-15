package gui;

import Gestion.GestorDeMemoria;
import Gestion.gestor_clientes;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;

public class JFrameClientes extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(JFrameClientes.class.getName());

    private gestor_clientes administrador;
    private DefaultTableModel tableModel;

    public JFrameClientes() {
        initComponents();
        this.administrador = GestorDeMemoria.getAdminClientes();
        
        // Ajustar fondo del Frame al cargar
        getContentPane().setBackground(new Color(255, 240, 245));
        
        agregarColumnasATabla();
        cargarClientes();
    }

    // ── Lógica ───────────────────────────────────────────────
    private void agregarColumnasATabla() {
        this.tableModel = new DefaultTableModel();
        this.tableModel.addColumn("Id");
        this.tableModel.addColumn("Documento");
        this.tableModel.addColumn("Nombre");
        this.tableModel.addColumn("Apellido");
        this.tableModel.addColumn("Contacto");
        this.tblClientes.setModel(tableModel);
    }

    private void limpiarCampos() {
        this.txtId.setText("");
        this.txtDocumento.setText("");
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.txtContacto.setText("");
    }

    private void cargarClientes() {
        this.tableModel.setRowCount(0);
        ArrayList<Cliente> clientes = this.administrador.getList();
        for (Cliente c : clientes) {
            if (c != null) {
                String[] fila = new String[5];
                fila[0] = Integer.toString(c.getCodigo());
                fila[1] = c.getDocumento();
                fila[2] = c.getNombre();
                fila[3] = c.getApellido();
                fila[4] = c.getContacto();
                this.tableModel.addRow(fila);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de Clientes");
        setBackground(new java.awt.Color(255, 240, 245));

        jLabel6.setBackground(new java.awt.Color(136, 14, 79));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Registro de Clientes");
        jLabel6.setOpaque(true);
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(136, 14, 79));
        jLabel1.setText("ID:");

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(240, 240, 240));
        txtId.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtId.setForeground(new java.awt.Color(33, 33, 33));
        txtId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(136, 14, 79));
        jLabel5.setText("Dni/Ruc:");

        txtDocumento.setBackground(new java.awt.Color(255, 248, 250));
        txtDocumento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDocumento.setForeground(new java.awt.Color(33, 33, 33));
        txtDocumento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

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
        jLabel4.setText("Contacto:");

        txtContacto.setBackground(new java.awt.Color(255, 248, 250));
        txtContacto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtContacto.setForeground(new java.awt.Color(33, 33, 33));
        txtContacto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

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

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        tblClientes.setBackground(new java.awt.Color(255, 255, 255));
        tblClientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Documento", "Nombre", "Apellido", "Contacto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setRowHeight(24);
        tblClientes.setSelectionBackground(new java.awt.Color(240, 180, 210));
        tblClientes.setShowGrid(false);
        jScrollPane2.setViewportView(tblClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int id = this.txtId.getText().trim().equals("") ? 0
                : Integer.parseInt(this.txtId.getText().trim());

        String documento = this.txtDocumento.getText().trim();
        String nombre    = this.txtNombre.getText().trim();
        String apellido  = this.txtApellido.getText().trim();
        String contacto  = this.txtContacto.getText().trim();

        if (documento.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el DNI o RUC.");
            return;
        }
        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre.");
            return;
        }
        if (apellido.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el apellido.");
            return;
        }
        if (contacto.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el contacto.");
            return;
        }

        Cliente cliente = new Cliente(id, documento, nombre, apellido, contacto);
        Cliente resultado;

        if (id == 0) {
            resultado = administrador.agregar(cliente);
        } else {
            resultado = administrador.modificar(cliente);
        }

        if (resultado != null) {
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error!");
        }
        cargarClientes();
        limpiarCampos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int index = this.tblClientes.getSelectedRow();
        if (index >= 0) {
            int codigo = Integer.parseInt(
                    this.tableModel.getValueAt(index, 0).toString());
            Cliente c = administrador.buscar(codigo);
            if (c != null) {
                this.txtId.setText(Integer.toString(c.getCodigo()));
                this.txtDocumento.setText(c.getDocumento());
                this.txtNombre.setText(c.getNombre());
                this.txtApellido.setText(c.getApellido());
                this.txtContacto.setText(c.getContacto());
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int index = this.tblClientes.getSelectedRow();
        if (index >= 0) {
            int codigo = Integer.parseInt(
                    this.tableModel.getValueAt(index, 0).toString());
            Cliente c = administrador.buscar(codigo);
            boolean flag = false;
            if (c != null) {
                flag = this.administrador.eliminar(c);
            }
            if (flag) {
                JOptionPane.showMessageDialog(this,
                        "Cliente eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error!");
            }
            cargarClientes();
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
            new JFrameClientes().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
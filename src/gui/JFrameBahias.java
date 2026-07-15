package gui;

import Gestion.GestorDeMemoria;
import Gestion.gestor_bahias;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Bahia;
import modelo.TipoBahia;
import modelo.EstadoBahia;

public class JFrameBahias extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(JFrameBahias.class.getName());

    private gestor_bahias administrador;
    private DefaultTableModel tableModel;

    public JFrameBahias() {
        initComponents();
        this.administrador = GestorDeMemoria.getAdminBahias();
        agregarColumnasATabla();
        cargarBahias();
        aplicarEstilo();
    }

    // ── Estilo ───────────────────────────────────────────────
    private void aplicarEstilo() {
        // Fondo general
        getContentPane().setBackground(new Color(255, 240, 245));

        // Título
        jLabel1.setOpaque(true);
        jLabel1.setBackground(new Color(136, 14, 79));
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(new Font("Arial", Font.BOLD, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Labels
        Color colorLabel = new Color(136, 14, 79);
        Font fuenteLabel = new Font("Arial", Font.BOLD, 12);
        jLabel2.setForeground(colorLabel); jLabel2.setFont(fuenteLabel);
        jLabel3.setForeground(colorLabel); jLabel3.setFont(fuenteLabel);
        jLabel4.setForeground(colorLabel); jLabel4.setFont(fuenteLabel);
        jLabel5.setForeground(colorLabel); jLabel5.setFont(fuenteLabel);

        // Campos
        Color fondoCampo = new Color(255, 248, 250);
        Color bordeCampo = new Color(194, 24, 91);
        estilizarCampo(txtId,       new Color(240, 240, 240), bordeCampo);
        estilizarCampo(txtCapacidad, fondoCampo, bordeCampo);

        // Combos
        Color fondoCombo = new Color(255, 248, 250);
        cmbTipo.setBackground(fondoCombo);
        cmbTipo.setForeground(new Color(136, 14, 79));
        cmbTipo.setFont(new Font("Arial", Font.PLAIN, 12));

        cmbEstado.setBackground(fondoCombo);
        cmbEstado.setForeground(new Color(136, 14, 79));
        cmbEstado.setFont(new Font("Arial", Font.PLAIN, 12));

        // Botones
        EstiloUI.estilizarBotonGuardar(btnGuardar);
        EstiloUI.estilizarBotonModificar(btnModificar);
        EstiloUI.estilizarBotonEliminar(btnEliminar);

        // Tabla
        EstiloUI.estilizarTabla(tblBahias);
        jScrollPane1.setBorder(
            javax.swing.BorderFactory.createLineBorder(
                new Color(194, 24, 91), 1));
    }

    private void estilizarCampo(javax.swing.JTextField campo,
                                  Color fondo, Color borde) {
        campo.setBackground(fondo);
        campo.setForeground(new Color(33, 33, 33));
        campo.setFont(new Font("Arial", Font.PLAIN, 12));
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(borde, 1),
            javax.swing.BorderFactory.createEmptyBorder(3, 6, 3, 6)));
    }

    // ── Lógica ───────────────────────────────────────────────
    private void agregarColumnasATabla() {
        this.tableModel = new DefaultTableModel();
        this.tableModel.addColumn("Id");
        this.tableModel.addColumn("Capacidad");
        this.tableModel.addColumn("Tipo");
        this.tableModel.addColumn("Estado");
        this.tblBahias.setModel(tableModel);
    }

    private void limpiarCampos() {
        this.txtId.setText("");
        this.txtCapacidad.setText("");
        this.cmbTipo.setSelectedItem("MECANICA GENERAL");
        this.cmbEstado.setSelectedItem("LIBRE");
    }

    private void cargarBahias() {
        this.tableModel.setRowCount(0);
        ArrayList<Bahia> bahias = this.administrador.getList();
        for (Bahia b : bahias) {
            if (b != null) {
                String[] fila = new String[4];
                fila[0] = Integer.toString(b.getCodigo());
                fila[1] = Integer.toString(b.getCapacidad());
                fila[2] = mostrarTipoBahia(b.getTipo());
                fila[3] = mostrarEstadoBahia(b.getEstado());
                this.tableModel.addRow(fila);
            }
        }
    }

    private TipoBahia obtenerTipoBahia() {
        String tipo = this.cmbTipo.getSelectedItem().toString();
        if (tipo.equals("MECANICA GENERAL"))    return TipoBahia.MECANICA_GENERAL;
        if (tipo.equals("PLANCHADO Y PINTURA")) return TipoBahia.PLANCHADO_PINTURA;
        if (tipo.equals("ELECTRICIDAD"))        return TipoBahia.ELECTRICIDAD;
        return null;
    }

    private String mostrarTipoBahia(TipoBahia tipo) {
        if (tipo == TipoBahia.MECANICA_GENERAL)  return "MECANICA GENERAL";
        if (tipo == TipoBahia.PLANCHADO_PINTURA) return "PLANCHADO Y PINTURA";
        if (tipo == TipoBahia.ELECTRICIDAD)      return "ELECTRICIDAD";
        return "";
    }

    private EstadoBahia obtenerEstadoBahia() {
        String estado = this.cmbEstado.getSelectedItem().toString();
        if (estado.equals("LIBRE"))              return EstadoBahia.LIBRE;
        if (estado.equals("OCUPADA"))            return EstadoBahia.OCUPADA;
        if (estado.equals("EN MANTENIMIENTO"))   return EstadoBahia.EN_MANTENIMIENTO;
        return null;
    }

    private String mostrarEstadoBahia(EstadoBahia estado) {
        if (estado == EstadoBahia.LIBRE)            return "LIBRE";
        if (estado == EstadoBahia.OCUPADA)          return "OCUPADA";
        if (estado == EstadoBahia.EN_MANTENIMIENTO) return "EN MANTENIMIENTO";
        return "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBahias = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de Bahias");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Registro de Bahias");

        jLabel2.setText("ID:");

        txtId.setEditable(false);

        jLabel3.setText("Capacidad:");

        jLabel4.setText("Tipo:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MECANICA GENERAL", "PLANCHADO Y PINTURA", "ELECTRICIDAD" }));

        tblBahias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Id", "Capacidad", "Tipo", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tblBahias);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LIBRE", "OCUPADA", "EN MANTENIMIENTO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int id = this.txtId.getText().equals("") ? 0
                : Integer.parseInt(this.txtId.getText());

        if (this.txtCapacidad.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la capacidad.");
            return;
        }

        int capacidad;
        try {
            capacidad = Integer.parseInt(this.txtCapacidad.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La capacidad debe ser un número entero.");
            return;
        }

        if (capacidad <= 0) {
            JOptionPane.showMessageDialog(this,
                    "La capacidad debe ser mayor que 0.");
            return;
        }

        TipoBahia tipo    = obtenerTipoBahia();
        EstadoBahia estado = obtenerEstadoBahia();
        Bahia bahia = new Bahia(id, capacidad, tipo, estado);
        Bahia resultado;

        if (id == 0) {
            resultado = administrador.agregar(bahia);
        } else {
            resultado = administrador.modificar(bahia);
        }

        if (resultado != null) {
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error!");
        }
        cargarBahias();
        limpiarCampos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int index = this.tblBahias.getSelectedRow();
        if (index >= 0) {
            int codigo = Integer.parseInt(
                    this.tableModel.getValueAt(index, 0).toString());
            Bahia b = administrador.buscar(codigo);
            if (b != null) {
                this.txtId.setText(Integer.toString(b.getCodigo()));
                this.txtCapacidad.setText(Integer.toString(b.getCapacidad()));
                this.cmbTipo.setSelectedItem(mostrarTipoBahia(b.getTipo()));
                this.cmbEstado.setSelectedItem(mostrarEstadoBahia(b.getEstado()));
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int index = this.tblBahias.getSelectedRow();
        if (index >= 0) {
            int codigo = Integer.parseInt(
                    this.tableModel.getValueAt(index, 0).toString());
            Bahia b = administrador.buscar(codigo);
            boolean flag = false;
            if (b != null) {
                flag = this.administrador.eliminar(b);
            }
            if (flag) {
                JOptionPane.showMessageDialog(this,
                        "Bahía eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error!");
            }
            cargarBahias();
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
            new JFrameBahias().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBahias;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
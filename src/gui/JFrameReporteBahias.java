package gui;

import Gestion.GestorDeMemoria;
import Gestion.gestor_bahias;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import modelo.Bahia;
import modelo.EstadoBahia;
import javax.swing.table.JTableHeader;

public class JFrameReporteBahias extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(JFrameReporteBahias.class.getName());

    private gestor_bahias administrador;
    private DefaultTableModel tableModel;

    public JFrameReporteBahias() {
        initComponents();
        this.administrador = GestorDeMemoria.getAdminBahias();
        
        // Ajustar fondo base rosa pastel
        getContentPane().setBackground(new Color(255, 240, 245));
        
        agregarColumnasATabla();
        cargarBahias();
        this.setLocationRelativeTo(null);
        aplicarEstilo();
    }

    // ── Estilo ───────────────────────────────────────────────
    private void aplicarEstilo() {
        // Tabla con colores por estado
        JTableHeader header = tblBahias.getTableHeader();
        header.setBackground(new Color(136, 14, 79));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 12));

        tblBahias.setFont(new Font("Arial", Font.PLAIN, 12));
        tblBahias.setGridColor(new Color(238, 238, 238));

        // Renderer especial — colorea la fila según estado
        tblBahias.setDefaultRenderer(Object.class,
            new DefaultTableCellRenderer() {
                @Override
                public java.awt.Component getTableCellRendererComponent(
                        javax.swing.JTable t, Object val,
                        boolean sel, boolean foc, int row, int col) {
                    super.getTableCellRendererComponent(
                            t, val, sel, foc, row, col);
                    if (!sel) {
                        String estado = "";
                        if (t.getModel().getValueAt(row, 3) != null) {
                            estado = t.getModel().getValueAt(row, 3).toString();
                        }
                        switch (estado) {
                            case "LIBRE":
                                setBackground(new Color(232, 255, 232));
                                setForeground(new Color(22, 100, 22));
                                break;
                            case "OCUPADA":
                                setBackground(new Color(255, 232, 232));
                                setForeground(new Color(180, 0, 0));
                                break;
                            case "EN_MANTENIMIENTO":
                                setBackground(new Color(255, 248, 220));
                                setForeground(new Color(150, 100, 0));
                                break;
                            default:
                                setBackground(row % 2 == 0
                                    ? Color.WHITE
                                    : new Color(255, 248, 250));
                                setForeground(new Color(33, 33, 33));
                        }
                        if (col == 3) {
                            setFont(new Font("Arial", Font.BOLD, 12));
                        } else {
                            setFont(new Font("Arial", Font.PLAIN, 12));
                        }
                    }
                    return this;
                }
            });
    }

    // ── Lógica ───────────────────────────────────────────────
    private void agregarColumnasATabla() {
        this.tableModel = new DefaultTableModel();
        this.tableModel.addColumn("Id");
        this.tableModel.addColumn("Tipo");
        this.tableModel.addColumn("Capacidad");
        this.tableModel.addColumn("Estado");
        this.tblBahias.setModel(tableModel);
    }

    private void cargarBahias() {
        this.tableModel.setRowCount(0);
        ArrayList<Bahia> bahias = this.administrador.getList();
        for (Bahia b : bahias) {
            if (b != null) {
                String[] fila = new String[4];
                fila[0] = Integer.toString(b.getCodigo());
                fila[1] = b.getTipo().toString();
                fila[2] = Integer.toString(b.getCapacidad());
                fila[3] = b.getEstado().toString();
                this.tableModel.addRow(fila);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBahias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte de Bahias");
        setBackground(new java.awt.Color(255, 240, 245));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

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
        tblBahias.setRowHeight(26);
        tblBahias.setSelectionBackground(new java.awt.Color(240, 180, 210));
        tblBahias.setSelectionForeground(new java.awt.Color(136, 14, 79));
        jScrollPane1.setViewportView(tblBahias);

        jLabel1.setBackground(new java.awt.Color(136, 14, 79));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reporte de Ocupacion de Bahias");
        jLabel1.setOpaque(true);
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 20, 12, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new JFrameReporteBahias().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBahias;
    // End of variables declaration//GEN-END:variables
}
package gui;

import Gestion.GestorDeMemoria;
import Gestion.gestor_ordenes;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import modelo.OrdenTrabajo;

// AGREGAR ESTOS TRES IMPORTS:
import modelo.Servicio;
import javax.swing.JOptionPane;

public class JFrameReporteIngresos extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(JFrameReporteIngresos.class.getName());

    private gestor_ordenes administradorOrdenes;
    private DefaultTableModel tableModel;

public JFrameReporteIngresos() {
        initComponents();
        this.administradorOrdenes = GestorDeMemoria.getAdminOrdenes();
        
        // Ajustar fondo base rosa pastel
        getContentPane().setBackground(new Color(255, 240, 245));
        
        agregarColumnasATabla();
        cargarReporteIngresos();
        this.setLocationRelativeTo(null);
        aplicarEstilo();
        
        // AGREGAR ESTO: Escucha de doble clic en la tabla para ver el desglose del mecánico
        tblIngresos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) { // Detectar Doble Clic
                    mostrarDetalleDeFila();
                }
            }
        });
    }

    // ── Estilo ───────────────────────────────────────────────
    private void aplicarEstilo() {
        JTableHeader header = tblIngresos.getTableHeader();
        header.setBackground(new Color(136, 14, 79));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 12));

        tblIngresos.setFont(new Font("Arial", Font.PLAIN, 12));
        tblIngresos.setGridColor(new Color(238, 238, 238));

        // Renderer para alternar colores de fila y destacar la columna de montos
        tblIngresos.setDefaultRenderer(Object.class,
            new DefaultTableCellRenderer() {
                @Override
                public java.awt.Component getTableCellRendererComponent(
                        javax.swing.JTable t, Object val,
                        boolean sel, boolean foc, int row, int col) {
                    super.getTableCellRendererComponent(
                            t, val, sel, foc, row, col);
                    if (!sel) {
                        setBackground(row % 2 == 0
                            ? Color.WHITE
                            : new Color(255, 248, 250));
                        setForeground(new Color(33, 33, 33));
                    }
                    
                    // Resaltar en negrita la columna de montos (Columna 4)
                    if (col == 4) {
                        setFont(new Font("Arial", Font.BOLD, 12));
                        setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                    } else {
                        setFont(new Font("Arial", Font.PLAIN, 12));
                        setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                    }
                    return this;
                }
            });
    }

    // ── Lógica ───────────────────────────────────────────────
    private void agregarColumnasATabla() {
        this.tableModel = new DefaultTableModel();
        this.tableModel.addColumn("Id Orden");
        this.tableModel.addColumn("Cliente");
        this.tableModel.addColumn("Vehículo");
        this.tableModel.addColumn("Fecha Entrega");
        this.tableModel.addColumn("Monto Total");
        this.tblIngresos.setModel(tableModel);
    }

    private void cargarReporteIngresos() {
        this.tableModel.setRowCount(0);
        double acumuladoTotal = 0.0;
        ArrayList<OrdenTrabajo> ordenes = this.administradorOrdenes.getList();
        
        for (OrdenTrabajo o : ordenes) {
            if (o != null && o.getFechaEntrega() != null && !o.getFechaEntrega().isEmpty()) {
                double totalOrden = o.calcularTotal();
                acumuladoTotal += totalOrden;

                String[] fila = new String[5];
                fila[0] = Integer.toString(o.getCodigo());
                fila[1] = o.getCita().getCliente().getNombre() + " " + o.getCita().getCliente().getApellido();
                fila[2] = o.getCita().getVehiculo().getPlaca() + " (" + o.getCita().getVehiculo().getMarca() + ")";
                fila[3] = o.getFechaEntrega();
                fila[4] = "S/. " + String.format("%.2f", totalOrden);
                
                this.tableModel.addRow(fila);
            }
        }
        this.txtTotalIngresos.setText("S/. " + String.format("%.2f", acumuladoTotal));
    }

   
private void mostrarDetalleDeFila() {
        int filaSeleccionada = tblIngresos.getSelectedRow();
        if (filaSeleccionada < 0) return;

        // Obtener el ID de la orden de la primera columna de la fila seleccionada
        String idOrdenStr = tblIngresos.getValueAt(filaSeleccionada, 0).toString();
        int idOrden = Integer.parseInt(idOrdenStr);

        // Buscar la orden correspondiente en nuestro gestor
        OrdenTrabajo orden = null;
        for (OrdenTrabajo o : administradorOrdenes.getList()) {
            if (o != null && o.getCodigo() == idOrden) {
                orden = o;
                break;
            }
        }

        if (orden == null) return;

        // Construir la factura/desglose estético
        StringBuilder sb = new StringBuilder();
        sb.append("📋 DETALLE DE TRABAJOS Y CONSUMOS - ORDEN #").append(orden.getCodigo()).append("\n");
        sb.append("Cliente: ").append(orden.getCita().getCliente().getNombre()).append(" ").append(orden.getCita().getCliente().getApellido()).append("\n");
        sb.append("Vehículo: ").append(orden.getCita().getVehiculo().getPlaca()).append(" (").append(orden.getCita().getVehiculo().getMarca()).append(")\n");
        sb.append("Fecha Entrega: ").append(orden.getFechaEntrega()).append("\n");
        sb.append("────────────────────────────────────────\n\n");

        // 1. Desglose de Servicios
        sb.append("🛠️ SERVICIOS REALIZADOS (MANO DE OBRA):\n");
        if (orden.getServicios().isEmpty()) {
            sb.append("   - Ninguno registrado\n");
        } else {
            for (Servicio s : orden.getServicios()) {
                sb.append("   • ").append(s.getNombre()).append(" ── S/. ").append(String.format("%.2f", s.getPrecio())).append("\n");
            }
        }
        sb.append("   > Total Servicios: S/. ").append(String.format("%.2f", orden.calcularTotalServicios())).append("\n\n");

        // 2. Desglose de Repuestos
        sb.append("⚙️ REPUESTOS Y ADICIONALES CONSUMIDOS:\n");
        if (orden.getRepuestos().isEmpty()) {
            sb.append("   - Ningún repuesto consumido\n");
        } else {
            for (modelo.DetalleRepuesto r : orden.getRepuestos()) {
                sb.append("   • ").append(r.getNombre())
                  .append(" (x").append(r.getCantidad()).append(") ")
                  .append("[c/u S/. ").append(String.format("%.2f", r.getPrecioUnitario())).append("]")
                  .append(" ── Subtotal: S/. ").append(String.format("%.2f", r.calcularSubtotal())).append("\n");
            }
        }
        sb.append("   > Total Repuestos: S/. ").append(String.format("%.2f", orden.calcularTotalRepuestos())).append("\n\n");

        sb.append("────────────────────────────────────────\n");
        sb.append("💰 MONTO TOTAL COBRADO: S/. ").append(String.format("%.2f", orden.calcularTotal())).append("\n");

        // Mostrar en una caja de diálogo con tipografía monospaced para que las columnas se alineen impecablemente
        javax.swing.JTextArea textArea = new javax.swing.JTextArea(sb.toString());
        textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        textArea.setEditable(false);
        
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(500, 380));

        JOptionPane.showMessageDialog(this, scrollPane, "Detalle de Facturación - Orden #" + idOrden, JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    
    
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblIngresos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        txtTotalIngresos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte de Ingresos");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        tblIngresos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Id Orden", "Cliente", "Vehículo", "Fecha Entrega", "Monto Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIngresos.setRowHeight(26);
        tblIngresos.setSelectionBackground(new java.awt.Color(240, 180, 210));
        tblIngresos.setSelectionForeground(new java.awt.Color(136, 14, 79));
        jScrollPane1.setViewportView(tblIngresos);

        jLabel1.setBackground(new java.awt.Color(136, 14, 79));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reporte Económico de Ingresos");
        jLabel1.setOpaque(true);
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 20, 12, 20));

        jLabelTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(136, 14, 79));
        jLabelTotal.setText("TOTAL RECAUDADO:");

        txtTotalIngresos.setEditable(false);
        txtTotalIngresos.setBackground(new java.awt.Color(255, 248, 250));
        txtTotalIngresos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtTotalIngresos.setForeground(new java.awt.Color(136, 14, 79));
        txtTotalIngresos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalIngresos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 24, 91)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTotal)
                        .addGap(10, 10, 10)
                        .addComponent(txtTotalIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotal)
                    .addComponent(txtTotalIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
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
            new JFrameReporteIngresos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblIngresos;
    private javax.swing.JTextField txtTotalIngresos;
    // End of variables declaration//GEN-END:variables
}
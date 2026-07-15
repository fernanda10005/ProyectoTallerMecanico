package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class EstiloUI {

    // ── Colores ──────────────────────────────────────────────
    public static final Color PRIMARIO   = new Color(136, 14, 79);
    public static final Color SECUNDARIO = new Color(194, 24, 91);
    public static final Color GRIS       = new Color(84, 110, 122);
    public static final Color PELIGRO    = new Color(198, 40, 40);
    public static final Color FONDO      = new Color(245, 245, 245);
    public static final Color HDR_TABLA  = new Color(252, 228, 236);
    public static final Color FILA_ALT   = new Color(255, 248, 250);
    public static final Color BLANCO     = Color.WHITE;
    public static final Color SELECCION  = new Color(240, 180, 210);

    // ── Métodos de estilo ─────────────────────────────────────

    public static void aplicarFondo(javax.swing.JFrame frame) {
        frame.getContentPane().setBackground(FONDO);
    }

    public static void estilizarTitulo(JLabel label) {
        label.setForeground(PRIMARIO);
        label.setFont(new Font("Arial", Font.BOLD, 20));
    }

    public static void estilizarPanelTitulo(JPanel panel, JLabel titulo) {
        panel.setBackground(PRIMARIO);
        titulo.setForeground(BLANCO);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
    }

    public static void estilizarBotonGuardar(JButton btn) {
        btn.setBackground(SECUNDARIO);
        btn.setForeground(BLANCO);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
    }

    public static void estilizarBotonModificar(JButton btn) {
        btn.setBackground(GRIS);
        btn.setForeground(BLANCO);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
    }

    public static void estilizarBotonEliminar(JButton btn) {
        btn.setBackground(PELIGRO);
        btn.setForeground(BLANCO);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
    }

    public static void estilizarBotonGeneral(JButton btn) {
        btn.setBackground(PRIMARIO);
        btn.setForeground(BLANCO);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
    }

    public static void estilizarTabla(JTable tabla) {
        // Header
        JTableHeader header = tabla.getTableHeader();
        header.setBackground(PRIMARIO);
        header.setForeground(BLANCO);
        header.setFont(new Font("Arial", Font.BOLD, 12));

        // Filas alternas
        tabla.setBackground(BLANCO);
        tabla.setForeground(new Color(33, 33, 33));
        tabla.setFont(new Font("Arial", Font.PLAIN, 12));
        tabla.setRowHeight(24);
        tabla.setGridColor(new Color(238, 238, 238));
        tabla.setSelectionBackground(SELECCION);
        tabla.setSelectionForeground(PRIMARIO);

        tabla.setDefaultRenderer(Object.class,
            new DefaultTableCellRenderer() {
                @Override
                public java.awt.Component getTableCellRendererComponent(
                        JTable t, Object val, boolean sel,
                        boolean foc, int row, int col) {
                    super.getTableCellRendererComponent(
                            t, val, sel, foc, row, col);
                    if (!sel) {
                        setBackground(row % 2 == 0 ? BLANCO : FILA_ALT);
                        setForeground(new Color(33, 33, 33));
                    }
                    return this;
                }
            });
    }
}
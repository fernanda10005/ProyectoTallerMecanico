package gui;

import java.awt.Color;
import java.awt.Font;

public class Principal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(Principal.class.getName());

    static final Color COLOR_PRIMARIO  = new Color(136, 14, 79);
    static final Color COLOR_SECUNDARIO = new Color(194, 24, 91);
    static final Color COLOR_FONDO     = new Color(255, 240, 245);
    static final Color BLANCO          = java.awt.Color.WHITE;

    private String rolActual;
    
    // Botones del panel lateral izquierdo
    private javax.swing.JButton btnAdminLateral;
    private javax.swing.JButton btnAsesorLateral;
    private javax.swing.JButton btnMecanicoLateral;
    private javax.swing.JButton btnSalirLateral;

    public Principal(String rol) {
        this.rolActual = rol;
        initComponents();
        aplicarEstilo();
        restringirMenuPorRol();
        agregarContenidoCentral();
        setMinimumSize(new java.awt.Dimension(850, 550));
        setLocationRelativeTo(null);
    }

    private void abrirVentana(javax.swing.JFrame ventana) {
        if (ventana != null) {
            ventana.setVisible(true);
        }
    }

    private void restringirMenuPorRol() {
        switch (rolActual) {
            case "Administrador":
                break;
            case "Asesor":
                jMenu3.setVisible(false);
                break;
            case "Mecanico":
                jMenu3.setVisible(false);
                jMenu4.setVisible(false);
                break;
        }
    }

    private void aplicarEstilo() {
        getContentPane().setBackground(COLOR_FONDO);
        if (jMenuBar2 != null) {
            jMenuBar2.setVisible(false);
        }
    }

    private void agregarContenidoCentral() {
        getContentPane().setLayout(new java.awt.BorderLayout());

        // ── 1. PANEL LATERAL IZQUIERDO (SIDEBAR) ──
        javax.swing.JPanel sidebar = new javax.swing.JPanel();
        sidebar.setBackground(COLOR_PRIMARIO);
        sidebar.setPreferredSize(new java.awt.Dimension(220, 0));
        sidebar.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbcSide = new java.awt.GridBagConstraints();
        gbcSide.gridx = 0;
        gbcSide.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbcSide.insets = new java.awt.Insets(6, 12, 6, 12);
        gbcSide.weightx = 1.0;

        // Encabezado del Sidebar
        gbcSide.gridy = 0;
        javax.swing.JLabel lblMenu = new javax.swing.JLabel("MENÚ PRINCIPAL");
        lblMenu.setFont(new Font("Arial", Font.BOLD, 14));
        lblMenu.setForeground(new Color(255, 200, 220));
        lblMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 0, 15, 0));
        sidebar.add(lblMenu, gbcSide);

        // Botón Administrador Lateral
        gbcSide.gridy = 1;
        btnAdminLateral = crearBtnLateral("»  Administrador");
        sidebar.add(btnAdminLateral, gbcSide);
        
        // Menú Desplegable emergente para Administrador
        javax.swing.JPopupMenu popupAdmin = new javax.swing.JPopupMenu();
        popupAdmin.add(jEmpleados);
        popupAdmin.add(jBahias);
        popupAdmin.add(jServicios);
        popupAdmin.add(new javax.swing.JSeparator());
        popupAdmin.add(jReporteIngresos);
        popupAdmin.add(jReporteBahias);
        btnAdminLateral.addActionListener(e -> popupAdmin.show(btnAdminLateral, 0, btnAdminLateral.getHeight()));

        // Botón Asesor Lateral
        gbcSide.gridy = 2;
        btnAsesorLateral = crearBtnLateral("»  Asesor");
        sidebar.add(btnAsesorLateral, gbcSide);
        
        // Menú Desplegable emergente para Asesor
        javax.swing.JPopupMenu popupAsesor = new javax.swing.JPopupMenu();
        popupAsesor.add(jClientes);
        popupAsesor.add(jVehiculos);
        popupAsesor.add(new javax.swing.JSeparator());
        popupAsesor.add(jCitas);
        popupAsesor.add(jRecepcion);
        popupAsesor.add(jEntrega);
        btnAsesorLateral.addActionListener(e -> popupAsesor.show(btnAsesorLateral, 0, btnAsesorLateral.getHeight()));

        // Botón Mecánico Lateral
        gbcSide.gridy = 3;
        btnMecanicoLateral = crearBtnLateral("»  Mecanico");
        sidebar.add(btnMecanicoLateral, gbcSide);
        
        // Menú Desplegable emergente para Mecánico
        javax.swing.JPopupMenu popupMecanico = new javax.swing.JPopupMenu();
        popupMecanico.add(jAtencion);
        btnMecanicoLateral.addActionListener(e -> popupMecanico.show(btnMecanicoLateral, 0, btnMecanicoLateral.getHeight()));

        // Espacio expandible empujador hacia abajo
        gbcSide.gridy = 4;
        gbcSide.weighty = 1.0;
        sidebar.add(new javax.swing.JLabel(""), gbcSide);

        // Botón Cerrar Sesión Lateral
        gbcSide.gridy = 5;
        gbcSide.weighty = 0.0;
        gbcSide.insets = new java.awt.Insets(6, 12, 20, 12);
        btnSalirLateral = crearBtnLateral("x  Cerrar Sesion");
        btnSalirLateral.setBackground(COLOR_SECUNDARIO);
        btnSalirLateral.addActionListener(e -> {
            int conf = javax.swing.JOptionPane.showConfirmDialog(
                null, "Desea cerrar sesion?",
                "Cerrar Sesion",
                javax.swing.JOptionPane.YES_NO_OPTION);
            if (conf == javax.swing.JOptionPane.YES_OPTION) {
                new JFrameLogin().setVisible(true);
                dispose();
            }
        });
        sidebar.add(btnSalirLateral, gbcSide);

        // Aplicar restricciones de Rol en los botones del Sidebar
        switch (rolActual) {
            case "Asesor":
                btnAdminLateral.setVisible(false);
                break;
            case "Mecanico":
                btnAdminLateral.setVisible(false);
                btnAsesorLateral.setVisible(false);
                break;
        }

        getContentPane().add(sidebar, java.awt.BorderLayout.WEST);


        // ── 2. PANEL CENTRAL (CONTENIDO DE BIENVENIDA) ──
        javax.swing.JPanel centro = new javax.swing.JPanel();
        centro.setLayout(new java.awt.GridBagLayout());
        centro.setBackground(COLOR_FONDO);
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);

        // Icono
        gbc.gridy = 0;
        javax.swing.JLabel icono = new javax.swing.JLabel("🔧");
        icono.setFont(new Font("Dialog", Font.PLAIN, 52));
        icono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        centro.add(icono, gbc);

        // Título
        gbc.gridy = 1;
        javax.swing.JLabel titulo = new javax.swing.JLabel("Taller Mecanico Automotriz");
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setForeground(COLOR_PRIMARIO);
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        centro.add(titulo, gbc);

        // Separador
        gbc.gridy = 2;
        javax.swing.JSeparator sep = new javax.swing.JSeparator();
        sep.setForeground(COLOR_SECUNDARIO);
        sep.setPreferredSize(new java.awt.Dimension(400, 2));
        centro.add(sep, gbc);

        // Subtítulo
        gbc.gridy = 3;
        javax.swing.JLabel sub = new javax.swing.JLabel("Sistema de Gestion de Ordenes de Trabajo");
        sub.setFont(new Font("Arial", Font.ITALIC, 14));
        sub.setForeground(new Color(180, 80, 120));
        centro.add(sub, gbc);

        // Info sesión
        gbc.gridy = 5;
        gbc.insets = new java.awt.Insets(20, 10, 0, 10);
        javax.swing.JLabel infoUser = new javax.swing.JLabel("Sesion iniciada como: " + rolActual);
        infoUser.setFont(new Font("Arial", Font.BOLD, 12));
        infoUser.setForeground(COLOR_PRIMARIO);
        centro.add(infoUser, gbc);

        getContentPane().add(centro, java.awt.BorderLayout.CENTER);


        // ── 3. PANEL INFERIOR (FOOTER) ──
        javax.swing.JPanel footer = new javax.swing.JPanel();
        footer.setBackground(COLOR_PRIMARIO);
        footer.setPreferredSize(new java.awt.Dimension(0, 32));
        javax.swing.JLabel footerLbl = new javax.swing.JLabel("Taller Mecanico Automotriz  |  Sistema de Gestion  |  2026");
        footerLbl.setFont(new Font("Arial", Font.PLAIN, 11));
        footerLbl.setForeground(new Color(255, 200, 220));
        footer.add(footerLbl);
        getContentPane().add(footer, java.awt.BorderLayout.SOUTH);

        // Forzar empaquetado dinámico y maximizado
        this.pack();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.revalidate();
        this.repaint();
    }

    private javax.swing.JButton crearBtnLateral(String texto) {
        javax.swing.JButton btn = new javax.swing.JButton(texto);
        btn.setBackground(COLOR_PRIMARIO);
        btn.setForeground(BLANCO);
        btn.setFont(new Font("Arial", Font.BOLD, 13));
        btn.setFocusPainted(false);
        
btn.setBorder(javax.swing.BorderFactory.createCompoundBorder(
    javax.swing.BorderFactory.createLineBorder(COLOR_SECUNDARIO, 1),
    javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 0)
));


        btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn.setPreferredSize(new java.awt.Dimension(0, 42));
        btn.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(COLOR_SECUNDARIO);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                if(btn == btnSalirLateral) {
                    btn.setBackground(COLOR_SECUNDARIO);
                } else {
                    btn.setBackground(COLOR_PRIMARIO);
                }
            }
        });
        return btn;
    }

    private javax.swing.JButton crearBtn(String texto, java.awt.event.ActionListener accion) {
        javax.swing.JButton btn = new javax.swing.JButton(texto);
        btn.setBackground(COLOR_PRIMARIO);
        btn.setForeground(BLANCO);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setPreferredSize(new java.awt.Dimension(120, 36));

        btn.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        btn.addActionListener(accion);
        return btn;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jEmpleados = new javax.swing.JMenuItem();
        jBahias = new javax.swing.JMenuItem();
        jServicios = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jReporteIngresos = new javax.swing.JMenuItem();
        jReporteBahias = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jClientes = new javax.swing.JMenuItem();
        jVehiculos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jCitas = new javax.swing.JMenuItem();
        jRecepcion = new javax.swing.JMenuItem();
        jEntrega = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jAtencion = new javax.swing.JMenuItem();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("    ");

        jMenu3.setText("Administrador");

        jEmpleados.setText("Personal del Taller");
        jEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmpleadosActionPerformed(evt);
            }
        });
        jMenu3.add(jEmpleados);

        jBahias.setText("Bahias de Trabajo");
        jBahias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBahiasActionPerformed(evt);
            }
        });
        jMenu3.add(jBahias);

        jServicios.setText("Catalogo de Servicios");
        jServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jServiciosActionPerformed(evt);
            }
        });
        jMenu3.add(jServicios);
        jMenu3.add(jSeparator1);

        jReporteIngresos.setText("Reporte de Ingresos");
        jReporteIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jReporteIngresosActionPerformed(evt);
            }
        });
        jMenu3.add(jReporteIngresos);

        jReporteBahias.setText("Reporte de Bahias");
        jReporteBahias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jReporteBahiasActionPerformed(evt);
            }
        });
        jMenu3.add(jReporteBahias);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Asesor");

        jClientes.setText("Registro de Clientes");
        jClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClientesActionPerformed(evt);
            }
        });
        jMenu4.add(jClientes);

        jVehiculos.setText("Registro de Vehiculos");
        jVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVehiculosActionPerformed(evt);
            }
        });
        jMenu4.add(jVehiculos);
        jMenu4.add(jSeparator2);

        jCitas.setText("Programar Cita");
        jCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCitasActionPerformed(evt);
            }
        });
        jMenu4.add(jCitas);

        jRecepcion.setText("Recepcion de Vehiculo");
        jRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRecepcionActionPerformed(evt);
            }
        });
        jMenu4.add(jRecepcion);

        jEntrega.setText("Entrega de Vehiculo");
        jEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEntregaActionPerformed(evt);
            }
        });
        jMenu4.add(jEntrega);

        jMenuBar2.add(jMenu4);

        jMenu1.setText("Mecanico");

        jAtencion.setText("Atencion del Vehiculo");
        jAtencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAtencionActionPerformed(evt);
            }
        });
        jMenu1.add(jAtencion);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmpleadosActionPerformed
        abrirVentana(new JFrameEmpleados());
    }//GEN-LAST:event_jEmpleadosActionPerformed

    private void jBahiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBahiasActionPerformed
        abrirVentana(new JFrameBahias());
    }//GEN-LAST:event_jBahiasActionPerformed

    private void jServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jServiciosActionPerformed
        abrirVentana(new JFrameServicios());
    }//GEN-LAST:event_jServiciosActionPerformed

    private void jVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVehiculosActionPerformed
        abrirVentana(new JFrameVehiculos());
    }//GEN-LAST:event_jVehiculosActionPerformed

    private void jClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClientesActionPerformed
        abrirVentana(new JFrameClientes());
    }//GEN-LAST:event_jClientesActionPerformed

    private void jCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCitasActionPerformed
        abrirVentana(new JFrameCitas());
    }//GEN-LAST:event_jCitasActionPerformed

    private void jRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRecepcionActionPerformed
        abrirVentana(new JFrameRecepcion());
    }//GEN-LAST:event_jRecepcionActionPerformed

    private void jEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEntregaActionPerformed
        abrirVentana(new JFrameEntrega());
    }//GEN-LAST:event_jEntregaActionPerformed

    private void jAtencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAtencionActionPerformed
        abrirVentana(new JFrameAtencion());
    }//GEN-LAST:event_jAtencionActionPerformed

    private void jReporteIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jReporteIngresosActionPerformed
        abrirVentana(new JFrameReporteIngresos());
    }//GEN-LAST:event_jReporteIngresosActionPerformed

    private void jReporteBahiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jReporteBahiasActionPerformed
        abrirVentana(new JFrameReporteBahias());
    }//GEN-LAST:event_jReporteBahiasActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Principal("Administrador").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jAtencion;
    private javax.swing.JMenuItem jBahias;
    private javax.swing.JMenuItem jCitas;
    private javax.swing.JMenuItem jClientes;
    private javax.swing.JMenuItem jEmpleados;
    private javax.swing.JMenuItem jEntrega;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jRecepcion;
    private javax.swing.JMenuItem jReporteBahias;
    private javax.swing.JMenuItem jReporteIngresos;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuItem jServicios;
    private javax.swing.JMenuItem jVehiculos;
    // End of variables declaration//GEN-END:variables
}
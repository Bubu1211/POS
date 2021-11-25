package vista.paneles;

import javax.swing.JOptionPane;
import vista.formularios.VisualizadorReportes;

public class PanelReportes extends javax.swing.JPanel {

    public PanelReportes() {
        initComponents();
        this.colorFondoNaranja = new java.awt.Color(255, 153, 51);
        this.colorAzul = new java.awt.Color(0,204,255);
        this.colorVerde = new java.awt.Color(53,222,138);
        this.colorMorado = new java.awt.Color(149,37,255);
        this.colorTurquesa = new java.awt.Color(0,255,204);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoTiempo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        botonResumenVentas = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        botonResumenCompras = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        botonComprasVentas = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        botonNegativas = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        botonAgotados = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        botonSinMovimiento = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnImprimirVentas = new javax.swing.JButton();
        btnImprimirArticulos = new javax.swing.JButton();
        botonPromociones = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(750, 445));
        setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Ventas");

        grupoTiempo.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jRadioButton1.setText("Diario");

        grupoTiempo.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jRadioButton2.setText("Semanal");

        grupoTiempo.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jRadioButton3.setText("Mensual");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel2.setText("De:");

        jDateChooser1.setDateFormatString("dd, MM, yyyy");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel3.setText("a:");

        jDateChooser2.setDateFormatString("dd, MM, yyyy");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Crear Reporte de Ventas");

        botonResumenVentas.setBackground(new java.awt.Color(255, 153, 51));
        botonResumenVentas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonResumenVentas.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        botonResumenVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonResumenVentasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonResumenVentasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonResumenVentasMouseReleased(evt);
            }
        });

        jPanel4.setPreferredSize(new java.awt.Dimension(145, 28));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel5.setText("Resumen Ventas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        javax.swing.GroupLayout botonResumenVentasLayout = new javax.swing.GroupLayout(botonResumenVentas);
        botonResumenVentas.setLayout(botonResumenVentasLayout);
        botonResumenVentasLayout.setHorizontalGroup(
            botonResumenVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonResumenVentasLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        botonResumenVentasLayout.setVerticalGroup(
            botonResumenVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonResumenVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        botonResumenCompras.setBackground(new java.awt.Color(255, 153, 51));
        botonResumenCompras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonResumenCompras.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        botonResumenCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonResumenComprasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonResumenComprasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonResumenComprasMouseReleased(evt);
            }
        });

        jPanel5.setPreferredSize(new java.awt.Dimension(145, 28));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel6.setText("Resumen Compras");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(16, 16, 16))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout botonResumenComprasLayout = new javax.swing.GroupLayout(botonResumenCompras);
        botonResumenCompras.setLayout(botonResumenComprasLayout);
        botonResumenComprasLayout.setHorizontalGroup(
            botonResumenComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonResumenComprasLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        botonResumenComprasLayout.setVerticalGroup(
            botonResumenComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonResumenComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        botonComprasVentas.setBackground(new java.awt.Color(255, 153, 51));
        botonComprasVentas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonComprasVentas.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        botonComprasVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonComprasVentasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonComprasVentasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonComprasVentasMouseReleased(evt);
            }
        });

        jPanel6.setPreferredSize(new java.awt.Dimension(145, 28));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel7.setText("Compras - Ventas");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(16, 16, 16))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout botonComprasVentasLayout = new javax.swing.GroupLayout(botonComprasVentas);
        botonComprasVentas.setLayout(botonComprasVentasLayout);
        botonComprasVentasLayout.setHorizontalGroup(
            botonComprasVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonComprasVentasLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        botonComprasVentasLayout.setVerticalGroup(
            botonComprasVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonComprasVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jCheckBox1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jCheckBox1.setText("Arts más vendidos");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel8.setText("No. Items:");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jCheckBox2.setText("Arts menos vendidos");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel9.setText("No. Items:");

        jTextField2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jCheckBox3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jCheckBox3.setText("Escala de proveedores");

        jCheckBox4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jCheckBox4.setText("Escala de categorías");

        jCheckBox5.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jCheckBox5.setText("Relación de días");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel10.setText("Artículos");

        botonNegativas.setBackground(new java.awt.Color(0, 204, 255));
        botonNegativas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonNegativas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonNegativasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonNegativasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonNegativasMouseReleased(evt);
            }
        });

        jPanel7.setPreferredSize(new java.awt.Dimension(145, 28));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel11.setText("Negativas");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        javax.swing.GroupLayout botonNegativasLayout = new javax.swing.GroupLayout(botonNegativas);
        botonNegativas.setLayout(botonNegativasLayout);
        botonNegativasLayout.setHorizontalGroup(
            botonNegativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonNegativasLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        botonNegativasLayout.setVerticalGroup(
            botonNegativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonNegativasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        botonAgotados.setBackground(new java.awt.Color(53, 222, 138));
        botonAgotados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAgotados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAgotadosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonAgotadosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonAgotadosMouseReleased(evt);
            }
        });

        jPanel8.setPreferredSize(new java.awt.Dimension(145, 28));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel12.setText("Agotados");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel12)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        javax.swing.GroupLayout botonAgotadosLayout = new javax.swing.GroupLayout(botonAgotados);
        botonAgotados.setLayout(botonAgotadosLayout);
        botonAgotadosLayout.setHorizontalGroup(
            botonAgotadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonAgotadosLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        botonAgotadosLayout.setVerticalGroup(
            botonAgotadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonAgotadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        botonSinMovimiento.setBackground(new java.awt.Color(149, 37, 255));
        botonSinMovimiento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonSinMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSinMovimientoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonSinMovimientoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonSinMovimientoMouseReleased(evt);
            }
        });

        jPanel9.setPreferredSize(new java.awt.Dimension(145, 28));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel13.setText("Sin movimiento");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        javax.swing.GroupLayout botonSinMovimientoLayout = new javax.swing.GroupLayout(botonSinMovimiento);
        botonSinMovimiento.setLayout(botonSinMovimientoLayout);
        botonSinMovimientoLayout.setHorizontalGroup(
            botonSinMovimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonSinMovimientoLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        botonSinMovimientoLayout.setVerticalGroup(
            botonSinMovimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonSinMovimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "UPC", "Descripción", "Categoría", "Proveedor", "Precio compra", "Precio venta", "Existencia"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnImprimirVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/iconos/imprimir.png"))); // NOI18N
        btnImprimirVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirVentasActionPerformed(evt);
            }
        });

        btnImprimirArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/iconos/imprimir.png"))); // NOI18N
        btnImprimirArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirArticulosActionPerformed(evt);
            }
        });

        botonPromociones.setBackground(new java.awt.Color(0, 255, 204));
        botonPromociones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonPromociones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonPromocionesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonPromocionesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonPromocionesMouseReleased(evt);
            }
        });

        jPanel10.setPreferredSize(new java.awt.Dimension(145, 28));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel14.setText("Promociones");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel14)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );

        javax.swing.GroupLayout botonPromocionesLayout = new javax.swing.GroupLayout(botonPromociones);
        botonPromociones.setLayout(botonPromocionesLayout);
        botonPromocionesLayout.setHorizontalGroup(
            botonPromocionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonPromocionesLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        botonPromocionesLayout.setVerticalGroup(
            botonPromocionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonPromocionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton3)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonResumenVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonResumenCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonComprasVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnImprimirArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jCheckBox1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(34, 34, 34))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(botonNegativas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jCheckBox2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField2)))
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox4)
                                            .addComponent(jCheckBox3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox5)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnImprimirVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botonAgotados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonSinMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonPromociones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton3)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonResumenCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonResumenVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonComprasVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimirVentas)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox4))))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonNegativas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgotados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSinMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPromociones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimirArticulos))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void botonResumenVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonResumenVentasMouseClicked
        // Boton que genera un resumen de ventas con las fechas especificadas
        //Se obtiene el rango de fechas y se pasa al controlador, se regresa un arrayList de vtipo Ventas
        //y se crea un DTM en el controlador, este evento pasa ese DTM al VisualizadorReportes
        ///Los botones cambian el Borde para crear Un efecto de presión
        VisualizadorReportes vr = new VisualizadorReportes();
        vr.setVisible(true);
    }//GEN-LAST:event_botonResumenVentasMouseClicked

    private void botonResumenVentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonResumenVentasMousePressed
        ///Evento para dar efecto de presiónado (Se presiona)
        this.botonResumenVentas.setBackground(java.awt.Color.GRAY);
    }//GEN-LAST:event_botonResumenVentasMousePressed

    private void botonResumenVentasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonResumenVentasMouseReleased
        // Evento para dar efecto de presiondado (Se suelta)
        this.botonResumenVentas.setBackground(this.colorFondoNaranja);
    }//GEN-LAST:event_botonResumenVentasMouseReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void botonNegativasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNegativasMouseClicked
        //Llena la tabla con los datos de artpículos cuta existencia sea menor a 0 
        JOptionPane.showMessageDialog(this, "Obteniendo Datos de negativas", "Datos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonNegativasMouseClicked

    private void botonNegativasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNegativasMousePressed
        // TODO add your handling code here:
        this.botonNegativas.setBackground(java.awt.Color.GRAY);
    }//GEN-LAST:event_botonNegativasMousePressed

    private void botonNegativasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNegativasMouseReleased
        // TODO add your handling code here:
        this.botonNegativas.setBackground(this.colorAzul);
    }//GEN-LAST:event_botonNegativasMouseReleased

    private void botonAgotadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgotadosMouseClicked
        ///lLENA LA TABLA CON LOS DATOS DE ARTÍCULOS CUYA EXISTENCIA = 0
        
        JOptionPane.showMessageDialog(this, "Obteniendo Datos de agotados", "Datos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonAgotadosMouseClicked

    private void botonAgotadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgotadosMousePressed
        // TODO add your handling code here:
        this.botonAgotados.setBackground(java.awt.Color.GRAY);
    }//GEN-LAST:event_botonAgotadosMousePressed

    private void botonAgotadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgotadosMouseReleased
        // TODO add your handling code here:
        this.botonAgotados.setBackground(this.colorVerde);
    }//GEN-LAST:event_botonAgotadosMouseReleased

    private void botonSinMovimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSinMovimientoMouseClicked
        ///Obtiene los datos de aquellos artículos que no ha tenido venta en un mes 
        JOptionPane.showMessageDialog(this, "Obteniendo Datos de sin movimiento", "Datos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonSinMovimientoMouseClicked

    private void botonSinMovimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSinMovimientoMousePressed
        // TODO add your handling code here:
        this.botonSinMovimiento.setBackground(java.awt.Color.GRAY);
    }//GEN-LAST:event_botonSinMovimientoMousePressed

    private void botonSinMovimientoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSinMovimientoMouseReleased
        // TODO add your handling code here:
        this.botonSinMovimiento.setBackground(this.colorMorado);
    }//GEN-LAST:event_botonSinMovimientoMouseReleased

    private void botonPromocionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPromocionesMouseClicked
        ///Datos de resumen de promociones
        JOptionPane.showMessageDialog(this, "Obteniendo resumen de promociones", "Datos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonPromocionesMouseClicked

    private void botonPromocionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPromocionesMousePressed
        // TODO add your handling code here:
        this.botonPromociones.setBackground(java.awt.Color.GRAY);
    }//GEN-LAST:event_botonPromocionesMousePressed

    private void botonPromocionesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPromocionesMouseReleased
        // TODO add your handling code here:
        this.botonPromociones.setBackground(this.colorTurquesa);
    }//GEN-LAST:event_botonPromocionesMouseReleased

    private void botonResumenComprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonResumenComprasMousePressed
        // TODO add your handling code here:
        this.botonResumenCompras.setBackground(java.awt.Color.GRAY);
    }//GEN-LAST:event_botonResumenComprasMousePressed

    private void botonResumenComprasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonResumenComprasMouseReleased
        // TODO add your handling code here:
        this.botonResumenCompras.setBackground(this.colorFondoNaranja);
    }//GEN-LAST:event_botonResumenComprasMouseReleased

    private void botonResumenComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonResumenComprasMouseClicked
        // TODO add your handling code here:
        VisualizadorReportes vr = new VisualizadorReportes();
        vr.setVisible(true);
    }//GEN-LAST:event_botonResumenComprasMouseClicked

    private void botonComprasVentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonComprasVentasMousePressed
        // TODO add your handling code here:
        this.botonComprasVentas.setBackground(java.awt.Color.GRAY);
    }//GEN-LAST:event_botonComprasVentasMousePressed

    private void botonComprasVentasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonComprasVentasMouseReleased
        // TODO add your handling code here:
        this.botonComprasVentas.setBackground(this.colorFondoNaranja);
    }//GEN-LAST:event_botonComprasVentasMouseReleased

    private void botonComprasVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonComprasVentasMouseClicked
        // TODO add your handling code here:}
        VisualizadorReportes vr = new VisualizadorReportes();
        vr.setVisible(true);
    }//GEN-LAST:event_botonComprasVentasMouseClicked

    private void btnImprimirVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirVentasActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Generando Reporte de ventas solicitado", "Reporte", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnImprimirVentasActionPerformed

    private void btnImprimirArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirArticulosActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Generando Reporte de artículos solicitado", "Reporte", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnImprimirArticulosActionPerformed

    private java.awt.Color colorFondoNaranja;
    private java.awt.Color colorAzul;
    private java.awt.Color colorVerde;
    private java.awt.Color colorMorado ;
    private java.awt.Color colorTurquesa ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botonAgotados;
    private javax.swing.JPanel botonComprasVentas;
    private javax.swing.JPanel botonNegativas;
    private javax.swing.JPanel botonPromociones;
    private javax.swing.JPanel botonResumenCompras;
    private javax.swing.JPanel botonResumenVentas;
    private javax.swing.JPanel botonSinMovimiento;
    private javax.swing.JButton btnImprimirArticulos;
    private javax.swing.JButton btnImprimirVentas;
    private javax.swing.ButtonGroup grupoTiempo;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

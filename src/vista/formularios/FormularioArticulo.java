package vista.formularios;

import control.ControlArticulos;
import datos.entidades.Articulo;
import datos.entidades.Categoria;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilidades.excepciones.ControlException;

public class FormularioArticulo extends javax.swing.JFrame {

    private ControlArticulos control;
    private Articulo articulo;
    private boolean modificar;

    public FormularioArticulo(Articulo articulo) {
        this();
        modificar = true;
        ///Pone los atributos en los campos de texto
        ctUpc.setText(String.valueOf(articulo.getId()));
        ctDescripcion.setText(articulo.getDescripcion());
        cmbCategoria.setSelectedIndex(articulo.getIdCategoria());
        cmbProveedores.setSelectedIndex(articulo.getIdProveedor());
        ctPrecioVenta.setText(null);
        ctPrecioCompra.setText(null);
        ///dESACTIVA el campo de texto de UPC ya que ya contiejne uno
        ctUpc.setEditable(false);
    }

    public FormularioArticulo() {
        initComponents();
        colorAzul = new java.awt.Color(0, 183, 222);
        colorRojo = new java.awt.Color(255, 0, 51);
        colorVerde = new java.awt.Color(0, 204, 51);

        this.setLocationRelativeTo(null);

        control = new ControlArticulos();
        modificar = false;
        this.setModeloCategoriasProveedores();
    }

    private void setModeloCategoriasProveedores() {
        try {
            ///Llena el modelo del comboList
            control.listarProveedoresCategorias();
            var categorias = control.getCategorias();
            var proveedores = control.getProveedores();

            String[] modeloCategorias = new String[categorias.size()];
            String[] modeloProveedores = new String[proveedores.size()];

            for (int i = 0; i < modeloCategorias.length; i++) {
                modeloCategorias[i] = categorias.get(i);
            }

            for (int i = 0; i < modeloProveedores.length; i++) {
                modeloProveedores[i] = proveedores.get(i);
            }

            this.cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(modeloCategorias));
            this.cmbProveedores.setModel(new javax.swing.DefaultComboBoxModel<>(modeloProveedores));

        } catch (ControlException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage() + "\n\n En: \n" + ex.getOrigen(), "Lo sentimos ocurrio un error ", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void limpiar() {
        ctUpc.setText(null);
        ctDescripcion.setText(null);
        ctPrecioVenta.setText(null);
        ctPrecioCompra.setText(null);
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Categoría"}));
        cmbProveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Proveedor"}));
    }

    private void cajaTextoError(javax.swing.JTextField ct) {
        ct.requestFocus();
        ct.setForeground(java.awt.Color.RED);
    }

    private void cajaTextoNormal(javax.swing.JTextField ct) {
        ct.setForeground(java.awt.Color.BLACK);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ctDescripcion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbProveedores = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        ctPrecioCompra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ctPrecioVenta = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        botonNuevaCategoria = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ctUpc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 183, 225));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Artículos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
        );

        jLabel2.setText("UPC");

        jLabel3.setText("Descripción");

        jLabel4.setText("Categoría");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoría", "Categoría" }));

        jLabel5.setText("Proveedor");

        cmbProveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proveedor", "Proveedor", "Proveedor" }));

        jLabel6.setText("Precio compra");

        jLabel7.setText("Precio venta");

        botonGuardar.setBackground(new java.awt.Color(0, 183, 222));
        botonGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonGuardarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonGuardarMouseReleased(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel10.setText("Guardar");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(23, 23, 23))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout botonGuardarLayout = new javax.swing.GroupLayout(botonGuardar);
        botonGuardar.setLayout(botonGuardarLayout);
        botonGuardarLayout.setHorizontalGroup(
            botonGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonGuardarLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botonGuardarLayout.setVerticalGroup(
            botonGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        botonCancelar.setBackground(new java.awt.Color(255, 0, 51));
        botonCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCancelarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonCancelarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonCancelarMouseReleased(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel13.setText("Cancelar");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel13)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout botonCancelarLayout = new javax.swing.GroupLayout(botonCancelar);
        botonCancelar.setLayout(botonCancelarLayout);
        botonCancelarLayout.setHorizontalGroup(
            botonCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonCancelarLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        botonCancelarLayout.setVerticalGroup(
            botonCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        botonNuevaCategoria.setBackground(new java.awt.Color(0, 204, 51));
        botonNuevaCategoria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonNuevaCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonNuevaCategoriaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonNuevaCategoriaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonNuevaCategoriaMouseReleased(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel14.setText("Nuevo");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel15.setText("Nueva Categoría");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(29, 29, 29))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14))
        );

        javax.swing.GroupLayout botonNuevaCategoriaLayout = new javax.swing.GroupLayout(botonNuevaCategoria);
        botonNuevaCategoria.setLayout(botonNuevaCategoriaLayout);
        botonNuevaCategoriaLayout.setHorizontalGroup(
            botonNuevaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonNuevaCategoriaLayout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        botonNuevaCategoriaLayout.setVerticalGroup(
            botonNuevaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(botonNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(ctPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(ctPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ctUpc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbProveedores, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ctDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctUpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ctPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ctPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMousePressed
        //Animacion boton
        this.botonGuardar.setBackground(java.awt.Color.GRAY);
    }//GEN-LAST:event_botonGuardarMousePressed

    private void botonGuardarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseReleased
        //Animacion boton
        this.botonGuardar.setBackground(this.colorAzul);
    }//GEN-LAST:event_botonGuardarMouseReleased

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked

        articulo = new Articulo();
        cajaTextoNormal(ctUpc);
        cajaTextoNormal(ctDescripcion);
        cajaTextoNormal(ctPrecioVenta);
        cajaTextoNormal(ctPrecioCompra);

        ///Recupera los datos de los campos de texto 
        String upcString = ctUpc.getText();
        String descripcionString = ctDescripcion.getText();
        String precioVentaString = ctPrecioVenta.getText();
        String precioCompraString = ctPrecioCompra.getText();

        if (!upcString.isEmpty()) {
            if (!descripcionString.isEmpty()) {
                if (!precioVentaString.isEmpty()) {
                    if (!precioCompraString.isEmpty()) {

                        try {
                            articulo.setId(Integer.parseInt(upcString));
                            articulo.setPrecioCompra(Float.parseFloat(precioCompraString));
                            articulo.setPrecioVenta(Float.parseFloat(precioVentaString));

                            try {
                                articulo.setDescripcion(descripcionString);
                                String itemProveedor = cmbProveedores.getItemAt(cmbProveedores.getSelectedIndex());
                                String itemCategoria = cmbCategoria.getItemAt(cmbCategoria.getSelectedIndex());
                                control.buscarProveedorCategoria(itemProveedor, itemCategoria);
                                
                                //EVENTO DEL BOTON GUARDAR
                                if (modificar) {
                                    this.control.modificarArticulo(articulo);
                                    JOptionPane.showMessageDialog(this, "El artículo se ha guardado", "Guardado", JOptionPane.INFORMATION_MESSAGE);

                                } else {
                                    this.control.insertarArticulo(articulo);
                                    JOptionPane.showMessageDialog(this, "El artículo se ha modificado", "Guardado", JOptionPane.INFORMATION_MESSAGE);

                                }

                            } catch (ControlException ex) {
                                JOptionPane.showMessageDialog(this, ex.getMessage() + "\n\n En: \n" + ex.getOrigen(),
                                        "Lo sentimos ocurrio un error ", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this, "Error al obtener valores numéricos", "Por favor verifique las entradas", JOptionPane.ERROR_MESSAGE);
                            cajaTextoError(ctUpc);
                            cajaTextoError(ctPrecioCompra);
                            cajaTextoError(ctPrecioVenta);
                        }
                    } else {
                        cajaTextoError(ctPrecioCompra);
                        JOptionPane.showMessageDialog(this, "Error en entrada", "Por favor ingrese un precio de compra", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    cajaTextoError(ctPrecioVenta);
                    JOptionPane.showMessageDialog(this, "Error en entrada", "Por favor ingrese un precio de venta", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                cajaTextoError(ctDescripcion);
                JOptionPane.showMessageDialog(this, "Error en entrada", "Por favor ingrese una descripcion", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            cajaTextoError(ctUpc);
            JOptionPane.showMessageDialog(this, "Error en entrada", "Por favor ingrese un UPC", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_botonGuardarMouseClicked

    private void botonCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMousePressed
        //Animacion boton
        this.botonCancelar.setBackground(java.awt.Color.GRAY);
    }//GEN-LAST:event_botonCancelarMousePressed

    private void botonCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseReleased
        //Animacion boton
        this.botonCancelar.setBackground(this.colorRojo);
    }//GEN-LAST:event_botonCancelarMouseReleased

    private void botonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseClicked
        //Evento boton cancelar
        //Para mantene la consistencia de la interfaz primero se advierte al usuario sobre la acción
        if (JOptionPane.showConfirmDialog(this, "Seguro que desea cancelar?", "Cancelar",
                JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            this.limpiar();
        }
    }//GEN-LAST:event_botonCancelarMouseClicked

    private void botonNuevaCategoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNuevaCategoriaMousePressed
        //Animacion boton
        this.botonNuevaCategoria.setBackground(java.awt.Color.GRAY);
    }//GEN-LAST:event_botonNuevaCategoriaMousePressed

    private void botonNuevaCategoriaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNuevaCategoriaMouseReleased
        //Animacion boton
        this.botonNuevaCategoria.setBackground(this.colorVerde);
    }//GEN-LAST:event_botonNuevaCategoriaMouseReleased

    private void botonNuevaCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNuevaCategoriaMouseClicked
        //Código para crear una nueva categoría
        //Se pide la nueva descripción
        String categoria = JOptionPane.showInputDialog(this, "Ingrese la nueva categoría", "Nueva Categoría", JOptionPane.PLAIN_MESSAGE);
        try {
            //Se realiza la inserción en la BD
            control.insertarCategoria(new Categoria(categoria));
            ///Se actualiza el comboBox
            this.setModeloCategoriasProveedores();
        } catch (ControlException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage() + "\n\n En: \n" + ex.getOrigen(), "Lo sentimos ocurrio un error ", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_botonNuevaCategoriaMouseClicked

    private java.awt.Color colorAzul;
    private java.awt.Color colorRojo;
    private java.awt.Color colorVerde;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botonCancelar;
    private javax.swing.JPanel botonGuardar;
    private javax.swing.JPanel botonNuevaCategoria;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbProveedores;
    private javax.swing.JTextField ctDescripcion;
    private javax.swing.JTextField ctPrecioCompra;
    private javax.swing.JTextField ctPrecioVenta;
    private javax.swing.JTextField ctUpc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}

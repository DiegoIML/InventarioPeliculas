package vista;
import controlador.BotonActualizar;
import controlador.BotonBuscar;
import controlador.BotonAgregar;
import controlador.BotonConectar;
import controlador.BotonDescargar;
import controlador.BotonEliminar;
import controlador.BotonIngresar;
import controlador.ObtenerDatosInventario;
import javax.swing.JFrame;
import modelo.Conexion;


public class VistaMenu extends javax.swing.JFrame {
    private Conexion conexionBD;
    
    public Conexion getConexion() {
       return conexionBD;
    }
    
    public VistaMenu() {    
        conexionBD = new Conexion(); 
        setTitle("Inventario Peliculas");
        initComponents();
        setVisible(true);
        setResizable(false);
        tablaInventario.setVisible(false);
        botonBuscar.addActionListener(new BotonBuscar(conexionBD , tablaInventario));
        botonAgregar.addActionListener(new BotonAgregar(conexionBD , tablaInventario));
        botonEliminar.addActionListener(new BotonEliminar(conexionBD , tablaInventario));
        botonActualizar.addActionListener(new BotonActualizar(conexionBD ,tablaInventario , cuadroIdInventario , cuadroIdPelicula , cuadroIdTienda));
        tablaInventario.addMouseListener(new ObtenerDatosInventario(tablaInventario , cuadroIdInventario , cuadroIdPelicula , cuadroIdTienda));
        botonDescargar.addActionListener(new BotonDescargar(tablaInventario));
        botonIngresar.addActionListener(new BotonIngresar(tablaInventario));
        botonConectar.addActionListener(new BotonConectar( this , conexionBD));
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("holo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();
        botonBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cuadroIdInventario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cuadroIdPelicula = new javax.swing.JTextField();
        cuadroIdTienda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        botonAgregar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        botonConectar = new javax.swing.JButton();
        botonDescargar = new javax.swing.JButton();
        botonIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 204));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));
        jPanel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaInventario.setBackground(new java.awt.Color(204, 204, 255));
        tablaInventario.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaInventario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaInventario.setGridColor(new java.awt.Color(0, 0, 0));
        tablaInventario.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tablaInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaInventarioKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaInventario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 530, 400));

        botonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_buscar.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.setToolTipText("Botón para poder buscar en la Base de datos de BlockBuster todas las peliculas que estan en el inventario disponibles para la renta.");
        botonBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 100, -1));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setText("ID_INVENTARIO");

        cuadroIdInventario.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        cuadroIdInventario.setToolTipText("completa el campo de texto con un id_inventario válido");
        cuadroIdInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadroIdInventarioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText("ID_PELICULA");

        cuadroIdPelicula.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        cuadroIdPelicula.setToolTipText("completa el campo de texto con un id_pelicula válido.");
        cuadroIdPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadroIdPeliculaActionPerformed(evt);
            }
        });

        cuadroIdTienda.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        cuadroIdTienda.setToolTipText("completa el cuadro de texto con un id_tienda válido");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("ID_TIENDA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cuadroIdTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cuadroIdPelicula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cuadroIdInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cuadroIdInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cuadroIdPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cuadroIdTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 270, 550));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        botonAgregar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_agregar.png"))); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.setToolTipText("botón para agregar una celda seleccionada del inventario a la Base de datos.");
        botonAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonEliminar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_eliminar.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setToolTipText("botón para eliminar una celda del inventario en la Base de datos.");
        botonEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botonActualizar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_actualizar.png"))); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.setToolTipText("botón para poder modificar la celda del  inventario en la Base de datos.");
        botonActualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(botonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(botonActualizar)
                .addGap(96, 96, 96)
                .addComponent(botonEliminar)
                .addGap(110, 110, 110)
                .addComponent(botonAgregar)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 210, 550));

        jPanel6.setBackground(new java.awt.Color(255, 204, 51));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel5.setText("Consultar Inventario ");

        botonConectar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        botonConectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_config.png"))); // NOI18N
        botonConectar.setText("Conectar");
        botonConectar.setToolTipText("botón para poder modificar los datos de conexión de la Base de datos.\n");
        botonConectar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(434, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(160, 160, 160)
                .addComponent(botonConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonConectar)))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1030, 50));

        botonDescargar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        botonDescargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_exportar.png"))); // NOI18N
        botonDescargar.setText("Descargar");
        botonDescargar.setToolTipText("botón para poder descargar la tabla, será guardada como un archivo excel.");
        botonDescargar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(botonDescargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

        botonIngresar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        botonIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_importar.png"))); // NOI18N
        botonIngresar.setText("Ingresar");
        botonIngresar.setToolTipText("botón para poder ingresar el inventario desde el archivo excel.");
        botonIngresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(botonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, 120, -1));

        jTabbedPane1.addTab("Inventario", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void cuadroIdPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadroIdPeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuadroIdPeliculaActionPerformed

    private void tablaInventarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaInventarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaInventarioKeyPressed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void cuadroIdInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadroIdInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuadroIdInventarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonConectar;
    private javax.swing.JButton botonDescargar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonIngresar;
    private javax.swing.JTextField cuadroIdInventario;
    private javax.swing.JTextField cuadroIdPelicula;
    private javax.swing.JTextField cuadroIdTienda;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaInventario;
    // End of variables declaration//GEN-END:variables
}

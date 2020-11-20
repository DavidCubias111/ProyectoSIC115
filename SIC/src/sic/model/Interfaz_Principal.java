
package sic.model;

import static java.awt.Color.BLUE;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.GroupLayout.Alignment.CENTER;
import sic.db.BCReport;
import sic.db.BGReport;
import sic.db.CuentaDB;
import sic.db.DepartamentoDB;
import sic.db.ECReport;
import sic.db.ERReport;
import sic.db.EmpleadoDB;
import sic.db.MayorDB;
import sic.db.PartidaDB;
import sic.db.PlanillaDB;
import sic.db.TransaccionDB;

/**
 * @author Velis
 */

public class Interfaz_Principal extends javax.swing.JFrame {
    private static int opcion;    
    private static boolean MAYORIZACION = false;
    private static final int BALANCE_COMPROBACION = 1;
    private static final int ESTADO_RESULTADO = 2;
    private static final int ESTADO_CAPITAL = 3;
    private static final int BALANCE_GENERAL = 4;
    private static final double IVA = 0.13;
    private boolean actualizar_cuenta; //Catalogo de cuentas
    private boolean actualizar_partida; //Libro diario
    private boolean actualizar_empleado;
    private Partida partida_actual;
    private Date start_date;
    private Date end_date;
    private LibroDiarioTM libroDiarioTM = new LibroDiarioTM();
    private CatalogoCuentasTM catalogoCuentasTM = new CatalogoCuentasTM();
    
    //EMPLEADOS
    EmpleadoTM empleadoTM = new EmpleadoTM();
    PlanillaTableModel planillaTM = new PlanillaTableModel();
    Departamento departamento_uno = new Departamento();
    
    
    public Interfaz_Principal() {
        initComponents();
        panel_crud_catalogo.setVisible(false);
        panel_crud_libro_diario.setVisible(false);
        msg_tabla_operacion.setVisible(false);
    }
   
    private void partida(){
        
        t_crud_libro_diario_numero.setText(null);
        t_crud_libro_diario_fecha.setDate(null);
        t_crud_libro_diario_debe.setText(null);
        t_crud_libro_diario_haber.setText(null);
        
        msg_tabla_operacion.setVisible(true);
        msg_tabla_operacion.setText("");
        msg_crud_libro_diario_cuenta.setText("");
        msg_crud_libro_diario_partida_operacion.setText("");
        btn_crud_libro_diario_guardar_partida.setEnabled(false);
        btn_crud_libro_diario_cancelar_partida.setEnabled(false);
        btn_crud_libro_diario_cuenta_agregar.setText("Agregar");
        crud_libro_diario.setTitle("Libro Diario - Registrar Partida");
        crud_libro_diario.setSize(785, 540);
        crud_libro_diario.setVisible(true);
        t_crud_libro_diario_numero.setEditable(true);

        CuentaListModel listModel = new CuentaListModel();
        CuentaDB db = new CuentaDB();
        listModel.setCuentas(db.getCuentas());
        lista_cuentas.setModel(listModel);
        lista_cuentas.repaint();

        LibroDiarioTM ldtm = new LibroDiarioTM();
        tabla_crud_libro_diario_partida.setModel(ldtm);
        tabla_crud_libro_diario_partida.setColumnModel(ldtm.getColumnModel());

        PartidaDB partDB = new PartidaDB();
        int numero_partida = partDB.getNextNumeroPartida();
        int id_partida = partDB.getNextIdPartida();

        partida_actual = new Partida(id_partida, numero_partida);

        t_crud_libro_diario_numero.setValue(numero_partida);
        Date fecha_actual = new Date(System.currentTimeMillis());
        t_crud_libro_diario_fecha.setDate(fecha_actual);

        actualizar_partida = false;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crud_catalogo_cuentas = new javax.swing.JDialog(this);
        ContePanel_Cuenta = new javax.swing.JPanel();
        msg_cuenta_operacion = new javax.swing.JLabel();
        panel_cuenta_crud = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        t_id_cuenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_nombre_cuenta = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        t_tipo_cuenta = new javax.swing.JComboBox();
        btn_cuenta_guardar = new javax.swing.JButton();
        btn_cuenta_cancelar = new javax.swing.JButton();
        ContePanel_Opciones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel_OpcionesCuenta = new javax.swing.JPanel();
        btn_Opc_BuscarCuenta = new javax.swing.JButton();
        btn_crud_catalogo_salir = new javax.swing.JButton();
        btn_cuenta_modificar = new javax.swing.JButton();
        btn_cuenta_nueva = new javax.swing.JButton();
        scroll_tabla_crud_catalogo_cuentas = new javax.swing.JScrollPane();
        tabla_crud_catalogo_cuentas = new javax.swing.JTable();
        crud_libro_diario = new javax.swing.JDialog(this);
        jPanel6 = new javax.swing.JPanel();
        scroll_tabla_crud_libro_diario_partida = new javax.swing.JScrollPane();
        tabla_crud_libro_diario_partida = new javax.swing.JTable();
        btn_crud_libro_diario_guardar_partida = new javax.swing.JButton();
        btn_crud_libro_diario_cancelar_partida = new javax.swing.JButton();
        msg_crud_libro_diario_partida_operacion = new javax.swing.JLabel();
        btn_crud_libro_diario_salir = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lista_cuentas = new javax.swing.JList();
        btn_crud_libro_diario_cuenta_agregar = new javax.swing.JButton();
        msg_crud_libro_diario_cuenta = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        t_crud_libro_diario_debe = new javax.swing.JFormattedTextField();
        t_crud_libro_diario_haber = new javax.swing.JFormattedTextField();
        t_crud_libro_diario_numero = new javax.swing.JFormattedTextField();
        btn_crud_libro_diario_cuenta_reset = new javax.swing.JButton();
        t_crud_libro_diario_fecha = new com.toedter.calendar.JDateChooser();
        jPanel11 = new javax.swing.JPanel();
        btn_iva_credito = new javax.swing.JRadioButton();
        btn_iva_exento = new javax.swing.JRadioButton();
        btn_iva_debito = new javax.swing.JRadioButton();
        dlg_periodo = new javax.swing.JDialog(this);
        lbl_periodo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_dlg_fecha_inicio = new com.toedter.calendar.JDateChooser();
        btn_dlg_fecha_fin = new com.toedter.calendar.JDateChooser();
        btn_dlg_aceptar = new javax.swing.JButton();
        btn_dlg_cancelar = new javax.swing.JButton();
        dlg_Buscar_Cuenta = new javax.swing.JDialog();
        Conte_BuscarCuenta = new javax.swing.JPanel();
        panel_BuscarCuenta = new javax.swing.JPanel();
        tex_Nombre_CuentaB = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        list_TipoCuenta_Buscar = new javax.swing.JComboBox();
        btn_CuentaBuscar = new javax.swing.JButton();
        btn_CuentaBuscar_Cancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_catalogo = new javax.swing.JButton();
        btn_libro_diario = new javax.swing.JButton();
        btn_mayorizar = new javax.swing.JButton();
        msg_tabla_operacion = new javax.swing.JLabel();
        scroll_tabla = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        panel_crud_catalogo = new javax.swing.JPanel();
        btn_agregar_cuenta = new javax.swing.JButton();
        panel_crud_libro_diario = new javax.swing.JPanel();
        btn_nueva_partida = new javax.swing.JButton();
        btn_modificar_partida = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_Balance_Compro = new javax.swing.JMenuItem();
        menu_Estado_Res = new javax.swing.JMenuItem();
        menu_Estado_Capi = new javax.swing.JMenuItem();
        menu_Balance_Gene = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        AdmCatalogo = new javax.swing.JMenuItem();
        Adm_Libro = new javax.swing.JMenuItem();

        crud_catalogo_cuentas.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        crud_catalogo_cuentas.setTitle("Catálogo de Cuentas");
        crud_catalogo_cuentas.setMinimumSize(new java.awt.Dimension(800, 460));
        crud_catalogo_cuentas.setResizable(false);

        ContePanel_Cuenta.setPreferredSize(new java.awt.Dimension(300, 350));

        msg_cuenta_operacion.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        msg_cuenta_operacion.setForeground(new java.awt.Color(102, 102, 255));

        panel_cuenta_crud.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cuenta"));
        panel_cuenta_crud.setPreferredSize(new java.awt.Dimension(275, 275));

        jLabel2.setText("Código :");

        jLabel3.setText("Nombre :");

        t_nombre_cuenta.setColumns(20);
        t_nombre_cuenta.setRows(5);
        jScrollPane2.setViewportView(t_nombre_cuenta);

        jLabel4.setText("Tipo :");

        t_tipo_cuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar tipo...", "Activo", "Pasivo", "Capital", "Resultado Deudor", "Resultado Acreedor" }));

        btn_cuenta_guardar.setText("Guardar");
        btn_cuenta_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cuenta_guardarActionPerformed(evt);
            }
        });

        btn_cuenta_cancelar.setText("Cancelar");
        btn_cuenta_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cuenta_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_cuenta_crudLayout = new javax.swing.GroupLayout(panel_cuenta_crud);
        panel_cuenta_crud.setLayout(panel_cuenta_crudLayout);
        panel_cuenta_crudLayout.setHorizontalGroup(
            panel_cuenta_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cuenta_crudLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel_cuenta_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_cuenta_crudLayout.createSequentialGroup()
                        .addGroup(panel_cuenta_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(panel_cuenta_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_cuenta_crudLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2)
                                .addContainerGap())
                            .addGroup(panel_cuenta_crudLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t_id_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_cuenta_crudLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(t_tipo_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(panel_cuenta_crudLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btn_cuenta_cancelar)
                        .addGap(39, 39, 39)
                        .addComponent(btn_cuenta_guardar)
                        .addContainerGap())))
        );
        panel_cuenta_crudLayout.setVerticalGroup(
            panel_cuenta_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cuenta_crudLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel_cuenta_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_tipo_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(25, 25, 25)
                .addGroup(panel_cuenta_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(t_id_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panel_cuenta_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panel_cuenta_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cuenta_guardar)
                    .addComponent(btn_cuenta_cancelar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ContePanel_CuentaLayout = new javax.swing.GroupLayout(ContePanel_Cuenta);
        ContePanel_Cuenta.setLayout(ContePanel_CuentaLayout);
        ContePanel_CuentaLayout.setHorizontalGroup(
            ContePanel_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContePanel_CuentaLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(ContePanel_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msg_cuenta_operacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContePanel_CuentaLayout.createSequentialGroup()
                        .addComponent(panel_cuenta_crud, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        ContePanel_CuentaLayout.setVerticalGroup(
            ContePanel_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContePanel_CuentaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(msg_cuenta_operacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panel_cuenta_crud, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ContePanel_Opciones.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 204, 255), null));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("CATALOGO DE CUENTAS");

        panel_OpcionesCuenta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 12), new java.awt.Color(102, 153, 255))); // NOI18N

        btn_Opc_BuscarCuenta.setText("Buscar Cuenta");
        btn_Opc_BuscarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Opc_BuscarCuentaActionPerformed(evt);
            }
        });

        btn_crud_catalogo_salir.setText("Salir");
        btn_crud_catalogo_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crud_catalogo_salirActionPerformed(evt);
            }
        });

        btn_cuenta_modificar.setText("Modificar");
        btn_cuenta_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cuenta_modificarActionPerformed(evt);
            }
        });

        btn_cuenta_nueva.setText("Nueva Cuenta");
        btn_cuenta_nueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cuenta_nuevaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_OpcionesCuentaLayout = new javax.swing.GroupLayout(panel_OpcionesCuenta);
        panel_OpcionesCuenta.setLayout(panel_OpcionesCuentaLayout);
        panel_OpcionesCuentaLayout.setHorizontalGroup(
            panel_OpcionesCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_OpcionesCuentaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btn_cuenta_nueva)
                .addGap(34, 34, 34)
                .addComponent(btn_cuenta_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_crud_catalogo_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Opc_BuscarCuenta)
                .addGap(77, 77, 77))
        );
        panel_OpcionesCuentaLayout.setVerticalGroup(
            panel_OpcionesCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_OpcionesCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_OpcionesCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Opc_BuscarCuenta)
                    .addComponent(btn_crud_catalogo_salir)
                    .addComponent(btn_cuenta_modificar)
                    .addComponent(btn_cuenta_nueva))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ContePanel_OpcionesLayout = new javax.swing.GroupLayout(ContePanel_Opciones);
        ContePanel_Opciones.setLayout(ContePanel_OpcionesLayout);
        ContePanel_OpcionesLayout.setHorizontalGroup(
            ContePanel_OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContePanel_OpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_OpcionesCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(ContePanel_OpcionesLayout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContePanel_OpcionesLayout.setVerticalGroup(
            ContePanel_OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContePanel_OpcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_OpcionesCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabla_crud_catalogo_cuentas.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 204, 255), null));
        scroll_tabla_crud_catalogo_cuentas.setViewportView(tabla_crud_catalogo_cuentas);

        javax.swing.GroupLayout crud_catalogo_cuentasLayout = new javax.swing.GroupLayout(crud_catalogo_cuentas.getContentPane());
        crud_catalogo_cuentas.getContentPane().setLayout(crud_catalogo_cuentasLayout);
        crud_catalogo_cuentasLayout.setHorizontalGroup(
            crud_catalogo_cuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContePanel_Opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(crud_catalogo_cuentasLayout.createSequentialGroup()
                .addComponent(ContePanel_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_tabla_crud_catalogo_cuentas, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
        );
        crud_catalogo_cuentasLayout.setVerticalGroup(
            crud_catalogo_cuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crud_catalogo_cuentasLayout.createSequentialGroup()
                .addComponent(ContePanel_Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(crud_catalogo_cuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crud_catalogo_cuentasLayout.createSequentialGroup()
                        .addComponent(ContePanel_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 56, Short.MAX_VALUE))
                    .addComponent(scroll_tabla_crud_catalogo_cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        crud_libro_diario.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        crud_libro_diario.setTitle("Libro Diario");
        crud_libro_diario.setAlwaysOnTop(true);
        crud_libro_diario.setMinimumSize(new java.awt.Dimension(800, 590));
        crud_libro_diario.setName("Libro Diario"); // NOI18N
        crud_libro_diario.setResizable(false);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Partida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        tabla_crud_libro_diario_partida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_crud_libro_diario_partida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_crud_libro_diario_partidaMouseClicked(evt);
            }
        });
        scroll_tabla_crud_libro_diario_partida.setViewportView(tabla_crud_libro_diario_partida);

        btn_crud_libro_diario_guardar_partida.setText("Guardar");
        btn_crud_libro_diario_guardar_partida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crud_libro_diario_guardar_partidaActionPerformed(evt);
            }
        });

        btn_crud_libro_diario_cancelar_partida.setText("Cancelar");
        btn_crud_libro_diario_cancelar_partida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crud_libro_diario_cancelar_partidaActionPerformed(evt);
            }
        });

        msg_crud_libro_diario_partida_operacion.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        msg_crud_libro_diario_partida_operacion.setForeground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(msg_crud_libro_diario_partida_operacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_crud_libro_diario_cancelar_partida)
                        .addGap(18, 18, 18)
                        .addComponent(btn_crud_libro_diario_guardar_partida))
                    .addComponent(scroll_tabla_crud_libro_diario_partida, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(scroll_tabla_crud_libro_diario_partida, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg_crud_libro_diario_partida_operacion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_crud_libro_diario_cancelar_partida)
                        .addComponent(btn_crud_libro_diario_guardar_partida)))
                .addGap(238, 238, 238))
        );

        btn_crud_libro_diario_salir.setText("Salir");
        btn_crud_libro_diario_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crud_libro_diario_salirActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Transacción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        lista_cuentas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lista_cuentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lista_cuentas);

        btn_crud_libro_diario_cuenta_agregar.setText("Agregar");
        btn_crud_libro_diario_cuenta_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crud_libro_diario_cuenta_agregarActionPerformed(evt);
            }
        });

        msg_crud_libro_diario_cuenta.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        msg_crud_libro_diario_cuenta.setForeground(new java.awt.Color(102, 102, 255));

        jLabel6.setText("Partida No.");

        jLabel7.setText("Fecha");

        jLabel8.setText("Debe");

        jLabel9.setText("Haber");

        t_crud_libro_diario_debe.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        t_crud_libro_diario_haber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        t_crud_libro_diario_numero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        t_crud_libro_diario_numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_crud_libro_diario_numeroKeyPressed(evt);
            }
        });

        btn_crud_libro_diario_cuenta_reset.setText("Reset");
        btn_crud_libro_diario_cuenta_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crud_libro_diario_cuenta_resetActionPerformed(evt);
            }
        });

        t_crud_libro_diario_fecha.setDateFormatString("dd-MM-yyyy");

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "IVA"));

        btn_iva_credito.setText("Credito");

        btn_iva_exento.setSelected(true);
        btn_iva_exento.setText("Exento");

        btn_iva_debito.setText("Debito");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_iva_credito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_iva_debito)
                .addGap(14, 14, 14)
                .addComponent(btn_iva_exento)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_iva_credito)
                    .addComponent(btn_iva_exento)
                    .addComponent(btn_iva_debito))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(btn_crud_libro_diario_cuenta_reset)
                                .addGap(18, 18, 18)
                                .addComponent(btn_crud_libro_diario_cuenta_agregar))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(t_crud_libro_diario_debe)
                                    .addComponent(t_crud_libro_diario_haber)
                                    .addComponent(t_crud_libro_diario_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(t_crud_libro_diario_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(19, 19, 19))
                    .addComponent(msg_crud_libro_diario_cuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(t_crud_libro_diario_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(t_crud_libro_diario_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_crud_libro_diario_debe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_crud_libro_diario_haber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg_crud_libro_diario_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_crud_libro_diario_cuenta_agregar)
                            .addComponent(btn_crud_libro_diario_cuenta_reset))))
                .addContainerGap())
        );

        javax.swing.GroupLayout crud_libro_diarioLayout = new javax.swing.GroupLayout(crud_libro_diario.getContentPane());
        crud_libro_diario.getContentPane().setLayout(crud_libro_diarioLayout);
        crud_libro_diarioLayout.setHorizontalGroup(
            crud_libro_diarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crud_libro_diarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crud_libro_diarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(crud_libro_diarioLayout.createSequentialGroup()
                        .addGap(0, 681, Short.MAX_VALUE)
                        .addComponent(btn_crud_libro_diario_salir)))
                .addContainerGap())
        );
        crud_libro_diarioLayout.setVerticalGroup(
            crud_libro_diarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crud_libro_diarioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_crud_libro_diario_salir)
                .addGap(12, 12, 12))
        );

        dlg_periodo.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dlg_periodo.setMinimumSize(new java.awt.Dimension(410, 250));
        dlg_periodo.setResizable(false);

        lbl_periodo.setFont(new java.awt.Font("Minion Pro SmBd", 1, 18)); // NOI18N
        lbl_periodo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_periodo.setText("PERIODO");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Del ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Al ");

        btn_dlg_fecha_inicio.setDateFormatString("dd-MM-yyyy");
        btn_dlg_fecha_inicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_dlg_fecha_fin.setDateFormatString("dd-MM-yyyy");
        btn_dlg_fecha_fin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_dlg_aceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_dlg_aceptar.setText("Aceptar");
        btn_dlg_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dlg_aceptarActionPerformed(evt);
            }
        });

        btn_dlg_cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_dlg_cancelar.setText("Cancelar");
        btn_dlg_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dlg_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlg_periodoLayout = new javax.swing.GroupLayout(dlg_periodo.getContentPane());
        dlg_periodo.getContentPane().setLayout(dlg_periodoLayout);
        dlg_periodoLayout.setHorizontalGroup(
            dlg_periodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlg_periodoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_dlg_cancelar)
                .addGap(18, 18, 18)
                .addComponent(btn_dlg_aceptar)
                .addGap(99, 99, 99))
            .addGroup(dlg_periodoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(dlg_periodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dlg_periodoLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_dlg_fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_dlg_fecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        dlg_periodoLayout.setVerticalGroup(
            dlg_periodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlg_periodoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbl_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(dlg_periodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_dlg_fecha_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(btn_dlg_fecha_fin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(dlg_periodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dlg_cancelar)
                    .addComponent(btn_dlg_aceptar))
                .addGap(48, 48, 48))
        );

        Conte_BuscarCuenta.setPreferredSize(new java.awt.Dimension(350, 275));

        panel_BuscarCuenta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar Cuenta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14), new java.awt.Color(102, 153, 255))); // NOI18N
        panel_BuscarCuenta.setPreferredSize(new java.awt.Dimension(275, 275));

        jLabel12.setText("Nombre :");

        jLabel13.setText("Tipo :");

        list_TipoCuenta_Buscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar tipo...", "Activo", "Pasivo", "Capital", "Resultado Deudor", "Resultado Acreedor" }));

        btn_CuentaBuscar.setText("Buscar");
        btn_CuentaBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CuentaBuscarActionPerformed(evt);
            }
        });

        btn_CuentaBuscar_Cancelar.setText("Cancelar");
        btn_CuentaBuscar_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CuentaBuscar_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_BuscarCuentaLayout = new javax.swing.GroupLayout(panel_BuscarCuenta);
        panel_BuscarCuenta.setLayout(panel_BuscarCuentaLayout);
        panel_BuscarCuentaLayout.setHorizontalGroup(
            panel_BuscarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BuscarCuentaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panel_BuscarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_BuscarCuentaLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tex_Nombre_CuentaB, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_BuscarCuentaLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(list_TipoCuenta_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_BuscarCuentaLayout.createSequentialGroup()
                        .addComponent(btn_CuentaBuscar_Cancelar)
                        .addGap(43, 43, 43)
                        .addComponent(btn_CuentaBuscar)
                        .addGap(10, 10, 10)))
                .addGap(30, 30, 30))
        );
        panel_BuscarCuentaLayout.setVerticalGroup(
            panel_BuscarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BuscarCuentaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panel_BuscarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(list_TipoCuenta_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(30, 30, 30)
                .addGroup(panel_BuscarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tex_Nombre_CuentaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(26, 26, 26)
                .addGroup(panel_BuscarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_CuentaBuscar)
                    .addComponent(btn_CuentaBuscar_Cancelar))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Conte_BuscarCuentaLayout = new javax.swing.GroupLayout(Conte_BuscarCuenta);
        Conte_BuscarCuenta.setLayout(Conte_BuscarCuentaLayout);
        Conte_BuscarCuentaLayout.setHorizontalGroup(
            Conte_BuscarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Conte_BuscarCuentaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panel_BuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        Conte_BuscarCuentaLayout.setVerticalGroup(
            Conte_BuscarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Conte_BuscarCuentaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panel_BuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout dlg_Buscar_CuentaLayout = new javax.swing.GroupLayout(dlg_Buscar_Cuenta.getContentPane());
        dlg_Buscar_Cuenta.getContentPane().setLayout(dlg_Buscar_CuentaLayout);
        dlg_Buscar_CuentaLayout.setHorizontalGroup(
            dlg_Buscar_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
            .addGroup(dlg_Buscar_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dlg_Buscar_CuentaLayout.createSequentialGroup()
                    .addComponent(Conte_BuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        dlg_Buscar_CuentaLayout.setVerticalGroup(
            dlg_Buscar_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(dlg_Buscar_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dlg_Buscar_CuentaLayout.createSequentialGroup()
                    .addComponent(Conte_BuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 204, 255), null));
        jPanel3.setForeground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 12), new java.awt.Color(102, 102, 255))); // NOI18N

        btn_catalogo.setText("Catalogo de cuentas");
        btn_catalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_catalogoActionPerformed(evt);
            }
        });

        btn_libro_diario.setText("Libreo Diario");
        btn_libro_diario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_libro_diarioActionPerformed(evt);
            }
        });

        btn_mayorizar.setText("Mayorizar");
        btn_mayorizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mayorizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_libro_diario, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(btn_catalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(btn_mayorizar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_libro_diario)
                    .addComponent(btn_mayorizar)
                    .addComponent(btn_catalogo))
                .addContainerGap())
        );

        msg_tabla_operacion.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        msg_tabla_operacion.setForeground(new java.awt.Color(102, 102, 255));
        msg_tabla_operacion.setMaximumSize(new java.awt.Dimension(40, 20));
        msg_tabla_operacion.setMinimumSize(new java.awt.Dimension(40, 20));
        msg_tabla_operacion.setPreferredSize(new java.awt.Dimension(40, 20));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addComponent(msg_tabla_operacion, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(msg_tabla_operacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabla.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 204, 255), null));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scroll_tabla.setViewportView(tabla);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 204, 255), null));

        btn_agregar_cuenta.setText("Administrar");
        btn_agregar_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_cuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_crud_catalogoLayout = new javax.swing.GroupLayout(panel_crud_catalogo);
        panel_crud_catalogo.setLayout(panel_crud_catalogoLayout);
        panel_crud_catalogoLayout.setHorizontalGroup(
            panel_crud_catalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_crud_catalogoLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(btn_agregar_cuenta)
                .addGap(19, 19, 19))
        );
        panel_crud_catalogoLayout.setVerticalGroup(
            panel_crud_catalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_crud_catalogoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btn_agregar_cuenta)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btn_nueva_partida.setText("Registar");
        btn_nueva_partida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nueva_partidaActionPerformed(evt);
            }
        });

        btn_modificar_partida.setText("Editar Partida");
        btn_modificar_partida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_partidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_crud_libro_diarioLayout = new javax.swing.GroupLayout(panel_crud_libro_diario);
        panel_crud_libro_diario.setLayout(panel_crud_libro_diarioLayout);
        panel_crud_libro_diarioLayout.setHorizontalGroup(
            panel_crud_libro_diarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_crud_libro_diarioLayout.createSequentialGroup()
                .addGroup(panel_crud_libro_diarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_crud_libro_diarioLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btn_nueva_partida))
                    .addGroup(panel_crud_libro_diarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_modificar_partida)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_crud_libro_diarioLayout.setVerticalGroup(
            panel_crud_libro_diarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_crud_libro_diarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn_nueva_partida)
                .addGap(18, 18, 18)
                .addComponent(btn_modificar_partida)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_crud_catalogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_crud_libro_diario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_crud_catalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_crud_libro_diario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setForeground(new java.awt.Color(0, 204, 204));

        jMenu1.setText("Estados Financieros");

        menu_Balance_Compro.setText("Balance de Comprobacion");
        menu_Balance_Compro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_Balance_ComproActionPerformed(evt);
            }
        });
        jMenu1.add(menu_Balance_Compro);

        menu_Estado_Res.setText("Estado de Resultados");
        menu_Estado_Res.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_Estado_ResActionPerformed(evt);
            }
        });
        jMenu1.add(menu_Estado_Res);

        menu_Estado_Capi.setText("Estado de Capital");
        menu_Estado_Capi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_Estado_CapiActionPerformed(evt);
            }
        });
        jMenu1.add(menu_Estado_Capi);

        menu_Balance_Gene.setText("Balance General");
        menu_Balance_Gene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_Balance_GeneActionPerformed(evt);
            }
        });
        jMenu1.add(menu_Balance_Gene);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Herramientas");

        AdmCatalogo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        AdmCatalogo.setText("Administrar Catalogo de Cuentas");
        AdmCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmCatalogoActionPerformed(evt);
            }
        });
        jMenu2.add(AdmCatalogo);

        Adm_Libro.setText("Administrar Libro Diario");
        Adm_Libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Adm_LibroActionPerformed(evt);
            }
        });
        jMenu2.add(Adm_Libro);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scroll_tabla, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scroll_tabla, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
       
    }//GEN-LAST:event_formWindowClosing

    private void AdmCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmCatalogoActionPerformed
        
        crud_catalogo_cuentas.setSize(850,500);
        crud_catalogo_cuentas.setLocationRelativeTo(this);
        crud_catalogo_cuentas.setVisible(true);
        ContePanel_Cuenta.setVisible(false); 
        
        CatalogoCuentasTM mt = new CatalogoCuentasTM();
        tabla_crud_catalogo_cuentas.setModel(mt);
        tabla_crud_catalogo_cuentas.setColumnModel(mt.getColumnModel());
        mt.setCatalogo_cuentas((new CuentaDB()).getCuentas());
        scroll_tabla_crud_catalogo_cuentas.setViewportView(tabla_crud_catalogo_cuentas);
        tabla_crud_catalogo_cuentas.repaint();
        msg_cuenta_operacion.setText("");
      
    }//GEN-LAST:event_AdmCatalogoActionPerformed

    private void Adm_LibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Adm_LibroActionPerformed
        partida();
    }//GEN-LAST:event_Adm_LibroActionPerformed

    private void btn_libro_diarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_libro_diarioActionPerformed
        // TODO add your handling code here:
        panel_crud_catalogo.setVisible(false);
        panel_crud_libro_diario.setVisible(true);

        tabla.setModel(libroDiarioTM);
        tabla.setColumnModel(libroDiarioTM.getColumnModel());
        TransaccionDB tdb = new TransaccionDB();
        libroDiarioTM.setLibro_diario(tdb.getTransacciones());
        scroll_tabla.setViewportView(tabla);
        tabla.repaint();
    }//GEN-LAST:event_btn_libro_diarioActionPerformed

    private void btn_catalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_catalogoActionPerformed
        // TODO add your handling code here:
        panel_crud_libro_diario.setVisible(false);
        panel_crud_catalogo.setVisible(true);
        tabla.setModel(catalogoCuentasTM);
        tabla.setColumnModel(catalogoCuentasTM.getColumnModel());
        CuentaDB cuenta = new CuentaDB();
        catalogoCuentasTM.setCatalogo_cuentas(cuenta.getCuentas());
        scroll_tabla.setViewportView(tabla);
        tabla.repaint();
    }//GEN-LAST:event_btn_catalogoActionPerformed

    private void btn_agregar_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_cuentaActionPerformed
        // TODO add your handling code here:
        crud_catalogo_cuentas.setSize(850,500);
        crud_catalogo_cuentas.setLocationRelativeTo(this);
        crud_catalogo_cuentas.setVisible(true);
        //panel_cuenta_crud.setVisible(false);
       // msg_cuenta_operacion.setVisible(false);
        ContePanel_Cuenta.setVisible(false);
        
        //scroll_tabla_crud_catalogo_cuentas.setVisible(true);
        CatalogoCuentasTM mt = new CatalogoCuentasTM();
        tabla_crud_catalogo_cuentas.setModel(mt);
        tabla_crud_catalogo_cuentas.setColumnModel(mt.getColumnModel());
        mt.setCatalogo_cuentas((new CuentaDB()).getCuentas());
        scroll_tabla_crud_catalogo_cuentas.setViewportView(tabla_crud_catalogo_cuentas);
        tabla_crud_catalogo_cuentas.repaint();
        msg_cuenta_operacion.setText("");
    }//GEN-LAST:event_btn_agregar_cuentaActionPerformed

    private void btn_cuenta_nuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cuenta_nuevaActionPerformed
        
        ContePanel_Cuenta.setVisible(true);
        panel_cuenta_crud.setVisible(true);
        actualizar_cuenta = false;
        msg_cuenta_operacion.setText("");
        t_id_cuenta.setText("");
        t_nombre_cuenta.setText("");
        t_tipo_cuenta.setSelectedIndex(0);
    }//GEN-LAST:event_btn_cuenta_nuevaActionPerformed

    private void btn_cuenta_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cuenta_modificarActionPerformed

        //Si hay fila seleccionada en la tabla
        if (tabla_crud_catalogo_cuentas.getSelectedRow() > -1) {
            
            ContePanel_Cuenta.setVisible(true);
            panel_cuenta_crud.setVisible(true);
            actualizar_cuenta = true;
            msg_cuenta_operacion.setText(""); 
            CatalogoCuentasTM cctm = (CatalogoCuentasTM) tabla_crud_catalogo_cuentas.getModel();
            Cuenta cuenta = cctm.getCuenta(tabla_crud_catalogo_cuentas.getSelectedRow());
            t_id_cuenta.setText(cuenta.getId_cuenta().trim());
            t_nombre_cuenta.setText(cuenta.getNombre_cuenta().trim());
            t_tipo_cuenta.setSelectedItem(cuenta.getTipo_cuenta().trim());
            t_id_cuenta.setEditable(false);

        } else {
            ContePanel_Cuenta.setVisible(true);
            msg_cuenta_operacion.setText("* Seleccione cuenta en la tabla");

        }
    }//GEN-LAST:event_btn_cuenta_modificarActionPerformed

    private void btn_cuenta_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cuenta_guardarActionPerformed

        //Este boton cumple dos funciones: guardar y actualizar cuentas
        if (!actualizar_cuenta) {
            //Funcion del boton: Guardar nueva cuenta
            if (!t_id_cuenta.getText().trim().isEmpty() & !t_nombre_cuenta.getText().trim().isEmpty() & (t_tipo_cuenta.getSelectedIndex() != 0)) {

                String id_cuenta = t_id_cuenta.getText().trim();
                String nombre_cuenta = t_nombre_cuenta.getText().trim();
                String tipo_cuenta = t_tipo_cuenta.getSelectedItem().toString();
                CuentaDB db = new CuentaDB();
                if (db.guardar(id_cuenta, nombre_cuenta, tipo_cuenta)) {

                    CatalogoCuentasTM cctm = (CatalogoCuentasTM) tabla_crud_catalogo_cuentas.getModel();
                    cctm.setCatalogo_cuentas(db.getCuentas());
                    scroll_tabla_crud_catalogo_cuentas.setViewportView(tabla_crud_catalogo_cuentas);
                    tabla_crud_catalogo_cuentas.repaint();
                    msg_cuenta_operacion.setText("Cuenta guardada!");

                } else {

                    msg_cuenta_operacion.setText("* No se pudo guardar la cuenta");

                }

                t_id_cuenta.setText("");
                t_nombre_cuenta.setText("");
                t_tipo_cuenta.setSelectedIndex(0);
                panel_cuenta_crud.setVisible(false);

            } else {

                msg_cuenta_operacion.setText("* Llene todos los campos");

            }

        } else {

            //Funcion del boton: Actualizar cuenta
            if (!t_nombre_cuenta.getText().trim().isEmpty() & t_tipo_cuenta.getSelectedIndex() > 0) {

                CuentaDB db = new CuentaDB();
                String id_cuenta = t_id_cuenta.getText().trim();
                String nombre_cuenta = t_nombre_cuenta.getText().trim();
                String tipo_cuenta = t_tipo_cuenta.getSelectedItem().toString();
                if (db.actualizar(id_cuenta, nombre_cuenta, tipo_cuenta)) {

                    CatalogoCuentasTM cctm = (CatalogoCuentasTM) tabla_crud_catalogo_cuentas.getModel();
                    cctm.setCatalogo_cuentas(db.getCuentas());
                    scroll_tabla_crud_catalogo_cuentas.setViewportView(tabla_crud_catalogo_cuentas);
                    tabla_crud_catalogo_cuentas.repaint();
                    msg_cuenta_operacion.setText("Cuenta actualizada!");

                } else {

                    msg_cuenta_operacion.setText("* No se pudo actualizar la cuenta");

                }
                t_id_cuenta.setText("");
                t_nombre_cuenta.setText("");
                t_tipo_cuenta.setSelectedIndex(0);
                t_id_cuenta.setEditable(true);
                panel_cuenta_crud.setVisible(false);

            } else {

                msg_cuenta_operacion.setText("* Llene todos los campos");

            }

        }
    }//GEN-LAST:event_btn_cuenta_guardarActionPerformed

    private void btn_cuenta_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cuenta_cancelarActionPerformed

        msg_cuenta_operacion.setText("");
        t_id_cuenta.setText("");
        t_nombre_cuenta.setText("");
        t_tipo_cuenta.setSelectedIndex(0);
        t_id_cuenta.setEditable(true);
        
        ContePanel_Cuenta.setVisible(false);
        //panel_cuenta_crud.setVisible(false);
    }//GEN-LAST:event_btn_cuenta_cancelarActionPerformed

    private void btn_crud_catalogo_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crud_catalogo_salirActionPerformed

        crud_catalogo_cuentas.dispose();
    }//GEN-LAST:event_btn_crud_catalogo_salirActionPerformed

    private void btn_nueva_partidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nueva_partidaActionPerformed
     partida();
    }//GEN-LAST:event_btn_nueva_partidaActionPerformed

    private void tabla_crud_libro_diario_partidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_crud_libro_diario_partidaMouseClicked

        if (tabla_crud_libro_diario_partida.getSelectedRow() != -1) {

            int fila = tabla_crud_libro_diario_partida.rowAtPoint(evt.getPoint());
            LibroDiarioTM model = (LibroDiarioTM) tabla_crud_libro_diario_partida.getModel();
            Transaccion transaccion = model.getLibro_diario().get(fila);
            t_crud_libro_diario_numero.setValue(transaccion.getPartida().getNum_partida());
            t_crud_libro_diario_fecha.setDate(transaccion.getFecha_tran());
            t_crud_libro_diario_debe.setValue(transaccion.getDebe());
            t_crud_libro_diario_haber.setValue(transaccion.getHaber());
            CuentaListModel lm = (CuentaListModel) lista_cuentas.getModel();
            int index = lm.getIndexOF(transaccion.getCuenta());
            lista_cuentas.ensureIndexIsVisible(index);
            lista_cuentas.setSelectedIndex(index);

        }
    }//GEN-LAST:event_tabla_crud_libro_diario_partidaMouseClicked

    private void btn_crud_libro_diario_guardar_partidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crud_libro_diario_guardar_partidaActionPerformed

        if (actualizar_partida) {
            //Funcion del boton: ACTUALIZAR la partida seleccionada ************
            LibroDiarioTM model = (LibroDiarioTM) tabla_crud_libro_diario_partida.getModel();
            List<Transaccion> transacciones = model.getLibro_diario();
            //COMPROBAR PARTIDA DOBLE ++++++++++++++++++++++++++++++++++++++
            double total_debe = 0.0;
            double total_haber = 0.0;
            for (Transaccion tr : model.getLibro_diario()) {
                total_debe += tr.getDebe();
                total_haber += tr.getHaber();
            }
            if (total_debe == total_haber) {
                TransaccionDB dbt = new TransaccionDB();
                for (Transaccion t : transacciones) {
                    if (dbt.actualizar(t.getId_transaccion(), t.getCuenta(), t.getPartida(), t.getFecha_tran(), t.getDebe(), t.getHaber())) {
                        msg_crud_libro_diario_partida_operacion.setText("* Partida actualizada");
                    } else {
                        msg_crud_libro_diario_partida_operacion.setText("* No se pudo actualizar la partida");
                    }
                }
            } else {
                msg_crud_libro_diario_partida_operacion.setText("* No se puede actualizar, debe cumplir PARTIDA DOBLE");
            }

        } else {
            //Funcion del boton: GUARDAR nueva partida *************************
            LibroDiarioTM model = (LibroDiarioTM) tabla_crud_libro_diario_partida.getModel();
            //COMPROBAR MINIMO DE TRASACCIONES POR PARTIDA
            if (!model.getLibro_diario().isEmpty() & model.getLibro_diario().size() >= 2) {
                //COMPROBAR PARTIDA DOBLE ++++++++++++++++++++++++++++++++++++++
                double total_debe = 0.0;
                double total_haber = 0.0;
                for (Transaccion tr : model.getLibro_diario()) {
                    total_debe += tr.getDebe();
                    total_haber += tr.getHaber();
                }
                if (total_debe == total_haber) {
                    PartidaDB pdb = new PartidaDB();
                    if (pdb.guardar(partida_actual.getNum_partida())) {

                        TransaccionDB tdb = new TransaccionDB();
                        for (Transaccion t : model.getLibro_diario()) {

                            if (tdb.guardar(t.getCuenta(), t.getPartida(), t.getFecha_tran(), t.getDebe(), t.getHaber())) {
                                msg_crud_libro_diario_partida_operacion.setText("* Transaccion guardada");
                            } else {
                                msg_crud_libro_diario_partida_operacion.setText("* No se pudo guardar la transaccion");
                            }
                        }
                        msg_crud_libro_diario_partida_operacion.setText("* Partida guardada");
                    } else {
                        msg_crud_libro_diario_partida_operacion.setText("* No se pudo guardar la partida");
                    }

                    //LIMPIAR EL MODELO DE LA TABLA
                    model.getLibro_diario().clear();
                    scroll_tabla_crud_libro_diario_partida.setViewportView(tabla_crud_libro_diario_partida);
                    tabla_crud_libro_diario_partida.repaint();

                    btn_crud_libro_diario_guardar_partida.setEnabled(false);
                    btn_crud_libro_diario_cancelar_partida.setEnabled(false);
                } else {
                    msg_crud_libro_diario_partida_operacion.setText("* No se puede guardar, debe cumplir PARTIDA DOBLE");
                }

            } else {
                msg_crud_libro_diario_partida_operacion.setText("* Partida sin transacciones o faltan transacciones");
            }
        }
    }//GEN-LAST:event_btn_crud_libro_diario_guardar_partidaActionPerformed

    private void btn_crud_libro_diario_cancelar_partidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crud_libro_diario_cancelar_partidaActionPerformed

        //LIMPIAR EL MODELO DE LA TABLA
        LibroDiarioTM model = (LibroDiarioTM) tabla_crud_libro_diario_partida.getModel();
        model.getLibro_diario().clear();
        scroll_tabla_crud_libro_diario_partida.setViewportView(tabla_crud_libro_diario_partida);
        tabla_crud_libro_diario_partida.repaint();
        btn_crud_libro_diario_guardar_partida.setEnabled(false);
        btn_crud_libro_diario_cancelar_partida.setEnabled(false);

        if (actualizar_partida) {
            crud_libro_diario.dispose();
        }
    }//GEN-LAST:event_btn_crud_libro_diario_cancelar_partidaActionPerformed

    private void btn_crud_libro_diario_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crud_libro_diario_salirActionPerformed

        crud_libro_diario.dispose();
    }//GEN-LAST:event_btn_crud_libro_diario_salirActionPerformed

    private void btn_crud_libro_diario_cuenta_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crud_libro_diario_cuenta_agregarActionPerformed

        //COMPROBAR QUE LOS CAMPOS REQUERIDOS NO ESTEN VACIOS
        if ((lista_cuentas.getSelectedIndex() != -1)
            & !t_crud_libro_diario_numero.getText().trim().isEmpty()
            & !t_crud_libro_diario_fecha.getDate().toString().isEmpty()
            & (!t_crud_libro_diario_debe.getText().trim().isEmpty()
                || !t_crud_libro_diario_haber.getText().trim().isEmpty())) {

            //AGREGAR LA CUENTA A LA PARTIDA
            CuentaListModel lm = (CuentaListModel) lista_cuentas.getModel();
            Cuenta cuenta = lm.getElementAt(lista_cuentas.getSelectedIndex());

            Integer numero_partida = Integer.parseInt(t_crud_libro_diario_numero.getText().trim());
            partida_actual.setNum_partida(numero_partida);

            java.util.Date date = (java.util.Date) t_crud_libro_diario_fecha.getDate();
            Date fecha = new Date(date.getTime());
            Double debe = 0.0;
            try {
                debe = Double.parseDouble(t_crud_libro_diario_debe.getText().trim());
            } catch (Exception e) {
                System.out.println("* Campo debe vacio");
            }
            Double haber = 0.0;
            try {
                haber = Double.parseDouble(t_crud_libro_diario_haber.getText().trim());
            } catch (Exception e) {
                System.out.println("* Campo haber vacio");
            }

            Transaccion transaccion = new Transaccion(fecha, debe, haber, cuenta, partida_actual);
            LibroDiarioTM model = (LibroDiarioTM) tabla_crud_libro_diario_partida.getModel();

            if (actualizar_partida) {

                int indice = tabla_crud_libro_diario_partida.getSelectedRow();
                model.getLibro_diario().get(indice).setCuenta(transaccion.getCuenta());
                model.getLibro_diario().get(indice).setFecha_tran(transaccion.getFecha_tran());
                model.getLibro_diario().get(indice).setPartida(transaccion.getPartida());
                model.getLibro_diario().get(indice).setDebe(transaccion.getDebe());
                model.getLibro_diario().get(indice).setHaber(transaccion.getHaber());
                //SI ES UNA TRANSACCION QUE INVOLUCRA IVA
                if (!btn_iva_exento.isSelected()) {
                    double monto_debe = 0.0;
                    double monto_haber = 0.0;
                    if (debe > 0.0) {
                        monto_debe += debe * IVA;
                    } else if (haber > 0.0) {
                        monto_haber += haber * IVA;
                    }
                    if (btn_iva_credito.isSelected()) {
                        Transaccion iva_credito = new Transaccion(fecha, monto_debe, monto_haber, new CuentaDB().getCuenta("1161"), partida_actual);
                        model.getLibro_diario().add(iva_credito);
                    } else if (btn_iva_debito.isSelected()) {
                        Transaccion iva_credito = new Transaccion(fecha, monto_debe, monto_haber, new CuentaDB().getCuenta("2226"), partida_actual);
                        model.getLibro_diario().add(iva_credito);
                    }
                }

            } else {
                model.getLibro_diario().add(transaccion);
                //SI ES UNA TRANSACCION QUE INVOLUCRA IVA
                if (!btn_iva_exento.isSelected()) {
                    double monto_debe = 0.0;
                    double monto_haber = 0.0;
                    if (debe > 0.0) {
                        monto_debe += debe * IVA;
                    } else if (haber > 0.0) {
                        monto_haber += haber * IVA;
                    }
                    if (btn_iva_credito.isSelected()) {
                        Transaccion iva_credito = new Transaccion(fecha, monto_debe, monto_haber, new CuentaDB().getCuenta("1161"), partida_actual);
                        model.getLibro_diario().add(iva_credito);
                    } else if (btn_iva_debito.isSelected()) {
                        Transaccion iva_credito = new Transaccion(fecha, monto_debe, monto_haber, new CuentaDB().getCuenta("2226"), partida_actual);
                        model.getLibro_diario().add(iva_credito);
                    }
                }
            }

            scroll_tabla_crud_libro_diario_partida.setViewportView(tabla_crud_libro_diario_partida);
            tabla_crud_libro_diario_partida.repaint();

            msg_crud_libro_diario_cuenta.setText("");
            btn_crud_libro_diario_guardar_partida.setEnabled(true);
            btn_crud_libro_diario_cancelar_partida.setEnabled(true);

        } else {

            msg_crud_libro_diario_cuenta.setText("* Faltan datos");

        }
    }//GEN-LAST:event_btn_crud_libro_diario_cuenta_agregarActionPerformed

    private void t_crud_libro_diario_numeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_crud_libro_diario_numeroKeyPressed

        String str = "";
        try {
            t_crud_libro_diario_numero.commitEdit();
        } catch (ParseException ex) {
            Logger.getLogger(Interfaz_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (char c : t_crud_libro_diario_numero.getText().trim().toCharArray()) {
            if (Character.isDigit(c)) {
                str += c;
            }
        }
        t_crud_libro_diario_numero.setText(str);
    }//GEN-LAST:event_t_crud_libro_diario_numeroKeyPressed

    private void btn_crud_libro_diario_cuenta_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crud_libro_diario_cuenta_resetActionPerformed

        t_crud_libro_diario_debe.setText(null);
        t_crud_libro_diario_haber.setText(null);
        lista_cuentas.clearSelection();

        msg_crud_libro_diario_cuenta.setText("");
        msg_crud_libro_diario_partida_operacion.setText("");

        if (actualizar_partida) {
            t_crud_libro_diario_numero.setText("");
            t_crud_libro_diario_fecha.setDate(null);
        }
    }//GEN-LAST:event_btn_crud_libro_diario_cuenta_resetActionPerformed

    private void btn_modificar_partidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_partidaActionPerformed
        // TODO add your handling code here:
        
        if (tabla.getSelectedRow() != -1) {

            t_crud_libro_diario_numero.setText(null);
            t_crud_libro_diario_fecha.setDate(null);
            t_crud_libro_diario_debe.setText(null);
            t_crud_libro_diario_haber.setText(null);

            crud_libro_diario.setSize(785, 540);
            crud_libro_diario.setVisible(true);
            crud_libro_diario.setTitle("Libro Diario - Editar Partida");
            msg_crud_libro_diario_cuenta.setText("");
            msg_tabla_operacion.setVisible(true);
            msg_tabla_operacion.setText("");
            msg_crud_libro_diario_partida_operacion.setText("");
            btn_crud_libro_diario_guardar_partida.setEnabled(false);
            btn_crud_libro_diario_cancelar_partida.setEnabled(false);
            btn_crud_libro_diario_cuenta_agregar.setText("Actualizar");
            t_crud_libro_diario_numero.setEditable(false);

            CuentaListModel listModel = new CuentaListModel();
            CuentaDB dbc = new CuentaDB();
            listModel.setCuentas(dbc.getCuentas());
            lista_cuentas.setModel(listModel);
            lista_cuentas.repaint();

            LibroDiarioTM ldtm = new LibroDiarioTM();
            tabla_crud_libro_diario_partida.setModel(ldtm);
            tabla_crud_libro_diario_partida.setColumnModel(ldtm.getColumnModel());

            //LLENAR LOS CAMPOS CON LOS DATOS
            LibroDiarioTM table_model = (LibroDiarioTM) tabla.getModel();
            int index_tran = tabla.getSelectedRow();
            Transaccion tran = table_model.getLibro_diario().get(index_tran);
            TransaccionDB tdb = new TransaccionDB();
            List<Transaccion> lista_transacciones = tdb.getPartida(tran.getPartida().getId_partida());
            ldtm.setLibro_diario(lista_transacciones);

            actualizar_partida = true;

        } else {
            msg_tabla_operacion.setVisible(true);
            msg_tabla_operacion.setText(" ** Seleccionar una partida de la tabla ** ");
        }
    }//GEN-LAST:event_btn_modificar_partidaActionPerformed

    private void btn_dlg_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dlg_aceptarActionPerformed

        start_date = new Date(btn_dlg_fecha_inicio.getDate().getTime());
        end_date = new Date(btn_dlg_fecha_fin.getDate().getTime());

        if (MAYORIZACION) {
            dlg_periodo.dispose();
            MayorDB mdb = new MayorDB();
            mdb.mayorizarCuentas(start_date, end_date);
        } else {
            //int index = btn_estados_financieros.getSelectedIndex();
            int index = opcion;
     
            switch (index) {
                case BALANCE_COMPROBACION:
                dlg_periodo.dispose();
                BCReport bc_report = new BCReport();
                bc_report.setPeriodo(start_date, end_date);
                bc_report.generarReporte();
                break;
                case ESTADO_RESULTADO:
                dlg_periodo.dispose();
                ERReport estado_res = new ERReport();
                estado_res.setPeriodo(start_date, end_date);
                estado_res.generarReporte();
                break;
                case ESTADO_CAPITAL:
                dlg_periodo.dispose();
                ECReport estado_capital = new ECReport();
                estado_capital.setPeriodo(start_date, end_date);
                estado_capital.generarReporte();
                break;
                case BALANCE_GENERAL:
                dlg_periodo.dispose();
                BGReport bg = new BGReport();
                bg.setPeriodo(start_date, end_date);
                bg.generarReporte();
                break;
                default:
                break;
            }
        }
    }//GEN-LAST:event_btn_dlg_aceptarActionPerformed

    private void btn_dlg_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dlg_cancelarActionPerformed
        btn_dlg_fecha_inicio.setDate(null);
        btn_dlg_fecha_fin.setDate(null);
        dlg_periodo.dispose();
    }//GEN-LAST:event_btn_dlg_cancelarActionPerformed

    private void btn_mayorizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mayorizarActionPerformed
        // TODO add your handling code here:
        MAYORIZACION = true;
        btn_dlg_fecha_inicio.setDate(null);
        btn_dlg_fecha_fin.setDate(null);
        dlg_periodo.setVisible(true);
    }//GEN-LAST:event_btn_mayorizarActionPerformed

    private void menu_Balance_ComproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_Balance_ComproActionPerformed
        // TODO add your handling code here:
        opcion = BALANCE_COMPROBACION;
        dlg_periodo.setVisible(true);
        dlg_periodo.setLocationRelativeTo(this);
    }//GEN-LAST:event_menu_Balance_ComproActionPerformed

    private void menu_Estado_ResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_Estado_ResActionPerformed
       
        opcion = ESTADO_RESULTADO;
        dlg_periodo.setVisible(true);
        dlg_periodo.setLocationRelativeTo(this);
    }//GEN-LAST:event_menu_Estado_ResActionPerformed

    private void menu_Estado_CapiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_Estado_CapiActionPerformed
        
        opcion = ESTADO_CAPITAL ;
        dlg_periodo.setVisible(true);
        dlg_periodo.setLocationRelativeTo(this);
    }//GEN-LAST:event_menu_Estado_CapiActionPerformed

    private void menu_Balance_GeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_Balance_GeneActionPerformed
        
        opcion = BALANCE_GENERAL;
        dlg_periodo.setVisible(true);
        dlg_periodo.setLocationRelativeTo(this);
    }//GEN-LAST:event_menu_Balance_GeneActionPerformed

    private void btn_CuentaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CuentaBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_CuentaBuscarActionPerformed

    private void btn_CuentaBuscar_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CuentaBuscar_CancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_CuentaBuscar_CancelarActionPerformed

    private void btn_Opc_BuscarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Opc_BuscarCuentaActionPerformed
        dlg_Buscar_Cuenta.setVisible(true);
        dlg_Buscar_Cuenta.setSize(355,310);
        dlg_Buscar_Cuenta.setLocationRelativeTo(this);
        Conte_BuscarCuenta.setVisible(true);
        panel_BuscarCuenta.setVisible(true);
        
    }//GEN-LAST:event_btn_Opc_BuscarCuentaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AdmCatalogo;
    private javax.swing.JMenuItem Adm_Libro;
    private javax.swing.JPanel ContePanel_Cuenta;
    private javax.swing.JPanel ContePanel_Opciones;
    private javax.swing.JPanel Conte_BuscarCuenta;
    private javax.swing.JButton btn_CuentaBuscar;
    private javax.swing.JButton btn_CuentaBuscar_Cancelar;
    private javax.swing.JButton btn_Opc_BuscarCuenta;
    private javax.swing.JButton btn_agregar_cuenta;
    private javax.swing.JButton btn_catalogo;
    private javax.swing.JButton btn_crud_catalogo_salir;
    private javax.swing.JButton btn_crud_libro_diario_cancelar_partida;
    private javax.swing.JButton btn_crud_libro_diario_cuenta_agregar;
    private javax.swing.JButton btn_crud_libro_diario_cuenta_reset;
    private javax.swing.JButton btn_crud_libro_diario_guardar_partida;
    private javax.swing.JButton btn_crud_libro_diario_salir;
    private javax.swing.JButton btn_cuenta_cancelar;
    private javax.swing.JButton btn_cuenta_guardar;
    private javax.swing.JButton btn_cuenta_modificar;
    private javax.swing.JButton btn_cuenta_nueva;
    private javax.swing.JButton btn_dlg_aceptar;
    private javax.swing.JButton btn_dlg_cancelar;
    private com.toedter.calendar.JDateChooser btn_dlg_fecha_fin;
    private com.toedter.calendar.JDateChooser btn_dlg_fecha_inicio;
    private javax.swing.JRadioButton btn_iva_credito;
    private javax.swing.JRadioButton btn_iva_debito;
    private javax.swing.JRadioButton btn_iva_exento;
    private javax.swing.JButton btn_libro_diario;
    private javax.swing.JButton btn_mayorizar;
    private javax.swing.JButton btn_modificar_partida;
    private javax.swing.JButton btn_nueva_partida;
    private javax.swing.JDialog crud_catalogo_cuentas;
    private javax.swing.JDialog crud_libro_diario;
    private javax.swing.JDialog dlg_Buscar_Cuenta;
    private javax.swing.JDialog dlg_periodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_periodo;
    private javax.swing.JComboBox list_TipoCuenta_Buscar;
    private javax.swing.JList lista_cuentas;
    private javax.swing.JMenuItem menu_Balance_Compro;
    private javax.swing.JMenuItem menu_Balance_Gene;
    private javax.swing.JMenuItem menu_Estado_Capi;
    private javax.swing.JMenuItem menu_Estado_Res;
    private javax.swing.JLabel msg_crud_libro_diario_cuenta;
    private javax.swing.JLabel msg_crud_libro_diario_partida_operacion;
    private javax.swing.JLabel msg_cuenta_operacion;
    private javax.swing.JLabel msg_tabla_operacion;
    private javax.swing.JPanel panel_BuscarCuenta;
    private javax.swing.JPanel panel_OpcionesCuenta;
    private javax.swing.JPanel panel_crud_catalogo;
    private javax.swing.JPanel panel_crud_libro_diario;
    private javax.swing.JPanel panel_cuenta_crud;
    private javax.swing.JScrollPane scroll_tabla;
    private javax.swing.JScrollPane scroll_tabla_crud_catalogo_cuentas;
    private javax.swing.JScrollPane scroll_tabla_crud_libro_diario_partida;
    private javax.swing.JFormattedTextField t_crud_libro_diario_debe;
    private com.toedter.calendar.JDateChooser t_crud_libro_diario_fecha;
    private javax.swing.JFormattedTextField t_crud_libro_diario_haber;
    private javax.swing.JFormattedTextField t_crud_libro_diario_numero;
    private javax.swing.JTextField t_id_cuenta;
    private javax.swing.JTextArea t_nombre_cuenta;
    private javax.swing.JComboBox t_tipo_cuenta;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla_crud_catalogo_cuentas;
    private javax.swing.JTable tabla_crud_libro_diario_partida;
    private javax.swing.JTextField tex_Nombre_CuentaB;
    // End of variables declaration//GEN-END:variables
}

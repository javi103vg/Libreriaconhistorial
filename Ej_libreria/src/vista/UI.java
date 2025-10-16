package vista;

import java.awt.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.Libreria;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UI extends JFrame {

    private static final long serialVersionUID = 1L;
    protected JPanel contentPane;
    protected JLabel lblNewLabel;
    protected JButton btnNewButton;
    protected JButton btnNewButton_1;
    protected JButton btnConsultar;
    protected JButton btnBorrar;
    protected JLabel lblNewLabel_1;
    protected JLabel lblNewLabel_2;
    protected JLabel lblNewLabel_3;
    protected JLabel lblNewLabel_4;
    protected JLabel lblNewLabel_5;
    protected JTextField textField;
    protected JTextField textField_1;
    protected JTextField textField_2;
    protected JTextField textField_3;
    protected JTextField textField_4;
    protected JScrollPane scrollPane;
    protected JTable tablaLibros;
    protected JRadioButton rdbtnreedicion;
    protected JRadioButton rdbtnnovedad;
    protected JRadioButton rdbtnCartone;
    protected JRadioButton rdbtnrustica;
    protected JRadioButton rdbtngrapada;
    protected JRadioButton rdbtnespiral;
    protected JLabel lblNewLabel_6;
    protected JLabel lblNewLabel_7;
    protected JPanel panelstock;
    protected JLabel lblNewLabel_8;
    protected JSpinner spinner;
    protected JLabel lblNewLabel_9;
    protected JButton btnvender;
    protected JButton btncomprar;
    protected JButton btnHistorialVentas;
    protected JPanel Mercado;
    protected JScrollPane scrollPane_1;
    protected JTable historialventya;
    protected JButton btnmod;


    public UI() {

        // Grupos de radio buttons
        ButtonGroup grupoEstado = new ButtonGroup();

        ButtonGroup grupoFormato = new ButtonGroup();

        // Frame básico
        setAlwaysOnTop(true);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 466, 314);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        // Panel norte
        JPanel PanelNorte = new JPanel();
        PanelNorte.setBackground(new Color(128, 128, 255));
        lblNewLabel = new JLabel("LIBRERIA DE JAVIER");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        PanelNorte.add(lblNewLabel);

        // Panel sur con botones
        JPanel PanelSur = new JPanel();
        PanelSur.setBackground(new Color(64, 128, 128));
        btnNewButton = new JButton("GUARDAR");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton_1 = new JButton("SALIR");
        btnNewButton_1.setForeground(new Color(255, 128, 128));
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnConsultar = new JButton("CONSULTAR");
        btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBorrar = new JButton("BORRAR");
        btnBorrar.setForeground(new Color(255, 128, 128));
        btnBorrar.setBackground(new Color(255, 255, 255));
        btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 16));

        PanelSur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        PanelSur.add(btnNewButton);
        PanelSur.add(btnNewButton_1);
        PanelSur.add(btnConsultar);
        PanelSur.add(btnBorrar);


        // Pestañas
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        // Inicializar radio buttons de ESTADO
        rdbtnreedicion = new JRadioButton("Reedición");
        rdbtnnovedad = new JRadioButton("Novedad");
        rdbtnreedicion.setBackground(new Color(193, 198, 166));
        rdbtnnovedad.setBackground(new Color(193, 198, 166));
        
                // Inicializar radio buttons de FORMATO
                rdbtnCartone = new JRadioButton("Cartoné");
                rdbtnrustica = new JRadioButton("Rústica");
                rdbtngrapada = new JRadioButton("Grapada");
                rdbtnespiral = new JRadioButton("Espiral");
                rdbtnespiral.setSelected(true);
                rdbtnCartone.setBackground(new Color(193, 198, 166));
                rdbtnrustica.setBackground(new Color(193, 198, 166));
                rdbtngrapada.setBackground(new Color(193, 198, 166));
                rdbtnespiral.setBackground(new Color(193, 198, 166));
                grupoEstado.add(rdbtnreedicion);
                grupoEstado.add(rdbtnnovedad);
                grupoFormato.add(rdbtnCartone);
                grupoFormato.add(rdbtnespiral);
                grupoFormato.add(rdbtngrapada);
                grupoFormato.add(rdbtnrustica);
                
                        // Panel Libro
                        JPanel panelLibro = new JPanel();
                        panelLibro.setBackground(new Color(193, 189, 166));
                        tabbedPane.addTab("Libro", null, panelLibro, null);
                        
                                lblNewLabel_1 = new JLabel("ISBN:");
                                lblNewLabel_2 = new JLabel("TITULO:");
                                lblNewLabel_3 = new JLabel("AUTOR:");
                                lblNewLabel_4 = new JLabel("EDITORIAL:");
                                lblNewLabel_5 = new JLabel("PRECIO:");
                                lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
                                lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
                                lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
                                lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
                                lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
                                
                                        textField = new JTextField(10);
                                        textField_1 = new JTextField(10);
                                        textField_2 = new JTextField(10);
                                        textField_3 = new JTextField(10);
                                        textField_4 = new JTextField(10);
                                        
                                                JPanel panelformato = new JPanel();
                                                panelformato.setBackground(new Color(193, 189, 166));
                                                panelformato.setBorder(new LineBorder(Color.BLACK));
                                                
                                                lblNewLabel_6 = new JLabel("FORMATO:");
                                                lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
                                                panelformato.add(lblNewLabel_6);
                                                panelformato.add(rdbtnCartone);
                                                panelformato.add(rdbtnrustica);
                                                panelformato.add(rdbtngrapada);
                                                panelformato.add(rdbtnespiral);
                                                
                                                        JPanel panelformato_1 = new JPanel();
                                                        panelformato_1.setBackground(new Color(193, 189, 166));
                                                        panelformato_1.setBorder(new LineBorder(Color.BLACK));
                                                        
                                                        lblNewLabel_7 = new JLabel("ESTADO:");
                                                        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
                                                        panelformato_1.add(lblNewLabel_7);
                                                        panelformato_1.add(rdbtnreedicion);
                                                        panelformato_1.add(rdbtnnovedad);
                                                                JPanel datosPanel = new JPanel(new GridLayout(5, 2));
                                                                datosPanel.add(lblNewLabel_1);
                                                                datosPanel.add(textField);
                                                                datosPanel.add(lblNewLabel_2);
                                                                datosPanel.add(textField_1);
                                                                datosPanel.add(lblNewLabel_3);
                                                                datosPanel.add(textField_2);
                                                                datosPanel.add(lblNewLabel_4);
                                                                datosPanel.add(textField_3);
                                                                datosPanel.add(lblNewLabel_5);
                                                                datosPanel.add(textField_4);
                                                                textField.setText("");
                                                                textField_1.setText("");
                                                                textField_2.setText("");
                                                                textField_3.setText("");
                                                                textField_4.setText("");
                                                                rdbtnreedicion.setSelected(false);
                                                                rdbtnnovedad.setSelected(false);
                                                                rdbtnCartone.setSelected(false);
                                                                rdbtnrustica.setSelected(false);
                                                                rdbtngrapada.setSelected(false);
                                                                rdbtnespiral.setSelected(true);
                                                                
                                                                
                                                                panelstock = new JPanel();
                                                                panelstock.setBorder(new LineBorder(new Color(0, 0, 0)));
                                                                panelstock.setBackground(new Color(193, 189, 166));
                                                                
                                                                lblNewLabel_8 = new JLabel("STOCK:");
                                                                lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
                                                                
                                                                spinner = new JSpinner();
                                                                
                                                             // Crear el JLabel para la imagen
                                                                lblNewLabel_9 = new JLabel();
                                                                lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
                                                                lblNewLabel_9.setVerticalAlignment(SwingConstants.CENTER);

                                                                // Cargar y escalar la imagen
                                                                ImageIcon icon = new ImageIcon("C:\\Users\\harnina\\eclipse-workspaceinterface\\Ej_libreria\\src\\libreriajavier.jpg");
                                                                Image img = icon.getImage().getScaledInstance(238, 144, Image.SCALE_SMOOTH);
                                                                lblNewLabel_9.setIcon(new ImageIcon(img));

                                                                // Configurar el GroupLayout
                                                                GroupLayout gl_panelLibro = new GroupLayout(panelLibro);
                                                                gl_panelLibro.setHorizontalGroup(
                                                                	gl_panelLibro.createParallelGroup(Alignment.LEADING)
                                                                		.addGroup(gl_panelLibro.createSequentialGroup()
                                                                			.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
                                                                				.addGroup(gl_panelLibro.createSequentialGroup()
                                                                					.addGap(233)
                                                                					.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
                                                                				.addGroup(gl_panelLibro.createSequentialGroup()
                                                                					.addComponent(datosPanel, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
                                                                					.addPreferredGap(ComponentPlacement.RELATED)
                                                                					.addComponent(panelformato, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                                                                				.addGroup(gl_panelLibro.createSequentialGroup()
                                                                					.addComponent(panelformato_1, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
                                                                					.addPreferredGap(ComponentPlacement.RELATED)
                                                                					.addComponent(panelstock, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)))
                                                                			.addContainerGap())
                                                                );
                                                                gl_panelLibro.setVerticalGroup(
                                                                	gl_panelLibro.createParallelGroup(Alignment.LEADING)
                                                                		.addGroup(gl_panelLibro.createSequentialGroup()
                                                                			.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
                                                                				.addComponent(datosPanel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                                                				.addComponent(panelformato, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
                                                                			.addPreferredGap(ComponentPlacement.RELATED)
                                                                			.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
                                                                				.addComponent(panelformato_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                                                				.addComponent(panelstock, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
                                                                			.addPreferredGap(ComponentPlacement.UNRELATED)
                                                                			.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                                			.addContainerGap())
                                                                );
                                                                GroupLayout gl_panelstock = new GroupLayout(panelstock);
                                                                gl_panelstock.setHorizontalGroup(
                                                                	gl_panelstock.createParallelGroup(Alignment.LEADING)
                                                                		.addGroup(gl_panelstock.createSequentialGroup()
                                                                			.addGap(128)
                                                                			.addComponent(lblNewLabel_8)
                                                                			.addGap(5)
                                                                			.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                                			.addGap(48))
                                                                );
                                                                gl_panelstock.setVerticalGroup(
                                                                	gl_panelstock.createParallelGroup(Alignment.LEADING)
                                                                		.addGroup(gl_panelstock.createSequentialGroup()
                                                                			.addGap(5)
                                                                			.addGroup(gl_panelstock.createParallelGroup(Alignment.LEADING)
                                                                				.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                				.addComponent(lblNewLabel_8))
                                                                			.addGap(107))
                                                                );
                                                                panelstock.setLayout(gl_panelstock);

                                                                // Aplicar el layout al panel
                                                                panelLibro.setLayout(gl_panelLibro);

        JPanel Libreria = new JPanel();
        tabbedPane.addTab("Libreria", null, Libreria, null);
        scrollPane = new JScrollPane();
        tablaLibros = new JTable();
        tablaLibros.setBackground(new Color(185, 198, 187));
        scrollPane.setViewportView(tablaLibros);
        Libreria.setLayout(new BorderLayout());
        Libreria.add(scrollPane, BorderLayout.CENTER);

        // Añadir paneles al contentPane
        contentPane.setLayout(new BorderLayout());
        contentPane.add(PanelNorte, BorderLayout.NORTH);
        contentPane.add(tabbedPane, BorderLayout.CENTER);
        
        Mercado = new JPanel();
        Mercado.setToolTipText("");
        tabbedPane.addTab("Mercado", null, Mercado, null);
        btnHistorialVentas = new JButton("HISTORIAL");
        btnHistorialVentas.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnHistorialVentas.setBackground(Color.WHITE);
        btnHistorialVentas.setForeground(new Color(0, 102, 204));
        
        btnvender = new JButton("$VENDER$");
        btnvender.setForeground(new Color(0, 128, 0));
        btnvender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnvender.setBackground(Color.WHITE);
        
        scrollPane_1 = new JScrollPane();
        
        btncomprar = new JButton("$COMPRAR$");
        btncomprar.setForeground(new Color(255, 0, 0));
        btncomprar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btncomprar.setBackground(Color.WHITE);
        GroupLayout gl_mercado = new GroupLayout(Mercado);
        gl_mercado.setHorizontalGroup(
        	gl_mercado.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_mercado.createSequentialGroup()
        			.addGroup(gl_mercado.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_mercado.createSequentialGroup()
        					.addGap(233)
        					.addComponent(btnHistorialVentas)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnvender)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btncomprar))
        				.addGroup(gl_mercado.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        contentPane.revalidate();
        contentPane.repaint();
        gl_mercado.setVerticalGroup(
        	gl_mercado.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_mercado.createSequentialGroup()
        			.addGap(5)
        			.addGroup(gl_mercado.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnHistorialVentas)
        				.addComponent(btnvender)
        				.addComponent(btncomprar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(17)
        			.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        			.addContainerGap())
        );
        contentPane.revalidate();
        contentPane.repaint();
        
        historialventya = new JTable();
        scrollPane_1.setViewportView(historialventya);
        Mercado.setLayout(gl_mercado);
        contentPane.add(PanelSur, BorderLayout.SOUTH);
        
        btnmod = new JButton("MODIFCAR");
        btnmod.setForeground(new Color(0, 0, 255));
        btnmod.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnmod.setBackground(Color.WHITE);
        PanelSur.add(btnmod);
        
     // --- Validación visual del ISBN ---
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarISBN();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarISBN();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarISBN();
            }
        });

        // Acciones de botones
        btnNewButton_1.addActionListener(e -> System.exit(0));
        btnNewButton.addActionListener(e -> {
        });
        
    }
    private void validarISBN() {
        String isbn = textField.getText(); // tu campo ISBN

        if (Libreria.validarISBNlibreria(isbn)) {
            textField.setBackground(new Color(200, 255, 200)); // Verde claro
        } else {
            textField.setBackground(new Color(255, 200, 200)); // Rojo claro
        }
    }
}

package proyecto2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class ABC_Limpio extends JFrame implements ActionListener {
	
	
    private Connection con;
    public JButton btnAgregar, btnModificar, btnBorrar, btnConsultar, btnRegresar;
    public JTextField txtClave, txtNombre;

    public String tabla() {
    	return "paises";
    }
    
    public String campo1() {
    	return "clave";
    }
    
    public String campo2() {
    	return "nombre";
    }
    
    public ABC_Limpio() {
        inicializarFormulario();
        conectarBaseDatos();
        crearComponentes();
        agregarListeners();
        configurarInterfaz();
    }
    
    protected void inicializarFormulario() {
        setTitle("BASE ABC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
    }
    
    protected void conectarBaseDatos() {
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String password = "degea200";
        String url = "jdbc:mysql://localhost:3306/abcjava";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, password);
            JOptionPane.showMessageDialog(null, "La conexión se llevó a cabo con éxito.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos: " + e.toString());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class Not Found Exception: " + e.toString());
        }
    }
    
    protected void crearComponentes() {

        txtClave = new JTextField();
        txtNombre = new JTextField();

        btnAgregar = new JButton("Agregar");
        btnModificar = new JButton("Modificar");
        btnBorrar = new JButton("Borrar");
        btnConsultar = new JButton("Consultar");
        btnRegresar = new JButton("Regresar");
    }
    
    protected void agregarListeners() {
        btnAgregar.addActionListener(this);
        btnModificar.addActionListener(this);
        btnBorrar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnRegresar.addActionListener(this);
    }
    
    protected void configurarInterfaz() {
        JPanel panelSuperior = new JPanel(new GridLayout(2, 2));
        panelSuperior.add(new JLabel("Clave"));
        panelSuperior.add(txtClave);
        panelSuperior.add(new JLabel("Nombre"));
        panelSuperior.add(txtNombre);

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnBorrar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnRegresar);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panelSuperior, BorderLayout.NORTH);
        container.add(panelBotones, BorderLayout.SOUTH);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            insertarRegistro();
        } else if (e.getSource() == btnModificar) {
            modificarRegistro();
        } else if (e.getSource() == btnBorrar) {
            borrarRegistro();
        } else if (e.getSource() == btnConsultar) {
            consultarRegistro();
        } else if (e.getSource() == btnRegresar) {
        	regresarOpciones();
        }
    }

    protected void insertarRegistro() {
        try {
        	//para limpiar los campos luego de la insercion
        	String c = ""; 
            String strSQL = "INSERT INTO " + tabla() + " (" + campo1() +", " + campo2() + ") VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(strSQL);
            stmt.setString(1, txtClave.getText());
            stmt.setString(2, txtNombre.getText());
            int rowsAffected = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, rowsAffected + " filas afectadas.");
        	txtClave.setText(c);
			txtNombre.setText(c);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos: " + ex.toString());
        }
    }

    protected void modificarRegistro() {
        try {
        	//para limpiar los campos luego de la modificacion
        	String c = "";
            String strSQL = "UPDATE "+ tabla() + " SET " + campo2() + " = ? WHERE  "+ campo1() +"  = ?";
            PreparedStatement stmt = con.prepareStatement(strSQL);
            stmt.setString(1, txtNombre.getText());
            stmt.setString(2, txtClave.getText());
            int rowsAffected = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, rowsAffected + " filas afectadas.");
        	txtClave.setText(c);
			txtNombre.setText(c);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos: " + ex.toString());
        }
    }

    protected void borrarRegistro() {
        try {
        	//para limpiar los campos del las partes de texro clave y nombre luego de la modificacion
        	String c = "";
            String strSQL = "DELETE FROM " + tabla() + " WHERE "+ campo1() +" = ?";
            PreparedStatement stmt = con.prepareStatement(strSQL);
            stmt.setString(1, txtClave.getText());
            int rowsAffected = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, rowsAffected + " filas afectadas.");
        	txtClave.setText(c);
			txtNombre.setText(c);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos: " + ex.toString());
        }
    }

    protected void consultarRegistro() {
        try {
            String strSQL = "SELECT * FROM " + tabla() + " WHERE "+ campo1() +" = ?";
            PreparedStatement stmt = con.prepareStatement(strSQL);
            stmt.setString(1, txtClave.getText());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                txtNombre.setText(rs.getString(campo2()));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún registro con la clave proporcionada.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos: " + ex.toString());
        }
    }
    
    protected void regresarOpciones() {
    	//"objeto".setVisible(false);
    	//opciones.setVisible(true);
    }

}

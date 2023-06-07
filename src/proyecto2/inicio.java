package proyecto2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class inicio extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtConstraseña;
	
	String[][] usuario = {{"pepe123", "contra"},{"juan123", "password"}};
	int valido;
	private JButton btnIniciarSesion;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio frame = new inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public inicio() {
		setTitle("inicio de sesion ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 224, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(82, 59, 96, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtConstraseña = new JTextField();
		txtConstraseña.setBounds(82, 113, 96, 19);
		contentPane.add(txtConstraseña);
		txtConstraseña.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 62, 58, 13);
		contentPane.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("contraseña:");
		lblContraseña.setBounds(10, 114, 74, 16);
		contentPane.add(lblContraseña);
		
		btnIniciarSesion = new JButton("iniciar sesion");
		btnIniciarSesion.setBounds(63, 170, 115, 21);
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				String c = ""; 
				String a = txtUsuario.getText();
				String b = txtConstraseña.getText();
				if(comprobarUsuarioContraseña( a , b )) {
					JOptionPane.showMessageDialog(null, "usuario valido");
					inicio.this.dispose();
			    	ABC_opciones Frame = new ABC_opciones();
			        Frame.setSize(480,220);
			        Frame.setVisible(true); // Mostrar la ventana de color (tabla_color)
				}
				else {
					JOptionPane.showMessageDialog(null, "usuario invalido");
					// esto es para limpiar los cuadros de dialogo despues de comprobar el usuario
					 txtUsuario.setText(c);
					 txtConstraseña.setText(c);
				}
			}
		});
		contentPane.add(btnIniciarSesion);
	}
	
	public boolean comprobarUsuarioContraseña(String a, String b) {
		     if(a.equals(usuario[0][0])) {
		    	 if( b.equals(usuario[0][1])){
		    		 return true;
		    	 }
		    	 else {
		    		 return false;
		    	 }
		     }
		     else if(a.equals(usuario[1][0])){
		    	 if (b.equals(usuario[1][1])) {
		    		 return true;
		    	 }
		    	 else {
		    		 return false;
		    	 }
		     }
		     else {
		    	 return false;
		     }
		
	}
}

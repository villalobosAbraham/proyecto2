package proyecto2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tabla_sabores extends ABC_Limpio {

	@Override //se cambia la tabla de origen
	public String tabla() {
    	return "sabores";
    }
	@Override //se cambia el primer campo
	public String campo1() {
		return "id";
	}
	@Override //se cambia el segundo campo
	public String campo2() {
	   	return "sabor";
    }
	
	@Override //modificamos el titulo del formulario del formulario
	protected void inicializarFormulario() {
        setTitle("TABLA SABORES");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
	}
	
	@Override //modificiaremos el label ingresado en el panel Superior, cambiamos los valores del primero y del segundo
	 protected void configurarInterfaz() {
	        JPanel panelSuperior = new JPanel(new GridLayout(2, 2));
	        panelSuperior.add(new JLabel("id"));
	        panelSuperior.add(txtClave);
	        panelSuperior.add(new JLabel("sabor"));
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
	protected void regresarOpciones() {
    	tabla_sabores.this.dispose();
    	ABC_opciones Frame = new ABC_opciones();
        Frame.setSize(480,220);
        Frame.setVisible(true); // Mostrar la ventana de color (tabla_color)
    }
	
	//por pruebas, luego se borra
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabla_sabores frame = new tabla_sabores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

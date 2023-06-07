package proyecto2;

import javax.swing.*;
import java.awt.*;

//herencia de la tabla base proporcionada por el profesor
public class tabla_color extends ABC_Limpio {
	
	@Override //se cambia la tabla de origen
	public String tabla() {
    	return "color";
    }
	@Override //se cambia el primer campo
	public String campo1() {
		return "id";
	}
	@Override //se cambia el segundo campo
	public String campo2() {
	   	return "color";
    }
	
	@Override //modificamos el titulo del formulario del formulario
	protected void inicializarFormulario() {
        setTitle("TABLA COLOR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
	}
	
	@Override //modificiaremos el label ingresado en el panel Superior, cambiamos los valores del primero y del segundo
	 protected void configurarInterfaz() {
	        JPanel panelSuperior = new JPanel(new GridLayout(2, 2));
	        panelSuperior.add(new JLabel("id"));
	        panelSuperior.add(txtClave);
	        panelSuperior.add(new JLabel("color"));
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
	
	@Override // marcamos la ruta de regreso
    protected void regresarOpciones() {
    	tabla_color.this.dispose();
    	ABC_opciones Frame = new ABC_opciones();
        Frame.setSize(480,220);
        Frame.setVisible(true); // Mostrar la ventana de color (tabla_color)
    }
	//solo para verse mientras se desarrolla, no se quedara
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabla_color frame = new tabla_color();
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.setSize(452,200);
			        frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

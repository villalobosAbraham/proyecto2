package proyecto2;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class tabla_paises extends ABC_Limpio {

	@Override //modificamos el titulo del formulario del formulario
	protected void inicializarFormulario() {
        setTitle("TABLA PAISES");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
	}
	
	protected void regresarOpciones() {
    	tabla_paises.this.dispose();
    	ABC_opciones Frame = new ABC_opciones();
        Frame.setSize(480,220);
        Frame.setVisible(true); // Mostrar la ventana de color (tabla_color)
    }
	//solo para verse mientras se desarrolla, no se quedara
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabla_paises frame = new tabla_paises();
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.setSize(400,200);
			        frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

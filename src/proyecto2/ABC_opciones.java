package proyecto2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ABC_opciones extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABC_opciones frame = new ABC_opciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ABC_opciones() {
		setTitle("MENU DE ABC´S");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("clickee la tabla que desea conectar ");
		lblNewLabel.setBounds(121, 10, 200, 62);
		contentPane.add(lblNewLabel);
		
		JButton btncolor = new JButton("color");
		btncolor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ABC_opciones.this.dispose(); // Cerrar la ventana actual (ABC_opciones)
		        tabla_color colorFrame = new tabla_color();
		        colorFrame.setSize(452,200);
		        colorFrame.setVisible(true); // Mostrar la ventana de color (tabla_color)
			}
		});
		btncolor.setBounds(10, 122, 66, 21);
		contentPane.add(btncolor);
		
		JButton btnestados = new JButton("estados");
		btnestados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		    	ABC_opciones.this.dispose();
		    	tabla_estados Frame = new tabla_estados();
		        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        Frame.setSize(452,200);
		        Frame.setVisible(true);
			}
		});
		btnestados.setBounds(76, 122, 91, 21);
		contentPane.add(btnestados);
		
		JButton btnhelados = new JButton("helados");
		btnhelados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		    	ABC_opciones.this.dispose();
		    	tabla_helados Frame = new tabla_helados();
		        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        Frame.setSize(452,200);
		        Frame.setVisible(true);
			}
		});
		btnhelados.setBounds(177, 122, 91, 21);
		contentPane.add(btnhelados);
		
		JButton btnpaises = new JButton("paises");
		btnpaises.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		    	ABC_opciones.this.dispose();
		    	tabla_paises Frame = new tabla_paises();
		        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        Frame.setSize(452,200);
		        Frame.setVisible(true);
			}
		});
		btnpaises.setBounds(278, 122, 74, 21);
		contentPane.add(btnpaises);
		
		JButton btnsabores = new JButton("sabores");
		btnsabores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		    	ABC_opciones.this.dispose();
		    	tabla_sabores Frame = new tabla_sabores();
		        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        Frame.setSize(452,200);
		        Frame.setVisible(true);
			}
		});
		btnsabores.setBounds(362, 122, 91, 21);
		contentPane.add(btnsabores);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		    	ABC_opciones.this.dispose();
		    	inicio Frame = new inicio();
		        Frame.setVisible(true);
			}
		});
		btnSalir.setBounds(362, 153, 85, 21);
		contentPane.add(btnSalir);
	}

}

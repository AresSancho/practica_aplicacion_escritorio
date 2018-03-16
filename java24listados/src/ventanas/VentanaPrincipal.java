package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import paneles.PanelListadoClientes;
import paneles.PanelRegistroCliente;


//23 si hay clase
//9 no hay clase


public class VentanaPrincipal extends JFrame implements ActionListener{

	//paneles de la ventana:
	private PanelRegistroCliente panelRegistroCliente = 
			new PanelRegistroCliente();
	private PanelListadoClientes panelListadoClientes = 
			new PanelListadoClientes();
	private JPanel panelVentana = null;
	
	//barra de menu:
	private JMenuBar barraDeMenu = new JMenuBar();
	private JMenu menuClientes = new JMenu("Clientes");
	private JMenu menuAyuda = new JMenu("Ayuda");
	
	public VentanaPrincipal() {
		
		//preparar la barra de menu:
		JMenuItem clientesInsertar = new JMenuItem("Insertar Cliente");
		JMenuItem clientesListar = new JMenuItem("Listar Clientes");
		menuClientes.add(clientesInsertar);
		menuClientes.add(clientesListar);
		barraDeMenu.add(menuClientes);
		barraDeMenu.add(menuAyuda);
		this.setJMenuBar(barraDeMenu);
		
		//voy a decir a las opciones de menu, quien las va a atender
		//cuando se las haga un click
		clientesInsertar.addActionListener(this);
		clientesListar.addActionListener(this);
		
		//preparacion de la ventana principal
		this.setSize(800, 600);
		this.setLocation(50,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//vamos a decir que cuando arranque esta ventana
		//se muestre el panel de registro cliente
		panelVentana = panelRegistroCliente;
		this.add(panelVentana);
		this.setVisible(true);
		
	}//end VentanaPrincipal

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		System.out.println("atiendo a: " + comando);
		if(e.getActionCommand().equals("Insertar Cliente")){
			setContentPane(panelRegistroCliente);
		}else if(e.getActionCommand().equals("Listar Clientes")){
			setContentPane(panelListadoClientes);
			panelListadoClientes.refrescarClientes();
		}
		SwingUtilities.updateComponentTreeUI(this);
	}

}//end class







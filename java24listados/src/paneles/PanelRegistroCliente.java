package paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelRegistroCliente extends JPanel 
implements ActionListener{

	JTextField campoNombre = new JTextField(15);
	JTextField campoDomicilio = new JTextField(15);
	JTextField campoPoblacion = new JTextField(15);
	JTextField campoCodigoPostal = new JTextField(15);
	JTextField campoTelefono = new JTextField(15);

	public PanelRegistroCliente() {
		// asi asigno un gestor de diseño que me permite
		// colocar las cosas en forma de filas y celdas
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		// primera fila:
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(new JLabel("INTRODUCE LOS DATOS DEL CLIENTE"), gbc);
		//vuelvo a decir que cada componente solo ocupe un elemento:
		gbc.gridwidth = 1;
		// segunda fila:
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("nombre: "),gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoNombre,gbc);
		//tercera fila:
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("domicilio"),gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoDomicilio,gbc);
		//cuarta fila:
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("poblacion: "),gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoPoblacion,gbc);
		//quinta fila:
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("codigo postal: "),gbc);
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoCodigoPostal,gbc);
		//sexta fila:
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("telefono: "),gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoTelefono,gbc);
		//septima fila:
		JButton botonRegistroCliente = 
				new JButton("REGISTRAR");
		botonRegistroCliente.addActionListener(this);
		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroCliente,gbc);
		
	}// end PanelRegistroClientge()

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed del PanelRegistroCliente");
		String nombre = campoNombre.getText();
		String domicilio = campoDomicilio.getText();
		String poblacion = campoPoblacion.getText();
		String codigoPostal = campoCodigoPostal.getText();
		String telefono = campoTelefono.getText();
		//ahora habria que validar estos datos
		//... TODO
		//una validados todos los datos registramos en base de datos:
		Cliente clienteAregistrar = 
				new Cliente(nombre, domicilio, poblacion, 
						codigoPostal, telefono);
		System.out.println("voy a registrar: " + clienteAregistrar.toString());
		//invoco a lo necesario de la capa de datos, para registrar el cliente
		//en base de datos
		ClientesDAOImpl clientesDAO = new ClientesDAOImpl();
		clientesDAO.registrarCliente(clienteAregistrar);
	}//end actionPerformed

}// end class










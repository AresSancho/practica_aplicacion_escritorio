package paneles;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import tableModels.TableModelClientes;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelListadoClientes extends JPanel{

	private ClientesDAO daoClientes = new ClientesDAOImpl();
	private Cliente[] clientes;
	
	public PanelListadoClientes() {
		this.add(new JLabel("soy el panel del listado de clientes"));
	}//end PanelListadoClientes()
	
	public void refrescarClientes(){
		this.clientes = daoClientes.obtenerClientes(); 
		JTable tabla = new JTable(new TableModelClientes(clientes));
		//en vez de agregar tabla agregrar la JScrollBar
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    tabla.setFillsViewportHeight(true);
	    JScrollPane scrollPane = new JScrollPane(tabla);		
		this.removeAll();//quito todo lo que tuviera antes dentro del panel
		this.add(scrollPane);		
	}//end refrescarClientes
	
}//end class










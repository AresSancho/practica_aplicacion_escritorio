package daos;

import modelo.Cliente;

//en entorno corporativo, lo mas normal del mundo es 
//definir las operaciones que se van a poder hacer sobre 
//base de datos en un interfaz

//en este caso, para el interfaz actual, cada metodo
//dira que se puede hacer en base de datos de cara a 
//clientes

public interface ClientesDAO {

	void registrarCliente(Cliente c);
	void borrarCliente(int id);
	Cliente[] obtenerClientes();
	//un array es un conjunto de datos del mismo tipo
	
}











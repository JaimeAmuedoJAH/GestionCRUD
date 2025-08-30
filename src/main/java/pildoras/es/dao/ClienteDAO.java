package pildoras.es.dao;

import java.util.List;

import pildoras.es.controlador.entity.Cliente;

public interface ClienteDAO {

	
	public List<Cliente> getClientes();
	
	public Cliente getClientes(int idCliente);

	public void insertarCliente(Cliente cliente);

	public void actualizarCliente(Cliente cliente);

	public void eliminarCliente(int idCliente);
	
	
}

package pildoras.es.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pildoras.es.controlador.entity.Cliente;
import pildoras.es.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	@Autowired //Inyeccion de dependencias
	private ClienteDAO clienteDAO;

	@RequestMapping("/lista")
	public String listaClientes(Model modelo) {
		
		//Obtener los clientes desde el DAO
		
		List<Cliente> clientes = clienteDAO.getClientes();
		
		//Agregar los clientes al modelo
		
		modelo.addAttribute("clientes", clientes);
		
		return "lista-clientes";
	}
	
	@RequestMapping("/muestraFormularioAgregar")
	public String muestraFormularioAgregar(Model modelo) {
		
		//Bind de datos de los clientes
		
		Cliente cliente = new Cliente();
		
		modelo.addAttribute("cliente", cliente);
		
		return "formularioCliente";
	}
	
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente cliente) {
		
		//Insertar ciente en BBDD
		clienteDAO.insertarCliente(cliente);
		
		return "redirect:/cliente/lista";
	}
	
	@RequestMapping("/actualizaRegistrosTabla")
	public String actualizaRegistrosTabla(@RequestParam("idCliente") int idCliente, Model modelo) {
		
		Cliente cliente = clienteDAO.getClientes(idCliente);
		
		modelo.addAttribute("cliente", cliente);
		
		
		return "actualizaClientes";
	}
	
	@PostMapping("/actualizarCliente")
	public String actualizarCliente(@ModelAttribute("cliente") Cliente cliente) {
		
		//Insertar ciente en BBDD
		clienteDAO.actualizarCliente(cliente);
		
		return "redirect:/cliente/lista";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarCliente(@RequestParam("id") int idCliente) {
		
		clienteDAO.eliminarCliente(idCliente);
		
	
		return "redirect:/cliente/lista";
	}
}

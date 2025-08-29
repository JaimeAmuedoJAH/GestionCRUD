package pildoras.es.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

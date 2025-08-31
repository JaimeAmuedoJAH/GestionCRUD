package es.pildoras.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.pildoras.aop.dao.ClienteDAO;
import es.pildoras.aop.dao.ClienteVIPDAO;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Leer la configuración de Spring
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		//Obtener el Bean del contenedor de Spring
		
		ClienteDAO cliente = contexto.getBean("clienteDAO", ClienteDAO.class);
		
		ClienteVIPDAO clienteVIP = contexto.getBean("clienteVIPDAO", ClienteVIPDAO.class);
		
		//Llamar al método
		
		Cliente miCliente = new Cliente();
		
		cliente.insertarCliente(miCliente);
		
		clienteVIP.insertarClienteVIP();
		
		//Cerrar el contexto
		
		cliente.setCodigoClienteNormal("4636457");
		
		cliente.setValoracionClienteNormal("posititva");
		
		String codigoCL = cliente.getCodigoClienteNormal();
		
		String valoraCL = cliente.getValoracionClienteNormal();
		
		contexto.close();
	}

}

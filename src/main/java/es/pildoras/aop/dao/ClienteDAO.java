package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

import es.pildoras.aop.Cliente;

@Component
public class ClienteDAO {
	
	private String valoracionClienteNormal;
	
	private String codigoClienteNormal;

	public String getValoracionClienteNormal() {
		System.out.println("getValoracionClienteNormal");
		return valoracionClienteNormal;
	}

	public void setValoracionClienteNormal(String valoracionClienteNormal) {
		System.out.println("setValoracionClienteNormal");
		this.valoracionClienteNormal = valoracionClienteNormal;
	}



	public String getCodigoClienteNormal() {
		System.out.println("getCodigoClienteNormal");
		return codigoClienteNormal;
	}



	public void setCodigoClienteNormal(String codigoClienteNormal) {
		System.out.println("setCodigoClienteNormal");
		this.codigoClienteNormal = codigoClienteNormal;
	}



	public void insertarCliente(Cliente cliente) {
		
		System.out.println("Cliente insertado correctamente");
		
	}
}

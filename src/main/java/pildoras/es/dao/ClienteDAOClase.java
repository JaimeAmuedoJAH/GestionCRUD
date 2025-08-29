package pildoras.es.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pildoras.es.controlador.entity.Cliente;

@Repository // Para que spring lo utitlice como Bean
public class ClienteDAOClase implements ClienteDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional //Anotacion para que nuestra sesion se encargue de los commits y rollbacks de forma automatica.
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		
		//Obtener la session
		
		Session miSession = sessionFactory.getCurrentSession();
		
		//Creamos la consulta (Query)
		
		Query<Cliente> miQuery = miSession.createQuery("FROM Cliente", Cliente.class);
		
		//Ejecutar la query y devolver resultados
		
		List<Cliente> clientes = miQuery.getResultList();
		
		return clientes;
	}
	

}

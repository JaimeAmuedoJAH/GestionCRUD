package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //Indicamos que es un aspecto
@Component
public class LoginConAspecto {
	
	/*Se declara esta anotación para crear un pointcut general y asi evitar repetir el before.
	 * De esta forma solo cambiamos la expresion en esta anotacion y no en todas las anotaciones de los distintos metodos
	 * facilitando la modularización y refactorizacion del codigo*/
	//@Pointcut("execution(public * insertarCliente(..))")
	
	//Esto actua en todo el package indicado
	@Pointcut("execution(* es.pildoras.aop.dao.*.*(..))")
	private void paraClientes() {}
	
	//Esto actua para los getters
	@Pointcut("execution(* es.pildoras.aop.dao.*.get*(..))")
	private void paraGetters() {}
	
	//Esto actua para los setters
	@Pointcut("execution(* es.pildoras.aop.dao.*.set*(..))")
	private void paraSetters() {}
		
	//Combinacion de pointcuts(actua sobre todo el paquete menos getters y setters)
	@Pointcut("paraClientes() && !(paraGetters() || paraSetters())")
	private void paqueteExceptoGetterSetter() {}
	

	//Diferentes formas de la anotacion before con pointCut expressions
	
	//@Before("execution(public void es.pildoras.aop.dao.ClienteVIPDAO.insertarCliente())") 
	/*Momento donde se tiene que ejecutar (before o after) y el metodo que se tiene
	que ejecutar*/
	//@Before("execution(public String insertarCliente())")
	//@Before("execution(public void insertarCliente*())")
	//@Before("execution(public * insertarCliente*())")//para todo tipo de metodos
	//@Before("execution(public void insertarCliente(es.pildoras.aop.Cliente, ..))") //Los dos puntos son para cualquier tipo de dato 
	//@Before("execution(public void insertarCliente(..))") //Cualquier numero de parametros y tipo de dato
	
	//@Before("paraClientes()") 
	//@Before("paraSetters()")
	@Before("paqueteExceptoGetterSetter()")
	public void antesInsertarCliente() {
		
		System.out.println("El usuario esta logeado");
		
		System.out.println("El perfil para insertar clientes es correcto");
	}
	//@Before("paraClientes()") 
	public void requisitosCliente() {
		
		System.out.println("El cliente cumple con los requisitos para ser insertado en la BBDD");
	}
	//@Before("paraClientes()") 
	public void requisitosTabla() {
		
		System.out.println("Hay menos de 3000 registros en la tabla. Puedes insertar el nuevo cliente");
	}
}

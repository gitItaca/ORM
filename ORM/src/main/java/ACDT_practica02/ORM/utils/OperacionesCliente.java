package ACDT_practica02.ORM.utils;

import java.math.BigDecimal;
import java.sql.Connection;

import ACDT_practica02.ORM.model.Cliente;


public class OperacionesCliente {
	
//CONSTRUCTOR
	public OperacionesCliente(Connection connection) {
	}
	
//METODOS
	public static Cliente crearCliente() throws Exception{
		System.out.println("Datos dobre el cliente nuevo:");
		System.out.println("Escriba el codigo del cliente.");
		int codigo_cliente = Leer.pedirEnteroValidar();
		System.out.println("Escriba el nombre del cliente.");
		String nombre_cliente = Leer.pedirCadena();
		System.out.println("Escriba el nombre del contacto.");
		String nombre_contacto = Leer.pedirCadena();
		System.out.println("Escriba el apellido del contacto.");
		String apellido_contacto = Leer.pedirCadena();
		System.out.println("Escriba el telefono.");
		String telefono = Leer.pedirCadena();
		System.out.println("Escriba el fax.");
		String fax = Leer.pedirCadena();
		System.out.println("Escriba la linea_direccion1.");
		String linea_direccion1 = Leer.pedirCadena();
		System.out.println("Escriba la linea_direccion2.");
		String linea_direccion2 = Leer.pedirCadena();
		System.out.println("Escriba la ciudad.");
		String ciudad = Leer.pedirCadena();
		System.out.println("Escriba la region.");
		String region = Leer.pedirCadena();
		System.out.println("Escriba el pais.");
		String pais = Leer.pedirCadena();
		System.out.println("Escriba el codigo_postal.");
		String codigo_postal = Leer.pedirCadena();
		System.out.println("Escriba el codigo del empleado representante de ventas.");
		int codigo_empleado_rep_ventas = Leer.pedirEnteroValidar();
		System.out.println("Escriba el limite_credito.");
		BigDecimal limite_credito = Leer.pedirBigDecimal();
		
		return new Cliente(codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto,
				 telefono, fax, linea_direccion1, linea_direccion2, ciudad,
				 region, pais, codigo_postal, codigo_empleado_rep_ventas, limite_credito);
	}
	
	public static Cliente crearClientePruebas(int codigo_cliente, String nombre_cliente, String nombre_contacto, String apellido_contacto,
			String telefono, String fax, String linea_direccion1, String linea_direccion2, String ciudad,
			String region, String pais, String codigo_postal, int codigo_empleado_rep_ventas, BigDecimal limite_credito) throws Exception{
		
		return new Cliente(codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto,
				 telefono, fax, linea_direccion1, linea_direccion2, ciudad,
				 region, pais, codigo_postal, codigo_empleado_rep_ventas, limite_credito);
	}
	

}

package ACDT_practica02.ORM.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ACDT_practica02.ORM.dao.ClienteDao;
import ACDT_practica02.ORM.dao.ProductoDao;
import ACDT_practica02.ORM.model.Cliente;
import ACDT_practica02.ORM.model.Producto;
import ACDT_practica02.ORM.utils.ConexionHibernate;
import ACDT_practica02.ORM.utils.Leer;
import ACDT_practica02.ORM.utils.OperacionesCliente;
import ACDT_practica02.ORM.utils.OperacionesProducto;

public class Programacion {

	public static void main(String[] args) {
		int opcion;
		ClienteDao cDao = new ClienteDao();
		ProductoDao pDao = new ProductoDao();
		
		do {
			opcion = menu();		
			try {
								
				switch (opcion) {
				case 1: cDao.save(OperacionesCliente.crearCliente());
					break;
				case 2: 
					System.out.println("Escriba el codigo del cliente.");
					String id = Leer.pedirCadena();
					System.out.println(cDao.get(id));
					break;
				case 3: 
					for(Cliente cliente : cDao.getAll()) {
						System.out.println(cliente.toString());
					}
					System.out.println();
					break;
				case 4: 
					System.out.println("Escriba el nombre a buscar.");
					String busqueda = Leer.pedirCadena();
					cDao.getByName(busqueda);
					break;
				case 5:
					Producto productoReemplazar = OperacionesProducto.crearProducto();
					if(productoReemplazar != null) {
						pDao.update(productoReemplazar);
					}
					break;
				case 6:
					List<Producto> productos = pDao.getAll();
					for(Producto pro: productos) {
						System.out.println(pro.toString());
					}
					System.out.println();
					break;
				case 0: System.out.println("Has salido.");
					ConexionHibernate.shutDown();
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {			
				e.printStackTrace();
			}	
		} while(opcion != 0);
	}

//METODOS
	public static int menu() {
		
			System.out.println("Elige una de las siguientes opciones, para salir pulse 0.");
			System.out.println("1- Añadir un cliente.");
			System.out.println("2- Mostrar un cliente.");
			System.out.println("3- Mostrar todos los clientes.");
			System.out.println("4- Buscar un cliente.");
			System.out.println("5- Editar un producto.");
			System.out.println("6- Mostrar todos los productos.");
			int opcion = Leer.pedirEnteroValidar();		
		
		return opcion;
	}

}

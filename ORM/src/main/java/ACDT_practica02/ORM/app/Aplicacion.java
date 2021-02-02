package ACDT_practica02.ORM.app;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

import com.mysql.cj.xdevapi.SessionFactory;

import ACDT_practica02.ORM.dao.ClienteDao;
//import ACDT_practica02.ORM.dao.PedidoDao;
import ACDT_practica02.ORM.dao.ProductoDao;
import ACDT_practica02.ORM.model.Cliente;
import ACDT_practica02.ORM.model.Producto;
import ACDT_practica02.ORM.utils.ConexionHibernate;
import ACDT_practica02.ORM.utils.OperacionesCliente;

public class Aplicacion {

	public static void main(String[] args) {
		ClienteDao cDao = new ClienteDao();
		ProductoDao prodDao = new ProductoDao();
//		PedidoDao pedDao = new PedidoDao();
		
		BigDecimal bd3 = new BigDecimal("3.00");	
		BigDecimal bd1 = new BigDecimal("1.00");
		
//		System.out.println(pedDao.get("1"));
//		System.out.println(cDao.getByName("Beragua"));
//		System.out.println(cDao.get("1"));
//		System.out.println(pDao.get("10101"));
//		for(Producto producto : pDao.getAll()) {
//			System.out.println(producto.toString());
//		}
		
		
		//cDao.delete(cDao.get(95));
//		for(Cliente cliente : cDao.getAll()) {
//			System.out.println(cliente.toString());
//		}
//		Cliente cliente = new Cliente(73, "Gusti", "Yors", "Samy", "000799976", "976767676", "Direccion1", "Direccion2", "Lisboa", "Per", "Portugal", "7700098", 13, bd);
//		Producto producto = new Producto("10101", "Buenafuente", "Frutales", "1,2", "Sonia", (short) 10, bd3, bd1);
//		prodDao.update(producto);
//		System.out.println(prodDao.get("10101"));
		
//		try {
//			cDao.save(cliente);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		cDao.get(71);
	}

}

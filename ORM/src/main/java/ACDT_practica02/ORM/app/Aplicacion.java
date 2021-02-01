package ACDT_practica02.ORM.app;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import com.mysql.cj.xdevapi.SessionFactory;

import ACDT_practica02.ORM.dao.ClienteDao;
import ACDT_practica02.ORM.dao.ProductoDao;
import ACDT_practica02.ORM.model.Cliente;
import ACDT_practica02.ORM.model.Producto;
import ACDT_practica02.ORM.utils.ConexionHibernate;
import ACDT_practica02.ORM.utils.OperacionesCliente;

public class Aplicacion {

	public static void main(String[] args) {
		ClienteDao cDao = new ClienteDao();
		ProductoDao pDao = new ProductoDao();
		BigDecimal bd = new BigDecimal("83798350570");	
		
//		System.out.println(cDao.get("1"));
		System.out.println(pDao.get("10101"));
		for(Producto producto : pDao.getAll()) {
			System.out.println(producto.toString());
		}
		
		
		//cDao.delete(cDao.get(95));
//		for(Cliente cliente : cDao.getAll()) {
//			System.out.println(cliente.toString());
//		}
//		Cliente cliente = new Cliente(73, "Gusti", "Yors", "Samy", "000799976", "976767676", "Direccion1", "Direccion2", "Lisboa", "Per", "Portugal", "7700098", 13, bd);
//
//		try {
//			cDao.save(cliente);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		cDao.get(71);
	}

}

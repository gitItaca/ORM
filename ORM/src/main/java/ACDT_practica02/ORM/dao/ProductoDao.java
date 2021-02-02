package ACDT_practica02.ORM.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ACDT_practica02.ORM.model.Cliente;
import ACDT_practica02.ORM.model.Producto;
import ACDT_practica02.ORM.utils.ConexionHibernate;
import ACDT_practica02.ORM.utils.Leer;

public class ProductoDao implements Dao<Producto>{
	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	private static SessionFactory sessionFactory = ConexionHibernate.setUp();
	
	public ProductoDao(){		
	}
	
	@Override
	public Producto get(String id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Producto producto = session.find(Producto.class, id);
		
		session.getTransaction().commit();
		session.close();
		
		return producto;
	}

	@Override
	public List<Producto> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Producto> productos = (List<Producto>) session.createQuery("FROM Producto ", Producto.class).getResultList();
		
		session.getTransaction().commit();
		session.close();
	
		return productos;
	}

	@Override
	public void save(Producto producto) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
	
		session.save(producto);
		
		session.getTransaction().commit();
		session.close();		
	}

	@Override
	public void update(Producto producto) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
				
		session.update(producto);
		
		//Hace lo mismo que la línea de arriba pero haciendo arriba la sentencia.
//		session.createQuery("UPDATE Producto SET nombre = :nombre_p, gama = :gama_p, dimensiones = :dimensiones_p,"
//				+ " proveedor = :proveedor_p, cantidad_en_stock = :cantidad_stock_p, precio_venta = :precio_venta_p, precio_proveedor = :precio_proveedor_p WHERE codigo_producto = :codigo_p")				
//				.setParameter("nombre_p", producto.getNombre())
//				.setParameter("gama_p", producto.getGama())
//				.setParameter("dimensiones_p", producto.getDimensiones())
//				.setParameter("proveedor_p", producto.getProveedor())
//				.setParameter("cantidad_stock_p", producto.getCantidad_en_stock())
//				.setParameter("precio_venta_p", producto.getPrecio_venta())
//				.setParameter("precio_proveedor_p", producto.getPrecio_proveedor())
//				.setParameter("codigo_p", id)
//				.executeUpdate();
//		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Producto producto) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.delete(producto);
		
		session.getTransaction().commit();
		session.close();
		
	}
}

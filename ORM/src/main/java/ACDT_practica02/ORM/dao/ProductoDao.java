package ACDT_practica02.ORM.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
		
		List<Producto> productos = (List<Producto>) session.createQuery("FROM producto ", Producto.class).getResultList();
		
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
//		System.out.println("Escriba el codigo del producto que quiera modificar.");
//		String codPro = Leer.pedirCadena();
//		try {
//			String sql = "UPDATE producto SET codigo_producto = ?, nombre = ?, gama = ?, dimensiones = ?,"
//					+ " proveedor = ?, descripcion = ?, cantidad_en_stock = ?, precio_venta = ?, precio_proveedor = ?"
//					+ "WHERE codigo_producto = ?";
//
//			PreparedStatement preparedStatement = connect.prepareStatement(sql);
//
//			preparedStatement.setString(1, producto.getCodigo_producto());
//			preparedStatement.setString(2, producto.getNombre());
//			preparedStatement.setString(3, producto.getGama());
//			preparedStatement.setString(4, producto.getDimensiones());
//			preparedStatement.setString(5, producto.getProveedor());
//			preparedStatement.setString(6, producto.getDescripcion());
//			preparedStatement.setInt(7, producto.getCantidad_en_stock());
//			preparedStatement.setDouble(8, producto.getPrecio_venta());
//			preparedStatement.setDouble(9, producto.getPrecio_proveedor());
//			preparedStatement.setString(10, codPro);
//			
//			preparedStatement.executeUpdate();
//			preparedStatement.close();
//
//		} catch (SQLException e) {
//			System.out.println("Problema en la conexion con el metodo update de productoDao.");
//			e.printStackTrace();
//		}		
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

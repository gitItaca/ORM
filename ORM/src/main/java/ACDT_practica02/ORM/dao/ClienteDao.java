package ACDT_practica02.ORM.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ACDT_practica02.ORM.model.Cliente;
import ACDT_practica02.ORM.utils.ConexionHibernate;
import ACDT_practica02.ORM.utils.Leer;

public class ClienteDao implements Dao<Cliente>{
	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static SessionFactory sessionFactory = ConexionHibernate.setUp();
	
	public ClienteDao() {		
	}

	@Override
	public Cliente get(String id) {		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int id_int = Integer.parseInt(id);
		Cliente cliente = session.find(Cliente.class, id_int);
		
		session.getTransaction().commit();
		session.close();
		
		return cliente;
//		List<Cliente> result = session.createQuery("from Cliente", Cliente.class).list();
		        
//		result.forEach(person -> {
//		    //do something with Person instance...   
//		});		        
//		session.getTransaction().commit();
//		session.close();
			
	}
	
	//CAMBIAR!!!!!!!!!!!!!!!!!!!!!
	public Cliente getByName(String nombre) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Cliente cliente = (Cliente)session.createQuery("FROM Cliente c WHERE c.nombre_cliente = :nombre OR c.nombre_contacto = :nombre OR c.apellido_contacto = :nombre")
				.setParameter("nombre", nombre)
				.uniqueResult();
    	        
		session.getTransaction().commit();
		session.close();
		System.out.println();
		return cliente;
	}

	@Override
	public List<Cliente> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Cliente> clientes = (List<Cliente>) session.createQuery("FROM Cliente c").getResultList();
		
		session.getTransaction().commit();
		session.close();
	
		return clientes;
	}

	@Override
	public void save(Cliente cliente) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
	
		session.save(cliente);
		
		session.getTransaction().commit();
		session.close();
	}
	//CAMBIAR!!!!!!!!!!!
	@Override 
	public void update(Cliente cliente) {
//		System.out.println("Escriba el codigo del cliente que quiera modificar.");
//		int codCli = Leer.pedirEnteroValidar();
//		try {
//			String sql = "UPDATE cliente SET codigo_cliente = ?, nombre_cliente = ?, nombre_contacto = ?, apellido_contacto = ?,"
//					+ " telefono = ?, fax = ?, linea_direccion1 = ?, linea_direccion2 = ?, ciudad = ?, region = ?, pais = ?,"
//					+ " codigo_postal = ?, codigo_empleado_rep_ventas = ?, limite_credito = ? "
//					+ "WHERE codigo_cliente = ?";
//
//			PreparedStatement preparedStatement = connect.prepareStatement(sql);
//
//			preparedStatement.setInt(1, cliente.getCodigo_cliente());
//			preparedStatement.setString(2, cliente.getNombre_cliente());
//			preparedStatement.setString(3, cliente.getNombre_contacto());
//			preparedStatement.setString(4, cliente.getApellido_contacto());
//			preparedStatement.setString(5, cliente.getTelefono());
//			preparedStatement.setString(6, cliente.getFax());
//			preparedStatement.setString(7, cliente.getLinea_direccion1());
//			preparedStatement.setString(8, cliente.getLinea_direccion2());
//			preparedStatement.setString(9, cliente.getCiudad());
//			preparedStatement.setString(10, cliente.getRegion());
//			preparedStatement.setString(11, cliente.getPais());
//			preparedStatement.setString(12, cliente.getCodigo_postal());
//			preparedStatement.setInt(13, cliente.getCodigo_empleado_rep_ventas());
////		preparedStatement.setDouble(14, cliente.getLimite_credito());
//			preparedStatement.setInt(15, codCli);
//			
//			preparedStatement.executeUpdate();
//			preparedStatement.close();
//
//		} catch (SQLException e) {
//			System.out.println("Problema en la conexion con el metodo update.");
//			e.printStackTrace();
//		}
	}

	@Override
	public void delete(Cliente cliente) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.delete(cliente);
		
		session.getTransaction().commit();
		session.close();
		
	}

}


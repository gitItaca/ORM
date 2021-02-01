package ACDT_practica02.ORM.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public void getByName(String nombre, Connection connect) {
		try {
			Statement stmt = connect.createStatement();
	    	ResultSet resultSet = stmt.executeQuery("SELECT * FROM cliente WHERE nombre_cliente=\"" + nombre +"\""
	    			+ " OR nombre_contacto = \"" + nombre + "\" OR apellido_contacto = \"" + nombre + "\"");

	    	while (resultSet.next()) {
	    		System.out.print(resultSet.getInt("codigo_cliente") + " - ");
	    		System.out.print(resultSet.getString("nombre_cliente") + " - ");
	    		System.out.print(resultSet.getString("nombre_contacto") + " - ");
	    		System.out.print(resultSet.getString("apellido_contacto") + " - ");
	    		System.out.print(resultSet.getString("telefono") + " - ");
	    		System.out.print(resultSet.getString("fax") + " - ");
	    		System.out.print(resultSet.getString("linea_direccion1") + " - ");
	    		System.out.print(resultSet.getString("linea_direccion2") + " - ");
	    		System.out.print(resultSet.getString("ciudad") + " - ");
	    		System.out.print(resultSet.getString("region") + " - ");
	    		System.out.print(resultSet.getString("pais") + " - ");
	    		System.out.print(resultSet.getString("codigo_postal") + " - ");
	    		System.out.print(resultSet.getInt("codigo_empleado_rep_ventas") + " - ");
	    		System.out.print(resultSet.getDouble("limite_credito") + "\n");   
			}
	    	resultSet.close();
	    	stmt.close();
		} catch (SQLException e) {
			System.out.println("Problema en la conexion con el metodo getByName");		
			e.printStackTrace();
		}		
		System.out.println();
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


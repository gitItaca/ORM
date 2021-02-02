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
	}
	
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

	@Override 
	public void update(Cliente cliente) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
				
		session.update(cliente);
		
		session.getTransaction().commit();
		session.close();
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


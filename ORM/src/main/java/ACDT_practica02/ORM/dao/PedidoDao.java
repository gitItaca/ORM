//package ACDT_practica02.ORM.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import ACDT_practica02.ORM.model.Pedido;
//import ACDT_practica02.ORM.model.Producto;
//import ACDT_practica02.ORM.utils.ConexionHibernate;
//
//public class PedidoDao implements Dao<Pedido>{
//
//	private static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
//	private static SessionFactory sessionFactory = ConexionHibernate.setUp();
//	
//	@Override
//	public Pedido get(String id) {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		int id_int = Integer.parseInt(id);
//		Pedido pedido = session.find(Pedido.class, id_int);
//		
//		session.getTransaction().commit();
//		session.close();
//		
//		return pedido;
//	}
//	@Override
//	public List<Pedido> getAll() {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		List<Pedido> pedidos = (List<Pedido>) session.createQuery("FROM Pedido ", Pedido.class).getResultList();
//		
//		session.getTransaction().commit();
//		session.close();
//		
//		return pedidos;
//	}
//	@Override
//	public void save(Pedido pedido) {
//		Session session = sessionFactory.openSession();
//
//		session.beginTransaction();
//	
//		session.save(pedido);
//		
//		session.getTransaction().commit();
//		session.close();	
//	}
//	@Override
//	public void update(Pedido pedido) {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//				
//		session.update(pedido);
//		
//		session.getTransaction().commit();
//		session.close();
//	}
//	@Override
//	public void delete(Pedido pedido) {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		session.delete(pedido);
//		
//		session.getTransaction().commit();
//		session.close();
//	}
//	
//	
//
//}

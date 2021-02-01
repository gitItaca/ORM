package ACDT_practica02.ORM.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ConexionHibernate {
	
	//@Getter  //Mirar por que se pone
	private static SessionFactory sessionFactory;
	
//CONSTRUCTOR privado para que solo se pueda crear una sesion, patron singletone
	private ConexionHibernate() {
	}

	public static SessionFactory setUp() {
		if(sessionFactory == null) {		//Para que no se queden sesiones abiertas y solo se cree una.
			
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); 
			try {
			    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return sessionFactory;
	}
	
	public static void shutDown() throws Exception{
		sessionFactory.close();
	}
	//lo mas eficiente es un pool de conexiones
}


/*final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
.configure() // configures settings from hibernate.cfg.xml
.build();
try {
session = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
}
catch (Exception e) {
// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
// so destroy it manually.
StandardServiceRegistryBuilder.destroy( registry );
}*/
//return (SessionFactory) session;

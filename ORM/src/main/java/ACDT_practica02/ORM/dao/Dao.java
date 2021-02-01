package ACDT_practica02.ORM.dao;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;

public interface Dao<T> {
	T get(String id);
    
    List<T> getAll();
    
    void save(T t);
    
    void update(T t);
    
    void delete(T t);
}

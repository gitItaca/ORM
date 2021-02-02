package ACDT_practica02.ORM.utils;

import ACDT_practica02.ORM.model.Producto;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import ACDT_practica02.ORM.dao.ProductoDao;
import ACDT_practica02.ORM.exceptions.*;

public class OperacionesProducto {
	
	public OperacionesProducto(Connection connection) {
	}	
	
//METODOS
	public static Producto crearProducto() throws Exception{	
			ProductoDao pDao = new ProductoDao();
			
			System.out.println("Datos dobre el producto nuevo:");
			System.out.println("Escriba el codigo del producto.");
			String codigo_producto = Leer.pedirCadena();
			System.out.println("Escriba el nombre del producto.");
			String nombre = Leer.pedirCadena();
			System.out.println("Escriba la gama del producto.");
			String gama = Leer.pedirCadena();
			System.out.println("Escriba las dimensiones del producto.");
			String dimensiones = Leer.pedirCadena();
			System.out.println("Escriba el proveedor.");
			String proveedor = Leer.pedirCadena();
//			System.out.println("Escriba la descripcion del producto.");
//			String descripcion = Leer.pedirCadena();	
			System.out.println("Escriba la cantidad que hay en stock.");
			short cantidad_en_stock = Leer.pedirShort();
			System.out.println("Escriba el precio de venta.");
			BigDecimal precio_venta = Leer.pedirBigDecimal();
			System.out.println("Escriba el precio del proveedor.");
			BigDecimal precio_proveedor = Leer.pedirBigDecimal();
			
			BigDecimal bdCero = new BigDecimal(0);
			if (codigo_producto.isEmpty() && nombre.isEmpty() && gama.isEmpty() && dimensiones.isEmpty()
					&& proveedor.isEmpty()) {
				throw new EmptyException();
			}else {
				if(precio_venta == bdCero || precio_proveedor == bdCero) {
					throw new ZeroPriceException();
				}else {
					return new Producto(codigo_producto, nombre, gama, dimensiones, proveedor,
		    			cantidad_en_stock, precio_venta, precio_proveedor);
				}
			}
		}
//	
//	public static Producto crearProductoPruebas(String codigo_producto, String nombre, String gama, String dimensiones, String proveedor,
//			String descripcion, int cantidad_en_stock, double precio_venta, double precio_proveedor) throws Exception{
//		
//		return new Producto(codigo_producto, nombre, gama, dimensiones, proveedor,
//				descripcion, cantidad_en_stock, precio_venta, precio_proveedor);
//	}
	
}

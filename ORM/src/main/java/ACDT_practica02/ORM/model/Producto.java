package ACDT_practica02.ORM.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "Producto")
@Table (name = "producto")
public class Producto {
	
	@Id
	@Column (name = "codigo_producto", updatable = false, nullable = false)
	private String codigo_producto;
	
	@Column (name = "nombre")
	private String nombre;
	@Column (name = "gama")
	private String gama;
	@Column (name = "dimensiones")
	private String dimensiones;
	@Column (name = "proveedor")
	private String proveedor;
//	@Column (name = "descripcion")
//	private String descripcion;
	@Column (name = "cantidad_en_stock")
	private short cantidad_en_stock;
	@Column (name = "precio_venta")
	private BigDecimal precio_venta;
	@Column (name = "precio_proveedor")
	private BigDecimal precio_proveedor;
	
//CONSTRUCTOR
	public Producto(String codigo_producto, String nombre, String gama, String dimensiones, String proveedor,
			 short cantidad_en_stock, BigDecimal precio_venta, BigDecimal precio_proveedor) {
		this.codigo_producto = codigo_producto;
		this.nombre = nombre;
		this.gama = gama;
		this.dimensiones = dimensiones;
		this.proveedor = proveedor;
//		this.descripcion = descripcion;
		this.cantidad_en_stock = cantidad_en_stock;
		this.precio_venta = precio_venta;
		this.precio_proveedor = precio_proveedor;
	}
	
	public Producto() {
	}
	
//GETTERS Y SETTERS
	public String getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGama() {
		return gama;
	}
	public void setGama(String gama) {
		this.gama = gama;
	}

	public String getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

//	public String getDescripcion() {
//		return descripcion;
//	}
//	public void setDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//	}

	public short getCantidad_en_stock() {
		return cantidad_en_stock;
	}
	public void setCantidad_en_stock(short cantidad_en_stock) {
		this.cantidad_en_stock = cantidad_en_stock;
	}

	public BigDecimal getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(BigDecimal precio_venta) {
		this.precio_venta = precio_venta;
	}

	public BigDecimal getPrecio_proveedor() {
		return precio_proveedor;
	}
	public void setPrecio_proveedor(BigDecimal precio_proveedor) {
		this.precio_proveedor = precio_proveedor;
	}

//METODOS
	@Override
	public String toString() {
		return "Producto [codigo_producto=" + codigo_producto + ", nombre=" + nombre + ", gama=" + gama
				+ ", dimensiones=" + dimensiones + ", proveedor=" + proveedor + ", descripcion=" 
				+ ", cantidad_en_stock=" + cantidad_en_stock + ", precio_venta=" + precio_venta + ", precio_proveedor="
				+ precio_proveedor + "]";
	}

}

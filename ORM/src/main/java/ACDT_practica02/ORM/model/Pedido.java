package ACDT_practica02.ORM.model;

import javax.persistence.*;

import org.hibernate.type.CalendarDateType;

@Entity (name = "Pedido")
@Table (name = "pedido")
public class Pedido {
	@Id
	@Column (name = "codigo_pedido", updatable = false, nullable = false)
	private int codigo_pedido;

	@Column (name = "fecha_pedido")
	private CalendarDateType fecha_pedido;
	@Column (name = "fecha_esperada")
	private CalendarDateType fecha_esperada;
	@Column (name = "fecha_entrega")
	private CalendarDateType fecha_entrega;
	@Column (name = "estado")
	private String estado;
	@Column (name = "comentarios")
	private String comentarios;
	
	private int codigo_cliente;
	
}

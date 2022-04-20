package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/*Para especificar que una clase con atributos se trabajara con JPA anotamos @Entity, siempre se importa de 
java persistence. 
@Table: Permite especificar el nombre de la tabla en la base de datos
*/
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {// Siempre es recomendable implementar esta interface
	@Id // Especificamos que este atributo sera la llave primaria dentro de
		// nuestra-aplicación
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Especificamos que se generara de 1 en 1
	private Long id;

	// @Column(name = "nombre_cliente") // Anotación: para especificar el nombre del
	// campo dentro de la base de datos

	private String nombre;
	private String apellido;
	private String email;
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE) // Indica el formato en el cual se guardara la fecha en el campo de la base de
									// datos
	@DateTimeFormat(pattern = "yyyy-MM-dd") // Con esta anotación podemos especificar el patron que deseamos usar para
											// la fecha
	private Date createAt;

	// Creamos la asociación del cliente con las facturas
	@OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY, cascade = CascadeType.ALL) // Especificamos que un cliente puede tener muchas facturas
	private List<Factura> facturas;

	private static final long serialVersionUID = 1L;

	/*
	 * @PrePersist //Se invoca justo antes que llamemos el método persist public
	 * void prePersist() { createAt=new Date(); }
	 */

	public Cliente() {
		facturas = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public void addFactura(Factura factura) {
		facturas.add(factura);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nombre+" "+ this.apellido;
	}
	
}

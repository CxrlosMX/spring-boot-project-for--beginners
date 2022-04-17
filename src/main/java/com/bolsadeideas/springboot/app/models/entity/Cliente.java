package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private Date createAt;

	private static final long serialVersionUID = 1L;

	public Cliente(Long id, String nombre, String apellido, String email, Date createAt) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.createAt = createAt;
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

}

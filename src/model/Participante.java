package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the participantes database table.
 * 
 */
@Entity
@Table(name="participantes")
@NamedQuery(name="Participante.findAll", query="SELECT p FROM Participante p")
public class Participante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String apellido;

	private String dni;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombre;

	@Column(name="num_licencia")
	private String numLicencia;

	private String tipo;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="ID_equipo")
	private Equipo equipo;

	//bi-directional many-to-many association to Partido
	@ManyToMany(mappedBy="participantes")
	private List<Partido> partidos;

	public Participante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumLicencia() {
		return this.numLicencia;
	}

	public void setNumLicencia(String numLicencia) {
		this.numLicencia = numLicencia;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Partido> getPartidos() {
		return this.partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

}
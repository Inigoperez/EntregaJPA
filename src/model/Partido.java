package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the partidos database table.
 *
 */
@Entity
@Table(name="partidos")
@NamedQuery(name="Partido.findAll", query="SELECT p FROM Partido p")
public class Partido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_encuentro")
	private Date fechaEncuentro;

	private String localidad;

	//bi-directional many-to-many association to Equipo
	@ManyToMany(mappedBy="partidos")
	private List<Equipo> equipos;

	//bi-directional many-to-many association to Participante
	@ManyToMany
	@JoinTable(
		name="participantes_partido"
		, joinColumns={
			@JoinColumn(name="ID_partido")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_arbitro1",referencedColumnName="ID"),
			@JoinColumn(name="ID_arbitro2",referencedColumnName="ID")
			}
		)
	private List<Participante> participantes;

	public Partido() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaEncuentro() {
		return this.fechaEncuentro;
	}

	public void setFechaEncuentro(Date fechaEncuentro) {
		this.fechaEncuentro = fechaEncuentro;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

}
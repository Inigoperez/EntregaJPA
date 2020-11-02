package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the equipos database table.
 * 
 */
@Entity
@Table(name="equipos")
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String categoria;

	private String nombre;

	//bi-directional many-to-one association to Clube
	@ManyToOne
	@JoinColumn(name="ID_club")
	private Clube clube;

	//bi-directional many-to-many association to Partido
	@ManyToMany
	@JoinTable(
		name="equipos_partidos"
		, joinColumns={
			@JoinColumn(name="ID_visitante")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_partido")
			}
		)
	private List<Partido> partidos;

	//bi-directional many-to-one association to Participante
	@OneToMany(mappedBy="equipo")
	private List<Participante> participantes;

	public Equipo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Clube getClube() {
		return this.clube;
	}

	public void setClube(Clube clube) {
		this.clube = clube;
	}

	public List<Partido> getPartidos() {
		return this.partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Participante addParticipante(Participante participante) {
		getParticipantes().add(participante);
		participante.setEquipo(this);

		return participante;
	}

	public Participante removeParticipante(Participante participante) {
		getParticipantes().remove(participante);
		participante.setEquipo(null);

		return participante;
	}

}
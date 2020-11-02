package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clubes database table.
 *
 */
@Entity
@Table(name="clubes")
@NamedQueries({
	@NamedQuery(name="Clube.findAll", query="SELECT c FROM Clube c")
})
public class Clube implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String localidad;

	private String nombre;

	@Column(name="primera_equipacion")
	private String primeraEquipacion;

	private String provincia;

	@Column(name="segunda_equipacion")
	private String segundaEquipacion;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="clube")
	private List<Equipo> equipos;

	public Clube() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimeraEquipacion() {
		return this.primeraEquipacion;
	}

	public void setPrimeraEquipacion(String primeraEquipacion) {
		this.primeraEquipacion = primeraEquipacion;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getSegundaEquipacion() {
		return this.segundaEquipacion;
	}

	public void setSegundaEquipacion(String segundaEquipacion) {
		this.segundaEquipacion = segundaEquipacion;
	}

	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo addEquipo(Equipo equipo) {
		getEquipos().add(equipo);
		equipo.setClube(this);

		return equipo;
	}

	public Equipo removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.setClube(null);

		return equipo;
	}

}
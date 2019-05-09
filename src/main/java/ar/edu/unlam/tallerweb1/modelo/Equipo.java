package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Equipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private int cantidadCampeonatos;
	@OneToOne
	private Club club;
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
	public int getCantidadCampeonatos() {
		return cantidadCampeonatos;
	}
	public void setCantidadCampeonatos(int cantidadCampeonatos) {
		this.cantidadCampeonatos = cantidadCampeonatos;
	}
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}
}

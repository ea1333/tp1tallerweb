package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

public class EquiposTest extends SpringTest {
	@Test
	@Transactional
	@Rollback(true)
	public void equiposYJugadores() {
		Session sesion = getSession();
		
		Equipo boca = new Equipo();
		boca.setNombre("Boca");
		boca.setCantidadCampeonatos(5);
		sesion.save(boca);
		Equipo river = new Equipo();
		river.setNombre("River");
		river.setCantidadCampeonatos(4);
		sesion.save(river);
		Equipo loremIpsum = new Equipo();
		loremIpsum.setNombre("Lorem ipsum");
		loremIpsum.setCantidadCampeonatos(2);
		sesion.save(loremIpsum);
		
		Jugador pavon = new Jugador();
		pavon.setNombre("Pavón");
		pavon.setEquipo(boca);
		sesion.save(pavon);
		Jugador barrios = new Jugador();
		barrios.setNombre("Barrios");
		barrios.setEquipo(boca);
		sesion.save(barrios);
		Jugador benedetto = new Jugador();
		benedetto.setNombre("Benedetto");
		benedetto.setEquipo(boca);
		sesion.save(benedetto);
		Jugador buffarini = new Jugador();
		buffarini.setNombre("Buffarini");
		buffarini.setEquipo(boca);
		sesion.save(buffarini);
		
		Jugador lorem = new Jugador();
		lorem.setNombre("Lorem");
		lorem.setEquipo(river);
		sesion.save(lorem);
		Jugador ipsum = new Jugador();
		ipsum.setNombre("Ipsum");
		ipsum.setEquipo(river);
		sesion.save(ipsum);
		
		Jugador dolor = new Jugador();
		dolor.setNombre("Dolor");
		dolor.setEquipo(loremIpsum);
		sesion.save(dolor);
		Jugador sitAmet = new Jugador();
		sitAmet.setNombre("Sit Amet");
		sitAmet.setEquipo(loremIpsum);
		sesion.save(sitAmet);
		
		List<Equipo> equiposMas3Campeonatos = sesion.createCriteria(Equipo.class)
				.add(Restrictions.gt("cantidadCampeonatos", 3))
				.list();
		
		List<Jugador> jugadoresBoca = sesion.createCriteria(Jugador.class)
				.add(Restrictions.eq("equipo", boca))
				.list();
		
		List<Jugador> jugadoresEquiposMas3Campeonatos = sesion.createCriteria(Jugador.class)
				.createAlias("equipo", "e")
				.add(Restrictions.gt("e.cantidadCampeonatos", 3))
				.list();
		
		assertThat(equiposMas3Campeonatos.size()).isEqualTo(2);
		assertThat(jugadoresEquiposMas3Campeonatos.size()).isGreaterThan(3);
	}
}

package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class MundoTest extends SpringTest {
	@Test
	@Transactional
	@Rollback(true)
	public void mundo() {
		Session sesion = getSession();
		
		Continente america = new Continente();
		america.setNombre("América");
		sesion.save(america);
		Continente europa = new Continente();
		europa.setNombre("europa");
		sesion.save(europa);
		Continente asia = new Continente();
		asia.setNombre("asia");
		sesion.save(asia);
		Continente africa = new Continente();
		africa.setNombre("africa");
		sesion.save(africa);
		Continente oceania = new Continente();
		oceania.setNombre("oceania");
		sesion.save(oceania);
		
		Ubicacion BsAsCoords = new Ubicacion();
		BsAsCoords.setLatitud(-34.6);
		BsAsCoords.setLongitud(-58.5);
		sesion.save(BsAsCoords);
		
		Ciudad BsAs = new Ciudad();
		BsAs.setNombre("Buenos Aires");
		BsAs.setUbicacionGeografica(BsAsCoords);
		sesion.save(BsAs);

		
		Ubicacion CdMxCoords = new Ubicacion();
		CdMxCoords.setLatitud(19.0);
		CdMxCoords.setLongitud(-99.9);
		sesion.save(CdMxCoords);
				
		Ciudad CdMx = new Ciudad();
		CdMx.setNombre("Ciudad de México");
		CdMx.setUbicacionGeografica(CdMxCoords);
		sesion.save(CdMx);
		
		
		Ubicacion BogCoords = new Ubicacion();
		BogCoords.setLatitud(5.0);
		BogCoords.setLongitud(-75.0);
		sesion.save(BogCoords);
				
		Ciudad Bog = new Ciudad();
		Bog.setNombre("Bogotá");
		Bog.setUbicacionGeografica(BogCoords);
		sesion.save(Bog);
		
		
		Ubicacion StgoCoords = new Ubicacion();
		StgoCoords.setLatitud(-33.0);
		StgoCoords.setLongitud(-71.0);
		sesion.save(StgoCoords);
				
		Ciudad Stgo = new Ciudad();
		Stgo.setNombre("Santiago");
		Stgo.setUbicacionGeografica(StgoCoords);
		sesion.save(Stgo);
		
		
		Ubicacion CcsCoords = new Ubicacion();
		CcsCoords.setLatitud(10.0);
		CcsCoords.setLongitud(-66.0);
		sesion.save(CcsCoords);
				
		Ciudad Ccs = new Ciudad();
		Ccs.setNombre("Caracas");
		Ccs.setUbicacionGeografica(CcsCoords);
		sesion.save(Ccs);
		
		
		Ubicacion BraCoords = new Ubicacion();
		BraCoords.setLatitud(-15.0);
		BraCoords.setLongitud(-77.0);
		sesion.save(BraCoords);
				
		Ciudad Bra = new Ciudad();
		Bra.setNombre("Brasilia");
		Bra.setUbicacionGeografica(BraCoords);
		sesion.save(Bra);
		
		
		Ubicacion WashDCCoords = new Ubicacion();
		WashDCCoords.setLatitud(39.0);
		WashDCCoords.setLongitud(-77.0);
		sesion.save(WashDCCoords);
				
		Ciudad WashDC = new Ciudad();
		WashDC.setNombre("Washington");
		WashDC.setUbicacionGeografica(WashDCCoords);
		sesion.save(WashDC);
		
		
		Ubicacion LdnCoords = new Ubicacion();
		LdnCoords.setLatitud(51.0);
		LdnCoords.setLongitud(0.0);
		sesion.save(LdnCoords);
				
		Ciudad Ldn = new Ciudad();
		Ldn.setNombre("Londres");
		Ldn.setUbicacionGeografica(LdnCoords);
		sesion.save(Ldn);
		
		
		Ubicacion MadCoords = new Ubicacion();
		MadCoords.setLatitud(40.0);
		MadCoords.setLongitud(-3.0);
		sesion.save(MadCoords);
				
		Ciudad Mad = new Ciudad();
		Mad.setNombre("Madrid");
		Mad.setUbicacionGeografica(MadCoords);
		sesion.save(Mad);
		
		
		Ubicacion TokCoords = new Ubicacion();
		TokCoords.setLatitud(35.0);
		TokCoords.setLongitud(135.0);
		sesion.save(TokCoords);
				
		Ciudad Tok = new Ciudad();
		Tok.setNombre("Tokio");
		Tok.setUbicacionGeografica(TokCoords);
		sesion.save(Tok);
		
		
		Pais AR = new Pais();
		AR.setNombre("Argentina");
		AR.setHabitantes(40000000);
		AR.setIdioma("español");
		AR.setContinente(america);
		AR.setCapital(BsAs);
		sesion.save(AR);
		
		Pais BR = new Pais();
		BR.setNombre("Brasil");
		BR.setHabitantes(209000000);
		BR.setIdioma("portugués");
		BR.setContinente(america);
		BR.setCapital(Bra);
		sesion.save(BR);
		
		Pais MX = new Pais();
		MX.setNombre("México");
		MX.setHabitantes(127000000);
		MX.setIdioma("español");
		MX.setContinente(america);
		MX.setCapital(CdMx);
		sesion.save(MX);
		
		Pais CO = new Pais();
		CO.setNombre("Colombia");
		CO.setHabitantes(50000000);
		CO.setIdioma("español");
		CO.setContinente(america);
		CO.setCapital(Bog);
		sesion.save(CO);
		
		Pais VE = new Pais();
		VE.setNombre("Venezuela");
		VE.setHabitantes(32000000);
		VE.setIdioma("español");
		VE.setContinente(america);
		VE.setCapital(Ccs);
		sesion.save(VE);
		
		Pais CL = new Pais();
		CL.setNombre("Chile");
		CL.setHabitantes(18000000);
		CL.setIdioma("español");
		CL.setContinente(america);
		CL.setCapital(Stgo);
		sesion.save(CL);
		
		Pais US = new Pais();
		US.setNombre("Estados Unidos");
		US.setHabitantes(327000000);
		US.setIdioma("inglés");
		US.setContinente(america);
		US.setCapital(WashDC);
		sesion.save(US);
		
		Pais GB = new Pais();
		GB.setNombre("Reino Unido");
		GB.setHabitantes(66000000);
		GB.setIdioma("inglés");
		GB.setContinente(europa);
		GB.setCapital(Ldn);
		sesion.save(GB);
		
		Pais ES = new Pais();
		ES.setNombre("España");
		ES.setHabitantes(47000000);
		ES.setIdioma("español");
		ES.setContinente(europa);
		ES.setCapital(Mad);
		sesion.save(ES);
		
		Pais JP = new Pais();
		JP.setNombre("Japón");
		JP.setHabitantes(127000000);
		JP.setIdioma("japonés");
		JP.setContinente(europa);
		JP.setCapital(Mad);
		sesion.save(JP);
		
		// 2
		List<Pais> paisesHablaInglesa = sesion.createCriteria(Pais.class)
				.add(Restrictions.eq("idioma", "inglés"))
				.list();
		
		// 3
		List<Pais> paisesEuropa = sesion.createCriteria(Pais.class)
				.add(Restrictions.eq("continente", europa))
				.list();
		
		// 4
		// Latitud decimal del Trópico de Cáncer es 23.45° Norte (23.45)
		List<Pais> paisesCapitalTropicoCancer = sesion.createCriteria(Pais.class)
				.createAlias("capital", "c")
				.createAlias("c.ubicacionGeografica", "u")
				.add(Restrictions.gt("u.latitud", 23.45))
				.list();
		
		// 5
		// Las latitudes al sur del ecuador son negativas (ejemplo: 34.6° Sur es -34.6)
		List<Ciudad> ciudadesHemisferioSur = sesion.createCriteria(Ciudad.class)
				.createAlias("ubicacionGeografica", "u")
				.add(Restrictions.lt("u.latitud", 0.0))
				.list();
		
		assertThat(paisesHablaInglesa).isNotNull();
		assertThat(paisesEuropa).isNotNull();
		assertThat(paisesCapitalTropicoCancer).isNotNull();
		assertThat(ciudadesHemisferioSur).isNotNull();
	}
}

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
import ar.edu.unlam.tallerweb1.modelo.Equipo;
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
		BsAsCoords.setLatitud(-58.5);
		sesion.save(BsAsCoords);

		Ubicacion CdMxCoords = new Ubicacion();
		CdMxCoords.setLatitud(19);
		CdMxCoords.setLatitud(-99);
		sesion.save(CdMxCoords);
				
		Ciudad CdMx = new Ciudad();
		CdMx.setNombre("Ciudad de México");
		CdMx.setUbicacionGeografica(CdMxCoords);
		sesion.save(CdMx);
		
		Ubicacion BogCoords = new Ubicacion();
		BogCoords.setLatitud(5);
		BogCoords.setLatitud(-75);
		sesion.save(BogCoords);
				
		Ciudad Bog = new Ciudad();
		Bog.setNombre("Bogotá");
		Bog.setUbicacionGeografica(BogCoords);
		sesion.save(Bog);
		
		Ubicacion StgoCoords = new Ubicacion();
		StgoCoords.setLatitud(-33);
		StgoCoords.setLatitud(-71);
		sesion.save(StgoCoords);
				
		Ciudad Stgo = new Ciudad();
		Stgo.setNombre("Santiago");
		Stgo.setUbicacionGeografica(StgoCoords);
		sesion.save(Stgo);
				
		Ciudad BsAs = new Ciudad();
		BsAs.setNombre("Buenos Aires");
		BsAs.setUbicacionGeografica(BsAsCoords);
		sesion.save(BsAs);
		
		Ubicacion CcsCoords = new Ubicacion();
		CcsCoords.setLatitud(10);
		CcsCoords.setLatitud(-66);
		sesion.save(CcsCoords);
				
		Ciudad Ccs = new Ciudad();
		Ccs.setNombre("Caracas");
		Ccs.setUbicacionGeografica(CcsCoords);
		sesion.save(Ccs);
		
		Ubicacion WashDCCoords = new Ubicacion();
		WashDCCoords.setLatitud(39);
		WashDCCoords.setLatitud(-77);
		sesion.save(WashDCCoords);
				
		Ciudad WashDC = new Ciudad();
		WashDC.setNombre("Washington");
		WashDC.setUbicacionGeografica(WashDCCoords);
		sesion.save(WashDC);
		
		Ubicacion LdnCoords = new Ubicacion();
		LdnCoords.setLatitud(51);
		LdnCoords.setLatitud(0);
		sesion.save(LdnCoords);
				
		Ciudad Ldn = new Ciudad();
		Ldn.setNombre("Londres");
		Ldn.setUbicacionGeografica(LdnCoords);
		sesion.save(Ldn);
		
		Pais AR = new Pais();
		AR.setNombre("Argentina");
		AR.setHabitantes(40000000);
		AR.setIdioma("español");
		AR.setContinente(america);
		AR.setCapital(BsAs);
		sesion.save(AR);
		
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
		
		List<Pais> paisesHablaInglesa = sesion.createCriteria(Pais.class)
				.add(Restrictions.eq("idioma", "inglés"))
				.list();
		
		List<Pais> paisesEuropa = sesion.createCriteria(Pais.class)
				.add(Restrictions.eq("continente", europa))
				.list();
		
		assertThat(paisesHablaInglesa.size()).isEqualTo(2);
	}
}

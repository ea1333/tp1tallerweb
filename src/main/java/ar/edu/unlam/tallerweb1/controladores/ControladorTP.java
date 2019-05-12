package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorTP {
	//HOLAMUNDO!!!
	@RequestMapping(path = "/holamundo")
	public ModelAndView HolaMundo() {
		ModelMap model = new ModelMap();
		String hola = "Hola mundo!";
		model.put("hm", hola);
		return new ModelAndView("holamundo", model);
	}

	//Saludar
	@RequestMapping(path = "/saludar")
	public ModelAndView SaludarPersona(
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "apellido") String apellido
		) {
		ModelMap model = new ModelMap();
		model.put("nombre", nombre);
		model.put("apellido", apellido);
		return new ModelAndView("saludar", model);
	}
	
	//Saludar 2
	@RequestMapping(value = "/saludar2/{nombre}/{apellido}")
	public ModelAndView SaludarPersona2(@PathVariable String nombre, @PathVariable String apellido) {
		ModelMap model = new ModelMap();
		model.put("nombre", nombre);
		model.put("apellido", apellido);
		return new ModelAndView("saludar", model);//LA MISMA VISTA QUE EL ANTERIOR!!!!!!!!!!!!!111111111
	}
	
	// Punto 6 del TP
	@RequestMapping(path = "/cadena/{cadena}/{operacion}")
	public ModelAndView cadena(@PathVariable String cadena, @PathVariable String operacion) {
		String cadenaResultado = null;
		if (operacion.equals("pasarAMayuscula")) {
			cadenaResultado = cadena.toUpperCase();
		} else if (operacion.equals("pasarAMinuscula")) {
			cadenaResultado = cadena.toLowerCase();
		} else if (operacion.equals("invertirOrden")) {
			cadenaResultado = invertirCadena(cadena);
		} else if (operacion.equals("cantidadDeCaracteres")) {
			cadenaResultado = Integer.toString(cadena.length());
		}
		ModelMap model = new ModelMap();
		model.put("cadena", cadena);
		model.put("nombreOperacion", operacion);
		model.put("cadenaResultado", cadenaResultado);
		return new ModelAndView("cadena", model);
	}

	// Función para invertir cadena
	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int i = cadena.length() - 1; i >= 0; i--) {
			cadenaInvertida += cadena.charAt(i);
		}
		return cadenaInvertida;
	}
}

package com.uca.capas.Tarea2.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/alumno")
	public @ResponseBody String alumno() {
		String texto = "Información Personal: <br> "
				+ "Nombre: Alvaro Francisco <br> "
				+ "Apellido: García Cornejo <br>"
				+ "Carnet: 00111317 <br>"
				+ "Carrera: Ingeniería Informática <br>"
				+ "Año cursado: 4°";
		return texto;
	}
	
	//fecha?day=1&month=1&year=2020
	@RequestMapping("/fecha")
	public @ResponseBody String fecha(HttpServletRequest request){
		Integer day = Integer.parseInt(request.getParameter("day"));
		Integer month = Integer.parseInt(request.getParameter("month"));
		Integer year = Integer.parseInt(request.getParameter("year"));
		
		String[] strDays = new String[]{
			"Domingo",
			"Lunes",
			"Martes",
			"Miércoles",
			"Jueves",
			"Viernes",
			"Sábado"};
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month-1, day);
		
		Integer diaDeSemana = calendar.get(Calendar.DAY_OF_WEEK);
		String message = "La fecha " + format.format(calendar.getTime()) + " cayo el día: ";

		return message.concat(strDays[diaDeSemana-1]);
	}
}

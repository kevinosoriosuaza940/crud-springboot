package com.kevin.apicrud.utils;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UtilsHorasTest {
    UtilsHoras utilsHoras;
    @Test
    void calculateHour () {
    Date fecha = new Date(2021, Calendar.DECEMBER,8,10,0);
    int resultado = UtilsHoras.calculateHour(fecha);
    assertEquals(resultado,10);
    }

    @Test
    void calcularhoraservicio () {
        Date fechaini = new Date(2021, Calendar.DECEMBER,8,10,0);
        Date fechafin = new Date(2021, Calendar.DECEMBER,8,15,0);

        int resultado = UtilsHoras.calcularhoraservicio(fechaini,fechafin);

        assertEquals(resultado, 5);
    }

    @Test
    void calculardiasemana () {
        Date fecha = new Date(2021, Calendar.APRIL,8,10,0);
        int resultado = UtilsHoras.calculardiasemana(fecha);

        assertEquals(resultado,6);
    }

    @Test
    void calcularsemana () {
        Date fecha = new Date(2021, Calendar.APRIL,8,10,0);
        int resultado = UtilsHoras.calcularsemana(fecha);

        assertEquals(resultado,15);

    }

    @Test
    void calculadorhorasnocturnas () {
        Date fechaini = new Date(2021, Calendar.DECEMBER,8,1,0);
        Date fechafin = new Date(2021, Calendar.DECEMBER,8,23,0);
        int restuldo = UtilsHoras.calculadorhorasnocturnas(fechaini,fechafin);

        assertEquals(restuldo,9);


    }

    @Test
    void calcularhorasextras () {
        int horas = 50;
        int resultado = UtilsHoras.calcularhorasextras(horas);

        assertEquals(resultado,2);
    }

    @Test
    void formatDate () throws ParseException {
        String fecha = new String("2021-4-25 10:00:00");
        Date resultado = UtilsHoras.formatDate(fecha);

        assertEquals(resultado,new Date(2021-1900, Calendar.APRIL,25,10,0,0));
    }
}
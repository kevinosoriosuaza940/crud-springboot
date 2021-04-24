package com.kevin.apicrud.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilsHoras {
    static Calendar cal = Calendar.getInstance();

    public static int calculateHour (Date date) {
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int calcularhoraservicio (Date stardate, Date enddate) {
        int inihour = calculateHour(stardate);
        int endhour = calculateHour(enddate);
        if (endhour > inihour) {
            return endhour - inihour;
        }
        return 0;
    }
    public static int calculadorhorasnocturnas (Date start, Date end) {

        int startHour = calculateHour(start);
        int endHour = calculateHour(end);

        int startNight = 20;
        int endNigth = 7;
        int midNigth = 23;

        if (startHour <= endNigth && endHour <= endNigth) {
            return endHour - startHour;
        }else if(endHour< endNigth){
            return endHour-endNigth;
        } else if(startHour>endNigth&&endHour>=startNight){
            return endHour-startNight;
        }else if(startHour>=startNight){
            return startHour-endHour;
        }else{
            return 0;
        }
    }

    public static int calculardiasemana (Date date) {
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static int calcularsemana (Date date) {
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static int calcularhorasdominicales (Date stardate, Date enddate, int totalhoras) {
        int dia = calculardiasemana(stardate);
        if (dia == 7) {
            return calcularhoraservicio(stardate, enddate);
        } else {
            return 0;
        }
    }

    public static int calcularhorascomunes (Date stardate, Date enddate) {
        return calcularhoraservicio(stardate, enddate);
    }

    public static Date formatDate (String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        return formatter.parse(date);
    }

    public static int calcularhorasextras (int TotalHoras) {
        int horasLaborales = 48;
        if (TotalHoras > horasLaborales) {
            return TotalHoras - horasLaborales;
        } else {
            return 0;
        }
    }

    public static int calcularhorasextrasdomingo (Date date, int totalHoras) {
        int day = calculardiasemana(date);
        int horasLaborales = calcularhorasextras(totalHoras);
        if (day == 6 && totalHoras > horasLaborales) {
            return calcularhorasextras(totalHoras);
        } else {
            return 0;
        }
    }
    public static int calcularhorasextrasnocturnas(Date startdate, Date enddate, int totalHoras) {
        int horasLaborales = 48;
        if (calculadorhorasnocturnas(startdate, enddate) != 0 && totalHoras > horasLaborales) {
            return calcularhorasextras(totalHoras);
        } else {
            return 0;
        }
    }

}

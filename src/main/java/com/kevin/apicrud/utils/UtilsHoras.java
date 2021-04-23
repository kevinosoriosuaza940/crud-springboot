package com.kevin.apicrud.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilsHoras {
    static Calendar cal = Calendar.getInstance();

    public static int calculateHour(Date date) {
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int calcularhoraservicio(Date starhour, Date endhour) {
        int initHour = calculateHour(starhour);
        int endHour = calculateHour(endhour);
        if (initHour == endHour) {
            return 0;
        } else if (initHour > endHour) {
            return initHour - endHour;
        } else {
            return endHour - initHour;
        }
    }

    public static int calculadorhorasnocturnas(Date start, Date end) {

        int startHour = calculateHour(start);
        int endHour = calculateHour(end);

        int startNight = 20;
        int endNigth = 7;
        int midNigth = 23;

        /*if(startHour <= endNigth && endHour <= endNigth) {
            return endHour-startHour;
        }else if(startHour >= startNight && endHour >= midNigth){
            return endHour - startHour;
        }else if(startHour <= startNight && endHour <= midNigth){
           return endHour-startNight;
     }else if(startHour < endNigth && endHour > endNigth){
            return endNigth-startHour;
        }else{
            return 0;
        }*/

        if ((startHour >= startNight && endHour <= midNigth) || (endHour <= endNigth)) {

            if (endHour <= midNigth)
                return endHour - startNight; // dia - noche
            else {// dia - madrugada
                return (midNigth - startHour) + endHour;
            }

        } else if (startHour >= startNight && endHour <= endNigth) {

            if (endHour <= endNigth) {// noche-noche
                return (endHour + 4) - (startHour - startNight); //20 - 24
            } else {
                return (endNigth - startHour) - (endNigth - endHour); //0 - 7
            }

        } else if (startHour >= startNight) {
            if (startHour <= midNigth) {
                return (midNigth - startHour); // noche - dia
            } else {
                return (endNigth - startHour); // madrugada - dia
            }
        } else {
            return 0;
        }
    }

    public static int calculardiasemana(Date date) {
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static int calcularsemana(Date date) {
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static int calcularhorasdominicales(Date stardate, Date enddate) {
        int dia = calculardiasemana(stardate);
        if (dia == 7) {
            return calcularhoraservicio(stardate, enddate);
        } else {
            return 0;
        }
    }


    public static int calcularhorascomunes(Date stardate, Date enddate) {
        return calcularhoraservicio(stardate, enddate) - calcularhorasdominicales(stardate, enddate) - calculadorhorasnocturnas(stardate, enddate);
    }

    public static Date formatDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        return formatter.parse(date);
    }
}

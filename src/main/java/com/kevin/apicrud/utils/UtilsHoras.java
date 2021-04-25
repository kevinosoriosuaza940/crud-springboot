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

    public static int calculardiasemana (Date date) {
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static int calcularsemana (Date date) {
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static int calculadorhorasnocturnas (Date start, Date end) {

        int startHour = calculateHour(start);
        int endHour = calculateHour(end);

        int startNight = 20;
        int endNigth = 7;
        int midNigth = 23;
        //madrugada-madrugada
        if (startHour <= endNigth && endHour <= endNigth) {
            return endHour - startHour;
            //madrugada-dia
        }else if(startHour < endNigth && endHour < startNight){
            return endNigth - startHour;
            //dia-noche
        } else if(startHour > endNigth && endHour >startNight){
            return endHour-startNight;
            //noche-noche
        }else if(startHour >= startNight && endHour > startNight){
            return endHour-startHour;
            //madrugada-noche
        }else if(startHour<endNigth && endHour>startNight){
            return (endNigth-startHour)+(endHour-startNight);
        }else {return 0;}
    }


        public static int calcularhorasextras (int TotalHoras) {
            int horasLaborales = 48;
            if (TotalHoras > horasLaborales) {
                return TotalHoras - horasLaborales;
            } else {
                return 0;
            }
        }

        public static int calcularhorascomunes (Date stardate, Date enddate) {
        return calcularhoraservicio(stardate, enddate);
    }

    public static int calcularhorasdominicales (Date stardate, Date enddate,int TotalHoras) {
        int dia = calculardiasemana(stardate);
        int horasLaborales = 48;
        if (dia == 7 &&calcularhorasextras(TotalHoras)>0) {
            return calcularhoraservicio(stardate, enddate);
        } else {
            return 0;
        }
    }

    public static int calcularhorasextrasdomingo (Date stardate, Date enddate,int TotalHoras) {
        int dia = calculardiasemana(stardate);
        int horasLaborales = 48;
        if (calcularhoraservicio(stardate, enddate)<horasLaborales && dia == 7) {
            return calcularhoraservicio(stardate, enddate);
        } else {
            return 0;
        }
    }
    public static int calcularhorasextrasnocturnas(Date startdate, Date enddate, int totalHoras) {
       int horasLaborales = 48;
        if (calcularhoraservicio(startdate, enddate)<horasLaborales) {
            return calcularhorasextras(totalHoras);
        } else {
            return 0;
        }

    }

    public static Date formatDate (String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        return formatter.parse(date);
    }

}

package org.kodigo.Utils;

import org.kodigo.Interfaces.interface_formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formatter implements interface_formatter {


    Date date = new Date();

    @Override
    public String formatDate() {
        String  formatDate;
        DateFormat shortDate = DateFormat.getDateInstance(DateFormat.SHORT);
        formatDate =shortDate.format(date);

        return formatDate;
    }
    
    @Override
    public Date formatDateToFactures(String format) {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dat = null;
        try{

            dat=formato.parse(format);

        }catch(ParseException ex){

            System.out.println("Hubo un problema: "+ex);

        }

        return dat;
    }


    @Override
    public String Hour() {
        String formatHour;
        DateFormat shorHour = DateFormat.getTimeInstance(DateFormat.MEDIUM);
        formatHour = shorHour.format(date);

        return formatHour;
    }

    public static boolean mail(String formatMail) {
        Pattern pattern = getPattern();
        Matcher mather = pattern.matcher(formatMail);
        return extracted(mather);
    }

    private static boolean extracted(Matcher mather) {
        if (mather.find() == true) {

            System.out.println("El email ingresado es válido.");
            return true;
        } else {
            System.out.println("El email ingresado es inválido.\nIngrese de nuevo su correo");
            return false;
        }
    }

    private static Pattern getPattern() {
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        return pattern;
    }
}

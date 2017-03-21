/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acseg.reconocimiento.models;

import java.text.ParseException;
import java.time.LocalDateTime;

/**
 *
 * @author joandv
 */
public class LogPersona {

    private String hora;
    private String month;
    private String day;
    private String year;
    private String CI;
    private String op;

    public LogPersona(String CI, String op) throws ParseException {
        LocalDateTime now = LocalDateTime.now();
        String minutes = "";
        if (now.getHour() < 10) {
            minutes = "0" + String.valueOf(now.getMinute());
        } else {
            minutes = String.valueOf(now.getMinute());
        }
        this.hora = String.valueOf(now.getHour()) + ":" + minutes;
        this.month = String.valueOf(now.getMonthValue());
        this.day = String.valueOf(now.getDayOfMonth());
        this.year = String.valueOf(now.getYear());
        this.CI = CI;
        this.op = op;
    }

    public String getHora() {
        return hora;
    }

    public String getCI() {
        return CI;
    }

    public String getOp() {
        return op;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getYear() {
        return year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "LogPersona{" + "hora=" + hora + ", Mes=" + month + ", Día=" + day + ", Año=" + year + ", CI=" + CI + ", Operacion=" + op + '}';
    }

}

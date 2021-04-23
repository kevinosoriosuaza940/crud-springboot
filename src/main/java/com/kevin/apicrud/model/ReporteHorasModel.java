package com.kevin.apicrud.model;

import java.util.List;

public class ReporteHorasModel {
    private String idtecnico;
    private int numerosemana;
    private int horasnormales;
    private int horasnormalesextra;
    private int horasnocturas;
    private int horasnocturnasextra;
    private int horasdomingo;
    private int getHorasdomingoextra;
    private int totalhoras;

    public String getIdtecnico() {
        return idtecnico;
    }

    public void setIdtecnico(String idtecnico) {
        this.idtecnico = idtecnico;
    }

    public int getNumerosemana() {
        return numerosemana;
    }

    public void setNumerosemana(int numerosemana) {
        this.numerosemana = numerosemana;
    }

    public int getHorasnormales() {
        return horasnormales;
    }

    public void setHorasnormales(int horasnormales) {
        this.horasnormales = horasnormales;
    }

    public int getHorasnormalesextra() {
        return horasnormalesextra;
    }

    public void setHorasnormalesextra(int horasnormalesextra) {
        this.horasnormalesextra = horasnormalesextra;
    }

    public int getHorasnocturas() {
        return horasnocturas;
    }

    public void setHorasnocturas(int horasnocturas) {
        this.horasnocturas = horasnocturas;
    }

    public int getHorasnocturnasextra() {
        return horasnocturnasextra;
    }

    public void setHorasnocturnasextra(int horasnocturnasextra) {
        this.horasnocturnasextra = horasnocturnasextra;
    }

    public int getHorasdomingo() {
        return horasdomingo;
    }

    public void setHorasdomingo(int horasdomingo) {
        this.horasdomingo = horasdomingo;
    }

    public int getGetHorasdomingoextra() {
        return getHorasdomingoextra;
    }

    public void setGetHorasdomingoextra(int getHorasdomingoextra) {
        this.getHorasdomingoextra = getHorasdomingoextra;
    }

    public int getTotalhoras() {
        return totalhoras;
    }

    public void setTotalhoras(int totalhoras) {
        this.totalhoras = totalhoras;
    }
}

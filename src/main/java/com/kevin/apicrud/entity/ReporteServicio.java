package com.kevin.apicrud.entity;
import javax.persistence.*;

@Entity
@Table(name="reporteservicio")
public class ReporteServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fechainicio;
    private String fechafinal;
    private int numerosemana;
    private int totalhorasservicio;
    private String idservicio;
    private String idtecnico;

    public int getId() {
        return id;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

    public int getNumerosemana() {
        return numerosemana;
    }

    public void setNumerosemana(int numerosemana) {
        this.numerosemana = numerosemana;
    }

    public int getTotalhorasservicio() {
        return totalhorasservicio;
    }

    public void setTotalhorasservicio(int totalhorasservicio) {
        this.totalhorasservicio = totalhorasservicio;
    }

    public String getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(String idservicio) {
        this.idservicio = idservicio;
    }

    public String getIdtecnico() {
        return idtecnico;
    }

    public void setIdtecnico(String idtecnico) {
        this.idtecnico = idtecnico;
    }
}

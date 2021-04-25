package com.kevin.apicrud.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicio")
public class ServicioEntity {
    @Id
    private String idservicio;

    private  String tiposervicio;

    public String getTiposervicio () {
        return tiposervicio;
    }

    public void setTiposervicio (String tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public String getIdservicio () {
        return idservicio;
    }

    public void setIdservicio (String idservicio) {
        this.idservicio = idservicio;
    }
}

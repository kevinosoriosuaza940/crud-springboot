package com.kevin.apicrud.controller;

import com.kevin.apicrud.entity.ServicioEntity;
import com.kevin.apicrud.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ServicioController {
    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicios")
    public List<ServicioEntity> findAll(){
        return servicioRepository.findAll();
    }
}

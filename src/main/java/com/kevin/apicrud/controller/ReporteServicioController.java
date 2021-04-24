package com.kevin.apicrud.controller;

import com.kevin.apicrud.entity.ReporteServicio;
import com.kevin.apicrud.repository.ReporteServicioRepository;
import com.kevin.apicrud.utils.UtilsHoras;
import com.kevin.apicrud.model.ReporteHorasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ReporteServicioController {
    @Autowired
    private ReporteServicioRepository reporteServicioRepository;

    @PostMapping("/reporteservicio")
    public ReporteServicio create(@RequestBody ReporteServicio reporteServicio) throws ParseException {
        Date iniDate = UtilsHoras.formatDate(reporteServicio.getFechainicio());
        Date endDate = UtilsHoras.formatDate(reporteServicio.getFechafinal());
        reporteServicio.setNumerosemana(UtilsHoras.calcularsemana(iniDate));
        reporteServicio.setTotalhorasservicio(UtilsHoras.calcularhoraservicio(iniDate, endDate));
        return reporteServicioRepository.save(reporteServicio);
    }

    @GetMapping("/reporteservicio")
    public List<ReporteServicio> findAll() {
        return reporteServicioRepository.findAll();
    }

    @GetMapping("/getservciostecnico")
    public List<ReporteServicio> findByTecnicoId(@RequestParam String idtecnico, @RequestParam int numerosemana) {
        List<ReporteServicio> results = findAll();
        List<ReporteServicio> finalList = new ArrayList<>();
        for(ReporteServicio rs: results) {
            if(rs.getIdtecnico().equals(idtecnico) && rs.getNumerosemana() == numerosemana) {
                finalList.add(rs);
            }
        }
        return finalList;
    }

    @GetMapping("/results")
    public List<ReporteHorasModel> findHoras(@RequestParam String idtecnico, @RequestParam int numerosemana) throws ParseException {
        List<ReporteServicio> results = findByTecnicoId(idtecnico, numerosemana);
        List<ReporteHorasModel> finalList = new ArrayList<>();
        ReporteHorasModel finalReport = new ReporteHorasModel();
        int sumhorasnormales = 0;
        int sumhorasdomingo = 0;
        int sumhorastotales = 0;
        int sumhorasnocturnas = 0;
        int sumhorasextras = 0;
        int sumhorasextrasdomingo = 0;
        int sumhorasextrasnocturnas = 0;

        for (ReporteServicio rs : results) {
            Date initDate = UtilsHoras.formatDate(rs.getFechainicio());
            Date endDate = UtilsHoras.formatDate(rs.getFechafinal());
            sumhorasnormales += UtilsHoras.calcularhorascomunes(initDate, endDate);
            sumhorastotales += UtilsHoras.calcularhoraservicio(initDate, endDate);
            sumhorasdomingo += UtilsHoras.calcularhorasdominicales(initDate, endDate,sumhorastotales);
            sumhorasnocturnas += UtilsHoras.calculadorhorasnocturnas(initDate, endDate);
            sumhorasextras += UtilsHoras.calcularhorasextras(sumhorastotales);
            sumhorasextrasdomingo += UtilsHoras.calcularhorasextrasdomingo(initDate,sumhorastotales);
            sumhorasextrasnocturnas += UtilsHoras.calcularhorasextrasnocturnas(initDate,endDate,sumhorastotales);

            finalReport.setIdtecnico(idtecnico);
            finalReport.setNumerosemana(UtilsHoras.calcularsemana(initDate));
            finalReport.setHorasdomingo(sumhorasdomingo-sumhorasextrasdomingo);
            finalReport.setHorasnocturas(sumhorasnocturnas-sumhorasextrasnocturnas);
            finalReport.setGetHorasdomingoextra(sumhorasextrasdomingo);
            finalReport.setHorasnormalesextra(sumhorasextras-sumhorasextrasdomingo-sumhorasextrasnocturnas);
            finalReport.setTotalhoras(sumhorasnormales);
            finalReport.setHorasnormales(sumhorastotales-sumhorasextras);
            finalReport.setHorasnocturnasextra((sumhorasextrasnocturnas));
        }
        finalList.add(finalReport);
        return finalList;
    }
}

package cl.awakelab.Grupal6M6.web.controller;


import cl.awakelab.Grupal6M6.model.domain.dto.*;
import cl.awakelab.Grupal6M6.web.service.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiRestTesting {

    private final VisitaService service;

    public ApiRestTesting(VisitaService service) {
        this.service = service;

    }

    @GetMapping("/all")
    public ResponseEntity<List<Visita>> findAll(){
        return service.findAll()
                .map(accidentes -> new ResponseEntity<>(accidentes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

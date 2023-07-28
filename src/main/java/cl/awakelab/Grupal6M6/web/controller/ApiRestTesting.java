package cl.awakelab.Grupal6M6.web.controller;


import cl.awakelab.Grupal6M6.model.domain.dto.*;
import cl.awakelab.Grupal6M6.web.service.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiRestTesting {

    private final CapacitacionService service;

    public ApiRestTesting(CapacitacionService service) {
        this.service = service;

    }

    @PostMapping("/create")
    public ResponseEntity<Capacitacion> create(@RequestBody Capacitacion capacitacion){
        return service.create(capacitacion)
                .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Capacitacion>> findAll(){
        return service.findAll()
                .map(accidentes -> new ResponseEntity<>(accidentes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}

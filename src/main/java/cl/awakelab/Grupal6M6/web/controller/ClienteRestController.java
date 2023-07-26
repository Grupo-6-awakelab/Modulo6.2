package cl.awakelab.Grupal6M6.web.controller;


import cl.awakelab.Grupal6M6.model.domain.dto.Capacitacion;
import cl.awakelab.Grupal6M6.model.domain.dto.Cliente;
import cl.awakelab.Grupal6M6.web.service.CapacitacionService;
import cl.awakelab.Grupal6M6.web.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {

 private final ClienteService service;

    public ClienteRestController( ClienteService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> findAll(){
        return service.findAll()
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

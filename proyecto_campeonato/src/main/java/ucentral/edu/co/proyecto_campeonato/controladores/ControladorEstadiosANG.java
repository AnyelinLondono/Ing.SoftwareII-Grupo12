package ucentral.edu.co.proyecto_campeonato.controladores;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ucentral.edu.co.proyecto_campeonato.dto.EstadioDto;
import ucentral.edu.co.proyecto_campeonato.servicios.ServicioEstadios;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/estadios")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})

public class ControladorEstadiosANG {
    private static final Logger logger = LogManager.getLogger(ControladorEstadios.class);


    private ServicioEstadios servicioEstadios;

    @GetMapping("/")
    public ResponseEntity<List<EstadioDto>> listarEstadios(){

        return ResponseEntity.ok(servicioEstadios.obtenerEstadios());
    }

    @GetMapping("/{serial}")
    public ResponseEntity<EstadioDto> obtenerPorId(@PathVariable("serial") Long serial) {
        log.info( " Ïngresa serial "+ serial);
        return ResponseEntity.ok(servicioEstadios.obtenerEstadio(serial));
    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EstadioDto> crear(@Validated @RequestBody EstadioDto entityDto) {
        entityDto = servicioEstadios.registrar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }
    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EstadioDto> modificar(@Validated @RequestBody EstadioDto entityDto) {
        entityDto = servicioEstadios.actualizar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrado(@PathVariable("serial") Long serial) {

        servicioEstadios.eliminar(serial);
    }

}

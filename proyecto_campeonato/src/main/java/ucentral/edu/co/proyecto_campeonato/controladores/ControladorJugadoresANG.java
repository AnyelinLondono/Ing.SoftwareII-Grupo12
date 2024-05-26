package ucentral.edu.co.proyecto_campeonato.controladores;


import ucentral.edu.co.proyecto_campeonato.dto.JugadorDto;
import ucentral.edu.co.proyecto_campeonato.servicios.ServicioJugadores;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/jugadores")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})

public class ControladorJugadoresANG {
    private static final Logger logger = LogManager.getLogger(ControladorJugadores.class);


    private ServicioJugadores servicioJugadores;

    @GetMapping("/")
    public ResponseEntity<List<JugadorDto>> listarJugadores(){

        return ResponseEntity.ok(servicioJugadores.obtenerJugadores());
    }

    @GetMapping("/{serial}")
    public ResponseEntity<JugadorDto> obtenerPorId(@PathVariable("serial") Long serial) {
        log.info( " Ïngresa serial "+ serial);
        return ResponseEntity.ok(servicioJugadores.obtenerJugador(serial));
    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<JugadorDto> crear(@Validated @RequestBody JugadorDto entityDto) {
        entityDto = servicioJugadores.registrar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }
    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<JugadorDto> modificar(@Validated @RequestBody JugadorDto entityDto) {
        entityDto = servicioJugadores.actualizar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrado(@PathVariable("serial") Long serial) {

        servicioJugadores.eliminar(serial);
    }

}

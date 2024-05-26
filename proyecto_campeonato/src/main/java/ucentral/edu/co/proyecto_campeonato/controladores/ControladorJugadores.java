package ucentral.edu.co.proyecto_campeonato.controladores;

import ucentral.edu.co.proyecto_campeonato.dto.JugadorDto;
import ucentral.edu.co.proyecto_campeonato.servicios.ServicioJugadores;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladorJugadores {
    private static final Logger logger = LogManager.getLogger(ControladorJugadores.class);

    @Autowired
    ServicioJugadores servicioJugadores;

    @GetMapping({  "/jugadores"})
    public String listarJugadores(Model model){
        logger.info("Verificando ");
        model.addAttribute("jugadores",servicioJugadores.obtenerJugadores());
        return "jugadores";
    }
    @GetMapping("/jugadores/nuevo")
    public String mostrarFormulario(Model model){
        JugadorDto jugadorDto = new JugadorDto();
        model.addAttribute("jugador", jugadorDto);
        return "crear_jugador";
    }
    @PostMapping("/jugadores")
    public String registrarJugadores(@ModelAttribute("jugador") JugadorDto jugador) {
        servicioJugadores.registrar(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/jugadores/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        JugadorDto jugadorDto = servicioJugadores.obtenerJugador(serial);
        model.addAttribute("jugador", jugadorDto);
        return "editar_jugador";
    }


    @PostMapping("/jugadores/{serial}")
    public String modificarJugador(@PathVariable long serial,@ModelAttribute( "jugador") JugadorDto jugadorDto, Model model){


        model.addAttribute("jugador", servicioJugadores.actualizar(jugadorDto));
        return "redirect:/jugadores";
    }
    @GetMapping("/jugadores/{serial}")
    public String eliminarJugador(@PathVariable long serial){

        servicioJugadores.eliminar(serial);

        return "redirect:/jugadores";
    }
}

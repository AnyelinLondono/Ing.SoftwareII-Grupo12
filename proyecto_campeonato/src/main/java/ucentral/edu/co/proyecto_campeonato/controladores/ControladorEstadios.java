package ucentral.edu.co.proyecto_campeonato.controladores;

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
import ucentral.edu.co.proyecto_campeonato.dto.EstadioDto;
import ucentral.edu.co.proyecto_campeonato.servicios.ServicioEstadios;

@Log4j2
@Controller
public class ControladorEstadios {
    private static final Logger logger = LogManager.getLogger(ControladorEstadios.class);

    @Autowired
    ServicioEstadios servicioEstadios;

    @GetMapping({  "/estadios"})
    public String listarEstadios(Model model){
        logger.info("Verificando ");
        model.addAttribute("estadios",servicioEstadios.obtenerEstadios());
        return "estadios";
    }
    @GetMapping("/estadios/nuevo")
    public String mostrarFormulario(Model model){
        EstadioDto estadioDto = new EstadioDto();
        model.addAttribute("estadio", estadioDto);
        return "crear_estadio";
    }
    @PostMapping("/estadios")
    public String registrarEstadios(@ModelAttribute("estadio") EstadioDto estadio) {
        servicioEstadios.registrar(estadio);
        return "redirect:/estadios";
    }

    @GetMapping("/estadios/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        EstadioDto estadioDto = servicioEstadios.obtenerEstadio(serial);
        model.addAttribute("estadio", estadioDto);
        return "editar_estadio";
    }


    @PostMapping("/estadios/{serial}")
    public String modificarEstadio(@PathVariable long serial,@ModelAttribute( "estadio") EstadioDto estadioDto, Model model){


        model.addAttribute("estadio", servicioEstadios.actualizar(estadioDto));
        return "redirect:/estadios";
    }
    @GetMapping("/estadios/{serial}")
    public String eliminarEStadio(@PathVariable long serial){

        servicioEstadios.eliminar(serial);

        return "redirect:/estadios";
    }
}

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
import ucentral.edu.co.proyecto_campeonato.dto.EquipoDto;
import ucentral.edu.co.proyecto_campeonato.servicios.ServicioEquipos;

@Log4j2
@Controller
public class ControladorEquipos {
    private static final Logger logger = LogManager.getLogger(ControladorEquipos.class);

    @Autowired
    ServicioEquipos servicioEquipos;

    @GetMapping({  "/equipos"})
    public String listarEquipos(Model model){
        logger.info("Verificando ");
        model.addAttribute("equipos",servicioEquipos.obtenerEquipos());
        return "equipos";
    }
    @GetMapping("/equipos/nuevo")
    public String mostrarFormulario(Model model){
        EquipoDto equipoDto = new EquipoDto();
        model.addAttribute("equipo", equipoDto);
        return "crear_equipo";
    }
    @PostMapping("/equipos")
    public String registrarEquipos(@ModelAttribute("equipos") EquipoDto equipo) {
        servicioEquipos.registrar(equipo);
        return "redirect:/equipos";
    }

    @GetMapping("/equipos/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        EquipoDto equipoDto = servicioEquipos.obtenerEquipo(serial);
        model.addAttribute("equipo", equipoDto);
        return "editar_equipo";
    }


    @PostMapping("/equipos/{serial}")
    public String modificarEquipo(@PathVariable long serial,@ModelAttribute( "equipo") EquipoDto equipoDto, Model model){


        model.addAttribute("equipo", servicioEquipos.actualizar(equipoDto));
        return "redirect:/equipos";
    }
    @GetMapping("/equipos/{serial}")
    public String eliminarEquipo(@PathVariable long serial){

        servicioEquipos.eliminar(serial);

        return "redirect:/equipos";
    }
}

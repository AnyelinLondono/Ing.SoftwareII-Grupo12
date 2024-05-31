package ucentral.edu.co.proyecto_campeonato.servicios;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import ucentral.edu.co.proyecto_campeonato.dto.EquipoDto;
import ucentral.edu.co.proyecto_campeonato.entidades.Equipo;
import ucentral.edu.co.proyecto_campeonato.exception.ResourceNotFoundException;
import ucentral.edu.co.proyecto_campeonato.repositorios.RespositorioEquipo;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioEquipos implements Serializable {


    private ModelMapper modelMapper;

    private final RespositorioEquipo repoEquipo;

    public EquipoDto registrar(EquipoDto equipoDto) {

        Equipo elEquipo = repoEquipo.save(modelMapper.map(equipoDto, Equipo.class));
        return modelMapper.map(elEquipo, EquipoDto.class);
    }
    public List<EquipoDto> obtenerEquipos() {
        TypeToken<List<EquipoDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoEquipo.findAll(), typeToken.getType());

    }
    public EquipoDto obtenerEquipo(long serial) {
        Equipo equipo = repoEquipo.findById(serial).orElseThrow(
            ResourceNotFoundException::new);

        return modelMapper.map(equipo, EquipoDto.class);

    }
    public EquipoDto actualizar(EquipoDto equipoDto) {
        repoEquipo.save(modelMapper.map(equipoDto, Equipo.class));
        return equipoDto;

    }
    public void eliminar(long serial) {

        repoEquipo.deleteById(serial);


    }
}

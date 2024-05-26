package ucentral.edu.co.proyecto_campeonato.servicios;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import ucentral.edu.co.proyecto_campeonato.dto.EstadioDto;
import ucentral.edu.co.proyecto_campeonato.entidades.Estadio;
import ucentral.edu.co.proyecto_campeonato.exception.ResourceNotFoundException;
import ucentral.edu.co.proyecto_campeonato.repositorios.RespositorioEstadio;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioEstadios implements Serializable {


    private ModelMapper modelMapper;

    private final RespositorioEstadio repoEstadio;

    public EstadioDto registrar(EstadioDto estadioDto) {

        Estadio elEstadio = repoEstadio.save(modelMapper.map(estadioDto, Estadio.class));
        return modelMapper.map(elEstadio, EstadioDto.class);
    }
    public List<EstadioDto> obtenerEstadios() {
        TypeToken<List<EstadioDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoEstadio.findAll(), typeToken.getType());

    }
    public EstadioDto obtenerEstadio(long serial) {
        Estadio estadio = repoEstadio.findById(serial).orElseThrow(
            ResourceNotFoundException::new);

        return modelMapper.map(estadio, EstadioDto.class);

    }
    public EstadioDto actualizar(EstadioDto estadioDto) {
        repoEstadio.save(modelMapper.map(estadioDto, Estadio.class));
        return estadioDto;

    }
    public void eliminar(long serial) {

        repoEstadio.deleteById(serial);


    }
}

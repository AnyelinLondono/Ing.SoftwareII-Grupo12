package ucentral.edu.co.proyecto_campeonato.servicios;

import ucentral.edu.co.proyecto_campeonato.dto.JugadorDto;
import ucentral.edu.co.proyecto_campeonato.entidades.Jugador;
import ucentral.edu.co.proyecto_campeonato.exception.ResourceNotFoundException;
import ucentral.edu.co.proyecto_campeonato.repositorios.RespositorioJugador;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioJugadores implements Serializable {


    private ModelMapper modelMapper;

    private final RespositorioJugador repoJugador;

    public JugadorDto registrar(JugadorDto jugadorDto) {

        Jugador elJugador = repoJugador.save(modelMapper.map(jugadorDto, Jugador.class));
        return modelMapper.map(elJugador, JugadorDto.class);
    }
    public List<JugadorDto> obtenerJugadores() {
        TypeToken<List<JugadorDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoJugador.findAll(), typeToken.getType());

    }
    public JugadorDto obtenerJugador(long serial) {
        Jugador jugador = repoJugador.findById(serial).orElseThrow(
            ResourceNotFoundException::new);

        return modelMapper.map(jugador, JugadorDto.class);

    }
    public JugadorDto actualizar(JugadorDto jugadorDto) {
        repoJugador.save(modelMapper.map(jugadorDto, Jugador.class));
        return jugadorDto;

    }
    public void eliminar(long serial) {

        repoJugador.deleteById(serial);


    }
}

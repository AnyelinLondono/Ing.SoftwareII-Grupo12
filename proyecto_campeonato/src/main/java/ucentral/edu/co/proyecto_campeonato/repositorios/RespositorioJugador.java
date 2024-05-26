package ucentral.edu.co.proyecto_campeonato.repositorios;

import ucentral.edu.co.proyecto_campeonato.entidades.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RespositorioJugador extends JpaRepository<Jugador, Long>, JpaSpecificationExecutor<Jugador> {

}

package ucentral.edu.co.proyecto_campeonato.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ucentral.edu.co.proyecto_campeonato.entidades.Estadio;

public interface RespositorioEstadio extends JpaRepository<Estadio, Long>, JpaSpecificationExecutor<Estadio> {

}

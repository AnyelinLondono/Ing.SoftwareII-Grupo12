package ucentral.edu.co.proyecto_campeonato.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ucentral.edu.co.proyecto_campeonato.entidades.Equipo;

public interface RespositorioEquipo extends JpaRepository<Equipo, Long>, JpaSpecificationExecutor<Equipo> {

}

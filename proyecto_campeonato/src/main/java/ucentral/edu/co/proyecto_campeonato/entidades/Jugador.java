package ucentral.edu.co.proyecto_campeonato.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Jugadores")
@Table(name = "JUGADORES")
public class Jugador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_JUGADORES")
    @SequenceGenerator(name = "SEQ_EQUIPOS", sequenceName = "SEQ_JUGADORES", allocationSize = 1)
    @Column(name = "JUG_CODIGO", nullable = false)
    private long serial;

    @Column(name = "JUG_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "JUG_POSICION", nullable = false)
    private String posicion;

    @Column(name = "JUG_FECHA", nullable = false)
    private String fecha;

    @Column(name = "JUG_EQUIPO", nullable = false)
    private String equipo;
}

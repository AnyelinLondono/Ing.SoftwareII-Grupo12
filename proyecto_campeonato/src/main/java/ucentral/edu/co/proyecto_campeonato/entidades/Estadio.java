package ucentral.edu.co.proyecto_campeonato.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Estadios")
@Table(name = "ESTADIOS")
public class Estadio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTADIOS")
    @SequenceGenerator(name = "SEQ_ESTADIOS", sequenceName = "SEQ_ESTADIOS", allocationSize = 1)
    @Column(name = "EST_CODIGO", nullable = false)
    private long serial;

    @Column(name = "EST_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "EST_UBICACION", nullable = false)
    private String ubicacion;

    @Column(name = "EST_CAPACIDAD", nullable = false)
    private int capacidad;

    @Column(name = "EST_EQUIPOS", nullable = false)
    private String equipos;
}

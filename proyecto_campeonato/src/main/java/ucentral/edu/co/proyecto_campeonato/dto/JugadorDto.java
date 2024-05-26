package ucentral.edu.co.proyecto_campeonato.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class JugadorDto implements Serializable{
    private long serial;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "La posición es obligatoria")
    private String posicion;
    @NotBlank(message = "La descripción es obligatoria")
    private String fecha;
    @NotBlank(message = "La descripción es obligatoria")
    private String equipo;
}

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
public class EstadioDto implements Serializable{
    private long serial;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "La ubicación es obligatoria")
    private String ubicacion;
    @NotBlank(message = "La capacidad es obligatoria")
    private int capacidad;
    @NotBlank(message = "Los equipos son obligatorios")
    private String equipos;
}

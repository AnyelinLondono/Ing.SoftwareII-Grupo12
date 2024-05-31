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
public class EquipoDto implements Serializable{
    private long serial;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El uniforme es obligatorio")
    private String uniforme;
    @NotBlank(message = "El tecnico es obligatorio")
    private String tecnico;
    @NotBlank(message = "La direccion es obligatoria")
    private String direccion;
    @NotBlank(message = "El estadio es obligatorio")
    private String estadio;
}

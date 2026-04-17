package cl.duoc.start_up.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "nombreCompleto", "tiempoExperiencia", "sueldo", "especialidad" })
public class TrabajadorDTO {

    private Long id;
    private String nombreCompleto;
    private String tiempoExperiencia;
    private String sueldo;
    private String especialidad;
    private String nombreDepartamento;

}

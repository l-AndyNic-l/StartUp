package cl.duoc.start_up.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "codigo, nombre, descripcion" })
public class DepartamentoDTO {
    private String codigo;
    private String nombre;
    private String descripcion;

}

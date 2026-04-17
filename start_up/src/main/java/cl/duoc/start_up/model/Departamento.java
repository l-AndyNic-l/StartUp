package cl.duoc.start_up.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Departamento {
    @Id
    @Size(min = 4, max = 4, message = "El código debe tener 4 caracteres.")
    private String codigo;

    @NotBlank(message = "El campo nombre no puede estar vacío.")
    @Column (length = 30, nullable = false)
    private String nombre;

    @Column (length = 50)
    private String descripcion;
}

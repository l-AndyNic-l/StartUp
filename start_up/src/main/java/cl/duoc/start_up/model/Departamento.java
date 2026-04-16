package cl.duoc.start_up.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Departamento {
    @Id
    @Column (length = 4, nullable = false)
    private String codigo;
    @Column (length = 30, nullable = false)
    private String nombre;
    @Column (length = 50)
    private String descripcion;
}

package cl.duoc.start_up.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trabajador {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( nullable = false )
    private Long id;

    @Column( nullable = false )
    private String nombre;

    @Column( nullable = false )
    private String apellido;

    @Email
    @Column( unique = true, nullable = false )
    private String email;

    @Column( nullable = false )
    private LocalDate fechaContrato;

    private String especialidad;

    @Min( value = 0 )
    private int sueldo;

    @Value( "${0}" )
    private int cargaFamiliar;

    @ManyToOne
    @JoinColumn( name = "codigo_departamento" )
    private Departamento departamento;

}

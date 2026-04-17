package cl.duoc.start_up.repository;

import cl.duoc.start_up.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrabajadorRepository extends JpaRepository <Trabajador, Long> {

    Trabajador findByEmail( String email );

    List<Trabajador> findAllByEspecialidad( String especialidad );

    List<Trabajador> findAllByDepartamento_Codigo( String departamentoCodigo );

    @Query( value = "SELECT * FROM trabajador WHERE suelo > :sld", nativeQuery = true )
    List<Trabajador> findSueldoMayor( @Param( "sld" ) int sld );

    @Query( value = "SELECT * FROM trabajador WHERE suelo < :sld", nativeQuery = true )
    List<Trabajador> findSueldoMenor( @Param( "sld" ) int sld );

    @Query( value = "SELECT * FROM trabajador WHERE suelo BETWEEN :sld_a AND :sld_b", nativeQuery = true )
    List<Trabajador> findSueldoEntre( @Param( "sld_a" ) int sld_a, @Param( "sld_b" ) int sld_b );

    @Query( value = "SELECT * FROM trabajador WHERE TIMESTAMPDIFF(YEAR, fecha_contrato, CURDATE()) = :experiencia", nativeQuery = true )
    List<Trabajador> findAllExperiencia( @Param("experiencia" ) int experiencia);

    @Query( value = "SELECT COALESCE( SUM( sueldo ), 0) FROM trabajador WHERE codigo_departamento = :cod", nativeQuery = true )
    int findSueldoDepartamento( @Param( "cod" ) String cod );
}

package cl.duoc.start_up.repository;

import cl.duoc.start_up.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajadorRepository extends JpaRepository <Trabajador, Long> {
}

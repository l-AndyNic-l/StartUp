package cl.duoc.start_up.repository;

import cl.duoc.start_up.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, String> {
}

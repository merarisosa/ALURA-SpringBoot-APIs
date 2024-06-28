package med.voll.api.repository;

import med.voll.api.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findByIsActivoTrue();
}

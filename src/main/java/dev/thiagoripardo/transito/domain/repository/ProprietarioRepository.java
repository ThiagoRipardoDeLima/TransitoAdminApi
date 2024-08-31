package dev.thiagoripardo.transito.domain.repository;

import dev.thiagoripardo.transito.domain.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {

    public List<Proprietario> findByNomeContaining(String nome);
    Optional<Proprietario> findByEmail(String email);

}

package wdefassio.io.rinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wdefassio.io.rinha.entity.Pessoa;

import java.util.List;
import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

    @Query(value = "SELECT * FROM Pessoa x WHERE x.apelido LIKE %?1% OR x.nome LIKE %?1% OR x.stack LIKE %?1% LIMIT 50", nativeQuery = true)
    List<Pessoa> findByT(String t);
}

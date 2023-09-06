package wdefassio.io.rinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wdefassio.io.rinha.entity.Pessoa;

import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
}

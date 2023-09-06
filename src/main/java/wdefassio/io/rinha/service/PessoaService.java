package wdefassio.io.rinha.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wdefassio.io.rinha.entity.Pessoa;
import wdefassio.io.rinha.repository.PessoaRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;


    public Pessoa createPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa getPessoa(UUID id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(RuntimeException::new);
        return pessoa;
    }

    public List<Pessoa> getByT(String t) {

        return pessoaRepository.findByT(t);

    }
}

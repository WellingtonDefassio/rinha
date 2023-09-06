package wdefassio.io.rinha.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wdefassio.io.rinha.entity.Pessoa;
import wdefassio.io.rinha.repository.PessoaRepository;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;


    public Pessoa createPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

}

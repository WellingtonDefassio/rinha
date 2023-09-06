package wdefassio.io.rinha.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wdefassio.io.rinha.repository.PessoaRepository;

@RequestMapping
@RequiredArgsConstructor
@RestController
public class ContagemPessoa {

    private final PessoaRepository pessoaRepository;
    @GetMapping("/contagem-pessoas")
    public Long contaPessoas() {
        return pessoaRepository.count();
    }
}

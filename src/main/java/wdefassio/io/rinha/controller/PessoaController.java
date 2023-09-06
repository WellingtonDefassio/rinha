package wdefassio.io.rinha.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import wdefassio.io.rinha.controller.dto.PessoaRequest;
import wdefassio.io.rinha.entity.Pessoa;
import wdefassio.io.rinha.service.PessoaService;

@RestController()
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Validated PessoaRequest request) {
        try {
            Pessoa toPessoa = request.toPessoa();
            Pessoa pessoa = pessoaService.createPessoa(toPessoa);
            return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri()).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}

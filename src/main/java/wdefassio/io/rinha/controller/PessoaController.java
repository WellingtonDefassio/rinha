package wdefassio.io.rinha.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import wdefassio.io.rinha.controller.dto.PessoaRequest;
import wdefassio.io.rinha.entity.Pessoa;
import wdefassio.io.rinha.service.PessoaService;

import java.util.UUID;

@RestController()
@RequestMapping("/pessoas")
@RequiredArgsConstructor
@Slf4j
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

    @GetMapping()
    public ResponseEntity<?> get(@RequestParam UUID id) {
        try {
            log.info("{}",id);
            Pessoa pessoa = pessoaService.getPessoa(id);
            return ResponseEntity.ok(pessoa);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(params = "t")
    public ResponseEntity<?> getTermos(@RequestParam String t) {
       return ResponseEntity.ok(pessoaService.getByT(t));
    }


}

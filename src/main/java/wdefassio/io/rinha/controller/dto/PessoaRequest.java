package wdefassio.io.rinha.controller.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import wdefassio.io.rinha.entity.Pessoa;

import java.util.Date;
import java.util.Set;

@Data
public class PessoaRequest {

    @NotBlank
    @Size(min = 1, max = 32)
    private String apelido;
    @NotBlank
    @Size(max = 100)
    private String nome;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @NotNull
    private Date nascimento;
    private Set<String> stack;

    public Pessoa toPessoa() {
        return new Pessoa(null, apelido, nome, nascimento, stack.toString());
    }
}

package wdefassio.io.rinha.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    @Size(min = 1, max = 32)
    @Column(unique = true)
    private String apelido;
    @NotBlank
    @Size(max = 100)
    private String nome;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date nascimento;

    private String stack;
    
}

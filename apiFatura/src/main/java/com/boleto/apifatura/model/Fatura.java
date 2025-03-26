package com.boleto.apifatura.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "faturas")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Numero do cartão não pode estar em branco")
    @Pattern(regexp = "\\d{16}", message="O numero do cartão deve conter 16 caracteres.")
    private String numeroCartao;

    @NotBlank(message = "O nome do titular não pode estar em branco.")
    @Size(min = 3, max = 100, message = "O nome do titular deve possuir entre 3 e 100 caracteres.")
    private String nomeTitular;

    @NotNull(message = "O valor não pode estar em branco.")
    @DecimalMin(value = "10.00", message = "O valor minimo é de 10 reais")
    @DecimalMax(value = "5000.00", message = "O valor maximo é de 5 mil")
    private Double valor;

    @NotNull(message = "A data não pode ser nula.")
    @FutureOrPresent(message = "A data de vencimento deve ser a data atual ou futura.")
    private LocalDate dataVencimento;

    @NotBlank(message = "O email nao pode estar em branco.")
    @Email(message = "O e-mail deve ser valido.")
    private String email;
}

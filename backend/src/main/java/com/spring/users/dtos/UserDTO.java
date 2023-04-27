package com.spring.users.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Size(min = 3, max = 100, message = "Nome deve ter tamanho mínimo 3 e máximo 100.")
    private String name;

    @Size(min = 5, max = 100, message = "Email deve ter tamanho mínimo 3 e máximo 100.")
    private String email;

    @Size(min = 7, max = 75, message = "Telefone deve ter tamanho mínimo 7 e máximo 45.")
    private String phone;

    @NotNull(message = "Data de nascimento não pode ser nulo.")
    @Past(message = "Data de nascimento deve ser uma data antiga.")
    private LocalDate birthday;

}

package com.Portfolio.app.Dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


   
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;
}

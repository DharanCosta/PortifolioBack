package com.portifoliodharan.dharanportifolio.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDto {
    @NotBlank
    @Email
    private String ownerRef;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;
}

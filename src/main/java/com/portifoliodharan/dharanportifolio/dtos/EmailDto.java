package com.portifoliodharan.dharanportifolio.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDto {
    @NotBlank
    @Email
    private String ownerMail;
    @NotBlank
    private String ownerName;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;
}

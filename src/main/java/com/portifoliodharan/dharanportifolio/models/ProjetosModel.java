package com.portifoliodharan.dharanportifolio.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "bd_projetos")
public class ProjetosModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Chave-primária
    private long id;

    @NotNull(message = "O atributo nome é obrigatório.")
    @Column(name = "name")
    @Size(min=2, max=200)
    private String name;

    @NotNull(message = "O atributo descrição é obrigatório.")
    @Column(name = "descrição")
    @Size(min=10, max=1000)
    private String description;

//    @NotBlank(message = "Infome a data de conclusão do projeto")
//////    @Temporal(TemporalType.TIMESTAMP)
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private LocalDate data;

    @Column(name="linkRepo")
    @Size(min=0, max=1000)
    private String link;

    @ManyToOne
//    @Column(name = "id_user")
    @JsonIgnoreProperties("projetos")
    private UserModel user;

    @ManyToOne
//    @Column(name = "id_tema")
    @JsonIgnoreProperties("projetosModels")
    private ThemeModel themeModel;

    public ProjetosModel(){}

    public ProjetosModel(long id, String name, String description, String link, UserModel user, ThemeModel themeModel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.link= link;
        this.user = user;
        this.themeModel = themeModel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() { return link; }

    public void setLink(String link) { this.link = link; }

    //    public LocalDate getData() {
//        return data;
//    }
//
//    public void setData(LocalDate data) {
//        this.data = data;
//    }

    public UserModel getUser() { return user; }

    public void setUser(UserModel user) { this.user = user; }

    public ThemeModel getThemeModel() { return themeModel; }

    public void setThemeModel(ThemeModel themeModel) { this.themeModel = themeModel;}



}

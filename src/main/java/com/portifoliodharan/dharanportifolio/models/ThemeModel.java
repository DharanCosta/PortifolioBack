package com.portifoliodharan.dharanportifolio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "bd_projetos_themes")
public class ThemeModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "linguagem")
    private String linguagem;
    @Column(name = "framework")
    private String frameworks;
    @OneToMany(mappedBy = "themeModel", cascade = CascadeType.ALL)
    @Column(name = "projetos")
    @JsonIgnoreProperties("themeModel")
    private List<ProjetosModel> projetosModels;

    public ThemeModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public String getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(String frameworks) {
        this.frameworks = frameworks;
    }

    public List<ProjetosModel> getProjetosModels() {
        return projetosModels;
    }

    public void setProjetosModels(List<ProjetosModel> projetosModels) {
        this.projetosModels = projetosModels;
    }
}

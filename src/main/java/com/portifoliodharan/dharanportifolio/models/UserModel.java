package com.portifoliodharan.dharanportifolio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name= "db_user")
public class UserModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "O atributo nome é obrigatório.")
    @Column(name = "name")
    @Size(min =2, max=100)
    private String name;
    @NotNull(message = "O atributo usuário é OBRIGATÓRIO.")
    @Column(name = "user")
    @Size(min =2, max=50)
    private String user;
    @NotNull
    @Column(name = "password")
//    @Size(min=4, max=20,  message = "A senha deve ter no mínimo 4 caracteres")
    private String password;

    @OneToMany(mappedBy="user", cascade=CascadeType.REMOVE)
    @JsonIgnoreProperties("user")
    private List<ProjetosModel> projetos;
    public UserModel(){
    }
    public UserModel(long id, String name, String user, String password) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.password = password;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ProjetosModel> getProjetos() { return projetos; }

    public void setProjetos(List<ProjetosModel> projetos) { this.projetos = projetos; }
}

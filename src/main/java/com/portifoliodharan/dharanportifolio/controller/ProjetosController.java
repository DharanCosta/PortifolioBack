package com.portifoliodharan.dharanportifolio.controller;

import com.portifoliodharan.dharanportifolio.models.ProjetosModel;
import com.portifoliodharan.dharanportifolio.models.ThemeModel;
import com.portifoliodharan.dharanportifolio.models.UserModel;
import com.portifoliodharan.dharanportifolio.repository.ProjetosRepository;
import com.portifoliodharan.dharanportifolio.repository.ThemeRepository;
import com.portifoliodharan.dharanportifolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
//@Tag(name = "Projetos", description = "Administração do projetos cadastrados no sistema") Swagger
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjetosController {
    @Autowired
    private ProjetosRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ThemeRepository themeRepository;


    @GetMapping
    public ResponseEntity<List<ProjetosModel>> getAll(){
        List<ProjetosModel> list = repository.findAll();
        if(list.isEmpty()){
            return ResponseEntity.status(204).build();
        }else {
            return ResponseEntity.ok(repository.findAll());
        }
    }

    @PostMapping
    public ResponseEntity<ProjetosModel> postProject(@RequestBody ProjetosModel projeto){
        return ResponseEntity.ok(repository.save(projeto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetosModel> putProject(@PathVariable long id, @RequestBody ProjetosModel projeto){
        ProjetosModel upProject = repository.findById(id).orElseThrow();
        upProject.setName(projeto.getName());
        upProject.setDescription(projeto.getDescription());
        upProject.setLink(projeto.getLink());
        upProject.setThemeModel(projeto.getThemeModel());
        repository.save(upProject);
        return ResponseEntity.ok(upProject);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable long id) {
        String projectName = repository.findById(id).get().getName();
        try {
            repository.deleteById(id);
            return "Projeto: " + projectName + " foi apagado com sucesso";
        } catch (Exception e) {
            return "Id: " + projectName + " não encontrado";
        }
    }
}

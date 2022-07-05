package com.portifoliodharan.dharanportifolio.controller;

import com.portifoliodharan.dharanportifolio.models.ProjetosModel;
import com.portifoliodharan.dharanportifolio.models.ThemeModel;
import com.portifoliodharan.dharanportifolio.repository.ProjetosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/projetos")
//@Tag(name = "Projetos", description = "Administração do projetos cadastrados no sistema") Swagger
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjetosController {
    @Autowired
    private ProjetosRepository repository;


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
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(projeto));
    }

    @PutMapping
    public ResponseEntity<ProjetosModel> putProject(@RequestBody ProjetosModel projeto){
        return ResponseEntity.ok(repository.save(projeto));
    }
}

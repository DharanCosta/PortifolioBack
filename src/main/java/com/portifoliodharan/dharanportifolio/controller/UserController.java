package com.portifoliodharan.dharanportifolio.controller;

import com.portifoliodharan.dharanportifolio.models.UserLoginModel;
import com.portifoliodharan.dharanportifolio.models.UserModel;
import com.portifoliodharan.dharanportifolio.repository.UserRepository;
import com.portifoliodharan.dharanportifolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository repository;

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> findAll(){
        List<UserModel> list = repository.findAll();
        if(list.isEmpty()){
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.ok(repository.findAll());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getById(@PathVariable long id){
        return repository.findById(id).map(resp-> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserModel>> getByNome (@PathVariable("name") String name){
        return ResponseEntity.ok(repository.findAllByNameContainingIgnoreCase(name));
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginModel> Autentication (@RequestBody Optional<UserLoginModel> user){
        return userService.logar(user).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/signin")
    public ResponseEntity<UserModel> post(@RequestBody UserModel user) {
        return userService.cadastroUser(user).map(resp -> ResponseEntity.status(201).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
    @PutMapping("/update")
    public ResponseEntity<UserModel> put(@RequestBody UserModel user) {
        return ResponseEntity.status(201).body(repository.save(user));
//                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteById(id);
    }

}

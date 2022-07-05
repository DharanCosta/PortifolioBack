package com.portifoliodharan.dharanportifolio.service;
import com.portifoliodharan.dharanportifolio.models.UserLoginModel;
import com.portifoliodharan.dharanportifolio.models.UserModel;
import com.portifoliodharan.dharanportifolio.repository.UserRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotNull;
import java.nio.charset.Charset;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public Optional<UserModel> cadastroUser(UserModel user){
        Optional<UserModel> optional = repository.findByUser(user.getUser());
        if(optional.isPresent()){
            return Optional.empty();
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaEncoder = encoder.encode(user.getPassword());
        user.setPassword(senhaEncoder);
        return Optional.ofNullable(repository.save(user));
    }

    public Optional<UserModel> updateUser(UserModel user){
        if (repository.findById(user.getId()).isPresent()){
            Optional<UserModel> buscarUser = repository.findByUser(user.getUser());
            if(buscarUser.isPresent()){
                if(buscarUser.get().getId() != user.getId())
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"O Usuário já existe", null);
            }
            user.setPassword(criptografarSenha(user.getPassword()));
            return Optional.of(repository.save(user));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado", null);
    }

    public Optional<UserLoginModel> logar(Optional<UserLoginModel> user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Optional <UserModel> usuario = repository.findByUser(user.get().getUser());

        if(usuario.isPresent()) {
            if(encoder.matches(user.get().getPassword(), usuario.get().getPassword())) {
                String auth = user.get().getUser() + ":" + user.get().getPassword();
                byte[] encoderAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encoderAuth);

                user.get().setToken(authHeader);
                user.get().setId(usuario.get().getId());
                user.get().setName(usuario.get().getName());
                user.get().setUser(usuario.get().getUser());
                user.get().setPassword(usuario.get().getPassword());

                return user;
            }
        }
        return null;
    }

    private String criptografarSenha(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}

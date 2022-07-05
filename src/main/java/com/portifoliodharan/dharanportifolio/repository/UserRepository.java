package com.portifoliodharan.dharanportifolio.repository;

import com.portifoliodharan.dharanportifolio.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <UserModel, Long> {
    public List<UserModel> findAllByNameContainingIgnoreCase(String nome);
    public Optional<UserModel> findByUser(String user);

}

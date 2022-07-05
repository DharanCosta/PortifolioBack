package com.portifoliodharan.dharanportifolio.repository;

import com.portifoliodharan.dharanportifolio.models.ProjetosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetosRepository extends JpaRepository<ProjetosModel, Long> {
    public List<ProjetosModel> findAllByNameContainingIgnoreCase(String name);


}

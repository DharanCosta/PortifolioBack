package com.portifoliodharan.dharanportifolio.repository;

import com.portifoliodharan.dharanportifolio.models.ThemeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThemeRepository extends JpaRepository<ThemeModel, Long> {
    public List<ThemeModel> findAllByDescricaoContainingIgnoreCase(String descricao);

    public List<ThemeModel> findAllByLinguagemContainingIgnoreCase(String linguagem);
}

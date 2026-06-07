package com.ufide.clase4base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ufide.clase4base.entity.Curso;

public interface CursoRepository
        extends JpaRepository<Curso, Long> {
}
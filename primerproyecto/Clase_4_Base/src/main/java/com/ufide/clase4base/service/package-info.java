/**
 * Capa Service - logica de negocio.
 *
 * En clase 4 se crea aqui:
 *
 *   CursoService.java
 *     package com.ufide.clase4base.service;
 *
 *     import org.springframework.beans.factory.annotation.Autowired;
 *     import org.springframework.stereotype.Service;
 *
 *     import com.ufide.clase4base.entity.Curso;
 *     import com.ufide.clase4base.repository.CursoRepository;
 *
 *     @Service
 *     public class CursoService {
 *
 *         @Autowired
 *         private CursoRepository repo;
 *
 *         public List<Curso> listar() { return repo.findAll(); }
 *         public Optional<Curso> buscarPorId(Long id) { return repo.findById(id); }
 *         public Curso guardar(Curso c) { return repo.save(c); }
 *         public void eliminar(Long id) { repo.deleteById(id); }
 *     }
 *
 * Reglas:
 *  - Coordina las operaciones de negocio.
 *  - Llama al Repository - nunca al reves.
 *  - El Controller NUNCA habla con el Repository directamente,
 *    siempre pasa por el Service.
 *  - Aqui van validaciones, transacciones y orquestacion.
 */
package com.ufide.clase4base.service;

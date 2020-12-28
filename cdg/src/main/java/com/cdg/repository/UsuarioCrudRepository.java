package com.cdg.repository;

import java.util.List;

import com.cdg.entities.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioCrudRepository extends CrudRepository<Usuario, Long> {
    
    List<Usuario> findByNomeContaining(String nome);
}

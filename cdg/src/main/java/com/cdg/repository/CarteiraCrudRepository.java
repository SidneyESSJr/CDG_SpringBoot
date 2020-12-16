package com.cdg.repository;

import com.cdg.entities.Carteira;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraCrudRepository extends CrudRepository<Carteira, Long> {

}

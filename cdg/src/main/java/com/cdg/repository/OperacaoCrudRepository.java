package com.cdg.repository;

import com.cdg.entities.Operacao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacaoCrudRepository extends CrudRepository<Operacao, Long> {

}

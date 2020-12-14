package com.cdg.cdg.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.cdg.cdg.entities.enums.*;
import com.cdg.cdg.entities.exception.TransacaoException;

@Entity
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data = LocalDateTime.now();

    @OneToOne
    private Carteira carteira;

    @OneToOne
    private Usuario usuario;

    private EnumOperacao enumOperacao;

    private String descricao;

    public Operacao() {
    }

    public Operacao(Carteira carteira, Usuario usuario) {
        this.carteira = carteira;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public EnumOperacao getEnumOperacao() {
        return enumOperacao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void retirada(Double vlr) throws TransacaoException {
        if (carteira.retirada(vlr)) {
            enumOperacao = EnumOperacao.RETIRADA;
        } else {
            enumOperacao = EnumOperacao.FALHA;
            throw new TransacaoException();
        }
    }

    public void guardar(Double vlr) throws TransacaoException {
        if (carteira.guardar(vlr)) {
            enumOperacao = EnumOperacao.GUARDAR;
        } else {
            enumOperacao = EnumOperacao.FALHA;
            throw new TransacaoException();
        }
    }

}

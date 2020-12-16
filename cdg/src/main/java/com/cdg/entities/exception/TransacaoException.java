package com.cdg.entities.exception;

public class TransacaoException extends Exception {

    private static final long serialVersionUID = 1L;

    public String getMessage() {
        return "Falha na transação";
    }
}

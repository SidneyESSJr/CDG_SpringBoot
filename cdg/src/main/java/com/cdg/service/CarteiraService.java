package com.cdg.service;

import java.util.Scanner;

public class CarteiraService {

    private Boolean system = true;

    public void menuUsuario(Scanner scan) {

        while (system) {
            System.out.println(" === Menu Usuario ===");
            System.out.println("Selecione uma opção");
            System.out.println(
                    "[1] Criar usuario\n[2] Atualizar funcionario\n[3] Buscar funcionario\n[4] Remover usuario\n[0] Menu principal");
            int menu = scan.nextInt();
            scan.nextLine();
            if (menu != 0) {
                seletor(scan, menu);
            } else {
                system = false;
            }
        }
    }

    private void seletor(Scanner scan, int menu) {
        switch (menu) {
            case 1 -> criar(scan);
            case 2 -> atualizar(scan);
            case 3 -> buscar(scan);
            case 4 -> remover(scan);
            default -> System.out.println("Opção invalida");
        }
    }

    private void criar(Scanner scan) {
    }

    private void atualizar(Scanner scan) {
    }

    private void buscar(Scanner scan) {
    }

    private void remover(Scanner scan) {

    }
}

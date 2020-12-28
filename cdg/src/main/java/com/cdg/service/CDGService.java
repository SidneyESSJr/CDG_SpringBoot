package com.cdg.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class CDGService {

    private final UsuarioService uService;
    private Boolean system = true;

    public CDGService(UsuarioService uService) {
        this.uService = uService;
    }

    public void menu(Scanner scan) {

        while (system) {
            system = true;
            System.out.println("\n === Menu ===");
            System.out.println("Selecione uma opção");
            System.out.print(
                    "[1] Usuario\n[2] Carteira\n[3] Operações\n[0] Sair\nOpção: ");
            try {
                int menu = scan.nextInt();
                scan.nextLine();
                if (menu != 0) {
                    seletor(scan, menu);
                } else {
                    system = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor invalido");
            }
        }
    }

    private void seletor(Scanner scan, int menu) {
        switch (menu) {
            case 1 -> uService.menuUsuario(scan);
            // case 2 -> atualizar(scan);
            // case 3 -> buscar(scan);
            // case 4 -> remover(scan);
            default -> System.out.println("\nOpção invalida");
        }
    }
}

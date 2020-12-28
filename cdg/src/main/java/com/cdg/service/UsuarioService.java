package com.cdg.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.cdg.entities.Usuario;
import com.cdg.repository.UsuarioCrudRepository;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioCrudRepository ucr;
    private Boolean system = true;

    public UsuarioService(UsuarioCrudRepository ucr) {
        this.ucr = ucr;
    }

    public void menuUsuario(Scanner scan) {

        while (system) {
            system = true;
            System.out.println("\n === Menu Usuario ===");
            System.out.println("Selecione uma opção");
            System.out.print(
                    "[1] Criar usuario\n[2] Atualizar funcionario\n[3] Buscar funcionario\n[4] Remover usuario\n[0] Menu principal\nOpção: ");
            try {
                int menu = scan.nextInt();
                scan.nextLine();
                if (menu != 0 || menu > 4 || menu < 0) {
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
            case 1 -> criar(scan);
            case 2 -> atualizar(scan);
            case 3 -> buscar(scan);
            case 4 -> remover(scan);
            default -> System.out.println("\nOpção invalida");
        }
    }

    private void criar(Scanner scan) {
        System.out.println("\n === Criando usuario === ");
        Usuario usuario = new Usuario();
        usuario = dadosUsuario(scan, usuario);

        ucr.save(usuario);

        System.out.print("\nOperação realizada com sucesso!\nEnter para voltar ao menu");
        scan.nextLine();
    }

    private void atualizar(Scanner scan) {
        System.out.println("\n === Atualizando usuario === ");
        if (!buscarPorNome(scan).isEmpty()) {
            System.out.print("\nUsuarioId: ");
            Long id = scan.nextLong();
            scan.nextLine();

            try {
                Usuario usuario = ucr.findById(id.longValue()).get();
                usuario = dadosUsuario(scan, usuario);

                ucr.save(usuario);

                System.out.print("\nOperação realizada com sucesso!\nEnter para voltar ao menu");
                scan.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("\nValor invalido");
            }
        } else {
            System.out.println("\nUsuario não encontrado");
        }

    }

    private void buscar(Scanner scan) {
        System.out.println("\n === Buscar usuario === ");

        System.out.print("[1] Por nome\n[2] UsuarioID\n[3] Listar todos\n[0] Sair\nOpção: ");
        int busca = scan.nextInt();
        scan.nextLine();

        switch (busca) {
            case 1 -> buscarPorNome(scan);
            case 2 -> buscaPorId(scan);
            case 3 -> listarUsuarios(scan);
            default -> System.out.println("\nOpção invalida");
        }
    }

    private Iterable<Usuario> listarUsuarios(Scanner scan) {
        Iterable<Usuario> usuarios = ucr.findAll();

        usuarios.forEach(u -> {
            System.out.println("\nUsuarioID: " + u.getId() + "\nCPF: " + u.getCpf() + "\nNome: " + u.getNome()
                    + "\nEmail: " + u.getEmail());
        });

        System.out.print("\nEnter para continuar");
        scan.nextLine();

        return usuarios;
    }

    private Usuario buscaPorId(Scanner scan) {
        System.out.print("UsuarioID: ");
        Long id = scan.nextLong();
        scan.nextLine();
        Usuario usuario = ucr.findById(id).get();
        System.out.println();

        if (usuario.getId() != null) {

            System.out.println(
                    "CPF: " + usuario.getCpf() + "\nNome: " + usuario.getNome() + "\nEmail: " + usuario.getEmail());

            System.out.print("\nEnter para continuar");
            scan.nextLine();
        } else {
            System.out.println("\nUsuario não identificado");
        }
        return usuario;
    }

    private void remover(Scanner scan) {
        System.out.println("\n === Remover usuario === ");
        Usuario usuario = buscaPorId(scan);

        if (usuario.getId() != null) {
            System.out.print("Deseja remover o usuarioID " + usuario.getId() + " (y/n): ");
            if (scan.nextLine().equalsIgnoreCase("y")) {
                ucr.delete(usuario);

                System.out.print("\nOperação realizada com sucesso!\nEnter para voltar ao menu");
                scan.nextLine();
            } else {
                System.out.print("\nEnter para voltar ao menu");
                scan.nextLine();
            }
        }
    }

    private List<Usuario> buscarPorNome(Scanner scan) {
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        List<Usuario> usuarios = ucr.findByNomeContaining(nome);

        usuarios.forEach(u -> {
            System.out.println("\nUsuarioID: " + u.getId() + "\nCPF: " + u.getCpf() + "\nNome: " + u.getNome()
                    + "\nEmail: " + u.getEmail());
        });

        System.out.print("\nEnter para continuar");
        scan.nextLine();

        return usuarios;
    }

    private Usuario dadosUsuario(Scanner scan, Usuario usuario) {
        System.out.print("Nome: ");
        usuario.setNome(scan.nextLine());
        System.out.print("Email: ");
        usuario.setEmail(scan.nextLine());
        System.out.print("CPF: ");
        usuario.setCpf(scan.nextLine());
        System.out.print("Senha: ");
        usuario.setSenha(scan.nextLine());
        return usuario;
    }
}

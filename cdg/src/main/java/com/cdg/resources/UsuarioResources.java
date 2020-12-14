package com.cdg.cdg.resources;

import com.cdg.cdg.entities.Usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResources {
    
    private Usuario usuario;

    @GetMapping
	public ResponseEntity<Usuario> buscarTodos() {
        usuario = new Usuario();
        usuario.setNome("Sidney Jr");
        usuario.setCpf("09254957941");
        usuario.setEmail("sidney.e.s.s.jr@gmail.com");
        usuario.setSenha("32465901");

        return ResponseEntity.ok().body(usuario);
    }

}

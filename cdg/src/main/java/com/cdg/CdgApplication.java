package com.cdg;

import java.util.Optional;

import com.cdg.entities.Carteira;
import com.cdg.entities.Operacao;
import com.cdg.entities.Usuario;
import com.cdg.repository.CarteiraCrudRepository;
import com.cdg.repository.OperacaoCrudRepository;
import com.cdg.repository.UsuarioCrudRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CdgApplication implements CommandLineRunner {

	private final CarteiraCrudRepository carteiraCrudRepository;
	private final OperacaoCrudRepository operacaoCrudRepository;
	private final UsuarioCrudRepository usuarioCrudRepository;

	public CdgApplication(CarteiraCrudRepository carteiraCrudRepository, OperacaoCrudRepository operacaoCrudRepository,
			UsuarioCrudRepository usuarioCrudRepository) {
		this.carteiraCrudRepository = carteiraCrudRepository;
		this.operacaoCrudRepository = operacaoCrudRepository;
		this.usuarioCrudRepository = usuarioCrudRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CdgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Usuario usuario = new Usuario();
		// usuario.setNome("Sidney Souza Junior");
		// usuario.setCpf("09254957941");
		// usuario.setEmail("sidney.e.s.s.jr@gmail.com");
		// usuario.setSenha("32465901");

		// usuarioCrudRepository.save(usuario);
		// Carteira carteira = new Carteira();
		// carteira.setIdentificador("Minha carteira");
		// carteira.setUsuario(usuario);

		// carteiraCrudRepository.save(carteira);

		Optional<Carteira> findByIdCarteira = carteiraCrudRepository.findById(1L);
		Optional<Usuario> findByIdUsuario = usuarioCrudRepository.findById(1L);

		Carteira carteira = findByIdCarteira.get();
		Usuario usuario = findByIdUsuario.get();

		Operacao operacao = new Operacao(carteira, usuario);
		operacao.guardar(2500.0);
		operacao.setDescricao("Primeiro Salario");

		carteiraCrudRepository.save(carteira);
		operacaoCrudRepository.save(operacao);
		
	}

}

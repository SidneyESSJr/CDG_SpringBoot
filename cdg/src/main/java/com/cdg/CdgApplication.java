package com.cdg;

import java.util.Scanner;

import com.cdg.service.CDGService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CdgApplication implements CommandLineRunner {

	private final CDGService application;

	public CdgApplication(CDGService application) {
		this.application = application;
	}

	public static void main(String[] args) {
		SpringApplication.run(CdgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scan = new Scanner(System.in);
		application.menu(scan);
	}

}

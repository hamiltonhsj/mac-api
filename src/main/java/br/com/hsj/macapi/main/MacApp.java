package br.com.hsj.macapi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "br.com.hsj.macapi" })
public class MacApp {

	public static void main(String[] args) {
		SpringApplication.run(MacApp.class, args);
	}
}

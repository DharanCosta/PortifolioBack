package com.portifoliodharan.dharanportifolio;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class DharanportifolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DharanportifolioApplication.class, args);
	}

}

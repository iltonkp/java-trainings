package io.github.iltonkp.udemy_hexagonal_architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UdemyHexagonalArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyHexagonalArchitectureApplication.class, args);
	}

}

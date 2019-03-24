package dev.munger.noted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NotedApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotedApplication.class, args);
	}

}

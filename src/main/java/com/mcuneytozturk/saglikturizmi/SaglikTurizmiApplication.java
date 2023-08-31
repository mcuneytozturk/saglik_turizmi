package com.mcuneytozturk.saglikturizmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//zamanlayıcı'nın çalışması için gereken anotasyon
@EnableScheduling
public class SaglikTurizmiApplication {
	public static void main(String[] args) {
		SpringApplication.run(SaglikTurizmiApplication.class, args);
	}

}

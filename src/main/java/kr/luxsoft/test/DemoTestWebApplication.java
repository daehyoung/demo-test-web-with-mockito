package kr.luxsoft.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@ComponentScan("kr.luxsoft")
@SpringBootApplication
public class DemoTestWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTestWebApplication.class, args);
	}

}

package kr.luxsoft.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@ExtendWith(SpringExtension.class)
@SpringBootTest( 
 webEnvironment = WebEnvironment.RANDOM_PORT )
class DemoTestWebApplicationTests {

	@Autowired
	private HomeController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting", String.class))
		.contains("Hello, Mock");
	}
	
	@Test
	public void greetingShouldReturnDefaultMessage2() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting", String.class))
		.contains("Hello, Mock");
	}
	

}

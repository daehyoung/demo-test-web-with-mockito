package kr.luxsoft.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GreetingController.class)
public class TestGreetingController {

	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GreetingService service;// = mock(GreetingService.class);

	
	@BeforeEach
	void initEach() {
		
	}
	
	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		Greeting greeting =  new Greeting("Hello, Mock","en");
		when(service.greet()).thenReturn(greeting);
		
		this.mockMvc.perform(get("/greeting")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Hello, Mock")));
	}
	
	@Test
	void test() throws Exception {
		Greeting greeting =  new Greeting("Hello, Mock","en");
		when(service.greet()).thenReturn(greeting);
		
		this.mockMvc.perform(get("/greeting")
			.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(jsonPath("$.message").value("Hello, Mock"))
			.andExpect(jsonPath("$.lang").value("en"));
	}
	
}

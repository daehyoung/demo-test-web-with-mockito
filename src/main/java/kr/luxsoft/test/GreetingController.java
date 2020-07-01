package kr.luxsoft.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
public class GreetingController {
	
	
//	@Autowired
	private   GreetingService service = mock(GreetingService.class);
	
	@PostConstruct
	void initMock() {
		Greeting greeting =  new Greeting("Hello, Mock","en");
		when(service.greet()).thenReturn(greeting);
	}
	
	@RequestMapping("/greeting")
	public @ResponseBody Greeting greeting() {
		return service.greet();
	}

}
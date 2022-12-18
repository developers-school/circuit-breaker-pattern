package ds.circuit.breaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableCircuitBreaker
@SpringBootApplication
public class CircuitBreakerPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerPatternApplication.class, args);
	}

	 @RequestMapping(value = "/recommended")
	  public String readingList(){
	    return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
	  }
}

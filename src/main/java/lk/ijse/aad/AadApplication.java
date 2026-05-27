package lk.ijse.aad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Configuration + EnableAutoConfiguration + ComponentsScan
public class AadApplication {

	public static void main(String[] args) {
		SpringApplication.run(AadApplication.class, args);
	}

}

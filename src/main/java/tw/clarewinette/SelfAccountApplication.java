package tw.clarewinette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"tw.clarewinette"})
public class SelfAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfAccountApplication.class, args);
	}

}

package calcular.somarestapiwevo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableRabbit /*Configuração do RabbitMQ*/
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan (basePackages = {"calcular.*"})
@EntityScan (basePackages = {"calcular.somarestapiwevo.models"})
@EnableJpaRepositories (basePackages = {"calcular.somarestapiwevo.repository"})
public class CalcApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalcApiApplication.class, args);
	}

}

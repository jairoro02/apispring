package es.iesrafaelalberti.apicliente;

import es.iesrafaelalberti.apicliente.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class ApiclienteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiclienteApplication.class, args);
    }

}

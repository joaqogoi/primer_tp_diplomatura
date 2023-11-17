package primer_Tp.diplomatura;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ApiRestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestJpaApplication.class, args);
	}

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .paths(PathSelectors.ant("/*"))
            .apis(RequestHandlerSelectors.basePackage("C:\\Programacion\\diplomatura\\Springboot\\ProyectosSpring\\primer_tp_diplomatura\\src\\main\\java\\primer_Tp"))
            .build()
            .apiInfo(apiCustomData());

    }

    private ApiInfo apiCustomData() {
        return new ApiInfo(
            "Gestion de bibliotecas",
            "Sistema de gestion simple",
            "version-1.0",
            "Terminos de servicio",
            new Contact("Goizueta Joaquín", "URL", "joaquin@gmail.com"),
            "Licencia",
            "Url Licencia",
            Collections.emptyList()
        );
    }

}

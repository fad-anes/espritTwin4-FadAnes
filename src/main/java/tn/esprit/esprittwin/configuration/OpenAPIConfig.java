package tn.esprit.esprittwin.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI openApInformation(){
        Contact Contact=new Contact().email("anes.fad@esprit.tn").name("Fad Anes");
        Info Info=new Info().contact(Contact).description("Spring Project Univesity Etudiant")
                .summary("BAck Application with web services").title("Study case").version("1.0.0").license(new License().name("Apache").url("https://springdoc.org/"));
        return new OpenAPI().info(Info);
    }
}

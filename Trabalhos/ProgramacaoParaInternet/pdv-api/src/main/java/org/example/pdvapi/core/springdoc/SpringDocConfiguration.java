package org.example.pdvapi.core.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("REST API - PDV")
                        .description("API")
                        .version("v1")
                        .contact(new Contact().name("PDV").url("https://pdv.com/")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Autorização via Bearer Token. " +
                                        "Para execução dos métodos da api, vá até o Controller de Autenticação e gere um novo token de acesso. " +
                                        "Com o TokenAcesso, configure essa sessão, no vampo de VALUE você deve preecher: " +
                                        "\"Bearer {token}\"" +
                                        " Depois clicar em \"Authorize\"" +
                                        ", assim todos as  chamadas a api irá utilizar esse token de acesso.")));
    }

}

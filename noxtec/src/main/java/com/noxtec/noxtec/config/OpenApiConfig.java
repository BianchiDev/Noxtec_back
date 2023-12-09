package com.noxtec.noxtec.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "Desafio Noxtec", description = "Documentao CRUD de Contatos", summary = "A API de Contatos é um desafio de  desenvolvimento em monolítico", termsOfService = "Noxtec", contact = @Contact(name = "Felipe Bianchi", email = "ifpebinachi@gmail.com"), license = @License(name = "Sua licença"), version = "1.0.0"), servers = {
        @Server(description = "Dev", url = "http://localhost:3000"),
        @Server(description = "test", url = "http://localhost:8080"),
        @Server(description = "DevOps", url = "http://localhost:3001")
}, security = @SecurityRequirement(name = "auth"))
@SecurityScheme(name = "auth", in = SecuritySchemeIn.HEADER, type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer", description = "Security desc")

public class OpenApiConfig {

}

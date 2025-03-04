package com.eroskoller.practicing.cards;

import com.eroskoller.practicing.cards.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Accounts Micro Service REST API",
                version = "v0.1",
                description = "A REST API for managing cards and customers.",
                contact = @io.swagger.v3.oas.annotations.info.Contact(
                        name = "Eros Koller",
                        email = "eroskoller.dev@gmail.com",
                        url = "https://www.eroskoller.com"
                ),
                license = @io.swagger.v3.oas.annotations.info.License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        externalDocs = @io.swagger.v3.oas.annotations.ExternalDocumentation(
                description = "GitHub",
                url = "https://github.com/ErosKollerDev/02-springboot-microservices-practicing-to-get-sharp-again")
)
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}

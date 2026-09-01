package org.apicode;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Sistema de Gerenciamento de Eventos",
        version = "1.0",
        description = "Este é um sistema para gerenciar eventos onde os"
        + " usuários podem se cadastrar, pesquisar eventos, se inscrever,"
        + " cancelar inscrições, registrar check-in de participantes e"
        + " enviar e-mails relacionados às inscrições. O sistema é"
        + " composto por várias funcionalidades para atender às"
        + " necessidades dos organizadores e participantes de eventos"))
public class EventsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventsystemApplication.class, args);
    }
}

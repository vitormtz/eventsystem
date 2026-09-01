/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apicode.dao.EmailDAO;
import org.apicode.model.Email;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vitor
 */
@RestController
@RequestMapping("/emails")
@Tag(name = "E-mails", description = "Endpoints para operações relacionadas a e-mails")
public class EmailController {

    private EmailDAO emailService = new EmailDAO();

    @PostMapping
    @Operation(summary = "Registra o envio de e-mail")
    @ApiResponse(responseCode = "200", description = "Envio de e-mail registrado",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Email.class)))
    @ApiResponse(responseCode = "404", description = "Falha no registro de envio de e-mail",
            content = @Content(schema = @Schema(hidden = true)))
    public ResponseEntity<Email> enviarEmail(@RequestBody Email emailRequest) {
        Email email = emailService.salvar(emailRequest);
        if (email == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(email);
        }
    }
}

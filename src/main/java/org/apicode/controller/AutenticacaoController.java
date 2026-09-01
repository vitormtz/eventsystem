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
import org.apicode.dao.AutenticacaoDAO;
import org.apicode.model.Autenticacao;
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
@RequestMapping("/autenticacao")
@Tag(name = "Autenticações", description = "Endpoints para operações relacionadas a autenticacções")
public class AutenticacaoController {

    private AutenticacaoDAO autenticacaoService = new AutenticacaoDAO();

    @PostMapping
    @Operation(summary = "Valida um usuário")
    @ApiResponse(responseCode = "200", description = "Usuário válido",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Autenticacao.class)))
    @ApiResponse(responseCode = "401", description = "Usuário inválido",
            content = @Content(schema = @Schema(hidden = true)))
    public ResponseEntity<Autenticacao> autenticarUsuario(@RequestBody Autenticacao request) {
        Autenticacao response = autenticacaoService.consultar(request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            return ResponseEntity.ok(response);
        }
    }
}

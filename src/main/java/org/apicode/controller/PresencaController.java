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
import org.apicode.dao.PresencaDAO;
import org.apicode.model.Presenca;
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
@RequestMapping("/presencas")
@Tag(name = "Presenças", description = "Endpoints para operações relacionadas a presenças")
public class PresencaController {

    private PresencaDAO presencaService = new PresencaDAO();

    @PostMapping
    @Operation(summary = "Registra uma presença")
    @ApiResponse(responseCode = "201", description = "Presença registrada",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Presenca.class)))
    @ApiResponse(responseCode = "400", description = "Falha no registro da presença",
            content = @Content(schema = @Schema(hidden = true)))
    public ResponseEntity<Presenca> registrarPresenca(@RequestBody Presenca presencaRequest) {
        Presenca presenca = presencaService.salvar(presencaRequest);
        if (presenca == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(presenca);
        }
    }
}

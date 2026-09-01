/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.ArrayList;
import org.apicode.dao.InscricaoDAO;
import org.apicode.model.Inscricao;
import org.apicode.model.InscricaoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vitor
 */
@RestController
@RequestMapping("/inscricoes")
@Tag(name = "Inscrições", description = "Endpoints para operações relacionadas a inscrições")
public class InscricaoController {

    private InscricaoDAO inscricaoService = new InscricaoDAO();

    @GetMapping("/{id}")
    @Operation(summary = "Consulta as inscrições de um usuário")
    @ApiResponse(responseCode = "200", description = "Inscrições encontrados",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = InscricaoRequest.class)))
    @ApiResponse(responseCode = "404", description = "Nenhuma inscrição encontrada",
            content = @Content(schema = @Schema(hidden = true)))
    public ResponseEntity<ArrayList<InscricaoRequest>> obterInscricaoPorId(
            @Parameter(description = "Id do usuário", example = "1", required = true, in = ParameterIn.PATH)
            @PathVariable int id) {
        ArrayList<InscricaoRequest> inscricao = inscricaoService.consultarInscricao(id);
        if (inscricao.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(inscricao);
        }
    }

    @PostMapping
    @Operation(summary = "Registra uma inscrição")
    @ApiResponse(responseCode = "201", description = "Inscrição registrada",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Inscricao.class)))
    @ApiResponse(responseCode = "400", description = "Falha no registro da inscrição",
            content = @Content(schema = @Schema(hidden = true)))
    public ResponseEntity<Inscricao> criarInscricao(@RequestBody Inscricao inscricaoRequest) {        
        Inscricao inscricao = inscricaoService.salvar(inscricaoRequest);
        if (inscricao == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(inscricao);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exlui uma inscrição")
    @ApiResponse(responseCode = "204", description = "Inscrição excluida",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Inscricao.class)))
    @ApiResponse(responseCode = "404", description = "Falha na exclusão da inscrição",
            content = @Content(schema = @Schema(hidden = true)))
    public ResponseEntity<Void> cancelarInscricao(
            @Parameter(description = "Id da inscrição", example = "1", required = true, in = ParameterIn.PATH)
            @PathVariable int id) {
        boolean cancelado = inscricaoService.excluir(id);
        if (cancelado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

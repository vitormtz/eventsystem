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
import java.util.stream.Collectors;
import org.apicode.dao.EventoDAO;
import org.apicode.dao.UsuarioDAO;
import org.apicode.model.Evento;
import org.apicode.model.Usuario;
import org.apicode.model.UsuarioRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vitor
 */
@RestController
@RequestMapping("/eventos")
@Tag(name = "Eventos", description = "Endpoints para operações relacionadas a eventos")
public class EventoController {

    private EventoDAO eventoService = new EventoDAO();
    private UsuarioDAO usuarioService = new UsuarioDAO();

    @GetMapping
    @Operation(summary = "Lista todos os eventos")
    @ApiResponse(responseCode = "200", description = "Eventos encontrados",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Evento.class)))
    @ApiResponse(responseCode = "404", description = "Nenhum evento encontrado",
            content = @Content(schema = @Schema(hidden = true)))
    public ResponseEntity<ArrayList<Evento>> listarEventos() {
        ArrayList<Evento> eventos = eventoService.consultarTodos();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta os participantes de um evento")
    @ApiResponse(responseCode = "200", description = "Evento encontrado",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = UsuarioRequest.class)))
    @ApiResponse(responseCode = "404", description = "Evento não encontrado",
            content = @Content(schema = @Schema(hidden = true)))
    public ResponseEntity<ArrayList<UsuarioRequest>> obterEventoPorId(
            @Parameter(description = "Id do evento", example = "1", required = true, in = ParameterIn.PATH)
            @PathVariable int id) {
        ArrayList<Usuario> usuarios = usuarioService.consultarUsuarioEventos(id);

        ArrayList<UsuarioRequest> usuarioDTO = (ArrayList<UsuarioRequest>) usuarios.stream()
                .map(usuario -> new UsuarioRequest(usuario.getId(), usuario.getNome(), usuario.getEmail()))
                .collect(Collectors.toList());

        if (usuarioDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuarioDTO);
        }
    }
}

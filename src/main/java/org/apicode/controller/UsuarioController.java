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
import org.apicode.dao.UsuarioDAO;
import org.apicode.model.Usuario;
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
@RequestMapping("/usuarios")
@Tag(name = "Usuários", description = "Endpoints para operações relacionadas a usuários")
public class UsuarioController {

    private UsuarioDAO usuarioService = new UsuarioDAO();

    @PostMapping
    @Operation(summary = "Cria um usuário")
    @ApiResponse(responseCode = "201", description = "Usuário criado",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Usuario.class)))
    @ApiResponse(responseCode = "400", description = "Falha na criação do usuário",
            content = @Content(schema = @Schema(hidden = true)))
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuarioRequest) {
        Usuario usuario = usuarioService.salvar(usuarioRequest);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }
    }
}

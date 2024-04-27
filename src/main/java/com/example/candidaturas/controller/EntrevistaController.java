package com.example.candidaturas.controller;

import com.example.candidaturas.model.Entrevista;
import com.example.candidaturas.model.MelhorarSkills;
import com.example.candidaturas.service.EntrevistaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/entrevista")
@Tag(name = "Entrevista", description = "Perguntas e respostas para se preparar para entrevista")
public class EntrevistaController {

    @Autowired
    EntrevistaService entrevistaService;

    @GetMapping
    @Operation(summary = "Listar todas as perguntas e respostas", description = "perguntas e respostas",
            tags = {"Entrevista"}, responses = {
            @ApiResponse(description = "Secess", responseCode = "200",
                    content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Entrevista.class)))
                    }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<List<Entrevista>> findAll() {
        List<Entrevista> list = entrevistaService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Encontra uma pergunta e a sua resposta", description = "Encontrar uma pergunta e a sua resposta",
            tags = {"Entrevista"}, responses = {
            @ApiResponse(description = "Sucess", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Entrevista.class))
            ),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<Entrevista> findById(@PathVariable(value = "id") Long id) {
        Entrevista ent = entrevistaService.findById(id);

        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(ent);
    }

    @PostMapping
    @Operation(summary = "Criar uma pergunta e a sua resposta", description = "Criar uma pergunta e a sua resposta",
            tags = {"Entrevista"}, responses = {
            @ApiResponse(description = "Sucess", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Entrevista.class))
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<Entrevista> create(@RequestBody Entrevista entrevista) {
        entrevistaService.create(entrevista);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entrevista.getId()).toUri();

        return ResponseEntity.created(uri).body(entrevista);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar uma pergunta ou a sua resposta", description = "Editar uma pergunta ou a sua resposta",
            tags = {"Entrevista"}, responses = {
            @ApiResponse(description = "Sucess", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Entrevista.class))
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<Entrevista> update(@PathVariable(value = "id") Long id, @RequestBody Entrevista entrevista) {
        entrevistaService.update(id, entrevista);

        return ResponseEntity.ok().body(entrevista);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma pergunta e a sua resposta", description = "Deletar uma pergunta e a sua resposta",
            tags = {"Entrevista"}, responses = {
            @ApiResponse(description = "Sucess", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Entrevista.class))
            ),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        entrevistaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}

package com.example.candidaturas.controller;

import com.example.candidaturas.model.MelhorarSkills;
import com.example.candidaturas.service.MelhorarSkillsService;
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
@RequestMapping("/skills")
@Tag(name = "Skills", description = "Skills relacionadas a uma candidaturas em que o usuário não foi aprovado, " +
        "para que ele possa melhorar")
public class MelhorarSkillsController {

    @Autowired
    MelhorarSkillsService skillsService;


    @GetMapping
    @Operation(summary = "Listar todas as skills", description = "Listar todas as skills",
        tags = {"Skills"}, responses = {
            @ApiResponse(description = "Secess", responseCode = "200",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = MelhorarSkills.class)))
            }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<List<MelhorarSkills>> findAll() {
        List<MelhorarSkills> list = skillsService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Encontrar uma skill", description = "Encontrar uma skill",
            tags = {"Skills"}, responses = {
            @ApiResponse(description = "Sucess", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = MelhorarSkills.class))
            ),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<MelhorarSkills> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(skillsService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar uma skill", description = "Criar uma skill",
            tags = {"Skills"}, responses = {
            @ApiResponse(description = "Sucess", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = MelhorarSkills.class))
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<MelhorarSkills> create(@RequestBody MelhorarSkills skills) {
        skillsService.create(skills);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(skills.getId()).toUri();

        return ResponseEntity.created(uri).body(skills);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma skill", description = "Atualizar uma skill",
            tags = {"Skills"}, responses = {
            @ApiResponse(description = "Sucess", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = MelhorarSkills.class))
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<MelhorarSkills> update(@PathVariable(value = "id") Long id, @RequestBody  MelhorarSkills skills) {
        skillsService.update(id, skills);

        return ResponseEntity.ok().body(skills);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma skill", description = "Deletar uma skill",
            tags = {"Skills"}, responses = {
            @ApiResponse(description = "Sucess", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = MelhorarSkills.class))
            ),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        skillsService.delete(id);

        return ResponseEntity.noContent().build();
    }



}

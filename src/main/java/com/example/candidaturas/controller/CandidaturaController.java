package com.example.candidaturas.controller;

import com.example.candidaturas.model.Candidatura;
import com.example.candidaturas.model.Entrevista;
import com.example.candidaturas.service.CandidaturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/candidaturas")
@Tag(name = "Candidaturas", description = "As candidaturas que o usuário está participando.")
public class CandidaturaController {

    @Autowired
    CandidaturaService canditService;

    @GetMapping("/semResposta")
    @Operation(summary = "Lista as candidaturas que não tiveram uma resposta no prazo determinado", description = "Candidaturas que não tiveram uma resposta no prazo determinado",
            tags = {"Candidaturas"}, responses = {
            @ApiResponse(description = "Secess", responseCode = "200",
                    content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Candidatura.class)))
                    }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<List<Candidatura>> semResposta() {
        List<Candidatura> list = canditService.semResposta();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/aguardandoResposta")
    @Operation(summary = "Lista as candidaturas que ainda não tem resposta mas estão dentro do prazo determinado.", description = "Lista as candidaturas que ainda não tem resposta mas estão dentro do prazo determinado.",
            tags = {"Candidaturas"}, responses = {
            @ApiResponse(description = "Secess", responseCode = "200",
                    content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Candidatura.class)))
                    }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<List<Candidatura>> aguardandoResposta() {
        List<Candidatura> list = canditService.aguardandoResposta();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/respostaPositiva")
    @Operation(summary = "Lista as candidaturas que receberam uma resposta positiva.", description = "Lista as candidaturas que receberam uma resposta positiva.",
            tags = {"Candidaturas"}, responses = {
            @ApiResponse(description = "Secess", responseCode = "200",
                    content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Candidatura.class)))
                    }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<List<Candidatura>> respostaPositiva() {
        List<Candidatura> list = canditService.respostaPositiva();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/respostaNegativa")
    @Operation(summary = "Lista as candidaturas que receberam uma resposta negativa.", description = "Lista as candidaturas que receberam uma resposta negativa.",
            tags = {"Candidaturas"}, responses = {
            @ApiResponse(description = "Secess", responseCode = "200",
                    content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Candidatura.class)))
                    }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<List<Candidatura>> respostaNegativa() {
        List<Candidatura> list = canditService.respostaNegativa();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Candidatura>> findAllByUsuario_Id(@PathVariable(value = "id") Long id) {
        List<Candidatura> list = canditService.findAllByUserLoginId(id);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("{st}/{id}")
    @Operation(summary = "Encontrar uma candidatura de acordo com o seu status e com o id", description = "Encontrar uma candidatura de acordo com o seu status e com o id",
            tags = {"Candidaturas"}, responses = {
            @ApiResponse(description = "Sucess", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Candidatura.class))
            ),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<Candidatura> findById(@PathVariable(value = "id") Long id) {
        Candidatura cand = canditService.findById(id);
        String st = cand.getStatusCandidatura().getStatus();


        if(cand != null) {
            return ResponseEntity.ok().body(canditService.findById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Criar uma candidatura (Ela é criada, por padrão, com o status 'aguardandoResposta')", description = "Criar uma candidatura (Ela é criada, por padrão, com o status 'aguardandoResposta')",
            tags = {"Candidaturas"}, responses = {
            @ApiResponse(description = "Sucess", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Candidatura.class))
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<Candidatura> create(@RequestBody Candidatura candidatura) {
        canditService.create(candidatura);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(candidatura.getId()).toUri();

        return ResponseEntity.created(uri).body(candidatura);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar uma candidatura", description = "Editar uma candidatura",
            tags = {"Candidaturas"}, responses = {
            @ApiResponse(description = "Sucess", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Candidatura.class))
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<Candidatura> update(@PathVariable(value = "id") Long id, @RequestBody Candidatura candidatura) {
        canditService.update(id, candidatura);

        return ResponseEntity.ok().body(candidatura);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma candidatura", description = "Deletar uma candidatura",
            tags = {"Candidaturas"}, responses = {
            @ApiResponse(description = "Sucess", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Candidatura.class))
            ),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<?> delete(@PathVariable(value =  "id") Long id) {
        canditService.delete(id);
        return ResponseEntity.noContent().build();
    }



}

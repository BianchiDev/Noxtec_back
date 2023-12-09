package com.noxtec.noxtec.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.noxtec.noxtec.service.ContatoService;
import com.noxtec.noxtec.shared.ContatoDTO;
import com.noxtec.noxtec.view.model.ContatoRequest;
import com.noxtec.noxtec.view.model.ContatoResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/contatos")
@SecurityRequirement(name = "auth")
public class ContatoController {

    @Autowired
    ContatoService service;

    @Operation(tags = "Contato", description = "Get all Contato", responses = {
            @ApiResponse(description = "Contato", responseCode = "200"),
            @ApiResponse(description = "Data Not Found", responseCode = "404"),
    })
    @GetMapping
    public ResponseEntity<List<ContatoResponse>> getContatos() {
        List<ContatoDTO> contatos = service.getContatos();
        ModelMapper mapper = new ModelMapper();
        List<ContatoResponse> response = contatos.stream()
                .map(contatoDTO -> mapper.map(contatoDTO, ContatoResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoResponse> getByIdContato(@PathVariable Integer id) {
        Optional<ContatoDTO> optionalDto = service.getByIdContato(id);
        return optionalDto
                .map(dto -> new ResponseEntity<>(new ModelMapper().map(dto, ContatoResponse.class), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/nome/{contatoNome}")
    public ResponseEntity<List<ContatoResponse>> getByName(@PathVariable String contatoNome) {
        List<ContatoDTO> contatos = service.getByName(contatoNome);
        return createContatoResponseEntity(contatos);
    }

    @GetMapping("/fone/{contatoTelefone}")
    public ResponseEntity<List<ContatoResponse>> getByTelefone(@PathVariable String contatoTelefone) {
        List<ContatoDTO> contatos = service.getByTelefone(contatoTelefone);
        return createContatoResponseEntity(contatos);
    }

    @GetMapping("/email/{contatoEmail}")
    public ResponseEntity<List<ContatoResponse>> getByEmail(@PathVariable String contatoEmail) {
        List<ContatoDTO> contatos = service.getByEmail(contatoEmail);
        return createContatoResponseEntity(contatos);
    }

    @GetMapping("/celular/{contatoCelular}")
    public ResponseEntity<List<ContatoResponse>> getByCelular(@PathVariable String contatoCelular) {
        List<ContatoDTO> contatos = service.getByCelular(contatoCelular);
        return createContatoResponseEntity(contatos);
    }

    @PostMapping
    public ResponseEntity<ContatoResponse> addContato(@RequestBody ContatoRequest contatoRequest) {
        ModelMapper mapper = new ModelMapper();
        ContatoDTO dto = mapper.map(contatoRequest, ContatoDTO.class);
        dto = service.addContato(dto);
        ContatoResponse response = mapper.map(dto, ContatoResponse.class);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoResponse> update(@RequestBody ContatoRequest contatoRequest,
            @PathVariable Integer id) {
        ModelMapper mapper = new ModelMapper();
        ContatoDTO dto = mapper.map(contatoRequest, ContatoDTO.class);
        dto = service.update(id, dto);
        ContatoResponse response = mapper.map(dto, ContatoResponse.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private ResponseEntity<List<ContatoResponse>> createContatoResponseEntity(List<ContatoDTO> contatos) {
        if (contatos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ModelMapper mapper = new ModelMapper();
        List<ContatoResponse> response = contatos.stream()
                .map(contatoDTO -> mapper.map(contatoDTO, ContatoResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

package com.ntt.testebackend.controller;

import com.ntt.testebackend.dto.FilmResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/filmes")
public class FilmController {

    public List<FilmResponseDTO> filmes = new ArrayList<>();
    private final RestTemplate restTemplate = new RestTemplate();
    private int idCounter = 1;

    @PostMapping("/alterar-descricao/{id}")
    public ResponseEntity<?> alterarDescricao(@PathVariable int id, @RequestBody String novaDescricao) {
        FilmResponseDTO filme = buscarFilmePorId(id);
        if (filme != null) {
            filme.setOpening_crawl(novaDescricao);
            filme.incrementarVersao();
            return ResponseEntity.ok(filme);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FilmResponseDTO>> listarFilmes() {
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalharFilme(@PathVariable int id) {
        FilmResponseDTO film = buscarFilmePorId(id);
        if (film != null) {
            return ResponseEntity.ok(film);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado");
        }
    }

    @GetMapping("/detalhes/{titulo}")
    public ResponseEntity<?> detalharFilmePorTitulo(@PathVariable String titulo) {
        FilmResponseDTO filme = buscarFilmePorTitulo(titulo);
        if (filme != null) {
            return ResponseEntity.ok(filme);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado");
        }
    }

    private FilmResponseDTO buscarFilmePorId(int id) {
        return filmes.stream()
                .filter(filme -> filme.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private FilmResponseDTO buscarFilmePorTitulo(String titulo) {
        return filmes.stream()
                .filter(filme -> filme.getTitle().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }
}

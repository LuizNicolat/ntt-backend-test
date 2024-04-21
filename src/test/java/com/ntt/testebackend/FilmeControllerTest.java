package com.ntt.testebackend;
import com.ntt.testebackend.controller.FilmController;
import com.ntt.testebackend.dto.FilmResponseDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FilmeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private List<FilmResponseDTO> filmes;

    private static String baseUrl = "/api/filmes";

    @Before
    public void setUp() {
    }

    @Test
    public void testAlterarDescricao() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(baseUrl+"/alterar-descricao/1")
                        .contentType(MediaType.ALL_VALUE)
                        .content("Nova descrição"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.opening_crawl").value("Nova descrição"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testListarFilmes() throws Exception {
        mockMvc.perform(get(baseUrl+"/listar")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testDetalharFilme() throws Exception {
        mockMvc.perform(get(baseUrl+"/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("A New Hope"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testDetalharFilmePorTitulo() throws Exception {
        mockMvc.perform(get(baseUrl+"/detalhes/A New Hope")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("A New Hope"))
                .andDo(MockMvcResultHandlers.print());
    }
}

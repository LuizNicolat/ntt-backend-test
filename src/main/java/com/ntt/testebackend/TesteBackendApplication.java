package com.ntt.testebackend;

import com.ntt.testebackend.dto.*;
import com.ntt.testebackend.controller.FilmController;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TesteBackendApplication {

	private final FilmController filmController;

	@Autowired
	public TesteBackendApplication(FilmController filmController) {
		this.filmController = filmController;
	}
	private final List<FilmResponseDTO> filmes = new ArrayList<>();
	private final RestTemplate restTemplate = new RestTemplate();
	private int idCounter = 1;

	public static void main(String[] args) {
		SpringApplication.run(TesteBackendApplication.class, args);
	}

	@PostConstruct
	public void carregarFilmes() {
		String baseUrl = "https://swapi.dev/api/films/";
		for (int i = 1; i <= 6; i++) {
			String url = baseUrl + i + "/";
			FilmDTO filmeDTO = restTemplate.getForObject(url, FilmDTO.class);
			if (filmeDTO != null) {
				int version = 1;
				List<CharacterDTO> characters = carregarLista(filmeDTO.getCharacters(), CharacterDTO.class);
				List<PlanetDTO> planetas = carregarLista(filmeDTO.getPlanets(), PlanetDTO.class);
				List<StarshipDTO> starships = carregarLista(filmeDTO.getStarships(), StarshipDTO.class);
				List<VehicleDTO> vehicles = carregarLista(filmeDTO.getVehicles(), VehicleDTO.class);
				List<SpecieDTO> species = carregarLista(filmeDTO.getSpecies(), SpecieDTO.class);
				filmes.add(new FilmResponseDTO(
						i,
						filmeDTO.getTitle(),
						filmeDTO.getEpisode_id(),
						filmeDTO.getOpening_crawl(),
						version,
						filmeDTO.getDirector(),
						filmeDTO.getProducer(),
						filmeDTO.getRelease_date(),
						characters,
						planetas,
						starships,
						vehicles,
						species,
						filmeDTO.getCreated(),
						filmeDTO.getEdited(),
						filmeDTO.getUrl()));
				filmController.filmes = filmes;
			}
		}
	}

	private <T> List<T> carregarLista(List<String> urls, Class<T> type) {
		List<T> list = new ArrayList<>();
		for (String url : urls) {
			T item = restTemplate.getForObject(url, type);
			if (item != null) {
				list.add(item);
			}
		}
		return list;
	}
}

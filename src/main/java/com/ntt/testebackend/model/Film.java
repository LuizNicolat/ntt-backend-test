package com.ntt.testebackend.model;

import com.ntt.testebackend.dto.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    public int id;
    private String title;
    private int episode_id;
    private String opening_crawl;
    private int version;
    private String director;
    private String producer;
    private String release_date;
    private List<Character> characters;
    private List<Planet> planets;
    private List<Starship> starships;
    private List<Vehicle> vehicles;
    private List<Specie> species;
    private String created;
    private String edited;
    private String url;

//    public Film(int i, String title, String openingCrawl, int version, String director, String producer, String releaseDate, List<CharacterDTO> characters, List<PlanetDTO> planetas, List<StarshipDTO> starships, List<VehicleDTO> vehicles, List<SpecieDTO> species, String created, String edited, String url) {
//    }

    public void incrementarVersao() {
        this.version++;
    }
}

package com.ntt.testebackend.dto;

import com.ntt.testebackend.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmResponseDTO {
    private int id;
    private String title;
    private int episode_id;
    private String opening_crawl;
    private int version;
    private String director;
    private String producer;
    private String release_date;
    private List<CharacterDTO> characters;
    private List<PlanetDTO> planets;
    private List<StarshipDTO> starships;
    private List<VehicleDTO> vehicles;
    private List<SpecieDTO> species;
    private String created;
    private String edited;
    private String url;

    public void incrementarVersao() {
        this.version++;
    }
}

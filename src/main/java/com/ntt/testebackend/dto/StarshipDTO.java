package com.ntt.testebackend.dto;

import com.ntt.testebackend.model.Character;
import com.ntt.testebackend.model.Film;
import lombok.Data;

import java.util.List;

@Data
public class StarshipDTO {
    private String name;
    private String model;
    private String manufacturer;
    private String costInCredits;
    private String length;
    private String maxAtmospheringSpeed;
    private String crew;
    private String passengers;
    private String cargoCapacity;
    private String consumables;
    private String hyperdriveRating;
    private String MGLT;
    private String starshipClass;
    private List<String> pilots;
    private List<String> films;
    private String created;
    private String edited;
    private String url;
}

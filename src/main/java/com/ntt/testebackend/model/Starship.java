package com.ntt.testebackend.model;

import lombok.Data;

import java.util.List;

@Data
public class Starship {
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
    private List<Character> pilots;
    private List<Film> films;
    private String created;
    private String edited;
    private String url;
}

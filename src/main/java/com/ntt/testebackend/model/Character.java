package com.ntt.testebackend.model;

import com.ntt.testebackend.dto.CharacterDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    public List<Film> films;
    private List<Specie> species;
    private List<Vehicle> vehicles;
    private List<Starship> starships;
    private String created;
    private String edited;
    private String url;

}

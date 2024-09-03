package com.yobel.proyecto_rickymorty.Controllers;

import com.yobel.proyecto_rickymorty.Models.Character;
import com.yobel.proyecto_rickymorty.Services.RickAndMortyService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200") // Permite solicitudes CORS desde la aplicación Angular en el puerto 4200
@RestController
@RequestMapping("/api/characters")
public class RickAndMortyController {

    private final RickAndMortyService rickAndMortyService;

    // Constructor que inyecta el servicio de Rick and Morty.
    public RickAndMortyController(RickAndMortyService rickAndMortyService) {
        this.rickAndMortyService = rickAndMortyService;
    }

    // Endpoint para obtener todos los personajes.
    @GetMapping
    public Character[] getAllCharacters() {
        return rickAndMortyService.getAllCharacters();
    }

    // Endpoint para obtener un personaje por su ID.
    @GetMapping("/{id}")
    public Character getCharacterId(@PathVariable int id) {
        return rickAndMortyService.getCharacterId(id);
    }

    // Endpoint para obtener el nombre de un episodio a partir de su URL.
    @GetMapping("/episode")
    public String getEpisode(@RequestParam String url) {
        return rickAndMortyService.getEpisodeName(url); // Llama al método del servicio
    }
}

package com.yobel.proyecto_rickymorty.Services;

import com.yobel.proyecto_rickymorty.Models.Character;
import com.yobel.proyecto_rickymorty.Models.CharacterResponse;
import com.yobel.proyecto_rickymorty.Models.Episode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.List;

@Service
public class RickAndMortyService {

    private final RestTemplate restTemplate;

    // Constructor con rest template para realizar solicitudes HTTP
    public RickAndMortyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Método para obtener todos los personajes de la API de Rick and Morty.
    public Character[] getAllCharacters() {
        String url = "https://rickandmortyapi.com/api/character/";
        CharacterResponse response = restTemplate.getForObject(url, CharacterResponse.class);

        if (response != null && response.getResults() != null) {
            Character[] characters = response.getResults().toArray(new Character[0]);

            // Itera sobre los personajes para obtener y asignar el nombre del primer episodio en el que aparecen
            for (Character character : characters) {
                List<String> episodes = character.getEpisode();
                if (episodes != null && !episodes.isEmpty()) {
                    String firstEpisodeUrl = episodes.get(0);  // Esto obtiene la primera URL en la lista de episodios.
                    String episodeName = getEpisodeName(firstEpisodeUrl);
                    character.setFirstSeenIn(episodeName);  // Aqui asigna el nombre del episodio donde fue encontrado
                }
            }
            return characters; // Devolver array de los personajes
        }
        return new Character[0]; // Si no hay arra, devuelve vacio
    }

    // Método para obtener un personaje específico por su ID.
    public Character getCharacterId(int id) {
        String url = "https://rickandmortyapi.com/api/character/" + id;
        Character cr = restTemplate.getForObject(url, Character.class);

        // Obtiene la URL del primer episodio en la lista de episodios y luego obtiene el nombre del episodio.
        String palabra = cr.getEpisode().get(0).toString();
        Episode episodioInicio = getEpisode(palabra);
        cr.setFirstSeenIn(episodioInicio.getName()); // Asigna el nombre del episodio al personaje.
        return cr;
    }

    // Método para obtener los detalles de un episodio específico a partir de su URL.
    public Episode getEpisode(String url){
        return restTemplate.getForObject(url, Episode.class);
    }

    // Método en desuso, solo se usó para hacer pruebas.
    public String getEpisodeName(String episodeUrl) {
        Map<String, Object> episodeData = restTemplate.getForObject(episodeUrl, Map.class);
        return episodeData != null ? (String) episodeData.get("name") : "Unknown Episode";
    }
}

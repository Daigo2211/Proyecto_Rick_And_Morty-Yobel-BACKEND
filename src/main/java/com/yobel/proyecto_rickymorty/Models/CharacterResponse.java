package com.yobel.proyecto_rickymorty.Models;

import java.util.List;


//Al final decidí no usar paginación
public class CharacterResponse {
    private Info info;
    private List<Character> results;

    // Getters y Setters
    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }

    // Clase interna para la estructura de 'info'
    public static class Info {
        private int count;
        private int pages;
        private String next;
        private String prev;

        // Getters y Setters
        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public String getPrev() {
            return prev;
        }

        public void setPrev(String prev) {
            this.prev = prev;
        }
    }
}

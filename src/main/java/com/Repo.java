package com;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repo {
    // 2.1 Atributos Privados
    private Long id;
    private String name;
    private String url;

    // 2.2 Constructor vacío (Indispensable para Jackson)
    public Repo() {
    }

    // 2.3 Getters y Setters Públicos
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 2.4 Método para facilitar la visualización de datos
    @Override
    public String toString() {
        return "Repo{id=" + id + ", name='" + name + "'}";
    }
}
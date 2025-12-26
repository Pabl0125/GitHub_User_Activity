package com;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Actor {
    // 2.1 Campos Privados
    private Long id;
    private String login;
    private String url;
    
    @JsonProperty("display_login")
    private String displayLogin;
    
    @JsonProperty("gravatar_id")
    private String gravatarId;
    
    @JsonProperty("avatar_url")
    private String avatarUrl;

    // 2.2 Constructor vacío (Requerido por Jackson)
    public Actor() {}

    // 2.3 Getters y Setters Públicos
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getUrl() { return url; } // Corregido a public
    public void setUrl(String url) { this.url = url; }

    public String getDisplayLogin() { return displayLogin; }
    public void setDisplayLogin(String displayLogin) { this.displayLogin = displayLogin; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    // 2.4 Método Auxiliar (Opcional pero útil para debugging)
    @Override
    public String toString() {
        return "Actor{login='" + login + "'}";
    }
}
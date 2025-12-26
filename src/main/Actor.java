@JsonIgnoreProperties(ignoreUnknown = true)
public class Actor {
    private Long id;
    private String login;
    
    @JsonProperty("display_login")
    private String displayLogin;
    
    @JsonProperty("gravatar_id")
    private String gravatarId;
    
    private String url;
    
    @JsonProperty("avatar_url")
    private String avatarUrl;

    // Getters y Setters ...
}
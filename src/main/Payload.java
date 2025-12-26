@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {
    // Campos de PushEvent
    @JsonProperty("push_id")
    private Long pushId;
    private String head;
    private String before;
    
    // Campos de CreateEvent / DeleteEvent
    private String ref;
    
    @JsonProperty("ref_type")
    private String refType;
    
    @JsonProperty("master_branch")
    private String masterBranch;
    
    private String description;
    
    @JsonProperty("pusher_type")
    private String pusherType;

    // Getters y Setters ...
}
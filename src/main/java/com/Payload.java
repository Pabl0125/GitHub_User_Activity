package com;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {

    // 2.1 Atributos de PushEvent
    @JsonProperty("push_id")
    private Long pushId;
    private String head;
    private String before;
    
    // 2.2 Atributos de CreateEvent / DeleteEvent
    private String ref;
    
    @JsonProperty("ref_type")
    private String refType;
    
    @JsonProperty("master_branch")
    private String masterBranch;
    
    private String description;
    
    @JsonProperty("pusher_type")
    private String pusherType;

    // 2.3 Constructor Vacío
    public Payload() {}

    // 2.4 Getters y Setters Públicos
    public Long getPushId() { return pushId; }
    public void setPushId(Long pushId) { this.pushId = pushId; }

    public String getHead() { return head; }
    public void setHead(String head) { this.head = head; }

    public String getBefore() { return before; }
    public void setBefore(String before) { this.before = before; }

    public String getRef() { return ref; }
    public void setRef(String ref) { this.ref = ref; }

    public String getRefType() { return refType; }
    public void setRefType(String refType) { this.refType = refType; }

    public String getMasterBranch() { return masterBranch; }
    public void setMasterBranch(String masterBranch) { this.masterBranch = masterBranch; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPusherType() { return pusherType; }
    public void setPusherType(String pusherType) { this.pusherType = pusherType; }
}
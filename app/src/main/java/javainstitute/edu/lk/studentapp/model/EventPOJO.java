package javainstitute.edu.lk.studentapp.model;

/**
 * Created by Nirodya on 3/31/2016.
 */
public class EventPOJO {
    private String id;
    private String EventName;
    private String description;

    public EventPOJO(String id, String eventName, String description) {
        this.id = id;
        EventName = eventName;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package Model;

import java.util.UUID;

public class User extends People {
    
    private String userId;
    private String contact;
    private Location location;
    
    public User(String name, GenderEnum gender, int age) {
        super(name, gender, age);
        String uuid = UUID.randomUUID().toString();
        this.userId = uuid;
    }

    public String getUserId() {
        return userId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    
}

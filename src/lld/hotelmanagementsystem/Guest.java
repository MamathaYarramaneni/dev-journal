package lld.hotelmanagementsystem;

public class Guest {
    private String id;
    private String name;
    private String phone;

    Guest(String name, String phone) {
        this.id = generateId();
        this.name = name;
        this.phone = phone;
    }

    String generateId() {
        return UUID.randomId().toString();
    }
}
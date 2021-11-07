package ca.nait.dnd5esrd.entities;

public class Attribute {
    private int id;
    private String name;

    public Attribute(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Attribute() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
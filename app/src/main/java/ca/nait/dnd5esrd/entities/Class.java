package ca.nait.dnd5esrd.entities;

public class Class {
    private int id;
    private int hitDieId;
    private String name;
    private String descrption;

    public Class() {
    }

    public Class(int id, int hitDieId, String name, String descrption) {
        this.id = id;
        this.hitDieId = hitDieId;
        this.name = name;
        this.descrption = descrption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHitDieId() {
        return hitDieId;
    }

    public void setHitDieId(int hitDieId) {
        this.hitDieId = hitDieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }
}

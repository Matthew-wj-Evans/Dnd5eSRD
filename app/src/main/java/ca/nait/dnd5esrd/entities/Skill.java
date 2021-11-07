package ca.nait.dnd5esrd.entities;

public class Skill {
    private int id;
    private String name;
    private int attributeModifier;

    public Skill() {
    }

    public Skill(int id, String name, int attributeModifier) {
        this.id = id;
        this.name = name;
        this.attributeModifier = attributeModifier;
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

    public int getAttributeModifier() {
        return attributeModifier;
    }

    public void setAttributeModifier(int attributeModifier) {
        this.attributeModifier = attributeModifier;
    }
}

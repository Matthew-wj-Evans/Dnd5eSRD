package ca.nait.dnd5esrd.entities;

public class DropDownEntity {
    private int id;
    private int displayString;

    public DropDownEntity() {
    }

    public DropDownEntity(int id, int displayString) {
        this.id = id;
        this.displayString = displayString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDisplayString() {
        return displayString;
    }

    public void setDisplayString(int displayString) {
        this.displayString = displayString;
    }
}

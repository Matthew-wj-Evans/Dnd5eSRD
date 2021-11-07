package ca.nait.dnd5esrd.entities;

public class ClassSavingThrow {
    private int classId;
    private int attributeId;

    public ClassSavingThrow() {
    }

    public ClassSavingThrow(int classId, int attributeId) {
        this.classId = classId;
        this.attributeId = attributeId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }
}

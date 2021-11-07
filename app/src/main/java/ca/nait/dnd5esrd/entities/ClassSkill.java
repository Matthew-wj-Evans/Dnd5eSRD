package ca.nait.dnd5esrd.entities;

public class ClassSkill {
    private int classId;
    private int skillId;

    public ClassSkill() {
    }

    public ClassSkill(int classId, int skillId) {
        this.classId = classId;
        this.skillId = skillId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}

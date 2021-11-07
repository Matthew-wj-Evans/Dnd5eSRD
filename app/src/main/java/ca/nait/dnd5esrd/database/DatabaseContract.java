package ca.nait.dnd5esrd.database;

import android.provider.BaseColumns;

public class DatabaseContract {

    private DatabaseContract(){

    }

    // Attribute Table
    public static class AttributeEntry implements BaseColumns {
        // Table Name
        public static final String TABLE_NAME = "attribute_table";
        // Columns
        public static final String COLUMN_NAME_ATTRIBUTE_NAME = "attribute_name";
            // Foreign Keys
    }

    // Class Table
    public static class ClassEntry implements BaseColumns {
        // Table Name
        public static final String TABLE_NAME = "class_table";
        // Columns
        public static final String COLUMN_NAME_CLASS_NAME = "class_name";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
            // Foreign Keys
            public static final String FK_COLUMN_NAME_HIT_DIE_ID = "hit_die_id";
    }
    // Class-SavingThrow Table
    public static class ClassSavingThrowEntry implements BaseColumns {
        // Table Name
        public static final String TABLE_NAME = "class_saving_throw_table";
        // Columns
            // Foreign Keys
        public static final String FK_COLUMN_NAME_CLASS_ID = "class_id";
        public static final String FK_COLUMN_NAME_ATTRIBUTE_ID = "attribute_id";
    }

    // Class-Skill Table
    public static class ClassSkillEntry implements BaseColumns {
        // Table Name
        public static final String TABLE_NAME = "class_skill_table";
        // Columns
            // Foreign Keys
        public static final String FK_COLUMN_NAME_CLASS_ID = "class_id";
        public static final String FK_COLUMN_NAME_SKILL_ID = "skill_id";
    }

    // Skill table
    public static class SkillEntry implements BaseColumns {
        // Table Name
        public static final String TABLE_NAME = "skill_table";
        // Columns
        public static final String COLUMN_NAME_SKILL_NAME = "skill_name";
            // Foreign Keys
        public static final String FK_COLUMN_NAME_ATTRIBUTE_ID = "attribute_id";
    }

    public static class HitDieEntry implements BaseColumns {
        // Table Name
        public static final String TABLE_NAME = "hit_die_table";
        // Table Columns
        public static final String COLUMN_NAME_DIE_FACES = "die_faces";
    }
}
/*
TEMPLATE CODE
public static class blankEntry implements BaseColumns {
    // Table Name
    private static final String TABLE_NAME = "";
    // Columns
    private static final String COLUMN_NAME_ = "";
        // Private Keys
}
 */

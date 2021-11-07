package ca.nait.dnd5esrd.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import ca.nait.dnd5esrd.database.DatabaseContract;
import ca.nait.dnd5esrd.entities.Attribute;
import ca.nait.dnd5esrd.entities.Class;
import ca.nait.dnd5esrd.entities.Skill;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "DndSrd_v" + DATABASE_VERSION + ".db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create Class Table String
    private static final String SQL_CREATE_CLASS_ENTRIES =
            "CREATE TABLE " + DatabaseContract.ClassEntry.TABLE_NAME + "("
                + DatabaseContract.ClassEntry._ID + " INTEGER PRIMARY KEY, "
                + DatabaseContract.ClassEntry.COLUMN_NAME_CLASS_NAME + " TEXT, "
                + DatabaseContract.ClassEntry.COLUMN_NAME_DESCRIPTION + " TEXT, "
                + DatabaseContract.ClassEntry.FK_COLUMN_NAME_HIT_DIE_ID + " INTEGER, "
                + " FOREIGN KEY (" + DatabaseContract.ClassEntry.FK_COLUMN_NAME_HIT_DIE_ID + ")"
                    + " REFERENCES " + DatabaseContract.HitDieEntry.TABLE_NAME + " (" + DatabaseContract.HitDieEntry._ID + ")"
            + ");";

    // Create Class-Skill Table String
    private static final String SQL_CREATE_CLASS_SKILL_ENTRIES =
            "CREATE TABLE " + DatabaseContract.ClassSkillEntry.TABLE_NAME + "("
                + DatabaseContract.ClassSkillEntry.FK_COLUMN_NAME_SKILL_ID + " INTEGER, "
                + DatabaseContract.ClassSkillEntry.FK_COLUMN_NAME_CLASS_ID + " INTEGER, "
                + " PRIMARY KEY (" + DatabaseContract.ClassSkillEntry.FK_COLUMN_NAME_CLASS_ID + ", " + DatabaseContract.ClassSkillEntry.FK_COLUMN_NAME_SKILL_ID + "), "
                + " FOREIGN KEY (" + DatabaseContract.ClassSkillEntry.FK_COLUMN_NAME_SKILL_ID + ")"
                    + " REFERENCES " + DatabaseContract.SkillEntry.TABLE_NAME + " (" + DatabaseContract.SkillEntry._ID + "), "
                + " FOREIGN KEY (" + DatabaseContract.ClassSkillEntry.FK_COLUMN_NAME_CLASS_ID + ")"
                    + " REFERENCES " + DatabaseContract.ClassEntry.TABLE_NAME + " (" + DatabaseContract.ClassEntry._ID + ")"
            + ");";

    // Create Attribute Table String
    private static final String SQL_CREATE_ATTRIBUTE_ENTRIES =
            "CREATE TABLE " + DatabaseContract.AttributeEntry.TABLE_NAME + "("
                + DatabaseContract.AttributeEntry._ID + " INTEGER PRIMARY KEY, "
                + DatabaseContract.AttributeEntry.COLUMN_NAME_ATTRIBUTE_NAME + " TEXT "
            + ");";

    // Create Skill Table String
    private static final String SQL_CREATE_SKILL_ENTRIES =
            "CREATE TABLE " + DatabaseContract.SkillEntry.TABLE_NAME + "("
                + DatabaseContract.SkillEntry._ID + " INTEGER PRIMARY KEY, "
                + DatabaseContract.SkillEntry.COLUMN_NAME_SKILL_NAME + " TEXT, "
                + DatabaseContract.SkillEntry.FK_COLUMN_NAME_ATTRIBUTE_ID + " INTEGER, "
                + " FOREIGN KEY (" + DatabaseContract.SkillEntry.FK_COLUMN_NAME_ATTRIBUTE_ID + ")"
                    + " REFERENCES " + DatabaseContract.AttributeEntry.TABLE_NAME + " (" + DatabaseContract.AttributeEntry._ID + ")"
            + ");";

    // Create Class-SavingThrow String
    private static final String SQL_CREATE_CLASS_SAVING_THROW_ENTRIES =
            "CREATE TABLE " + DatabaseContract.ClassSavingThrowEntry.TABLE_NAME + "("
                + DatabaseContract.ClassSavingThrowEntry.FK_COLUMN_NAME_ATTRIBUTE_ID + " INTEGER, "
                + DatabaseContract.ClassSavingThrowEntry.FK_COLUMN_NAME_CLASS_ID + " INTEGER, "
                + " PRIMARY KEY (" + DatabaseContract.ClassSavingThrowEntry.FK_COLUMN_NAME_ATTRIBUTE_ID + ", "
                    + DatabaseContract.ClassSavingThrowEntry.FK_COLUMN_NAME_CLASS_ID + "), "
                + " FOREIGN KEY (" + DatabaseContract.ClassSavingThrowEntry.FK_COLUMN_NAME_ATTRIBUTE_ID + ")"
                    + " REFERENCES " + DatabaseContract.AttributeEntry.TABLE_NAME + " (" + DatabaseContract.AttributeEntry._ID + "), "
                + " FOREIGN KEY (" + DatabaseContract.ClassSavingThrowEntry.FK_COLUMN_NAME_CLASS_ID + ")"
                    + " REFERENCES " + DatabaseContract.ClassEntry.TABLE_NAME + " (" + DatabaseContract.ClassEntry._ID + ")"
            + ");";

    // Create HitDie Table String
    private static final String SQL_CREATE_HIT_DIE_ENTRIES =
            "CREATE TABLE " + DatabaseContract.HitDieEntry.TABLE_NAME + "("
                + DatabaseContract.HitDieEntry._ID + " INTEGER PRIMARY KEY, "
                + DatabaseContract.HitDieEntry.COLUMN_NAME_DIE_FACES + " TEXT"
            + ");";

    /*
    private static final String SQL_DELETE_blank_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract..TABLE_NAME;
    */

    private static final String SQL_DELETE_ATTRIBUTE_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract.AttributeEntry.TABLE_NAME;
    private static final String SQL_DELETE_CLASS_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract.ClassEntry.TABLE_NAME;
    private static final String SQL_DELETE_CLASS_SAVING_THROW_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract.ClassSavingThrowEntry.TABLE_NAME;
    private static final String SQL_DELETE_CLASS_SKILL_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract.ClassSkillEntry.TABLE_NAME;
    private static final String SQL_DELETE_SKILL_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract.SkillEntry.TABLE_NAME;
    private static final String SQL_DELETE_HIT_DIE_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract.HitDieEntry.TABLE_NAME;


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_HIT_DIE_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_ATTRIBUTE_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_CLASS_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_SKILL_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_CLASS_SKILL_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_CLASS_SAVING_THROW_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_CLASS_SAVING_THROW_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_CLASS_SKILL_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_SKILL_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_CLASS_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_ATTRIBUTE_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_HIT_DIE_ENTRIES);
        onCreate(sqLiteDatabase);
    }


    /*
        Grab-All Cursors
     */
    public Cursor getAttributesCursor() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {
            DatabaseContract.AttributeEntry._ID,
            DatabaseContract.AttributeEntry.COLUMN_NAME_ATTRIBUTE_NAME
        };
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        return db.query(
            DatabaseContract.AttributeEntry.TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            groupBy,
            having,
            orderBy
        );
    }

    public Cursor getSkillsCursor() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {
                DatabaseContract.SkillEntry._ID,
                DatabaseContract.SkillEntry.COLUMN_NAME_SKILL_NAME,
                DatabaseContract.SkillEntry.FK_COLUMN_NAME_ATTRIBUTE_ID
        };
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        return db.query(
            DatabaseContract.AttributeEntry.TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            groupBy,
            having,
            orderBy
        );
    }

    public Cursor getClassesCursor() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {
                DatabaseContract.ClassEntry._ID,
                DatabaseContract.ClassEntry.COLUMN_NAME_CLASS_NAME,
                DatabaseContract.ClassEntry.COLUMN_NAME_DESCRIPTION,
                DatabaseContract.ClassEntry.FK_COLUMN_NAME_HIT_DIE_ID
        };
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        return db.query(
            DatabaseContract.AttributeEntry.TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            groupBy,
            having,
            orderBy
        );
    }

    /*
        Get-By-Id Cursors
     */
    public Cursor getAttributeCursorById(int attributeId) {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {
            DatabaseContract.AttributeEntry._ID,
            DatabaseContract.AttributeEntry.COLUMN_NAME_ATTRIBUTE_NAME
        };
        String selection = DatabaseContract.AttributeEntry._ID + "= ?";
        String[] selectionArgs = {
                String.valueOf(attributeId)
        };
        String groupBy = null;
        String having = null;
        String orderBy = null;

        return db.query(
            DatabaseContract.AttributeEntry.TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            groupBy,
            having,
            orderBy
        );
    }

    public Cursor getSkillCursorById(int skillId) {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {
            DatabaseContract.SkillEntry._ID,
            DatabaseContract.SkillEntry.COLUMN_NAME_SKILL_NAME,
            DatabaseContract.SkillEntry.FK_COLUMN_NAME_ATTRIBUTE_ID
        };
        String selection = DatabaseContract.SkillEntry._ID + "= ?";
        String[] selectionArgs = {
                String.valueOf(skillId)
        };
        String groupBy = null;
        String having = null;
        String orderBy = null;

        return db.query(
            DatabaseContract.SkillEntry.TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            groupBy,
            having,
            orderBy
        );
    }

    public Cursor getClassCursorById(int classId) {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {
                DatabaseContract.ClassEntry._ID,
                DatabaseContract.ClassEntry.COLUMN_NAME_CLASS_NAME,
                DatabaseContract.ClassEntry.COLUMN_NAME_DESCRIPTION,
                DatabaseContract.ClassEntry.FK_COLUMN_NAME_HIT_DIE_ID
        };
        String selection = DatabaseContract.ClassEntry._ID + "= ?";
        String[] selectionArgs = {
                String.valueOf(classId)
        };
        String groupBy = null;
        String having = null;
        String orderBy = null;

        return db.query(
                DatabaseContract.ClassEntry.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy
        );
    }

    /*
        Map Cursor to data class functions
     */
    public Attribute mapCursorToAttribute(Cursor queryResultCursor) {
        Attribute currentAttribute = new Attribute();

        currentAttribute.setId(
            queryResultCursor.getInt(
                queryResultCursor.getColumnIndexOrThrow(DatabaseContract.AttributeEntry._ID)
            )
        );
        currentAttribute.setName(
            queryResultCursor.getString(
                queryResultCursor.getColumnIndexOrThrow(DatabaseContract.AttributeEntry.COLUMN_NAME_ATTRIBUTE_NAME)
            )
        );
        return currentAttribute;
    }

    public Skill mapCursorToSkill(Cursor queryResultCursor) {
        Skill currentSkill = new Skill();

        currentSkill.setId(
            queryResultCursor.getInt(
                queryResultCursor.getColumnIndexOrThrow(DatabaseContract.SkillEntry._ID)
            )
        );
        currentSkill.setName(
            queryResultCursor.getString(
                queryResultCursor.getColumnIndexOrThrow(DatabaseContract.SkillEntry.COLUMN_NAME_SKILL_NAME)
            )
        );
        currentSkill.setAttributeModifier(
            queryResultCursor.getInt(
                queryResultCursor.getColumnIndexOrThrow(DatabaseContract.SkillEntry.FK_COLUMN_NAME_ATTRIBUTE_ID)
            )
        );
        return currentSkill;
    }

    public Class mapCursorToClass(Cursor queryResultCursor) {
        Class currentClass = new Class();

        currentClass.setId(
            queryResultCursor.getInt(
                queryResultCursor.getColumnIndexOrThrow(DatabaseContract.ClassEntry._ID)
            )
        );
        currentClass.setName(
            queryResultCursor.getString(
                queryResultCursor.getColumnIndexOrThrow(DatabaseContract.ClassEntry.COLUMN_NAME_CLASS_NAME)
            )
        );
        currentClass.setDescrption(
            queryResultCursor.getString(
                queryResultCursor.getColumnIndexOrThrow(DatabaseContract.ClassEntry.COLUMN_NAME_DESCRIPTION)
            )
        );
        currentClass.setHitDieId(
            queryResultCursor.getInt(
                queryResultCursor.getColumnIndexOrThrow(DatabaseContract.ClassEntry.FK_COLUMN_NAME_HIT_DIE_ID)
            )
        );
        return currentClass;
    }

    /*
        Cursor-Consuming Classes
     */
    public List<Attribute> getAttributesList() {
        Cursor queryResultCursor = getAttributesCursor();
        List<Attribute> attributes = new ArrayList<>();

        while(queryResultCursor.moveToNext()) {
            Attribute currentAttribute = mapCursorToAttribute(queryResultCursor);
            attributes.add(currentAttribute);
        }
        return attributes;
    }

    public List<Skill> getSkillsList() {
        Cursor queryResultCursor = getSkillsCursor();
        List<Skill> skills = new ArrayList<>();

        while(queryResultCursor.moveToNext()) {
            Skill currentSkill = mapCursorToSkill(queryResultCursor);
            skills.add(currentSkill);
        }
        return skills;
    }

    public List<Class> getClassesList() {
        Cursor queryResultCursor = getClassesCursor();
        List<Class> classes = new ArrayList<>();

        while(queryResultCursor.moveToNext()) {
            Class currentClass = mapCursorToClass(queryResultCursor);
            classes.add(currentClass);
        }
        return classes;
    }

    public Attribute getAttributeById(int attributeId) {
        Cursor queryResultCursor = getAttributeCursorById(attributeId);
        Attribute existingAttribute = null;

        while(queryResultCursor.moveToNext()) {
            existingAttribute = mapCursorToAttribute(queryResultCursor);
        }
        return existingAttribute;
    }

    public Skill getSkillById(int skillId) {
        Cursor queryResultCursor = getAttributeCursorById(skillId);
        Skill existingSkill = null;

        while(queryResultCursor.moveToNext()) {
            existingSkill = mapCursorToSkill(queryResultCursor);
        }
        return existingSkill;
    }

    public Class getClassById(int classId) {
        Cursor queryResultCursor = getAttributeCursorById(classId);
        Class existingClass = null;

        while(queryResultCursor.moveToNext()) {
            existingClass = mapCursorToClass(queryResultCursor);
        }
        return existingClass;
    }

    // Add classes
    public long addAttribute(Attribute newAttribute) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.AttributeEntry.COLUMN_NAME_ATTRIBUTE_NAME, newAttribute.getName());
        return db.insert(DatabaseContract.AttributeEntry.TABLE_NAME, null, values);
    }

    public long addSkill(Skill newSKill) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.SkillEntry.COLUMN_NAME_SKILL_NAME, newSKill.getName());
        values.put(DatabaseContract.SkillEntry.FK_COLUMN_NAME_ATTRIBUTE_ID, newSKill.getAttributeModifier());
        return db.insert(DatabaseContract.SkillEntry.TABLE_NAME, null, values);
    }

    public long addClass(Class newClass) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.ClassEntry.COLUMN_NAME_CLASS_NAME, newClass.getName());
        values.put(DatabaseContract.ClassEntry.COLUMN_NAME_DESCRIPTION, newClass.getDescrption());
        values.put(DatabaseContract.ClassEntry.FK_COLUMN_NAME_HIT_DIE_ID, newClass.getHitDieId());
        return db.insert(DatabaseContract.ClassEntry.TABLE_NAME, null, values);
    }

    public int updateAttribute(int id, Attribute attribute) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.AttributeEntry.COLUMN_NAME_ATTRIBUTE_NAME, attribute.getName());
        final String whereClause = DatabaseContract.AttributeEntry._ID + "= ?";
        final String[] whereArgs = {
                String.valueOf(id)
        };
        return db.update(DatabaseContract.AttributeEntry.TABLE_NAME, values, whereClause, whereArgs);
    }

    public int deleteAttribute(int attributeId) {
        SQLiteDatabase db = getWritableDatabase();
        final String whereClause = DatabaseContract.AttributeEntry._ID + "= ?";
        final String[] whereArgs = {
                String.valueOf(attributeId)
        };
        return db.delete(DatabaseContract.AttributeEntry.TABLE_NAME, whereClause, whereArgs);
    }
}

/*
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {

        };
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        return db.query(
            DatabaseContract..TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            groupBy,
            having,
            orderBy
        );
 */

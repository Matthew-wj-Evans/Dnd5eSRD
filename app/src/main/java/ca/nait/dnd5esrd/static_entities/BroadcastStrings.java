package ca.nait.dnd5esrd.static_entities;

public final class BroadcastStrings {
    public static final String PACKAGE_NAME = "ca.nait.dnd5esrd.";

    public static final String INTENT_ACTION_ATTRIBUTE_EDIT = PACKAGE_NAME + "ATTRIBUTE_EDIT";
    public static final String INTENT_ACTION_SKILL_EDIT = PACKAGE_NAME + "SKILL_EDIT";
    public static final String INTENT_ACTION_CLASS_EDIT = PACKAGE_NAME + "CLASS_EDIT";
    public static final String INTENT_ACTION_HITDIE_EDIT = PACKAGE_NAME + "HITDIE_EDIT";

    public static final String INTENT_ACTION_ATTRIBUTE_DELETE = PACKAGE_NAME + "ATTRIBUTE_DELETE";
    public static final String INTENT_ACTION_SKILL_DELETE = PACKAGE_NAME + "SKILL_DELETE";
    public static final String INTENT_ACTION_CLASS_DELETE = PACKAGE_NAME + "CLASS_DELETE";
    public static final String INTENT_ACTION_HITDIE_DELETE = PACKAGE_NAME + "HITDIE_DELETE";

    public static final String EXTRA_ATTRIBUTE_ID = PACKAGE_NAME + "ATTRIBUTE_ID";
    public static final String EXTRA_SKILL_ID = PACKAGE_NAME + "SKILL_ID";
    public static final String EXTRA_CLASS_ID = PACKAGE_NAME + "CLASS_ID";
    public static final String EXTRA_HITDIE_ID = PACKAGE_NAME + "HITDIE_ID";

    private BroadcastStrings() {
    }
}

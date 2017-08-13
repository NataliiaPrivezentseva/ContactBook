package contactbook.ui;

public enum EditOptions {
    CHANGE_FIRST_NAME("Change first name"),
    CHANGE_LAST_NAME("Change last name"),
    CHANGE_PHONE_NUMBER("Change phone number"),
    CHANGE_EMAIL("Change e-mail"),
    ADD_PHONE_NUMBER("Add new phone number"),
    ADD_EMAIL("Add e-mail (only if field is empty)"),
    DELETE_PHONE_NUMBER("Delete phone number"),
    DELETE_EMAIL("Delete e-mail");

    private final String message;

    EditOptions(String message) {
        this.message = message;
    }

    public static EditOptions fromInteger(Integer ordinal) {
        return EditOptions.values()[ordinal - 1];
    }

    @Override
    public String toString() {
        return (ordinal() + 1) + " — " + message;
    }
}

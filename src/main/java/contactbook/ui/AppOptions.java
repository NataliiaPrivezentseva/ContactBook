package contactbook.ui;

public enum AppOptions {
    ADD_CONTACT("Add new contact"),
    SHOW_CONTACTS("Show contacts"),
    FIND_CONTACT("Find contact"),
    EDIT_CONTACT("Edit contact"),
    DELETE_CONTACT("Delete contact"),
    UPLOAD_CONTACTS("Upload contacts from file"),
    DOWNLOAD_CONTACTS("Download contact book to file");

    private final String message;

    AppOptions(String message) {
        this.message = message;
    }

    public static AppOptions fromInteger(Integer ordinal) {
        return AppOptions.values()[ordinal - 1];
    }

    @Override
    public String toString() {
        return (ordinal() + 1) + " — " + message;
    }
}

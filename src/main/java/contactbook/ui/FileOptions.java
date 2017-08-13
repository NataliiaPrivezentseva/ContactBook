package contactbook.ui;

public enum FileOptions {
    DEFAULT("into default file named \'my_contacts\' which placed on disc C"),
    CUSTOM("I want to use another file");

    private final String message;

    FileOptions(String message) {
        this.message = message;
    }

    public static FileOptions fromInteger(Integer ordinal){
        return FileOptions.values()[ordinal - 1];
    }

    @Override
    public String toString() {
        return (ordinal() + 1) + " — " + message;
    }
}
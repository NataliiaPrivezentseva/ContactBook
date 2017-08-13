package contactbook.ui.console;

public class MessageForUserCreator {

    public String createMessageFromEnum(String headingOfMessage, Enum[] options) {
        StringBuilder builder = new StringBuilder(headingOfMessage);
        for (Enum option : options) {
            builder.append("\n").append(option);
        }
        return builder.toString();
    }
}

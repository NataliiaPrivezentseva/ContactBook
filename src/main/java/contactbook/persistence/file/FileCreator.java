package contactbook.persistence.file;

import java.io.File;
import java.io.IOException;

public class FileCreator {

    // creates txt file at disk C
    //todo может, не нужны тут выводы в консоль о том, был ли создан файл или уже существовал?
    //todo я писала их, пока хотела понимать, что там проиходит, а пользователю это не важно
    public File createFile(String fileName) {
        File file = null;
        try {
            file = new File("c:\\" + fileName + ".txt");
            if (file.createNewFile()) {
                System.out.println("File \'" + fileName + ".txt\' is created!");
            } else {
                System.out.println("File \'" + fileName + ".txt\' already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}

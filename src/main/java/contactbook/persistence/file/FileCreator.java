package contactbook.persistence.file;

import java.io.File;
import java.io.IOException;

public class FileCreator {

    /**
     * Atomically creates on disk C a new, empty txt file named by this abstract pathname if
     * and only if a file with this name does not yet exist.
     * @param fileName the pathname of the file, which will be return
     * @return The absolute abstract pathname denoting the same file as this abstract pathname
     */

    //todo write these messages into log-file
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

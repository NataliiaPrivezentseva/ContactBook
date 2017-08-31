package contactbook.persistence.file;

import java.io.File;
import java.io.IOException;

public class FileCreator {

    /**
     * Automatically creates on disk C a new, empty file if and only if a file with this name
     * does not yet exist.
     * @param   fileName
     *          The name of the file, which will be return;
     * @param   extension
     *          The extension of the file, which will be return;
     * The {@code fileName} and the {@code extension} arguments together create pathname of file,
     * which will be return.
     * @return The absolute abstract pathname denoting the same file as this abstract pathname
     */

    //todo write these messages into log-file
    public File createFile(String fileName, String extension) {
        File file = null;
        try {
            file = new File("c:\\" + fileName + extension);
            if (file.createNewFile()) {
                System.out.println("File \'" + fileName + extension + "\' is created!");
            } else {
                System.out.println("File \'" + fileName + extension + "\' already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
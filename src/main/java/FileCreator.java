import java.io.File;
import java.io.IOException;

class FileCreator {

    static File createFile(String fileName) {
        File file = null;
        try {
            file = new File("c:\\" + fileName + ".txt");
            if (file.createNewFile()) {
                System.out.println("File \'" + fileName + ".txt\' is created!");
            } else {
                System.out.println("File \'" + fileName + ".txt\' already exists");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}

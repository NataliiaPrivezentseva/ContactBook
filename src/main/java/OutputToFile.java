import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

class OutputToFile {

    private FileCreator creator;

    OutputToFile(FileCreator creator) {
        this.creator = creator;
    }

    File writeToFile(List<String> infoFromContactBook, String fileName) throws IOException {
        File fileToWrite = creator.createFile(fileName);
        try (PrintWriter outputStream = new PrintWriter(new FileWriter(fileToWrite))) {
            outputStream.println(infoFromContactBook);
            return fileToWrite;
        }

    }
}

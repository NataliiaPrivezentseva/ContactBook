import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

class OutputToFile {

File writeToFile(List<String> infoFromContactBook, File fileToWrite) throws IOException {
        try (PrintWriter outputStream = new PrintWriter(new FileWriter(fileToWrite))) {
            outputStream.println(infoFromContactBook);
            return fileToWrite;
        }
    }
}

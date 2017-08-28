package contactbook.persistence.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OutputToFile {

public void writeToFile(List<String> infoFromContactBook, File fileToWrite) throws IOException {
        try (PrintWriter outputStream = new PrintWriter(new FileWriter(fileToWrite))) {
            for (String s : infoFromContactBook){
                outputStream.println(s);
            }

        }
    }
}

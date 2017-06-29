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

    //todo try-with-resources
    File writeToFile(List<String> infoFromContactBook, String fileName) throws IOException {
        File fileToWrite = creator.createFile(fileName);
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileWriter(fileToWrite));
            outputStream.println(infoFromContactBook);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
        return fileToWrite;
    }

}
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFromFile {

    //todo решить, оставлять ли оба метода чтения из файла
    List<String> readFromFile(String fileName) throws IOException {
        File fileToRead = new File("c:\\" + fileName + ".txt");
        return this.readFromFile(fileToRead);
    }

    List<String> readFromFile(File fileToRead) throws IOException {
        List<String> inputInStrings = new ArrayList<>();
        try (BufferedReader inputStream = new BufferedReader(new FileReader(fileToRead))) {
            String stringFromFileToRead;
            while ((stringFromFileToRead = inputStream.readLine()) != null) {
                inputInStrings.add(stringFromFileToRead);
            }
            return inputInStrings;
        }
    }
}

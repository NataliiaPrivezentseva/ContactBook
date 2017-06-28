import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class Output {

    static void printToConsole(Object o) {
        System.out.println(o);
    }

    static void printToConsole(List<String> inputInStrings) {
        for (String s : inputInStrings) {
            System.out.println(s);
        }
    }

//    static void printToConsole(File contactBook) {
//        System.out.println("Contact book \'" + contactBook.getName() + "\' contains next contacts:");
//
//        try {
//            System.out.println(Input.readFromFile(contactBook));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    static File writeToFile(char[] infoToWrite) throws IOException {
        // make message for user more clear. What information? to put = to write...
        File fileToWrite = FileCreator.createFile(Input.getInfoFromUser("the name of the file, in which you want to put" +
                " this information. If file don't exists, it will be created"));

        FileWriter outputToFile;
        try {
            outputToFile = new FileWriter(fileToWrite);
            outputToFile.write(infoToWrite);
            outputToFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileToWrite;
    }

    //static File


}

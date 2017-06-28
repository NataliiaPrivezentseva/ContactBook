import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class Output {

    static void printToConsole(Object o){
        System.out.println(o);
    }

    static void printToConsole(File contactBook){
        System.out.println("Contact book \'" + contactBook.getName() + "\' contains next contacts:");

        try {
            System.out.println(Input.readFromFile(contactBook));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    static File writeToFile(char[] infoToWrite) throws IOException {
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


}

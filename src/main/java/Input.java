import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Input {

    static String getInfoFromUser(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please, enter " + message);
        return input.nextLine();
    }

    static int getNumberFromUser(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        while (!input.hasNextInt() || input.nextInt() <= 0) {
            System.out.println("It is improper value! Try again!");
        }
        return input.nextInt();
    }

    static char[] readFromFile(File fileToRead) throws IOException {

        FileReader inputFromFile = null;
        List<Character> inputInCharacters = new ArrayList<Character>();

        try {
            inputFromFile = new FileReader(fileToRead);
            int character;
            while ((character = inputFromFile.read()) != -1) {
                inputInCharacters.add((char) character);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputFromFile != null) {
                inputFromFile.close();
            }
        }

        int i = 0;
        char[] inputInChars = new char[inputInCharacters.size()];
        for (Character everyCharacter : inputInCharacters) {
            inputInChars[i] = everyCharacter;
            i++;
        }

        return inputInChars;
    }

}

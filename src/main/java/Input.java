import java.io.BufferedReader;
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

    static List<String> readFromFile(File fileToRead) throws IOException {
        BufferedReader inputStream = null;
        List<String> inputInStrings = new ArrayList<String>();
        try {
            inputStream = new BufferedReader(new FileReader(fileToRead));
            String stringFromFileToRead;
            while ((stringFromFileToRead = inputStream.readLine()) != null) {
                inputInStrings.add(stringFromFileToRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // нужно выбросить эту ошибку вверх, а потом при ее появлении запустить опять метод из цикла
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return inputInStrings;
    }

// old method that reads chars
//    static char[] readFromFile(File fileToRead) throws IOException {
//
//        FileReader inputFromFile = null;
//        List<Character> inputInCharacters = new ArrayList<Character>();
//
//        try {
//            inputFromFile = new FileReader(fileToRead);
//            int character;
//            while ((character = inputFromFile.read()) != -1) {
//                inputInCharacters.add((char) character);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            if (inputFromFile != null) {
//                inputFromFile.close();
//            }
//        }
//
//        int i = 0;
//        char[] inputInChars = new char[inputInCharacters.size()];
//        for (Character everyCharacter : inputInCharacters) {
//            inputInChars[i] = everyCharacter;
//            i++;
//        }
//
//        return inputInChars;
//    }

}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Input {

    String getInfoFromUser(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please, enter " + message);
        return input.nextLine();
    }

    int getNumberFromUser(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        while (!input.hasNextInt() || input.nextInt() <= 0) {
            System.out.println("It is improper value! Try again!");
        }
        return input.nextInt();
    }

    List<String> readFromFile(File fileToRead) throws IOException {
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

}

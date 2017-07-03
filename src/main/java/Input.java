import java.io.BufferedReader;
import java.io.File;
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
        int numberFromUser;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println(message);

            while (!input.hasNextInt()) {
                String usersInput = input.next();
                System.out.println("\'" + usersInput + "\' is not proper choice. Try again!");
            }
            numberFromUser = input.nextInt();
            if (numberFromUser <= 0) {
                System.out.println("\'" + numberFromUser + "\' is not proper choice. Try again!");
            }

        } while (numberFromUser <= 0);
        return numberFromUser;
    }

    int getChoiceFromUser(String message, int amountOfOptions) {
        int choice;
        do {
            choice = this.getNumberFromUser(message);
        } while (choice <= 0 || choice > amountOfOptions);

        return choice;
    }

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
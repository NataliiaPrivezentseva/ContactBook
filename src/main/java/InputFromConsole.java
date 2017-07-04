import java.util.Scanner;

class InputFromConsole {

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
}
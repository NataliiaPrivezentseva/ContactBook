import java.util.List;

public class OutputToConsole {

    //    static void printToConsole(Object o) {
//        System.out.println(o);
//    }

    static void printToConsole(List<String> inputInStrings) {
        for (String s : inputInStrings) {
            // не печатать результат, а создать объект
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
}

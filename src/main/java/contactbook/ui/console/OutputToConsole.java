package contactbook.ui.console;

import java.util.List;

public class OutputToConsole {

    public void printToConsole(List<String> inputInStrings) {
        for (String s : inputInStrings) {
            System.out.println(s);
        }
    }
}
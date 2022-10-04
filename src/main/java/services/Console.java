package services;

import java.util.List;

public interface Console {

    void print(String msg);

    void printError(String err);

    String getInput(String msg);

    String optionMenu(List<String> options);

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Menu {

    public Menu(List<Option> options){
        this.menuOptions = options;
    }



    public static final Scanner scanner = new Scanner(System.in);

    public record Option(String name, Runnable action){}

    private final List<Option> menuOptions;

    public void printMainMenu(){
        List<String> menuColumn = new ArrayList<>();
        for(int i= 0; i < menuOptions.size(); i++){
            System.out.println(i + 1 + ".  " + menuOptions.get(i).name);
        }
    }

    public static String getUserInput(String description){
        String userInput;
        do{
            System.out.print(description + ": ");
            scanner.skip("\n");
            userInput = scanner.nextLine().strip();
        } while (userInput.isBlank());
        return userInput;
    }

    public static <T> T getUserSelection (String description, List<T> options){
        Integer userInput;
        String userChoise;
        do{
            System.out.print(description + ": ");
            try{
                userChoise = scanner.next();
                userInput =Integer.parseInt(userChoise);
                if (userInput==5) break;
            }
            catch(NumberFormatException e){
                System.out.print("Введены некорректные данные" );
                userInput = -1;
            }
        } while (userInput >= options.size() || userInput < 0);
        return options.get(userInput -1);
    }
    public void run(){
        while (true){
            printMainMenu();
            Option selectedOption = getUserSelection("Выберите", menuOptions);;
            if(selectedOption==menuOptions.getLast()) {
                break;
            }
            if(selectedOption != null)
                selectedOption.action.run();
        }
    }
}
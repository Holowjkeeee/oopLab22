import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Menu mainMenu = new Menu(List.of(
            new Menu.Option("Задание А", ()->{
                String initialSentenceData = Menu.getUserInput("Введите предложение");
                SentenceAnalyzer sentenceAnalyzer = new SentenceAnalyzer(initialSentenceData);
                // task a 1
                for (String currentWord :
                        sentenceAnalyzer.getWordsSameLengthAsLast()) {
                    System.out.print(currentWord + " ");
                }

                System.out.println();

                // task a 2
                System.out.println("Сколько первых слов надо?");
                String temp = Menu.scanner.nextLine();
                int n = Integer.parseInt(temp);

                try {
                    for (String currentWord :
                            sentenceAnalyzer.getFirstWords(n)) {
                        System.out.print(currentWord + " ");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                System.out.println();

            }),
             new Menu.Option("Задание B", ()->{
                 String[] inputStringNumbers = Menu.getUserInput("Введите числа").split("\\D+");
                 System.out.println("Какое число считаем?");
                 int ex = Menu.scanner.nextInt();
                 int[] inputNumbers = new int[inputStringNumbers.length];
                 for (int i = 0; i<inputStringNumbers.length;i++)
                 { inputNumbers[i]=Integer.parseInt(inputStringNumbers[i]);
                 }
                 NumericArrayWorker numericArrayWorker = new NumericArrayWorker(inputNumbers);
                 System.out.println(numericArrayWorker.getFrequency(ex));


             } ),
            new Menu.Option("Задание С", ()->{;

                String initialSentenceData =Menu.getUserInput("Введите предложение");
                SentenceAnalyzer sentenceAnalyzer = new SentenceAnalyzer(initialSentenceData);
                ArrayList<Character> result = sentenceAnalyzer.getLeastFrequentLetters(true);

                for (char currentLetter : result)
                {
                    System.out.print(currentLetter + " ");
                }
                // System.out.println(result.isEmpty());
                if (result.isEmpty()) {
                    System.out.println("нет подходящих символов");
                }


            } ),
            new Menu.Option("Задание D", ()->{String initialSentenceData = Menu.getUserInput("Введите предожение");
                SentenceAnalyzer sentenceAnalyzer = new SentenceAnalyzer(initialSentenceData);

                System.out.println(sentenceAnalyzer.replaceCommasWithAnd());


            } ),
            new Menu.Option("Выход", ()->{System.exit(0);

    } )


    )
    );

    public static void main(String[] args) throws Exception {
        mainMenu.run();




   }

}
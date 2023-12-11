import java.util.ArrayList;

public class SentenceAnalyzer {

    private final String[] words;
    private String sentence;

    public SentenceAnalyzer(String sentence){
        this.sentence = sentence;
        this.words = sentence.split("\\P{L}+");
    }

    public int getLastWordLength(){
        String lastWord = words[words.length-1];
        return lastWord.length();
    }

    public ArrayList<String> getWordsSameLengthAsLast(){
        int lastWordLength = getLastWordLength();
        ArrayList<String> output = new ArrayList<>();
        for (String currentWord :
                words) {
            if (currentWord.length() == lastWordLength){
                output.add(currentWord);
            }
        }
        return output;
    }


    public String replaceCommasWithAnd(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ','){
                sb.append(" и");
            }
            else{
                sb.append(sentence.charAt(i));
            }
        }
        sentence = sb.toString();
        return sentence;
    }

    public float getLetterFrequency(char letter){
        int letterOccurences = 0;
        int letterQuantity   = 0;

        for (String currentWord :
                words) {
            for (int i = 0; i < currentWord.length(); i++){
                letterQuantity += 1;
                if (currentWord.charAt(i) == letter) letterOccurences += 1;
            }

        }
        return (float) letterOccurences / letterQuantity * 100;
    }


    public ArrayList<Character> getLeastFrequentLetters(boolean isCaseSensitive){
        float frequencyThreshold = 10f;
        ArrayList<Character> output = new ArrayList<>();
        for (String currentWord :
                words) {
            for(int i = 0; i < currentWord.length(); i++){
                char currentLetter = isCaseSensitive ? currentWord.toLowerCase().charAt(i) : currentWord.charAt(i);
                if (output.contains(currentLetter)) continue;
                if (getLetterFrequency(currentLetter) < frequencyThreshold){
                    output.add(currentLetter);
                }
            }
        }
        return output;
    }

    public String[] getFirstWords(int n) throws Exception {
        if (n <= 0)           throw new Exception("Wrong words amount (non-positive value)");
        if (n > words.length) throw new Exception("Wrong words amount (value greater, than words)");

        String[] output = new String[n];
        int index = 0;
        while (index < n){
            output[index] = words[index];
            index += 1;
        }
        return output;
    }
}

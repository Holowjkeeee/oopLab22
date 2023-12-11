public class NumericArrayWorker {

    private int[] NumericArray;

    public int getArraySize() {
        return arraySize;
    }

    private int arraySize;

 public NumericArrayWorker(int[] nums) {
        NumericArray = nums;
    arraySize = nums.length;
    }

    public float getFrequency(int num, int[] array){
        int numOccurences = 0;
        for (int current :
                array) {
            if (current == num) numOccurences += 1;
        }
        return (float) numOccurences / arraySize * 100;
    }

    public float getFrequency(int num){
         return getFrequency(num, NumericArray);
    }
}

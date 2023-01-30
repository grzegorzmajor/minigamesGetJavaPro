package ovh.major.MiniGames.LottoGame.Data;

public class Numbers {
    private final int MAX_NUMBER_OF_NUMBERS;
    private int size;
    private int[] numbers;

    public Numbers(int maxNumberOfNumbers) {
        size = 0;
        MAX_NUMBER_OF_NUMBERS = maxNumberOfNumbers;
        numbers =  new int[maxNumberOfNumbers];
    }

    public int size(){ return size; }

    public void add(int number) {
        if (!isFull()) {
            numbers[size] = number;
            size++;
        } else throw new RuntimeException("Add Number Error: Array is full");
    }

    public void clear(){
        size = 0;
        numbers =  new int[MAX_NUMBER_OF_NUMBERS];
    }

    public boolean isContainNumber(int comparedNumber) {
        for(int number:numbers) {
            if (number==comparedNumber) return true;
        }
        return false;
    }

    public boolean isContainAllNumbers(Numbers numbers) {
        boolean result = true;
        for (int number: this.numbers) {
            result = numbers.isContainNumber(number);
        }
        return result;
    }

    public Numbers returnContainNumbers(Numbers numbers) {
        Numbers result = new Numbers(MAX_NUMBER_OF_NUMBERS);
        //TODO for na wykłego bo ten iteruje wstecz.
        for (int number: this.numbers) {
            if (numbers.isContainNumber(number)) result.add(number);
        }
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i=0;i<size;i++) {
            if (i==0) result.append(numbers[i]);
            else result.append(", " + numbers[i]);
        }
        return result.toString();
    }

    private boolean isFull() {
        return (size == MAX_NUMBER_OF_NUMBERS);
    }

    private boolean isEmpty() {
        return (size == 0);
    }
}

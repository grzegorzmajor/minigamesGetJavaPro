package ovh.major.minigames.lotekGames;

import java.util.HashSet;
import java.util.Set;

public class NumbersSet {
    private final int MAX_NUMBER_OF_NUMBERS;

    private final Set<Integer> numbers = new HashSet<>();

    public NumbersSet(int maxNumberOfNumbers) {
        MAX_NUMBER_OF_NUMBERS = maxNumberOfNumbers;
    }

    public int size() {
        return numbers.size();
    }

    public boolean add(int number) {
        if (!isFull()) {
            return numbers.add(number);
        } else return false;
    }

    public void clear() {
        numbers.clear();
    }

    public NumbersSet returnContainNumbers(NumbersSet numbers) {
        NumbersSet result = new NumbersSet(MAX_NUMBER_OF_NUMBERS);
        for (int number : this.numbers) {
            if (numbers.isContainNumber(number)) result.add(number);
        }
        return result;
    }

    public String toString() {
        return numbers.toString();
    }

    public boolean isFull() {
        return (size() == MAX_NUMBER_OF_NUMBERS);
    }
    private boolean isEmpty() {
        return (size() == 0);
    }
    private boolean isContainNumber(Integer comparedNumber) {
        if (this.isEmpty()) return false;
        return numbers.contains(comparedNumber);
    }
}

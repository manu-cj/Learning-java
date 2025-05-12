package Challenge9;

import java.util.List;
import java.util.Random;

// Generic class RandomPicker to pick a random element from a list
public class RandomPicker<T> { // Use a proper generic type parameter like T instead of <list>
    List<T> elemList; // List of elements of type T
    Random random; // Random instance for generating random numbers

    // Constructor to initialize the list and Random instance
    public RandomPicker(List<T> elemList) {
        this.elemList = elemList;
        this.random = new Random();
    }

    // Method to pick a random element from the list
    public T pickRandom() {
        int index = random.nextInt(elemList.size()); // Generate a random index
        return elemList.get(index); // Return the element at the random index
    }
}

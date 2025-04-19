package CsvFactory;

import java.util.List;
import java.util.Random;

public class RandomPicker<list> {
    List<list> elemList;
    Random random;

    public RandomPicker(List<list> elemList) {
        this.elemList = elemList;
        this.random = new Random();
    }

    public list pickRandom() {
        int index = random.nextInt(elemList.size());
        return elemList.get(index);
    }
 


}

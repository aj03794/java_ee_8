package producers;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.util.ArrayList;
import java.util.List;

public class LuckyDishProducer {

    @Produces
    // Could do this and it would inject the logger from LoggerProducer
//    public List<String> getLuckyDish(Logger logger) {
    public List<String> getLuckyDish() {
        var dishes = new ArrayList<String>();
        dishes.add("A");
        dishes.add("B");
        dishes.add("C");
        dishes.add("D");
        dishes.add("E");
        dishes.add("F");

        return dishes;
    }

    public void dispose(@Disposes List<String> dishes) {
        dishes = null;
    }
}

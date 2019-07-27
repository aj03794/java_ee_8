package producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

//@ApplicationScoped
public class LuckyDishProducer {

    @Produces
    // Could do this and it would inject the logger from LoggerProducer
//    public List<String> getLuckyDish(Logger logger) {
    public List<String> getLuckyDish() {
        System.out.println("get luck dish function");
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
        System.out.println("CALLING DISPOSE METHOD");
        dishes = null;
    }
}

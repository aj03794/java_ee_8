package producers;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LuckyDishProducer {

    @Inject
    EntityManager entityManager;

    @Produces
    // Could do this and it would inject the logger from LoggerProducer
    public List<String> getLuckyDish(Logger logger) {
//    public List<String> getLuckyDish() {
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

package beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class LuckyDishRaffle {

    @Inject
    List<String> luckyDishes;

    @Inject
    Logger logger;

    private final Random random = new Random();

    public void printLuckDish() {
        logger.log(Level.INFO,"*************************");
        System.out.println(logger);
        logger.log(Level.INFO, "PRINT LUCKY DISH");
        logger.log(Level.INFO, luckyDishes.get(1));
    }

}

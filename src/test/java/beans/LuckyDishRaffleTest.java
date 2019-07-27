package beans;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class LuckyDishRaffleTest {

    @Inject
    LuckyDishRaffle luckyDishRaffle;

    @Test
    public void t1() {
        luckyDishRaffle.printLuckDish();
    }

}
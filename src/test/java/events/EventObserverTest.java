package events;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qualifiers.annotations.Admin;
import qualifiers.annotations.PopularStand;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class EventObserverTest {

    @Inject
    EventObserver eventObserver;

    @Inject
    Event<EventData> plainEvent;

    @Inject
    @PopularStand
    Event<EventData> userLoggedInEvent;

    @Inject
    @Admin
    Event<EventData> ceoLoggedInEvent;

    @Inject
    Event<String> stringEvent;

    @Test
    @DisplayName("Just a learning test")
    public void t1() {
        plainEvent.fire(new EventData("adamjohnston151@yahoo.com", LocalDateTime.now()));
        // This line won't run until the observer listening to event above is finished
//        System.out.println("Finished");
//        userLoggedInEvent.fire(new EventData("x@yahoo.com", LocalDateTime.now()));
        System.out.println("------------");
        ceoLoggedInEvent.fire(new EventData("___@google.com", LocalDateTime.now()));
    }

    @Test
    @DisplayName("Normal event firing")
    public void t2() {
        plainEvent.fire(new EventData("adamjohnston151@yahoo.com", LocalDateTime.now()));
    }

    @Test
    @DisplayName("Async observer")
    public void q() {
        userLoggedInEvent.fireAsync(new EventData("_____@yahoo.com", LocalDateTime.now()));
        plainEvent.fire(new EventData("adamjohnston151@yahoo.com", LocalDateTime.now()));
    }

    @Test
    @DisplayName("Prioritized observers")
    public void w() {
        stringEvent.fire("hello world");
    }

}
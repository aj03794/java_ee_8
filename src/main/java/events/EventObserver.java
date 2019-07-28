package events;

import qualifiers.annotations.Admin;
import qualifiers.annotations.PopularStand;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class EventObserver implements Serializable {

    @Inject
    Logger logger;

    void asyncObserver(@ObservesAsync @PopularStand EventData eventData) {
        logger.log(Level.INFO, "User {0} logged in at {1}. LOGGED FROM ASYNC OBSERVER",
                new Object[]{ eventData.getEmail(), eventData.getLoginTime() });

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, null, e);
        }
        logger.log(Level.INFO, "ASYNC OBSERVER COMPLETE");
    }

    void plainEvent(@Observes EventData eventData) {
        logger.log(Level.INFO, "user {0} logged in at {1}. Logged from plain event observer",
                new Object[]{ eventData.getEmail(), eventData.getLoginTime() });

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, null, e);
        }
        logger.log(Level.INFO, "PLAIN EVENT OBSERVER COMPLETE");

    }

    void userLoggedIn(@Observes @PopularStand  EventData eventData) {
        logger.log(Level.INFO, "user {0} logged in at {1}. Logged from userLoggedIn observer",
                new Object[]{ eventData.getEmail(), eventData.getLoginTime() });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    void conditionalObserver(@Observes(notifyObserver = Reception.IF_EXISTS,
            during = TransactionPhase.AFTER_COMPLETION) @Admin EventData eventData) {
        logger.log(Level.INFO, "The CEO {0} logged in at {1}",
                new Object[]{ eventData.getEmail(), eventData. getLoginTime()});
    }

    // Lower Priority
    void greetingReceiver1(@Observes @Priority(101) String greeting) {
        logger.log(Level.INFO, "Greeting Receiver 1");
    }

    // Higher priority
    void greetingReceiver2(@Observes @Priority(100) String greeting) {
        logger.log(Level.INFO, "Greeting Receiver 2");
    }

}

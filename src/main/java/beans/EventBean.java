package beans;

import events.EventData;
import events.User;
import qualifiers.annotations.PopularStand;
import qualifiers.annotations.Web;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.time.LocalDateTime;

@Web
public class EventBean {

//    @Inject
//    private User user;

    @Inject
    Event<EventData> plainEvent;

    @Inject
    @PopularStand
    private Event<EventData> eventDataEvent;

    public void login(User user) {
        // Fire login event
        // Normal sync event
        plainEvent.fire(new EventData(user.getEmail(), LocalDateTime.now()));
    }


}

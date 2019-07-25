package org.acme.events;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class AppLifecycleBean {

//    private static final Logger LOGGER = LoggerFactory.getLogger("ListenerBean");

    /**
     * Inject a bean used in the callbacks.
     */
//    @Inject
//    MyOtherBean bean;

//    void onStart(@Observes StartupEvent ev) {
//        System.out.println("The application is starting...{}");
//    }
//
//    void onStop(@Observes ShutdownEvent ev) {
//        System.out.println("The application is stopping... {}");
//    }

    @PostConstruct
    private void init() {
        System.out.println("*************************");
        System.out.println("POST CONSTRUCT");
        System.out.println("*************************");
    }

}
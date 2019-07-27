package beans;

import io.quarkus.runtime.StartupEvent;
import qualifiers.annotations.Web;
import scopes.DependentScope;
import scopes.RequestScope;
import scopes.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;


@Web
//@RequestScoped
public class ScopeBean {

//     This is a contextual instance
//    @Inject
//    private RequestScope requestScope;

    @Inject
    private Logger logger;

    private DependentScope dependentScope;
    private SessionScope sessionScope;

    // Constructor injection point
    @Inject
    private void ScopesBean(DependentScope dependentScope) {
        this.dependentScope = dependentScope;
    }

    // Method injection point
    @Inject
    private void setSessionScope(SessionScope sessionScope) {
        this.sessionScope = sessionScope;
    }

    void onStart(@Observes StartupEvent ev) {
       logger.log(Level.INFO,"The application is starting...{}");
    }

//     Lifecycle callback
//     This is invoked by CDI runtime
//     It can only have injected parameters - but generally you shouldn't use parameters
//     Return type has to be void
//     This method is invoked just before the bean is actually used
    @PostConstruct
    private void init() {
        logger.log(Level.INFO,"*************************");
        logger.log(Level.INFO,"PostConstruct Hook");
        logger.log(Level.INFO,"*************************");
    }

    // Invoked just before the bean is destroyed
    // When CDI container is done with bean and it releases it for garbage collection, then this hook is called
    @PreDestroy
    private void kill() {
        logger.log(Level.INFO,"*************************");
        logger.log(Level.INFO,"PreConstruct Hook");
        logger.log(Level.INFO,"*************************");
    }

}

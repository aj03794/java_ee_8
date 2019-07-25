package beans;

import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qualifiers.annotations.Web;
import scopes.DependentScope;
import scopes.RequestScope;
import scopes.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@Web
public class ScopeBean {

//     This is a contextual instance
    @Inject
    private RequestScope requestScope;

    private static final Logger logger = LoggerFactory.getLogger("ScopeBean");

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
        System.out.println("The application is starting...{}");
    }

//     Lifecycle callback
//     This is invoked by CDI runtime
//     It can only have injected parameters - but generally you shouldn't use parameters
//     Return type has to be void
//     This method is invoked just before the bean is actually used
    @PostConstruct
    private void init() {
        System.out.println("*************************");
        System.out.println("POST CONSTRUCT");
        System.out.println("*************************");
    }

    // Invoked just before the bean is destroyed
    // When CDI container is done with bean and it releases it for garbage collection, then this hook is called
    @PreDestroy
    private void kill() {
        System.out.println("*****************************");
        System.out.println("PreDestroy hook");
        System.out.println("*****************************");
    }

}

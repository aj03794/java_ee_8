package producers;

import qualifiers.Police;
import qualifiers.Salute;
import qualifiers.annotations.ServiceMan;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

@ApplicationScoped
public class LoggerProducer {

    @Produces
    public Logger produceLogger (InjectionPoint injectionPoint) {
        System.out.println(injectionPoint.getMember().getDeclaringClass().getName());
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    @Produces
    @PersistenceContext
    EntityManager entityManager;

    // More than one class that implements the Salute interface
    @Produces
//    @ServiceMan(value = ServiceMan.ServiceType.POLICE)
    @qualifiers.annotations.Police
    public Salute getSalutation() {
        System.out.println("PRODUCES GET SALUTATION");
        return new Police();
    }

}

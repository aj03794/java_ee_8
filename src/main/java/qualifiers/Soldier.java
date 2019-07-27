package qualifiers;

import qualifiers.annotations.ServiceMan;

import javax.enterprise.context.ApplicationScoped;
import java.text.MessageFormat;

@ApplicationScoped
@ServiceMan(value = ServiceMan.ServiceType.SOLDIER)
public class Soldier implements Salute {
    @Override
    public String salute(String name) {
        return MessageFormat.format("Soldier {0}", name);
    }
}

package qualifiers;

import qualifiers.annotations.ServiceMan;

import javax.enterprise.context.ApplicationScoped;
import java.text.MessageFormat;

@ApplicationScoped
@ServiceMan(value = ServiceMan.ServiceType.POLICE)
public class Police implements Salute {
    @Override
    public String salute(String name) {
        return MessageFormat.format("Police {0}", name);
    }
}

package beans;

import qualifiers.Salute;
import qualifiers.annotations.*;

import javax.inject.Inject;

@Web
public class QualifierBean {

    @Inject
    @ServiceMan(value = ServiceMan.ServiceType.POLICE)
    public Salute policeSalute;

    @Inject
    @ServiceMan(value = ServiceMan.ServiceType.SOLDIER)
    public Salute soldierSalute;

    private String name;

    public void policeSalutation() {
        var res = policeSalute.salute(name);
        System.out.println(res);
    }

    public void soldierSalutation() {
        var res = soldierSalute.salute(name);
        System.out.println(res);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package beans;

import qualifiers.Salute;
import qualifiers.annotations.*;

import javax.inject.Inject;

@Web
public class QualifierBean {

    @Inject
    @ServiceMan(value = ServiceMan.ServiceType.SOLDIER)
    public Salute soldierSalute;

    @Inject
    @Police
    public Salute policeSalute;

    @Inject
    @ServiceMan(value = ServiceMan.ServiceType.POLICE)
    public Salute policeSaluteTwo;

    private String name;

    public void policeSalutation() {
        System.out.println("------------------");
        var res = policeSalute.salute(name);
        System.out.println(res);
    }

    public void policeSalutationTwo() {
        System.out.println("-=-=--=-=-=-=-==-=");
        var res = policeSaluteTwo.salute(name);
        System.out.println(res);
    }

    public void soldierSalutation() {
        System.out.println("==================");
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

package beans;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class QualifierBeanTest {

    @Inject
    QualifierBean qualifierBean;

    @Test
    public void t1() {
        qualifierBean.setName("hello world");
        qualifierBean.policeSalutation();
        qualifierBean.soldierSalutation();
    }

}
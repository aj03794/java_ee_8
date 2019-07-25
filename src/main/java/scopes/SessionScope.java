package scopes;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class SessionScope implements Serializable {
    public String getHashCode() {
        return this.hashCode() + " ";
    }
}

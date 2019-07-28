package beans;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

@qualifiers.annotations.LoggedInterceptor
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class LoggedInterceptor {

    @Inject
    private Logger logger;

    private String username = "Adam";

    @AroundInvoke
    public Object logMethodCall(InvocationContext context) throws Exception {
        logger.log(Level.INFO, "User {0} invoked {1} method at {2}", new Object[]{ username, context.getMethod(), LocalDate.now()});
        // Can also stop execution
        return context.proceed();
    }

}

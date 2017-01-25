import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.time.LocalDate;

public class SimpleInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation invocation) throws Exception {
        SaludarUsuario action = (SaludarUsuario) invocation.getAction();
        action.setHoy(LocalDate.now());
        return invocation.invoke();
    }
}

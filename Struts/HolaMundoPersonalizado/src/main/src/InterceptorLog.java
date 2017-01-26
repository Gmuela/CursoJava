import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.time.LocalDateTime;

public class InterceptorLog extends AbstractInterceptor{

    public String intercept(ActionInvocation actionInvocation) throws Exception {

        LocalDateTime now = LocalDateTime.now();

        String hour = now.getHour() + ":" + now.getMinute();

        String invoke = actionInvocation.invoke();

        String nombreAction = " -> Nombre del action: " + actionInvocation.getAction().toString();
        String result = " Result->" + invoke;
        String log = hour + nombreAction + result + " Interceptor llamado ->" +this.toString();

        System.out.println("\033[33m"+log);

        return invoke;
    }

    @Override
    public String toString() {
        return "InterceptorLog";
    }
}

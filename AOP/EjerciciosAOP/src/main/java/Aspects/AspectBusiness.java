package Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Aspect
@Component
public class AspectBusiness {


	@Before("execution(* Business.BusinessInterface.*(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("---BEFORE "+joinPoint.getSignature().getName()+"---");
		System.out.println("Ejecutado a las: "+LocalTime.now());
		System.out.println("");
	}

	@After("execution(* Business.BusinessInterface.*(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("---AFTER "+joinPoint.getSignature().getName()+"---");
		System.out.println("Ejecutado a las: "+LocalTime.now());
		System.out.println("");

	}

	@AfterReturning(pointcut = "execution(* Business.BusinessInterface.*Return(..))", returning= "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println("---AFTERRETURNING "+joinPoint.getSignature().getName()+"---");
		System.out.println("Ejecutado a las: "+LocalTime.now());
		System.out.println("El método a retornado: " + result);
		System.out.println("");

	}

	@AfterThrowing(pointcut = "execution(* Business.BusinessInterface.throwBananas(..))", throwing= "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		System.out.println("---AFTERTHROWING "+joinPoint.getSignature().getName()+"---");
		System.out.println("Ejecutado a las: "+LocalTime.now());
		System.out.println("Exception : " + error);
		System.out.println("");

	}


    @Around("execution(* Business.BusinessInterface.*(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("---AROUND BEGIN "+joinPoint.getSignature().getName()+"---");
        System.out.println("Ejecutado a las: "+LocalTime.now());
        System.out.println("");
        joinPoint.proceed();
		System.out.println("");
		System.out.println("---AROUND END "+joinPoint.getSignature().getName()+"---");
		System.out.println("");

    }
}

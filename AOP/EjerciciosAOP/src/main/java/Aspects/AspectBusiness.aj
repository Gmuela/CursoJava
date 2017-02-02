package Aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Aspect
public aspect AspectBusiness {

    @Before("execution(* *.*.*(..))")
    public void metodo(){
        System.out.println("HOLLLLL");
        System.out.println(LocalTime.now());
    }

}

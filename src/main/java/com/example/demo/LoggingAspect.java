package com.example.demo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
    //For each method in Controller
    @Pointcut("execution(public * com.example.demo.HelloController.*(..))")
    public void publicMethod(){}

    //Print which method is being executed
    @Before("publicMethod()")
    public void addLog(final JoinPoint jP){
        System.out.println("\n* * * Executing " + jP.getSignature());
        java.lang.Object[] arguments = jP.getArgs();
        for(java.lang.Object arg: arguments){
            System.out.println(arg.getClass().getSimpleName() + " = " + arg + "");
        }
    }

}

package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FaithfulAspect {
    /**
     * Methods without friends
     */
    @Pointcut("execution(public * com.example.demo.FaithfulController.*ing(..))")
    public void withoutFriends(){}

    @Before("withoutFriends()")
    public void pray(final JoinPoint joinPoint){
        System.out.print("\nI pray to God");
    }

    @After("withoutFriends()")
    public void prayAndGiveGlory(final JoinPoint joinPoint){
        System.out.println("Then I praise and give glory to God.");
    }

    /**
     * Methods with friends
     */
    @Pointcut("execution(public * com.example.demo.FaithfulController.*WithFriends(..))")
    public void withFriends(){}

    @Before("withFriends()")
    public void prayWithFriends(final JoinPoint joinPoint){
        System.out.print("\nI don't usually pray to God");
    }

    @After("withFriends()")
    public void prayAndGiveGloryWithFriends(final JoinPoint joinPoint){
        System.out.println("But then I praise and give glory to God after.");
    }

}
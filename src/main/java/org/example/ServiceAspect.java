package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

@Aspect
public class ServiceAspect {

    @Before("execution(public int calculate(*,*))")
    public void getNameAdvice(){
        System.out.println("executing Advice before getNameAdvice");
    }
    @Before("@annotation(org.example.AspectAnnotation)")
    public void loggingAdvice(JoinPoint joinPoint){
        System.out.println("executing Advice before loggingAdvice"+ joinPoint);

        System.out.println("Args"+ Arrays.toString(joinPoint.getArgs()));
    }

    @Before("@annotation(org.example.AspectNAme)")
    public void loggingName(JoinPoint joinPoint){
//        Object[] args = joinPoint.getArgs();
//
//        // Ищем первый аргумент типа String
//        for (Object arg : args) {
//            if (arg instanceof String) {
//                String stringParam = (String) arg;
//                System.out.println("String parameter: " + stringParam);
//                break;
//            }
//        }
        String stringParam = joinPoint.getArgs()[0].toString();
        if(stringParam.equals("Pavel")){
            System.out.println("Pavel hello");
        } else {
            System.out.println("Not Pavel hello");
        }
    }

}

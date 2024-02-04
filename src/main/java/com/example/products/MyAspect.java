// package com.example.products;
//
// import java.util.Date;
//
// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.springframework.stereotype.Component;
//
// @Aspect
// @Component
// public class MyAspect
// {
//
// @Around("execution(* com.example.products.CanonPrinter*(..))") // pointcut: com.example.products.CanonPrinter
// public Object around(final ProceedingJoinPoint joinPoint) throws Throwable
// {
// Date start = new Date();
//
// // execute the method from pointcut
// Object result = joinPoint.proceed();
//
// Date end = new Date();
//
// long time = end.getTime() - start.getTime();
// System.out.println("It takes " + time + " m(s) to run.");
// return result;
// }
//
// }

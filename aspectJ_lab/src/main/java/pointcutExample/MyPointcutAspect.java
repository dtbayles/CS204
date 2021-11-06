package pointcutExample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyPointcutAspect {

    /**
     * This Pointcut pattern applies to ever method execution in your project
     */
    @Pointcut("execution(* *(..))")
    public void allMethodExecutions(){}

    /**
     * This pointcut pattern applies to all public methods in the pointcutExample package
     */
    @Pointcut("execution(public * pointcutExample.*.*(..))")
    public void allPublicMethodExecutions(){}

    /**
     * This pointcut pattern applies to any method named "myMethod" that has a single Integer parameter
     */
    @Pointcut("execution(* pointcutExample.MyPointcutClass.myMethod(Integer))")
    public void myMethodIntegerExecution(){}

    /**
     * This Pointcut pattern applies to any method in the pointcutExample package that is named "myMethod"
     */
    @Pointcut("execution(* pointcutExample.*.myMethod(..))")
    public void allMyMethodExecutions(){}

    /**
     * This Pointcut pattern applies to any method that returns a String
     */
    @Pointcut("execution(String *(..))")
    public void allStringReturns(){}


    /**
     *
     * @param joinPoint Holds the reference the the method being called by the "allMethodExecution()" pointcut
     * @return returns returnObject. which holds the return value of the method called by joinPoint.proceed()
     * @throws Throwable can contain any throwable possible from any method that is executed according the the allMethodExecutions pointcut
     */
    @Around("allStringReturns()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("Before Advice--" + joinPoint.toString());
        Object returnObject = joinPoint.proceed();
        System.out.println("After Advice--" + joinPoint.toString());

        return returnObject;
    }


}
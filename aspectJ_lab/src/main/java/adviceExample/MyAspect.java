package adviceExample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {
    //These are pointcut definitions, we will go over these later

    /**
     * This is a pointcut that will only trigger when myMethod method executes
     */
    @Pointcut("execution(* adviceExample.MyClass.myMethod(..))")
    public void myMethodExecution(){}


    /**
     * This is a pointcut that will only trigger when the myMethodAround method executes
     */
    @Pointcut("execution(* adviceExample.MyClass.myMethodAround(..))")
    public void myMethodAroundExecution(){}


    /**
     * A Before advice that outputs a string and the method reference
     * @param joinPoint holds a reference of the method call
     */
    @Before("myMethodExecution()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("BeforeAdvice is running before " + joinPoint.toString());
    }

    @After("myMethodExecution()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After Advice code is executing " + joinPoint.toString());
    }

    /**
     *
     * @param joinPoint the reference to the method call
     * .proceed() signals the method referenced by joinPoint to execute.
     * joinPoint.proceed() returns the return value of the method referenced by joinpoint
     * @return Returns a value in place of the value that is returned by the method held in joinpoint
     * @throws Throwable
     */
    @Around("myMethodAroundExecution()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("Around advice is executing before");

        Object returnObject = joinPoint.proceed();

        System.out.println("Around advice is executing After");

        return returnObject;
    }


}
